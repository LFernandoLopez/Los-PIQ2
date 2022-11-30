package Vista;

public class Principal {
	

	public static void main(String[] args) {
		//Inicio
		VentanaPrincipal vp = null;
		
		
		if(vp!=null) {
			vp.dispose();		
		}
		else {
			vp= new VentanaPrincipal("Hotel Las Gaviotas");
		}
	}
}

