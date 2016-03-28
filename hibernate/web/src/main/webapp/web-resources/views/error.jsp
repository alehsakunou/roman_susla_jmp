<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
		<div class="ax-panel warning">
			<div class="ax-panel-heading">
				Error
			</div>
			<div class="ax-panel-body">
				<h2><c:out value="message"/></h2>
			</div>
		</div>

		<div style="padding:10px;text-align: right;">
			<button class="ax-btn lg" onclick="location.href = '/';"><i class="axi axi-restore"></i></button>
		</div>

