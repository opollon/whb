package de.broscode.wsv.domain.arzt;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import de.broscode.wsv.domain.HasId;

@Entity
public class Arztpraxis implements HasId {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5768661328161572418L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Enumerated
	private ArztArt arztArt;
	
	@Column
	private String praxisName;
	
	@Column
	private String kuerzel;

	
	public ArztArt getArztArt() {
		return arztArt;
	}

	public void setArztArt(ArztArt arztArt) {
		this.arztArt = arztArt;
	}

	public String getPraxisName() {
		return praxisName;
	}

	public void setPraxisName(String praxisName) {
		this.praxisName = praxisName;
	}

	public String getKuerzel() {
		return kuerzel;
	}

	public void setKuerzel(String kuerzel) {
		this.kuerzel = kuerzel;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public Long getId() {
		return this.id;
	}
	
	

}
