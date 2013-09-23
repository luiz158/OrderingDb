package com.orderingdb.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.entities.Account;

public class AccountDAO {
	
	public List<Account> getAccountList()
	{
		EntityManager em = null;
		List<Account> accList = null;
		try {
				em = SQLConnection.getConnection();
				accList = em.createQuery("from Account").getResultList();
				

		} catch (Exception e) {
			e.printStackTrace();
		} 
		finally {
				if (em != null)
					em.close();
		}
	return accList;
	}
	
	public void createAccount(Account acc) throws Exception
	{
		EntityManager em = null;
		try {
				em = SQLConnection.getConnection();
				em.getTransaction().begin();
				em.persist(acc);
				em.getTransaction().commit();
				
		}
		finally {
				if (em != null)
					em.close();
		}
	}
	
	public void deleteAccount(String accId) throws Exception {
		EntityManager em = null;
		try {
				em = SQLConnection.getConnection();
				em.getTransaction().begin();
				em.remove(em.find(Account.class, Integer.parseInt(accId)));
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
