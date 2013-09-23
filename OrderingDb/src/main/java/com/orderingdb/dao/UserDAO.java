package com.orderingdb.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.entities.User;
import com.entities.UserRole;

public class UserDAO {
	
	/**
	 * Get the list of users of the application
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<UserRole> getUserRoleList()
	{
		EntityManager em = null;
		List<UserRole> userRoleList = null;
		try {
				em = SQLConnection.getConnection();
				userRoleList = em.createQuery("from UserRole").getResultList();
				

		} catch (Exception e) {
			e.printStackTrace();
		} 
		finally {
				if (em != null)
					em.close();
		}
	return userRoleList;
	}
	
	/**
	 * Get the list of users of the application
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<User> getUserList()
	{
		EntityManager em = null;
		List<User> userList = null;
		try {
				em = SQLConnection.getConnection();
				userList = em.createQuery("from User").getResultList();
				

		} catch (Exception e) {
			e.printStackTrace();
		} 
		finally {
				if (em != null)
					em.close();
		}
	return userList;
	}
	
	/**
	 * Creates a new user
	 * @param user
	 * @throws Exception
	 */
	public void createUser(User user) throws Exception
	{
		EntityManager em = null;
		try {
				em = SQLConnection.getConnection();
				em.getTransaction().begin();
				em.persist(user);
				em.getTransaction().commit();
				
		}
		finally {
				if (em != null)
					em.close();
		}
	}
	
	/**
	 * 
	 * @param userId
	 * @throws Exception
	 */
	public void deleteUser(String userId) throws Exception {
		EntityManager em = null;
		try {
				em = SQLConnection.getConnection();
				em.getTransaction().begin();
				em.remove(em.find(User.class, Integer.parseInt(userId)));
				em.getTransaction().commit();

		}  finally {
			try {
				if (em != null)
					em.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
