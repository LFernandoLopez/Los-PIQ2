package Modelo_DAO;

public class M_ConsultarDisponibilidad {
	
	String FechaLlegada, FechaSalida, tipoHab;
		
	public M_ConsultarDisponibilidad(String fechaLlegada, String fechaSalida, String tipoHab) {
		super();
		FechaLlegada = fechaLlegada;
		FechaSalida = fechaSalida;
		this.tipoHab = tipoHab;
	}

	public void consultaDisp() {
		
		C1 c = new C1 (FechaLlegada, FechaSalida, tipoHab);
		DAO_ConsDisp daocd1 = new DAO_ConsDisp();
		daocd1.consultaDisp(c);
		
	}


}
