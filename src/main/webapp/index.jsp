<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Strict//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
<body>
<h2>Hello World!</h2>
	<a href="requestDistpatcherExample.do?param1=value1&param2=value2">All values</a> 
	<br/>
	<a href="download">Readme.txt</a>
	<br/>
	<a href="code?page=index.jsp">showCode.jsp</a>
	<br/>
	<a href="dir/">This will match a entry in welcome file list(not the first one)</a>
	<br/>
	<a href="doesNotExist">A error page configured on web.xml</a>
	<br/>
	<a href="jspInitParams.jsp">Using init parameters in a JSP </a>
	<br/>
	<a href="ignoreEL.jsp">EL is ignored in this page</a>
</body>
</html>
