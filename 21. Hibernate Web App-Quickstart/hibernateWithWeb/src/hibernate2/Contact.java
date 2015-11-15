
package hibernate2;
// Java POJO class to map to the DB 'contact' table

import org.hibernate.Transaction;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Contact
{

	private String firstName;
	private String lastName;
	private String email;
	private int id;
	
	// GETTERS 
	public String getFirstName()
	{
		return firstName;
	}
	public String getLastName()
	{
		return lastName;
	}
	public String getEmail()
	{
		return email;
	}
	public int getId()
	{
		return id;
	}

	// SETTERS
	public void setFirstName(String st)
	{
		firstName=st; 
	}
	public void setLastName(String st)
	{
		lastName=st; 
	}
	public void setEmail(String st)
	{
		email=st; 
	}
	public void setId(int i)
	{
		id=i; 
	}
	public void saveDetails(){
		Session session=null;
		try{
			System.out.println("start");

			Configuration cfgr=new Configuration();

			Configuration c=cfgr.configure();

			SessionFactory sessionfactory=c.buildSessionFactory();

			session=sessionfactory.openSession();
		
			Transaction tr=session.beginTransaction();
			
			System.out.println("Inserted id : "+session.save(this));
			tr.commit();
		}catch(Exception e){
			System.out.println(e);
		}	
	}
}