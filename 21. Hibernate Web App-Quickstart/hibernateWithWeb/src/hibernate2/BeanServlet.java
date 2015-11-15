package hibernate2;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Transaction;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class BeanServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	Contact contact=null;
	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		
		try{
			res.setContentType("text/html");
			Session session=null;
			System.out.println("start");

			Configuration cfgr=new Configuration();

			Configuration c=cfgr.configure();

			SessionFactory sessionfactory=c.buildSessionFactory();

			session=sessionfactory.openSession();
		
			Transaction tr=session.beginTransaction();
			
			contact=new Contact();
			contact.setFirstName(req.getParameter("firstName"));
			contact.setLastName(req.getParameter("lastName"));
			contact.setEmail(req.getParameter("email"));
			
			System.out.println("Inserted id : "+session.save(contact));
			tr.commit();
		}catch(Exception e){
			e.printStackTrace();
		}	
	}
	
}
