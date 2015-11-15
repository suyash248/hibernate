package hibernate2;

import org.hibernate.Transaction;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cache.Cache;
import org.hibernate.cache.CacheProvider;
import org.hibernate.cache.EhCacheProvider;
import org.hibernate.HibernateException; 
import java.util.*;
import java.io.*;

public class Save
{
	public static void main(String... w)
	{
		Session session1,session2;
		try
		{
			System.out.println("start");

			Configuration cfgr=new Configuration();

			Configuration c=cfgr.configure();

			SessionFactory sessionfactory=c.buildSessionFactory();

			session1=sessionfactory.openSession();
		
			String s=null;
			//contact.getId();

			int j=0;
			Contact contact=new Contact();
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			
			System.out.println("FETCHING A RECORD...................");
			System.out.print("Enter id : ");
			int i=Integer.parseInt(br.readLine());

			Contact contact1=(Contact)session1.get(Contact.class,new Integer(i));
			System.out.println("RID : "+contact1);
			System.out.println();
			if(contact1!=null)
			{
				//System.out.println("Id : "+contact1.getId());
				System.out.println("firstname : "+contact1.getFirstName());
				System.out.println("lastname : "+contact1.getLastName());
				System.out.println("email : "+contact1.getEmail());
			}
			session1.close();

			System.out.println("AGAIN FETCHING THE SAME RECORD...................");
			session2=sessionfactory.openSession();
			Thread.sleep(2000);
			
			Contact contact2=(Contact)session2.get(Contact.class,new Integer(i));
			System.out.println();
			if(contact2!=null)
			{
				//System.out.println("Id : "+contact2.getId());
				System.out.println("firstname : "+contact2.getFirstName());
				System.out.println("lastname : "+contact2.getLastName());
				System.out.println("email : "+contact2.getEmail());
			}
			session2.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}	
	}
}