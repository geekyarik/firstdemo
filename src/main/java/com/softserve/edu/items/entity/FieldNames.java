package com.softserve.edu.items.entity;

public enum FieldNames {

    ID("id"),
    BRAND("brand"),
    MODEL("model"),
    GEARBOX("gearbox"),
    DETAILS("details"),
    ID_USER("id_user"),
    ENGINE_CAPACITY("engineCapacity"),
    YEAR("year"),
    MILEAGE("mileage"),
    PRICE("price"),
    USERNAME("username"),
    FIRSTNAME("firstname"),
    SECONDNAME("secondname"),
    LOGIN("login"),
    PASSWORD("password"),
    REPEAT_PASSWORD("repeatPassword"),
    EMAIL("email"),
    PHONE("phone"),
    IS_ACTIVE("is_active"),
    IS_ADMIN("is_admin");
    
    private String name;

    private FieldNames(String name) {
	    this.name = name;
    }

    @Override
    public String toString() {
	return name;
    }
}
