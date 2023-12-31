<%@ include file="../init.jsp" %>

<%
	List<Position> positions = PositionLocalServiceUtil.getAllPositions();
	List<ElectronicType> electrotypes = ElectronicTypeLocalServiceUtil.getElectronicTypes(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
%>

<liferay-ui:success key="addEmployeeSuccess" message="add-employee-success" />

<portlet:renderURL var="backURL">
    <portlet:param name="mvcPath" value="/employees/employees.jsp"></portlet:param>
</portlet:renderURL>
<portlet:actionURL name="addEmployee" var="addEmplURL"></portlet:actionURL>

<liferay-ui:header title="Добавление сотрудника"></liferay-ui:header>

<aui:form action="<%= addEmplURL %>" name="addEmployeeForm">
	<aui:fieldset>		
		<aui:input name="lastname" label="Фамилия">
			<aui:validator errorMessage="Обязательное поле" name="required"></aui:validator>
			<aui:validator errorMessage="Длина поля должна быть меньше 100 символов" name="maxLength">100</aui:validator>
		</aui:input>
		<aui:input type="text" name="name" label="Имя">
			<aui:validator errorMessage="Обязательное поле" name="required"></aui:validator>
			<aui:validator errorMessage="Длина поля должна быть меньше 100 символов" name="maxLength">100</aui:validator>
		</aui:input>
		<aui:input name="midname" label="Отчество">			
			<aui:validator errorMessage="Длина поля должна быть меньше 100 символов" name="maxLength">100</aui:validator>
		</aui:input>
		<aui:input name="birthdate" label="Дата рождения" type="date">
			<aui:validator errorMessage="Обязательное поле" name="required"></aui:validator>
			<aui:validator errorMessage="Только прошлые даты" 
        name="custom">
                function (val, fieldNode, ruleValue) {
                	if(val !== '') { 	
                		var date = Date.parse(val);
                		return Date.now() - date > 0;
                	}
				} 
        </aui:validator>	
		</aui:input>
		<aui:select name="sex" label="Пол">
			<aui:option value="false" label="Мужчина"></aui:option>
			<aui:option value="true" label="Женщина"></aui:option>
		</aui:select>
		<aui:select size="<%= electrotypes.size() %>" multiple="true" name="electrotypes" label="Категории товаров">
			<aui:validator errorMessage="Обязательное поле" name="required"></aui:validator>
			<c:forEach items="<%= electrotypes %>" var="etype">
				<aui:option value="${ etype.getElectrotype_id() }">${ etype.getName() }</aui:option>				
			</c:forEach>
		</aui:select>
		<aui:select name="position" label="Должность">
			<c:forEach items="<%= positions %>" var="pos">
				<aui:option value="${ pos.getPosition_id() }">${ pos.getName() }</aui:option>				
			</c:forEach>
		</aui:select>
	</aui:fieldset>	
	<aui:button-row>
		<aui:button value="Добавить" type="submit"></aui:button>
		<aui:button type="cancel" onClick="${ backURL }" value="Назад"></aui:button>
	</aui:button-row>
</aui:form>