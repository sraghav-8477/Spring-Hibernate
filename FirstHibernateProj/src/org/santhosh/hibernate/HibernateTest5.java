/**
 * 
 */
package org.santhosh.hibernate;

import org.actuate.santhosh.dto.UserDetails3;
import org.actuate.santhosh.dto.UserDetails4;
import org.actuate.santhosh.dto.Vehicle;
import org.actuate.santhosh.dto.Vehicle1;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * @author user
 *
 */
public class HibernateTest5 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		UserDetails4 user = new UserDetails4();
		user.setUserName("First User");
		
		Vehicle1 vehicle = new Vehicle1();
		vehicle.setVehicleName("HONDA BRIO CAR");
		
		Vehicle1 vehicle2 = new Vehicle1();
		vehicle2.setVehicleName("ASHOK LEYLAND TRUCK");
		
		user.getVehicle().add(vehicle);
		user.getVehicle().add(vehicle2);
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(user);
		session.save(vehicle);
		session.save(vehicle2);
		session.getTransaction().commit();
		session.close();
	}

}
