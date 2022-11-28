package Controlador;



import Modelo_DAO.M_RealizarReservacion;

public class C_Reservacion {
	
		
		String fechaLlegada, fechaSalida, nombre, apellido, tel, tipoHab, status;
		double precio;
		int idRes;

		

		public C_Reservacion(int idRes, String fechaLlegada, String fechaSalida, String nombre, String apellido, String tel,
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
		
		public void Reservacion() {
			M_RealizarReservacion r1 = new M_RealizarReservacion(idRes,fechaLlegada, fechaSalida, nombre, apellido, tel, tipoHab, precio, status);
			r1.RealizarReserva();
			
		}
		
			
}
