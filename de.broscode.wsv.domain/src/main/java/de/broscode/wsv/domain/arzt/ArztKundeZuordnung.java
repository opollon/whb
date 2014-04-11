package de.broscode.wsv.domain.arzt;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import de.broscode.wsv.domain.HasId;
import de.broscode.wsv.domain.personen.Kunde;

@Entity
public class ArztKundeZuordnung implements HasId {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4601516016622460500L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column
	private boolean hausarzt;
	
	@ManyToOne
	@JoinColumn(name="kunde_fk")
	private Kunde kunde;
	
	@ManyToOne
	@JoinColumn(name="arztpraxis_fk")
	private Arztpraxis arztpraxis;
	
	
	public boolean isHausarzt() {
		return hausarzt;
	}

	public void setHausarzt(boolean hausarzt) {
		this.hausarzt = hausarzt;
	}

	public Kunde getKunde() {
		return kunde;
	}

	public void setKunde(Kunde kunde) {
		this.kunde = kunde;
	}

	public Arztpraxis getArztpraxis() {
		return arztpraxis;
	}

	public void setArztpraxis(Arztpraxis arztpraxis) {
		this.arztpraxis = arztpraxis;
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
