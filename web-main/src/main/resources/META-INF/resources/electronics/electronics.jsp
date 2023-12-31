<%@ include file="../init.jsp" %>

<portlet:renderURL var="addEmployeeURL">
	<portlet:param name="mvcPath" value="/electronics/add_electronic.jsp"/>
</portlet:renderURL>
<portlet:renderURL var="mainPageURL">
	<portlet:param name="mvcPath" value="/view.jsp"/>
</portlet:renderURL>
<liferay-portlet:renderURL varImpl="iteratorURL">
	<portlet:param name="mvcPath" value="/electronics/electronics.jsp" />
</liferay-portlet:renderURL>
<liferay-ui:header title="Список электротоваров"></liferay-ui:header>

<aui:button-row>
	<aui:button onClick="${ addEmployeeURL }" value="Добавить товар"></aui:button>
	<aui:button onClick="${ mainPageURL }" value="Главная страница"></aui:button>
</aui:button-row>
<liferay-ui:search-container iteratorURL="<%= iteratorURL %>" emptyResultsMessage="Список товаров пуст" total="<%= ElectronicLocalServiceUtil.getElectronicsCount() %>">
	<liferay-ui:search-container-results results="<%= ElectronicLocalServiceUtil.getElectronics(searchContainer.getStart(), searchContainer.getEnd()) %>"></liferay-ui:search-container-results>
	<liferay-ui:search-container-row className="electrostore.db.model.Electronic" modelVar="electronic">
		<portlet:actionURL name="deleteElectronic" var="deleteElectronicURL">
			<portlet:param name="electronicId" value="<%= String.valueOf(electronic.getElectronic_id()) %>"></portlet:param>
		</portlet:actionURL>
		<portlet:renderURL var="editElectronicURL">
			<portlet:param name="mvcPath" value="/electronics/edit_electronic.jsp"/>
			<portlet:param name="electronicId" value="<%= String.valueOf(electronic.getElectronic_id()) %>"></portlet:param>
		</portlet:renderURL>
		<portlet:renderURL var="addPurchaseURL">
			<portlet:param name="mvcPath" value="/purchases/add_purchase.jsp"/>
			<portlet:param name="electronicId" value="<%= String.valueOf(electronic.getElectronic_id()) %>"></portlet:param>
		</portlet:renderURL>
		<liferay-ui:search-container-column-text name="Название" property="name"></liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-text name="Тип товара" value="<%= ElectronicTypeLocalServiceUtil.getElectronicType(electronic.getElectrotype_id()).getName() %>">></liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-text name="Цена, руб" value="<%= String.valueOf(electronic.getPrice() / 100) %>"></liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-text name="Количество" property="electronic_count"></liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-text name="Наличие на складе" value="<%= electronic.getIs_present() ? "Есть на складе" : "Нет на складе" %>"> </liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-text name="В продаже" value="<%= electronic.getIs_archive() ? "Снят с продажи" : "В продаже" %>"></liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-text name="Описание" property="description"></liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-text>
		<c:if test="${ !electronic.getIs_archive() }">
			<aui:button onClick="${ addPurchaseURL }" value="Оформить продажу"></aui:button>
		</c:if>
		<aui:button onClick="${ editElectronicURL }" value="Изменить"></aui:button>
		<aui:button onClick="${ deleteElectronicURL }" value="Удалить"></aui:button>				
		</liferay-ui:search-container-column-text>
	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator searchContainer="<%= searchContainer %>"></liferay-ui:search-iterator>
</liferay-ui:search-container>