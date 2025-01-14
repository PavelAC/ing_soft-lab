<%--
  Created by IntelliJ IDEA.
  User: Pavel
  Date: 1/14/2025
  Time: 8:30 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<t:pageTemplate pageTitle="EditUser">
  <h1>edit your Car</h1>
  <div class="col-md-7 col-lg-8">
  <h4 class="mb-3">Edit your Profile</h4>
  <form class="needs-validation" novalidate method="POST" action="${pageContext.request.contextPath}/EditUser">
    <div class="row">
      <div class="col-md-6 mb-3">
        <label class="form-label" for="username">Username</label>
        <input type="text" class="form-control" id="username" name="username" placeholder="" value="" required>
        <div class="invalid-feedback">
          Username is required.
        </div>
      </div>
      <div class="col-md-6 mb-3">
        <label class="form-label" for="email">Email</label>
        <input type="text" class="form-control" id="email" name="email" placeholder="" value="" required>
        <div class="invalid-feedback">
          Email is required.
        </div>
      </div>
      <div class="col-md-6 mb-3">
        <label class="form-label" for="password">Password</label>
        <input type="password" class="form-control" id="password" name="password" placeholder="" value="">
      </div>
      <div class="col-md-6 mb-3">
        <label class="form-label" for="user_groups">Groups</label>
        <select class="form-select" id="user_groups" name="user_groups" multiple>
          <option value="">Choose...</option>
          <c:forEach var="user_group" items="${userGroups}" varStatus="status">
            <option value="${user_group}">${user_group}</option>
          </c:forEach>
        </select>
        <div class="invalid-feedback">
          Please select a group.
        </div>
      </div>
      <button type="submit" class="btn btn-primary">Submit</button>
    </div>
  </form>
</t:pageTemplate>
