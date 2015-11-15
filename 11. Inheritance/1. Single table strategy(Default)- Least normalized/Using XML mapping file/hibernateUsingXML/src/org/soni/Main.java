package org.soni;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class Main {
	public static void main(String[] args) {
		Configuration configuration = new Configuration().configure("user.cfg.xml");
		ServiceRegistry serviceRegistry=new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
		SessionFactory sessionFactory=configuration.buildSessionFactory(serviceRegistry);
		Session session=sessionFactory.openSession();
		
		Vehicle vehicle=new Vehicle();
		vehicle.setVehicleName("Audi");
		vehicle.setVehicleOwner("Suyash");
		
		TwoWheeler twoWheeler = new TwoWheeler();
		twoWheeler.setVehicleName("Bike");
		twoWheeler.setVehicleOwner("Abhi");
		twoWheeler.setSteeringHandle("TwoHandle");
		
		FourWheeler fourWheeler = new FourWheeler();
		fourWheeler.setVehicleName("Car");
		fourWheeler.setVehicleOwner("Pappu");
		fourWheeler.setSteeringWheel("FourWheel");
		
		session.beginTransaction();
		
		try{
			session.save(vehicle);
			session.save(twoWheeler);
			session.save(fourWheeler);
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
