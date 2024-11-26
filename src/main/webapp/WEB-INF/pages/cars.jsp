<%--
  Created by IntelliJ IDEA.
  User: Pavel
  Date: 11/5/2024
  Time: 8:45 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:pageTemplate pageTitle="Cars">
    <h1>CARS IN THE PARKIING LOT</h1>
    <a class="btn btn-primary btn-lg" href="${pageContext.request.contextPath}/AddCar">Add Car</a>
    <div class="container text-center">

        <c:forEach var="car" items="${cars}">
            <div class="row">
                <div class="col">
                    ${car.licensePlate}
                </div>
                <div class="col">
                        ${car.parkingSpot}
                </div>
                <div class="col">
                        ${car.ownerName}
                </div>
                <div class="col">
                    <a class="btn btn-secondary" href="${pageContext.request.contextPath}/EditCar?id=${car.id}">Edit Car</a>
                </div>
            </div>

        </c:forEach>

<%--        <div class="row">--%>
<%--            <div class="col">--%>
<%--                Car 1--%>
<%--            </div>--%>
<%--            <div class="col">--%>
<%--                Spot 1--%>
<%--            </div>--%>
<%--            <div class="col">--%>
<%--                User 1--%>
<%--            </div>--%>
<%--        </div>--%>
<%--        <div class="row">--%>
<%--            <div class="col">--%>
<%--                Car 2--%>
<%--            </div>--%>
<%--            <div class="col">--%>
<%--                Spot 2--%>
<%--            </div>--%>
<%--            <div class="col">--%>
<%--                User 2--%>
<%--            </div>--%>
<%--        </div>--%>
<%--        <div class="row">--%>
<%--            <div class="col">--%>
<%--                Car 3--%>
<%--            </div>--%>
<%--            <div class="col">--%>
<%--                Spot 3--%>
<%--            </div>--%>
<%--            <div class="col">--%>
<%--                User 3--%>
<%--            </div>--%>
<%--        </div>--%>
    </div>
    <h5>Free parking spots: ${numberOfFreeParkingSpots}</h5>
</t:pageTemplate>
