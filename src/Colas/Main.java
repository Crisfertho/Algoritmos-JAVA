package Colas;


import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class Main extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel Panel_Principal;
	private JTextField txtNombre;
	private JTextField txtDNI;
	private JTextField txtEdad;
	private JTextField txtProced;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Main() {
		setTitle("Tribunal Eterno de Elecciones");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 654, 458);
		Panel_Principal = new JPanel();
		Panel_Principal.setBackground(UIManager.getColor("Button.background"));
		Panel_Principal.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(Panel_Principal);
		Panel_Principal.setLayout(null);
		
		JPanel panel_Muestra = new JPanel();
		panel_Muestra.setBackground(UIManager.getColor("Button.background"));
		panel_Muestra.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Mostrar Informaci\u00F3n", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_Muestra.setBounds(324, 11, 304, 400);
		Panel_Principal.add(panel_Muestra);
		panel_Muestra.setLayout(null);
		
		JButton btn_Limpiar = new JButton("Limpiar");
		btn_Limpiar.setIcon(new ImageIcon(Main.class.getResource("/ImagenesColas/Actions-edit-clear-icon.png")));
		btn_Limpiar.setBounds(98, 354, 105, 33);
		btn_Limpiar.setToolTipText("Limpiar Informaci\u00F3n");
		panel_Muestra.add(btn_Limpiar);
		
		JScrollPane scrollPaneMostrar = new JScrollPane();
		scrollPaneMostrar.setBounds(10, 21, 282, 322);
		panel_Muestra.add(scrollPaneMostrar);
		
		JTextArea atxtMostrar = new JTextArea();
		atxtMostrar.setEditable(false);
		scrollPaneMostrar.setViewportView(atxtMostrar);
		atxtMostrar.setForeground(Color.BLACK);
		atxtMostrar.setBackground(Color.WHITE);
		atxtMostrar.setFont(new Font("Arial", Font.BOLD, 14));
		
		JPanel panel_Gestor = new JPanel();
		panel_Gestor.setBounds(10, 11, 304, 399);
		Panel_Principal.add(panel_Gestor);
		panel_Gestor.setLayout(null);
		panel_Gestor.setForeground(Color.BLACK);
		panel_Gestor.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Registro de Votantes", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_Gestor.setBackground(SystemColor.menu);
		
		JButton btnVotar = new JButton("");
		btnVotar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//accion de mostrar el votante y elegir partido por votar
			}
		});
		btnVotar.setIcon(new ImageIcon(Main.class.getResource("/ImagenesColas/Button-Ok-icon.png")));
		btnVotar.setToolTipText("Votar");
		btnVotar.setBounds(176, 161, 46, 49);
		panel_Gestor.add(btnVotar);
		
		JButton btnAgregar = new JButton("");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Agregar un nuevo nodo a la cola
				
			}
		});
		btnAgregar.setToolTipText("Agregar Votante ");
		btnAgregar.setIcon(new ImageIcon(Main.class.getResource("/ImagenesColas/Button-Add-icon (1).png")));
		btnAgregar.setBounds(77, 161, 46, 49);
		panel_Gestor.add(btnAgregar);
		
		JButton btnSalir = new JButton("");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//accion del boton para salir de la aplicacion
				Salir();
			}
		});
		btnSalir.setToolTipText("Salir de la Aplicaci\u00F3n");
		btnSalir.setIcon(new ImageIcon(Main.class.getResource("/ImagenesColas/Button-Delete-icon (6).png")));
		btnSalir.setBounds(176, 254, 46, 49);
		panel_Gestor.add(btnSalir);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(93, 30, 167, 20);
		panel_Gestor.add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(28, 33, 46, 14);
		panel_Gestor.add(lblNombre);
		
		JLabel lblDNI = new JLabel("DNI");
		lblDNI.setBounds(28, 70, 46, 14);
		panel_Gestor.add(lblDNI);
		
		JLabel lblEdad = new JLabel("Edad");
		lblEdad.setBounds(28, 95, 46, 14);
		panel_Gestor.add(lblEdad);
		
		JLabel lblProce = new JLabel("Procedencia");
		lblProce.setBounds(28, 126, 69, 14);
		panel_Gestor.add(lblProce);
		
		txtDNI = new JTextField();
		txtDNI.setColumns(10);
		txtDNI.setBounds(93, 61, 167, 20);
		panel_Gestor.add(txtDNI);
		
		txtEdad = new JTextField();
		txtEdad.setColumns(10);
		txtEdad.setBounds(93, 92, 167, 20);
		panel_Gestor.add(txtEdad);
		
		txtProced = new JTextField();
		txtProced.setColumns(10);
		txtProced.setBounds(93, 123, 167, 20);
		panel_Gestor.add(txtProced);
		
		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Accion de mostrar los resultados de las votaciones
			}
		});
		button.setIcon(new ImageIcon(Main.class.getResource("/ImagenesColas/Document-icon (1).png")));
		button.setToolTipText("Mostrar Resultados de la Votacion");
		button.setBounds(77, 254, 46, 49);
		panel_Gestor.add(button);
		
		
		btn_Limpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				atxtMostrar.setText("");
			}
		});
	}//fin del constructor
public void Salir(){
	int salir = JOptionPane.showConfirmDialog(null, "¿Desea salir de la aplicación?");
    if(salir == JOptionPane.YES_OPTION){
	JOptionPane.showMessageDialog(null, "Gracias por utilizar la aplicacion");
	System.exit(0);
}
}//fin del metodo salir
}//fin de la clase main o principal
