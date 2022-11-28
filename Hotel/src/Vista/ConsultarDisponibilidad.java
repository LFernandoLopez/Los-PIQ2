package Vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import Controlador.C_ConsultarDisponibilidad;
import Controlador.ValidarDatos;

public class ConsultarDisponibilidad extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	JPanel panel1, panel2,panel3;
	JButton botonBus ,botonCanc;
	JLabel label1, label2, label3, label4;
	JTextField texto1, texto2; 
	JRadioButton sencilla, doble;
	ButtonGroup hab;
	VentanaPrincipal vp;
	JComboBox<String> year, dia, mes, yearS, diaS, mesS;
	ValidarDatos vd;
	

	
	public ConsultarDisponibilidad (String titulo) throws HeadlessException {
		super(titulo);
		setSize(350,350);
		setResizable(false);
		setLocationRelativeTo(null);
		panel1=new JPanel();
		panel2=new JPanel();
		panel3=new JPanel();
		vd= new ValidarDatos();
		botonBus=new JButton("Buscar");
		botonCanc=new JButton("Cancelar");
		
		label1 = new JLabel("Tipo de Habitacion ");
		label2 = new JLabel("Fecha de Llegada");
		label4 = new JLabel("Fecha de Salida");
		//label3 = new JLabel("Consulta Disponibilidad ");
		//label3.setFont(new Font("SERIF", Font.ITALIC, 25));
		//label3.setForeground(Color.BLUE);
		
		
		
		hab=new ButtonGroup();
		sencilla = new JRadioButton("Sencilla",true);
		doble = new JRadioButton("Doble");
		year = new JComboBox<String>();
		dia = new JComboBox<String>();
		mes = new JComboBox<String>();
		yearS = new JComboBox<String>();
		diaS = new JComboBox<String>();
		mesS = new JComboBox<String>();
		hab.add(sencilla);
		hab.add(doble);
		
		dia.addItem("--Dia--");
		mes.addItem("--Mes--");
		year.addItem("--Año--");
		diaS.addItem("--Dia--");
		mesS.addItem("--Mes--");
		yearS.addItem("--Año--");
		
		for(int i= 1; i<32; i++) {
			if(i<10){
				dia.addItem("0"+i);
				diaS.addItem("0"+i);
				
			}	
			
			else
			{
				dia.addItem(""+i);
				diaS.addItem(""+i);
				
			}
				
		}
		
		for(int i= 1; i<13; i++) {
			if(i<10){
				mes.addItem("0"+i);
				mesS.addItem("0"+i);
				
				
			}
				
			else
			{
				mes.addItem(""+i);
				mesS.addItem(""+i);
				
				
			}
				
				
		}
		for(int i= 2022; i<2041; i++) {
			year.addItem(""+i);
			yearS.addItem(""+i);		
		}
		
	    
		panel1.setBackground(Color.LIGHT_GRAY);
		panel2.setBackground(Color.LIGHT_GRAY);
		panel3.setBackground(Color.LIGHT_GRAY);
		add(panel3,BorderLayout.NORTH);
		add(panel1,BorderLayout.CENTER);
		add(panel2,BorderLayout.SOUTH);
		
		
		
		panel2.add(botonBus);
		panel2.add(botonCanc);
		
		//panel3.add(label3);
		
		panel1.add(label1);
		panel1.add(sencilla);
		panel1.add(doble);
		panel1.add(label2);
		panel1.add(dia);
		panel1.add(mes);
		panel1.add(year);
		panel1.add(label4);
		panel1.add(diaS);
		panel1.add(mesS);
		panel1.add(yearS);
	
		
		
		
		
		
		botonCanc.setMnemonic('C');
		botonCanc.setMnemonic('c');
		botonCanc.setToolTipText("Presione ALT+C para Cancelar");
		botonCanc.addActionListener(this);
		
		botonBus.setMnemonic('B');
		botonBus.setMnemonic('b');
		botonBus.setToolTipText("Presione ALT+B para Buscar");
		botonBus.addActionListener(this);
		

		
		botonBus.setHorizontalAlignment(SwingConstants.CENTER);
		botonCanc.setHorizontalAlignment(SwingConstants.CENTER);
		
		
		panel1.setLayout(new GridLayout(0,1));
		
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String fechaLlegada= null, fechaSalida=null, tipoHab =null;
		int cont=0;
		
		if(e.getSource()==botonCanc){
			if(vp!=null) {
				vp.dispose();		
			}
			dispose();
			
			vp= new VentanaPrincipal("Hotel Las Gaviotas");		
		}
		if(e.getSource()==botonBus) {
			
			if(sencilla.isSelected()) 
				tipoHab = "sencilla";
			else 
				tipoHab="doble";
			
			if(vd.ValidarFecha(dia.getSelectedIndex(), mes.getSelectedIndex(), year.getSelectedIndex())) {
				fechaLlegada= year.getSelectedItem()+"/"+mes.getSelectedItem()+"/"+dia.getSelectedItem();
				cont++;
			}
			else 
				javax.swing.JOptionPane.showMessageDialog(null,"BUSQUEDA NO EXITOSA. REVISAR FECHA DE LLEGADA", "ERROR", JOptionPane.ERROR_MESSAGE);
			
			if(vd.ValidarFecha(diaS.getSelectedIndex(), mesS.getSelectedIndex(), yearS.getSelectedIndex())) {
				fechaSalida= yearS.getSelectedItem()+"/"+mesS.getSelectedItem()+"/"+diaS.getSelectedItem();
				cont++;
			}
			else 
				javax.swing.JOptionPane.showMessageDialog(null,"BUSQUEDA NO EXITOSA. REVISAR FECHA DE SALIDA", "ERROR", JOptionPane.ERROR_MESSAGE);
			
		if(cont==2) {
			C_ConsultarDisponibilidad cd = new C_ConsultarDisponibilidad(fechaLlegada, fechaSalida, tipoHab);
			cd.ConsultarDisponibilidad();
			dispose();
		}
		else {
			javax.swing.JOptionPane.showMessageDialog(null,"BUSQUEDA NO EXITOSA. REVISAR DATOS", "ERROR", JOptionPane.ERROR_MESSAGE);
			cont=0;
		}
		
	}
	}

}
