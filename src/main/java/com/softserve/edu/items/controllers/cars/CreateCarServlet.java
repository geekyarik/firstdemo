package com.softserve.edu.items.controllers.cars;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.softserve.edu.container.IocContainer;
import com.softserve.edu.items.controllers.ControllerUrl;
import com.softserve.edu.items.controllers.SessionManager;
import com.softserve.edu.items.controllers.ViewUrls;
import com.softserve.edu.items.dto.CarDto;
import com.softserve.edu.items.dto.LoginDto;
import com.softserve.edu.items.dto.UserDto;
import com.softserve.edu.items.entity.FieldNames;
import com.softserve.edu.items.services.CarService;
import com.softserve.edu.items.services.UserService;

/**
 * Servlet implementation class CreateCarServlet
 */
@WebServlet(ControllerUrl.CAR_CREATE_SERVLET)
public class CreateCarServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private CarService carService;
    private UserService userService;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateCarServlet() {
	carService = IocContainer.get().getCarService();
	userService = IocContainer.get().getUserService();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	if (SessionManager.checkSession(request)) {
	    doPost(request, response);
	} else {
	    getServletConfig().getServletContext().getRequestDispatcher(ViewUrls.LOGIN_JSP.toString()).forward(request,
		    response);
	}
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {

	if (SessionManager.checkSession(request)) {

	    CarDto carDto = null;
	    UserDto userDto = null;

	    String brand = null;
	    String model = null;
	    String gearbox = null;
	    String details = null;
	    Integer engineCapacity = null;
	    Integer year = null;
	    Integer mileage = null;
	    Integer price = null;

	    if (request.getParameter(FieldNames.BRAND.toString()) != null) {
		brand = request.getParameter(FieldNames.BRAND.toString());
	    }

	    if (request.getParameter(FieldNames.MODEL.toString()) != null) {
		model = request.getParameter(FieldNames.MODEL.toString());
	    }

	    if (request.getParameter(FieldNames.GEARBOX.toString()) != null) {
		gearbox = request.getParameter(FieldNames.GEARBOX.toString());
	    }

	    if (request.getParameter(FieldNames.DETAILS.toString()) != null) {
		details = request.getParameter(FieldNames.DETAILS.toString());
	    }

	    if (request.getParameter(FieldNames.ENGINE_CAPACITY.toString()) != null) {
		engineCapacity = Integer.parseInt(request.getParameter(FieldNames.ENGINE_CAPACITY.toString()));
	    }

	    if (request.getParameter(FieldNames.YEAR.toString()) != null) {
		year = Integer.parseInt(request.getParameter(FieldNames.YEAR.toString()));
	    }

	    if (request.getParameter(FieldNames.MILEAGE.toString()) != null) {
		mileage = Integer.parseInt(request.getParameter(FieldNames.MILEAGE.toString()));
	    }

	    if (request.getParameter(FieldNames.PRICE.toString()) != null) {
		price = Integer.parseInt(request.getParameter(FieldNames.PRICE.toString()));
	    }

	    userDto = userService.getUserDto((LoginDto) request.getSession().getAttribute("loginDto"));
	    carDto = new CarDto(0l, brand, model, gearbox, details, userDto.getId(), engineCapacity, year, mileage,
		    price);
	    carService.setCarDto(carDto, carDto.getIdUser());

	    getServletConfig().getServletContext().getRequestDispatcher(ViewUrls.ALL_CARS_JSP.toString())
		    .forward(request, response);
	    /*
	     * getServletConfig().getServletContext().getRequestDispatcher(ViewUrls.
	     * USER_CARS_JSP.toString()) .forward(request, response);
	     */
	} else {
	    getServletConfig().getServletContext().getRequestDispatcher(ViewUrls.LOGIN_JSP.toString()).forward(request,
		    response);
	}
    }

}
