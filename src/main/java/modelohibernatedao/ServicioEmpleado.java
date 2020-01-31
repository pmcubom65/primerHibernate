package modelohibernatedao;

import java.util.List;

public class ServicioEmpleado {
	private EmpleadoDao empleadodao;
	
	public ServicioEmpleado() {
		empleadodao=new EmpleadoDao();
	}
	
	
	  public void persist(EmpleadoEntity entity) {
		  empleadodao.openCurrentSessionwithTransaction();
		  
		  empleadodao.persist(entity);
		  empleadodao.closeCurrentSessionwithTransaction();
    }
 
	   public void update(EmpleadoEntity entity) {
		   empleadodao.openCurrentSessionwithTransaction();
		   empleadodao.update(entity);
		   empleadodao.closeCurrentSessionwithTransaction();
	    }
	 
 
	   public EmpleadoEntity findById(String id) {
		   empleadodao.openCurrentSession();
		   EmpleadoEntity ee = empleadodao.findById(id);
	        empleadodao.closeCurrentSession();
	        return ee;
	    }
 
	    public boolean delete(String id) {
	    	
	    	empleadodao.openCurrentSessionwithTransaction();
	        EmpleadoEntity ee = empleadodao.findById(id);
	        empleadodao.delete(ee);
	        empleadodao.closeCurrentSessionwithTransaction();
	        return (ee instanceof EmpleadoEntity);
	    }
	    
	    public List<EmpleadoEntity> findAll() {
	    	empleadodao.openCurrentSession();
	        List<EmpleadoEntity> ee = empleadodao.findAll();
	        empleadodao.closeCurrentSession();
	        return ee;
	    }

 
	    public void deleteAll() {
	    	empleadodao.openCurrentSessionwithTransaction();
	    	empleadodao.deleteAll();
	    	empleadodao.closeCurrentSessionwithTransaction();
	    }
 
    public EmpleadoDao bookDao() {
        return empleadodao;
    }
}
