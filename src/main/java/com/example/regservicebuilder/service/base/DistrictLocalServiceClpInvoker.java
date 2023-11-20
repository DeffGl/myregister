package com.example.regservicebuilder.service.base;

import com.example.regservicebuilder.service.DistrictLocalServiceUtil;

import java.util.Arrays;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public class DistrictLocalServiceClpInvoker {
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
    private String _methodName16;
    private String[] _methodParameterTypes16;
    private String _methodName17;
    private String[] _methodParameterTypes17;
    private String _methodName18;
    private String[] _methodParameterTypes18;
    private String _methodName19;
    private String[] _methodParameterTypes19;
    private String _methodName20;
    private String[] _methodParameterTypes20;
    private String _methodName21;
    private String[] _methodParameterTypes21;
    private String _methodName22;
    private String[] _methodParameterTypes22;
    private String _methodName23;
    private String[] _methodParameterTypes23;
    private String _methodName24;
    private String[] _methodParameterTypes24;
    private String _methodName25;
    private String[] _methodParameterTypes25;
    private String _methodName26;
    private String[] _methodParameterTypes26;
    private String _methodName27;
    private String[] _methodParameterTypes27;
    private String _methodName28;
    private String[] _methodParameterTypes28;
    private String _methodName29;
    private String[] _methodParameterTypes29;
    private String _methodName30;
    private String[] _methodParameterTypes30;
    private String _methodName31;
    private String[] _methodParameterTypes31;
    private String _methodName56;
    private String[] _methodParameterTypes56;
    private String _methodName57;
    private String[] _methodParameterTypes57;
    private String _methodName62;
    private String[] _methodParameterTypes62;
    private String _methodName63;
    private String[] _methodParameterTypes63;

    public DistrictLocalServiceClpInvoker() {
        _methodName0 = "addDistrict";

        _methodParameterTypes0 = new String[] {
                "com.example.regservicebuilder.model.District"
            };

        _methodName1 = "createDistrict";

        _methodParameterTypes1 = new String[] { "long" };

        _methodName2 = "deleteDistrict";

        _methodParameterTypes2 = new String[] { "long" };

        _methodName3 = "deleteDistrict";

        _methodParameterTypes3 = new String[] {
                "com.example.regservicebuilder.model.District"
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

        _methodName9 = "dynamicQueryCount";

        _methodParameterTypes9 = new String[] {
                "com.liferay.portal.kernel.dao.orm.DynamicQuery",
                "com.liferay.portal.kernel.dao.orm.Projection"
            };

        _methodName10 = "fetchDistrict";

        _methodParameterTypes10 = new String[] { "long" };

        _methodName11 = "getDistrict";

        _methodParameterTypes11 = new String[] { "long" };

        _methodName12 = "getPersistedModel";

        _methodParameterTypes12 = new String[] { "java.io.Serializable" };

        _methodName13 = "getDistricts";

        _methodParameterTypes13 = new String[] { "int", "int" };

        _methodName14 = "getDistrictsCount";

        _methodParameterTypes14 = new String[] {  };

        _methodName15 = "updateDistrict";

        _methodParameterTypes15 = new String[] {
                "com.example.regservicebuilder.model.District"
            };

        _methodName16 = "addFarmerDistrict";

        _methodParameterTypes16 = new String[] { "long", "long" };

        _methodName17 = "addFarmerDistrict";

        _methodParameterTypes17 = new String[] {
                "long", "com.example.regservicebuilder.model.District"
            };

        _methodName18 = "addFarmerDistricts";

        _methodParameterTypes18 = new String[] { "long", "long[][]" };

        _methodName19 = "addFarmerDistricts";

        _methodParameterTypes19 = new String[] { "long", "java.util.List" };

        _methodName20 = "clearFarmerDistricts";

        _methodParameterTypes20 = new String[] { "long" };

        _methodName21 = "deleteFarmerDistrict";

        _methodParameterTypes21 = new String[] { "long", "long" };

        _methodName22 = "deleteFarmerDistrict";

        _methodParameterTypes22 = new String[] {
                "long", "com.example.regservicebuilder.model.District"
            };

        _methodName23 = "deleteFarmerDistricts";

        _methodParameterTypes23 = new String[] { "long", "long[][]" };

        _methodName24 = "deleteFarmerDistricts";

        _methodParameterTypes24 = new String[] { "long", "java.util.List" };

        _methodName25 = "getFarmerDistricts";

        _methodParameterTypes25 = new String[] { "long" };

        _methodName26 = "getFarmerDistricts";

        _methodParameterTypes26 = new String[] { "long", "int", "int" };

        _methodName27 = "getFarmerDistricts";

        _methodParameterTypes27 = new String[] {
                "long", "int", "int",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };

        _methodName28 = "getFarmerDistrictsCount";

        _methodParameterTypes28 = new String[] { "long" };

        _methodName29 = "hasFarmerDistrict";

        _methodParameterTypes29 = new String[] { "long", "long" };

        _methodName30 = "hasFarmerDistricts";

        _methodParameterTypes30 = new String[] { "long" };

        _methodName31 = "setFarmerDistricts";

        _methodParameterTypes31 = new String[] { "long", "long[][]" };

        _methodName56 = "getBeanIdentifier";

        _methodParameterTypes56 = new String[] {  };

        _methodName57 = "setBeanIdentifier";

        _methodParameterTypes57 = new String[] { "java.lang.String" };

        _methodName62 = "findByArchive";

        _methodParameterTypes62 = new String[] { "java.lang.String", "int", "int" };

        _methodName63 = "findByArchive";

        _methodParameterTypes63 = new String[] { "java.lang.String" };
    }

    public Object invokeMethod(String name, String[] parameterTypes,
        Object[] arguments) throws Throwable {
        if (_methodName0.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes0, parameterTypes)) {
            return DistrictLocalServiceUtil.addDistrict((com.example.regservicebuilder.model.District) arguments[0]);
        }

        if (_methodName1.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes1, parameterTypes)) {
            return DistrictLocalServiceUtil.createDistrict(((Long) arguments[0]).longValue());
        }

        if (_methodName2.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes2, parameterTypes)) {
            return DistrictLocalServiceUtil.deleteDistrict(((Long) arguments[0]).longValue());
        }

        if (_methodName3.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes3, parameterTypes)) {
            return DistrictLocalServiceUtil.deleteDistrict((com.example.regservicebuilder.model.District) arguments[0]);
        }

        if (_methodName4.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes4, parameterTypes)) {
            return DistrictLocalServiceUtil.dynamicQuery();
        }

        if (_methodName5.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes5, parameterTypes)) {
            return DistrictLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0]);
        }

        if (_methodName6.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes6, parameterTypes)) {
            return DistrictLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0],
                ((Integer) arguments[1]).intValue(),
                ((Integer) arguments[2]).intValue());
        }

        if (_methodName7.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes7, parameterTypes)) {
            return DistrictLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0],
                ((Integer) arguments[1]).intValue(),
                ((Integer) arguments[2]).intValue(),
                (com.liferay.portal.kernel.util.OrderByComparator) arguments[3]);
        }

        if (_methodName8.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes8, parameterTypes)) {
            return DistrictLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0]);
        }

        if (_methodName9.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes9, parameterTypes)) {
            return DistrictLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0],
                (com.liferay.portal.kernel.dao.orm.Projection) arguments[1]);
        }

        if (_methodName10.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes10, parameterTypes)) {
            return DistrictLocalServiceUtil.fetchDistrict(((Long) arguments[0]).longValue());
        }

        if (_methodName11.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes11, parameterTypes)) {
            return DistrictLocalServiceUtil.getDistrict(((Long) arguments[0]).longValue());
        }

        if (_methodName12.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes12, parameterTypes)) {
            return DistrictLocalServiceUtil.getPersistedModel((java.io.Serializable) arguments[0]);
        }

        if (_methodName13.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes13, parameterTypes)) {
            return DistrictLocalServiceUtil.getDistricts(((Integer) arguments[0]).intValue(),
                ((Integer) arguments[1]).intValue());
        }

        if (_methodName14.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
            return DistrictLocalServiceUtil.getDistrictsCount();
        }

        if (_methodName15.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
            return DistrictLocalServiceUtil.updateDistrict((com.example.regservicebuilder.model.District) arguments[0]);
        }

        if (_methodName16.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes16, parameterTypes)) {
            DistrictLocalServiceUtil.addFarmerDistrict(((Long) arguments[0]).longValue(),
                ((Long) arguments[1]).longValue());

            return null;
        }

        if (_methodName17.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes17, parameterTypes)) {
            DistrictLocalServiceUtil.addFarmerDistrict(((Long) arguments[0]).longValue(),
                (com.example.regservicebuilder.model.District) arguments[1]);

            return null;
        }

        if (_methodName18.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes18, parameterTypes)) {
            DistrictLocalServiceUtil.addFarmerDistricts(((Long) arguments[0]).longValue(),
                (long[]) arguments[1]);

            return null;
        }

        if (_methodName19.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes19, parameterTypes)) {
            DistrictLocalServiceUtil.addFarmerDistricts(((Long) arguments[0]).longValue(),
                (java.util.List<com.example.regservicebuilder.model.District>) arguments[1]);

            return null;
        }

        if (_methodName20.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes20, parameterTypes)) {
            DistrictLocalServiceUtil.clearFarmerDistricts(((Long) arguments[0]).longValue());

            return null;
        }

        if (_methodName21.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes21, parameterTypes)) {
            DistrictLocalServiceUtil.deleteFarmerDistrict(((Long) arguments[0]).longValue(),
                ((Long) arguments[1]).longValue());

            return null;
        }

        if (_methodName22.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes22, parameterTypes)) {
            DistrictLocalServiceUtil.deleteFarmerDistrict(((Long) arguments[0]).longValue(),
                (com.example.regservicebuilder.model.District) arguments[1]);

            return null;
        }

        if (_methodName23.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes23, parameterTypes)) {
            DistrictLocalServiceUtil.deleteFarmerDistricts(((Long) arguments[0]).longValue(),
                (long[]) arguments[1]);

            return null;
        }

        if (_methodName24.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes24, parameterTypes)) {
            DistrictLocalServiceUtil.deleteFarmerDistricts(((Long) arguments[0]).longValue(),
                (java.util.List<com.example.regservicebuilder.model.District>) arguments[1]);

            return null;
        }

        if (_methodName25.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes25, parameterTypes)) {
            return DistrictLocalServiceUtil.getFarmerDistricts(((Long) arguments[0]).longValue());
        }

        if (_methodName26.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes26, parameterTypes)) {
            return DistrictLocalServiceUtil.getFarmerDistricts(((Long) arguments[0]).longValue(),
                ((Integer) arguments[1]).intValue(),
                ((Integer) arguments[2]).intValue());
        }

        if (_methodName27.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes27, parameterTypes)) {
            return DistrictLocalServiceUtil.getFarmerDistricts(((Long) arguments[0]).longValue(),
                ((Integer) arguments[1]).intValue(),
                ((Integer) arguments[2]).intValue(),
                (com.liferay.portal.kernel.util.OrderByComparator) arguments[3]);
        }

        if (_methodName28.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes28, parameterTypes)) {
            return DistrictLocalServiceUtil.getFarmerDistrictsCount(((Long) arguments[0]).longValue());
        }

        if (_methodName29.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes29, parameterTypes)) {
            return DistrictLocalServiceUtil.hasFarmerDistrict(((Long) arguments[0]).longValue(),
                ((Long) arguments[1]).longValue());
        }

        if (_methodName30.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes30, parameterTypes)) {
            return DistrictLocalServiceUtil.hasFarmerDistricts(((Long) arguments[0]).longValue());
        }

        if (_methodName31.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes31, parameterTypes)) {
            DistrictLocalServiceUtil.setFarmerDistricts(((Long) arguments[0]).longValue(),
                (long[]) arguments[1]);

            return null;
        }

        if (_methodName56.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes56, parameterTypes)) {
            return DistrictLocalServiceUtil.getBeanIdentifier();
        }

        if (_methodName57.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes57, parameterTypes)) {
            DistrictLocalServiceUtil.setBeanIdentifier((java.lang.String) arguments[0]);

            return null;
        }

        if (_methodName62.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes62, parameterTypes)) {
            return DistrictLocalServiceUtil.findByArchive((java.lang.String) arguments[0],
                ((Integer) arguments[1]).intValue(),
                ((Integer) arguments[2]).intValue());
        }

        if (_methodName63.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes63, parameterTypes)) {
            return DistrictLocalServiceUtil.findByArchive((java.lang.String) arguments[0]);
        }

        throw new UnsupportedOperationException();
    }
}
