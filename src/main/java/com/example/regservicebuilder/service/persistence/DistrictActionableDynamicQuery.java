package com.example.regservicebuilder.service.persistence;

import com.example.regservicebuilder.model.District;
import com.example.regservicebuilder.service.DistrictLocalServiceUtil;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public abstract class DistrictActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public DistrictActionableDynamicQuery() throws SystemException {
        setBaseLocalService(DistrictLocalServiceUtil.getService());
        setClass(District.class);

        setClassLoader(com.example.regservicebuilder.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("districtId");
    }
}
