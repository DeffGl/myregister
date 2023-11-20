package com.example.regservicebuilder.service.impl;

import com.example.regservicebuilder.model.District;
import com.example.regservicebuilder.service.base.DistrictLocalServiceBaseImpl;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.SystemException;

import java.util.List;

/**
 * The implementation of the district local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.example.regservicebuilder.service.DistrictLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.example.regservicebuilder.service.base.DistrictLocalServiceBaseImpl
 * @see com.example.regservicebuilder.service.DistrictLocalServiceUtil
 */
public class DistrictLocalServiceImpl extends DistrictLocalServiceBaseImpl {
    public List<District> findByArchive(String archived, int start, int end)
            throws SystemException {
        return this.districtPersistence.findByArchive(archived, start, end);
    }

    public List<District> findByArchive(String archived)
            throws SystemException {
        return this.districtPersistence.findByArchive(archived);
    }
}
