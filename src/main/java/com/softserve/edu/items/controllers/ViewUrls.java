package com.softserve.edu.items.controllers;

public enum ViewUrls {
    LOGIN_JSP("/WEB-INF/views/users/Login.jsp"), 
    REGISTRATION_JSP("/WEB-INF/views/users/Registration.jsp"),
    USER_PROFILE_JSP("/WEB-INF/views/users/UserProfile.jsp"), 
    CAR_PROFILE_JSP("/WEB-INF/views/cars/CarProfile.jsp"),
    CAR_SUPPLY_JSP("/WEB-INF/views/cars/CarSupply.jsp"), 
    USER_CARS_JSP("/WEB-INF/views/commons/UserCars.jsp"),
    ALL_CARS_JSP("/WEB-INF/views/cars/AllCars.jsp"), 
    ALL_USERS_JSP("/WEB-INF/views/users/AllUsers.jsp"),
    ERROR_JSP("/WEB-INF/views/commons/Error.jsp");
    //
    private String url;

    private ViewUrls(String url) {
	this.url = url;
    }

    @Override
    public String toString() {
	return url;
    }
}
