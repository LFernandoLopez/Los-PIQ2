package Controlador;

import Modelo_DAO.M_ConsultarDisponibilidad;

public class C_ConsultarDisponibilidad {
	
	String FechaLlegada, FechaSalida, tipoHab;

	public C_ConsultarDisponibilidad(String fechaLlegada, String fechaSalida, String tipoHab) {
		
		FechaLlegada = fechaLlegada;
		FechaSalida = fechaSalida;
		this.tipoHab = tipoHab;
	}
	
	public void ConsultarDisponibilidad(){
		M_ConsultarDisponibilidad c1 = new M_ConsultarDisponibilidad(FechaLlegada, FechaSalida,tipoHab);
		c1.consultaDisp();
	}
	
	

}
