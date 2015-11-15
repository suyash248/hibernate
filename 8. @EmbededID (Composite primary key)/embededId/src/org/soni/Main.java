package org.soni;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {
	public static void main(String[] args) {
		SessionFactory sessionFactory=new Configuration().configure("user.cfg.xml").buildSessionFactory();
		Session session=sessionFactory.openSession();
		
		UserDetails userDetails=new UserDetails();
		
		PrimaryKey pk=new PrimaryKey();
		pk.setLoginId(101);
		pk.setEmail("suyash.soni@soni.com");
		pk.setPassword("soniPass");
		
		userDetails.setUserName("Sunny");
		userDetails.setUserKey(pk);
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
