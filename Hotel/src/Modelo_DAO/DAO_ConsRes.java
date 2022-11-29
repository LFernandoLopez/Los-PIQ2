package Modelo_DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import Vista.ConsultarReservacion;
import Vista.ResultadosReservacion;
import Vista.VentanaPrincipal;

public class DAO_ConsRes {
	
	String usuario="root";
	String contrasena="user123";
	String url="jdbc:mysql://localhost/Hotel";
	Connection conexion= null;
	Statement stmt;
	PreparedStatement stm ;
	ResultSet rs;
	VentanaPrincipal vp;
	ConsultarReservacion cr;
	String cad;
	
	public void ConsultaReserva(C2 c) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Conexion Exitosa");
		} catch(ClassNotFoundException e){
			System.out.println("Error en la conexion");
		}
		
		try {
			conexion = DriverManager.getConnection(url, usuario, contrasena);
			stmt = conexion.createStatement();
			
			stm= conexion.prepareStatement("SELECT idReservacion, nombre, apellido, fecha_llegada, fecha_salida, tel, idTipoHabitacion, status FROM reservacion INNER JOIN huesped USING (idHuesped) WHERE idReservacion = ?");
			stm.setInt(1,c.getIdRes());
			rs= stm.executeQuery();
			
			javax.swing.JOptionPane.showMessageDialog(null,"CONSULTA EXITOSA", "CONFIRMACION DE CONSULTA", JOptionPane.INFORMATION_MESSAGE);	
			
			
			if(rs.next()) 
			{ 
				
				ResultadosReservacion rr = new ResultadosReservacion("Resultados");
				
				c.setIdRes(rs.getInt (1));
			    c.setNombre(rs.getString(2));
			    c.setApellidos(rs.getString(3));
			    c.setFechaLlegada(rs.getString(4));
			    c.setFechaSalida(rs.getString(5));
			    c.setTel(rs.getString(6));
			    c.setTipoHab(cad);
			    c.setStatus(rs.getString(8));
			    
			    if(rs.getInt(7)==1) {
			    	cad = "Sencilla";
			    	rr.texto7.setText(cad);
			    }
				else {
					cad = "Doble";
			    	ResultadosReservacion.texto7.setText(cad);
				}
			    
			    rr.texto1.setText(rs.getString (1));
			    rr.texto2.setText(rs.getString (2));
			    rr.texto3.setText(rs.getString (3));
			    rr.texto4.setText(rs.getString (4));
			    rr.texto5.setText(rs.getString (5));
			    rr.texto6.setText(rs.getString (6));
			    rr.texto8.setText(rs.getString (8));
			    
			    
			    
			    if(rs.getString(8).equals("Cancelada")) {
			    	rr.botonMod.setEnabled(false);
			    	rr.botonCanc.setEnabled(false);
			    	
			    }
			}
			else
				javax.swing.JOptionPane.showMessageDialog(null,"RESERVACION NO ENCONTRADA.", "RESERVACION", JOptionPane.ERROR_MESSAGE);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			javax.swing.JOptionPane.showMessageDialog(null,"CONSULTA NO EXITOSA.", "CONSULTA", JOptionPane.ERROR_MESSAGE);	
			
		
		
		}
	}

}
