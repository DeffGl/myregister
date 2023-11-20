package com.example.regservicebuilder;

import com.example.regservicebuilder.enums.Status;
import com.example.regservicebuilder.model.Farmer;
import com.example.regservicebuilder.service.DistrictLocalServiceUtil;
import com.example.regservicebuilder.service.FarmerLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.dao.search.DisplayTerms;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

import javax.portlet.*;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FarmerPortlet extends MVCPortlet {
    private static final Logger log = Logger.getLogger(DistrictPortlet.class.getName());

    @ProcessAction(name = "addFarmer")
    public void addFarmer(ActionRequest request, ActionResponse response) throws SystemException, ParseException {
        Farmer farmer = addFields(
                FarmerLocalServiceUtil.createFarmer(0),
                ParamUtil.getString(request, "organizationName"),
                ParamUtil.getString(request, "legalForm"),
                ParamUtil.getString(request, "inn"),
                ParamUtil.getString(request, "kpp"),
                ParamUtil.getString(request, "ogrn"),
                ParamUtil.getLong(request, "registrationDistrict"),
                parseDate(ParamUtil.getString(request, "registrationDate")));
        try {
            Farmer savedFarmer = FarmerLocalServiceUtil.addFarmer(farmer);
            DistrictLocalServiceUtil.addFarmerDistricts(savedFarmer.getFarmerId(), getSelectedDistricts(ParamUtil.getString(request, "selectedDistrictsHidden")));
            log.info(String.format(String.valueOf(farmer.getFarmerId()), "Создан фермер с ID: %s"));
        } catch (Exception e) {
            log.log(Level.SEVERE, String.format(e.getMessage(), "Ошибка при создании фермера: %s"));
        }
    }

    @ProcessAction(name = "editFarmer")
    public void editFarmer(ActionRequest request, ActionResponse response) {
        try {
            long farmerId = ParamUtil.getLong(request, "farmerId");
            Farmer farmer = FarmerLocalServiceUtil.getFarmer(farmerId);
            if (farmer != null) {
                Farmer updatedFarmer = addFields(
                        farmer,
                        ParamUtil.getString(request, "organizationName"),
                        ParamUtil.getString(request, "legalForm"),
                        ParamUtil.getString(request, "inn"),
                        ParamUtil.getString(request, "kpp"),
                        ParamUtil.getString(request, "ogrn"),
                        ParamUtil.getLong(request, "registrationDistrict"),
                        parseDate(ParamUtil.getString(request, "registrationDate")));

                FarmerLocalServiceUtil.updateFarmer(updatedFarmer);
                DistrictLocalServiceUtil.setFarmerDistricts(farmerId, getSelectedDistricts(ParamUtil.getString(request, "selectedDistrictsHidden")));
                log.info(String.format(String.valueOf(farmer.getFarmerId()), "Отредактирован фермер с ID: %s"));
            } else {
                log.warning(String.format(String.valueOf(farmerId), "Фермер с ID: {%s} не найден для редактирования"));
            }
        } catch (Exception e) {
            log.log(Level.SEVERE, String.format(e.getMessage(), "Ошибка при редактировании фермера: %s"));
        }
    }

    @ProcessAction(name = "archiveFarmer")
    public void archiveFarmer(ActionRequest request, ActionResponse response) {
        long farmerId = ParamUtil.getLong(request, "farmerId");

        try {
            Farmer farmer = FarmerLocalServiceUtil.getFarmer(farmerId);
            if (farmer != null) {
                farmer.setArchived(Status.YES.toString());

                FarmerLocalServiceUtil.updateFarmer(farmer);
                log.info(String.format(String.valueOf(farmerId), "Заархивирован фермер с ID: {%s}"));
            } else {
                log.warning(String.format(String.valueOf(farmerId), "Фермер с ID: {%s} не найден для архивации"));
            }
        } catch (Exception e) {
            log.log(Level.SEVERE, String.format(e.getMessage(), "Ошибка при архивации фермера: %s"));
        }
    }

    @ProcessAction(name = "restoreFarmer")
    public void restoreFarmer(ActionRequest request, ActionResponse response) {
        long farmerId = ParamUtil.getLong(request, "farmerId");

        try {
            Farmer farmer = FarmerLocalServiceUtil.getFarmer(farmerId);
            if (farmer != null) {
                farmer.setArchived(Status.NO.toString());

                FarmerLocalServiceUtil.updateFarmer(farmer);
                log.info(String.format(String.valueOf(farmerId), "Разархивирован фермер с ID: {%s}"));
            } else {
                log.warning(String.format(String.valueOf(farmerId), "Фермер с ID: {%s} не найден для разархивации"));
            }
        } catch (Exception e) {
            log.log(Level.SEVERE, String.format(e.getMessage(), "Ошибка при разархивации фермера: %s"));
        }
    }

    @ProcessAction(name = "filterAction")
    public void filterAction(ActionRequest request, ActionResponse response) throws SystemException, PortalException, ParseException {
        DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(Farmer.class);

        String searchOrganizationName = ParamUtil.getString(request, "searchOrganizationName", "");
        String searchInn = ParamUtil.getString(request, "searchInn", "");
        long searchDistrict = ParamUtil.getLong(request, "searchDistrict");
        String startDate = ParamUtil.getString(request, "startDate", "");
        String endDate = ParamUtil.getString(request, "endDate", "");
        String searchArchivedStatus = ParamUtil.getString(request, "searchArchivedStatus", "");

        if (!searchOrganizationName.isEmpty()){
            dynamicQuery.add(RestrictionsFactoryUtil.ilike("organizationName", "%" + searchOrganizationName + "%"));
        }
        if (!searchInn.isEmpty()){
            dynamicQuery.add(RestrictionsFactoryUtil.eq("inn", searchInn));
        }
        if (searchDistrict != 0){
            dynamicQuery.add(RestrictionsFactoryUtil.eq("districtId", searchDistrict));
        }
        if ((!startDate.isEmpty() && !endDate.isEmpty())){
            try {
                dynamicQuery.add(RestrictionsFactoryUtil.between("registrationDate", parseDate(startDate), parseDate(endDate)));
            } catch (ParseException e) {
                log.log(Level.SEVERE, String.format(e.getMessage(), "Ошибка при обработке даты: %s"));
            }
        }
        if (!searchArchivedStatus.isEmpty()){
            dynamicQuery.add(RestrictionsFactoryUtil.eq("archived", searchArchivedStatus));
        }

        request.setAttribute("dynamicQuery", dynamicQuery);
    }

    private long[] getSelectedDistricts(String districtsIds) {
        if (districtsIds.isEmpty()) {
            return new long[0];
        } else {
            String[] values = districtsIds.split(",");
            long[] longValues = new long[values.length];

            for (int i = 0; i < values.length; i++) {
                longValues[i] = Long.parseLong(values[i]);
            }
            return longValues;
        }
    }

    private Farmer addFields(Farmer farmer, String organizationName, String legalForm, String inn, String kpp, String ogrn, long registrationDistrict, Date registrationDate) {
        farmer.setOrganizationName(organizationName);
        farmer.setLegalForm(legalForm);
        farmer.setInn(inn);
        farmer.setKpp(kpp);
        farmer.setOgrn(ogrn);
        farmer.setDistrictId(registrationDistrict);
        farmer.setRegistrationDate(registrationDate);
        farmer.setArchived(Status.NO.toString());
        return farmer;
    }

    private Date parseDate(String date) throws ParseException {
        if (date.isEmpty()){
            return new Date();
        }
        DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
        return df.parse(date);
    }
}
