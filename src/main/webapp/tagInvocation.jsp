<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="mine" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Custom tag invocations</title>
</head>
<body>
	<b>Calling a tag file with empty body and 3 required parameters:</b> <br/>
	<mine:iterator value="Hi" y="3" x="5"></mine:iterator>
	<br/>
	
	<b>Including a tag with a body that displays a simple letter(no passing optional parameter):</b><br/>
	<p>
		<mine:myTag name="Gillian Seed">
		Welcome to the Junker HQ. 
		Please met with Harry to get your Metal Gear navigational unit
		and your brand new Junker Eye System.
		</mine:myTag>
	</p>
	
	<b>Now calling the same tag passing the optional parameter:</b><br/>
	<p>
		<mine:myTag name="Solid Snake" title="Shadow Moses briefing">
			The insurrection group is formed by the High Tech Special Operation Forces 
			Fox Hound, and you have two main mission objectives: locate and rescue the 
			president of Arms Tech Kenneth Baker and the DARPA Chief Donald Anderson. 
			And determinate of the terrorists have the ability to launch a nuclear 
			strike and stop them if you have to.
		</mine:myTag>
	</p>
</body>
</html>