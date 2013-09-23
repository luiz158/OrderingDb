package com.orderingdb.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class SQLConnection {

	public static EntityManager getConnection() throws Exception
	{
		EntityManagerFactory entityManagerFactory =  Persistence.createEntityManagerFactory("HibernateTest");
	    EntityManager em = entityManagerFactory.createEntityManager();
	    return em;
	}
}
