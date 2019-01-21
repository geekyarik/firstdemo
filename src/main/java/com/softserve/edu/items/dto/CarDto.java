package com.softserve.edu.items.dto;

/**
 * **DTO for Home page with list of all cars DTO for car objects
 * 
 * @author y3809
 *
 */
public class CarDto {

    private Long id;
    private String brand;
    private String model;
    private String gearBox;
    private String details;
    private Long idUser;
    private Integer engineCapacity;
    private Integer year;
    private Integer mileage;
    private Integer price;

    /**
     * @param brand
     * @param model
     * @param gearBox
     * @param details
     * @param idUser
     * @param engineCapacity
     * @param year
     * @param mileage
     * @param price
     */
    public CarDto(Long id, String brand, String model, String gearBox, String details, Long idUser,
	    Integer engineCapacity, Integer year, Integer mileage, Integer price) {
	this.id = id;
	this.brand = brand;
	this.model = model;
	this.gearBox = gearBox;
	this.details = details;
	this.idUser = idUser;
	this.engineCapacity = engineCapacity;
	this.year = year;
	this.mileage = mileage;
	this.price = price;
    }

    public Long getId() {
	return id;
    }

    public Long getIdItem() {
	return id;
    }

    public String getBrand() {
	return brand;
    }

    public String getModel() {
	return model;
    }

    public String getGearBox() {
	return gearBox;
    }

    public String getDetails() {
	return details;
    }

    public Long getIdUser() {
	return idUser;
    }

    public Integer getEngineCapacity() {
	return engineCapacity;
    }

    public Integer getYear() {
	return year;
    }

    public Integer getMileage() {
	return mileage;
    }

    public Integer getPrice() {
	return price;
    }

    public void setId(Long id) {
	this.id = id;
    }

    public void setBrand(String brand) {
	this.brand = brand;
    }

    public void setModel(String model) {
	this.model = model;
    }

    public void setGearBox(String gearBox) {
	this.gearBox = gearBox;
    }

    public void setDetails(String details) {
	this.details = details;
    }

    public void setIdUser(Long idUser) {
	this.idUser = idUser;
    }

    public void setEngineCapacity(Integer engineCapacity) {
	this.engineCapacity = engineCapacity;
    }

    public void setYear(Integer year) {
	this.year = year;
    }

    public void setMileage(Integer mileage) {
	this.mileage = mileage;
    }

    public void setPrice(Integer price) {
	this.price = price;
    }

}
