<%@ include file="init.jsp" %>

<portlet:renderURL var="addEmployeeURL">
	<portlet:param name="mvcPath" value="/add_electronic.jsp"/>
</portlet:renderURL>
<portlet:renderURL var="mainPageURL">
	<portlet:param name="mvcPath" value="/view.jsp"/>
</portlet:renderURL>

<liferay-ui:header title="Список электротоваров"></liferay-ui:header>

<aui:button-row>
	<aui:button onClick="${ addEmployeeURL }" value="Добавить товар"></aui:button>
	<aui:button onClick="${ mainPageURL }" value="Главная страница"></aui:button>
</aui:button-row>
<liferay-ui:search-container emptyResultsMessage="Список товаров пуст" total="<%= ElectronicLocalServiceUtil.getElectronicsCount() %>">
	<liferay-ui:search-container-results results="<%= ElectronicLocalServiceUtil.getElectronics(searchContainer.getStart(), searchContainer.getEnd()) %>"></liferay-ui:search-container-results>
	<liferay-ui:search-container-row className="electrostore.db.model.Electronic" modelVar="electronic">
		<portlet:actionURL name="deleteElectronic" var="deleteElectronicURL">
			<portlet:param name="electronicId" value="<%= String.valueOf(electronic.getElectronic_id()) %>"></portlet:param>
		</portlet:actionURL>
		<portlet:renderURL var="editElectronicURL">
			<portlet:param name="mvcPath" value="/edit_electronic.jsp"/>
			<portlet:param name="electronicId" value="<%= String.valueOf(electronic.getElectronic_id()) %>"></portlet:param>
		</portlet:renderURL>
		<liferay-ui:search-container-column-text name="Название" property="name"></liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-text name="Тип товара" value="Будет позже"></liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-text name="Цена" property="price"></liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-text name="Количество" property="electronic_count"></liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-text name="Наличие на складе"> </liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-text name="В продаже" value="В продаже"></liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-text name="Описание" property="description"></liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-text>
			<aui:button-row>
			<aui:button onClick="${ editElectronicURL }" value="Изменить"></aui:button>
			<aui:button onClick="${ deleteElectronicURL }" value="Удалить"></aui:button>
			</aui:button-row>				
			
		</liferay-ui:search-container-column-text>
	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator></liferay-ui:search-iterator>
</liferay-ui:search-container>