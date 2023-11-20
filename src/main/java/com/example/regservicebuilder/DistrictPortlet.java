package com.example.regservicebuilder;

import com.example.regservicebuilder.enums.Status;
import com.example.regservicebuilder.model.District;
import com.example.regservicebuilder.service.DistrictLocalServiceUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.ProcessAction;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DistrictPortlet extends MVCPortlet {

    private static final Logger log = Logger.getLogger(DistrictPortlet.class.getName());

    @ProcessAction(name = "addDistrict")
    public void addDistrict(ActionRequest request, ActionResponse response){
        String districtName = ParamUtil.getString(request, "name");
        String districtCode = ParamUtil.getString(request, "code");

        District district = DistrictLocalServiceUtil.createDistrict(0);

        district.setName(districtName);
        district.setCode(districtCode);
        district.setArchived(Status.NO.toString());

        try {
            district = DistrictLocalServiceUtil.addDistrict(district);
            log.info(String.format(String.valueOf(district.getDistrictId()), "Создан район с ID: %s"));
        } catch (Exception e) {
            log.log(Level.SEVERE, String.format(e.getMessage(),"Ошибка при создании района: %s"));
        }
    }

    @ProcessAction(name = "editDistrict")
    public void editDistrict(ActionRequest request, ActionResponse response){
        long districtId = ParamUtil.getLong(request, "districtId");
        String districtName = ParamUtil.getString(request, "name");
        String districtCode = ParamUtil.getString(request, "code");

        try {
            District district = DistrictLocalServiceUtil.getDistrict(districtId);
            if (district != null) {
                district.setName(districtName);
                district.setCode(districtCode);

                DistrictLocalServiceUtil.updateDistrict(district);
                log.info(String.format(String.valueOf(districtId), "Отредактирован район с ID: {%s}"));
            } else {
                log.warning(String.format(String.valueOf(districtId), "Район с ID: {%s} не найден для редактирования"));
            }
        } catch (Exception e) {
            log.log(Level.SEVERE, String.format(e.getMessage(),"Ошибка при редактировании района: %s"));
        }
    }

    @ProcessAction(name = "archiveDistrict")
    public void archiveDistrict(ActionRequest request, ActionResponse response){
        long districtId = ParamUtil.getLong(request, "districtId");

        try {
            District district = DistrictLocalServiceUtil.getDistrict(districtId);
            if (district != null) {
                district.setArchived(Status.YES.toString());

                DistrictLocalServiceUtil.updateDistrict(district);
                log.info(String.format(String.valueOf(districtId), "Заархивирован район с ID: {%s}"));
            } else {
                log.warning(String.format(String.valueOf(districtId), "Район с ID: {%s} не найден для архивации"));
            }
        } catch (Exception e) {
            log.log(Level.SEVERE, String.format(e.getMessage(),"Ошибка при архивации района: %s"));
        }
    }
}
