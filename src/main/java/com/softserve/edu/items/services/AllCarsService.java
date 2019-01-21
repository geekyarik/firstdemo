package com.softserve.edu.items.services;

import com.softserve.edu.container.IocContainer;
import com.softserve.edu.items.dao.CarDao;
import com.softserve.edu.items.dto.AllCarsDto;
import com.softserve.edu.items.dto.CarDto;
import com.softserve.edu.items.dto.SearchStatementDto;
import com.softserve.edu.items.entity.Car;

public class AllCarsService {

    private CarDao carDao;

    /**
     * @param carDao
     */
    public AllCarsService() {
	this.carDao = IocContainer.get().getCarDao();
    }

    public AllCarsService(CarDao carDao) {
	this.carDao = carDao;
    }

    /*
     * If pageOffset == 0 then DEFAULT(10) used
     * 
     */
    public AllCarsDto getCarsDto(int currentPage, int pageOffset) {
	AllCarsDto allCarsDto = new AllCarsDto();
	allCarsDto.setCurrentPage(currentPage);
	int fromIndex;
	int toIndex;
	int maxIndex = carDao.getAll().size();

	// allCarsDto.setPageOffset(pageOffset);
	if (currentPage != 0) {
	    allCarsDto.setCurrentPage(currentPage);
	}
	if (pageOffset != 0) {
	    allCarsDto.setPageOffset(pageOffset);
	}
	fromIndex = (allCarsDto.getCurrentPage() - 1) * allCarsDto.getPageOffset();
	toIndex = allCarsDto.getCurrentPage() * allCarsDto.getPageOffset();

	if (toIndex > maxIndex) {
	    toIndex = maxIndex;
	}
	if (fromIndex > toIndex) {
	    fromIndex -= 10;
	}

	for (Car car : carDao.getAll().subList(fromIndex, toIndex)) {
	    CarDto carDto = new CarDto(car.getId(), car.getBrand(), car.getModel(), car.getGearBox(), car.getDetails(),
		    car.getIdUser(), car.getEngineCapacity(), car.getYear(), car.getMileage(), car.getPrice());
	    allCarsDto.addCarDto(carDto);
	}
	allCarsDto.setPageCount(maxIndex / pageOffset + ((maxIndex % pageOffset) > 0 ? 1 : 0));
	return allCarsDto;
    }

    public AllCarsDto getCarsDto() {
	AllCarsDto allCarsDto = new AllCarsDto();
	int fromIndex = (allCarsDto.getCurrentPage() - 1) * allCarsDto.getPageOffset();
	int toIndex = allCarsDto.getCurrentPage() * allCarsDto.getPageOffset();
	int maxIndex = carDao.getAll().size();

	if (toIndex > maxIndex) {
	    toIndex = maxIndex;
	}
	if (fromIndex > toIndex) {
	    fromIndex -= 10;
	}

	for (Car car : carDao.getAll().subList(fromIndex, toIndex)) {
	    CarDto carDto = new CarDto(car.getId(), car.getBrand(), car.getModel(), car.getGearBox(), car.getDetails(),
		    car.getIdUser(), car.getEngineCapacity(), car.getYear(), car.getMileage(), car.getPrice());
	    allCarsDto.addCarDto(carDto);
	}
	return allCarsDto;
    }

    public AllCarsDto getAllCarsDto() {
	AllCarsDto allCarsDto = new AllCarsDto();
	for (Car car : carDao.getAll()) {
	    CarDto carDto = new CarDto(car.getId(), car.getBrand(), car.getModel(), car.getGearBox(), car.getDetails(),
		    car.getIdUser(), car.getEngineCapacity(), car.getYear(), car.getMileage(), car.getPrice());
	    allCarsDto.addCarDto(carDto);
	}
	return allCarsDto;
    }

    public AllCarsDto getCarsDtoFromSearch(SearchStatementDto ssDto, int currentPage, int pageOffset) {
	AllCarsDto allCarsDto = new AllCarsDto();
	int fromIndex;
	int toIndex;
	int maxIndex = carDao.getByFieldName(ssDto.getFieldName(), ssDto.getRegex()).size();

	allCarsDto.setPageOffset(pageOffset);
	// If 0 then use default values from dto
	if (currentPage != 0) {
	    allCarsDto.setCurrentPage(currentPage);
	}
	if (pageOffset != 0) {
	    allCarsDto.setPageOffset(pageOffset);
	}

	fromIndex = (allCarsDto.getCurrentPage() - 1) * allCarsDto.getPageOffset();
	toIndex = (allCarsDto.getCurrentPage() * allCarsDto.getPageOffset());

	if (toIndex > maxIndex) {
	    toIndex = maxIndex;
	}
	if (fromIndex > toIndex) {
	    fromIndex -= 10;
	}

	for (Car car : carDao.getByFieldName(ssDto.getFieldName(), ssDto.getRegex()).subList(fromIndex, toIndex)) {
	    CarDto carDto = new CarDto(car.getId(), car.getBrand(), car.getModel(), car.getGearBox(), car.getDetails(),
		    car.getIdUser(), car.getEngineCapacity(), car.getYear(), car.getMileage(), car.getPrice());
	    allCarsDto.addCarDto(carDto);
	}
	allCarsDto.setPageCount(maxIndex / pageOffset + ((maxIndex % pageOffset) > 0 ? 1 : 0));
	return allCarsDto;
    }
}
