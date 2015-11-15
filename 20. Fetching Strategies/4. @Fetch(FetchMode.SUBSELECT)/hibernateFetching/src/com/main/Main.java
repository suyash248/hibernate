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
    	   for(Address address : addressesListForStudent){
    		  System.out.print(address.getCity()+" : ");
    		  System.out.print(address.getState()+"\n");
    	   }
       }
	}
	public static void insertRecords(Session session){
	   Student s1 = new Student();
       Student s2 = new Student();
       Student s3 = new Student();
       Student s4 = new Student();
       Student s5 = new Student();
       Student s6 = new Student();
       
       List<Address> addresses1 = new ArrayList<Address>();
       List<Address> addresses2 = new ArrayList<Address>();
       List<Address> addresses3 = new ArrayList<Address>();
       List<Address> addresses4 = new ArrayList<Address>();
       List<Address> addresses5 = new ArrayList<Address>();
       List<Address> addresses6 = new ArrayList<Address>();
       
       Address a1 = new Address();
       a1.setCity("Delhi");
       a1.setState("Delhi");
       a1.setStudent(s1);
       
       Address a2 = new Address();
       a2.setCity("Dharamshala");
       a2.setState("HP");
       a2.setStudent(s2);
       
       Address a3 = new Address();
       a3.setCity("Ghaziabad");
       a3.setState("UP");
       a3.setStudent(s3);
       
       Address a4 = new Address();
       a4.setCity("Lalitpur");
       a4.setState("UP");
       a4.setStudent(s4);
       
       Address a5 = new Address();
       a5.setCity("New York");
       a5.setState("NYC");
       a5.setStudent(s5);
       
       Address a6 = new Address();
       a6.setCity("Washington");
       a6.setState("Columbia");
       a6.setStudent(s6);
       
       addresses1.add(a1);
       addresses2.add(a2);
       addresses3.add(a3);
       addresses4.add(a4);
       addresses5.add(a5);
       addresses6.add(a6);
       
       s1.setStudentName("Suyash");
       s2.setStudentName("Abhi");
       s3.setStudentName("Anoop");
       s4.setStudentName("Ramya");
       s5.setStudentName("Ahba");
       s6.setStudentName("Iti");
       
       s1.setAddress(addresses1);
       s2.setAddress(addresses2);
       s3.setAddress(addresses3);
       s4.setAddress(addresses4);
       s5.setAddress(addresses5);
       s6.setAddress(addresses6);
       
       session.save(s1);
       session.save(s2);
       session.save(s3);
       session.save(s4);
       session.save(s5);
       session.save(s6);
	}
}
