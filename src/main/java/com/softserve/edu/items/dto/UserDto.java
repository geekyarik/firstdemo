package com.softserve.edu.items.dto;

public class UserDto {

    private Long id;
    private String username;
    private String firstname;
    private String secondname;
    private String login;
    private String password;
    private String email;
    private String phone;
    private Integer isActive;
    private Integer isAdmin;

    /**
     * @param username
     * @param firstname
     * @param secondname
     * @param login
     * @param password
     * @param email
     * @param phone
     * @param isActive
     * @param isAdmin
     */
    public UserDto(Long id, String username, String firstname, String secondname, String login, String password,
	    String email, String phone, Integer isActive, Integer isAdmin) {

	this.id = id;
	this.username = username;
	this.firstname = firstname;
	this.secondname = secondname;
	this.login = login;
	this.password = password;
	this.email = email;
	this.phone = phone;
	this.isActive = isActive;
	this.isAdmin = isAdmin;
    }

    // Getters
    public Long getId() {
	return id;
    }

    public String getUsername() {
	return username;
    }

    public String getFirstname() {
	return firstname;
    }

    public String getSecondname() {
	return secondname;
    }

    public String getLogin() {
	return login;
    }

    public String getPassword() {
	return password;
    }

    public String getEmail() {
	return email;
    }

    public String getPhone() {
	return phone;
    }

    public Integer getIsActive() {
	return isActive;
    }

    public Integer getIsAdmin() {
	return isAdmin;
    }

    // Setters
    public void setId(Long id) {
	this.id = id;
    }

    public void setUsername(String username) {
	this.username = username;
    }

    public void setFirstname(String firstname) {
	this.firstname = firstname;
    }

    public void setSecondname(String secondname) {
	this.secondname = secondname;
    }

    public void setLogin(String login) {
	this.login = login;
    }

    public void setPassword(String password) {
	this.password = password;
    }

    public void setEmail(String email) {
	this.email = email;
    }

    public void setPhone(String phone) {
	this.phone = phone;
    }

    public void setIsActive(Integer isActive) {
	this.isActive = isActive;
    }

    public void setIsAdmin(Integer isAdmin) {
	this.isAdmin = isAdmin;
    }

}
