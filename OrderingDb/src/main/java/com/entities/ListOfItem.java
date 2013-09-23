package com.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the list_of_items database table.
 * 
 */
@Entity
@Table(name="list_of_items")
public class ListOfItem implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ListOfItemPK id;

	private BigDecimal price;

	//bi-directional many-to-one association to Item
	@ManyToOne
	@JoinColumn(name="item_id", insertable=false, updatable=false)
	private Item item;

	//bi-directional many-to-one association to Vendor
	@ManyToOne
	@JoinColumn(name="vendor_id", insertable=false, updatable=false)
	private Vendor vendor;

	public ListOfItem() {
	}

	public ListOfItemPK getId() {
		return this.id;
	}

	public void setId(ListOfItemPK id) {
		this.id = id;
	}

	public BigDecimal getPrice() {
		return this.price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Item getItem() {
		return this.item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public Vendor getVendor() {
		return this.vendor;
	}

	public void setVendor(Vendor vendor) {
		this.vendor = vendor;
	}

}