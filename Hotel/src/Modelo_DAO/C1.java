package Modelo_DAO;

public class C1 {
	
	private String FechaLlegada, FechaSalida, tipoHab;
	private int habDis=5;
	
	public C1(String fechaLlegada, String fechaSalida, String tipoHab, int habDis) {
		super();
		FechaLlegada = fechaLlegada;
		FechaSalida = fechaSalida;
		this.tipoHab = tipoHab;
		this.habDis = habDis;
	}
	
	public C1(String fechaLlegada, String fechaSalida, String tipoHab) {
		super();
		FechaLlegada = fechaLlegada;
		FechaSalida = fechaSalida;
		this.tipoHab = tipoHab;
	}

	public String getFechaLlegada() {
		return FechaLlegada;
	}
	public void setFechaLlegada(String fechaLlegada) {
		FechaLlegada = fechaLlegada;
	}
	public String getFechaSalida() {
		return FechaSalida;
	}
	public void setFechaSalida(String fechaSalida) {
		FechaSalida = fechaSalida;
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
	public int getHabDis() {
		return habDis;
	}
	public void setHabDis(int habDis) {
		this.habDis = habDis;
	}
	
	@Override
	public String toString() {
		return "C1 [FechaLlegada=" + FechaLlegada + ", FechaSalida=" + FechaSalida + ", tipoHab=" + tipoHab
				+ ", habDis=" + habDis + "]";
	}
	
	
	

}
