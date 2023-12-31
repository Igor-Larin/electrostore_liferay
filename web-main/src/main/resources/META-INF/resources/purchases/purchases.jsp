<%@ include file="../init.jsp" %>

<%
	DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm");
	String order = ParamUtil.getString(renderRequest, "orderByType");
	if(order.isBlank())
		order = "none";
%>

<portlet:renderURL var="mainPageURL">
	<portlet:param name="mvcPath" value="/view.jsp"/>
</portlet:renderURL>
<liferay-portlet:renderURL varImpl="iteratorURL">
	<portlet:param name="mvcPath" value="/purchases/purchases.jsp" />
</liferay-portlet:renderURL>
<liferay-ui:header title="Продажи"></liferay-ui:header>

<aui:button-row>
	<aui:button onClick="${ mainPageURL }" value="Главная страница"></aui:button>
</aui:button-row>
<liferay-ui:search-container iteratorURL="<%= iteratorURL %>" emptyResultsMessage="Продаж нет" total="<%= PurchaseLocalServiceUtil.getPurchasesCount() %>">
	<liferay-ui:search-container-results results="<%= PurchaseLocalServiceUtil.getPurchasesByOrder(searchContainer.getStart(), searchContainer.getEnd(), order) %>"></liferay-ui:search-container-results>
	<liferay-ui:search-container-row className="electrostore.db.model.Purchase" modelVar="purchase">
		<portlet:actionURL name="deletePurchase" var="deletePurchaseURL">
			<portlet:param name="purchaseId" value="<%= String.valueOf(purchase.getPurchase_id()) %>"></portlet:param>
			<portlet:param name="orderByType" value="<%= order %>"></portlet:param>
		</portlet:actionURL>
		<portlet:renderURL var="editPurchaseURL">
			<portlet:param name="mvcPath" value="/purchases/edit_purchase.jsp"/>
			<portlet:param name="purchaseId" value="<%= String.valueOf(purchase.getPurchase_id()) %>"></portlet:param>
		</portlet:renderURL>				
		<%
			Employee employee = EmployeeLocalServiceUtil.getEmployee(purchase.getEmployee_id());
			Electronic electronic = ElectronicLocalServiceUtil.getElectronic(purchase.getElectronic_id());
		%>
		<liferay-ui:search-container-column-text name="Название товара" value="<%= electronic.getName() %>"></liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-text name="Цена товара" value="<%= String.valueOf(electronic.getPrice() / 100) %>"></liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-text name="Тип товара" value="<%= ElectronicTypeLocalServiceUtil.getElectronicType(electronic.getElectrotype_id()).getName() %>"></liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-text name="Сотрудник" value="<%= employee.getName() + " " + employee.getLastname() %>">></liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-text orderable="true" name="Время покупки" value="<%= dateFormat.format(purchase.getPurchase_date()) %>">></liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-text name="Тип оплаты" value="<%= PurchaseTypeLocalServiceUtil.getPurchaseType(purchase.getPurchasetype_id()).getName() %>"></liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-text>
			<aui:button onClick="${ deletePurchaseURL }" value="Удалить">
			</aui:button>				
		</liferay-ui:search-container-column-text>		
	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator searchContainer="<%= searchContainer %>"></liferay-ui:search-iterator>
</liferay-ui:search-container>