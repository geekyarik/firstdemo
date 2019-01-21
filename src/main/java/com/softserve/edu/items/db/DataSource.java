package com.softserve.edu.items.db;

public final class DataSource {

	private String connectionUrl;
	private String username;
	private String password;

	// TODO Create Factory, Builder
	public DataSource(String connectionUrl, String username, String password) {
		this.connectionUrl = connectionUrl;
		this.username = username;
		this.password = password;
	}

	// setters

	public void setConnectionUrl(String connectionUrl) {
		this.connectionUrl = connectionUrl;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	// getters

	public String getConnectionUrl() {
		return connectionUrl;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	@Override
	public boolean equals(Object dataSource) {
		boolean result = false;
		if (getUsername().equals(((DataSource) dataSource).getUsername()) & dataSource instanceof DataSource) {
			result = getConnectionUrl().equals(((DataSource) dataSource).getConnectionUrl())
					&& getPassword().equals(((DataSource) dataSource).getPassword());
		}
		return result;
	}

}
