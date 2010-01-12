<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="mine" uri="myTags" %>
<%@ taglib prefix="crappy" uri="oldies" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Custom tags invocation</title>
</head>
<body>
	<b>This is a Simple tag invocation with two required parameters values and var</b>
	<p>
		<ol>
			<mine:loop values="${applicationScope.list}" var="value">
				<li>${value}</li>
			</mine:loop>
		</ol>
		<table border="2px">
			<mine:loop values="${applicationScope.list}" var="value">
				<tr><td>${value}</td></tr>
			</mine:loop>
		</table>
	</p>
	<b>Calling a tag with no body twice(with int argument that can use EL)</b>
	<p>
		<mine:say word="nobody" times="5"/> <br/>
		<mine:say word="no body " times="${3*3}"/>
	</p>
	
	<hr/>
	<b>Using dynamic attributes in a tag</b>
	<p>
		<mine:dynamic mgs="MGS4" castlevania="Symphony of the Night" GoW="God of War III" uncharted="Uncharted 2"/>
	</p>
	
	<hr/>
	
	<b>Now calling some old crappy tags with TagSupport</b>
	<p>
		<ul>
			<crappy:loop val="${applicationScope.list}" var="value">
				<li>${value}</li>
			</crappy:loop>
		</ul>
	</p>
	Yes they do the same
	<p>
		<crappy:say word="crappy" times="${9*2}"></crappy:say><!-- Just put and space between the tags and you are screwed -->
	</p>	
	
</body>
</html>