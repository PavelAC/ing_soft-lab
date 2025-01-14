<%--
  Created by IntelliJ IDEA.
  User: Pavel
  Date: 11/19/2024
  Time: 9:12 AM
  To change this template use File | Settings | File Templates.
--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:pageTemplate pageTitle="Users">
    <h1>USERS</h1>
    <form method="POST" action="${pageContext.request.contextPath}/Users">
    <div class="container text-center">
    <c:if test="${pageContext.request.isUserInRole('WRITE_USERS')}">
        <a class="btn btn-primary btn-lg" href="${pageContext.request.contextPath}/AddUser">Add User</a>
    </c:if>
        <c:if test="${pageContext.request.isUserInRole('INVOICING')}">
        <button class="btn btn-secondary" type="submit">Invoice</button>
        </c:if>
    <c:forEach var="user" items="${users}">
        <div class="row">
            <c:if test="${pageContext.request.isUserInRole('WRITE_USERS')}">
                <div class="col">
                    <input type="checkbox" name="user_ids" value="${user.id}">
                </div>
            </c:if>
            <div class="col">
                    ${user.username}
            </div>
            <div class="col">
                    ${user.email}
            </div>
            <c:if test="${pageContext.request.isUserInRole('WRITE_USERS')}">
                <div class="col">
                    <a class="btn btn-secondary" href="${pageContext.request.contextPath}/EditUser?id=${user.id}">Edit User</a>
                </div>
            </c:if>
        </div>
    </c:forEach>
    </form>
    <c:if test="${not empty invoices}">
        <h2>Invoices</h2>
        <c:forEach var="username" items="${invoices}" varStatus="status">
            ${status.index + 1}. ${username}
            <br/>
        </c:forEach>
    </c:if>
</t:pageTemplate>
