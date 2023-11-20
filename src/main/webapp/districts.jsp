<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ page import="com.example.regservicebuilder.model.District" %>
<%@ page import="com.example.regservicebuilder.service.DistrictLocalServiceUtil" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.regservicebuilder.service.DistrictLocalService" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>


<portlet:defineObjects />

Реестр <b>районов</b>.

<%
    List<District> districts = DistrictLocalServiceUtil.findByArchive("NO", 0, DistrictLocalServiceUtil.getDistrictsCount());
%>


<portlet:renderURL var="addDistrictURL">
    <portlet:param name="jspPage" value="/save_district.jsp"/>
</portlet:renderURL>

<a href="${addDistrictURL}" class="btn btn-primary" style="float: right;">Добавить район</a>


<liferay-ui:search-container emptyResultsMessage="Нет данных" delta="5" deltaConfigurable="true">
    <liferay-ui:search-container-results
            results="<%= DistrictLocalServiceUtil.findByArchive(\"NO\",searchContainer.getStart(), searchContainer.getEnd())%>"
            total="<%= districts.size()%>"/>

    <liferay-ui:search-container-row className="com.example.regservicebuilder.model.District" modelVar="district">
            <liferay-ui:search-container-column-text property="name" name="Название района"/>
            <liferay-ui:search-container-column-text property="code" name="Код района"/>


            <liferay-ui:search-container-column-text name="Действия">
                <portlet:renderURL var="editURLDistrict">
                    <portlet:param name="jspPage" value="/save_district.jsp"/>
                    <portlet:param name="districtId" value="<%= String.valueOf(district.getDistrictId()) %>"/>
                </portlet:renderURL>
                <a href="<%= editURLDistrict %>"><span class="icon-edit">Изменить</span></a><br>


                <portlet:actionURL var="archiveURLDistrict" name="archiveDistrict">
                    <portlet:param name="districtId" value="<%= String.valueOf(district.getDistrictId()) %>"/>
                </portlet:actionURL>
                <a href="<%= archiveURLDistrict %>"><span class="icon-archive">Отправить в Архив</span></a>

            </liferay-ui:search-container-column-text>
    </liferay-ui:search-container-row>

    <liferay-ui:search-iterator/>
</liferay-ui:search-container>
