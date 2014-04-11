package de.broscode.wsv.domain.user;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import de.broscode.wsv.domain.HasId;
import de.broscode.wsv.domain.personen.Adresse;

@Entity
public class User implements HasId{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7646726334417424185L;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Column
	private String name;
	
	@Column
	private String password;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
    @JoinColumn(name="user_fk")
	private Set<Role> roles;

	public Set<Role> getRollen() {
		return roles;
	}
}
