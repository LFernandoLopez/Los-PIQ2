package Modelo_DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import Vista.ConsultarDisponibilidad;
import Vista.ResultadosDisponibilidad;
import Vista.VentanaPrincipal;

public class DAO_ConsDisp {
	String usuario="root";
	String contrasena="user123";
	String url="jdbc:mysql://localhost/hotel";
	Connection conexion= null;
	Statement stmt;
	PreparedStatement stm ;
	ResultSet rs;
	VentanaPrincipal vp;
	ConsultarDisponibilidad cd;
	ResultadosDisponibilidad rd;
	
	public void consultaDisp(C1 c){
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Conexion Exitosa");
		} catch(ClassNotFoundException e){
			System.out.println("Error en la conexion");
		}
		
		try {
			conexion = DriverManager.getConnection(url, usuario, contrasena);
			stmt = conexion.createStatement();
			stm= conexion.prepareStatement("SELECT count(idReservacion)  FROM reservacion INNER JOIN tipohabitacion USING (idTipoHabitacion) WHERE fecha_llegada = ? AND fecha_salida= ? AND idTipoHabitacion = ? AND status = ?");
			stm.setString(1,c.getFechaLlegada());
			stm.setString(2,c.getFechaSalida());
			stm.setInt(3,c.getTipoHab());
			stm.setString(4,"vigente");
			rs= stm.executeQuery();
			//javax.swing.JOptionPane.showMessageDialog(null,"CONSULTA EXITOSA", "NO HAY DISPONIBILIDAD", JOptionPane.INFORMATION_MESSAGE);	
			
			int count=0; 
			while (rs.next()) 
			{ 
				c.setHabDis(c.getHabDis()-count);
				count= rs.getInt (1);
			    c.setHabDis(c.getHabDis()-count);
				
			}
			
			stm= conexion.prepareStatement("SELECT count(idHospedaje) FROM Hospedaje INNER JOIN Habitacion USING (numHabitacion) INNER JOIN TipoHabitacion USING (idTipoHabitacion)WHERE fecha_llegada = ? AND fecha_salida= ? AND idTipoHabitacion = ?");
			stm.setString(1,c.getFechaLlegada());
			stm.setString(2,c.getFechaSalida());
			stm.setInt(3,c.getTipoHab());
			rs= stm.executeQuery();
		 
			while (rs.next()) 
			{ 
				c.setHabDis(c.getHabDis()-rs.getInt(1));
				count= rs.getInt (1);
			    c.setHabDis(c.getHabDis()-count);
				
				
				if(c.getHabDis()==0) {
					javax.swing.JOptionPane.showMessageDialog(null,"NO HAY DISPONIBILIDAD", "CONSULTA EXITOSA", JOptionPane.INFORMATION_MESSAGE);	
					vp=new VentanaPrincipal ("Hotel Las Gaviotas");
				}
				else {
					rd= new ResultadosDisponibilidad("Resultados");
					
				}
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			javax.swing.JOptionPane.showMessageDialog(null,"CONSULTA NO EXITOSA.", "CONSULTA", JOptionPane.ERROR_MESSAGE);	
			
		
		
		}
	}
	

}
