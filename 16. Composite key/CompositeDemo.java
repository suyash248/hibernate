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

public class CompositeDemo
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
			
			Product p=new Product();
			p.setProId(101);
			p.setProName("Lux");
			p.setProPrice(24.50);		
			System.out.println("Serialized ID returned by save() : "+session.save(p));

			System.out.println();
			System.out.println("FETTHING......");
			Product loadpro=new Product();
			
			Product pro=(Product)session.load(Product.class,p);
			System.out.println("Load product price = "+pro.getProPrice());			

			tr.commit();
			session.close();
			sessionfactory.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}	
	}
}