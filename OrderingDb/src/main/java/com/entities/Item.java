package com.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the items database table.
 * 
 */
@Entity
@Table(name="items")
public class Item implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int item_ID;

	private String item_Description;

	private String item_Name;

	//bi-directional many-to-one association to ListOfItem
	@OneToMany(mappedBy="item")
	private List<ListOfItem> listOfItems;

	//bi-directional many-to-one association to OrderRequest
	@OneToMany(mappedBy="item",cascade = CascadeType.ALL)
	private List<OrderRequest> orderRequests;

	public Item() {
	}

	public int getItem_ID() {
		return this.item_ID;
	}

	public void setItem_ID(int item_ID) {
		this.item_ID = item_ID;
	}

	public String getItem_Description() {
		return this.item_Description;
	}

	public void setItem_Description(String item_Description) {
		this.item_Description = item_Description;
	}

	public String getItem_Name() {
		return this.item_Name;
	}

	public void setItem_Name(String item_Name) {
		this.item_Name = item_Name;
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

}