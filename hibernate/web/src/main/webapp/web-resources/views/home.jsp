<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
		<div class="ax-panel good">
			<div class="ax-panel-heading">
				Hi <c:out value="${user.uid}"/>
			</div>
			<div class="ax-panel-body">
				Email : <c:out value="${user.email}"/> <br/>
			</div>
		</div>

		<div style="padding:10px;text-align: right;">
			<button class="ax-btn lg" onclick="location.href = '/logout';"><i class="axi axi-sign-out"></i> Logout</button>
		</div>

