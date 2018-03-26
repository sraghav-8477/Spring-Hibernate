/**
 * 
 */
package org.santhosh.hibernate;

import org.actuate.santhosh.dto.Address;
import org.actuate.santhosh.dto.UserDetails1;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * @author user
 *
 */
public class HibernateTest1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UserDetails1 user = new UserDetails1();
		user.setUserName("First User");
		Address addr = new Address();
		addr.setStreet("FIRST STREET NAME");
		addr.setCity("FIRST CITY NAME");
		addr.setState("FIRST STATE NAME");
		addr.setPincode("100001");
		
		user.getListOfAddress().add(addr);
		
		Address addr1 = new Address();
		addr1.setStreet("SECONS STREET NAME");
		addr1.setCity("SECOND CITY NAME");
		addr1.setState("SECOND STATE NAME");
		addr1.setPincode("200002");
		
		user.getListOfAddress().add(addr1);
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
		session.close();
	}

}
