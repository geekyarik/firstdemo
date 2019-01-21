package com.softserve.edu.items.entity;

public class User implements IEntity {

    public static enum UserEntityQueries {
	CREATE_DB(SqlQueries.CREATE_DB,
		"IF NOT EXISTS(SELECT * FROM SYS.databases WHERE NAME = 'CARSTORE') " + "CREATE DATABASE CARSTORE "),
	CREATE_TABLE(SqlQueries.CREATE_TABLE,
		"USE CARSTORE IF NOT EXISTS (SELECT * FROM SYSOBJECTS WHERE NAME='USERS') "
			+ "CREATE TABLE USERS(id INT IDENTITY(0,1) PRIMARY KEY , "
			+ "username VARCHAR(30), firstname VARCHAR(30), secondname VARCHAR(30), login VARCHAR(30) UNIQUE, "
			+ "password VARCHAR(30), email VARCHAR(30), phone VARCHAR(30), is_active BIT, is_admin BIT) "),
	INSERT(SqlQueries.INSERT,
		"INSERT INTO users (username, firstname, secondname, login, password, email, phone, is_active, is_admin) "
			+ "VALUES ('%s', '%s', '%s', '%s', '%s', '%s', '%s', %s, %s);"),
	GET_BY_ID(SqlQueries.GET_BY_ID,
		"SELECT id, username, firstname, secondname, login, password, email, phone, is_active, is_admin "
			+ "FROM users WHERE id = %s;"),
	GET_BY_FIELD(SqlQueries.GET_BY_FIELD,
		"USE CARSTORE SELECT id, username, firstname, secondname, login, password, email, phone, is_active, is_admin "
			+ "FROM USERS WHERE %s = '%s' ;"),
	GET_ALL(SqlQueries.GET_ALL,
		"USE CARSTORE SELECT id, username, firstname, secondname, login, password, email, phone, is_active, is_admin "
			+ "FROM users;"),
	UPDATE_BY_ID(SqlQueries.UPDATE_BY_ID,
		"UPDATE users SET username = '%s', firstname = '%s', secondname = '%s', login = '%s',"
			+ "password = '%s', email = '%s', phone = '%s', is_active = %s, is_admin = %s WHERE id = %s;"),
	UPDATE_BY_FIELD(SqlQueries.UPDATE_BY_FIELD, "UPDATE users SET %s = '%s' WHERE %s = '%s';"),
	DELETE_BY_ID(SqlQueries.DELETE_BY_ID, "DELETE FROM users WHERE id = %s;"),
	DELETE_BY_FIELD(SqlQueries.DELETE_BY_FIELD, "DELETE FROM users WHERE %s = '%s';");
	//
	private SqlQueries sqlQuery;
	private String query;

	private UserEntityQueries(SqlQueries sqlQuery, String query) {
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
     * @param id
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
    public User(Long id, String username, String firstname, String secondname, String login, String password,
	    String email, String phone, Integer isActive, Integer isAdmin) {
	super();
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

    public String getUsername() {
	return username;
    }

    public void setUsername(String username) {
	this.username = username;
    }

    public String getFirstname() {
	return firstname;
    }

    public void setFirstname(String firstname) {
	this.firstname = firstname;
    }

    public String getSecondname() {
	return secondname;
    }

    public void setSecondname(String secondname) {
	this.secondname = secondname;
    }

    public String getLogin() {
	return login;
    }

    public void setLogin(String login) {
	this.login = login;
    }

    public String getPassword() {
	return password;
    }

    public void setPassword(String password) {
	this.password = password;
    }

    public String getEmail() {
	return email;
    }

    public void setEmail(String email) {
	this.email = email;
    }

    public String getPhone() {
	return phone;
    }

    public void setPhone(String phone) {
	this.phone = phone;
    }

    public Integer isActive() {
	return isActive;
    }

    public void setActive(Integer isActive) {
	this.isActive = isActive;
    }

    public Integer isAdmin() {
	return isAdmin;
    }

    public void setAdmin(Integer isAdmin) {
	this.isAdmin = isAdmin;
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
	return "User [id=" + id + ", username=" + username + ", firstname=" + firstname + ", secondname=" + secondname
		+ ", login=" + login + ", password=" + password + ", email=" + email + ", phone=" + phone
		+ ", isActive=" + isActive + ", isAdmin=" + isAdmin + "]";
    }

}
