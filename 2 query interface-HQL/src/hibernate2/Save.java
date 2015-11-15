package hibernate2;


import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.*;

import java.util.*;

public class Save
{
	public static void main(String... w)
	{
		Session session=null;
		try
		{
			System.out.println("start");

			Configuration cfgr=new Configuration();

			Configuration c=cfgr.configure();

			SessionFactory sessionfactory=c.buildSessionFactory();

			session=sessionfactory.openSession();
		
			Transaction tr=session.beginTransaction();
			/*Contact ct1=new Contact("Suyash","Soni","suyash.soni248@gmail.com");
			Contact ct2=new Contact("Abhi","Soni","abhi.ltp@gmail.com");
			Contact ct3=new Contact("AB","Soni","ab92@gmail.com");
			session.save(ct1);
			session.save(ct2);
			session.save(ct3); */
			// Code for selecting multiple rows via native sql.
			
			Query q=session.createQuery("from Contact");	// using HQL so here "Contact" is our POJO class.
			List list=q.list();
			Iterator i=list.iterator();
			while(i.hasNext())
			{
					Contact ct=(Contact)i.next();
					System.out.println("id : "+ct.getId()+"  firstName : "+ct.getFirstName()+"  lastName : "+ct.getLastName()+"  email : "+ct.getEmail());
			}
			
			tr.commit();
			System.exit(1);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}	
	}
}