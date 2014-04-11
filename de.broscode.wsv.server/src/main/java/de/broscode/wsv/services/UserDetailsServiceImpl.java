package de.broscode.wsv.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import de.broscode.wsv.dao.user.UserDao;
import de.broscode.wsv.domain.user.User;

@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserDao dao;
	@SuppressWarnings("unused")
	private UserDao getUserDao() {
		return dao;
	}

	public void setUserDao(UserDao userDao) {
		this.dao = userDao;
	}
	
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException, DataAccessException {

		User userEntity = dao.findUserByName(username);
		if (userEntity == null)
			throw new UsernameNotFoundException("Der Benutzer " + username + " wurde nicht gefunden");

		return Assembler.buildUserFromUserEntity(userEntity);
	}
}
