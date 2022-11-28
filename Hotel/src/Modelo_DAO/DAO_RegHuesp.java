package Modelo_DAO;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import Vista.Registro;
import Vista.VentanaPrincipal;



public class DAO_RegHuesp {
	String usuario="root";
	String contrasena="user123";
	String url="jdbc:mysql://localhost/Hotel";
	Connection conexion= null;
	Statement stmt;
	ResultSet rs;
	VentanaPrincipal vp;
	Registro re;
	
	public void regHuesp(R2 r) {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Conexion Exitosa");
		}catch(ClassNotFoundException e){
			System.out.println("Error en la conexion");
		}
		
		
			
		try {
			
			conexion = DriverManager.getConnection(url, usuario, contrasena);
			stmt = conexion.createStatement();
			stmt.executeUpdate("INSERT INTO huesped VALUES('"+ r.getIdHues() +"', '"+r.getNombre()+"', '"+r.getApellido()+"','"+r.getTel()+"', '"+r.getEmail()+"', '"+r.getCdProcedencia()+"')");
			stmt.executeUpdate("INSERT INTO hospedaje VALUES('"+ r.getIdHues()+"', '"+r.getFechaLlegada()+"', '"+r.getFechaSalida()+"','"+r.getPrecio()+"', '"+r.getNumhab()+"', '"+r.getIdHues()+"')");
			javax.swing.JOptionPane.showMessageDialog(null,"REGISTRO EXITOSO.", "REGISTRO DE HUESPED", JOptionPane.INFORMATION_MESSAGE);	
			
			
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			javax.swing.JOptionPane.showMessageDialog(null,"REGISTRO NO EXITOSO.", "REGISTRO DE HUESPED", JOptionPane.ERROR_MESSAGE);	
		}
		
	}

}