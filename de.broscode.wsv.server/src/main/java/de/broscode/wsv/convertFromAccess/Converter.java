package de.broscode.wsv.convertFromAccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import de.broscode.wsv.client.ClientServiceLocator;
import de.broscode.wsv.domain.arzt.ArztArt;
import de.broscode.wsv.domain.arzt.ArztKundeZuordnung;
import de.broscode.wsv.domain.arzt.Arztpraxis;
import de.broscode.wsv.domain.mandant.Mandant;
import de.broscode.wsv.domain.personen.Familienstand;
import de.broscode.wsv.domain.personen.Geschlecht;
import de.broscode.wsv.domain.personen.Konfession;
import de.broscode.wsv.domain.personen.Kunde;
import de.broscode.wsv.domain.personen.Person;
import de.broscode.wsv.domain.versicherungen.Versicherung;
import de.broscode.wsv.services.IArztService;
import de.broscode.wsv.services.IKundenService;

public class Converter {

	public static void importPerson(IKundenService kundenService) {
		
		Map<Long, Arztpraxis> arztZuordnung = new HashMap<Long, Arztpraxis>();
		
		//Lese Aerzte ein
		try {
			List<Arztpraxis> arztpraxenListe = new ArrayList<Arztpraxis>();
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			Connection con = DriverManager.getConnection("jdbc:odbc:caritas");
			Statement st = con.createStatement();
			st.execute("select * from person, arzt where person.p_nummer = arzt.p_nummer");
			ResultSet resultSet = st.getResultSet();
			while (resultSet.next()) {
				Person person = new Person();
				person.setName(resultSet.getString("name"));
				System.out.println("-------------");
				System.out.println(person.getName());
				person.setVorname(resultSet.getString("vorname"));
				person.setGeburtsname(resultSet.getString("geburtsname"));
				String anrede = resultSet.getString("anrede");
				if (anrede != null && anrede.equals("Herr")) {
					person.setGeschlecht(Geschlecht.MAENNLICH);
				} else {
					person.setGeschlecht(Geschlecht.WEIBLICH);
				}
				String context = resultSet.getString("context");

				System.out.println("=> speichere Arztpraxis");
				Arztpraxis arztpraxis = new Arztpraxis();
				
				// Praxisdaten füllen
				arztpraxis.setPraxisName(resultSet.getString("praxis_name"));
				arztpraxis.setKuerzel(resultSet.getString("kuerzel"));
				String arztart = resultSet.getString("arzt_art");
				if(arztart != null) {
					arztart = arztart.toUpperCase();
				}
				if (arztart == null) {
					arztpraxis.setArztArt(null);
				} else if (arztart.equals("AM")) {
					arztpraxis.setArztArt(ArztArt.ALLGEMEINMEDIZINER);
				} else if (arztart.equals("ZA")) {
					arztpraxis.setArztArt(ArztArt.ZAHNARZT);
				} else if (arztart.equals("NE")) {
					arztpraxis.setArztArt(ArztArt.NEUROLOGE);
				} else if (arztart.equals("RAD")) {
					arztpraxis.setArztArt(ArztArt.RADIOLOGE);
				} else if (arztart.equals("KH")) {
					arztpraxis.setArztArt(ArztArt.KRANKENHAUS);
				} else if (arztart.equals("GY")) {
					arztpraxis.setArztArt(ArztArt.GYNEKOLOGE);
				} else if (arztart.equals("OR")) {
					arztpraxis.setArztArt(ArztArt.ORTHOPAEDE);
				} else if (arztart.equals("IN")) {
					arztpraxis.setArztArt(ArztArt.INTERNIST);
				} else if (arztart.equals("HA")) {
					arztpraxis.setArztArt(ArztArt.HAUSARZT);
				} else if (arztart.equals("HNO")) {
					arztpraxis.setArztArt(ArztArt.HALS_NASEN_OHREN_ARZT);
				} else if (arztart.equals("SO")) {
					arztpraxis.setArztArt(ArztArt.SONDERFORM);
				} else if (arztart.equals("AU")) {
					arztpraxis.setArztArt(ArztArt.AUGENARZT);
				} else if (arztart.equals("UR")) {
					arztpraxis.setArztArt(ArztArt.UROLOGE);
				} else if (arztart.equals("LU")) {
					arztpraxis.setArztArt(ArztArt.LUNGENARZT);
				} else {
					arztpraxis.setArztArt(null);
				}
				
				arztZuordnung.put(resultSet.getLong("p_nummer"), arztpraxis);

				arztpraxenListe.add(arztpraxis);
			}
			resultSet.close();
			con.close();
			IArztService arztService = ClientServiceLocator.instance().getArztService();
			arztService.saveAllArztpraxen(arztpraxenListe);
		} catch (Exception e) {
			System.out.println("does not added:" + e);
			e.printStackTrace();
		}
		
		
		// Lese Kunden ein
		try {
			List<Kunde> kundenListe = new ArrayList<Kunde>();
			Map<Long, Person> personenMap = new HashMap<Long, Person>();
			Mandant whb = kundenService.getMandant("WHB");
			Mandant wpk = kundenService.getMandant("WPK");
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			Connection con = DriverManager.getConnection("jdbc:odbc:caritas");
			Statement st = con.createStatement();
			st.execute("select * from person, whb where person.p_nummer = whb.p_nummer");
			ResultSet resultSet = st.getResultSet();
			while (resultSet.next()) {
				Person person = new Person();
				person.setName(resultSet.getString("name"));
				System.out.println("-------------");
				System.out.println(person.getName());
				person.setVorname(resultSet.getString("vorname"));
				person.setGeburtsname(resultSet.getString("geburtsname"));
				String anrede = resultSet.getString("anrede");
				if (anrede != null && anrede.equals("Herr")) {
					person.setGeschlecht(Geschlecht.MAENNLICH);
				} else {
					person.setGeschlecht(Geschlecht.WEIBLICH);
				}
				String context = resultSet.getString("context");

				System.out.println("=> speichere Kunde");
				Kunde kunde = new Kunde();
				kunde.setPerson(person);
				if (context != null && context.equals("WHB")) {
					kunde.setMandant(whb);
				} else if (context != null && context.equals("WPK")) {
					kunde.setMandant(wpk);
				}

				// Kundendaten füllen
				kunde.setAktenzeichen(resultSet.getString("aktenzeichen"));
				kunde.setAustritt(resultSet.getDate("austritt"));
				kunde.setEintritt(resultSet.getDate("eintritt"));
				kunde.setGeburtsdatum(resultSet.getDate("geb_datum"));
				kunde.setGeburtsort(resultSet.getString("geb_ort"));
				kunde.setGeburtsland(resultSet.getString("geb_land"));
				String religion = resultSet.getString("religion");
				if(religion != null) {
					religion = religion.toUpperCase();
				}
				if (religion == null) {
					kunde.setReligion(null);
				} else if (religion.equals("RK") || religion.equals("KATH")
						|| religion.equals("R.K.")
						|| religion.equals("KATHOLISCH")
						|| religion.equals("RÖMISCH-KATHOLISCH")
						|| religion.equals("RÖM-KATH")
						|| religion.equals("RÖM-KATH.")) {
					kunde.setReligion(Konfession.RK);
				} else if (religion.equals("EV")
						|| religion.equals("EVANGELISCH")) {
					kunde.setReligion(Konfession.RK);
				} else if (religion.equals("KONFESSIONSLOS")) {
					kunde.setReligion(Konfession.KONFESSINSLOS);
				} else if (religion.equals("MUSLIMISCH")) {
					kunde.setReligion(Konfession.MUSLIMISCH);
				}
				String familienstand = resultSet.getString("f_stand");
				if(familienstand != null) {
					familienstand = familienstand.toLowerCase();
				}
				if(familienstand == null) {
					kunde.setFamilienstand(null);
				} else if(familienstand.equals("ledig") || familienstand.equals("led.")) {
					kunde.setFamilienstand(Familienstand.LEDIG);
				} else if(familienstand.equals("verheiratet")) {
					kunde.setFamilienstand(Familienstand.VERHEIRATET);
				} else if(familienstand.equals("geschieden")) {
					kunde.setFamilienstand(Familienstand.GESCHIEDEN);
				} else if(familienstand.equals("verwittwet")) {
					kunde.setFamilienstand(Familienstand.VERWITWERT);
				}
				
				kunde.setIdent_nr(resultSet.getString("identnr"));
				kunde.setNationalitaet(resultSet.getString("nationalitaet"));
				Set<Versicherung> versicherungen = kunde.getVersicherungen();
				
				//Aerzte zuordnen
				Set<ArztKundeZuordnung> aerzte = kunde.getAerzte();
				if(aerzte == null) {
					aerzte = new HashSet<ArztKundeZuordnung>();
				}
				Long hausarzt = resultSet.getLong("hausarzt");
				if(hausarzt != null) {
					ArztKundeZuordnung zuordnung = new ArztKundeZuordnung();
					Arztpraxis arztpraxis = arztZuordnung.get(hausarzt);
					
					zuordnung.setArztpraxis(arztpraxis);
					zuordnung.setKunde(kunde);
					zuordnung.setHausarzt(true);
					aerzte.add(zuordnung);
				}
				Long neurologe = resultSet.getLong("neurologe");
				if(neurologe != null) {
					ArztKundeZuordnung zuordnung = new ArztKundeZuordnung();
					zuordnung.setArztpraxis(arztZuordnung.get(neurologe));
					zuordnung.setKunde(kunde);
					zuordnung.setHausarzt(false);
					aerzte.add(zuordnung);
				}
				Long zahnarzt = resultSet.getLong("zahnarzt");
				if(zahnarzt != null) {
					ArztKundeZuordnung zuordnung = new ArztKundeZuordnung();
					zuordnung.setArztpraxis(arztZuordnung.get(zahnarzt));
					zuordnung.setKunde(kunde);
					zuordnung.setHausarzt(false);
					aerzte.add(zuordnung);
				}
				
				kunde.setChroniker(resultSet.getString("chroniker")
						.equals("JA") ? true : false);
				kunde.setInkontinent(resultSet.getString("inkontinent").equals(
						"JA") ? true : false);

				kundenListe.add(kunde);
			}
			resultSet.close();
			con.close();
			kundenService.saveAllKunden(kundenListe);
		} catch (Exception e) {
			System.out.println("does not added:" + e);
			e.printStackTrace();
		}
	}
}
