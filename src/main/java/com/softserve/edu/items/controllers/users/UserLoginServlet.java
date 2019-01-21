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
import com.softserve.edu.items.controllers.ViewUrls;
import com.softserve.edu.items.dto.LoginDto;
import com.softserve.edu.items.services.DatabaseService;
import com.softserve.edu.items.services.UserService;

/**
 * Servlet implementation class UserLoginServlet
 */

@WebServlet({ ControllerUrl.ROOT_SERVLET, ControllerUrl.LOGIN_SERVLET })
//@WebServlet({ "/", "/login" })
public class UserLoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UserService userService;
    private DatabaseService databaseService;
    private boolean isFirstStart;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserLoginServlet() {
	super();
	databaseService = IocContainer.get().getDatabaseService();
	userService = IocContainer.get().getUserService();
	isFirstStart = true;
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {

	if (isFirstStart) {
	    try {
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
	    } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
		e.printStackTrace();
	    }
	    /*
	     * try { DriverManager.getConnection(
	     * "jdbc:sqlserver://GEEKS-LAPTOP;integratedSecurity=true", "y3809", ""); }
	     * catch (SQLException ex) { // TODO Auto-generated catch block
	     * ex.printStackTrace(); }
	     */
	    databaseService = IocContainer.get().getDatabaseService();
	    databaseService.initDatabase();

	    isFirstStart = false;
	    request.setAttribute("loginUrl", // TODO
		    request.getRequestURL().toString());
	    getServletConfig().getServletContext().getRequestDispatcher(ViewUrls.REGISTRATION_JSP.toString()) // REGISTRATION
		    .forward(request, response);
	    // .include(request, response);
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

	// doGet(request, response);

	String login = request.getParameter("login");
	String password = request.getParameter("password");

	LoginDto loginDto = new LoginDto(login, password);

	if (userService.isValid(loginDto)) {
	    if (userService.getUserDto(loginDto).getIsActive() == 0) {
		request.setAttribute("error", "You are blocked!");
		getServletConfig().getServletContext().getRequestDispatcher(ViewUrls.LOGIN_JSP.toString())
			.forward(request, response);
	    }
	    // Create session
	    HttpSession session = request.getSession(true);
	    session.setAttribute("loginDto", loginDto);
	    session.setMaxInactiveInterval(300000);
	    session.setAttribute("userDto", userService.getUserDto(loginDto));

	    // Add Cookie
	    Cookie cookie = new Cookie("id_session", session.getId());
	    response.addCookie(cookie);

	    // Redirection on all cars page
	    // response.sendRedirect(request.getContextPath() +
	    // ControllerUrl.ALL_CARS_SERVLET);
	    getServletConfig().getServletContext().getRequestDispatcher(ControllerUrl.ALL_CARS_SERVLET.toString())
		    .forward(request, response);
	} else {

	    // Show Error Validator
	    request.setAttribute("error", "Bad Login or Password");
	    getServletConfig().getServletContext().getRequestDispatcher(ViewUrls.LOGIN_JSP.toString()).forward(request,
		    response);
	}
    }

}
