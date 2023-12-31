<%@ include file="init.jsp" %>
<portlet:renderURL var="backURL">
    <portlet:param name="mvcPath" value="/view.jsp"></portlet:param>
</portlet:renderURL>
<portlet:actionURL name="loadDatabase" var="loadDatabaseURL"></portlet:actionURL>

<liferay-ui:header title="Загрузка данных"></liferay-ui:header>

<aui:form action="<%= loadDatabaseURL %>" name="addEmployeeForm" enctype="multipart/form-data">
	<aui:input name="datafile" type="file" label="Файл">
		<aui:validator errorMessage="Используйте файлы с расширением .zip" name="acceptFiles">'zip'</aui:validator>
	</aui:input>
	<aui:button-row>
		<aui:button value="Загрузить" type="submit"></aui:button>
		<aui:button type="cancel" onClick="${ backURL }" value="Назад"></aui:button>
	</aui:button-row>
</aui:form>