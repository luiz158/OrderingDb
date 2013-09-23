package com.orderingdb;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import org.primefaces.event.RowEditEvent;

import com.entities.User;
import com.entities.UserRole;
import com.orderingdb.dao.UserDAO;
import com.orderingdb.util.OrderingConstants;

@ManagedBean(name="user")
@SessionScoped
public class UserAction {
	private List<User> users;
	private List<User> filteredUsers;
	private UserDAO userDao;
	private User newUser;
	List<UserRole> userRoles;
	
	public List<UserRole> getUserRoles() {
		return userRoles;
	}



	public void setUserRoles(List<UserRole> userRoles) {
		this.userRoles = userRoles;
	}



	public User getNewUser() {
		return newUser;
	}



	public void setNewUser(User newUser) {
		this.newUser = newUser;
	}



	public UserAction() {
		userDao = new UserDAO();
	}



	public List<User> getUsers() {
		return users;
	}



	public void setUsers(List<User> users) {
		this.users = users;
	}



	public List<User> getFilteredUsers() {
		return filteredUsers;
	}



	public void setFilteredUsers(List<User> filteredUsers) {
		this.filteredUsers = filteredUsers;
	}



	public String listAllUsers() {
		List<User> users = userDao.getUserList();
		this.users = (users!=null)?users:new ArrayList<User>();
		return "/userAdmin/ListOfUsers.xhtml?faces-direct=true";
	}
	
	public String addUser() {
		List<UserRole> userRoles = userDao.getUserRoleList();
		this.userRoles = (userRoles!=null)?userRoles:new ArrayList<UserRole>();
		return "/userAdmin/AddUser.xhtml?faces-direct=true";
	}
	
	public String editUser() {
		return "/userAdmin/EditUser.xhtml?faces-direct=true";
	}
	
	public void onEdit(RowEditEvent ree) {
		System.out.println(((User)ree.getObject()).getUserName());
		System.out.println(((User)ree.getObject()).getLab());
		System.out.println(((User)ree.getObject()).getUserStatus());
	}
	
	public void createUser() {
		FacesContext context =  FacesContext.getCurrentInstance();
		Login login = (Login)context.getExternalContext().getSessionMap().get("login");
		List<SelectItem> users = login.getUsernames();
		for(SelectItem user:users) {
			if(user.getLabel().equalsIgnoreCase(newUser.getUserName())) {
				context.addMessage(null, new FacesMessage(
						FacesMessage.SEVERITY_ERROR,
						"User Name already exists", null));
				return;
			}
		}
		
		try {
			userDao.createUser(newUser);
			context.addMessage(null, new FacesMessage(
					FacesMessage.SEVERITY_INFO,
					"User created successfully", null));
			newUser = new User();
		} catch (Exception e) {
			context.addMessage(null, new FacesMessage(
					FacesMessage.SEVERITY_ERROR,
					OrderingConstants.criticalError, null));
		}
		
		
	}
}
