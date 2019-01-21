package com.softserve.edu;

import java.util.ArrayList;
import java.util.List;

import com.softserve.edu.container.IocContainer;
import com.softserve.edu.items.dao.CarDao;
import com.softserve.edu.items.dao.UserDao;
import com.softserve.edu.items.db.ConnectionManager;
import com.softserve.edu.items.db.DataSourceRepository;
import com.softserve.edu.items.services.DatabaseService;

/**
 * This class is template for testing
 * 
 * @author y3809
 *
 */
public class App {
    public static void main(String[] args) {

	ConnectionManager.getInstance(DataSourceRepository.getMsSqlLocalHost()).getConnection();
	CarDao aa = new CarDao();
	UserDao bb = new UserDao();
	List<String> fields = new ArrayList<String>();

	DatabaseService databaseService = IocContainer.get().getDatabaseService();
	databaseService.initDatabase();

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

	aa.createDatabase();
	bb.init();
	bb.createTable();
	aa.init();
	aa.createTable();

	System.out.println(aa.getAll());
	System.out.println(bb.getAll());

	// bb.insert(new User(0l, "username0", "fn0", "sn0", "log15", "pass", "em",
	// "ph", 1, 0)); // aa.insert(new Car(0L, "brand1", "model1", "gearbox1",
	// "details1", 4L, 2200, // 2018, 118000, 10999)); //
	// aa.insert(aa.createInstance(fields));

	System.out.println(aa.getAll());
	System.out.println(bb.getAll());

	ConnectionManager.closeAllConnections();

    }
}
