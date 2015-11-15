package hibernate2;

import org.hibernate.Transaction;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import java.io.*;

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
			String s=null;
			//contact.getId();

			Contact contact=new Contact();
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Enter firstname : ");
			s=br.readLine();
			contact.setFirstName(s);

			System.out.println("Enter lastname : ");
			s=br.readLine();
			contact.setLastName(s);
			
			System.out.println("Enter email : ");
			s=br.readLine();
			contact.setEmail(s);

			System.out.println("Inserted id : "+session.save(contact));

			//System.out.println(session.persist(contact));              ERROR !! void type is not allowed in 'println()'      so use : session.persist(contact);
			//System.out.println(session.saveOrUpdate(contact));    ERROR !! void type is not allowed in 'println()'      so use : session.saveOrUpdate(contact);
			
			tr.commit();
			session.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}	
	}
}