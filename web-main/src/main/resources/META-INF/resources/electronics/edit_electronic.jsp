<%@ include file="../init.jsp" %>

<%
	List<ElectronicType> electrotypes = ElectronicTypeLocalServiceUtil.getElectronicTypes(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	long id = ParamUtil.getLong(renderRequest, "electronicId");
	Electronic electronic = ElectronicLocalServiceUtil.getElectronic(id);
	String name = electronic.getName();
	String description = electronic.getDescription();
	int price = electronic.getPrice();
	int count = electronic.getElectronic_count();
%>

<c:set var="electroType_id" scope="page" value="<%= electronic.getElectrotype_id() %>"/>

<portlet:renderURL var="backURL">
    <portlet:param name="mvcPath" value="/electronics/electronics.jsp"></portlet:param>
</portlet:renderURL>
<portlet:actionURL name="updateElectronic" var="updateElectronicURL">
	<portlet:param name="electronicId" value="<%= String.valueOf(id) %>"/>
</portlet:actionURL>

<liferay-ui:header title="Добавление сотрудника"></liferay-ui:header>

<aui:form action="<%= updateElectronicURL %>" name="updateElectronicForm">
	<aui:fieldset>		
		<aui:input value="<%= name %>" name="name" label="Название товара">
			<aui:validator errorMessage="Обязательное поле" name="required"></aui:validator>
			<aui:validator errorMessage="Длина поля должна быть меньше 150 символов" name="maxLength">150</aui:validator>
		</aui:input>
		<aui:select name="electrotype" label="Тип товара">
			<c:forEach items="<%= electrotypes %>" var="eltype">
				<aui:option selected="${ eltype.getElectrotype_id() == electroType_id  }" value="${ eltype.getElectrotype_id() }">${ eltype.getName() }</aui:option>				
			</c:forEach>
		</aui:select>
		<aui:input value="<%= description %>" name="description" label="Описание">
			<aui:validator errorMessage="Обязательное поле" name="required"></aui:validator>
			<aui:validator errorMessage="Длина поля должна быть меньше 5000 символов" name="maxLength">5000</aui:validator>
		</aui:input>
		<aui:input value="<%= price %>" name="price" label="Цена товара">
			<aui:validator errorMessage="Обязательное поле" name="required"></aui:validator>
			<aui:validator errorMessage="Пожалуйста испрользуйте только цифры" name="digits"></aui:validator>
			<aui:validator errorMessage="Пожалуйста число больше или равное 1" name="min">1</aui:validator>
		</aui:input>
		<aui:input value="<%= count %>" name="count" label="Количество">
			<aui:validator errorMessage="Обязательное поле" name="required"></aui:validator>
			<aui:validator errorMessage="Пожалуйста испрользуйте только цифры" name="digits"></aui:validator>
		</aui:input>						
		<aui:select name="is_present" label="Наличие на складе">
			<aui:option value="true">В наличии</aui:option>
			<aui:option value="false">Нет в наличии</aui:option>
		</aui:select>
	</aui:fieldset>	
	<aui:button-row>
		<aui:button value="Обновить" type="submit"></aui:button>
		<aui:button type="cancel" onClick="${ backURL }" value="Назад"></aui:button>
	</aui:button-row>
</aui:form>