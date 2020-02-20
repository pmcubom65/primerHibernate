package modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name="depar")
@Table(name="depart")
public class Departamento {

	@Id
	@Column(name="dept_no")
	private String dept_no;
	@Column(name="Dnombre")
	private String Dnombre;
	@Column(name="loc")
	private String loc;
	
	public Departamento() {}

	public Departamento(String dept_no, String dnombre, String loc) {
		super();
		this.dept_no = dept_no;
		Dnombre = dnombre;
		this.loc = loc;
	}

	public String getDept_no() {
		return dept_no;
	}

	public void setDept_no(String dept_no) {
		this.dept_no = dept_no;
	}

	public String getDnombre() {
		return Dnombre;
	}

	public void setDnombre(String dnombre) {
		Dnombre = dnombre;
	}

	public String getLoc() {
		return loc;
	}

	public void setLoc(String loc) {
		this.loc = loc;
	}

	@Override
	public String toString() {
		return "Departamento [dept_no=" + dept_no + ", Dnombre=" + Dnombre + ", loc=" + loc + "]";
	}
	
	
	
	
}
