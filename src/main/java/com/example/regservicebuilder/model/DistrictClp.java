package com.example.regservicebuilder.model;

import com.example.regservicebuilder.service.ClpSerializer;
import com.example.regservicebuilder.service.DistrictLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;


public class DistrictClp extends BaseModelImpl<District> implements District {
    private long _districtId;
    private String _name;
    private String _code;
    private String _archived;
    private BaseModel<?> _districtRemoteModel;
    private Class<?> _clpSerializerClass = com.example.regservicebuilder.service.ClpSerializer.class;

    public DistrictClp() {
    }

    @Override
    public Class<?> getModelClass() {
        return District.class;
    }

    @Override
    public String getModelClassName() {
        return District.class.getName();
    }

    @Override
    public long getPrimaryKey() {
        return _districtId;
    }

    @Override
    public void setPrimaryKey(long primaryKey) {
        setDistrictId(primaryKey);
    }

    @Override
    public Serializable getPrimaryKeyObj() {
        return _districtId;
    }

    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey(((Long) primaryKeyObj).longValue());
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("districtId", getDistrictId());
        attributes.put("name", getName());
        attributes.put("code", getCode());
        attributes.put("archived", getArchived());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long districtId = (Long) attributes.get("districtId");

        if (districtId != null) {
            setDistrictId(districtId);
        }

        String name = (String) attributes.get("name");

        if (name != null) {
            setName(name);
        }

        String code = (String) attributes.get("code");

        if (code != null) {
            setCode(code);
        }

        String archived = (String) attributes.get("archived");

        if (archived != null) {
            setArchived(archived);
        }
    }

    @Override
    public long getDistrictId() {
        return _districtId;
    }

    @Override
    public void setDistrictId(long districtId) {
        _districtId = districtId;

        if (_districtRemoteModel != null) {
            try {
                Class<?> clazz = _districtRemoteModel.getClass();

                Method method = clazz.getMethod("setDistrictId", long.class);

                method.invoke(_districtRemoteModel, districtId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getName() {
        return _name;
    }

    @Override
    public void setName(String name) {
        _name = name;

        if (_districtRemoteModel != null) {
            try {
                Class<?> clazz = _districtRemoteModel.getClass();

                Method method = clazz.getMethod("setName", String.class);

                method.invoke(_districtRemoteModel, name);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getCode() {
        return _code;
    }

    @Override
    public void setCode(String code) {
        _code = code;

        if (_districtRemoteModel != null) {
            try {
                Class<?> clazz = _districtRemoteModel.getClass();

                Method method = clazz.getMethod("setCode", String.class);

                method.invoke(_districtRemoteModel, code);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getArchived() {
        return _archived;
    }

    @Override
    public void setArchived(String archived) {
        _archived = archived;

        if (_districtRemoteModel != null) {
            try {
                Class<?> clazz = _districtRemoteModel.getClass();

                Method method = clazz.getMethod("setArchived", String.class);

                method.invoke(_districtRemoteModel, archived);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    public BaseModel<?> getDistrictRemoteModel() {
        return _districtRemoteModel;
    }

    public void setDistrictRemoteModel(BaseModel<?> districtRemoteModel) {
        _districtRemoteModel = districtRemoteModel;
    }

    public Object invokeOnRemoteModel(String methodName,
        Class<?>[] parameterTypes, Object[] parameterValues)
        throws Exception {
        Object[] remoteParameterValues = new Object[parameterValues.length];

        for (int i = 0; i < parameterValues.length; i++) {
            if (parameterValues[i] != null) {
                remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
            }
        }

        Class<?> remoteModelClass = _districtRemoteModel.getClass();

        ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

        Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

        for (int i = 0; i < parameterTypes.length; i++) {
            if (parameterTypes[i].isPrimitive()) {
                remoteParameterTypes[i] = parameterTypes[i];
            } else {
                String parameterTypeName = parameterTypes[i].getName();

                remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
            }
        }

        Method method = remoteModelClass.getMethod(methodName,
                remoteParameterTypes);

        Object returnValue = method.invoke(_districtRemoteModel,
                remoteParameterValues);

        if (returnValue != null) {
            returnValue = ClpSerializer.translateOutput(returnValue);
        }

        return returnValue;
    }

    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            DistrictLocalServiceUtil.addDistrict(this);
        } else {
            DistrictLocalServiceUtil.updateDistrict(this);
        }
    }

    @Override
    public District toEscapedModel() {
        return (District) ProxyUtil.newProxyInstance(District.class.getClassLoader(),
            new Class[] { District.class }, new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        DistrictClp clone = new DistrictClp();

        clone.setDistrictId(getDistrictId());
        clone.setName(getName());
        clone.setCode(getCode());
        clone.setArchived(getArchived());

        return clone;
    }

    @Override
    public int compareTo(District district) {
        long primaryKey = district.getPrimaryKey();

        if (getPrimaryKey() < primaryKey) {
            return -1;
        } else if (getPrimaryKey() > primaryKey) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof DistrictClp)) {
            return false;
        }

        DistrictClp district = (DistrictClp) obj;

        long primaryKey = district.getPrimaryKey();

        if (getPrimaryKey() == primaryKey) {
            return true;
        } else {
            return false;
        }
    }

    public Class<?> getClpSerializerClass() {
        return _clpSerializerClass;
    }

    @Override
    public int hashCode() {
        return (int) getPrimaryKey();
    }

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(9);

        sb.append("{districtId=");
        sb.append(getDistrictId());
        sb.append(", name=");
        sb.append(getName());
        sb.append(", code=");
        sb.append(getCode());
        sb.append(", archived=");
        sb.append(getArchived());
        sb.append("}");

        return sb.toString();
    }

    @Override
    public String toXmlString() {
        StringBundler sb = new StringBundler(16);

        sb.append("<model><model-name>");
        sb.append("com.example.regservicebuilder.model.District");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>districtId</column-name><column-value><![CDATA[");
        sb.append(getDistrictId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>name</column-name><column-value><![CDATA[");
        sb.append(getName());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>code</column-name><column-value><![CDATA[");
        sb.append(getCode());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>archived</column-name><column-value><![CDATA[");
        sb.append(getArchived());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
