<%@ include file="init.jsp" %>

<liferay-ui:header title="Визитка магазина"></liferay-ui:header>
 <p> Количество вырученных наличных денег: <%= PurchaseLocalServiceUtil.getGainByCash() %> </p> 
 <p> Количество проданной аудиотехники за последний месяц: <%= PurchaseLocalServiceUtil.getElectrotechPurchasesCount() %> </p> 
<%
	Employee bestEmployee = EmployeeLocalServiceUtil.getBestEmployeeBySmartphonesPurchases();
	List<String> bestEmployees = PositionLocalServiceUtil.getBestEmployeesByPositions();
%>
<p> Лучший сотрудник по продаже смартфонов до 10000р: <%= bestEmployee.getLastname() + " " + bestEmployee.getName() + " " + bestEmployee.getMidname() %></p>
<c:forEach items="<%= bestEmployees %>" var="empl">
	<p>${ empl }</p>
</c:forEach>