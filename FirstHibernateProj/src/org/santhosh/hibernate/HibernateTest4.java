/**
 * 
 */
package org.santhosh.hibernate;

import org.actuate.santhosh.dto.UserDetails3;
import org.actuate.santhosh.dto.Vehicle;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * @author user
 *
 */
public class HibernateTest4 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		UserDetails3 user = new UserDetails3();
		user.setUserName("First User");
		
		UserDetails3 user2 = new UserDetails3();
		user2.setUserName("Second User");
		
		Vehicle vehicle = new Vehicle();
		vehicle.setVehicleName("CAR");
		
		Vehicle vehicle2 = new Vehicle();
		vehicle2.setVehicleName("JEEP");
		
		user.getVehicle().add(vehicle);
		user.getVehicle().add(vehicle2);
		
		user2.getVehicle().add(vehicle);
		user2.getVehicle().add(vehicle2);
		
		vehicle.getUserList().add(user);
		vehicle2.getUserList().add(user);
		
		vehicle.getUserList().add(user2);
		vehicle2.getUserList().add(user2);
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(user);
		session.save(user2);
		session.save(vehicle);
		session.save(vehicle2);
		session.getTransaction().commit();
		session.close();
	}

}
