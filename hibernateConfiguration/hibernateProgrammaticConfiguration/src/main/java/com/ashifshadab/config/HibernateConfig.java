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
		
		//Configuration configuration = getConfigurationByAddClass();
		
		//Configuration configuration = getConfigurationByAddJar();

		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties()).build();

		sessionFactory = configuration.buildSessionFactory(serviceRegistry);

		return sessionFactory;
	}

	/*
	 * The Configuration class provides the API to load the hbm files, to specify
	 * the driver to be used for the database connection, and to provide other
	 * connection details
	 */

	private Configuration getConfigurationAddResource() {

		Configuration configuration = new Configuration();

		configuration.addResource("Product.hbm.xml").addResource("Seller.hbm.xml")
				.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect")
				.setProperty("hibernate.connection.driver_class", "com.mysql.cj.jdbc.Driver")
				.setProperty("hibernate.connection.url",
						"jdbc:mysql://localhost:3306/ecommerce?useSSL=false&allowPublicKeyRetrieval=true")
				.setProperty("hibernate.connection.username", "ashif")
				.setProperty("hibernate.connection.password", "Flower@123");

		return configuration;
	}

	/*
	 * Instead of using addResource() to add the mapping files, you can also use
	 * addClass() to add a persistent class and let Hibernate load the mapping
	 * definition for this class:
	 * 
	 * If you are useing addClass() to add a persistent class then You have to put
	 * hbm.xml files at same package where your persistent classes are else you will
	 * got exception hibernate.properties not found
	 * org.hibernate.boot.MappingNotFoundException: Mapping (RESOURCE) not found :
	 * com/ashifshadab/model/Seller.hbm.xml :
	 * origin(com/ashifshadab/model/Seller.hbm.xml)
	 **/
	private Configuration getConfigurationByAddClass() {

		Configuration configuration = new Configuration();

		configuration.addClass(com.ashifshadab.model.Seller.class).addClass(com.ashifshadab.model.Product.class)
				.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect")
				.setProperty("hibernate.connection.driver_class", "com.mysql.cj.jdbc.Driver")
				.setProperty("hibernate.connection.url",
						"jdbc:mysql://localhost:3306/ecommerce?useSSL=false&allowPublicKeyRetrieval=true")
				.setProperty("hibernate.connection.username", "ashif")
				.setProperty("hibernate.connection.password", "Flower@123");

		return configuration;
	}
	
	/*
	 * If your application has hundreds of mapping definitions, 
	 * you can pack it in a JAR file and 
	 * add it to the Hibernate configuration. 
	 * This JAR file must be found in your application’s classpath:**/
	private Configuration getConfigurationByAddJar() {

		Configuration configuration = new Configuration();

		configuration.addJar(new File("mapping.jar"))
				.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect")
				.setProperty("hibernate.connection.driver_class", "com.mysql.cj.jdbc.Driver")
				.setProperty("hibernate.connection.url",
						"jdbc:mysql://localhost:3306/ecommerce?useSSL=false&allowPublicKeyRetrieval=true")
				.setProperty("hibernate.connection.username", "ashif")
				.setProperty("hibernate.connection.password", "Flower@123");

		return configuration;
	}
}
