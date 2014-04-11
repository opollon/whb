package de.broscode.wsv.domain.versicherungen;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import de.broscode.wsv.domain.HasId;

@Entity
public class Versicherung implements HasId {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2642969684247584252L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column
	private String versicherungsnummer;
	
	@ManyToOne
	@JoinColumn(name="versicherer_fk")
	Versicherer versicherer;
	
	public Versicherer getVersicherer() {
		return versicherer;
	}

	public void setVersicherer(Versicherer versicherer) {
		this.versicherer = versicherer;
	}

	public String getVersicherungsnummer() {
		return versicherungsnummer;
	}

	public void setVersicherungsnummer(String versicherungsnummer) {
		this.versicherungsnummer = versicherungsnummer;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public Long getId() {
		return id;
	}

}
