package Vista;

public class Principal {
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		VentanaPrincipal vp = null;
		
		
		if(vp!=null) {
			vp.dispose();		
		}
		else {
			vp= new VentanaPrincipal("Hotel Las Gaviotas");
		}
	}
}

