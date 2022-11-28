package Modelo_DAO;

public class R2 {
	
	private String fechaLlegada , fechaSalida, nombre, apellido, tel, email, cdProcedencia;
	private double precio;
	private int numhab, idHues;
	
	public R2(int idHues, String fechaLlegada, String fechaSalida, String nombre, String apellido, String tel, String email,
			String cdProcedencia, int numhab,double precio) {
		
		this.idHues = idHues;
		this.fechaLlegada = fechaLlegada;
		this.fechaSalida = fechaSalida;
		this.nombre = nombre;
		this.apellido = apellido;
		this.tel = tel;
		this.email = email;
		this.cdProcedencia = cdProcedencia;
		this.precio = precio;
		this.numhab = numhab;
	}
	
	

	public int getIdHues() {
		return idHues;
	}
	
	public void setIdHues(int idHues) {
		this.idHues = idHues;
	}

	public String getFechaLlegada() {
		return fechaLlegada;
	}
	public void setFechaLlegada(String fechaLlegada) {
		this.fechaLlegada = fechaLlegada;
	}
	public String getFechaSalida() {
		return fechaSalida;
	}
	public void setFechaSalida(String fechaSalida) {
		this.fechaSalida = fechaSalida;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCdProcedencia() {
		return cdProcedencia;
	}
	public void setCdProcedencia(String cdProcedencia) {
		this.cdProcedencia = cdProcedencia;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public int getNumhab() {
		return numhab;
	}
	public void setNumhab(int numhab) {
		this.numhab = numhab;
	}
	
	@Override
	public String toString() {
		return "R2 [fechaLlegada=" + fechaLlegada + ", fechaSalida=" + fechaSalida + ", nombre=" + nombre
				+ ", apellido=" + apellido + ", tel=" + tel + ", email=" + email + ", cdProcedencia=" + cdProcedencia
				+ ", precio=" + precio + ", numhab=" + numhab + "]";
	}
	

}
