package de.broscode.wsv.services;

import de.broscode.wsv.dao.user.UserDao;
import de.broscode.wsv.domain.user.User;

public class UserServiceImpl implements IUserService {
	
	private UserDao userDao;

	private UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public boolean doLogin(String username, String password) {
		User user = getUserDao().findUserByName(username);
		
		if(user != null){
			if(user.getPassword().equals(password)) {
				return new Boolean(true);
			}
		}
		return  new Boolean(false);
	}
}
