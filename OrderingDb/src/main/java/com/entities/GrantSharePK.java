package com.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the grant_share database table.
 * 
 */
@Embeddable
public class GrantSharePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="request_id")
	private int requestId;

	@Column(name="account_id")
	private int accountId;

	public GrantSharePK() {
	}
	public int getRequestId() {
		return this.requestId;
	}
	public void setRequestId(int requestId) {
		this.requestId = requestId;
	}
	public int getAccountId() {
		return this.accountId;
	}
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof GrantSharePK)) {
			return false;
		}
		GrantSharePK castOther = (GrantSharePK)other;
		return 
			(this.requestId == castOther.requestId)
			&& (this.accountId == castOther.accountId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.requestId;
		hash = hash * prime + this.accountId;
		
		return hash;
	}
}