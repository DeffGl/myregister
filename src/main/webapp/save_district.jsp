<%@ page import="com.liferay.portal.kernel.util.ParamUtil" %>
<%@ page import="com.example.regservicebuilder.model.District" %>
<%@ page import="com.example.regservicebuilder.service.DistrictLocalServiceUtil" %>
<%@ page import="com.example.regservicebuilder.NoSuchDistrictException" %>
<%@ page import="javax.portlet.PortletURL" %>
<%@ page import="javax.portlet.ActionRequest" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib prefix="aui" uri="http://alloy.liferay.com/tld/aui" %>


<%
    javax.portlet.RenderResponse renderResponse = (javax.portlet.RenderResponse) request.getAttribute("javax.portlet.response");
    long districtId = ParamUtil.getLong(request, "districtId");

    PortletURL editActionUrl = renderResponse.createActionURL();
    editActionUrl.setParameter(ActionRequest.ACTION_NAME, "editDistrict");
    String editUrlString = editActionUrl.toString();

    PortletURL addActionUrl = renderResponse.createActionURL();
    addActionUrl.setParameter(ActionRequest.ACTION_NAME, "addDistrict");
    String addUrlString = addActionUrl.toString();

    String actionUrl;
    District district = null;
    String pageTitle;

    if (districtId > 0) {
        actionUrl = editUrlString;
        pageTitle = "редактирования";
        try {
            district = DistrictLocalServiceUtil.getDistrict(districtId);
        } catch (NoSuchDistrictException e) {
            out.println("Район с указанным ID не найден.");
        }
    } else {
        actionUrl = addUrlString;
        pageTitle = "создания";
    }


%>

<!DOCTYPE html>
<html>
<head>
    <title>Форма <%= pageTitle%> района</title>
</head>
<body>
<h3>Форма <%= pageTitle%> района</h3>

<form id="districtForm" action="<%= actionUrl %>" method="POST">

    <label for="districtName">Название района:</label>
    <input id="districtName" name="name" value="<%= (district != null) ? district.getName() : "" %>"><br><br>

    <label for="districtCode">Код:</label>
    <input id="districtCode" name="code" value="<%= (district != null) ? district.getCode() : "" %>"><br><br>

    <input type="hidden" name="districtId" value="<%= (district != null) ? district.getDistrictId() : "" %>">

    <input type="submit" value="Сохранить">
</form>
</body>
</html>

<aui:script>

    var rules = {
        name: {
            required: true,
            rangeLength: [2,75]
        },
        code: {
            rangeLength: [1,75],
            digits: true
        }
    }

    var fieldStrings = {
        name: {
            required: "Поле с название не должно быть пустым",
            rangeLength: "Названием должно быть длинной от 2 до 75 символов",
        },
        code: {
            rangeLength: "Код должно быть длинной от 1 до 75 символов",
            digits: "Код должен содержать только цифровые символы"
        }
    }

    AUI().use(
            'aui-form-validator',
            function(A) {
                new A.FormValidator(
                        {
                            boundingBox: districtForm,
                            fieldStrings: fieldStrings,
                            rules: rules,
                            showAllMessages: true
                        }
                )
            }
    );
</aui:script>