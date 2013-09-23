package com.entities;

import java.io.Serializable;
import javax.persistence.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the orders database table.
 * 
 */
@Entity
@Table(name="orders")
public class Order implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="order_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int orderId;

	@Temporal(TemporalType.DATE)
	@Column(name="delivery_date")
	private Date deliveryDate;

	@Temporal(TemporalType.DATE)
	@Column(name="order_date")
	private Date orderDate;

	@Column(name="order_ref_num")
	private String orderRefNum;

	@Column(name="total_cost")
	private BigDecimal totalCost;

	//bi-directional many-to-one association to OrderRequest
	@OneToMany(mappedBy="order")
	private List<OrderRequest> orderRequests;

	//bi-directional many-to-one association to Vendor
	@ManyToOne
	@JoinColumn(name="vendor_Id")
	private Vendor vendor;

	public Order() {
	}

	public int getOrderId() {
		return this.orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public Date getDeliveryDate() {
		return this.deliveryDate;
	}

	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public Date getOrderDate() {
		return this.orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public String getOrderRefNum() {
		return this.orderRefNum;
	}

	public void setOrderRefNum(String orderRefNum) {
		this.orderRefNum = orderRefNum;
	}

	public BigDecimal getTotalCost() {
		return this.totalCost;
	}

	public void setTotalCost(BigDecimal totalCost) {
		this.totalCost = totalCost;
	}

	public List<OrderRequest> getOrderRequests() {
		return this.orderRequests;
	}

	public void setOrderRequests(List<OrderRequest> orderRequests) {
		this.orderRequests = orderRequests;
	}

	public Vendor getVendor() {
		return this.vendor;
	}

	public void setVendor(Vendor vendor) {
		this.vendor = vendor;
	}

}