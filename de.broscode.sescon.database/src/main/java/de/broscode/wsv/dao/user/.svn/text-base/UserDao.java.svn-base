package de.broscode.wsv.dao.user;

import org.hibernate.criterion.Restrictions;

import de.broscode.wsv.domain.user.User;

public class UserDao extends
		org.springframework.orm.hibernate3.support.HibernateDaoSupport {

	public User findUserByName(String username) {
		try {
			return (User) getSession().createCriteria(User.class)
					.add(Restrictions.eq("name", username)).uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
