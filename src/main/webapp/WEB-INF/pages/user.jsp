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
    <div class="container text-center">
    <c:if test="${pageContext.request.isUserInRole('WRITE_USERS')}">
        <a class="btn btn-primary btn-lg" href="${pageContext.request.contextPath}/AddUser">Add User</a>
    </c:if>
    <c:forEach var="user" items="${users}">
        <div class="row">
            <div class="col">
                    ${user.username}
            </div>
            <div class="col">
                    ${user.email}
            </div>
<%--            <div class="col">--%>
<%--                    ${car.ownerName}--%>
<%--            </div>--%>
        </div>
    </c:forEach>
</t:pageTemplate>
