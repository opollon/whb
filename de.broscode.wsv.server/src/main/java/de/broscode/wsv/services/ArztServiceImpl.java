package de.broscode.wsv.services;

import java.util.List;

import de.broscode.wsv.dao.person.ArztDao;
import de.broscode.wsv.domain.arzt.Arztpraxis;

public class ArztServiceImpl implements IArztService{

	private ArztDao arztDao;

	private ArztDao getArztDao() {
		return arztDao;
	}

	public void setArztDao(ArztDao arztDao) {
		this.arztDao = arztDao;
	}
	
	@Override
	public boolean saveArztpraxis(Arztpraxis arztpraxis) {
		// TODO Auto-generated method stub
		return arztDao.saveArztpraxis(arztpraxis);
	}

	@Override
	public boolean saveAllArztpraxen(List<Arztpraxis> arztpraxen) {
		// TODO Auto-generated method stub
		return arztDao.saveArztpraxen(arztpraxen);
	}
}
