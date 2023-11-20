package com.example.regservicebuilder.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.example.regservicebuilder.service.http.DistrictServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.example.regservicebuilder.service.http.DistrictServiceSoap
 * @generated
 */
public class DistrictSoap implements Serializable {
    private long _districtId;
    private String _name;
    private String _code;
    private String _archived;

    public DistrictSoap() {
    }

    public static DistrictSoap toSoapModel(District model) {
        DistrictSoap soapModel = new DistrictSoap();

        soapModel.setDistrictId(model.getDistrictId());
        soapModel.setName(model.getName());
        soapModel.setCode(model.getCode());
        soapModel.setArchived(model.getArchived());

        return soapModel;
    }

    public static DistrictSoap[] toSoapModels(District[] models) {
        DistrictSoap[] soapModels = new DistrictSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static DistrictSoap[][] toSoapModels(District[][] models) {
        DistrictSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new DistrictSoap[models.length][models[0].length];
        } else {
            soapModels = new DistrictSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static DistrictSoap[] toSoapModels(List<District> models) {
        List<DistrictSoap> soapModels = new ArrayList<DistrictSoap>(models.size());

        for (District model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new DistrictSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _districtId;
    }

    public void setPrimaryKey(long pk) {
        setDistrictId(pk);
    }

    public long getDistrictId() {
        return _districtId;
    }

    public void setDistrictId(long districtId) {
        _districtId = districtId;
    }

    public String getName() {
        return _name;
    }

    public void setName(String name) {
        _name = name;
    }

    public String getCode() {
        return _code;
    }

    public void setCode(String code) {
        _code = code;
    }

    public String getArchived() {
        return _archived;
    }

    public void setArchived(String archived) {
        _archived = archived;
    }
}
