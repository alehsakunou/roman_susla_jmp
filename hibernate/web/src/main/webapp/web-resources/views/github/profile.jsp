<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

		<div id="header">
			<h1><a th:href="@{/}">Spring Social Showcase</a></h1>
		</div>
		
		<div id="leftNav">
			Left nav menu
		</div>
		
		<div id="content" layout:fragment="content">
			<h3>Your GitHub Profile</h3>
			
			<p>Hello, <span th:text="${profile.firstName}">first name</span>!</p>
			<img th:src="${profile.profilePictureUrl}"/>
			<dl>
				<dt>GitHub ID:</dt>
				<dd><a th:href="${profile.publicProfileUrl}" target="_blank" th:text="${profile.id}">profile id</a></dd>
				<dt>Email Address:</dt>
				<dd th:text="${profile.emailAddress}"></dd>
				<dt>Headline:</dt>
				<dd th:text="${profile.headline}"></dd>
				<dt>Industry:</dt>
				<dd th:text="${profile.industry}"></dd>
				<dt>Summary:</dt>
				<dd th:text="${profile.summary}"></dd>
			</dl>
			
			<form id="disconnect" th:action="@{/connect/github}" method="post">
				<input type="hidden" name="_csrf" th:value="${_csrf.token}" />
				<button type="submit">Disconnect from GitHub</button>
				<input type="hidden" name="_method" value="delete" />
			</form>
		</div>