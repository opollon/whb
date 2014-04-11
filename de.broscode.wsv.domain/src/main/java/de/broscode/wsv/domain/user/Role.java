package de.broscode.wsv.domain.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import de.broscode.wsv.domain.HasId;

@Entity
public class Role  implements HasId{

	/**
	 * 
	 */
	private static final long serialVersionUID = -485930465726751993L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column (name="role_name")
	private String roleName;
	
	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
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
