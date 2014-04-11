package de.broscode.wsv.dao.person;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import de.broscode.wsv.domain.mandant.Mandant;
import de.broscode.wsv.domain.personen.Kunde;

public class KundeDao extends
		org.springframework.orm.hibernate3.support.HibernateDaoSupport {
	
	public Mandant getMandantByName(String name) {
		try {
			return (Mandant) getSession().createCriteria(Mandant.class)
					.add(Restrictions.eq("name", name)).uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public boolean saveKunde(Kunde kunde) {
		try {
			getSession().save(kunde);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
		return true;
	}

	public boolean saveKunden(List<Kunde> kunden) {
		try {
			Session session = getSession();
			for (Kunde kunde: kunden) {
				session.save(kunde);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
		return true;
	}

}
