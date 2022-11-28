package Vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import Controlador.C_Registro;
import Controlador.ValidarDatos;

public class Registro extends JFrame implements ActionListener {
	
	private static final long serialVersionUID = 1L;
	JPanel panel1, panel2,panel3;
	JButton botonConf,botonCanc;
	JTextField texto1, texto2, texto3, texto4, texto5, texto6, texto7, texto8, texto9, texto10;
	JLabel label1, label2, label3, label4, label5, label6, label7, label8, label9, label10, label11;
	VentanaPrincipal vp;
	JComboBox<String>  year, dia, mes , yearS, diaS, mesS;
	JComboBox<Integer> numHab;
	ValidarDatos vd;
	
	
	
	public Registro(String titulo) throws HeadlessException {
		super(titulo);
		setSize(600,600);
		setResizable(false);
		setLocationRelativeTo(null);
		panel1=new JPanel();
		panel2=new JPanel();
		panel3=new JPanel();
		vd= new ValidarDatos();
		
		botonConf=new JButton("Confirmar");
		botonCanc=new JButton("Cancelar");
		label1 = new JLabel("Nombre");
		label2 = new JLabel("Apellidos");
		label3 = new JLabel("Telefono");
		label4 = new JLabel("Email");
		label5 = new JLabel("Cd. Procedencia");
		label6 = new JLabel("Fecha Llegada");
		label7 = new JLabel("Fecha de Salida");
		label8 = new JLabel("No. Habitacion");
		label9 = new JLabel("Precio");
		
		label10 = new JLabel("Datos de Hospedaje");
		label10.setFont(new Font("SERIF", Font.ITALIC, 30));
		label10.setForeground(Color.BLACK);
		
		label11= new JLabel("ID Hospedaje");
		texto10= new JTextField();
		
		texto1= new JTextField(4);
		texto2= new JTextField(4);
		texto3= new JTextField(4);
		texto4= new JTextField(4);
		texto5= new JTextField(4);
		texto6= new JTextField(4);
		texto7= new JTextField(4);
		texto8= new JTextField(4);
		texto9= new JTextField(4);
		
		year = new JComboBox<String>();
		dia = new JComboBox<String>();
		mes = new JComboBox<String>();
		yearS = new JComboBox<String>();
		diaS = new JComboBox<String>();
		mesS = new JComboBox<String>();
		numHab = new JComboBox<Integer>();
		
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
		
		for(int i= 2022; i<2041; i++) {
			year.addItem(""+i);
			yearS.addItem(""+i);
				
		}
		
		for(int i= 1; i<11; i++) {
			numHab.addItem(i);
		}
		
		
		panel1.setBackground(Color.LIGHT_GRAY);
		panel2.setBackground(Color.LIGHT_GRAY);
		panel3.setBackground(Color.LIGHT_GRAY);
		add(panel1,BorderLayout.NORTH);
		add(panel2,BorderLayout.CENTER);
		add(panel3,BorderLayout.SOUTH);
		
	    panel1.add(label10);
	    panel2.add(label11);
	    panel2.add(texto10);
	    panel2.add(label1);
	    panel2.add(texto1);
	    panel2.add(label2);
	    panel2.add(texto2);
	    panel2.add(label3);
	    panel2.add(texto3);
	    panel2.add(label4);
	    panel2.add(texto4);
	    panel2.add(label5);
	    panel2.add(texto5);
	    panel2.add(label6);
	    panel2.add(dia);
		panel2.add(mes);
		panel2.add(year);
	    panel2.add(label7);
	    panel2.add(diaS);
		panel2.add(mesS);
		panel2.add(yearS);
	    panel2.add(label8);
	    panel2.add(numHab);
	    panel2.add(label9);
	    panel2.add(texto9);
	    panel3.add(botonConf);
		panel3.add(botonCanc);
		
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
		if(e.getSource()==botonCanc) {
			if(vp!=null) {
				vp.dispose();		
			}
		dispose();
		vp= new VentanaPrincipal("Hotel Las Gaviotas");	
		}
		
		if(e.getSource()==botonConf) {
			String fechaLlegada= null, fechaSalida= null, nombre=null, apellido=null, tel=null, email=null, cdProcedencia=null;
			double precio=0.0;
			int idHues=0, numh, cont=0;
			
			if(vd.NoReserva(texto10.getText())) {
				idHues= Integer.parseInt(String.valueOf(texto10.getText()));
				cont++;
			}
			else 
				javax.swing.JOptionPane.showMessageDialog(null,"RESERVACION NO EXITOSA. REVISAR ID", "ERROR", JOptionPane.ERROR_MESSAGE);
			
			
			if(vd.ValidarNombre(texto1.getText())){
				nombre=texto1.getText();
				cont++;
			}
			else 
				javax.swing.JOptionPane.showMessageDialog(null,"REGISTRO NO EXITOSO. REVISAR NOMBRE", "ERROR", JOptionPane.ERROR_MESSAGE);
			
			if(vd.ValidarApellidos(texto2.getText())) {
				apellido = texto2.getText();
				cont++;
			}
			else 
				javax.swing.JOptionPane.showMessageDialog(null,"REGISTRO NO EXITOSO. REVISAR APELLIDO", "ERROR", JOptionPane.ERROR_MESSAGE);
			
			if(vd.ValidarTel(texto3.getText())) {
				tel = texto3.getText();
				cont++;
			}
			else 
				javax.swing.JOptionPane.showMessageDialog(null,"REGISTRO NO EXITOSO. REVISAR TELEFONO", "ERROR", JOptionPane.ERROR_MESSAGE);
			
			if(vd.ValidarFecha(dia.getSelectedIndex(), mes.getSelectedIndex(), year.getSelectedIndex())) {
				fechaLlegada= year.getSelectedItem()+"/"+mes.getSelectedItem()+"/"+dia.getSelectedItem();
				cont++;
			}
			
			else 
				javax.swing.JOptionPane.showMessageDialog(null,"REGISTRO NO EXITOSO. REVISAR FECHA DE LLEGADA", "ERROR", JOptionPane.ERROR_MESSAGE);
			
			if(vd.ValidarFecha(diaS.getSelectedIndex(), mesS.getSelectedIndex(), yearS.getSelectedIndex())) {
				fechaSalida= yearS.getSelectedItem()+"/"+mesS.getSelectedItem()+"/"+diaS.getSelectedItem();
				cont++;
			}
			else 
				javax.swing.JOptionPane.showMessageDialog(null,"REGISTRO NO EXITOSO. REVISAR FECHA DE SALIDA", "ERROR", JOptionPane.ERROR_MESSAGE);
			
			if(vd.ValidarPrecio(texto9.getText())) {
				precio= Double.parseDouble(String.valueOf(texto9.getText()));
				cont++;
			}
			else 
				javax.swing.JOptionPane.showMessageDialog(null,"REGISTRO NO EXITOSO. REVISAR PRECIO", "ERROR", JOptionPane.ERROR_MESSAGE);
			
			email=texto4.getText();
			cdProcedencia=texto5.getText();
			numh = (Integer)numHab.getSelectedItem();
			
			if(cont==7) {
				C_Registro r = new C_Registro (idHues,fechaLlegada, fechaSalida, nombre, apellido, tel, email, cdProcedencia, numh, precio);
				r.registro();
				
				if(vp!=null) {
					vp.dispose();		
				}
				else {
					dispose();
					vp= new VentanaPrincipal("Hotel Las Gaviotas");		
				}
			}
			else {
				javax.swing.JOptionPane.showMessageDialog(null,"REGISTRO NO EXITOSO. REVISAR DATOS", "ERROR", JOptionPane.ERROR_MESSAGE);
				cont=0;
			}
			
		}
	}

}
