<%@ include file="../init.jsp" %>

<%
	List<ElectronicType> electrotypes = ElectronicTypeLocalServiceUtil.getElectronicTypes(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
%>

<portlet:renderURL var="backURL">
    <portlet:param name="mvcPath" value="/electronics/electronics.jsp"></portlet:param>
</portlet:renderURL>
<portlet:actionURL name="addElectronic" var="addElectronicURL"></portlet:actionURL>

<liferay-ui:header title="Добавление сотрудника"></liferay-ui:header>

<aui:form action="<%= addElectronicURL %>" name="addElectronicForm">
	<aui:fieldset>		
		<aui:input name="name" label="Название товара"></aui:input>
		<aui:select name="electrotype" label="Тип товара">
			<c:forEach items="<%= electrotypes %>" var="eltype">
				<aui:option value="${ eltype.getElectrotype_id() }">${ eltype.getName() }</aui:option>				
			</c:forEach>
		</aui:select>
		<aui:input name="description" label="Описание"></aui:input>
		<aui:input name="price" label="Цена товара"></aui:input>
		<aui:input name="count" label="Количество"></aui:input>						
		<aui:select name="is_present" label="Наличие на складе">
			<aui:option value="true">В наличии</aui:option>
			<aui:option value="false">Нет в наличии</aui:option>
		</aui:select>
		<aui:select name="is_archive" label="Есть в продаже">
			<aui:option value="false">В продаже</aui:option>
			<aui:option value="true">Снят с продажи</aui:option>
		</aui:select>
	</aui:fieldset>	
	<aui:button-row>
		<aui:button value="Добавить" type="submit"></aui:button>
		<aui:button type="cancel" onClick="${ backURL }" value="Назад"></aui:button>
	</aui:button-row>
</aui:form>