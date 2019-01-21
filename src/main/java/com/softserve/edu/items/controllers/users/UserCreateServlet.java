package com.softserve.edu.items.controllers.users;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.softserve.edu.container.IocContainer;
import com.softserve.edu.items.controllers.ControllerUrl;
import com.softserve.edu.items.dto.LoginDto;
import com.softserve.edu.items.dto.UserDto;
import com.softserve.edu.items.entity.FieldNames;
import com.softserve.edu.items.services.UserService;

/**
 * Servlet implementation class UserCreateServlet
 */
@WebServlet(ControllerUrl.USER_CREATE_SERVLET)
public class UserCreateServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UserService userService;
    private boolean isFirstUser;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserCreateServlet() {
	userService = IocContainer.get().getUserService();
	isFirstUser = true;
	// TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {

	// doPost(request, response); // Or delete method doGet
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {

	LoginDto loginDto = null;
	Long id = 0L; // TODO What value?
	String username = null;
	String firstname = null;
	String secondname = null;
	String login = null;
	String password = null;
	// String repeatPassword = null;
	String email = null;
	String phone = null;
	Integer isActive = 1;
	Integer isAdmin = 0;

	if (isFirstUser) {
	    isFirstUser = false;
	    isAdmin = 1;
	}
	/*
	 * if (request.getParameter(FieldNames.PASSWORD.toString()) != null) { password
	 * = request.getParameter(FieldNames.PASSWORD.toString()); repeatPassword =
	 * request.getParameter(FieldNames.REPEAT_PASSWORD.toString()); if
	 * (!password.equals(repeatPassword)) {
	 * request.removeAttribute(FieldNames.REPEAT_PASSWORD.toString());
	 * request.setAttribute("error", "Bad Password Confirmation");
	 * getServletConfig().getServletContext()
	 * .getRequestDispatcher(ControllerUrl.USER_CREATE_SERVLET.toString()).forward(
	 * request, response); } }
	 */
	if (request.getParameter(FieldNames.PASSWORD.toString()) != null) {
	    password = request.getParameter(FieldNames.PASSWORD.toString());
	}

	if (request.getParameter(FieldNames.USERNAME.toString()) != null) {
	    username = request.getParameter(FieldNames.USERNAME.toString());
	}

	if (request.getParameter(FieldNames.FIRSTNAME.toString()) != null) {
	    firstname = request.getParameter(FieldNames.FIRSTNAME.toString());
	}

	if (request.getParameter(FieldNames.SECONDNAME.toString()) != null) {
	    secondname = request.getParameter(FieldNames.SECONDNAME.toString());
	}

	if (request.getParameter(FieldNames.LOGIN.toString()) != null) {
	    login = request.getParameter(FieldNames.LOGIN.toString());
	}

	if (request.getParameter(FieldNames.EMAIL.toString()) != null) {
	    email = request.getParameter(FieldNames.EMAIL.toString());
	}

	if (request.getParameter(FieldNames.PHONE.toString()) != null) {
	    phone = request.getParameter(FieldNames.PHONE.toString());
	}

	userService.setUserDto(
		new UserDto(id, username, firstname, secondname, login, password, email, phone, isActive, isAdmin));

	// Create loginDto
	loginDto = new LoginDto(login, password);

	// Create session
	HttpSession session = request.getSession(true);
	session.setAttribute("loginDto", loginDto);
	session.setMaxInactiveInterval(300000);

	// Add Cookie
	Cookie cookie = new Cookie("id_session", session.getId());
	response.addCookie(cookie);

	// Redirection on all cars page
	getServletConfig().getServletContext().getRequestDispatcher(ControllerUrl.ALL_CARS_SERVLET.toString())
		.forward(request, response);
    }

}
