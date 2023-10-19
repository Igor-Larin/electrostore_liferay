<%@ include file="init.jsp" %>


<portlet:renderURL var="allEmployeesURL">
	<portlet:param name="mvcRenderCommandName" value="/employees"/>
	<portlet:param name="mvcPath" value="/employees.jsp"/>
</portlet:renderURL>
<portlet:renderURL var="allElectronicsURL">
	<portlet:param name="mvcPath" value="/electronics.jsp"/>
</portlet:renderURL>
<portlet:renderURL var="allPurchasesURL">
	<portlet:param name="mvcPath" value="/purchases.jsp"/>
</portlet:renderURL>

<aui:button-row>
	<aui:button onClick="${ allEmployeesURL }" value="Сотрудки"></aui:button>
	<aui:button onClick="${ allElectronicsURL }" value="Товары"></aui:button>
	<aui:button onClick="${ allPurchasesURL }" value="Продажи"></aui:button>
</aui:button-row>
