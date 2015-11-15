package org.soni;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class Main {
	public static void main(String[] args) {
		SessionFactory sessionFactory=new Configuration().configure("user.cfg.xml").buildSessionFactory();
		Session session=sessionFactory.openSession();
		
		UserDetails userDetails=new UserDetails();
	
		Address add1=new Address();
		add1.setCityName("Ghaziabad");
		add1.setPinCode(201010);
		add1.setStateName("Uttar Pradesh");
		
		Address add2=new Address();
		add2.setCityName("Dharmsala");
		add2.setPinCode(4279);
		add2.setStateName("Himanchal Pradesh");
		
		userDetails.setUserName("Soni");
		userDetails.getListOfAddresses().add(add1);
		userDetails.getListOfAddresses().add(add2);
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
		userDetails=null;
		session=sessionFactory.openSession();
		userDetails=(UserDetails)session.get(UserDetails.class, 1);	// Hibernate will fetch the object of proxy class.
		session.close();	// It will give an exception because we are calling getter 'getListOfAddresses()' which will try to fetch the list 
		//	 of addresses but it will not find any session hence exception will be thrown.
		System.out.println("Number of addresses : "+userDetails.getListOfAddresses().size());
		
	}
}
