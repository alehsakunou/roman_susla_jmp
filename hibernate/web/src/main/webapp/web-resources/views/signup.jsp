<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
		<c:choose>
            <c:when test="${user!=null}">
                <form name="test" action="/signup" method="POST">
                			<div class="ax-panel info">
                				<div class="ax-panel-heading">
                					Sign-up
                				</div>
                				<div class="ax-panel-body">
									<div style="padding:5px;">uid</div>
                					<input class="ax-inp lg" style="width:100%;" type="text" name="uid" value="${user.uid}"
                						   required/><br/>
                					<div style="padding:5px;">email</div>
                					<input class="ax-inp lg" style="width:100%;" type="text" name="email" value="${user.email}"
                						   required/><br/>

                					<div style="padding:5px;">password</div>
                					<input class="ax-inp lg" style="width:100%;" type="password" name="password" value="" required/>

                				</div>
                			</div>

                			<div style="padding:10px;text-align: right;">
                				<input type="submit" value="Sign-up" class="ax-btn lg good"/>
                				<button type="button" class="ax-btn lg" onclick="location.href = '/';"><i class="axi axi-restore"></i>
                					Cancel
                				</button>
                			</div>

                		</form>
            </c:when>
            <c:otherwise>
                <div class="ax-panel warning">
                			<div class="ax-panel-heading">
                				Error
                			</div>
                			<div class="ax-panel-body">
                				예상치 못한 에러가 발생되었습니다. 로그를 확인해주세요.
                			</div>
                		</div>
            </c:otherwise>
        </c:choose>



