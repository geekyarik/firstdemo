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
import com.softserve.edu.items.dto.AllCarsDto;
import com.softserve.edu.items.dto.SearchStatementDto;
import com.softserve.edu.items.services.AllCarsService;

/**
 * Servlet implementation class HomeServlet
 */
@WebServlet(ControllerUrl.ALL_CARS_SERVLET)
public class AllCarsServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private AllCarsService allCarsService;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AllCarsServlet() {
	super();
	allCarsService = IocContainer.get().getAllCarsService();
	// TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {

	Integer currentPage = AllCarsDto.DEFAULT_CURRENT_PAGE;
	Integer pageOffset = AllCarsDto.DEFAULT_PAGE_OFFSET;
	SearchStatementDto ssDto;

	if (SessionManager.checkSession(request)) {

	    // Checking if user set next parameters, is not, use default
	    if (request.getParameter("currentPage") != null) {
		currentPage = Integer.parseInt(request.getParameter("currentPage"));
		if (getServletConfig().getServletContext().getAttribute("allCarsDto") != null) {
		    pageOffset = ((AllCarsDto) getServletConfig().getServletContext().getAttribute("allCarsDto"))
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
		getServletConfig().getServletContext().setAttribute("allCarsDto",
			allCarsService.getCarsDtoFromSearch(ssDto, currentPage, pageOffset));
		getServletConfig().getServletContext().getRequestDispatcher(ViewUrls.ALL_CARS_JSP.toString());

	    } else {
		// getServletConfig().getServletContext() == request ?
		// If no search statement
		getServletConfig().getServletContext().setAttribute("allCarsDto",
			allCarsService.getCarsDto(currentPage, pageOffset));
		getServletConfig().getServletContext().getRequestDispatcher(ViewUrls.ALL_CARS_JSP.toString())
			.forward(request, response);
	    }
	} else {
	    /*
	     * getServletConfig().getServletContext().setAttribute("allCarsDto",
	     * allCarsService.getCarsDto(currentPage, pageOffset));
	     * getServletConfig().getServletContext().getRequestDispatcher(ViewUrls.
	     * ALL_CARS_JSP.toString()) .forward(request, response); ;
	     */
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
	doGet(request, response);
    }

}
