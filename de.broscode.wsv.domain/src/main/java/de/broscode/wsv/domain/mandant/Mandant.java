package de.broscode.wsv.domain.mandant;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import de.broscode.wsv.domain.HasId;

@Entity
public class Mandant implements HasId {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6065647328261132133L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String name;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
