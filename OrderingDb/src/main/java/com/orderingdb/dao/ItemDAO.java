package com.orderingdb.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.entities.ListOfItem;

public class ItemDAO {
	
	@SuppressWarnings("unchecked")
	public List<ListOfItem> getItems() throws Exception {
		List<ListOfItem> items = null;
		EntityManager em = null;
		try {
			em = SQLConnection.getConnection();
			Query query = em.createQuery("FROM ListOfItem");
			items= query.getResultList();
	} finally {
			if (em != null)
				em.close();
	}

	return items;
	}

}
