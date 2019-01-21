package com.softserve.edu.items.controllers.users;

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
import com.softserve.edu.items.dto.LoginDto;
import com.softserve.edu.items.dto.UserDto;
import com.softserve.edu.items.entity.FieldNames;
import com.softserve.edu.items.services.UserService;

/**
 * Servlet implementation class UserProfileServlet
 */
@WebServlet(ControllerUrl.USER_EDIT_SERVLET)
public class UserProfileServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UserService userService;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserProfileServlet() {
	userService = IocContainer.get().getUserService();
	// TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    /*
     * protected void doGet(HttpServletRequest request, HttpServletResponse
     * response) throws ServletException, IOException { doPost(request, response);
     * /* LoginDto loginDto; UserDto userDto; System.out.println("in edit get"); if
     * (SessionManager.checkSession(request)) { loginDto = (LoginDto)
     * request.getSession().getAttribute("loginDto"); userDto =
     * userService.getUserDto(loginDto); request.setAttribute("userDto", userDto);
     * 
     * } else {
     * getServletConfig().getServletContext().getRequestDispatcher(ViewUrls.
     * LOGIN_JSP.toString()).forward(request, response); ; }
     */
//    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    @SuppressWarnings("unused")
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	// TODO Auto-generated method stub
	// System.out.println("in edit post");
	LoginDto loginDto;
	UserDto userDto;
	String username = null;
	String firstname = null;
	String secondname = null;
	// String login = null;
	String password = null;
	String repeatPassword = null;
	String email = null;
	String phone = null;

	if (SessionManager.checkSession(request)) {
	    /*
	     * loginDto = (LoginDto) request.getSession().getAttribute("loginDto"); userDto
	     * = userService.getUserDto(loginDto); request.setAttribute("userDto", userDto);
	     */
	    userDto = (UserDto) request.getSession().getAttribute("userDto");

	    if (request.getParameter(FieldNames.PASSWORD.toString()) != null
		    && request.getParameter(FieldNames.PASSWORD.toString()).length() > 0) {

		userDto.setPassword(request.getParameter(FieldNames.PASSWORD.toString()));
	    }

	    if (request.getParameter(FieldNames.USERNAME.toString()) != null
		    && request.getParameter(FieldNames.USERNAME.toString()).length() > 0) {
		userDto.setUsername(request.getParameter(FieldNames.USERNAME.toString()));
	    }

	    if (request.getParameter(FieldNames.FIRSTNAME.toString()) != null
		    && request.getParameter(FieldNames.FIRSTNAME.toString()).length() > 0) {
		userDto.setFirstname(request.getParameter(FieldNames.FIRSTNAME.toString()));
	    }

	    if (request.getParameter(FieldNames.SECONDNAME.toString()) != null
		    && request.getParameter(FieldNames.SECONDNAME.toString()).length() > 0) {
		userDto.setSecondname(request.getParameter(FieldNames.SECONDNAME.toString()));
	    }

	    if (request.getParameter(FieldNames.EMAIL.toString()) != null
		    && request.getParameter(FieldNames.EMAIL.toString()).length() > 0) {
		userDto.setEmail(request.getParameter(FieldNames.EMAIL.toString()));
	    }

	    if (request.getParameter(FieldNames.PHONE.toString()) != null
		    && request.getParameter(FieldNames.PHONE.toString()).length() > 0) {
		userDto.setPhone(request.getParameter(FieldNames.PHONE.toString()));
	    }

	    userService.setUserDto(userDto);

	    getServletConfig().getServletContext().getRequestDispatcher(ViewUrls.USER_PROFILE_JSP.toString())
		    .forward(request, response);
	} else {
	    getServletConfig().getServletContext().getRequestDispatcher(ViewUrls.LOGIN_JSP.toString());
	}

    }

}
