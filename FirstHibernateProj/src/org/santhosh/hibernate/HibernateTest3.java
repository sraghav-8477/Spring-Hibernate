/**
 * 
 */
package org.santhosh.hibernate;

import org.actuate.santhosh.dto.Address;
import org.actuate.santhosh.dto.UserDetails1;
import org.actuate.santhosh.dto.UserDetails2;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * @author user
 *
 */
public class HibernateTest3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UserDetails2 user = new UserDetails2();
		user.setUserName("Second User");
		user.setEmailId("firstname.secondname@companyname.com");
		Address addr = new Address();
		addr.setStreet("SEVENTH STREET NAME");
		addr.setCity("SEVENTH CITY NAME");
		addr.setState("SEVENTH STATE NAME");
		addr.setPincode("700007");
		
		user.getListOfAddress().add(addr);
		
		Address addr1 = new Address();
		addr1.setStreet("EIGHTH STREET NAME");
		addr1.setCity("EIGHTH CITY NAME");
		addr1.setState("EIGHTH STATE NAME");
		addr1.setPincode("800008");
		
		user.getListOfAddress().add(addr1);
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
		session.close();
	}

}
