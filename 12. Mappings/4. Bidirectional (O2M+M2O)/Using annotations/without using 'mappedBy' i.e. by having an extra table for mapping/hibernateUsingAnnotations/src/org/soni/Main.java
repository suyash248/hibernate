package org.soni;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class Main {
	public static void main(String[] args) {
		SessionFactory sessionFactory=new Configuration().configure("user.cfg.xml").buildSessionFactory();
		Session session=sessionFactory.openSession();
		
		UserDetails userDetails=new UserDetails();
		
		Vehicle vehicle=new Vehicle();
		vehicle.setVehicleName("Audi");
		vehicle.setVehicleOwner("Suyash");
		vehicle.setUserDetails(userDetails);
		
		Vehicle vehicle2=new Vehicle();
		vehicle2.setVehicleName("XUV");
		vehicle2.setVehicleOwner("Abhi");
		vehicle2.setUserDetails(userDetails);
		
		Vehicle vehicle3=new Vehicle();
		vehicle3.setVehicleName("Maruti");
		vehicle3.setVehicleOwner("Servent");
		vehicle3.setUserDetails(userDetails);
		
		userDetails.setUserName("First User");
		userDetails.getVehicle().add(vehicle);
		userDetails.getVehicle().add(vehicle2);
		userDetails.getVehicle().add(vehicle3);
		
		session.beginTransaction();
		
		try{
			session.save(userDetails);
			session.save(vehicle);
			session.save(vehicle2);
			session.save(vehicle3);
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
