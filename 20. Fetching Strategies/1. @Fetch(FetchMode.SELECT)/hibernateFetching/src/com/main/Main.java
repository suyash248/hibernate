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
       
       Student s1 = new Student();
       List<Address> addresses = new ArrayList<Address>();
       Address a1 = new Address();
       a1.setCity("Delhi");
       a1.setState("Delhi");
       a1.setStudent(s1);
       
       Address a2 = new Address();
       a2.setCity("Dharamshala");
       a2.setState("HP");
       a2.setStudent(s1);
       
       s1.setStudentName("Suyash");
       s1.setAddress(addresses);
       
       session.save(a1);
       session.save(a2);
       session.save(s1);
   
       Student student=(Student)session.get(Student.class, 1);  
       System.out.println("Retrieving Data");  
       System.out.println( student);  
       System.out.println("Address retrieval initiated");  
       List<Address> addresses1 = student.getAddress();  
       System.out.println("Address retrieval complete");  
       int i=1;  
       for (Address address : addresses1) {  
           System.out.println("#### individual address: " + i);  
           System.out.println(address);  
           System.out.println("#### Address complete");  
           i++;  
       }  
       session.getTransaction().commit();  
       session.close();  
   }
}
