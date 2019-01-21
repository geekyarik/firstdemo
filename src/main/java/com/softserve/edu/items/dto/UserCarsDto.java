package com.softserve.edu.items.dto;

import java.util.ArrayList;
import java.util.List;

public class UserCarsDto {

    public static final int DEFAULT_PAGE_OFFSET = 10; // TODO
    public static final int DEFAULT_CURRENT_PAGE = 1;
    //
    private String login;
    private List<CarDto> cars;
    private int pageCount;
    private int pageOffset;
    private int currentPage;

    public UserCarsDto(String login) {
	this.login = login;
	cars = new ArrayList<CarDto>();
	this.pageCount = cars.size() / DEFAULT_PAGE_OFFSET + 1;
	this.pageOffset = DEFAULT_PAGE_OFFSET;
	this.currentPage = DEFAULT_CURRENT_PAGE;
    }

    // Getters

    public void addCarDto(CarDto carDto) {
	this.cars.add(carDto);
	setPageCount(cars.size() / pageOffset + ((cars.size() % pageOffset) > 0 ? 1 : 0));
    }

    public int getDEFAULT_PAGE_OFFSET() {
	return DEFAULT_PAGE_OFFSET;
    }

    public String getLogin() {
	return login;
    }

    public List<CarDto> getCars() {
	return cars;
    }

    public int getPageCount() {
	return pageCount;
    }

    public int getPageOffset() {
	return pageOffset;
    }

    public int getCurrentPage() {
	return this.currentPage;
    }

    // Setters
    public void setCurrentPage(int currentPage) {
	this.currentPage = currentPage;
    }

    public void setLogin(String login) {
	this.login = login;
    }

    public void setCars(List<CarDto> cars) {
	this.cars = cars;
    }

    public void setPageCount(int pageCount) {
	this.pageCount = pageCount;
    }

    public void setPageOffset(int pageOffset) {
	this.pageOffset = pageOffset;
    }

}
