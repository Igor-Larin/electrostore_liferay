<%@ include file="init.jsp" %>

<%
	
%>

<portlet:renderURL var="backURL">
    <portlet:param name="mvcPath" value="/electronics.jsp"></portlet:param>
</portlet:renderURL>
<portlet:actionURL name="addElectronic" var="addElectronicURL"></portlet:actionURL>

<liferay-ui:header title="Добавление сотрудника"></liferay-ui:header>

<aui:form action="<%= addElectronicURL %>" name="addEmployeeForm">
	<aui:fieldset>		
		<aui:input name="name" label="Название товара"></aui:input>
		<aui:input name="price" label="Цена товара"></aui:input>
		<aui:input name="count" label="Количество"></aui:input>				
		<aui:input name="description" label="Описание"></aui:input>

		<%-- <aui:select name="position" label="Должность">
			<c:forEach items="<%= positions %>" var="pos">
				<aui:option value="${ pos.getPosition_id() }">${ pos.getName() }</aui:option>				
			</c:forEach>
		</aui:select> --%>
	</aui:fieldset>	
	<aui:button-row>
		<aui:button value="Добавить" type="submit"></aui:button>
		<aui:button type="cancel" onClick="${ backURL }" value="Назад"></aui:button>
	</aui:button-row>
</aui:form>