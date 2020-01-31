package testhibernate.mihibernate;

import java.util.List;

import javax.persistence.Query;


import org.hibernate.Session;
import org.hibernate.SessionBuilder;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;


public class App 
{
    public static void main( String[] args )
    {
       Empleado e=new Empleado();
       e.setApellido("Cubo");
       e.setEmp_no("1500");
       e.setDept_no("20");
       Configuration configuration = new Configuration();
       configuration.configure();
       
       ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
       SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
       Session session = sessionFactory.openSession();

       session.beginTransaction();
       String hql = "FROM emple";
    
       org.hibernate.Query query = session.createQuery(hql);
       List results = query.list();


       System.out.println(results);   
 //      session.save(e);
       session.getTransaction().commit();
       
       session.close();
    }
}
