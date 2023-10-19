<%@ include file="init.jsp" %>

<portlet:renderURL var="addEmployeeURL">
	<portlet:param name="mvcPath" value="/add_employee.jsp"/>
</portlet:renderURL>
<portlet:renderURL var="mainPageURL">
	<portlet:param name="mvcPath" value="/view.jsp"/>
</portlet:renderURL>

<aui:button-row>
	<aui:button onClick="${ addEmployeeURL }" value="Добавить сотрудника"></aui:button>
	<aui:button onClick="${ mainPageURL }" value="Назад"></aui:button>
</aui:button-row>

<liferay-ui:search-container emptyResultsMessage="Список сотрудников пуст" total="<%= EmployeeLocalServiceUtil.getEmployeesCount() %>">
	<liferay-ui:search-container-results results="<%= EmployeeLocalServiceUtil.getAllEmployees() %>"></liferay-ui:search-container-results>
	<liferay-ui:search-container-row className="electrostore.db.model.Employee" modelVar="employee">
		<liferay-ui:search-container-column-text property="name"></liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-text property="lastname"></liferay-ui:search-container-column-text>
	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator></liferay-ui:search-iterator>
</liferay-ui:search-container>