package com.example.regservicebuilder.model.impl;

import com.example.regservicebuilder.model.Farmer;
import com.example.regservicebuilder.service.FarmerLocalServiceUtil;

import com.liferay.portal.kernel.exception.SystemException;

/**
 * The extended model base implementation for the Farmer service. Represents a row in the &quot;Regs_Farmer&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link FarmerImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FarmerImpl
 * @see com.example.regservicebuilder.model.Farmer
 * @generated
 */
public abstract class FarmerBaseImpl extends FarmerModelImpl implements Farmer {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. All methods that expect a farmer model instance should use the {@link Farmer} interface instead.
     */
    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            FarmerLocalServiceUtil.addFarmer(this);
        } else {
            FarmerLocalServiceUtil.updateFarmer(this);
        }
    }
}
