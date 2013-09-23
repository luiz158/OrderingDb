package com.entities;

import java.io.Serializable;
import javax.persistence.*;

import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the users database table.
 * 
 */
@Entity
@Table(name="users")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private short user_Id;

	@Column(name="added_by")
	private String addedBy;

	@Column(name="added_date")
	private Timestamp addedDate;

	private String lab;

	@Column(name="modified_by")
	private String modifiedBy;

	@Column(name="modified_date")
	private Timestamp modifiedDate;

	private int role_Id;

	@Column(name="user_name")
	private String userName;

	@Column(name="user_status")
	private String userStatus;

	//bi-directional many-to-one association to OrderRequest
	@OneToMany(mappedBy="user")
	private List<OrderRequest> orderRequests;

	public User() {
	}

	public short getUser_Id() {
		return this.user_Id;
	}

	public void setUser_Id(short user_Id) {
		this.user_Id = user_Id;
	}

	public String getAddedBy() {
		return this.addedBy;
	}

	public void setAddedBy(String addedBy) {
		this.addedBy = addedBy;
	}

	public Timestamp getAddedDate() {
		return this.addedDate;
	}

	public void setAddedDate(Timestamp addedDate) {
		this.addedDate = addedDate;
	}

	public String getLab() {
		return this.lab;
	}

	public void setLab(String lab) {
		this.lab = lab;
	}

	public String getModifiedBy() {
		return this.modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public Timestamp getModifiedDate() {
		return this.modifiedDate;
	}

	public void setModifiedDate(Timestamp modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public int getRole_Id() {
		return this.role_Id;
	}

	public void setRole_Id(int role_Id) {
		this.role_Id = role_Id;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserStatus() {
		return this.userStatus;
	}

	public void setUserStatus(String userStatus) {
		this.userStatus = userStatus;
	}

	public List<OrderRequest> getOrderRequests() {
		return this.orderRequests;
	}

	public void setOrderRequests(List<OrderRequest> orderRequests) {
		this.orderRequests = orderRequests;
	}

}