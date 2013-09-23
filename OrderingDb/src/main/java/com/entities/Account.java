package com.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the accounts database table.
 * 
 */
@Entity
@Table(name="accounts")
public class Account implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="account_id")
	private int accountId;

	@Column(name="account_description")
	private String accountDescription;

	@Column(name="account_name")
	private String accountName;

	//bi-directional many-to-one association to GrantShare
	@OneToMany(mappedBy="account")
	private List<GrantShare> grantShares;

	public Account() {
	}

	public int getAccountId() {
		return this.accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public String getAccountDescription() {
		return this.accountDescription;
	}

	public void setAccountDescription(String accountDescription) {
		this.accountDescription = accountDescription;
	}

	public String getAccountName() {
		return this.accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public List<GrantShare> getGrantShares() {
		return this.grantShares;
	}

	public void setGrantShares(List<GrantShare> grantShares) {
		this.grantShares = grantShares;
	}

}