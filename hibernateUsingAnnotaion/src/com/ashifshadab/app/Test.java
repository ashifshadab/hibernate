package com.ashifshadab.app;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;

import com.ashifshadab.model.Seller;

public class Test {

	public static void main(String[] args) {
		
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();  
	    Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();  
	  
	SessionFactory factory = meta.getSessionFactoryBuilder().build();  
	Session session = factory.openSession();  

		try  {

			session.beginTransaction();

			Query query = session.createQuery("from Seller");

			List<Seller> sellers = query.list();

			sellers.forEach(seller -> System.out.println(seller));

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
