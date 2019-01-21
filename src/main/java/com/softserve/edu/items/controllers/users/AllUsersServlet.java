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
import com.softserve.edu.items.dto.AllCarsDto;
import com.softserve.edu.items.dto.AllUsersDto;
import com.softserve.edu.items.dto.SearchStatementDto;
import com.softserve.edu.items.services.AllUsersService;

/**
 * Servlet implementation class AllUsersServlet
 */
@WebServlet(ControllerUrl.ALL_USERS_SERVLET)
public class AllUsersServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private AllUsersService allUsersService;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AllUsersServlet() {
	super();
	allUsersService = IocContainer.get().getAllUserService();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	System.out.println("you got it");
	Integer currentPage = AllCarsDto.DEFAULT_CURRENT_PAGE;
	Integer pageOffset = AllCarsDto.DEFAULT_PAGE_OFFSET;
	SearchStatementDto ssDto;

	if (SessionManager.checkSession(request)) {

	    // Checking if user set next parameters, is not, use dafault
	    if (request.getParameter("currentPage") != null) {
		currentPage = Integer.parseInt(request.getParameter("currentPage"));
		if (getServletConfig().getServletContext().getAttribute("allUsersDto") != null) {
		    pageOffset = ((AllUsersDto) getServletConfig().getServletContext().getAttribute("allUsersDto"))
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

	    if (request.getParameter("fieldName") != null && request.getParameter("regex") != null) {
		ssDto = new SearchStatementDto(request.getParameter("fieldName"), request.getParameter("regex"));
		getServletConfig().getServletContext().setAttribute("allUsersDto",
			allUsersService.getUsersDtoFromSearch(ssDto, currentPage, pageOffset));
		getServletConfig().getServletContext().getRequestDispatcher(ViewUrls.ALL_USERS_JSP.toString())
			.forward(request, response);
	    } else {
		// getServletConfig().getServletContext() == request ?
		// If no serach statement
		getServletConfig().getServletContext().setAttribute("allUsersDto",
			allUsersService.getUsersDto(currentPage, pageOffset)); // list or dto ?
		getServletConfig().getServletContext().getRequestDispatcher(ViewUrls.ALL_USERS_JSP.toString())
			.forward(request, response);
	    }
	} else {
	    getServletConfig().getServletContext().getRequestDispatcher(ViewUrls.LOGIN_JSP.toString());
	}
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	doGet(request, response);
    }

}
