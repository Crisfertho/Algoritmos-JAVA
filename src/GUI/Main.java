package GUI;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

public class Main extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel Panel_Principal;
	private JTextField txtNom;
	private JTextField txtNum;
	private JTextField txtSim;

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
		setTitle("Tabla Peri\u00F3dica");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 665, 500);
		Panel_Principal = new JPanel();
		Panel_Principal.setBackground(new Color(0, 153, 204));
		Panel_Principal.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(Panel_Principal);
		Panel_Principal.setLayout(null);
		
		JPanel panel_Muestra = new JPanel();
		panel_Muestra.setBackground(new Color(0, 153, 204));
		panel_Muestra.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Mostrar Elemento", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_Muestra.setBounds(274, 39, 375, 411);
		Panel_Principal.add(panel_Muestra);
		panel_Muestra.setLayout(null);
		
		JButton btn_Limpiar = new JButton("Limpiar");
		btn_Limpiar.setIcon(new ImageIcon(Main.class.getResource("/Imagenes/Actions-edit-clear-icon.png")));
		btn_Limpiar.setBounds(134, 356, 105, 33);
		btn_Limpiar.setToolTipText("Limpiar \u00C1rea de texto");
		panel_Muestra.add(btn_Limpiar);
		
		JScrollPane scrollPaneMostrar = new JScrollPane();
		scrollPaneMostrar.setBounds(10, 23, 352, 322);
		panel_Muestra.add(scrollPaneMostrar);
		
		JTextArea atxtMostrar = new JTextArea();
		scrollPaneMostrar.setViewportView(atxtMostrar);
		atxtMostrar.setEditable(false);
		atxtMostrar.setForeground(Color.BLACK);
		atxtMostrar.setBackground(Color.WHITE);
		atxtMostrar.setFont(new Font("Arial", Font.BOLD, 14));
		
		JPanel panel_Gestor = new JPanel();
		panel_Gestor.setBounds(0, 39, 264, 411);
		Panel_Principal.add(panel_Gestor);
		panel_Gestor.setLayout(null);
		panel_Gestor.setForeground(Color.BLACK);
		panel_Gestor.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Ingreso de Elementos", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_Gestor.setBackground(new Color(0, 153, 204));
		
		JButton btnAgregar = new JButton("Agregar Elemento");
		btnAgregar.setIcon(new ImageIcon(Main.class.getResource("/Imagenes2/Actions-list-add-icon (1).png")));
		btnAgregar.setToolTipText("Bot\u00F3n para agregar elementos");
		btnAgregar.setFont(new Font("Arial", Font.BOLD, 12));
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//accion de agregar TERMINOS

			}
		});
		btnAgregar.setBounds(35, 203, 188, 57);
		panel_Gestor.add(btnAgregar);
		
		txtNom = new JTextField();
		txtNom.setToolTipText("Campo de texto donde ingresa el nombre del elemento");
		txtNom.setBounds(10, 44, 244, 23);
		panel_Gestor.add(txtNom);
		txtNom.setColumns(10);
		
		JLabel lblNumeroDeVuelo = new JLabel("Nombre del Elemento");
		lblNumeroDeVuelo.setBounds(10, 22, 239, 23);
		panel_Gestor.add(lblNumeroDeVuelo);
		
		JLabel lblNombreDeUnidad = new JLabel("N\u00FAmero At\u00F3mico");
		lblNombreDeUnidad.setBounds(10, 135, 239, 23);
		panel_Gestor.add(lblNombreDeUnidad);
		
		txtNum = new JTextField();
		txtNum.setToolTipText("Campo de texto donde ingresa el n\u00FAmero atomino");
		txtNum.setColumns(10);
		txtNum.setBounds(10, 155, 146, 23);
		panel_Gestor.add(txtNum);
		
		JLabel lblNmeroDePgina = new JLabel("S\u00EDmbolo del Elemento");
		lblNmeroDePgina.setBounds(10, 78, 239, 23);
		panel_Gestor.add(lblNmeroDePgina);
		
		txtSim = new JTextField();
		txtSim.setToolTipText("Campo de texto donde ingresa simbolo del elemento");
		txtSim.setColumns(10);
		txtSim.setBounds(10, 101, 146, 23);
		panel_Gestor.add(txtSim);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 649, 33);
		Panel_Principal.add(menuBar);
		
		JMenu mnMostrar = new JMenu("Buscar");
		mnMostrar.setIcon(new ImageIcon(Main.class.getResource("/Imagenes2/search-icon (4).png")));
		menuBar.add(mnMostrar);
		
		JMenuItem mntmInOrden = new JMenuItem("Buscar Elementos");
		mntmInOrden.setIcon(new ImageIcon(Main.class.getResource("/Imagenes2/Document-Preview-icon.png")));
		mntmInOrden.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				///MOSTRAR INDICE
			}
		});
		mnMostrar.add(mntmInOrden);
		
		JMenu mnEliminar = new JMenu("Eliminar");
		mnEliminar.setIcon(new ImageIcon(Main.class.getResource("/Imagenes2/Trash-icon (2).png")));
		menuBar.add(mnEliminar);
		
		JMenuItem mntmEliminarElemento = new JMenuItem("Eliminar Elemento");
		mntmEliminarElemento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		mntmEliminarElemento.setIcon(new ImageIcon(Main.class.getResource("/Imagenes2/Trash-icon.png")));
		mnEliminar.add(mntmEliminarElemento);
		
		JMenu mnSalir = new JMenu("Salir");
		mnSalir.setIcon(new ImageIcon(Main.class.getResource("/Imagenes2/Action-exit-icon (2).png")));
		menuBar.add(mnSalir);
		
		JMenuItem mntmSalir = new JMenuItem("Salir de la Aplicacion");
		mntmSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			//salir de la aplicacion
				Salir();
			}
		});
		mntmSalir.setIcon(new ImageIcon(Main.class.getResource("/Imagenes2/Logout-icon (1).png")));
		mnSalir.add(mntmSalir);
		
		
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

