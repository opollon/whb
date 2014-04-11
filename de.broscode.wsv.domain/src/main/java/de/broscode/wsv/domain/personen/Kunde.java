package de.broscode.wsv.domain.personen;

import java.util.Date;
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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import de.broscode.wsv.domain.HasId;
import de.broscode.wsv.domain.arzt.ArztKundeZuordnung;
import de.broscode.wsv.domain.mandant.Mandant;
import de.broscode.wsv.domain.versicherungen.Versicherung;

@Entity
public class Kunde implements HasId{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6204939226721557272L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@OneToOne(cascade = CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="person_fk")
	private Person person;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="mandant_fk")
	private Mandant mandant;
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
    @JoinColumn(name="kunde_fk")
	private Set<Versicherung> versicherungen;
	
	@Column
	private Date geburtsdatum;
	
	@Column
	private String geburtsort;

	@Column
	private String geburtsland;
	
	@Enumerated
	private Konfession religion;
	
	@Enumerated
	private Familienstand familienstand;
	
	@Column
	private String nationalitaet;
	
	@Column
	private boolean chroniker;
	
	@Column
	private boolean inkontinent;
	
	@Column
	private String aktenzeichen;
	
	@Column
	private String ident_nr;
	
	@Column
	private Date eintritt;

	@Column
	private Date austritt;
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
    @JoinColumn(name="kunde_fk")
	private Set<ArztKundeZuordnung> aerzte;

	public String getGeburtsort() {
		return geburtsort;
	}

	public void setGeburtsort(String geburtsort) {
		this.geburtsort = geburtsort;
	}

	public String getGeburtsland() {
		return geburtsland;
	}

	public void setGeburtsland(String geburtsland) {
		this.geburtsland = geburtsland;
	}

	public Konfession getReligion() {
		return religion;
	}

	public void setReligion(Konfession religion) {
		this.religion = religion;
	}

	public Familienstand getFamilienstand() {
		return familienstand;
	}

	public void setFamilienstand(Familienstand familienstand) {
		this.familienstand = familienstand;
	}

	public String getNationalitaet() {
		return nationalitaet;
	}

	public void setNationalitaet(String nationalitaet) {
		this.nationalitaet = nationalitaet;
	}

	public boolean isChroniker() {
		return chroniker;
	}

	public void setChroniker(boolean chroniker) {
		this.chroniker = chroniker;
	}

	public boolean isInkontinent() {
		return inkontinent;
	}

	public void setInkontinent(boolean inkontinent) {
		this.inkontinent = inkontinent;
	}

	public String getAktenzeichen() {
		return aktenzeichen;
	}

	public void setAktenzeichen(String aktenzeichen) {
		this.aktenzeichen = aktenzeichen;
	}

	public String getIdent_nr() {
		return ident_nr;
	}

	public void setIdent_nr(String ident_nr) {
		this.ident_nr = ident_nr;
	}

	public Date getEintritt() {
		return eintritt;
	}

	public void setEintritt(Date eintritt) {
		this.eintritt = eintritt;
	}

	public Date getAustritt() {
		return austritt;
	}

	public void setAustritt(Date austritt) {
		this.austritt = austritt;
	}

	public Set<ArztKundeZuordnung> getAerzte() {
		return aerzte;
	}

	public void setAerzte(Set<ArztKundeZuordnung> aerzte) {
		this.aerzte = aerzte;
	}

	public Date getGeburtsdatum() {
		return geburtsdatum;
	}

	public void setGeburtsdatum(Date geburtsdatum) {
		this.geburtsdatum = geburtsdatum;
	}

	public Set<Versicherung> getVersicherungen() {
		return versicherungen;
	}

	public void setVersicherungen(Set<Versicherung> versicherungen) {
		this.versicherungen = versicherungen;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public Mandant getMandant() {
		return mandant;
	}

	public void setMandant(Mandant mandant) {
		this.mandant = mandant;
	}
}
