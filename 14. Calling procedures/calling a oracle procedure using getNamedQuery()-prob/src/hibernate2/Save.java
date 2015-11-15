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
		
			Query q=session.getNamedQuery("getmailprocedure");	
			q.setParameter("a", 9);
			q.setParameter("b"," virag");
			q.setParameter("c","baba");
			q.setParameter("d", "viragjain0");
			List list=q.list();
			Iterator i=list.iterator();
			while(i.hasNext())
			{
					Contact ct=(Contact)i.next();
					System.out.println("id : "+ct.getId()+"  firstName : "+ct.getFirstName()+"  lastName : "+ct.getLastName()+"  email : "+ct.getEmail());
			}
			
			tr.commit();
			session.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}	
	}
}