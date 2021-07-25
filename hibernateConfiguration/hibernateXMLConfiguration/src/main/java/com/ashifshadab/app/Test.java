package com.ashifshadab.app;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.ashifshadab.model.Product;

public class Test {

	public static void main(String[] args) {
		
		/*This method loads the default hibernate.cfg.xml file from the root classpath. 
		 * The new Configuration() loads the hibernate.properties file, 
		 * and the configure() method loads the hibernate.cfg.xml file 
		 * if hibernate.properties isn’t found.**/
		Configuration configuration = new Configuration().configure();
		
		/*If you need to load another configuration file 
		 * located elsewhere (not in the root classpath), you can use the following code:
		 * This code looks for recipes.cfg.xml in the config subdirectory of the classpath.**/
		//Configuration configuration = new Configuration().configure("/config/recipes.cfg.xml");
		
		
		try (Session session = configuration.buildSessionFactory().getCurrentSession()) {

			session.beginTransaction();

			Query query = session.createQuery("from Product");

			List<Product> products = query.list();

			products.forEach(product -> System.out.println(product));

		} catch (Exception e) {
			e.printStackTrace();
		}
		

	}

}
