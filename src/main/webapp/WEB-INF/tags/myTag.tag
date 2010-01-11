<%@ tag language="java" pageEncoding="UTF-8" body-content="scriptless"%>
<%@ attribute name="name" required="true"  rtexprvalue="false" type="java.lang.String"%>
<%@ attribute name="title" required="false" rtexprvalue="false" %><!-- defaults to string -->
<%--Tag with a body --%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

Dear ${name}: <br/>
<c:if test="${not empty title}">
	Title: ${title}
</c:if>
<br/>
<p>
	<jsp:doBody/>
</p>
<br/>
Thanks...
