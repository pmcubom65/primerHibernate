package modelohibernatedao;

import java.sql.CallableStatement;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.hibernate.type.StandardBasicTypes;

import javafx.animation.KeyValue.Type;
import modelo.Empleado;

public class EmpleadoDao implements Dao<Empleado, String> {

	private Session currentSession;

	private Transaction currentTransaction;

	private EntityManager entityManager;

	public EmpleadoDao() {
	}

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
		List<Empleado> listado = (List<Empleado>) query.getResultList();

		return listado;

	}

	public void deleteAll() {
		List<Empleado> entityList = findAll();
		for (Empleado entity : entityList) {
			delete(entity);
		}
	}

	public List<Empleado> procedimiento() {

		Integer m = new Integer(10);

		org.hibernate.query.Query query = getCurrentSession().createNativeQuery("{call emplepordepar(?)}",
				Empleado.class);
		query.setParameter(1, m);

		List<Empleado> listados = query.getResultList();

		return listados;
	}

}
