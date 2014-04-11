package de.broscode.wsv.services;


public class MigrationServiceImpl implements IMigrationService {

	@Override
	public boolean migrate() {
		System.out.println("------------------- migrate!");
//		Converter.importPerson(ClientServiceLocator.instance().getKundenService());
		return true;
	}

}
