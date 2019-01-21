package com.softserve.edu.items.services;

import com.softserve.edu.container.IocContainer;
import com.softserve.edu.items.dao.UserDao;
import com.softserve.edu.items.dto.AllUsersDto;
import com.softserve.edu.items.dto.SearchStatementDto;
import com.softserve.edu.items.dto.UserDto;
import com.softserve.edu.items.entity.User;

public class AllUsersService {
    private UserDao userDao;

    /**
     * @param carDao
     */
    public AllUsersService() {
	this.userDao = IocContainer.get().getUserDao();
    }

    public AllUsersService(UserDao userDao) {
	this.userDao = userDao;
    }

    public AllUsersDto getAllUsersDto() {
	AllUsersDto allUsersDto = new AllUsersDto();
	for (User user : userDao.getAll()) {
	    UserDto userDto = new UserDto(user.getId(), user.getUsername(), user.getFirstname(), user.getSecondname(),
		    user.getLogin(), user.getPassword(), user.getEmail(), user.getPhone(), user.isActive(),
		    user.isAdmin());
	    allUsersDto.addUserDto(userDto);
	}
	return allUsersDto;
    }

    public AllUsersDto getUsersDto(int currentPage, int pageOffset) {
	AllUsersDto allUsersDto = new AllUsersDto();
	allUsersDto.setCurrentPage(currentPage);
	int fromIndex;
	int toIndex;
	int maxIndex = userDao.getAll().size();

	if (currentPage != 0) {
	    allUsersDto.setCurrentPage(currentPage);
	}
	if (pageOffset != 0) {
	    allUsersDto.setPageOffset(pageOffset);
	}

	fromIndex = (allUsersDto.getCurrentPage() - 1) * allUsersDto.getPageOffset();
	toIndex = allUsersDto.getCurrentPage() * allUsersDto.getPageOffset();

	if (toIndex > maxIndex) {
	    toIndex = maxIndex;
	}
	if (fromIndex > toIndex) {
	    fromIndex -= 10;
	}

	for (User user : userDao.getAll().subList(fromIndex, toIndex)) {
	    UserDto userDto = new UserDto(user.getId(), user.getUsername(), user.getFirstname(), user.getSecondname(),
		    user.getLogin(), user.getPassword(), user.getEmail(), user.getPhone(), user.isActive(),
		    user.isAdmin());
	    allUsersDto.addUserDto(userDto);
	}
	allUsersDto.setPageCount(maxIndex / pageOffset + ((maxIndex % pageOffset) > 0 ? 1 : 0));
	return allUsersDto;
    }

    public AllUsersDto getUsersDto() {
	AllUsersDto allUsersDto = new AllUsersDto();
	int fromIndex = (allUsersDto.getCurrentPage() - 1) * allUsersDto.getPageOffset();
	int toIndex = allUsersDto.getCurrentPage() * allUsersDto.getPageOffset();

	for (User user : userDao.getAll().subList(fromIndex, toIndex)) {
	    UserDto userDto = new UserDto(user.getId(), user.getUsername(), user.getFirstname(), user.getSecondname(),
		    user.getLogin(), user.getPassword(), user.getEmail(), user.getPhone(), user.isActive(),
		    user.isAdmin());
	    allUsersDto.addUserDto(userDto);
	}
	return allUsersDto;
    }

    public AllUsersDto getUsersDtoFromSearch(SearchStatementDto ssDto, int currentPage, int pageOffset) {
	AllUsersDto allUsersDto = new AllUsersDto();
	int fromIndex;
	int toIndex;
	int maxIndex = userDao.getByFieldName(ssDto.getFieldName(), ssDto.getRegex()).size();

	// If 0 then use default values from dto
	if (currentPage != 0) {
	    allUsersDto.setCurrentPage(currentPage);
	}
	if (pageOffset != 0) {
	    allUsersDto.setPageOffset(pageOffset);
	}

	fromIndex = (allUsersDto.getCurrentPage() - 1) * allUsersDto.getPageOffset();
	toIndex = (allUsersDto.getCurrentPage() * allUsersDto.getPageOffset());

	if (toIndex > maxIndex) {
	    toIndex = maxIndex;
	}
	if (fromIndex > toIndex) {
	    fromIndex -= 10;
	}

	for (User user : userDao.getByFieldName(ssDto.getFieldName(), ssDto.getRegex()).subList(fromIndex, toIndex)) {
	    UserDto userDto = new UserDto(user.getId(), user.getUsername(), user.getFirstname(), user.getSecondname(),
		    user.getLogin(), user.getPassword(), user.getEmail(), user.getPhone(), user.isActive(),
		    user.isAdmin());
	    allUsersDto.addUserDto(userDto);
	}
	allUsersDto.setPageCount(maxIndex / pageOffset + ((maxIndex % pageOffset) > 0 ? 1 : 0));
	return allUsersDto;
    }
}
