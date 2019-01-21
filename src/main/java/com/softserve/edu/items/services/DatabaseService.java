package com.softserve.edu.items.services;

import com.softserve.edu.items.dao.CarDao;
import com.softserve.edu.items.dao.UserDao;
import com.softserve.edu.items.db.ConnectionManager;
import com.softserve.edu.items.db.DataSourceRepository;

public class DatabaseService {
    CarDao carDao;
    UserDao userDao;

    /**
     * @param carDao
     * @param userDao
     */
    public DatabaseService(CarDao carDao, UserDao userDao) {
	this.carDao = carDao;
	this.userDao = userDao;
    }

    public DatabaseService() {
	this.carDao = new CarDao();
	this.userDao = new UserDao();
    }

    public void initDatabase() {
	ConnectionManager.getInstance(DataSourceRepository.getMsSqlLocalHost()).getConnection();

	userDao.createDatabase();
	userDao.createTable();
	userDao.init();
	carDao.createTable();
	carDao.init();

    }
}
