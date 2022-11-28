package Vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class VentanaPrincipal extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JPanel panel1, panel2, panel3, panel4;
	JButton botonDis,botonRes,botonHos, botonSalir;
	JLabel etiqueta, label1, label2;
	Registro rh;
	ConsultarDisponibilidad cd;
	


	public VentanaPrincipal(String titulo) throws HeadlessException {
		
		super(titulo);
		setSize(700,400);
		setResizable(false);
		setLocationRelativeTo(null);
		panel1=new JPanel();
		panel2=new JPanel();
		panel3=new JPanel();
		panel4=new JPanel();
		botonDis=new JButton("Consultar disponibilidad");
		botonRes=new JButton("Consultar reservacion");
		botonHos=new JButton("Consultar cliente");
		botonSalir=new JButton("Salir");		
		etiqueta=new JLabel();
		label2=new JLabel();
		label1=new JLabel("Hotel Las Gaviotas");
		label1.setFont(new Font("SERIF", Font.ITALIC, 60));
		label1.setForeground(Color.darkGray);
		label1.setHorizontalAlignment(SwingConstants.CENTER);
		
		ImageIcon icono=new ImageIcon(getClass().getResource("/Images/playa.png"));
		Image imagen=icono.getImage();
		ImageIcon iconoes=new ImageIcon(imagen.getScaledInstance(600, 100, Image.SCALE_SMOOTH));
		etiqueta.setIcon(iconoes);
		
		
		etiqueta.setHorizontalAlignment(SwingConstants.CENTER);
		
		panel1.setBackground(Color.WHITE);
		panel2.setBackground(Color.CYAN);
		panel3.setBackground(Color.WHITE);
		add(panel1,BorderLayout.CENTER);
		add(panel2,BorderLayout.SOUTH);
		add(panel3,BorderLayout.NORTH);
		
		panel3.add(label1);
		panel1.add(etiqueta);
		panel1.add(label2);
		panel2.add(botonDis);
		panel2.add(botonRes);
		panel2.add(botonHos);
		panel2.add(botonSalir);
		
		botonDis.setMnemonic('D');
		botonDis.setMnemonic('d');
		botonDis.setToolTipText("Presione ALT+D para Consultar disponibilidad");
		botonDis.addActionListener(this);
		
		botonRes.setMnemonic('R');
		botonRes.setMnemonic('r');
		botonRes.setToolTipText("Presione ALT+R para Consultar reservacion");
		botonRes.addActionListener(this);
		
		botonHos.setMnemonic('H');
		botonHos.setMnemonic('h');
		botonHos.setToolTipText("Presione ALT+H para Consultar cliente");
		botonHos.addActionListener(this);
		
		botonSalir.setMnemonic('E');
		botonSalir.setMnemonic('e');
		botonSalir.setToolTipText("Presione ALT+E para Salir");
		botonSalir.addActionListener(this);
		
		botonDis.setHorizontalAlignment(SwingConstants.CENTER);
		botonRes.setHorizontalAlignment(SwingConstants.CENTER);
		botonHos.setHorizontalAlignment(SwingConstants.CENTER);
		botonSalir.setHorizontalAlignment(SwingConstants.CENTER);
		
		panel1.setLayout(new GridLayout(2,3));
		
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
	
	if(e.getSource()==botonDis) {
		if(cd!=null) {
			cd.dispose();		
		}
		dispose();
		cd = new ConsultarDisponibilidad("Consulta de Disponibilidad");
		        
	}
	
	if(e.getSource()==botonSalir) {
		System.exit(0);
	
	}

	}

}

