<%@ include file="init.jsp" %>

<portlet:renderURL var="allEmployeesURL">
	<portlet:param name="mvcRenderCommandName" value="/employees"/>
	<portlet:param name="mvcPath" value="/employees/employees.jsp"/>
</portlet:renderURL>
<portlet:renderURL var="allElectronicsURL">
	<portlet:param name="mvcPath" value="/electronics/electronics.jsp"/>
</portlet:renderURL>
<portlet:renderURL var="allPurchasesURL">
	<portlet:param name="mvcPath" value="/purchases/purchases.jsp"/>
</portlet:renderURL>
<portlet:renderURL var="loadingPageURL">
	<portlet:param name="mvcPath" value="/loadingPage.jsp"/>
</portlet:renderURL>

<liferay-ui:header title="Информация о магазине электротоваров"></liferay-ui:header>
<aui:button-row>
	<aui:button onClick="${ allEmployeesURL }" value="Сотрудники"></aui:button>
	<aui:button onClick="${ allElectronicsURL }" value="Товары"></aui:button>
	<aui:button onClick="${ allPurchasesURL }" value="Продажи"></aui:button>
	<aui:button onClick="${ loadingPageURL }" value="Загрузка данных"></aui:button>
</aui:button-row>
