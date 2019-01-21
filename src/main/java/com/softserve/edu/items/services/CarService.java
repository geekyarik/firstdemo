/**
 * 
 */
package com.softserve.edu.items.services;

import com.softserve.edu.items.dao.CarDao;
import com.softserve.edu.items.dto.CarDto;
import com.softserve.edu.items.entity.Car;

/**
 * @author y3809
 *
 */
public class CarService {

    CarDao carDao;

    public CarService(CarDao carDao) {
	this.carDao = carDao;
    }

    public CarService() {
	this.carDao = new CarDao();
    }

    public CarDto getCarDto(long id) {
	Car car = carDao.getById(id);
	return new CarDto(car.getId(), car.getBrand(), car.getModel(), car.getGearBox(), car.getDetails(),
		car.getIdUser(), car.getEngineCapacity(), car.getYear(), car.getMileage(), car.getPrice());
    }

    public boolean setCarDto(CarDto carDto, Long idUser) {
	boolean result = false;
	Car car = new Car(carDto.getId(), carDto.getBrand(), carDto.getModel(), carDto.getGearBox(),
		carDto.getDetails(), idUser, carDto.getEngineCapacity(), carDto.getYear(), carDto.getMileage(),
		carDto.getPrice());
	if (carDto.getId() > 0) {
	    if (isExistCar(car.getId())) {
		carDao.updateByEntity(car);
		result = true;
	    }
	} else {
	    carDao.insert(car);
	    result = true;
	}
	return result;
    }

    boolean isExistCar(long id) {
	boolean result = true;
	try {
	    carDao.getById(id);
	} catch (RuntimeException e) {
	    // Logging Exception
	    System.out.println("Item not found, message: " + e.getMessage());
	    result = false;
	}
	return result;
    }

    public boolean deleteCar(long id) {
	boolean result = true;
	try {
	    result = result && carDao.deleteById(id);
	} catch (RuntimeException e) {
	    // Logging Exception
	    result = false;
	}
	return result;
    }
}
