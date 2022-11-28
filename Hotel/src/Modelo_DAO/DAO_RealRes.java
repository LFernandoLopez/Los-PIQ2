package Modelo_DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Vista.RealizarReservacion;
import Vista.VentanaPrincipal;

public class DAO_RealRes {
	
	String usuario="root";
	String contrasena="user123";
	String url="jdbc:mysql://localhost/Hotel";
	Connection conexion= null;
	Statement stmt;
	ResultSet rs;
	VentanaPrincipal vp;
	RealizarReservacion rr;
	
	public void RealizarReserva(R1 r) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Conexion Exitosa");
		} catch(ClassNotFoundException e){
			System.out.println("Error en la conexion");
		}
		
		try {
			conexion = DriverManager.getConnection(url, usuario, contrasena);
			stmt = conexion.createStatement();
			stmt.executeUpdate("INSERT INTO huesped VALUES('"+r.getIdRes()+"', '"+r.getNombre()+"', '"+r.getApellido()+"','"+r.getTel()+"','"+ null +"', '"+ null+"')");
			stmt.executeUpdate("INSERT INTO reservacion VALUES('"+ r.getIdRes() +"', '"+r.getFechaLlegada()+"', '"+r.getFechaSalida()+"','"+r.getStatus()+"','"+r.getPrecio()+"', '"+r.getTipoHab()+"', '"+r.getIdRes()+"')");
			
			javax.swing.JOptionPane.showMessageDialog(null,"RESERVACION EXITOSA", "CONFIRMACION DE RESERVACION", JOptionPane.INFORMATION_MESSAGE);	
							
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			javax.swing.JOptionPane.showMessageDialog(null,"RESERVACION NO EXITOSA. ID DUPLICADO", "RESERVACION", JOptionPane.ERROR_MESSAGE);	
			
		
		
		}
	}
}
