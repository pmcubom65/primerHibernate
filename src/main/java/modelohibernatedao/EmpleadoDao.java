package modelohibernatedao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import modelo.Empleado;



public class EmpleadoDao implements Dao<Empleado, String>{

	
	private Session currentSession;
     
	private Transaction currentTransaction;
	
	public EmpleadoDao() {}
	
	
	 private static SessionFactory getSessionFactory() {
			Configuration configuration = new Configuration().configure();
			configuration.addAnnotatedClass(modelo.Empleado.class);
			StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
	                .applySettings(configuration.getProperties());
			SessionFactory sessionFactory = configuration.buildSessionFactory(builder.build());
			return sessionFactory;
	    }
	
	
	
	 public Session openCurrentSession() {
	        currentSession = getSessionFactory().openSession();
	        return currentSession;
	    }

	
    public Session getCurrentSession() {
        return currentSession;
    }
 
    public void setCurrentSession(Session currentSession) {
        this.currentSession = currentSession;
    }
    
   
 
    public Session openCurrentSessionwithTransaction() {
        currentSession = getSessionFactory().openSession();
        currentTransaction = currentSession.beginTransaction();
        return currentSession;
    }
     
    public void closeCurrentSession() {
        currentSession.close();
    }
     
    public void closeCurrentSessionwithTransaction() {
        currentTransaction.commit();
        currentSession.close();
    }
    public Transaction getCurrentTransaction() {
        return currentTransaction;
    }
 
    public void setCurrentTransaction(Transaction currentTransaction) {
        this.currentTransaction = currentTransaction;
    }
    
    public void persist(Empleado entity) {
        getCurrentSession().save(entity);
    }
    
    public void update(Empleado entity) {
        getCurrentSession().update(entity);
    }
    public Empleado findById(String id) {
    	Empleado ee = (Empleado) getCurrentSession().get(Empleado.class, id);
        return ee; 
    }
    public void delete(Empleado entity) {
        getCurrentSession().delete(entity);
    }
    

    
	public List<Empleado> findAll() {
       
		Query query = getCurrentSession().createQuery("from emple");
		List<Empleado> listado=(List<Empleado>) query.getResultList();
	
		return listado;
        
        
    }
 
    public void deleteAll() {
        List<Empleado> entityList = findAll();
        for (Empleado entity : entityList) {
            delete(entity);
        }
    }
}
