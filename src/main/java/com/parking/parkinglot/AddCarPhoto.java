package com.parking.parkinglot;

import com.parking.parkinglot.common.CarDto;
import com.parking.parkinglot.ejb.CarsBean;
import jakarta.inject.Inject;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
@MultipartConfig
@WebServlet(name = "AddCarPhoto.", value = "/AddCarPhoto.")
public class AddCarPhoto extends HttpServlet {

    @Inject
    CarsBean carsBean;

    @Override
    protected void doGet (HttpServletRequest request, HttpServletResponse
            response) throws ServletException, IOException {
        Long carId = Long.parseLong(request.getParameter("id"));
        CarDto car = carsBean.findByid(carId);
        request.setAttribute("car", car);

        request.getRequestDispatcher("/addcarphoto.jsp").forward(request, response);
    }
    @Override
    protected void doPost (HttpServletRequest request, HttpServletResponse
            response) throws ServletException, IOException {
        long carId = Long.parseLong(request.getParameter("car_id"));

        Part filePart = request.getPart("file");
        String fileName = filePart.getSubmittedFileName();
        String fileType = filePart.getContentType();
        long fileSize = filePart.getSize();
        byte[] fileContent = new byte[(int) fileSize];
        filePart.getInputStream().read(fileContent);

        carsBean.addPhotoToCar(carId, fileName, fileType, fileContent);
        response.sendRedirect(request.getContextPath() + "/Cars");
    }
}