package de.broscode.wsv.services;

import java.util.List;

import de.broscode.wsv.domain.mandant.Mandant;
import de.broscode.wsv.domain.personen.Kunde;

public interface IKundenService {
	boolean saveKunde(Kunde kunde);
	boolean saveAllKunden(List<Kunde> kunden);
	Mandant getMandant(String name);
}
