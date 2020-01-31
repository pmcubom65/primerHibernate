package testhibernate.mihibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class Persistiendo {
	public static void main(String[] args) {
		Configuration configuration = new Configuration().configure();
		 StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
	                .applySettings(configuration.getProperties());
		 SessionFactory sessionFactory = configuration.buildSessionFactory(builder.build());
		 Session session=sessionFactory.openSession();
		 Transaction transaction=session.beginTransaction();
		
		 Empleado e=new Empleado("1500","ejemplo","director","1000","2000-11-11","1000","20","10");
		 session.update(e);
		 session.close();
		
	}
}
