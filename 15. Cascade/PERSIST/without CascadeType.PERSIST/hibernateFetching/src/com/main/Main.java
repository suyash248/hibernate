package com.main;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.entity.Address;
import com.entity.Student;

public class Main {
	public static void main(String[] args)  {  
	   SessionFactory sessionFactory=new Configuration().configure("user.cfg.xml").buildSessionFactory();
       Session session = sessionFactory.openSession();  
       session.beginTransaction(); 
       
       /*********** INSERT RECORDS **************/
       //insertRecords(session);
       
       /*********** FETCH RECORDS **************/
       fetchRecords(session);
       
       session.getTransaction().commit();  
       session.close();  
	}
	public static void fetchRecords(Session session){
	   List<Student> studentsList = session.createQuery("from Student").list();
	   
       for(Student student : studentsList){
    	   List<Address> addressesListForStudent = student.getAddress();
    	   System.out.println(student.getStudentName()+" :-");
    	   for(Address address : addressesListForStudent){
    		  System.out.print(address.getCity()+" : ");
    		  System.out.print(address.getState()+"\n");
    	   }
       }
	}
	public static void insertRecords(Session session){
	   Student s1 = new Student();
       
       List<Address> addresses1 = new ArrayList<Address>();
       
       Address a1 = new Address();
       a1.setCity("Delhi");
       a1.setState("Delhi");
       a1.setStudent(s1);
       
       Address a2 = new Address();
       a2.setCity("Dharamshala");
       a2.setState("HP");
       a2.setStudent(s1);
       
       addresses1.add(a1);
       addresses1.add(a2);
       
       s1.setStudentName("Suyash");
       s1.setAddress(addresses1);
      
       session.persist(s1);
	}
}
