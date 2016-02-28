<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>CARTIER API JSP</title>
</head>
<Body>


<form name="EventForm" action="../saveFile.do" method="post" enctype="multipart/form-data">
		<h2>API saveFile</h2>
		saveFile:<input type="file" id="icon" name="fileName">
		<input type="submit" style="width: 200px" value="saveFile"/>
</form>
</BODY>
</html>