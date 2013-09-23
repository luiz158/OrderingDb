package com.orderingdb;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;

import org.primefaces.model.TreeNode;

import com.entities.*;
import com.orderingdb.dao.AccountDAO;
import com.orderingdb.dao.OrderDAO;
import com.orderingdb.dao.UserDAO;
import com.orderingdb.dao.VendorDAO;
import com.orderingdb.util.OrderingConstants;

@ManagedBean(name = "order")
@SessionScoped
public class OrderAction {

	private List<OrderRequest> orders;
	private OrderRequest newOrder;
	private OrderRequest updateOrder = new OrderRequest();
	private TreeNode navigation;
	private String selectedOrder;
	private String userString;
	private String vendorString;
	private String accountString;
	private String percentString;
	private List<SelectItem> vendors;
	private OrderDAO orderDao;
	private VendorDAO vendorDao;
	private UserDAO userDao;
	private AccountDAO acctDao;
	private FacesContext context;
	private String commentString;
	private List<GrantShare> grantShare = new ArrayList<GrantShare>();
	private GrantShare newGrant = new GrantShare();
	private List<User> users = new ArrayList<User>();
	private List<Account> accounts = new ArrayList<Account>();
	
	public String getCommentString() {
		return commentString;
	}

	public void setCommentString(String commentString) {
		this.commentString = commentString;
	}

	public String getAccountString() {
		return accountString;
	}

	public void setAccountString(String accountString) {
		this.accountString = accountString;
	}

	public String getPercentString() {
		return percentString;
	}

	public void setPercentString(String percentString) {
		this.percentString = percentString;
	}

	public String getVendorString() {
		return vendorString;
	}

	public void setVendorString(String vendorString) {
		this.vendorString = vendorString;
	}

	public String getUserString() {
		return userString;
	}

	public void setUserString(String userString) {
		this.userString = userString;
	}

	public GrantShare getNewGrant() {
		return newGrant;
	}

	public void setNewGrant(GrantShare newGrant) {
		this.newGrant = newGrant;
	}

	public List<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public List<SelectItem> getVendors() {
		return vendors;
	}

	public void setVendors(List<SelectItem> vendors) {
		this.vendors = vendors;
	}

	public List<OrderRequest> getOrders() {
		return orders;
	}

	public void setOrders(List<OrderRequest> orders) {
		this.orders = orders;
	}

	public OrderRequest getNewOrder() {
		return newOrder;
	}

	public void setNewOrder(OrderRequest newOrder) {
		this.newOrder = newOrder;
	}

	public OrderRequest getUpdateOrder() {
		return updateOrder;
	}

	public void setUpdateOrder(OrderRequest updateOrder) {
		this.updateOrder = updateOrder;
	}

	public String getSelectedOrder() {
		return selectedOrder;
	}

	public void setSelectedOrder(String selectedOrder) {
		this.selectedOrder = selectedOrder;
	}

	public TreeNode getNavigation() {
		return navigation;
	}

	public void setNavigation(TreeNode navigation) {
		this.navigation = navigation;
	}

	public List<GrantShare> getGrantShare() {
		return grantShare;
	}

	public void setGrantShare(List<GrantShare> grantShare) {
		this.grantShare = grantShare;
	}

	public OrderAction() {
		orderDao = new OrderDAO();
		vendorDao = new VendorDAO();
		userDao = new UserDAO();
		acctDao = new AccountDAO();
		context = FacesContext.getCurrentInstance();
	}

	/**
	 * To display all orders and requests when user enters the application
	 * 
	 * @return
	 */
	public String displayOrders() {
		try {
			orders = orderDao.getOrdersRequests();
			
			if (orders != null && orders.isEmpty()) {
				context.addMessage(null, new FacesMessage(
						FacesMessage.SEVERITY_INFO,
						OrderingConstants.orderingError, null));
			}
		} catch (Exception e) {
			context.addMessage(null, new FacesMessage(
					FacesMessage.SEVERITY_ERROR,
					OrderingConstants.criticalError, null));
		}
		return OrderingConstants.HOME_NAVIGATION;
	}

	/**
	 * This method is used for navigation fetch vendorList to create order
	 * screen
	 * 
	 * @return
	 */
	public String goToCreateOrder() {
		List<Vendor> vendorList = vendorDao.getVendorList();
		List<User> users = userDao.getUserList();
		List<Account> accounts = acctDao.getAccountList();
		this.users = (users != null) ? users : new ArrayList<User>();
		this.users = (users != null) ? users : new ArrayList<User>();
		this.accounts = (accounts != null) ? accounts
				: new ArrayList<Account>();

		vendors = new ArrayList<SelectItem>();
		for (Vendor vendor : vendorList) {
			vendors.add(new SelectItem(vendor.getVendor_Name()));
		}
		return "/Order/newOrderRequest.xhtml?faces-redirect=true";
	}

	/**
	 * This method is written to delete any order
	 * 
	 * @param actionEvent
	 */
	public void deleteOrder(ActionEvent actionEvent) {
		context = FacesContext.getCurrentInstance();
		String selectedOrder = context.getExternalContext()
				.getRequestParameterMap().get("selectedOrder");
		try {
			orderDao.deleteOrder(selectedOrder);
		} catch (Exception e) {
			context.addMessage(null, new FacesMessage(
					FacesMessage.SEVERITY_ERROR,
					OrderingConstants.criticalError, null));
		}
		displayOrders();
		context.addMessage(null, new FacesMessage("Successful",
				"Order Successfully deleted !!"));
	}

	/**
	 * This method will update the order details provided by the user
	 */
	public String editOrder() {
		OrderRequest orderRequest = null;
		FacesContext context = FacesContext.getCurrentInstance();
		// Updating the order request details
		try {
			// Acquiring the order object to be updated
			for (OrderRequest ordReq : orders) {
				if (ordReq.getRequestId() == updateOrder.getRequestId()) {
					orderRequest = ordReq;
					orderRequest.setReceived_By(updateOrder.getReceived_By());
					orderRequest.setReceived_Date(updateOrder
							.getReceived_Date());
					orderRequest.setLocation(updateOrder.getLocation());
					orderRequest.setStatus("received");
					break;
				}
			}

			orderDao.editOrder(orderRequest);
			context.addMessage(null, new FacesMessage("Message",
					"Order Request Updated successfully"));
		} catch (Exception e) {
			context.addMessage(null, new FacesMessage(
					FacesMessage.SEVERITY_ERROR,
					OrderingConstants.criticalError, null));
		}
		return null;

	}

	/**
	 * This method is written to add an account in new order request screen
	 */
	public String addAnAccount() {
		System.out.println(accountString + " hello  " + percentString);
		Account newAcct = null;
		for (Account act : accounts) {
			if (act.getAccountName().equalsIgnoreCase(accountString)) {
				newAcct = act;
				break;
			}
		}
		GrantShare grantShare = new GrantShare();
		grantShare.setAccount(newAcct);
		grantShare.setPercentage(Integer.parseInt(percentString));
		grantShare.setComments(commentString);
		accountString = "";
		percentString = "";
		commentString = "";

		this.grantShare.add(grantShare);
		return null;
	}

	public String createNewOrder() {
		return null;
	}

	public void createAnOrderRequest() {
		
		for(User user: users) {
			if(userString.equalsIgnoreCase(user.getUserName())) {
				this.newOrder.setUser(user);
				break;
			}
		}
		this.newOrder.setGrantShares(grantShare);
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			orderDao.createOrderRequest(newOrder);

		} catch (Exception e) {
			context.addMessage(null, new FacesMessage(
					FacesMessage.SEVERITY_ERROR,
					OrderingConstants.criticalError, null));
		}
	}
}
