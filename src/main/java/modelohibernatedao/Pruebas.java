package modelohibernatedao;

public class Pruebas {

	public static void main(String[] args) {
		ServicioEmpleado se=new ServicioEmpleado();
		EmpleadoEntity ee=new EmpleadoEntity("5556", "PERICO", "Empleado", "7902", "2000-08-05", "1000", "20", "10");
		
		//funciona	System.out.println(se.findAll());
	
		// funciona System.out.println(se.findById("7369"));
		
		// funciona	System.out.println(se.delete("1500"));
	
		//	se.persist(ee);
		
		// FUNCIONA se.update(ee);

	}

}
