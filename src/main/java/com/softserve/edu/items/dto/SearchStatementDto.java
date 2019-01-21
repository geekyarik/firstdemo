package com.softserve.edu.items.dto;

import com.softserve.edu.items.entity.FieldNames;

public class SearchStatementDto {

    private String fieldName;
    private String regex;

    /**
     * @param fieldName
     * @param regex
     */
    public SearchStatementDto(String fieldName, String regex) {
	super();
	this.fieldName = fieldName;
	this.regex = regex;
    }

    // Getters
    public String getFieldName() {
	return fieldName;
    }

    public String getRegex() {
	if (fieldName.equals(FieldNames.ID.toString()) || fieldName.equals(FieldNames.IS_ACTIVE.toString())
		|| fieldName.equals(FieldNames.IS_ADMIN.toString()) || fieldName.equals(FieldNames.ID_USER.toString())
		|| fieldName.equals(FieldNames.ENGINE_CAPACITY.toString())
		|| fieldName.equals(FieldNames.YEAR.toString()) || fieldName.equals(FieldNames.MILEAGE.toString())
		|| fieldName.equals(FieldNames.PRICE.toString())) {
	    return regex;
	} else {
	    return "'%" + regex + "%'";
	}
    }

    // Setters
    public void setFieldName(String fieldName) {
	this.fieldName = fieldName;
    }

    public void setRegex(String regex) {
	this.regex = regex;
    }

}
