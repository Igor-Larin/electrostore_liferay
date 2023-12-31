<%@ include file="../init.jsp" %>

<%
	DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
%>
<portlet:renderURL var="addEmployeeURL">
	<portlet:param name="mvcPath" value="/employees/add_employee.jsp"/>
</portlet:renderURL>
<portlet:renderURL var="mainPageURL">
	<portlet:param name="mvcPath" value="/view.jsp"/>
</portlet:renderURL>
<liferay-portlet:renderURL varImpl="iteratorURL">
	<portlet:param name="mvcPath" value="/employees/employees.jsp" />
</liferay-portlet:renderURL>

<liferay-ui:header title="Список сотрудников"></liferay-ui:header>

<aui:button-row>
	<aui:button onClick="${ addEmployeeURL }" value="Добавить сотрудника"></aui:button>
	<aui:button onClick="${ mainPageURL }" value="Главная страница"></aui:button>
</aui:button-row>
<liferay-ui:search-container delta="15" iteratorURL="<%= iteratorURL %>" emptyResultsMessage="Список сотрудников пуст" total="<%= EmployeeLocalServiceUtil.getEmployeesCount() %>">
	<liferay-ui:search-container-results results="<%= EmployeeLocalServiceUtil.getEmployees(searchContainer.getStart(), searchContainer.getEnd()) %>"></liferay-ui:search-container-results>
	<liferay-ui:search-container-row className="electrostore.db.model.Employee" modelVar="employee">
		<portlet:actionURL name="deleteEmployee" var="deleteEmployeeURL">
			<portlet:param name="employeeId" value="<%=String.valueOf(employee.getEmployee_id()) %>"></portlet:param>
		</portlet:actionURL>
		<portlet:renderURL var="editEmployeeURL">
			<portlet:param name="mvcPath" value="/employees/edit_employee.jsp"/>
			<portlet:param name="employeeId" value="<%=String.valueOf(employee.getEmployee_id()) %>"></portlet:param>
		</portlet:renderURL>
		<liferay-ui:search-container-column-text name="Фамилия" property="lastname"></liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-text name="Имя" property="name"></liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-text name="Отчество" property="midname"></liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-text name="Должность" value="<%= PositionLocalServiceUtil.getPosition(employee.getPosition_id()).getName() %>"></liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-text name="Дата рождения(День-Месяц-Год)" value="<%= dateFormat.format(employee.getBirthdate()) %>"> </liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-text name="Пол" value="<%= employee.getSex() ? "Женщина" : "Мужчина" %>"></liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-text>			
				<aui:button onClick="${ editEmployeeURL }" value="Изменить"></aui:button>
				<aui:button onClick="${ deleteEmployeeURL }" value="Удалить"></aui:button>
		</liferay-ui:search-container-column-text>
	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator searchContainer="<%= searchContainer %>"></liferay-ui:search-iterator>
</liferay-ui:search-container>