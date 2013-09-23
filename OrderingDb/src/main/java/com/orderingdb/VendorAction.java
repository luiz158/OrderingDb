package com.orderingdb;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.RowEditEvent;

import com.entities.Vendor;
import com.orderingdb.dao.VendorDAO;
import com.orderingdb.util.OrderingConstants;

@ManagedBean(name = "vendor")
@SessionScoped
public class VendorAction {

	private List<Vendor> vendors;
	private List<Vendor> filterVendor;
	private Vendor newVendor = new Vendor();
	private VendorDAO vendorDao;
	
	public VendorAction() {
		vendorDao = new VendorDAO();
	}

	public Vendor getNewVendor() {
		return newVendor;
	}

	public void setNewVendor(Vendor newVendor) {
		this.newVendor = newVendor;
	}

	public List<Vendor> getFilterVendor() {
		return filterVendor;
	}

	public void setFilterVendor(List<Vendor> filterVendor) {
		this.filterVendor = filterVendor;
	}

	public List<Vendor> getVendors() {
		return vendors;
	}

	public void setVendors(List<Vendor> vendors) {
		this.vendors = vendors;
	}
	
	/**
	 * This method is to retrieve all the vendor information to display on the vendor screen
	 * @return
	 */
	public String displayVendors(){
		vendors = (vendorDao.getVendorList()!=null?vendorDao.getVendorList():new ArrayList<Vendor>());
		return "/vendor/vendors.xhtml?faces-redirect=true";
	}
	
	public String goToCreateVendor(){
		return "/vendor/newVendor.xhtml?faces-redirect=true";
	}
	
	/**
	 * This method is used to create a new Vendor
	 * @param ae
	 */
	public void createNewVendor(){
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			vendorDao.createVendor(newVendor);
			context.addMessage(null, new FacesMessage(
					FacesMessage.SEVERITY_INFO,
					"New Vendor Created", "created"));
		} catch (Exception e) {
			context.addMessage(null, new FacesMessage(
					FacesMessage.SEVERITY_ERROR,
					OrderingConstants.criticalError, null));
		}
	}
	
	public void onEdit(RowEditEvent event) {
		Vendor editedVendor = (Vendor) event.getObject();
		System.out.println(editedVendor.getAddress());
	}
	
}
