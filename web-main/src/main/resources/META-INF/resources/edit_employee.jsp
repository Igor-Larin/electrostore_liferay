<%@ include file="init.jsp" %>

<%
	List<Position> positions = PositionLocalServiceUtil.getAllPositions();
	long id = ParamUtil.getLong(renderRequest, "employeeId");
	Employee employee = EmployeeLocalServiceUtil.getEmployee(id);
	LocalDate localDate = LocalDate.ofInstant(employee.getBirthdate().toInstant(), ZoneId.systemDefault());
	int birthDay = localDate.getDayOfMonth();
	int birthMonth = localDate.getMonthValue() - 1;
	int birthYear = localDate.getYear();
	
%>
<c:set var="empl_pos_id" scope="page" value="<%= employee.getPosition_id() %>"/>

<portlet:renderURL var="backURL">
    <portlet:param name="mvcPath" value="/employees.jsp"></portlet:param>
</portlet:renderURL>
<portlet:actionURL name="updateEmployee" var="updateEmplURL">
	<portlet:param name="employeeId" value="<%=String.valueOf(id) %>"></portlet:param>
</portlet:actionURL>

<liferay-ui:header title="Изменение данных сотрудника"></liferay-ui:header>

<aui:form action="<%= updateEmplURL %>" name="editEmployeeForm">
	<aui:fieldset>		
		<aui:input value="<%= employee.getLastname() %>" name="lastname" label="Фамилия"></aui:input>
		<aui:input value="<%= employee.getName() %>" type="text" name="name" label="Имя"></aui:input>
		<aui:input value="<%= employee.getMidname() %>" name="midname" label="Отчество"></aui:input>
		<label>
			Дата рождения
			<liferay-ui:input-date dayValue="<%= birthDay %>" monthValue="<%= birthMonth %>" yearValue="<%= birthYear %>" formName="editEmployeeForm" name="birthdate"></liferay-ui:input-date>
		</label>		
		<aui:select name="sex" label="Пол">			
			<aui:option value="false" label="Мужчина"></aui:option>
			<aui:option value="true" label="Женщина"></aui:option>
		</aui:select>

		<aui:select name="position" label="Должность">
			<c:forEach items="<%= positions %>" var="pos">			
				<aui:option selected="${ empl_pos_id == pos.getPosition_id() }" value="${ pos.getPosition_id() }">${ pos.getName() }</aui:option>				
			</c:forEach>
		</aui:select>
	</aui:fieldset>	
	<aui:button-row>
		<aui:button value="Обновить информацию" type="submit"></aui:button>
		<aui:button type="cancel" onClick="${ backURL }" value="Назад"></aui:button>
	</aui:button-row>
</aui:form>