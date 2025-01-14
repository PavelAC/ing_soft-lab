package com.parking.parkinglot.servlets.users;

import com.parking.parkinglot.common.CarDto;
import com.parking.parkinglot.common.UserDto;
import com.parking.parkinglot.ejb.UserBean;
import jakarta.inject.Inject;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

    @WebServlet(name = "EditUser", value = "/EditUser")
public class EditUser extends HttpServlet {

        @Inject
        UserBean userBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse
            response) throws ServletException, IOException {
        List<UserDto> users = userBean.findAllUsers();
        request.setAttribute("users", users);

        request.getRequestDispatcher("/WEB-INF/pages/users/editUser.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse
            response) throws ServletException, IOException {


        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        Long userId = Long.parseLong(request.getParameter("owner_id"));

        userBean.updateUser(userId, username, email, password);
        response.sendRedirect( request.getContextPath() + "/Users");

    }
}