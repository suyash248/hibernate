package hibernate2;


import org.hibernate.Criteria;
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
			
			Criteria cr=session.createCriteria(Contact.class);
		// List list=cr.setProjection(Projections.projectionList().add(Projections.property("firstName")).add(Projections.property("lastName"))).addOrder(Order.asc("lastName")).list();
			List list1=cr.add(Restrictions.like("firstName", "A%")).addOrder(Order.desc("lastName")).list();
		//	List list2=cr.add(Restrictions.eq("firstName","Suyash")).list();
			Iterator i1=list1.iterator();
			while(i1.hasNext())
			{
					Contact ctc=(Contact) i1.next();
					System.out.println("firstName : "+ctc.getFirstName()+"  lastName : "+ctc.getLastName());
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