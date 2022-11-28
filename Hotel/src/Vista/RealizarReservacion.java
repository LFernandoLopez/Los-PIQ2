package Vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import Controlador.C_Reservacion;
import Controlador.ValidarDatos;

public class RealizarReservacion extends JFrame implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JPanel panel1, panel2,panel3, panel4,panel5;
	JButton botonConf,botonCanc;
	JLabel label1, label2, label3, label4, label5, label6, label7, label8, label9, label10, label11, etiqueta, label12 ;
	JTextField texto1, texto2, texto3, texto4, texto5, texto6,texto7; 
	JRadioButton sencilla, doble;
	ButtonGroup hab;
	VentanaPrincipal vp;
	public JComboBox<String>  year, dia, mes , yearS, diaS, mesS;
	ValidarDatos vd;
	

	public RealizarReservacion(String titulo) throws HeadlessException {
		super(titulo);
		setSize(400,600);
		setResizable(false);
		setLocationRelativeTo(null);
		panel1=new JPanel();
		panel2=new JPanel();
		panel3=new JPanel();
		panel4=new JPanel();
		panel5=new JPanel();
		etiqueta = new JLabel();
		vd= new ValidarDatos();
		
		botonConf=new JButton("Confirmar");
		botonCanc=new JButton("Cancelar");
		
		label1 = new JLabel("Fecha Llegada");
		label2 = new JLabel("Fecha de Salida");
		label3 = new JLabel("Nombre");
		label4 = new JLabel("Apellidos");
		label5 = new JLabel("Telefono");
		label6 = new JLabel("Tipo de habitacion");
		label7 = new JLabel("Precio");
		label8 = new  JLabel("Datos de Reservacion");
		label8.setFont(new Font("SERIF", Font.ITALIC, 30));
		label8.setForeground(Color.BLACK);
		
		label12= new JLabel("ID Reservacion");
		texto7= new JTextField();
		
		label9 = new JLabel("Dia");
		label10 = new JLabel("Mes");
		label11 = new JLabel("Año");
		texto1= new JTextField(4);
		texto2= new JTextField(4);
		texto3= new JTextField(4);
		texto4= new JTextField(4);
		texto5= new JTextField(4);
		texto6= new JTextField(4);
		hab=new ButtonGroup();
		year = new JComboBox<String>();
		dia = new JComboBox<String>();
		mes = new JComboBox<String>();
		yearS = new JComboBox<String>();
		diaS = new JComboBox<String>();
		mesS = new JComboBox<String>();
		sencilla = new JRadioButton("Sencilla",true);
		doble = new JRadioButton("Doble");
		hab.add(sencilla);
		hab.add(doble);
		
		dia.addItem("--Dia--");
		diaS.addItem("--Dia--");
		mes.addItem("--Mes--");
		mesS.addItem("--Mes--");
		year.addItem("--Año--");
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
		for(int i= 2022; i<2042; i++) {
			year.addItem(""+i);
			yearS.addItem(""+i);
				
		}
		
		dia.setBounds(120,10,50,30);
		
		panel1.setBackground(Color.LIGHT_GRAY);
		panel2.setBackground(Color.LIGHT_GRAY);
		panel3.setBackground(Color.LIGHT_GRAY);
		
		add(panel1,BorderLayout.NORTH);
		add(panel2,BorderLayout.CENTER);
		add(panel3,BorderLayout.WEST);
		//add(panel4,BorderLayout.EAST);
		add(panel5,BorderLayout.SOUTH);
		
		
		panel1.add(label8);
		panel2.add(label12);
		panel2.add(texto7);
		panel2.add(label3);
		panel2.add(texto1);
		panel2.add(label4);
		panel2.add(texto2);
		panel2.add(label5);
		panel2.add(texto5);
		panel2.add(label1);
		panel2.add(dia);
		panel2.add(mes);
		panel2.add(year);
		panel2.add(label2);
		panel2.add(diaS);
		panel2.add(mesS);
		panel2.add(yearS);
		panel2.add(label6);
		panel2.add(sencilla);
		panel2.add(doble);
		panel2.add(label7);
		panel2.add(texto4);
		panel5.add(botonConf);
		panel5.add(botonCanc);
		
		
		panel4.add(etiqueta);
		panel3.add(etiqueta);
		
		//panel4.setLayout(new GridLayout(1,3));
	
		botonCanc.setMnemonic('E');
		botonCanc.setMnemonic('e');
		botonCanc.setToolTipText("Presione ALT+E para Cancelar");
		botonCanc.addActionListener(this);
		
		botonConf.setMnemonic('A');
		botonConf.setMnemonic('a');
		botonConf.setToolTipText("Presione ALT+A para Confirmar");
		botonConf.addActionListener(this);

		
		botonConf.setHorizontalAlignment(SwingConstants.CENTER);
		botonCanc.setHorizontalAlignment(SwingConstants.CENTER);
		
		
		panel2.setLayout(new GridLayout(0,1));
		
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==botonCanc)
			if(vp!=null) {
				vp.dispose();		
			}
			else {
			dispose();
			vp= new VentanaPrincipal("Hotel Las Gaviotas");		
			}
		if(e.getSource()==botonConf) {
			
			String fechaLlegada= null, fechaSalida= null, nombre=null, apellido=null, tel=null, tipoHab=null, status= "Vigente";
			Double precio=0.0;
			int idRes = 0,  cont=0;
			
			if(sencilla.isSelected()) 
				tipoHab = "sencilla";
			else 
				tipoHab="doble";
			
			if(vd.NoReserva(texto7.getText())) {
				idRes= Integer.parseInt(String.valueOf(texto7.getText()));
				cont++;
			}
			else 
				javax.swing.JOptionPane.showMessageDialog(null,"RESERVACION NO EXITOSA. REVISAR ID", "ERROR", JOptionPane.ERROR_MESSAGE);
			

			if(vd.ValidarNombre(texto1.getText())) {
				nombre=texto1.getText();
				cont++;
			}
			else 
				javax.swing.JOptionPane.showMessageDialog(null,"RESERVACION NO EXITOSA. REVISAR NOMBRE", "ERROR", JOptionPane.ERROR_MESSAGE);
			
			if(vd.ValidarApellidos(texto2.getText())) {
				apellido = texto2.getText();
				cont++;
			}
			else 
				javax.swing.JOptionPane.showMessageDialog(null,"RESERVACION NO EXITOSA. REVISAR APELLIDO", "ERROR", JOptionPane.ERROR_MESSAGE);
			
			if(vd.ValidarTel(texto5.getText())) {
				tel = texto5.getText();
				cont++;
			}
			else 
				javax.swing.JOptionPane.showMessageDialog(null,"RESERVACION NO EXITOSA. REVISAR TELEFONO", "ERROR", JOptionPane.ERROR_MESSAGE);
			
			if(vd.ValidarFecha(dia.getSelectedIndex(), mes.getSelectedIndex(), year.getSelectedIndex())) {
				fechaLlegada=  year.getSelectedItem()+"/"+mes.getSelectedItem()+"/"+dia.getSelectedItem();
				cont++;
			}
			else 
				javax.swing.JOptionPane.showMessageDialog(null,"RESERVACION NO EXITOSA. REVISAR FECHA DE LLEGADA", "ERROR", JOptionPane.ERROR_MESSAGE);
			
			if(vd.ValidarFecha(diaS.getSelectedIndex(), mesS.getSelectedIndex(), yearS.getSelectedIndex())) {
				fechaSalida= yearS.getSelectedItem()+"/"+mesS.getSelectedItem()+"/"+diaS.getSelectedItem();
				cont++;
			}
			else 
				javax.swing.JOptionPane.showMessageDialog(null,"RESERVACION NO EXITOSA. REVISAR FECHA DE SALIDA", "ERROR", JOptionPane.ERROR_MESSAGE);
			
			if(vd.ValidarPrecio(texto4.getText())) {
				precio= Double.parseDouble(String.valueOf(texto4.getText()));
				cont++;
			}
			else 
				javax.swing.JOptionPane.showMessageDialog(null,"RESERVACION NO EXITOSA. REVISAR PRECIO", "ERROR", JOptionPane.ERROR_MESSAGE);
			
			
			if(cont==7) {
				C_Reservacion r = new C_Reservacion(idRes, fechaLlegada, fechaSalida, nombre, apellido, tel, tipoHab, precio, status);
				r.Reservacion();
				if(vp!=null) {
					vp.dispose();		
				}
				else {
					dispose();
					vp= new VentanaPrincipal("Hotel Las Gaviotas");		
				}
			}
			else {
				javax.swing.JOptionPane.showMessageDialog(null,"RESERVACION NO EXITOSA. REVISAR DATOS", "ERROR", JOptionPane.ERROR_MESSAGE);
				cont=0;
			}	
		}		
	}
}
