package Modelo_DAO;

public class M_Registro {
	
	String fechaLlegada , fechaSalida, nombre, apellido, tel, email, cdProcedencia;
	double precio;
	int numhab, idHues;
	
	public M_Registro(int idHues, String fechaLlegada, String fechaSalida, String nombre, String apellido, String tel, String email,
			String cdProcedencia, int numhab, double precio) {
		
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
	
	public void regHuesp() {
		
		R2 r = new R2(idHues,fechaLlegada, fechaSalida, nombre, apellido, tel, email, cdProcedencia, numhab, precio);
		DAO_RegHuesp daor1 = new DAO_RegHuesp();
		daor1.regHuesp(r);
	}

}
