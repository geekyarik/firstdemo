package com.softserve.edu.items.dao;

import java.util.ArrayList;
import java.util.List;

import com.softserve.edu.items.entity.User;
import com.softserve.edu.items.entity.User.UserEntityQueries;

public class UserDao extends ADaoCRUD<User> {
    private final static String LOGIN_FIELDNAME = "login";

    public UserDao() {
	super();
	init();
    }

    // TODO Create abstract method in ADao
    public void init() {
	for (UserEntityQueries userEntityQueries : UserEntityQueries.values()) {
	    sqlQueries.put(userEntityQueries.getSqlQuery(), userEntityQueries);
	}
    }

    // Using String[]
    /*
     * protected User createInstance(String[] args) { return new
     * User(Long.parseLong(args[0] == null ? "0" : args[0]), // id args[1] == null ?
     * new String() : args[1], // username args[2] == null ? new String() : args[2],
     * // firstname args[3] == null ? new String() : args[3], // secondname args[4]
     * == null ? new String() : args[4], // login args[5] == null ? new String() :
     * args[5], // password args[6] == null ? new String() : args[6], // email
     * args[7] == null ? new String() : args[7], // phone Integer.parseInt(args[8]
     * == null ? "0" : args[8]), // isActive Integer.parseInt(args[9] == null ? "0"
     * : args[9])); // isAdmin }
     */

    // Using List<String>
    protected User createInstance(List<String> args) {
	return new User(Long.parseLong(args.get(0) == null ? "0" : args.get(0)), // id
		args.get(1) == null ? new String() : args.get(1), // username
		args.get(2) == null ? new String() : args.get(2), // firstname
		args.get(3) == null ? new String() : args.get(3), // secondname
		args.get(4) == null ? new String() : args.get(4), // login
		args.get(5) == null ? new String() : args.get(5), // password
		args.get(6) == null ? new String() : args.get(6), // email
		args.get(7) == null ? new String() : args.get(7), // phone
		Integer.parseInt(args.get(8) == null ? "0" : args.get(8)), // isActive
		Integer.parseInt(args.get(9) == null ? "0" : args.get(9))); // isAdmin
    }

    // Method for query UPDATE_BY_ID
    protected List<String> getUpdateFields(User entity) {
	List<String> result = new ArrayList<String>();
	List<String> allFields = getFields(entity);

	for (int i = 0; i < 9; i++) {
	    result.add(i, allFields.get(i + 1));
	}
	result.add(9, allFields.get(0));

	return result;
    }

    protected List<String> getFields(User entity) {
	List<String> fields = new ArrayList<String>();

	fields.add(0, entity.getId().toString());
	fields.add(1, entity.getUsername());
	fields.add(2, entity.getFirstname());
	fields.add(3, entity.getSecondname());
	fields.add(4, entity.getLogin());
	fields.add(5, entity.getPassword());
	fields.add(6, entity.getEmail());
	fields.add(7, entity.getPhone());
	fields.add(8, entity.isActive().toString());
	fields.add(9, entity.isAdmin().toString());

	return fields;
    }

    public User getUserEntityByLogin(String login) throws Exception {
	return getByFieldName(LOGIN_FIELDNAME, login).get(0);
    }
}
