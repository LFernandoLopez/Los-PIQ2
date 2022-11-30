package Modelo_DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import Vista.ModificarReservacion;
import Vista.VentanaPrincipal;

//Conexion a la base de datos
public class DAO_ModRes {
	String usuario="root";
	String contrasena="user123";
	String url="jdbc:mysql://localhost/Hotel";
	Connection conexion= null;
	Statement stmt;
	PreparedStatement stm ;
	int r_act;
	ResultSet rs;
	VentanaPrincipal vp;
	ModificarReservacion mr;
	
	public void ModifReserva(R3 r) {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Conexion Exitosa");
		} catch(ClassNotFoundException e){
			System.out.println("Error en la conexion");
		}
		
		try {
			conexion = DriverManager.getConnection(url, usuario, contrasena);
			stmt = conexion.createStatement();
			
			stm= conexion.prepareStatement("UPDATE reservacion SET fecha_llegada= '"+r.getFechaLlegada()+"', fecha_salida= '"+r.getFechaSalida()+"', idTipoHabitacion= '"+r.getTipoHab()+"', precio= '"+r.getPrecio()+"' WHERE idReservacion = ?");
			stm.setInt(1,r.getIdRes());
			r_act=stm.executeUpdate();
			
			if(r_act>0)
				javax.swing.JOptionPane.showMessageDialog(null,"RESERVACION ACTUALIZADA", "CONFIRMACION DE RESERVACION", JOptionPane.INFORMATION_MESSAGE);	
			else
				javax.swing.JOptionPane.showMessageDialog(null,"RESERVACION NO ACTUALIZADA. INTENTELO MAS TARDE", "ERROR", JOptionPane.INFORMATION_MESSAGE);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			javax.swing.JOptionPane.showMessageDialog(null,"RESERVACION NO EXITOSA.", "RESERVACION", JOptionPane.ERROR_MESSAGE);
		}
	}
}
