package org.soni;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;


public class Main {
	public static void main(String[] args) {
		Configuration configuration=new Configuration().configure("user.cfg.xml");
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
		SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		Session session=sessionFactory.openSession();
		
		UserDetails userDetails=new UserDetails();
		userDetails.setUserName("Suyash");
		
		Address address=new Address();
		address.setCityName("Bangalore");
		address.setPinCode(36920);
		address.setStateName("Karnataka");
		
		userDetails.setAddress(address);
		address.setUserDetails(userDetails);
		
		session.beginTransaction();
		
		try{
			session.save(userDetails);
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
