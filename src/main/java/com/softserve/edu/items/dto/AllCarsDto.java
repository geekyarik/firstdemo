package com.softserve.edu.items.dto;

import java.util.ArrayList;
import java.util.List;

public class AllCarsDto {

    public static final int DEFAULT_PAGE_OFFSET = 10; // TODO
    public static final int DEFAULT_CURRENT_PAGE = 1;
    //

    private List<CarDto> cars;
    private int pageCount; // count of all pages
    private int pageOffset; // count of items on one page
    private int currentPage; // number of current page

    public AllCarsDto() {
	cars = new ArrayList<CarDto>();
	this.pageCount = cars.size() / DEFAULT_PAGE_OFFSET + 1;
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

    public List<CarDto> getCars() {
	return cars;
    }

    public int getPageCount() {
	return pageCount;
    }

    public int getPageOffset() {
	return pageOffset;
    }

    // Setters
    public void addCarDto(CarDto carDto) {
	this.cars.add(carDto);
    }

    public void setCurrentPage(int currentPage) {
	this.currentPage = currentPage;
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
