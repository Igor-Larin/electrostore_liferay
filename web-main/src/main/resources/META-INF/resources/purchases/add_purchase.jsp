<%@ include file="../init.jsp" %>

<%
	long electroid = ParamUtil.getLong(renderRequest, "electronicId");
	Electronic electronic = ElectronicLocalServiceUtil.getElectronic(electroid);
	List<PurchaseType> types = PurchaseTypeLocalServiceUtil.getPurchaseTypes(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	List<Employee> employees = EmployeeLocalServiceUtil.getEmployeesByElectroType(electronic.getElectrotype_id());
%>

<portlet:renderURL var="backURL">
    <portlet:param name="mvcPath" value="/electronics/electronics.jsp"></portlet:param>
</portlet:renderURL>
<portlet:actionURL name="addPurchase" var="addPurchaseURL">
	<portlet:param name="electronicId" value="<%= String.valueOf(electroid) %>"></portlet:param>
</portlet:actionURL>

<liferay-ui:header title="<%= "Оформление продажи товара: " + electronic.getName() %>"></liferay-ui:header>

<aui:form action="<%= addPurchaseURL %>" name="addPurchaseForm">
	<aui:fieldset>
		<aui:input type="datetime-local" name="purchaseDate" label="Дата продажи">
			<aui:validator errorMessage="Обязательное поле" name="required"></aui:validator>
			<aui:validator errorMessage="Только прошлые даты и время" 
        name="custom">
                function (val, fieldNode, ruleValue) {
                	if(val !== '') { 	
                		var date = Date.parse(val);
                		return Date.now() - date >= 0;
                	}
				} 
        </aui:validator>
		</aui:input>
		<aui:select name="purchasetype" label="Тип оплаты">
			<aui:validator errorMessage="Обязательное поле" name="required"></aui:validator>
			<c:forEach items="<%= types %>" var="type">
				<aui:option value="${ type.getPurchasetype_id() }">${ type.getName() }</aui:option>				
			</c:forEach>
		</aui:select>
		<aui:select name="employee" label="Сотрудник">
			<aui:validator errorMessage="Обязательное поле" name="required"></aui:validator>
			<c:forEach items="<%= employees %>" var="employee">
				<aui:option value="${ employee.getEmployee_id() }">${ String.format("%s %s", employee.getName(), employee.getLastname()) }</aui:option>				
			</c:forEach>
		</aui:select>
	</aui:fieldset>	
	<aui:button-row>
		<aui:button value="Оформить" type="submit"></aui:button>
		<aui:button type="cancel" onClick="${ backURL }" value="Назад"></aui:button>
	</aui:button-row>
</aui:form>