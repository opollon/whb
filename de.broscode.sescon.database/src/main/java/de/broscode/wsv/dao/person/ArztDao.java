package de.broscode.wsv.dao.person;

import java.util.List;

import org.hibernate.Session;

import de.broscode.wsv.domain.arzt.Arztpraxis;

public class ArztDao extends
		org.springframework.orm.hibernate3.support.HibernateDaoSupport {
	
	public boolean saveArztpraxis(Arztpraxis arztpraxis) {
		try {
			getSession().save(arztpraxis);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
		return true;
	}

	public boolean saveArztpraxen(List<Arztpraxis> arztpraxen) {
		try {
			Session session = getSession();
			for (Arztpraxis arztpraxis: arztpraxen) {
				session.save(arztpraxis);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
		return true;
	}

}
