<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.regservicebuilder.service.FarmerLocalServiceUtil" %>
<%@ page import="com.example.regservicebuilder.model.Farmer" %>
<%@ page import="com.example.regservicebuilder.model.District" %>
<%@ page import="com.example.regservicebuilder.service.DistrictLocalServiceUtil" %>
<%@ page import="com.liferay.portal.kernel.dao.orm.DynamicQuery" %>
<%@ page import="com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib prefix="aui" uri="http://alloy.liferay.com/tld/aui" %>
<portlet:defineObjects/>

<%
    DynamicQuery dynamicQuery = (DynamicQuery) renderRequest.getAttribute("dynamicQuery");
    if (dynamicQuery == null) {
        dynamicQuery = DynamicQueryFactoryUtil.forClass(Farmer.class);
    }
    List<Farmer> filteredFarmers = FarmerLocalServiceUtil.dynamicQuery(dynamicQuery, 0, FarmerLocalServiceUtil.getFarmersCount());
    List<District> districts = DistrictLocalServiceUtil.getDistricts(0, DistrictLocalServiceUtil.getDistrictsCount());
%>

<!DOCTYPE html>
<html>

<body>
Реестр <b>фермеров</b>.<br><br>

<portlet:renderURL var="addFarmerURL">
    <portlet:param name="jspPage" value="/save_farmer.jsp"/>
</portlet:renderURL>

<portlet:actionURL var="filterURL" name="filterAction"/>

<a href="${addFarmerURL}" class="btn btn-primary" style="float: right;">Добавить фермера</a>

<button id="toggleFilterForm">Показать фильтр</button>
<br><br>

<form id="filterForm" action="<%= filterURL %>" method="post" style="display: none">
    <div style="display: flex;">
        <div style="flex: 0;">
            <label for="searchOrganizationName">Название организации:</label>
            <input type="text" id="searchOrganizationName" name="searchOrganizationName"><br><br>

            <label for="searchInn">ИНН:</label>
            <input type="text" id="searchInn" name="searchInn"><br><br>

            <label for="searchDistrict">Район регистрации:</label>
            <select id="searchDistrict" name="searchDistrict">
                <option value="">Выберите район</option>
                <% for (District district : districts) { %>
                <option value="<%= district.getDistrictId() %>"><%= district.getName() %>
                </option>
                <% } %>
            </select>
        </div>

        <div style="flex: 1; margin-left: 30px;">
            <label for="startDate">Начальная дата регистрации:</label>
            <input type="text" id="startDate" name="startDate"><br><br>

            <label for="endDate">Конечная дата регистрации:</label>
            <input type="text" id="endDate" name="endDate"><br><br>

            <label for="searchArchivedStatus">Статус архивности:</label>
            <select id="searchArchivedStatus" name="searchArchivedStatus">
                <option value="">Все</option>
                <option value="YES">В архиве</option>
                <option value="NO">Не в архиве</option>
            </select>
        </div>
    </div>
    <br>

    <input type="submit" value="Применить фильтр">
</form>

<liferay-ui:search-container emptyResultsMessage="Нет данных"> <%--Пагинация отключена--%>
    <liferay-ui:search-container-results
            results="<%=filteredFarmers %>"
            total="<%= filteredFarmers.size() %>"/>

    <liferay-ui:search-container-row className="com.example.regservicebuilder.model.Farmer" modelVar="farmer">
        <liferay-ui:search-container-column-text property="organizationName"
                                                 name="Название организации"/>
        <liferay-ui:search-container-column-text property="legalForm" name="Орг.-правовая форма"/>
        <liferay-ui:search-container-column-text property="inn" name="ИНН"/>
        <liferay-ui:search-container-column-text property="kpp" name="КПП"/>
        <liferay-ui:search-container-column-text property="ogrn" name="ОГРН"/>
        <liferay-ui:search-container-column-text name="Район регистрации">
            <% String districtName = ""; %>
            <% long districtId = farmer.getDistrictId(); %>
            <% if (districtId > 0) {
                District district = DistrictLocalServiceUtil.fetchDistrict(districtId);
                if (district != null) {
                    districtName = district.getName();
                }
            } %>
            <%= districtName %>
        </liferay-ui:search-container-column-text>
        <liferay-ui:search-container-column-text property="registrationDate" name="Дата регистрации"/>
        <liferay-ui:search-container-column-text name="Статус">
            <% if (farmer.getArchived().equals("YES")) { %> В архиве <% } else { %> Не в архиве <% } %>
        </liferay-ui:search-container-column-text>


        <liferay-ui:search-container-column-text name="Действия">
            <portlet:renderURL var="editURLFarmer">
                <portlet:param name="jspPage" value="/save_farmer.jsp"/>
                <portlet:param name="farmerId" value="<%= String.valueOf(farmer.getFarmerId()) %>"/>
            </portlet:renderURL>
            <a href="<%= editURLFarmer %>"><span class="icon-edit">Изменить</span></a><br>


            <portlet:actionURL var="archiveURLFarmer" name="archiveFarmer">
                <portlet:param name="farmerId" value="<%= String.valueOf(farmer.getFarmerId()) %>"/>
            </portlet:actionURL>
            <a href="<%= archiveURLFarmer %>"><span class="icon-archive">Отправить в Архив</span></a><br>


            <portlet:actionURL var="restoreURLFarmer" name="restoreFarmer">
                <portlet:param name="farmerId" value="<%= String.valueOf(farmer.getFarmerId()) %>"/>
            </portlet:actionURL>
            <a href="<%= restoreURLFarmer %>"><span class="icon-archive">Восстановить из архива</span></a>

        </liferay-ui:search-container-column-text>
    </liferay-ui:search-container-row>
    <liferay-ui:search-iterator/>
</liferay-ui:search-container>

</body>
</html>

<script>
    const toggleFormButton = document.getElementById('toggleFilterForm');
    const filterForm = document.getElementById('filterForm');

    toggleFormButton.addEventListener('click', function () {
        if (filterForm.style.display === 'none') {
            filterForm.style.display = 'block';
            toggleFormButton.textContent = 'Скрыть форму фильтра';
        } else {
            filterForm.style.display = 'none';
            toggleFormButton.textContent = 'Открыть форму фильтра';
        }
    });
</script>

<script>

    function saveFormValues() {
        const searchOrganizationName = document.getElementById('searchOrganizationName');
        const searchInn = document.getElementById('searchInn');
        const searchDistrict = document.getElementById('searchDistrict');
        const startDate = document.getElementById('startDate');
        const endDate = document.getElementById('endDate');
        const searchArchivedStatus = document.getElementById('searchArchivedStatus');


        localStorage.setItem('searchOrganizationName', searchOrganizationName.value);
        localStorage.setItem('searchInn', searchInn.value);
        localStorage.setItem('searchDistrict', searchDistrict.value);
        localStorage.setItem('startDate', startDate.value);
        localStorage.setItem('endDate', endDate.value);
        localStorage.setItem('searchArchivedStatus', searchArchivedStatus.value);
    }

    function loadFormValues() {
        const searchOrganizationName = document.getElementById('searchOrganizationName');
        const searchInn = document.getElementById('searchInn');
        const searchDistrict = document.getElementById('searchDistrict');
        const startDate = document.getElementById('startDate');
        const endDate = document.getElementById('endDate');
        const searchArchivedStatus = document.getElementById('searchArchivedStatus');

        searchOrganizationName.value = localStorage.getItem('searchOrganizationName') || '';
        searchInn.value = localStorage.getItem('searchInn') || '';
        searchDistrict.value = localStorage.getItem('searchDistrict') || '';
        startDate.value = localStorage.getItem('startDate') || '';
        endDate.value = localStorage.getItem('endDate') || '';
        searchArchivedStatus.value = localStorage.getItem('searchArchivedStatus') || '';
    }

    window.onload = function () {
        loadFormValues();
    };

    document.getElementById('filterForm').addEventListener('submit', function () {
        saveFormValues();
    });

</script>

<aui:script use="aui-datepicker">
    YUI().use('aui-datepicker', function (A) {
        var fromDatePicker = new A.DatePicker({
            trigger: '#startDate',
            popover: {
                zIndex: 1
            },
            mask: '%m/%d/%Y'
        })
    });

    YUI().use('aui-datepicker', function (A) {
        var endDatePicker = new A.DatePicker({
            trigger: '#endDate',
            popover: {
                zIndex: 1
            },
            mask: '%m/%d/%Y'
        });
    });

</aui:script>