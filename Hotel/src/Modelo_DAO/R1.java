package Modelo_DAO;

public class R1 {
	
	private String fechaLlegada, fechaSalida, nombre, apellido, tel, tipoHab, status;
	private double precio;
	private int idRes;

	public R1(int idRes,String fechaLlegada, String fechaSalida, String nombre, String apellido, String tel,
			String tipoHab, double precio, String status) {
		
		this.idRes = idRes;
		this.fechaLlegada = fechaLlegada;
		this.fechaSalida = fechaSalida;
		this.nombre = nombre;
		this.apellido = apellido;
		this.tel = tel;
		this.tipoHab = tipoHab;
		this.precio = precio;
		this.status = status;
	}

	

	public int getIdRes() {
		return idRes;
	}

	public void setIdRes(int idRes) {
		this.idRes = idRes;
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

	public int getTipoHab() {
		if(tipoHab.equals("sencilla")) 
			return 1;
		else 
			return 2;
		
	}

	public void setTipoHab(String tipoHab) {
		this.tipoHab = tipoHab;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	@Override
	public String toString() {
		return "R1 [fechaLlegada=" + fechaLlegada + ", fechaSalida=" + fechaSalida + ", nombre=" + nombre
				+ ", apellido=" + apellido + ", tel=" + tel + ", tipoHab=" + tipoHab + ", status=" + status
				+ ", precio=" + precio + "]";
	}
	
	

}
