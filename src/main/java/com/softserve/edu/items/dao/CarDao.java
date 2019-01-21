package com.softserve.edu.items.dao;

import java.util.ArrayList;
import java.util.List;

import com.softserve.edu.items.db.ConnectionManager;
import com.softserve.edu.items.entity.Car;
import com.softserve.edu.items.entity.Car.CarEntityQueries;
import com.softserve.edu.items.entity.User;

public class CarDao extends ADaoCRUD<Car> {
    private final static String ID_USER_FIELDNAME = "id_user";

    public CarDao() {
	super();
	init();
    }

    // TODO Create abstract method in ADao
    public void init() {
	for (CarEntityQueries carEntityQueries : CarEntityQueries.values()) {
	    sqlQueries.put(carEntityQueries.getSqlQuery(), carEntityQueries);
	}
    }

    // Using List<String>
    protected Car createInstance(List<String> args) {
	return new Car(Long.parseLong(args.get(0) == null ? "0" : args.get(0)), // id
		args.get(1) == null ? new String() : args.get(1), // brand
		args.get(2) == null ? new String() : args.get(2), // model
		args.get(3) == null ? new String() : args.get(3), // gearBox
		args.get(4) == null ? new String() : args.get(4), // details
		Long.parseLong(args.get(5) == null ? "0" : args.get(5)), // idUser
		Integer.parseInt(args.get(6) == null ? "0" : args.get(6)), // engineCapacity
		Integer.parseInt(args.get(7) == null ? "0" : args.get(7)), // year
		Integer.parseInt(args.get(8) == null ? "0" : args.get(8)), // mileage
		Integer.parseInt(args.get(9) == null ? "0" : args.get(9))); // price
    }

    // Method for query UPDATE_BY_ID
    /*
     * protected String[] getUpdateFields(Car entity) { String[] result = new
     * String[3]; String[] allFields = getFields(entity); result[0] = allFields[1];
     * // brand result[1] = allFields[2]; // model result[2] = allFields[3]; //
     * gearBox result[3] = allFields[4]; // details result[4] = allFields[5]; //
     * idUser result[5] = allFields[6]; // engineCapacity result[6] = allFields[7];
     * // year result[7] = allFields[8]; // mileage result[8] = allFields[9]; //
     * price result[9] = allFields[0]; // id
     * 
     * return result; }
     */

    protected List<String> getUpdateFields(Car entity) {
	List<String> result = new ArrayList<String>();
	List<String> allFields = getFields(entity);

	for (int i = 0; i < 9; i++) {
	    result.add(i, allFields.get(i + 1));
	}
	result.add(9, allFields.get(0));

	return result;
    }

    protected List<String> getFields(Car entity) {
	// String[] fields = new String[User.class.getDeclaredFields().length];
	List<String> fields = new ArrayList<String>();

	fields.add(entity.getId().toString());
	fields.add(entity.getBrand());
	fields.add(entity.getModel());
	fields.add(entity.getGearBox());
	fields.add(entity.getDetails());
	fields.add(entity.getIdUser().toString());
	fields.add(entity.getEngineCapacity().toString());
	fields.add(entity.getYear().toString());
	fields.add(entity.getMileage().toString());
	fields.add(entity.getPrice().toString());
	/*
	 * fields[0] = entity.getId().toString(); fields[1] = entity.getBrand();
	 * fields[2] = entity.getModel(); fields[3] = entity.getGearBox(); fields[4] =
	 * entity.getDetails(); fields[5] = entity.getIdUser().toString(); fields[6] =
	 * entity.getEngineCapacity().toString(); fields[7] =
	 * entity.getYear().toString(); fields[8] = entity.getMileage().toString();
	 * fields[9] = entity.getPrice().toString();
	 */
	return fields;
    }

    public List<Car> getUserEntityByIdUser(Long idUser) {
	return getByFieldName(ID_USER_FIELDNAME, idUser.toString()); // .get(0)
    }

    public static void main(String[] args) {

	ConnectionManager.getInstance().getConnection();
	CarDao aa = new CarDao();
	UserDao bb = new UserDao();
	List<String> fields = new ArrayList<String>();

	fields.add("0");
	fields.add("brand0");
	fields.add("model0");
	fields.add("gearbox0");
	fields.add("details0");
	fields.add("1");
	fields.add("2000");
	fields.add("2019");
	fields.add("191000");
	fields.add("8999");

	aa.createDatabase(); // bb.init(); bb.createTable(); // aa.init();
	aa.createTable();
	bb.insert(new User(1l, "���0", "fn0", "sn0", "log9", "pass", "em", "ph", 1, 0));
	aa.insert(new Car(1L, "brand1", "model1", "gearbox1", "details1", 1L, 2200, 2018, 118000, 10999));

	// aa.insert(aa.createInstance(fields));

	System.out.println(aa.getAll());
	System.out.println(bb.getAll());

	ConnectionManager.closeAllConnections();

    }
}
