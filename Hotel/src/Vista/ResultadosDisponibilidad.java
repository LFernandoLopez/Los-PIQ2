package Vista;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ResultadosDisponibilidad extends JFrame implements ActionListener {
	
	JButton botonReservar ,botonResgistrar,botonPantallaInicio;
    JLabel etiqueta;
    VentanaPrincipal vp;
    RealizarReservacion rere;
    Registro reg;
    
    public ResultadosDisponibilidad(String titulo) {
    super(titulo);
    setSize(800,600);
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	setLocationRelativeTo(this);
	setResizable(false);
	           
	JPanel panel = new JPanel();
	this.getContentPane().add(panel);
	panel.setLayout(null);
	panel.setBackground(Color.LIGHT_GRAY);
	        
	etiqueta = new JLabel();
	etiqueta.setText("Disponibilidad Encontrada");
	etiqueta.setBounds(300,100, 300, 50);
	panel.add(etiqueta);
	        
	botonReservar = new JButton("Realizar Reservacion");
	botonReservar.setBounds(150, 250, 200, 30);
	panel.add(botonReservar);
	botonReservar.addActionListener(this);
	        
	botonResgistrar=new JButton("Registro de huesped");
	botonResgistrar.setBounds(400, 250, 200, 30);
	panel.add(botonResgistrar);
	botonResgistrar.addActionListener(this);
	        
	botonPantallaInicio=new JButton("Volver a la pantalla de inicio");
	botonPantallaInicio.setBounds(250, 350, 300, 30);
	panel.add(botonPantallaInicio);
	botonPantallaInicio.addActionListener(this);
	
        setResizable(false);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.botonReservar) {
            if(rere!=null) {
            	rere.dispose();		
            }
            dispose();
            rere= new  RealizarReservacion("Reservacion");
	}
        
        if (e.getSource() == this.botonResgistrar) {
            if(reg!=null) {
            	reg.dispose();		
            }
            dispose();
            reg= new Registro("Registrar");
	
        }
        if (e.getSource() == this.botonPantallaInicio) {
            if(vp!=null) {
		vp.dispose();		
            }
            dispose();
            vp= new VentanaPrincipal("Hotel Las Gaviotas");
            
        }
    }


}
