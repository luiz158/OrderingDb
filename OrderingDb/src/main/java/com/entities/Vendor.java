package com.entities;

import java.io.Serializable;
import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the vendors database table.
 * 
 */
@Entity
@Table(name="vendors")
public class Vendor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int vendor_Id;

	private String address;

	private String city;

	private String comments;

	@Column(name="contact_name")
	private String contactName;

	@Column(name="contact_number")
	private String contactNumber;

	private String email;

	private String instructions;

	private String state;
	private String fax;

	private String vendor_Name;

	@Column(name="web_link")
	private String webLink;

	private String zip;

	//bi-directional many-to-one association to ListOfItem
	@OneToMany(mappedBy="vendor")
	private List<ListOfItem> listOfItems;

	//bi-directional many-to-one association to OrderRequest
	@OneToMany(mappedBy="vendor")
	private List<OrderRequest> orderRequests;

	//bi-directional many-to-one association to Order
	@OneToMany(mappedBy="vendor")
	private List<Order> orders;

	public Vendor() {
	}
	
	

	public String getFax() {
		return fax;
	}



	public void setFax(String fax) {
		this.fax = fax;
	}



	public int getVendor_Id() {
		return this.vendor_Id;
	}

	public void setVendor_Id(int vendor_Id) {
		this.vendor_Id = vendor_Id;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getComments() {
		return this.comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getContactName() {
		return this.contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public String getContactNumber() {
		return this.contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getInstructions() {
		return this.instructions;
	}

	public void setInstructions(String instructions) {
		this.instructions = instructions;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getVendor_Name() {
		return this.vendor_Name;
	}

	public void setVendor_Name(String vendor_Name) {
		this.vendor_Name = vendor_Name;
	}

	public String getWebLink() {
		return this.webLink;
	}

	public void setWebLink(String webLink) {
		this.webLink = webLink;
	}

	public String getZip() {
		return this.zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public List<ListOfItem> getListOfItems() {
		return this.listOfItems;
	}

	public void setListOfItems(List<ListOfItem> listOfItems) {
		this.listOfItems = listOfItems;
	}

	public List<OrderRequest> getOrderRequests() {
		return this.orderRequests;
	}

	public void setOrderRequests(List<OrderRequest> orderRequests) {
		this.orderRequests = orderRequests;
	}

	public List<Order> getOrders() {
		return this.orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

}