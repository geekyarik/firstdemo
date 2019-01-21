package com.softserve.edu.container;

import com.softserve.edu.items.dao.CarDao;
import com.softserve.edu.items.dao.UserDao;
import com.softserve.edu.items.services.AllCarsService;
import com.softserve.edu.items.services.AllUsersService;
import com.softserve.edu.items.services.CarService;
import com.softserve.edu.items.services.DatabaseService;
import com.softserve.edu.items.services.UserCarsService;
import com.softserve.edu.items.services.UserService;

public final class IocContainer {
    private static volatile IocContainer instance = null;
    //
    private UserDao userDao;
    private CarDao carDao;
    //
    private DatabaseService databaseService;
    private UserService userService;
    private CarService carService;
    private UserCarsService userCarsService;
    private AllCarsService allCarsService;
    private AllUsersService allUsersService;

    private IocContainer() {
	initDaos();
	initServices();
    }

    private void initDaos() {
	userDao = new UserDao();
	carDao = new CarDao();
    }

    private void initServices() {
	databaseService = new DatabaseService(carDao, userDao);
	userService = new UserService(userDao);
	carService = new CarService(carDao);
	userCarsService = new UserCarsService(userDao, carDao);
	allCarsService = new AllCarsService(carDao);
	allUsersService = new AllUsersService(userDao);
    }

    public static IocContainer get() {
	if (instance == null) {
	    synchronized (IocContainer.class) {
		if (instance == null) {
		    instance = new IocContainer();
		}
	    }
	}
	return instance;
    }

    public UserDao getUserDao() {
	return userDao;
    }

    public CarDao getCarDao() {
	return carDao;
    }

    public DatabaseService getDatabaseService() {
	return databaseService;
    }

    public UserService getUserService() {
	return userService;
    }

    public CarService getCarService() {
	return carService;
    }

    public UserCarsService getUserCarsService() {
	return userCarsService;
    }

    public AllCarsService getAllCarsService() {
	return allCarsService;
    }

    public AllUsersService getAllUserService() {
	return allUsersService;
    }
}
