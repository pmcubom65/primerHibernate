package modelohibernatedao;

import java.util.List;

import modelo.Departamento;

public class ServicioDepartamento {

	private static DeparDao deparDao;
	 
    public ServicioDepartamento() {
    	deparDao = new DeparDao();
    }
    public void persist(Departamento entity) {
    	deparDao.openCurrentSessionwithTransaction();
    	deparDao.persist(entity);
    	deparDao.closeCurrentSessionwithTransaction();
    }
 
    public void update(Departamento entity) {
    	deparDao.openCurrentSessionwithTransaction();
    	deparDao.update(entity);
    	deparDao.closeCurrentSessionwithTransaction();
    }
    
    public Departamento findById(String id) {
    	deparDao.openCurrentSession();
    	Departamento d = deparDao.findById(id);
        deparDao.closeCurrentSession();
        return d;
    }
 
    public void delete(String id) {
    	deparDao.openCurrentSessionwithTransaction();
    	Departamento d = deparDao.findById(id);
        deparDao.delete(d);
        deparDao.closeCurrentSessionwithTransaction();
    }
    
    public List<Departamento> findAll() {
    	deparDao.openCurrentSession();
        List<Departamento> d = deparDao.findAll();
        deparDao.closeCurrentSession();
        return d;
    }
 
    public void deleteAll() {
    	deparDao.openCurrentSessionwithTransaction();
    	deparDao.deleteAll();
    	deparDao.closeCurrentSessionwithTransaction();
    }
 
    public DeparDao deparDao() {
        return deparDao;
    }
    
    
    
	
}
