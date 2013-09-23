package com.orderingdb.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.entities.User;


public class LoginDAO {


	public List<String> getUserNames() throws SQLException {
		List<String> usernames = new ArrayList<String>();
		List<User> users = null;
		EntityManager em = null;
		try {
				em = SQLConnection.getConnection();
				Query query = em.createQuery("FROM User");
				users= query.getResultList();
				
				for(User u : users)
				{
					usernames.add(u.getUserName());
				}
			
		} catch(Exception e) {
			e.printStackTrace();
		 
		} finally {
			if(em != null)
				em.close();			
		}
		return usernames;
	}
}
