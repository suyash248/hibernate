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
			Transaction tx1 = session1.beginTransaction();
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			System.out.print("Enter id : ");
			int i=Integer.parseInt(br.readLine());
			Contact contact=(Contact)session1.get(Contact.class,new Integer(i));
			System.out.println("RID : "+contact);
			tx1.commit();
			session1.close(); // end of first session, contact is detached.

			session2=sessionfactory.openSession();
			Transaction tx2 = session2.beginTransaction();
			Contact contact1=(Contact)session2.get(Contact.class,new Integer(i));
			session2.merge(contact);	//session2.update(contact);  NonUniqueObjectException
			if(contact1!=null)
			{
				//System.out.println("Id : "+contact1.getId());
				System.out.println("firstname : "+contact1.getFirstName());
				System.out.println("lastname : "+contact1.getLastName());
				System.out.println("email : "+contact1.getEmail());
			}
			tx2.commit();
			session2.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}	
	}
}