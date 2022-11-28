package Controlador;


public class ValidarDatos {

	
	public boolean ValidarNombre( String nombre) {
		
		if(nombre.equals("")) 
			return false;
		else
			return true;
			
				
	}
	
	public boolean ValidarApellidos( String apellido) {
		
		if(apellido.equals(""))
			return false;
		else
			return true;
			
	}
	
	public boolean ValidarTel(String tel) {
		
		if(tel.equals(""))
			return false;
		else
			return true;
		
	}
	
	public boolean NoReserva(String numRes) {
		try {
			int num= Integer.parseInt(String.valueOf(numRes));
			return true;
		}
		catch (Exception E) {
			return false;
		}
	}
	
	public boolean ValidarPrecio(String precio) {
		try {
			double num= Double.parseDouble(String.valueOf(precio));
			return true;
		}
		catch (Exception E) {
			return false;
		}
	}
	
	public boolean ValidarFecha(int dia, int mes, int year) {
		if(year==0|| mes==0|| dia==0)
			return false;
		else
			return true;
			
			
	}
	
}
