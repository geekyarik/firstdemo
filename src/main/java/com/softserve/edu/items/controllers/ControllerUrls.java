package com.softserve.edu.items.controllers;

public enum ControllerUrls {
    ROOT_SERVLET("/"), // Get
    LOGIN_SERVLET("/login"), // Get // Post login+password
    LOGOUT_SERVLET("/logout"), // Post
    //
    ALL_USERS_SERVLET("/allusers"), // Post?
    USER_CREATE_SERVLET("/usercreate"), // Get?
    USER_EDIT_SERVLET("/useredit"), // Post
    USER_UPDATE_SERVLET("/userupdate"), // Post
    //
    ALL_CARS_SERVLET("allcars"), USER_CARS_SERVLET("/useritems"), // Post // and pagination
    CAR_CREATE_SERVLET("/itemcreate"), // Post
    CAR_EDIT_SERVLET("/itemedit"), // Post
    CAR_UPDATE_SERVLET("/itemupdate"), // Post
    // CAR_CANCEL_SERVLET("/itemcancel"), // Post
    //
    CAR_DELETE_SERVLET("/itemdelete"), // Post
    //
    CARS_COUNT_SERVLET("/carscount"), // Post
    USERS_COUNT_SERVLET("/userscount");
    //
    private String url;

    private ControllerUrls(String url) {
	this.url = url;
    }

    @Override
    public String toString() {
	return url;
    }
}
