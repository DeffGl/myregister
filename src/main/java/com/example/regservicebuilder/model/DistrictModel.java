package com.example.regservicebuilder.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

/**
 * The base model interface for the District service. Represents a row in the &quot;Regs_District&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.example.regservicebuilder.model.impl.DistrictModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.example.regservicebuilder.model.impl.DistrictImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see District
 * @see com.example.regservicebuilder.model.impl.DistrictImpl
 * @see com.example.regservicebuilder.model.impl.DistrictModelImpl
 * @generated
 */
public interface DistrictModel extends BaseModel<District> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. All methods that expect a district model instance should use the {@link District} interface instead.
     */

    /**
     * Returns the primary key of this district.
     *
     * @return the primary key of this district
     */
    public long getPrimaryKey();

    /**
     * Sets the primary key of this district.
     *
     * @param primaryKey the primary key of this district
     */
    public void setPrimaryKey(long primaryKey);

    /**
     * Returns the district ID of this district.
     *
     * @return the district ID of this district
     */
    public long getDistrictId();

    /**
     * Sets the district ID of this district.
     *
     * @param districtId the district ID of this district
     */
    public void setDistrictId(long districtId);

    /**
     * Returns the name of this district.
     *
     * @return the name of this district
     */
    @AutoEscape
    public String getName();

    /**
     * Sets the name of this district.
     *
     * @param name the name of this district
     */
    public void setName(String name);

    /**
     * Returns the code of this district.
     *
     * @return the code of this district
     */
    @AutoEscape
    public String getCode();

    /**
     * Sets the code of this district.
     *
     * @param code the code of this district
     */
    public void setCode(String code);

    /**
     * Returns the archived of this district.
     *
     * @return the archived of this district
     */
    @AutoEscape
    public String getArchived();

    /**
     * Sets the archived of this district.
     *
     * @param archived the archived of this district
     */
    public void setArchived(String archived);

    @Override
    public boolean isNew();

    @Override
    public void setNew(boolean n);

    @Override
    public boolean isCachedModel();

    @Override
    public void setCachedModel(boolean cachedModel);

    @Override
    public boolean isEscapedModel();

    @Override
    public Serializable getPrimaryKeyObj();

    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj);

    @Override
    public ExpandoBridge getExpandoBridge();

    @Override
    public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

    @Override
    public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

    @Override
    public void setExpandoBridgeAttributes(ServiceContext serviceContext);

    @Override
    public Object clone();

    @Override
    public int compareTo(com.example.regservicebuilder.model.District district);

    @Override
    public int hashCode();

    @Override
    public CacheModel<com.example.regservicebuilder.model.District> toCacheModel();

    @Override
    public com.example.regservicebuilder.model.District toEscapedModel();

    @Override
    public com.example.regservicebuilder.model.District toUnescapedModel();

    @Override
    public String toString();

    @Override
    public String toXmlString();
}