<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

		<div id="header">
			<h1><a th:href="@{/}">Spring Social Showcase</a></h1>
		</div>
		
		<div id="leftNav">
			Left nav menu
		</div>
		
		<div id="content" layout:fragment="content">
			<h3>Your GitHub Connections</h3>
			
			<p>First degree count: <span th:text="${firstDegreeCount}">first degree count</span></p>
			<p>Second degree count: <span th:text="${secondDegreeCount}">second degree count</span></p>
			
			<ul class="friends">
				<li th:each="connection : ${connections}">
				<img th:src="${connection.profilePictureUrl}" align="middle"/><span th:text="${connection.firstName}"></span> <span th:text="${connection.lastName}"></span></li>
			</ul>
		</div>
