<%@ include file="init.jsp" %>

<%
	List<Position> positions = PositionLocalServiceUtil.getAllPositions();
%>

<portlet:renderURL var="backURL">
    <portlet:param name="mvcPath" value="/employees.jsp"></portlet:param>
</portlet:renderURL>
<portlet:actionURL name="addEmployee" var="addEmplURL"></portlet:actionURL>

<liferay-ui:header title="Добавление сотрудника"></liferay-ui:header>

<aui:form action="<%= addEmplURL %>" name="addEmployeeForm">
	<aui:fieldset>		
		<aui:input name="lastname" label="Фамилия"></aui:input>
		<aui:input type="text" name="name" label="Имя"></aui:input>
		<aui:input name="midname" label="Отчество"></aui:input>
		<label>
			Дата рождения
			<liferay-ui:input-date dayValue="1" monthValue="0" yearValue="1950" formName="addEmployeeForm" name="birthdate"></liferay-ui:input-date>
		</label>
		<aui:select name="sex" label="Пол">
			<aui:option value="false" label="Мужчина"></aui:option>
			<aui:option value="true" label="Женщина"></aui:option>
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