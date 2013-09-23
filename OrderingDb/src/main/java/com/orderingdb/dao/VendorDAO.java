package com.orderingdb.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.entities.*;

public class VendorDAO {
	
	
	public List<Vendor> getVendorList()
	{
		EntityManager em = null;
		List<Vendor> vendList = null;
		try {
				em = SQLConnection.getConnection();
				vendList = em.createQuery("from Vendor").getResultList();
				

		} catch (Exception e) {
			e.printStackTrace();
		} 
		finally {
				if (em != null)
					em.close();
		}
	return vendList;
	}
	
	public void createVendor(Vendor vend) throws Exception
	{
		EntityManager em = null;
		try {
				em = SQLConnection.getConnection();
				em.getTransaction().begin();
				em.persist(vend);
				em.getTransaction().commit();
				
		}
		finally {
				if (em != null)
					em.close();
		}
	}
	
	public void deleteVendor(String vendId) throws Exception {
		EntityManager em = null;
		try {
				em = SQLConnection.getConnection();
				em.getTransaction().begin();
				em.remove(em.find(Vendor.class, Integer.parseInt(vendId)));
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
