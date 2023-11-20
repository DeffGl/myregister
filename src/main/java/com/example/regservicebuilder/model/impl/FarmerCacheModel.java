package com.example.regservicebuilder.model.impl;

import com.example.regservicebuilder.model.Farmer;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Farmer in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see Farmer
 * @generated
 */
public class FarmerCacheModel implements CacheModel<Farmer>, Externalizable {
    public long farmerId;
    public String organizationName;
    public String legalForm;
    public String inn;
    public String kpp;
    public String ogrn;
    public long districtId;
    public long registrationDate;
    public String archived;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(19);

        sb.append("{farmerId=");
        sb.append(farmerId);
        sb.append(", organizationName=");
        sb.append(organizationName);
        sb.append(", legalForm=");
        sb.append(legalForm);
        sb.append(", inn=");
        sb.append(inn);
        sb.append(", kpp=");
        sb.append(kpp);
        sb.append(", ogrn=");
        sb.append(ogrn);
        sb.append(", districtId=");
        sb.append(districtId);
        sb.append(", registrationDate=");
        sb.append(registrationDate);
        sb.append(", archived=");
        sb.append(archived);
        sb.append("}");

        return sb.toString();
    }

    @Override
    public Farmer toEntityModel() {
        FarmerImpl farmerImpl = new FarmerImpl();

        farmerImpl.setFarmerId(farmerId);

        if (organizationName == null) {
            farmerImpl.setOrganizationName(StringPool.BLANK);
        } else {
            farmerImpl.setOrganizationName(organizationName);
        }

        if (legalForm == null) {
            farmerImpl.setLegalForm(StringPool.BLANK);
        } else {
            farmerImpl.setLegalForm(legalForm);
        }

        if (inn == null) {
            farmerImpl.setInn(StringPool.BLANK);
        } else {
            farmerImpl.setInn(inn);
        }

        if (kpp == null) {
            farmerImpl.setKpp(StringPool.BLANK);
        } else {
            farmerImpl.setKpp(kpp);
        }

        if (ogrn == null) {
            farmerImpl.setOgrn(StringPool.BLANK);
        } else {
            farmerImpl.setOgrn(ogrn);
        }

        farmerImpl.setDistrictId(districtId);

        if (registrationDate == Long.MIN_VALUE) {
            farmerImpl.setRegistrationDate(null);
        } else {
            farmerImpl.setRegistrationDate(new Date(registrationDate));
        }

        if (archived == null) {
            farmerImpl.setArchived(StringPool.BLANK);
        } else {
            farmerImpl.setArchived(archived);
        }

        farmerImpl.resetOriginalValues();

        return farmerImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        farmerId = objectInput.readLong();
        organizationName = objectInput.readUTF();
        legalForm = objectInput.readUTF();
        inn = objectInput.readUTF();
        kpp = objectInput.readUTF();
        ogrn = objectInput.readUTF();
        districtId = objectInput.readLong();
        registrationDate = objectInput.readLong();
        archived = objectInput.readUTF();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput)
        throws IOException {
        objectOutput.writeLong(farmerId);

        if (organizationName == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(organizationName);
        }

        if (legalForm == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(legalForm);
        }

        if (inn == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(inn);
        }

        if (kpp == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(kpp);
        }

        if (ogrn == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(ogrn);
        }

        objectOutput.writeLong(districtId);
        objectOutput.writeLong(registrationDate);

        if (archived == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(archived);
        }
    }
}
