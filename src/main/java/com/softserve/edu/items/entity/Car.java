package com.softserve.edu.items.entity;

public class Car implements IEntity {

    public static enum CarEntityQueries {
	CREATE_DB(SqlQueries.CREATE_DB,
		"IF NOT EXISTS(SELECT * FROM SYS.databases WHERE NAME = 'CARSTORE') CREATE DATABASE CARSTORE "),
	CREATE_TABLE(SqlQueries.CREATE_TABLE, "USE CARSTORE IF NOT EXISTS (SELECT * FROM SYSOBJECTS WHERE NAME='CARS') "
		+ " CREATE TABLE CARS(id INT IDENTITY(0,1) PRIMARY KEY, "
		+ " brand VARCHAR(30), model VARCHAR(30), gearbox VARCHAR(30), details VARCHAR(30), "
		+ " id_user INT, engine_capacity INT, year INT, mileage INT, price INT, FOREIGN KEY(ID_USER) REFERENCES USERS(ID))"),
	INSERT(SqlQueries.INSERT,
		"INSERT INTO cars (brand, model, gearbox, details, id_user, engine_capacity, year, "
			+ "mileage, price) VALUES ('%s', '%s', '%s', '%s', %s, %s, %s, %s, %s);"),
	GET_BY_ID(SqlQueries.GET_BY_ID,
		"SELECT id, brand, model, gearbox, details, id_user, engine_capacity, year, "
			+ "mileage, price FROM cars WHERE id = %s;"),
	GET_BY_FIELD(SqlQueries.GET_BY_FIELD,
		"SELECT id, brand, model, gearbox, details, id_user, engine_capacity, year, "
			+ " mileage, price FROM cars WHERE %s = %s;"),
	GET_ALL(SqlQueries.GET_ALL, "USE CARSTORE SELECT * FROM CARS;"),
	UPDATE_BY_ID(SqlQueries.UPDATE_BY_ID,
		"UPDATE cars SET brand = '%s', model = '%s', "
			+ "gearbox = '%s', details = '%s', engine_capacity = %s, year = %s, "
			+ "mileage = %s, price = %s WHERE id = %s;"),
	UPDATE_BY_FIELD(SqlQueries.UPDATE_BY_FIELD, "UPDATE cars SET %s = '%s' WHERE %s = '%s';"),
	DELETE_BY_ID(SqlQueries.DELETE_BY_ID, "DELETE FROM cars WHERE id = %s;"),
	DELETE_BY_FIELD(SqlQueries.DELETE_BY_FIELD, "DELETE FROM cars WHERE %s = '%s';");

	//
	private SqlQueries sqlQuery;
	private String query;

	private CarEntityQueries(SqlQueries sqlQuery, String query) {
	    this.sqlQuery = sqlQuery;
	    this.query = query;
	}

	public SqlQueries getSqlQuery() {
	    return sqlQuery;
	}

	@Override
	public String toString() {
	    return query;
	}
    }

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

    public Car(Long id, String brand, String model, String gearBox, String details, Long idUser, Integer engineCapacity,
	    Integer year, Integer mileage, Integer price) {
	super();
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

    public String getBrand() {
	return brand;
    }

    public void setBrand(String brand) {
	this.brand = brand;
    }

    public String getModel() {
	return model;
    }

    public void setModel(String model) {
	this.model = model;
    }

    public String getGearBox() {
	return gearBox;
    }

    public void setGearBox(String gearBox) {
	this.gearBox = gearBox;
    }

    public String getDetails() {
	return details;
    }

    public void setDetails(String details) {
	this.details = details;
    }

    public Long getIdUser() {
	return idUser;
    }

    public void setIdUser(Long idUser) {
	this.idUser = idUser;
    }

    public Integer getEngineCapacity() {
	return engineCapacity;
    }

    public void setEngineCapacity(Integer engineCapacity) {
	this.engineCapacity = engineCapacity;
    }

    public Integer getYear() {
	return year;
    }

    public void setYear(Integer year) {
	this.year = year;
    }

    public Integer getMileage() {
	return mileage;
    }

    public void setMileage(Integer mileage) {
	this.mileage = mileage;
    }

    public Integer getPrice() {
	return price;
    }

    public void setPrice(Integer price) {
	this.price = price;
    }

    public void setId(Long id) {
	this.id = id;
    }

    @Override
    public Long getId() {
	return this.id;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
	return "Car [id=" + id + ", brand=" + brand + ", model=" + model + ", gearBox=" + gearBox + ", details="
		+ details + ", idUser=" + idUser + ", engineCapacity=" + engineCapacity + ", year=" + year
		+ ", mileage=" + mileage + ", price=" + price + "]";
    }

}
