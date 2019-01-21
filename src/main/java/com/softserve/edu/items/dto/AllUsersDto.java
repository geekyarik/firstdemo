package com.softserve.edu.items.dto;

import java.util.ArrayList;
import java.util.List;

public class AllUsersDto {

    public static final int DEFAULT_PAGE_OFFSET = 10; // TODO
    public static final int DEFAULT_CURRENT_PAGE = 1;
    //

    private List<UserDto> users;
    private int pageCount;
    private int pageOffset;
    private int currentPage;

    public AllUsersDto() {
	users = new ArrayList<UserDto>();
	this.pageCount = users.size() / DEFAULT_PAGE_OFFSET + 1;
	this.pageOffset = DEFAULT_PAGE_OFFSET;
	this.currentPage = DEFAULT_CURRENT_PAGE;
    }

    // Getters
    public int getCurrentPage() {
	return currentPage;
    }

    public int getDEFAULT_CURRENT_PAGE() {
	return DEFAULT_CURRENT_PAGE;
    }

    public int getDEFAULT_PAGE_OFFSET() {
	return DEFAULT_PAGE_OFFSET;
    }

    public void addUserDto(UserDto userDto) {
	this.users.add(userDto);
    }

    public List<UserDto> getUsers() {
	return users;
    }

    public int getPageCount() {
	return pageCount;
    }

    public int getPageOffset() {
	return pageOffset;
    }

    // Setters
    public void setCurrentPage(int currentPage) {
	this.currentPage = currentPage;
    }

    public void setUsers(List<UserDto> users) {
	this.users = users;
    }

    public void setPageCount(int pageCount) {
	this.pageCount = pageCount;
    }

    public void setPageOffset(int pageOffset) {
	this.pageOffset = pageOffset;
    }

}
