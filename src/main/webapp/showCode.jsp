<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Showing code for ${param.page}</title>
</head>
<body>
	<b>${param.page}</b> printed XML with &lt;c:out&gt; to scape HTML
	characters and print the page with the right format.
	<br/>
	<p>
		<%-- Declaring scapeXml attribute explicitly(default is true) --%>
		<c:out value="${fileContent}" escapeXml="true">No JSP selected</c:out>
	</p>
</body>
</html>
