package com.softserve.edu.items.services;

import com.softserve.edu.container.IocContainer;
import com.softserve.edu.items.dao.UserDao;
import com.softserve.edu.items.dto.LoginDto;
import com.softserve.edu.items.dto.UserDto;
import com.softserve.edu.items.entity.User;

public class UserService {

    private UserDao userDao;

    public UserService() {
	this.userDao = IocContainer.get().getUserDao();
    }

    public UserService(UserDao userDao) {
	this.userDao = userDao;
    }

    public boolean setUserDto(UserDto userDto) {
	boolean result = true;
	User user;

	try {
	    user = userDao.getUserEntityByLogin(userDto.getLogin());

	    user.setId(userDto.getId());
	    user.setActive(userDto.getIsActive());
	    user.setAdmin(userDto.getIsAdmin());
	    user.setEmail(userDto.getEmail());
	    user.setFirstname(userDto.getFirstname());
	    user.setSecondname(userDto.getSecondname());
	    user.setPassword(userDto.getPassword());
	    user.setPhone(userDto.getPhone());
	    user.setUsername(userDto.getUsername());

	    if (userDto.getId() == 0L) {
		user.setAdmin(1);
	    }

	    if (userDto.getId() > 0) {
		if (isExistUser(user.getId())) {
		    userDao.updateByEntity(user);
		    result = true;
		}
	    } else {
		userDao.insert(user);
		result = true;
	    }
	} catch (Exception ex) {
	    user = new User(userDto.getId(), userDto.getUsername(), userDto.getFirstname(), userDto.getSecondname(),
		    userDto.getLogin(), userDto.getPassword(), userDto.getEmail(), userDto.getPhone(),
		    userDto.getIsActive(), userDto.getIsAdmin());
	    userDao.insert(user);
	    result = true; // false
	}
	return result;
    }

    public boolean isValid(LoginDto loginDto) {
	boolean result = false;

	try {
	    User user = userDao.getUserEntityByLogin(loginDto.getLogin());
	    if (user.getPassword().equals(loginDto.getPassword())) {
		result = true;
	    }

	} catch (Exception ex) {
	    // TODO Logging
	}
	return result;

    }

    boolean isExistUser(long id) {
	boolean result = true;
	try {
	    userDao.getById(id);
	} catch (RuntimeException e) {
	    // Logging Exception
	    System.out.println("User not found, message: " + e.getMessage());
	    result = false;
	}
	return result;
    }

    public UserDto getUserDto(User user) {
	UserDto userDto = new UserDto(user.getId(), user.getUsername(), user.getFirstname(), user.getSecondname(),
		user.getLogin(), user.getPassword(), user.getEmail(), user.getPhone(), user.isActive(), user.isAdmin());
	return userDto;
    }

    public UserDto getUserDto(LoginDto loginDto) {
	try {
	    User user = userDao.getUserEntityByLogin(loginDto.getLogin());
	    return new UserDto(user.getId(), user.getUsername(), user.getFirstname(), user.getSecondname(),
		    user.getLogin(), user.getPassword(), user.getEmail(), user.getPhone(), user.isActive(),
		    user.isAdmin());
	} catch (Exception ex) {
	    return null;
	}
    }

    public Long getIdUserByLogin(LoginDto loginDto) throws Exception {
	return userDao.getUserEntityByLogin(loginDto.getLogin()).getId();
    }

    public Long getIdUserByLogin(UserDto userDto) throws Exception {
	return userDao.getUserEntityByLogin(userDto.getLogin()).getId();
    }
}
