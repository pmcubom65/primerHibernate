package controlador;

import java.util.List;

import javax.persistence.Query;


import org.hibernate.Session;
import org.hibernate.SessionBuilder;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import modelo.Departamento;
import modelohibernatedao.ServicioDepartamento;
import modelohibernatedao.ServicioEmpleado;



public class App 
{
    public static void main( String[] args )
    {
    /*   modelo.Empleado e=new modelo.Empleado();
       e.setApellido("Cubo");
       e.setEmp_no("1500");
       e.setDept_no("10");
      
       ServicioEmpleado se=new ServicioEmpleado();
       System.out.println(se.delete("1500"));*/
      
       Departamento d=new Departamento("200","LIMPIEZA","JAEN");
       ServicioDepartamento sd=new ServicioDepartamento();
       sd.delete("200");
       System.out.println(sd.findAll());
       
       
       
    }
}
