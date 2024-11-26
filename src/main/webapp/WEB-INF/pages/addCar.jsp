<%--
  Created by IntelliJ IDEA.
  User: Pavel
  Date: 11/26/2024
  Time: 8:17 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<t:pageTemplate pageTitle="AddCar">
    <h1>park your Car</h1>
    <div class="col-md-7 col-lg-8">
    <h4 class="mb-3">Park your Car</h4>
    <form class="needs-validation" novalidate method="POST" action="${pageContext.request.contextPath}/AddCar">
    <div class="row g-3">
    <div class="col-sm-6">
        <label for="license_plate" class="form-label">Licens plate</label>
        <input type="text" class="form-control" id="license_plate" name="license_plate" placeholder="" value="" required>
        <div class="invalid-feedback">
            Valid license plate is required.
        </div>
    </div>

    <div class="col-sm-6">
        <label for="parking_spot" class="form-label">Parking Spot</label>
        <input type="text" class="form-control" id="parking_spot" name="parking_spot" placeholder="" value="" required>
        <div class="invalid-feedback">
            Valid spot is required.
        </div>
    </div>

        <div class="col-md-5">
            <label for="owner_id" class="form-label">Owner_Id</label>
            <select class="form-select" id="owner_id" name="owner_id" required>
                <option value="">Choose...</option>
                <c:forEach var="user" items="${users}" varStatus="status">
                    <option value="${user.id}">
                        ${user.username}
                    </option>
                </c:forEach>
            </select>
            <div class="invalid-feedback">
                Please select a valid Id.
            </div>
        </div>
        <button type="submit" class="btn btn-primary btn-lg">Submit</button>
    </div>
</t:pageTemplate>
