package modelohibernatedao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class EmpleadoDao implements Dao<EmpleadoEntity, String>{

	
	private Session currentSession;
     
	private Transaction currentTransaction;
	
	public EmpleadoDao() {}
	
	
	 private static SessionFactory getSessionFactory() {
	        Configuration configuration = new Configuration().configure();
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
    
    public void persist(EmpleadoEntity entity) {
        getCurrentSession().save(entity);
    }
    
    public void update(EmpleadoEntity entity) {
        getCurrentSession().update(entity);
    }
    public EmpleadoEntity findById(String id) {
    	EmpleadoEntity ee = (EmpleadoEntity) getCurrentSession().get(EmpleadoEntity.class, id);
        return ee; 
    }
    public void delete(EmpleadoEntity entity) {
        getCurrentSession().delete(entity);
    }
    
    @SuppressWarnings("unchecked")
    public List<EmpleadoEntity> findAll() {
        List<EmpleadoEntity> lalista = (List<EmpleadoEntity>) getCurrentSession().createQuery("from emple").list();
        return lalista;
    }
 
    public void deleteAll() {
        List<EmpleadoEntity> entityList = findAll();
        for (EmpleadoEntity entity : entityList) {
            delete(entity);
        }
    }
}
