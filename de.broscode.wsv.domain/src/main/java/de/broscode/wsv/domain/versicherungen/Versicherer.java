package de.broscode.wsv.domain.versicherungen;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import de.broscode.wsv.domain.HasId;
import de.broscode.wsv.domain.personen.Adresse;

@Entity
public class Versicherer implements HasId{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3271111140829299392L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Versicherungstyp getVersicherungstyp() {
		return versicherungstyp;
	}

	public void setVersicherungstyp(Versicherungstyp versicherungstyp) {
		this.versicherungstyp = versicherungstyp;
	}


	@OneToOne
	@JoinColumn(name="adresse_fk")
	private Adresse adresse;
	
	@Column
	private String name;
	
	@Enumerated
	private Versicherungstyp versicherungstyp;
}
