package com.softserve.edu.items.dao;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.softserve.edu.items.db.ConnectionManager;
import com.softserve.edu.items.entity.IEntity;
import com.softserve.edu.items.entity.SqlQueries;

abstract class ADaoCRUD<TEntity extends IEntity> extends ADaoRead<TEntity> implements IDaoCRUD<TEntity> {
    protected final static String DATABASE_INPUT_ERROR = "Database Input Error";

    protected ADaoCRUD() {
	super();
    }

    // TODO Use Builder
    protected abstract List<String> getFields(TEntity entity);

    protected abstract List<String> getUpdateFields(TEntity entity);

    private boolean executeQuery(String query, SqlQueries sqlQueries) {
	boolean result = false;
	Statement statement = null;
	if (query == null) {
	    throw new RuntimeException(String.format(QUERY_NOT_FOUND, sqlQueries.name()));
	}
	try {
	    statement = ConnectionManager.getInstance().getConnection().createStatement();
	    // TODO CHECK!
	    result = statement.execute(query);
	} catch (SQLException e) {
	    throw new RuntimeException(DATABASE_INPUT_ERROR, e);
	} finally {
	    if (statement != null) {
		try {
		    statement.close();
		} catch (Exception ex) {
		    // TODO Warning
		}
	    }
	}
	// TODO result must be return if delete Ok
	return result;
    }

    // Create database

    public boolean createDatabase() {

	return executeQuery(sqlQueries.get(SqlQueries.CREATE_DB).toString(), SqlQueries.CREATE_DB);
    }

    // Create table
    public boolean createTable() {

	return executeQuery(sqlQueries.get(SqlQueries.CREATE_TABLE).toString(), SqlQueries.CREATE_TABLE);
    }

    // Insert
    public boolean insert(TEntity entity) {
	String query = String.format(sqlQueries.get(SqlQueries.INSERT).toString(),
		(Object[]) getFields(entity).subList(1, getFields(entity).size()).toArray());
	// System.out.println("query = " + query);
	return executeQuery(query, SqlQueries.INSERT);
    }

    // Update
    public boolean updateByEntity(TEntity entity) {
	String query = String.format(sqlQueries.get(SqlQueries.UPDATE_BY_ID).toString(),
		(Object[]) getUpdateFields(entity).toArray());
	return executeQuery(query, SqlQueries.UPDATE_BY_FIELD);
    }

    public boolean updateByFieldName(String fieldName, String text, String fieldCondition, String textCondition) {
	String query = String.format(sqlQueries.get(SqlQueries.UPDATE_BY_FIELD).toString(), fieldName, text,
		fieldCondition, textCondition);
	return executeQuery(query, SqlQueries.UPDATE_BY_FIELD);
    }

    // Delete
    public boolean deleteById(Long id) {
	String query = String.format(sqlQueries.get(SqlQueries.DELETE_BY_ID).toString(), id);
	// System.out.println("query=" + query);
	return executeQuery(query, SqlQueries.DELETE_BY_ID);
    }

    public boolean deleteByFieldName(String fieldCondition, String textCondition) {
	String query = String.format(sqlQueries.get(SqlQueries.DELETE_BY_FIELD).toString(), fieldCondition,
		textCondition);
	return executeQuery(query, SqlQueries.DELETE_BY_FIELD);
    }

    public boolean delete(TEntity entity) {
	return deleteById(entity.getId());
    }

}