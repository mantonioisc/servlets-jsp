<%@ tag body-content="empty" %>
<%@ attribute name="value" required="true" rtexprvalue="false"%><!-- default type String -->
<%@ attribute name="x" required="true" rtexprvalue="true" type="java.lang.Integer"%>
<%@ attribute name="y" required="true" rtexprvalue="true" type="java.lang.Integer"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<table border="1px">
	<c:forEach begin="1" end="${y}" varStatus="j">
		<tr>
			<c:forEach begin="1" end="${x}" varStatus="i">
				<td>(${i.count},${j.count}) = ${value}</td>
			</c:forEach>
		</tr>
	</c:forEach>
</table>
