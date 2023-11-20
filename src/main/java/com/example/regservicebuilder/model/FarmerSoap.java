package com.example.regservicebuilder.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.example.regservicebuilder.service.http.FarmerServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.example.regservicebuilder.service.http.FarmerServiceSoap
 * @generated
 */
public class FarmerSoap implements Serializable {
    private long _farmerId;
    private String _organizationName;
    private String _legalForm;
    private String _inn;
    private String _kpp;
    private String _ogrn;
    private long _districtId;
    private Date _registrationDate;
    private String _archived;

    public FarmerSoap() {
    }

    public static FarmerSoap toSoapModel(Farmer model) {
        FarmerSoap soapModel = new FarmerSoap();

        soapModel.setFarmerId(model.getFarmerId());
        soapModel.setOrganizationName(model.getOrganizationName());
        soapModel.setLegalForm(model.getLegalForm());
        soapModel.setInn(model.getInn());
        soapModel.setKpp(model.getKpp());
        soapModel.setOgrn(model.getOgrn());
        soapModel.setDistrictId(model.getDistrictId());
        soapModel.setRegistrationDate(model.getRegistrationDate());
        soapModel.setArchived(model.getArchived());

        return soapModel;
    }

    public static FarmerSoap[] toSoapModels(Farmer[] models) {
        FarmerSoap[] soapModels = new FarmerSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static FarmerSoap[][] toSoapModels(Farmer[][] models) {
        FarmerSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new FarmerSoap[models.length][models[0].length];
        } else {
            soapModels = new FarmerSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static FarmerSoap[] toSoapModels(List<Farmer> models) {
        List<FarmerSoap> soapModels = new ArrayList<FarmerSoap>(models.size());

        for (Farmer model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new FarmerSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _farmerId;
    }

    public void setPrimaryKey(long pk) {
        setFarmerId(pk);
    }

    public long getFarmerId() {
        return _farmerId;
    }

    public void setFarmerId(long farmerId) {
        _farmerId = farmerId;
    }

    public String getOrganizationName() {
        return _organizationName;
    }

    public void setOrganizationName(String organizationName) {
        _organizationName = organizationName;
    }

    public String getLegalForm() {
        return _legalForm;
    }

    public void setLegalForm(String legalForm) {
        _legalForm = legalForm;
    }

    public String getInn() {
        return _inn;
    }

    public void setInn(String inn) {
        _inn = inn;
    }

    public String getKpp() {
        return _kpp;
    }

    public void setKpp(String kpp) {
        _kpp = kpp;
    }

    public String getOgrn() {
        return _ogrn;
    }

    public void setOgrn(String ogrn) {
        _ogrn = ogrn;
    }

    public long getDistrictId() {
        return _districtId;
    }

    public void setDistrictId(long districtId) {
        _districtId = districtId;
    }

    public Date getRegistrationDate() {
        return _registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        _registrationDate = registrationDate;
    }

    public String getArchived() {
        return _archived;
    }

    public void setArchived(String archived) {
        _archived = archived;
    }
}
