package de.broscode.wsv.domain.personen;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import de.broscode.wsv.domain.HasId;

@Entity
public class Adresse implements HasId{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6840030889530836140L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column
	private String strasse;
	@Column
	private String hausnummer;
	@Column
	private int plz;
	@Column
	private String ort;
	@Enumerated
	private Adresstyp adresstyp;

	public Adresstyp getAdresstyp() {
		return adresstyp;
	}

	public void setAdresstyp(Adresstyp adresstyp) {
		this.adresstyp = adresstyp;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStrasse() {
		return strasse;
	}

	public void setStrasse(String strasse) {
		this.strasse = strasse;
	}

	public String getHausnummer() {
		return hausnummer;
	}

	public void setHausnummer(String hausnummer) {
		this.hausnummer = hausnummer;
	}

	public int getPlz() {
		return plz;
	}

	public void setPlz(int plz) {
		this.plz = plz;
	}

	public String getOrt() {
		return ort;
	}

	public void setOrt(String ort) {
		this.ort = ort;
	}
}
