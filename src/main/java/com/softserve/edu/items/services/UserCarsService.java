package com.softserve.edu.items.services;

import com.softserve.edu.container.IocContainer;
import com.softserve.edu.items.dao.CarDao;
import com.softserve.edu.items.dao.UserDao;
import com.softserve.edu.items.dto.CarDto;
import com.softserve.edu.items.dto.UserCarsDto;
import com.softserve.edu.items.dto.UserDto;
import com.softserve.edu.items.entity.Car;
import com.softserve.edu.items.entity.User;

public class UserCarsService {

    private UserDao userDao;
    private CarDao carDao;

    /**
     * @param userDao
     * @param carDao
     */
    public UserCarsService() {
	this.userDao = IocContainer.get().getUserDao();
	this.carDao = IocContainer.get().getCarDao();
    }

    public UserCarsService(UserDao userDao, CarDao carDao) {
	this.userDao = userDao;
	this.carDao = carDao;
    }

    public UserCarsDto getUserCarsDto(UserDto userDto, int currentPage, int pageOffset) {
	try {
	    User user = userDao.getUserEntityByLogin(userDto.getLogin());
	    UserCarsDto userCarsDto = new UserCarsDto(userDto.getLogin());
	    userCarsDto.setCurrentPage(currentPage);
	    int fromIndex;
	    int toIndex;
	    int maxIndex = carDao.getUserEntityByIdUser(user.getId()).size();

	    // If 0 then use default values from dto
	    if (currentPage != 0) {
		userCarsDto.setCurrentPage(currentPage);
	    }
	    if (pageOffset != 0) {
		userCarsDto.setPageOffset(pageOffset);
	    }
	    fromIndex = (userCarsDto.getCurrentPage() - 1) * userCarsDto.getPageOffset();
	    toIndex = userCarsDto.getCurrentPage() * userCarsDto.getPageOffset();

	    if (toIndex > maxIndex) {
		toIndex = maxIndex;
	    }
	    if (fromIndex > toIndex) {
		fromIndex -= 10;
	    }

	    for (Car car : carDao.getUserEntityByIdUser(user.getId()).subList(fromIndex, toIndex)) {
		CarDto carDto = new CarDto(car.getId(), car.getBrand(), car.getModel(), car.getGearBox(),
			car.getDetails(), car.getIdUser(), car.getEngineCapacity(), car.getYear(), car.getMileage(),
			car.getPrice());
		userCarsDto.addCarDto(carDto);
	    }
	    userCarsDto.setPageCount(maxIndex / pageOffset + ((maxIndex % pageOffset) > 0 ? 1 : 0));
	    return userCarsDto;
	} catch (Exception ex) {
	    return null;
	}
    }
}
