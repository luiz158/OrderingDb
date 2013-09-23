package com.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the user_roles database table.
 * 
 */
@Entity
@Table(name="user_roles")
public class UserRole implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="role_id")
	private int roleId;

	@Column(name="role_details")
	private String roleDetails;

	@Column(name="role_name")
	private String roleName;

	public UserRole() {
	}

	public int getRoleId() {
		return this.roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public String getRoleDetails() {
		return this.roleDetails;
	}

	public void setRoleDetails(String roleDetails) {
		this.roleDetails = roleDetails;
	}

	public String getRoleName() {
		return this.roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

}