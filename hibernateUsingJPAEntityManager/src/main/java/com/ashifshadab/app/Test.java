package com.ashifshadab.app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.ashifshadab.model.Seller;

public class Test {

	private static final EntityManagerFactory emFactoryObj;
	private static final String PERSISTENCE_UNIT_NAME = "JPADemo";	

	static {
		emFactoryObj = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
	}

	// This Method Is Used To Retrieve The 'EntityManager' Object
	public static EntityManager getEntityManager() {
		return emFactoryObj.createEntityManager();
	}
	
	public static void main(String[] args) {
		
		EntityManager entityMgr = getEntityManager();
		entityMgr.getTransaction().begin();
		
		Seller seller=entityMgr.find(Seller.class, "MAS");
		
		System.out.println(seller);

		

	}
}
