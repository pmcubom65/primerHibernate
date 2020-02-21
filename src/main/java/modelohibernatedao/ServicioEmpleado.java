package modelohibernatedao;

import java.util.List;

import modelo.Empleado;


public class ServicioEmpleado {
	private EmpleadoDao empleadodao;
	
	public ServicioEmpleado() {
		empleadodao=new EmpleadoDao();
	}
	
	
	  public void persist(Empleado entity) {
		  empleadodao.openCurrentSessionwithTransaction();
		  
		  empleadodao.persist(entity);
		  empleadodao.closeCurrentSessionwithTransaction();
    }
 
	   public void update(Empleado entity) {
		   empleadodao.openCurrentSessionwithTransaction();
		   empleadodao.update(entity);
		   empleadodao.closeCurrentSessionwithTransaction();
	    }
	 
 
	   public Empleado findById(String id) {
		   empleadodao.openCurrentSession();
		   Empleado ee = empleadodao.findById(id);
	        empleadodao.closeCurrentSession();
	        return ee;
	    }
 
	    public boolean delete(String id) {
	    	
	    	empleadodao.openCurrentSessionwithTransaction();
	        Empleado ee = empleadodao.findById(id);
	        empleadodao.delete(ee);
	        empleadodao.closeCurrentSessionwithTransaction();
	        return (ee instanceof Empleado);
	    }
	    
	    public List<Empleado> findAll() {
	    	empleadodao.openCurrentSession();
	        List<Empleado> ee = empleadodao.findAll();
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
    
    
    public List<Empleado> aplicarProcedimiento() {
    	empleadodao.openCurrentSessionwithTransaction();
    	List<Empleado> emples=empleadodao.procedimiento();
    	empleadodao.closeCurrentSessionwithTransaction();
    	return emples;
    }
    
    
    
}
