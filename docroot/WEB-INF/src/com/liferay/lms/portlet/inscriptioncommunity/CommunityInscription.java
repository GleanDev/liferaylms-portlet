package com.liferay.lms.portlet.inscriptioncommunity;

import java.util.List;

import javax.mail.internet.InternetAddress;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.ProcessAction;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.lms.course.inscriptiontype.InscriptionType;
import com.liferay.lms.course.inscriptiontype.InscriptionTypeRegistry;
import com.liferay.lms.model.Course;
import com.liferay.lms.service.CourseLocalServiceUtil;
import com.liferay.mail.service.MailServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.mail.MailMessage;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PrefsPropsUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.GroupConstants;
import com.liferay.portal.model.User;
import com.liferay.portal.security.permission.ActionKeys;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.portal.security.permission.PermissionCheckerFactoryUtil;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.service.MembershipRequestLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portlet.social.service.SocialActivityLocalServiceUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;


/** Portlet implementation class CommunityInscription */
public class CommunityInscription extends MVCPortlet {
	private static Log log = LogFactoryUtil.getLog(CommunityInscription.class);

	@ProcessAction(name = "member")
	public void member(ActionRequest request, ActionResponse response) throws SystemException{
		ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);
		Group group = null;
		Course course = null;
		int numberUsers = 0;
		try {
			group = GroupLocalServiceUtil.getGroup(themeDisplay.getScopeGroupId());
			course = CourseLocalServiceUtil.getCourseByGroupCreatedId(themeDisplay.getScopeGroupId());
			numberUsers = UserLocalServiceUtil.getGroupUsersCount(themeDisplay.getScopeGroupId());
		} catch (PortalException e) {
			if(log.isDebugEnabled()){
				e.printStackTrace();
			}
			
		} catch (SystemException e) {
			if(log.isDebugEnabled()){
				e.printStackTrace();
			}
		}
    	
    	if(group.getType()!=GroupConstants.TYPE_SITE_RESTRICTED){ 
    		if(log.isDebugEnabled()){
    			log.debug("Site not restricted!");
    		}
    		throw new SystemException("Site not restricted!");
    	}
    	
    	if(course.getMaxusers()>0&&numberUsers>=course.getMaxusers()){
    		if(log.isDebugEnabled()){
    			log.debug("Maxusers!"); 
    		}
    		throw new SystemException("Maxusers!");
    	}
    	

		try {
			long teamId = ParamUtil.getLong(request, "teamId",0);
	    	ServiceContext serviceContext=ServiceContextFactory.getInstance(request);
	    	MembershipRequestLocalServiceUtil.addMembershipRequest(themeDisplay.getUserId(), themeDisplay.getScopeGroupId(), "Enroll petition", serviceContext);
	    	SocialActivityLocalServiceUtil.addActivity(themeDisplay.getUserId(), course.getGroupId(), Course.class.getName(), course.getCourseId(), com.liferay.portlet.social.model.SocialActivityConstants.TYPE_SUBSCRIBE, "", course.getUserId());

	    	if(teamId>0){
    			long[] userIds = new long[1];
    			userIds[0] = themeDisplay.getUserId();	
    			if(!UserLocalServiceUtil.hasTeamUser(teamId, themeDisplay.getUserId())){
    				UserLocalServiceUtil.addTeamUsers(teamId, userIds);	
    			}			
    		}
			
			List<User> allUsers = UserLocalServiceUtil.getGroupUsers(course.getGroupCreatedId());
			
			for(User userTmp : allUsers){
				PermissionChecker permissionChecker;
				try {
					permissionChecker = PermissionCheckerFactoryUtil.create(userTmp);
					if(log.isDebugEnabled())log.debug(userTmp.getFullName());
					if(permissionChecker.hasPermission(course.getGroupCreatedId(),Course.class.getName(),course.getCourseId(),ActionKeys.ASSIGN_MEMBERS)){
						if(log.isDebugEnabled())log.debug(userTmp.getFullName());

				    	String fromName = PrefsPropsUtil.getString(themeDisplay.getCompanyId(),
								PropsKeys.ADMIN_EMAIL_FROM_NAME);
						String fromAddress = PrefsPropsUtil.getString(themeDisplay.getCompanyId(),
								PropsKeys.ADMIN_EMAIL_FROM_ADDRESS);
						
						InternetAddress from = new InternetAddress(fromAddress, fromName);

				    	String url = themeDisplay.getURLPortal();
				    	String urlcourse = themeDisplay.getURLPortal()+"/web"+course.getFriendlyURL(); 

				    	String emailTo = userTmp.getEmailAddress();
				    	String nameTo = userTmp.getFullName();
				    	InternetAddress to = new InternetAddress(emailTo, nameTo);
						
						String subject = LanguageUtil.format(userTmp.getLocale(),"reply-membership-request-for-x", new String[]{course.getTitle(userTmp.getLocale())});
				    	String body = StringUtil.replace(
				    			LanguageUtil.get(userTmp.getLocale(), "reply-membership-body"),
				    			new String[] {"[$FROM_ADDRESS$]", "[$FROM_NAME$]", "[$PAGE_URL$]","[$PORTAL_URL$]","[$TO_ADDRESS$]","[$TO_NAME$]","[$COURSE_NAME$]"},
				    			new String[] {fromAddress, fromName, urlcourse, url, emailTo, nameTo,course.getTitle(userTmp.getLocale())});
				    	try{
							if(log.isDebugEnabled()){
								log.debug(from);
								log.debug(to);
								log.debug(subject);
								log.debug(body);
							}
							MailMessage mailm = new MailMessage(from, to, subject, body, true);
							MailServiceUtil.sendEmail(mailm);
						}
						catch(Exception ex)
						{
							ex.printStackTrace();
						}
						
					}
				} catch (Exception e) {
					if(log.isDebugEnabled())e.printStackTrace();
					if(log.isErrorEnabled())log.error(e.getMessage());
				}
			}
			
		} catch (PortalException e) {
			if(log.isDebugEnabled()){
				e.printStackTrace();
			}
			
		}catch (SystemException e) {
			if(log.isDebugEnabled()){
				e.printStackTrace();
			}
		}
	}
	
	@ProcessAction(name = "inscribir") 
	public void inscribir(ActionRequest request, ActionResponse response) throws Exception{

		ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);
		if (!themeDisplay.isSignedIn()) {return;}

		long teamId = ParamUtil.getLong(request, "teamId",0);
		long groupId = themeDisplay.getScopeGroupId();	
    	
    	Course course = CourseLocalServiceUtil.getCourseByGroupCreatedId(groupId);
    	
    	log.debug("COURSE GROUP ID "+course.getGroupCreatedId());
    	log.debug("THEME DISPLAY GROUP "+groupId);
    	long userId = themeDisplay.getUserId();
    	
    	ServiceContext serviceContext=ServiceContextFactory.getInstance(request);
    	
    	InscriptionType inscriptionType = new InscriptionTypeRegistry().getInscriptionType(course.getInscriptionType());
    	
    	String result = inscriptionType.enrollUser(course.getCourseId(), userId, teamId, serviceContext);
    	
    	if(!result.equalsIgnoreCase("ok")){
    		if(result.equalsIgnoreCase("error-complete-course")){
    			SessionErrors.add(request, "inscription-error-max-users");
    		}else if(result.equalsIgnoreCase("error-private-course")){
    			SessionErrors.add(request, "inscription-error-syte-restricted");
    		}else if(result.equalsIgnoreCase("error-user-suscribed")){
    			SessionErrors.add(request, "inscription-error-already-enrolled");
    		}else{
    			SessionErrors.add(request, "inscription-error");
    		}
    	}
    }
	
	public void desinscribir(ActionRequest request, ActionResponse response) throws Exception{

		ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);
		if (!themeDisplay.isSignedIn()) {return;}

		long[] groupId = new long[1];
    	groupId[0] = themeDisplay.getScopeGroupId();						
		long userId = themeDisplay.getUserId();
		
		Course course = CourseLocalServiceUtil.getCourseByGroupCreatedId(groupId[0]);

		InscriptionType inscriptionType = new InscriptionTypeRegistry().getInscriptionType(course.getInscriptionType());
		

		boolean result = inscriptionType.unsubscribeUser(course, userId);

		if(!result){
			SessionErrors.add(request, "inscription-error-already-disenrolled");
		}
	}

}
