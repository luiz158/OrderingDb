package com.entities;

import java.io.Serializable;
import javax.persistence.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the order_requests database table.
 * 
 */
@Entity
@Table(name="order_requests")
public class OrderRequest implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="request_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int requestId;

	private String cat_No;

	private String comments;

	private BigDecimal cost;

	@Column(name="line_price")
	private BigDecimal linePrice;

	private String location;

	@Temporal(TemporalType.DATE)
	@Column(name="order_date")
	private Date orderDate;

	private BigDecimal quantity;

	private String received_By;

	@Temporal(TemporalType.DATE)
	private Date received_Date;

	private String reference_Num;

	@Temporal(TemporalType.DATE)
	private Date request_Date;

	private int secondary_Vendor;

	private BigDecimal size;

	//bi-directional many-to-one association to Item
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="item_Id")
	private Item item;

	//bi-directional many-to-one association to Order
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="order_Id")
	private Order order;

	//bi-directional many-to-one association to User
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="requested_by")
	private User user;

	//bi-directional many-to-one association to Vendor
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="vendor_Id")
	private Vendor vendor;

	//bi-directional many-to-one association to GrantShare
	@OneToMany(mappedBy="orderRequest")
	private List<GrantShare> grantShares;
	
	private String status;
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public OrderRequest() {
	}

	public int getRequestId() {
		return this.requestId;
	}

	public void setRequestId(int requestId) {
		this.requestId = requestId;
	}

	public String getCat_No() {
		return this.cat_No;
	}

	public void setCat_No(String cat_No) {
		this.cat_No = cat_No;
	}

	public String getComments() {
		return this.comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public BigDecimal getCost() {
		return this.cost;
	}

	public void setCost(BigDecimal cost) {
		this.cost = cost;
	}

	public BigDecimal getLinePrice() {
		return this.linePrice;
	}

	public void setLinePrice(BigDecimal linePrice) {
		this.linePrice = linePrice;
	}

	public String getLocation() {
		return this.location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Date getOrderDate() {
		return this.orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public BigDecimal getQuantity() {
		return this.quantity;
	}

	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}

	public String getReceived_By() {
		return this.received_By;
	}

	public void setReceived_By(String received_By) {
		this.received_By = received_By;
	}

	public Date getReceived_Date() {
		return this.received_Date;
	}

	public void setReceived_Date(Date received_Date) {
		this.received_Date = received_Date;
	}

	public String getReference_Num() {
		return this.reference_Num;
	}

	public void setReference_Num(String reference_Num) {
		this.reference_Num = reference_Num;
	}

	public Date getRequest_Date() {
		return this.request_Date;
	}

	public void setRequest_Date(Date request_Date) {
		this.request_Date = request_Date;
	}

	public int getSecondary_Vendor() {
		return this.secondary_Vendor;
	}

	public void setSecondary_Vendor(int secondary_Vendor) {
		this.secondary_Vendor = secondary_Vendor;
	}

	public BigDecimal getSize() {
		return this.size;
	}

	public void setSize(BigDecimal size) {
		this.size = size;
	}

	public Item getItem() {
		return this.item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public Order getOrder() {
		return this.order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Vendor getVendor() {
		return this.vendor;
	}

	public void setVendor(Vendor vendor) {
		this.vendor = vendor;
	}

	public List<GrantShare> getGrantShares() {
		return this.grantShares;
	}

	public void setGrantShares(List<GrantShare> grantShares) {
		this.grantShares = grantShares;
	}
	
//	public void addItem(Item it)
//	{
//		it.s
//	}

}