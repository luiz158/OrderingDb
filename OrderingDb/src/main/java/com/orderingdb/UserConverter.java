package com.orderingdb;

import java.util.List;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.entities.User;
import com.orderingdb.dao.UserDAO;


@FacesConverter(value="userConverter")
public class UserConverter implements Converter{
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		UserDAO userDAO = new UserDAO();
		System.out.println(component.getAttributes().entrySet());
		System.out.println(context.getAttributes().entrySet());
		List<User> users = userDAO.getUserList();
		for(User use: users) {
			if(use.getUserName().equalsIgnoreCase(value)) {
				return use;
			}
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		User user = (User) arg2;
		return user.getUserName();
	}

}
