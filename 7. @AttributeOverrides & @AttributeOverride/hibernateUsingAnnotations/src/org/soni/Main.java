package org.soni;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class Main {
	public static void main(String[] args) {
		SessionFactory sessionFactory=new Configuration().configure("user.cfg.xml").buildSessionFactory();
		Session session=sessionFactory.openSession();
		
		UserDetails userDetails=new UserDetails();
	
		Address hadd=new Address();
		hadd.setCityName("Lalitpur");
		hadd.setPinCode(284403);
		hadd.setStateName("Uttar Pradesh");
		
		Address oadd=new Address();
		oadd.setCityName("Bangalore");
		oadd.setPinCode(39265);
		oadd.setStateName("Karnataka");
		
		userDetails.setUserName("Sunny");
		userDetails.setHomeAddress(hadd);
		userDetails.setOfficeAddress(oadd);
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
