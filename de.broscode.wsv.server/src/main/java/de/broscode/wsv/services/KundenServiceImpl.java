package de.broscode.wsv.services;

import java.util.List;

import de.broscode.wsv.dao.person.KundeDao;
import de.broscode.wsv.domain.mandant.Mandant;
import de.broscode.wsv.domain.personen.Kunde;

public class KundenServiceImpl implements IKundenService{

	private KundeDao kundeDao;

	@SuppressWarnings("unused")
	private KundeDao getKundeDao() {
		return kundeDao;
	}

	public void setKundeDao(KundeDao kundeDao) {
		this.kundeDao = kundeDao;
	}
	
	@Override
	public boolean saveKunde(Kunde kunde) {
		// TODO Auto-generated method stub
		return kundeDao.saveKunde(kunde);
	}

	@Override
	public Mandant getMandant(String name) {
		// TODO Auto-generated method stub
		return kundeDao.getMandantByName(name);
	}
	
	@Override
	public boolean saveAllKunden(List<Kunde> kunden) {
		// TODO Auto-generated method stub
		return kundeDao.saveKunden(kunden);
	}
}
