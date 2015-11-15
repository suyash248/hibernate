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
			
			Connection con=session.connection();
			Statement s=con.createStatement();
			CallableStatement cs=con.prepareCall("{call GetMail(?,?,?,?)}");
			cs.setInt(1,9);
			cs.setString(2,"paa");
			cs.setString(3,"maa");
			cs.setString(4,"parents@assests");
			cs.executeUpdate();
			ResultSet result1=s.executeQuery("select * from contact");
			while(result1.next())
			{
				System.out.print("id : "+result1.getString(1));
				System.out.print("  firstname:  "+result1.getString(2));
				System.out.print("  lastname :  "+result1.getString(3));
				System.out.println("  email :  "+result1.getString(4));
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