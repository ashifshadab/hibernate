package com.ashifshadab.config;

import java.io.File;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/*The following code loads the configuration programmatically. If you have a very specific use case to
configure programmatically, you can use this method; otherwise, the preferred way is to use annotations.*/

public class HibernateConfig {

	public SessionFactory getSessionFactory() {

		SessionFactory sessionFactory = null;

		Configuration configuration = getConfigurationAddResource();
		
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties()).build();

		sessionFactory = configuration.buildSessionFactory(serviceRegistry);

		return sessionFactory;
	}

	

	private Configuration getConfigurationAddResource() {

		Configuration configuration = new Configuration();

		configuration.addResource("Product.hbm.xml").addResource("Seller.hbm.xml");
				

		return configuration;
	}

	
}
