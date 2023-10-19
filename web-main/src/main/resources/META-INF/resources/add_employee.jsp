<%@ include file="init.jsp" %>

<portlet:renderURL var="viewURL">
    <portlet:param name="mvcPath" value="/view.jsp"></portlet:param>
</portlet:renderURL>
<portlet:actionURL name="addEmployee" var="addEmplURL"></portlet:actionURL>
<aui:form action="<%= addEmplURL %>" name="addEmployeeForm">
	<aui:input type="text" name="name" label="Имя"></aui:input>
	<aui:input name="lastname" label="Фамилия"></aui:input>
	<aui:input name="midname" label="Отчество"></aui:input>
	<liferay-ui:input-date name="birthdate"></liferay-ui:input-date>
	<aui:select name="sex" label="Пол">
		<aui:option label="Мужчина"></aui:option>
		<aui:option label="Женщина"></aui:option>
	</aui:select>
	<aui:button-row>
		<aui:button value="Добавить" type="submit"></aui:button>
		<aui:button type="cancel" onClick="<%= viewURL.toString() %>" value="Назад"></aui:button>
	</aui:button-row>
</aui:form>