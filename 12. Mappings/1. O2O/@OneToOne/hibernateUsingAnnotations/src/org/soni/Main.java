package org.soni;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class Main {
	public static void main(String[] args) {
		SessionFactory sessionFactory=new Configuration().configure("user.cfg.xml").buildSessionFactory();
		Session session=sessionFactory.openSession();
		Vehicle vehicle=new Vehicle();
		vehicle.setVehicleName("Audi");
		vehicle.setVehicleOwner("Suyash");
		
		UserDetails userDetails=new UserDetails();
		userDetails.setUserName("First User");
		userDetails.setVehicle(vehicle);

		session.beginTransaction();
		
		try{
			session.save(userDetails);
			session.save(vehicle);
			session.getTransaction().commit();
		}catch(Exception ex){
			ex.printStackTrace();
			session.getTransaction().rollback();
		}
		finally{
			session.close();
		}
	}
}
