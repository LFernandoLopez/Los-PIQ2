package Vista;

public class Principal {
	//Clase Principal

	public static void main(String[] args) {
		
		
		VentanaPrincipal vp = null;
		
		
		if(vp!=null) {
			vp.dispose();		
		}
		else {
			vp= new VentanaPrincipal("Hotel Las Gaviotas");
		}
	}
}

