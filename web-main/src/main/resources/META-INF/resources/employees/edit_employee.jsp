<%@ include file="../init.jsp" %>
<liferay-ui:success key="updateEmployeeSuccess" message="asdasd" />
<%
	List<Position> positions = PositionLocalServiceUtil.getAllPositions();
	long id = ParamUtil.getLong(renderRequest, "employeeId");
	Employee employee = EmployeeLocalServiceUtil.getEmployee(id);
	DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	List<ElectronicType> electrotypes = ElectronicTypeLocalServiceUtil.getElectronicTypes(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	List<Long> selectedTypes = ElectronicTypeLocalServiceUtil.getEmployeesElectronicTypes(id);	
%>
<c:set var="empl_pos_id" scope="page" value="<%= employee.getPosition_id() %>"/>
<c:set var="selectedTypes" scope="page" value="<%= selectedTypes %>"/>

<portlet:renderURL var="backURL">
    <portlet:param name="mvcPath" value="/employees/employees.jsp"></portlet:param>
</portlet:renderURL>
<portlet:actionURL name="updateEmployee" var="updateEmplURL">
	<portlet:param name="employeeId" value="<%=String.valueOf(id) %>"></portlet:param>
</portlet:actionURL>

<liferay-ui:header title="Изменение данных сотрудника"></liferay-ui:header>

<aui:form action="<%= updateEmplURL %>" name="editEmployeeForm">
	<aui:fieldset>		
		<aui:input value="<%= employee.getLastname() %>" name="lastname" label="Фамилия">
			<aui:validator errorMessage="Обязательное поле" name="required"></aui:validator>			
			<aui:validator errorMessage="Длина поля должна быть меньше 100 символов" name="maxLength">100</aui:validator>
		</aui:input>
		<aui:input value="<%= employee.getName() %>" type="text" name="name" label="Имя">
			<aui:validator errorMessage="Обязательное поле" name="required"></aui:validator>
			<aui:validator errorMessage="Длина поля должна быть меньше 100 символов" name="maxLength">100</aui:validator>
		</aui:input>
		<aui:input value="<%= employee.getMidname() %>" name="midname" label="Отчество">
			<aui:validator errorMessage="Длина поля должна быть меньше 100 символов" name="maxLength">100</aui:validator>
		</aui:input>
		<aui:input name="birthdate" label="Дата рождения" type="date" value="<%= dateFormat.format(employee.getBirthdate())%>">
			<aui:validator errorMessage="Обязательное поле" name="required"></aui:validator>
		</aui:input>		
		<aui:select name="sex" label="Пол">			
			<aui:option value="false" label="Мужчина"></aui:option>
			<aui:option value="true" label="Женщина"></aui:option>
		</aui:select>

		<aui:select name="position" label="Должность">
			<c:forEach items="<%= positions %>" var="pos">			
				<aui:option selected="${ empl_pos_id == pos.getPosition_id() }" value="${ pos.getPosition_id() }">${ pos.getName() }</aui:option>				
			</c:forEach>
		</aui:select>
		<aui:select size="<%= electrotypes.size() %>" multiple="true" name="electrotypes" label="Категории товаров">
			<aui:validator name="required"></aui:validator>
			<c:forEach items="<%= electrotypes %>" var="etype">
				<aui:option selected="${ selectedTypes.contains(etype.getElectrotype_id()) }" value="${ etype.getElectrotype_id() }">${ etype.getName() }</aui:option>				
			</c:forEach>
		</aui:select>
	</aui:fieldset>	
	<aui:button-row>
		<aui:button value="Обновить информацию" type="submit"></aui:button>
		<aui:button type="cancel" onClick="${ backURL }" value="Назад"></aui:button>
	</aui:button-row>
</aui:form>