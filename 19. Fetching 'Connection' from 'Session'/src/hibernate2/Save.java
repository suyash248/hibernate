package hibernate2;


import org.hibernate.Transaction;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import java.sql.*;

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
			// Extracting "Connection" from session.
			Connection con=session.connection();
			Statement stmt=con.createStatement();
			System.out.println("Now you can perform any operation using this JDBC Connection object !!!!");
			tr.commit();
			session.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}	
	}
}