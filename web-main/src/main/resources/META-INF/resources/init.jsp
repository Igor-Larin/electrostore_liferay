<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %><%@
taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %><%@
taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %><%@
taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="electrostore.db.model.Employee" %>
<%@page import="electrostore.db.model.Position"%>
<%@page import="electrostore.db.model.Electronic"%>
<%@page import="electrostore.db.service.ElectronicLocalServiceUtil"%>
<%@page import="electrostore.db.service.PositionLocalServiceUtil"%>
<%@page import="electrostore.db.service.EmployeeLocalServiceUtil" %>
<%@page import="java.util.List"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="java.time.ZoneId"%>
<%@page import="java.time.LocalDate"%>

<liferay-theme:defineObjects />

<portlet:defineObjects />