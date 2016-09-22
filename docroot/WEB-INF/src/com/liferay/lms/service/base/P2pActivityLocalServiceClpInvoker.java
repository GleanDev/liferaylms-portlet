/**
 * Copyright (c) 2000-2012 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.lms.service.base;

import com.liferay.lms.service.P2pActivityLocalServiceUtil;

import java.util.Arrays;

/**
 * @author Brian Wing Shun Chan
 */
public class P2pActivityLocalServiceClpInvoker {
	public P2pActivityLocalServiceClpInvoker() {
		_methodName0 = "addP2pActivity";

		_methodParameterTypes0 = new String[] {
				"com.liferay.lms.model.P2pActivity"
			};

		_methodName1 = "createP2pActivity";

		_methodParameterTypes1 = new String[] { "long" };

		_methodName2 = "deleteP2pActivity";

		_methodParameterTypes2 = new String[] { "long" };

		_methodName3 = "deleteP2pActivity";

		_methodParameterTypes3 = new String[] {
				"com.liferay.lms.model.P2pActivity"
			};

		_methodName4 = "dynamicQuery";

		_methodParameterTypes4 = new String[] {  };

		_methodName5 = "dynamicQuery";

		_methodParameterTypes5 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery"
			};

		_methodName6 = "dynamicQuery";

		_methodParameterTypes6 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery", "int", "int"
			};

		_methodName7 = "dynamicQuery";

		_methodParameterTypes7 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery", "int", "int",
				"com.liferay.portal.kernel.util.OrderByComparator"
			};

		_methodName8 = "dynamicQueryCount";

		_methodParameterTypes8 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery"
			};

		_methodName9 = "fetchP2pActivity";

		_methodParameterTypes9 = new String[] { "long" };

		_methodName10 = "getP2pActivity";

		_methodParameterTypes10 = new String[] { "long" };

		_methodName11 = "getPersistedModel";

		_methodParameterTypes11 = new String[] { "java.io.Serializable" };

		_methodName12 = "getP2pActivities";

		_methodParameterTypes12 = new String[] { "int", "int" };

		_methodName13 = "getP2pActivitiesCount";

		_methodParameterTypes13 = new String[] {  };

		_methodName14 = "updateP2pActivity";

		_methodParameterTypes14 = new String[] {
				"com.liferay.lms.model.P2pActivity"
			};

		_methodName15 = "updateP2pActivity";

		_methodParameterTypes15 = new String[] {
				"com.liferay.lms.model.P2pActivity", "boolean"
			};

		_methodName144 = "getBeanIdentifier";

		_methodParameterTypes144 = new String[] {  };

		_methodName145 = "setBeanIdentifier";

		_methodParameterTypes145 = new String[] { "java.lang.String" };

		_methodName150 = "findByActIdAndUserId";

		_methodParameterTypes150 = new String[] { "long", "long" };

		_methodName151 = "existP2pAct";

		_methodParameterTypes151 = new String[] { "long", "long" };

		_methodName152 = "findByActId";

		_methodParameterTypes152 = new String[] { "long" };

		_methodName153 = "findByActId";

		_methodParameterTypes153 = new String[] { "long", "int", "int" };

		_methodName154 = "countByActId";

		_methodParameterTypes154 = new String[] { "long" };

		_methodName155 = "findByActIdOrderByP2pId";

		_methodParameterTypes155 = new String[] { "long" };

		_methodName156 = "getUsersToCorrectP2P";

		_methodParameterTypes156 = new String[] {
				"long", "long", "int", "java.util.Calendar"
			};

		_methodName157 = "getP2pActivitiesToCorrect";

		_methodParameterTypes157 = new String[] { "long", "long", "int" };

		_methodName158 = "findByUserId";

		_methodParameterTypes158 = new String[] { "long" };

		_methodName159 = "getP2PActivitiesInDay";

		_methodParameterTypes159 = new String[] { "java.util.Calendar" };

		_methodName160 = "getNumCorrectsByDayP2P";

		_methodParameterTypes160 = new String[] { "long", "java.util.Calendar" };

		_methodName161 = "addP2pActivity";

		_methodParameterTypes161 = new String[] {
				"com.liferay.lms.model.P2pActivity"
			};

		_methodName162 = "updateP2pActivity";

		_methodParameterTypes162 = new String[] {
				"com.liferay.lms.model.P2pActivity"
			};
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName0.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes0, parameterTypes)) {
			return P2pActivityLocalServiceUtil.addP2pActivity((com.liferay.lms.model.P2pActivity)arguments[0]);
		}

		if (_methodName1.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes1, parameterTypes)) {
			return P2pActivityLocalServiceUtil.createP2pActivity(((Long)arguments[0]).longValue());
		}

		if (_methodName2.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes2, parameterTypes)) {
			return P2pActivityLocalServiceUtil.deleteP2pActivity(((Long)arguments[0]).longValue());
		}

		if (_methodName3.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes3, parameterTypes)) {
			return P2pActivityLocalServiceUtil.deleteP2pActivity((com.liferay.lms.model.P2pActivity)arguments[0]);
		}

		if (_methodName4.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes4, parameterTypes)) {
			return P2pActivityLocalServiceUtil.dynamicQuery();
		}

		if (_methodName5.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes5, parameterTypes)) {
			return P2pActivityLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName6.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes6, parameterTypes)) {
			return P2pActivityLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName7.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes7, parameterTypes)) {
			return P2pActivityLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[3]);
		}

		if (_methodName8.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes8, parameterTypes)) {
			return P2pActivityLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName9.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes9, parameterTypes)) {
			return P2pActivityLocalServiceUtil.fetchP2pActivity(((Long)arguments[0]).longValue());
		}

		if (_methodName10.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes10, parameterTypes)) {
			return P2pActivityLocalServiceUtil.getP2pActivity(((Long)arguments[0]).longValue());
		}

		if (_methodName11.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes11, parameterTypes)) {
			return P2pActivityLocalServiceUtil.getPersistedModel((java.io.Serializable)arguments[0]);
		}

		if (_methodName12.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes12, parameterTypes)) {
			return P2pActivityLocalServiceUtil.getP2pActivities(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName13.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes13, parameterTypes)) {
			return P2pActivityLocalServiceUtil.getP2pActivitiesCount();
		}

		if (_methodName14.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
			return P2pActivityLocalServiceUtil.updateP2pActivity((com.liferay.lms.model.P2pActivity)arguments[0]);
		}

		if (_methodName15.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
			return P2pActivityLocalServiceUtil.updateP2pActivity((com.liferay.lms.model.P2pActivity)arguments[0],
				((Boolean)arguments[1]).booleanValue());
		}

		if (_methodName144.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes144, parameterTypes)) {
			return P2pActivityLocalServiceUtil.getBeanIdentifier();
		}

		if (_methodName145.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes145, parameterTypes)) {
			P2pActivityLocalServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);
		}

		if (_methodName150.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes150, parameterTypes)) {
			return P2pActivityLocalServiceUtil.findByActIdAndUserId(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());
		}

		if (_methodName151.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes151, parameterTypes)) {
			return P2pActivityLocalServiceUtil.existP2pAct(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());
		}

		if (_methodName152.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes152, parameterTypes)) {
			return P2pActivityLocalServiceUtil.findByActId(((Long)arguments[0]).longValue());
		}

		if (_methodName153.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes153, parameterTypes)) {
			return P2pActivityLocalServiceUtil.findByActId(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName154.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes154, parameterTypes)) {
			return P2pActivityLocalServiceUtil.countByActId(((Long)arguments[0]).longValue());
		}

		if (_methodName155.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes155, parameterTypes)) {
			return P2pActivityLocalServiceUtil.findByActIdOrderByP2pId(((Long)arguments[0]).longValue());
		}

		if (_methodName156.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes156, parameterTypes)) {
			return P2pActivityLocalServiceUtil.getUsersToCorrectP2P(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Integer)arguments[2]).intValue(),
				(java.util.Calendar)arguments[3]);
		}

		if (_methodName157.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes157, parameterTypes)) {
			return P2pActivityLocalServiceUtil.getP2pActivitiesToCorrect(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName158.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes158, parameterTypes)) {
			return P2pActivityLocalServiceUtil.findByUserId(((Long)arguments[0]).longValue());
		}

		if (_methodName159.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes159, parameterTypes)) {
			return P2pActivityLocalServiceUtil.getP2PActivitiesInDay((java.util.Calendar)arguments[0]);
		}

		if (_methodName160.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes160, parameterTypes)) {
			return P2pActivityLocalServiceUtil.getNumCorrectsByDayP2P(((Long)arguments[0]).longValue(),
				(java.util.Calendar)arguments[1]);
		}

		if (_methodName161.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes161, parameterTypes)) {
			return P2pActivityLocalServiceUtil.addP2pActivity((com.liferay.lms.model.P2pActivity)arguments[0]);
		}

		if (_methodName162.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes162, parameterTypes)) {
			return P2pActivityLocalServiceUtil.updateP2pActivity((com.liferay.lms.model.P2pActivity)arguments[0]);
		}

		throw new UnsupportedOperationException();
	}

	private String _methodName0;
	private String[] _methodParameterTypes0;
	private String _methodName1;
	private String[] _methodParameterTypes1;
	private String _methodName2;
	private String[] _methodParameterTypes2;
	private String _methodName3;
	private String[] _methodParameterTypes3;
	private String _methodName4;
	private String[] _methodParameterTypes4;
	private String _methodName5;
	private String[] _methodParameterTypes5;
	private String _methodName6;
	private String[] _methodParameterTypes6;
	private String _methodName7;
	private String[] _methodParameterTypes7;
	private String _methodName8;
	private String[] _methodParameterTypes8;
	private String _methodName9;
	private String[] _methodParameterTypes9;
	private String _methodName10;
	private String[] _methodParameterTypes10;
	private String _methodName11;
	private String[] _methodParameterTypes11;
	private String _methodName12;
	private String[] _methodParameterTypes12;
	private String _methodName13;
	private String[] _methodParameterTypes13;
	private String _methodName14;
	private String[] _methodParameterTypes14;
	private String _methodName15;
	private String[] _methodParameterTypes15;
	private String _methodName144;
	private String[] _methodParameterTypes144;
	private String _methodName145;
	private String[] _methodParameterTypes145;
	private String _methodName150;
	private String[] _methodParameterTypes150;
	private String _methodName151;
	private String[] _methodParameterTypes151;
	private String _methodName152;
	private String[] _methodParameterTypes152;
	private String _methodName153;
	private String[] _methodParameterTypes153;
	private String _methodName154;
	private String[] _methodParameterTypes154;
	private String _methodName155;
	private String[] _methodParameterTypes155;
	private String _methodName156;
	private String[] _methodParameterTypes156;
	private String _methodName157;
	private String[] _methodParameterTypes157;
	private String _methodName158;
	private String[] _methodParameterTypes158;
	private String _methodName159;
	private String[] _methodParameterTypes159;
	private String _methodName160;
	private String[] _methodParameterTypes160;
	private String _methodName161;
	private String[] _methodParameterTypes161;
	private String _methodName162;
	private String[] _methodParameterTypes162;
}