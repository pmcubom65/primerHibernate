package testhibernate.book2storepedrom;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="emple")
public class Empleado {
	@Id
	private String emp_no;
	@Column(name = "APELLIDO")
	private String apellido;
	@Column(name = "OFICIO")
	private String oficio;
	@Column(name = "DIR")
	private String dir;
	@Column(name = "FECHA_ALT")
	private String fecha_alt;
	@Column(name = "SALARIO")
	private String salario;
	@Column(name = "COMISION")
	private String comision;
	@Column(name = "DEPT_NO")
	private String dept_no;

	
	public Empleado() {
	}

	public Empleado(String emp_no) {
		this.emp_no=emp_no;
	}
	
	public Empleado(String emp_no, String apellido, String oficio, String dir, String fecha_alt, String salario,
			String comision, String dept_no) {

		this.emp_no = emp_no;
		this.apellido = apellido;
		this.oficio = oficio;
		this.dir = dir;
		this.fecha_alt = fecha_alt;
		this.salario = salario;
		this.comision = comision;
		this.dept_no = dept_no;
	}

	public String getEmp_no() {
		return emp_no;
	}

	public void setEmp_no(String emp_no) {
		this.emp_no = emp_no;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getOficio() {
		return oficio;
	}

	public void setOficio(String oficio) {
		this.oficio = oficio;
	}

	public String getDir() {
		return dir;
	}

	public void setDir(String dir) {
		this.dir = dir;
	}

	public String getFecha_alt() {
		return fecha_alt;
	}

	public void setFecha_alt(String fecha_alt) {
		this.fecha_alt = fecha_alt;
	}

	public String getSalario() {
		return salario;
	}

	public void setSalario(String salario) {
		this.salario = salario;
	}

	public String getComision() {
		return comision;
	}

	public void setComision(String comision) {
		this.comision = comision;
	}

	public String getDept_no() {
		return dept_no;
	}

	public void setDept_no(String dept_no) {
		this.dept_no = dept_no;
	}

	@Override
	public String toString() {
		return "Empleado [emp_no=" + emp_no + ", apellido=" + apellido + ", oficio=" + oficio + ", dir=" + dir
				+ ", fecha_alt=" + fecha_alt + ", salario=" + salario + ", comision=" + comision + ", dept_no="
				+ dept_no + "]\n";
	}

}
