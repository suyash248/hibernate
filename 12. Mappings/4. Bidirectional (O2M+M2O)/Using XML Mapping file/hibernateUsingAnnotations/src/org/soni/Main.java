package org.soni;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {
	public static void main(String[] args) {
		SessionFactory sessionFactory=new Configuration().configure("user.cfg.xml").buildSessionFactory();
		Session session=sessionFactory.openSession();
		
		UserDetails userDetails=new UserDetails();
		userDetails.setUserName("First User");
		
		Vehicle vehicle=new Vehicle();
		vehicle.setVehicleName("Car");
		vehicle.setVehicleOwner("Sunny");
		vehicle.setUserDetials(userDetails);
		
		Vehicle vehicle2=new Vehicle();
		vehicle2.setVehicleName("Bike");
		vehicle2.setVehicleOwner("Abhi");
		vehicle2.setUserDetials(userDetails);
		
		Vehicle vehicle3=new Vehicle();
		vehicle3.setVehicleName("Cycle");
		vehicle3.setVehicleOwner("Pandey");
		vehicle3.setUserDetials(userDetails);
		
		userDetails.getVehicles().add(vehicle);
		userDetails.getVehicles().add(vehicle2);
		userDetails.getVehicles().add(vehicle3);
		
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
