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
       
       		List<Student> studentsList = session.createQuery("from Student").list();
       		for(Student student : studentsList){
    	   		session.delete(student);
       		}
       		session.getTransaction().commit();  
       		session.close();  
	}
}
