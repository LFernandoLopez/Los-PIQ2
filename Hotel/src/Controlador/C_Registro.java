package Controlador;


import Modelo_DAO.M_Registro;

public class C_Registro {
	
	String fechaLlegada , fechaSalida, nombre, apellido, tel, email, cdProcedencia;
	double precio;
	int numhab, idHues;
	
	
	
	public C_Registro(int idHues,String fechaLlegada, String fechaSalida, String nombre, String apellido, String tel, String email,
			String cdProcedencia, int numhab, double precio) {
		
		this.idHues = idHues;
		this.fechaLlegada = fechaLlegada;
		this.fechaSalida = fechaSalida;
		this.nombre = nombre;
		this.apellido = apellido;
		this.tel = tel;
		this.email = email;
		this.cdProcedencia = cdProcedencia;
		this.numhab = numhab;
		this.precio = precio;
	}
	
	public void registro() {
		
		M_Registro r = new M_Registro(idHues,fechaLlegada, fechaSalida, nombre, apellido, tel, email,cdProcedencia, numhab, precio);
		r.regHuesp();
		
	}
}
