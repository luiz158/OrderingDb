package com.orderingdb;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.entities.ListOfItem;
import com.orderingdb.dao.ItemDAO;
import com.orderingdb.util.OrderingConstants;

@ManagedBean(name="item")
@SessionScoped
public class ItemsAction {
	private List<ListOfItem> listOfItems;
	private List<ListOfItem> filteredItems;
	private FacesContext context;
	private ItemDAO itemDao;
	
	public List<ListOfItem> getListOfItems() {
		return listOfItems;
	}

	public void setListOfItems(List<ListOfItem> listOfItems) {
		this.listOfItems = listOfItems;
	}

	public List<ListOfItem> getFilteredItems() {
		return filteredItems;
	}

	public void setFilteredItems(List<ListOfItem> filteredItems) {
		this.filteredItems = filteredItems;
	}

	public ItemsAction() {
		itemDao = new ItemDAO();
		context = FacesContext.getCurrentInstance();
	}
	
	public String ListAllItems(){
		List<ListOfItem> listofItems;
		try {
			listofItems = itemDao.getItems();
			this.listOfItems = (listofItems!=null)?listofItems:new ArrayList<ListOfItem>();
		} catch (Exception e) {
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,OrderingConstants.criticalError,
					null));
		}
		return "/Items/ListOfItems.xhtml?faces-redirect=true";
	}
}
