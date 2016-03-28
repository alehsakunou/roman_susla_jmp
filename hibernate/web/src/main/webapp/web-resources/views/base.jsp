<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
		<title>Spring Social Example</title>
		<meta charset="utf-8"/>
		<meta http-equiv="X-UA-Compatible" content="IE=edge"/>
		<meta name="viewport" content="width=device-width, initial-scale=1"/>

</head>
<body>
	<div class="container">
		<div class="ax-sample-header">
			<div class="ax-logo"></div>
			<h1 class="ax info">AXISJ SAMPLE CODES</h1>
		</div>

		<jsp:include page="${partial}" />
	</div>
</body>
</html>