package com.ashifshadab.app;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.ashifshadab.model.Product;

public class Test {

	public static void main(String[] args) {

		try (Session session = new Configuration().configure().buildSessionFactory().getCurrentSession()) {

			session.beginTransaction();

			Query query = session.createQuery("from Product");

			List<Product> products = query.list();

			products.forEach(product -> System.out.println(product));

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
