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
import com.softserve.edu.items.dto.UserCarsDto;
import com.softserve.edu.items.services.UserCarsService;
import com.softserve.edu.items.services.UserService;

/**
 * Servlet implementation class UserCarsServlet
 */
@WebServlet(ControllerUrl.USER_CARS_SERVLET)
public class UserCarsServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UserCarsService userCarsService;
    private UserService userService;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserCarsServlet() {
	super();
	userCarsService = IocContainer.get().getUserCarsService();
	userService = IocContainer.get().getUserService();
	// TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	doPost(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	Integer currentPage = UserCarsDto.DEFAULT_CURRENT_PAGE;
	Integer pageOffset = UserCarsDto.DEFAULT_PAGE_OFFSET;

	LoginDto loginDto = (LoginDto) request.getSession().getAttribute("loginDto");

	if (SessionManager.checkSession(request)) {
	    if (request.getParameter("currentPage") != null) {
		currentPage = Integer.parseInt(request.getParameter("currentPage"));
		if (getServletConfig().getServletContext().getAttribute("userCarsDto") != null) {
		    pageOffset = ((UserCarsDto) getServletConfig().getServletContext().getAttribute("userCarsDto"))
			    .getPageOffset();
		}
	    } else {
		request.setAttribute("currentPage", currentPage);
	    }

	    if (request.getParameter("pageOffset") != null) {
		pageOffset = Integer.parseInt(request.getParameter("pageOffset"));
	    } else {
		request.setAttribute("pageOffset", pageOffset);
	    }

	    getServletConfig().getServletContext().setAttribute("userCarsDto",
		    userCarsService.getUserCarsDto(userService.getUserDto(loginDto), currentPage, pageOffset));
	    getServletConfig().getServletContext().getRequestDispatcher(ViewUrls.USER_CARS_JSP.toString())
		    .forward(request, response);
	} else {
	    getServletConfig().getServletContext().getRequestDispatcher(ViewUrls.LOGIN_JSP.toString());
	}
    }
}
