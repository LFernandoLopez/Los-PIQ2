package Modelo_DAO;

import Vista.VentanaPrincipal;

public class M_RealizarReservacion {
	
	String fechaLlegada, fechaSalida, nombre, apellido, tel, tipoHab, status;
	double precio;
	int idRes;
	VentanaPrincipal vp;

	public M_RealizarReservacion(int idRes,String fechaLlegada, String fechaSalida, String nombre, String apellido, String tel,
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
	
	public void RealizarReserva() {
		
		R1 r = new R1(idRes,fechaLlegada, fechaSalida, nombre, apellido, tel, tipoHab, precio, status);
		DAO_RealRes daor1 = new DAO_RealRes();
		daor1.RealizarReserva(r);

	}
}
