/**
 * 
 */
package com.orderingdb;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;
import javax.faces.view.facelets.FaceletContext;

import com.orderingdb.dao.LoginDAO;
import com.orderingdb.util.OrderingConstants;

/**
 * @author Anusha Sunkenapally
 *
 */

@ManagedBean
@SessionScoped
public class Login {
	private String username;
	private List<SelectItem> usernames;
	
		
	public void setUsernames(List<SelectItem> usernames) {
		this.usernames = usernames;
	}
	
	public List<SelectItem> getUsernames() {
		return usernames;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	
	public void getUsernameList(){
		LoginDAO login = new LoginDAO();
		usernames = new ArrayList<SelectItem>();
		try {
			List<String> users = login.getUserNames();
			for (String user: users) {
				usernames.add(new SelectItem(user));
			}
		} catch (SQLException e) {
			
		}
	}
		
}
