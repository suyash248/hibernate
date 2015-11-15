
package hibernate2;
import org.hibernate.Transaction;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Save{
	public static void main(String... w){
		Session session=null;
		try{
			System.out.println("start");

			Configuration cfgr=new Configuration();

			Configuration c=cfgr.configure();

			SessionFactory sessionfactory=c.buildSessionFactory();

			session=sessionfactory.openSession();
		
			Transaction tr=session.beginTransaction();

			Contact contact=new Contact();
			contact.setFirstName("Abhi");
			contact.setLastName("Soni");
			contact.setEmail("abhi.ltp");
			System.out.println("Inserted id : "+session.save(contact));

			//System.out.println(session.persist(contact));              ERROR !! void type is not allowed in 'println()'      so use : session.persist(contact);
			//System.out.println(session.saveOrUpdate(contact));    ERROR !! void type is not allowed in 'println()'      so use : session.saveOrUpdate(contact);
			
			tr.commit();
			System.exit(1);
		}
		catch(Exception e){
			System.out.println(e);
		}	
	}
}