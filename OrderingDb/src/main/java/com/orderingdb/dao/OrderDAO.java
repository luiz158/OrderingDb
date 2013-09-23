package com.orderingdb.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.entities.*;

public class OrderDAO {

	@SuppressWarnings("unchecked")
	public List<OrderRequest> getOrdersRequests() throws Exception {
		List<OrderRequest> ordReq = new ArrayList<OrderRequest>();
		EntityManager em = null;
		try {
			em = SQLConnection.getConnection();
			Query query = em.createQuery("FROM OrderRequest where status='requested' order by request_Date");
			ordReq.addAll(query.getResultList());
			query = em.createQuery("FROM OrderRequest where status='ordered' order by orderDate");
			ordReq.addAll(query.getResultList());
			query = em.createQuery("FROM OrderRequest where status='received' order by received_Date");
			ordReq.addAll(query.getResultList());
		} finally {
			if (em != null)
				em.close();
		}

		return ordReq;
	}

	/**
	 * To delete an order
	 * 
	 * @param orderId
	 */
	public void deleteOrder(String orderId) throws Exception {
		EntityManager em = null;
		try {
			em = SQLConnection.getConnection();
			em.getTransaction().begin();
			em.remove(em.find(OrderRequest.class, Integer.parseInt(orderId)));
			em.getTransaction().commit();

		} finally {
			if (em != null)
				em.close();
		}
	}

	/**
	 * This method updates the orderRequest object
	 * 
	 * @param orderRequest
	 */
	public void editOrder(OrderRequest orderRequest) throws Exception {
		EntityManager em = null;
		try {
			em = SQLConnection.getConnection();
			em.getTransaction().begin();
			em.merge(orderRequest);
			em.getTransaction().commit();
		} finally {
			if (em != null)
				em.close();
		}
	}

	/**
	 * This method is for creating order requests
	 * @param or
	 * @throws Exception
	 */
	public void createOrderRequest(OrderRequest or) throws Exception {
		EntityManager em = null;
		try {
			em = SQLConnection.getConnection();
			em.getTransaction().begin();
			em.persist(or);
			em.getTransaction().commit();

		} finally {
			if (em != null)
				em.close();
		}
	}

}
