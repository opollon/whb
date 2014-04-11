package de.broscode.wsv.domain.personen;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import de.broscode.wsv.domain.HasId;

@Entity
public class Person implements HasId{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3539265214585994466L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column
	private String name;

	@Column
	private String vorname;
	
	@Column
	private String geburtsname;
	
	@Enumerated
	private Geschlecht geschlecht;
	
	@Column
	private String titel;
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
    @JoinColumn(name="person_fk")
	private Set<Adresse> adressen;

	public Set<Adresse> getAdressen() {
		return adressen;
	}
	public void setAdressen(Set<Adresse> adressen) {
		this.adressen = adressen;
	}
	public Geschlecht getGeschlecht() {
		return geschlecht;
	}
	public void setGeschlecht(Geschlecht geschlecht) {
		this.geschlecht = geschlecht;
	}
	public String getTitel() {
		return titel;
	}
	public void setTitel(String titel) {
		this.titel = titel;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getVorname() {
		return vorname;
	}
	public void setVorname(String vorname) {
		this.vorname = vorname;
	}
	public String getGeburtsname() {
		return geburtsname;
	}
	public void setGeburtsname(String geburtsname) {
		this.geburtsname = geburtsname;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
}
