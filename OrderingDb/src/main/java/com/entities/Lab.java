package com.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the labs database table.
 * 
 */
@Entity
@Table(name="labs")
public class Lab implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="lab_id")
	private int labId;

	private String comments;

	@Column(name="lab_name")
	private String labName;

	private String supervisor;

	public Lab() {
	}

	public int getLabId() {
		return this.labId;
	}

	public void setLabId(int labId) {
		this.labId = labId;
	}

	public String getComments() {
		return this.comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getLabName() {
		return this.labName;
	}

	public void setLabName(String labName) {
		this.labName = labName;
	}

	public String getSupervisor() {
		return this.supervisor;
	}

	public void setSupervisor(String supervisor) {
		this.supervisor = supervisor;
	}

}