package com.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the list_of_items database table.
 * 
 */
@Embeddable
public class ListOfItemPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="item_id")
	private int itemId;

	@Column(name="vendor_id")
	private int vendorId;

	private long size;

	public ListOfItemPK() {
	}
	public int getItemId() {
		return this.itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public int getVendorId() {
		return this.vendorId;
	}
	public void setVendorId(int vendorId) {
		this.vendorId = vendorId;
	}
	public long getSize() {
		return this.size;
	}
	public void setSize(long size) {
		this.size = size;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof ListOfItemPK)) {
			return false;
		}
		ListOfItemPK castOther = (ListOfItemPK)other;
		return 
			(this.itemId == castOther.itemId)
			&& (this.vendorId == castOther.vendorId)
			&& (this.size == castOther.size);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.itemId;
		hash = hash * prime + this.vendorId;
		hash = hash * prime + ((int) (this.size ^ (this.size >>> 32)));
		
		return hash;
	}
}