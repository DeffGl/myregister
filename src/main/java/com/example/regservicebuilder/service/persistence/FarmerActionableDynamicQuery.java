package com.example.regservicebuilder.service.persistence;

import com.example.regservicebuilder.model.Farmer;
import com.example.regservicebuilder.service.FarmerLocalServiceUtil;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public abstract class FarmerActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public FarmerActionableDynamicQuery() throws SystemException {
        setBaseLocalService(FarmerLocalServiceUtil.getService());
        setClass(Farmer.class);

        setClassLoader(com.example.regservicebuilder.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("farmerId");
    }
}
