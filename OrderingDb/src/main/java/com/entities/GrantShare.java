package com.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the grant_share database table.
 * 
 */
@Entity
@Table(name="grant_share")
public class GrantShare implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private GrantSharePK id;

	private String comments;

	private int percentage;

	//bi-directional many-to-one association to OrderRequest
	@ManyToOne
	@JoinColumn(name="request_id", insertable=false, updatable=false)
	private OrderRequest orderRequest;

	//bi-directional many-to-one association to Account
	@ManyToOne
	@JoinColumn(name="account_id", insertable=false, updatable=false)
	private Account account;

	public GrantShare() {
	}

	public GrantSharePK getId() {
		return this.id;
	}

	public void setId(GrantSharePK id) {
		this.id = id;
	}

	public String getComments() {
		return this.comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public int getPercentage() {
		return this.percentage;
	}

	public void setPercentage(int percentage) {
		this.percentage = percentage;
	}

	public OrderRequest getOrderRequest() {
		return this.orderRequest;
	}

	public void setOrderRequest(OrderRequest orderRequest) {
		this.orderRequest = orderRequest;
	}

	public Account getAccount() {
		return this.account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

}