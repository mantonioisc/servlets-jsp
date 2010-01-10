<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Using servlet init params in a JSP</title>
</head>
<body>
	Using servlet init parameters in a JSP <br />
	
	Don't be fool, this will access context init parametes and print nothing \${initParam.title } <br />
	To access it you must access via PageContext, ServletConfig but guess what? I can't be acced by EL. <br/>
	
	Anyway you can add them with <br/>
	&lt;servlet&gt; <br/>
		&lt;servlet-name&gt;&lt;/servlet-name&gt;<br/>
		&lt;jsp-file&gt;&lt;/jsp-file&gt; <br/>
	&lt;/servlet&gt;
	
	<%=pageContext.getServletConfig().getInitParameter("title")%>
</body>
</html>