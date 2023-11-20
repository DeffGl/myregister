<%@ page import="com.liferay.portal.kernel.util.ParamUtil" %>
<%@ page import="com.example.regservicebuilder.model.District" %>
<%@ page import="com.example.regservicebuilder.service.DistrictLocalServiceUtil" %>
<%@ page import="javax.portlet.PortletURL" %>
<%@ page import="javax.portlet.ActionRequest" %>
<%@ page import="com.example.regservicebuilder.model.Farmer" %>
<%@ page import="com.example.regservicebuilder.service.FarmerLocalServiceUtil" %>
<%@ page import="com.example.regservicebuilder.NoSuchFarmerException" %>
<%@ page import="java.util.List" %><%@ page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib prefix="aui" uri="http://alloy.liferay.com/tld/aui" %>


<%
    javax.portlet.RenderResponse renderResponse = (javax.portlet.RenderResponse) request.getAttribute("javax.portlet.response");
    long farmerId = ParamUtil.getLong(request, "farmerId");

    PortletURL editActionUrl = renderResponse.createActionURL();
    editActionUrl.setParameter(ActionRequest.ACTION_NAME, "editFarmer");
    String editUrlString = editActionUrl.toString();

    PortletURL addActionUrl = renderResponse.createActionURL();
    addActionUrl.setParameter(ActionRequest.ACTION_NAME, "addFarmer");
    String addUrlString = addActionUrl.toString();

    String actionUrl;
    Farmer farmer = null;
    String pageTitle;


    if (farmerId > 0) {
        actionUrl = editUrlString;
        pageTitle = "редактирования";
        try {
            farmer = FarmerLocalServiceUtil.getFarmer(farmerId);
        } catch (NoSuchFarmerException e) {
            out.println("Фермер с указанным ID не найден.");
        }
    } else{
        actionUrl = addUrlString;
        pageTitle = "создания";
    }

    List<District> districts = DistrictLocalServiceUtil.getDistricts(0, DistrictLocalServiceUtil.getDistrictsCount());

%>

<!DOCTYPE html>
<html>
<head>
    <title>Форма <%=pageTitle%> фермера</title>
    <link rel="stylesheet" type="text/css" href="css/main.css">
    <script src="js/main.js"></script>
</head>
<body>
<h3>Форма <%=pageTitle%> фермера</h3>

<form id="farmerForm" action="<%= actionUrl %>" method="POST">

    <label for="organizationName">Название организации:</label>
    <input id="organizationName" name="organizationName"
           value="<%= (farmer != null) ? farmer.getOrganizationName() : "" %>"><br><br>

    <label for="legalForm">Орг.-правовая форма:</label>
    <input id="legalForm" name="legalForm" value="<%= (farmer != null) ? farmer.getLegalForm() : "" %>"><br><br>

    <label for="inn">ИНН:</label>
    <input id="inn" name="inn" value="<%= (farmer != null) ? farmer.getInn() : "" %>"><br><br>

    <label for="kpp">КПП:</label>
    <input id="kpp" name="kpp" value="<%= (farmer != null) ? farmer.getKpp() : "" %>"><br><br>

    <label for="ogrn">ОГРН:</label>
    <input id="ogrn" name="ogrn" value="<%= (farmer != null) ? farmer.getOgrn() : "" %>"><br><br>

    <label for="registrationDistrict">Район регистрации:</label>
    <select id="registrationDistrict" name="registrationDistrict">
        <option value="">Выберите район</option>
        <% for (District district : districts) { %>
        <option value="<%= district.getDistrictId() %>"
                <% if (farmer != null && farmer.getDistrictId() == district.getDistrictId()) { %>
                selected
                <% } %>
        ><%= district.getName() %>
        </option>
        <% } %>
    </select><br><br>

    <label>Районы посевных полей:</label>
    <% List<District> selectedDistricts = DistrictLocalServiceUtil.getFarmerDistricts(farmerId); %>
    <div class="container">
        <select id="districts" multiple>
            <% for (District district : districts) {
                boolean isSelected = false;
                for (District selectedDistrict : selectedDistricts) {
                    if (selectedDistrict.getDistrictId() == district.getDistrictId()) {
                        isSelected = true;
                        break;
                    }
                }
                if (!isSelected) { %>
            <option value="<%= district.getDistrictId() %>"><%= district.getName() %>
            </option>
            <% }
            } %>
        </select>
        <div>
            <button type="button" onclick="moveToSelected()">></button>
            <br>
            <button type="button" onclick="moveToDistricts()"><</button>
        </div>
        <select id="selectedDistricts" name="selectedDistricts" multiple>
            <% for (District district : selectedDistricts) { %>
            <option value="<%= district.getDistrictId() %>"><%= district.getName() %>
            </option>
            <% } %>
        </select>
        <input type="hidden" id="selectedDistrictsHidden" name="selectedDistrictsHidden" value="">
    </div>

    <%
        String formattedDate = "";
        if (farmer != null && farmer.getRegistrationDate() != null) {
            SimpleDateFormat outputDateFormat = new SimpleDateFormat("MM/dd/yyyy");
            formattedDate = outputDateFormat.format(farmer.getRegistrationDate());
        }
    %>
    <label for="myDatePicker">Дата регистрации:</label>
    <input type="text" name="registrationDate" id="myDatePicker" value="<%= formattedDate %>"/><br>

    <input type="hidden" name="farmerId" value="<%= (farmer != null) ? farmer.getFarmerId() : "" %>">

    <input type="submit" value="Сохранить">
</form>
</body>
</html>


<aui:script use="aui-datepicker">
    YUI().use('aui-datepicker', function(A) {
        var datePicker = new A.DatePicker({
            trigger: '#myDatePicker',
            popover: {
                zIndex: 1
            },
            mask: '%m/%d/%Y'
        });

        var registrationDate = '<%= formattedDate %>';

        if (registrationDate) {
            var formattedDate = registrationDate.split("/");

            var month = parseInt(formattedDate[0]) - 1;
            var day = parseInt(formattedDate[1]);
            var year = parseInt(formattedDate[2]);

            datePicker.set('activeInput', A.one('#myDatePicker'));
            datePicker.selectDates(new Date(year, month, day));
        }
    });
</aui:script>

<aui:script>

    var rules = {
        organizationName: {
            required: true,
            rangeLength: [2,75]
        },
        legalForm: {
            rangeLength: [2,75]
        },
        inn: {
            required: true,
            minLength: 10,
            maxLength: 12,
            digits: true

        },
        kpp: {
            rangeLength: [9,9],
            digits: true
        },
        ogrn: {
            minLength: 13,
            maxLength: 15,
            digits: true
        }
    }

    var fieldStrings = {
        organizationName: {
            required: "Поле с названием организации не должно быть пустым",
            rangeLength: "Название организации должно быть длинной от 2 до 75 символов"
        },
        legalForm: {
            rangeLength: "Орг.-правовая форма должна быть длинной от 2 до 75 символов"
        },
        inn: {
            required: "Поле с ИНН не должно быть пустым",
            minLength: "Длина ИНН должна быть не менее 10 символов",
            maxLength: "Длина ИНН должна быть не более 12 символов",
            digits: "ИНН должен содержать только цифровые символы"
        },
        kpp: {
            rangeLength: "Длина КПП должна быть равна 9 символов",
            digits: "КПП должен содержать только цифровые символы"
        },
        ogrn: {
            minLength: "Длина ОГРН должна быть не менее 13 символов",
            maxLength: "Длина ОГРН должна быть не более 15 символов",
            digits: "ОГРН должен содержать только цифровые символы"
        }
    }

    AUI().use(
            'aui-form-validator',
            function(A) {
                new A.FormValidator(
                        {
                            boundingBox: farmerForm,
                            fieldStrings: fieldStrings,
                            rules: rules,
                            showAllMessages: true
                        }
                )
            }
    );
</aui:script>
