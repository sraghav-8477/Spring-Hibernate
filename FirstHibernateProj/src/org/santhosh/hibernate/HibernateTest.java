/**
 * 
 */
package org.santhosh.hibernate;

import java.util.Date;

import org.actuate.santhosh.dto.Address;
import org.actuate.santhosh.dto.UserDetails;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * @author user
 *
 */
public class HibernateTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UserDetails user = new UserDetails();
		user.setUserName("First User");
		Address addr = new Address();
		addr.setStreet("HOME STREET NAME");
		addr.setCity("HOME CITY NAME");
		addr.setState("HOME STATE NAME");
		addr.setPincode("HOME PINCODE");
		
		user.setHomeaddress(addr);
		
		Address addr1 = new Address();
		addr1.setStreet("OFFICE STREET NAME");
		addr1.setCity("OFFICE CITY NAME");
		addr1.setState("OFFICE STATE NAME");
		addr1.setPincode("OFFICE PINCODE");
		
		user.setOfficeAddress(addr1);
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
		session.close();
	}
}
