package ListaDoble;


import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
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

	private JPanel Panel_Principal;
	private JTextField txtBuscar;
	ListaDoble lista = new ListaDoble();
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
		setTitle("Admistracion de Informacion");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 595, 481);
		Panel_Principal = new JPanel();
		Panel_Principal.setBackground(UIManager.getColor("Button.background"));
		Panel_Principal.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(Panel_Principal);
		Panel_Principal.setLayout(null);
		
		JPanel panel_Muestra = new JPanel();
		panel_Muestra.setBackground(UIManager.getColor("Button.background"));
		panel_Muestra.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Mostrar Informaci\u00F3n", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_Muestra.setBounds(262, 31, 307, 400);
		Panel_Principal.add(panel_Muestra);
		panel_Muestra.setLayout(null);
		
		JButton btn_Limpiar = new JButton("Limpiar");
//		btn_Limpiar.setIcon(new ImageIcon(Main.class.getResource("/Imagenes/Actions-edit-clear-icon.png")));
		btn_Limpiar.setBounds(107, 354, 114, 33);
		btn_Limpiar.setToolTipText("Limpiar Informaci\u00F3n");
		panel_Muestra.add(btn_Limpiar);
		
		JScrollPane scrollPaneMostrar = new JScrollPane();
		scrollPaneMostrar.setBounds(10, 21, 287, 322);
		panel_Muestra.add(scrollPaneMostrar);
		
		JTextArea atxtMostrar = new JTextArea();
		scrollPaneMostrar.setViewportView(atxtMostrar);
		atxtMostrar.setForeground(Color.BLACK);
		atxtMostrar.setBackground(Color.WHITE);
		atxtMostrar.setFont(new Font("Consolas", Font.BOLD, 13));
		atxtMostrar.setEditable(false);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setToolTipText("Barra de Opciones");
		menuBar.setBounds(0, 0, 557, 26);
		Panel_Principal.add(menuBar);
		
		JMenu mnAgregar = new JMenu("Agregar");
		//mnAgregar.setIcon(new ImageIcon(Main.class.getResource("/Imagenes/Actions-list-add-icon (2).png")));
		menuBar.add(mnAgregar);
		
		JMenuItem mntmAgregarInicio = new JMenuItem("Agregar al Inicio");
		mntmAgregarInicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Accion de agregar al incio de la lista doble
				Catalogo C1 = new Catalogo();
				C1.Ingresar();
				lista.InsertarInicio(C1);
			}
		});
		//mntmAgregarInicio.setIcon(new ImageIcon(Main.class.getResource("/Imagenes/Button-Previous-icon (2).png")));
		mnAgregar.add(mntmAgregarInicio);
		
		JMenuItem mntmAgregarFinal = new JMenuItem("Agregar al final");
		mntmAgregarFinal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				///Accion de agregar al final de la lista doble
				Catalogo C2 = new Catalogo();
				C2.Ingresar();
				lista.InsertarFinal(C2);
			}
		});
		
		JMenuItem mntmAgregarEnMedio = new JMenuItem("Agregar en Medio");
		mntmAgregarEnMedio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				///Accion de agregar en medio de la lista doble
				Catalogo C3 = new Catalogo();
				C3.Ingresar();
				lista.InsertarMedio(C3);
			}
		});
//		mntmAgregarEnMedio.setIcon(new ImageIcon(Main.class.getResource("/Imagenes/Button-Add-icon (4).png")));
		mnAgregar.add(mntmAgregarEnMedio);
		//mntmAgregarFinal.setIcon(new ImageIcon(Main.class.getResource("/Imagenes/Button-Next-icon (2).png")));
		mnAgregar.add(mntmAgregarFinal);
		
		JMenu mnMostrar = new JMenu("Mostrar");
		mnMostrar.setIcon(new ImageIcon(Main.class.getResource("/Imagenes/Apps-preferences-desktop-printer-icon.png")));
		menuBar.add(mnMostrar);
		
		JMenuItem mntmMostrarDeInicio = new JMenuItem("Mostrar de Inicio a Fin");
		//mntmMostrarDeInicio.setIcon(new ImageIcon(Main.class.getResource("/Imagenes/Button-Next-icon (2).png")));
		mntmMostrarDeInicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Accion de mostrar los datos de la lista de inicio a fin
				atxtMostrar.setText(lista.MostrarInicioFin());
				
			}
		});
		mnMostrar.add(mntmMostrarDeInicio);
		
		JMenuItem mntmMostrarDeFin = new JMenuItem("Mostrar de Fin a Inicio");
		//mntmMostrarDeFin.setIcon(new ImageIcon(Main.class.getResource("/Imagenes/Button-Previous-icon (2).png")));
		mntmMostrarDeFin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				///Accion de mostrar los datos de la lista de fin a inicio
				atxtMostrar.setText(lista.MostrarFinInicio());
			}
		});
		mnMostrar.add(mntmMostrarDeFin);
		
		JMenu mnEliminar = new JMenu("Eliminar");
		//mnEliminar.setIcon(new ImageIcon(Main.class.getResource("/Imagenes/Actions-list-remove-icon.png")));
		menuBar.add(mnEliminar);
		
		JMenuItem mntmEliminar = new JMenuItem("Eliminar Datos");
		mntmEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				///Accion de eliminar un dato de la lista
				if(!lista.SiVacia()){
				String dato = JOptionPane.showInputDialog(null, "Ingrese el dato a eliminar");
				lista.EliminarNodo(dato);
				}else{
					JOptionPane.showMessageDialog(null, "No hay datos!");
				}
			}
		});
//		mntmEliminar.setIcon(new ImageIcon(Main.class.getResource("/Imagenes/Trash-icon (2).png")));
		mnEliminar.add(mntmEliminar);
		
		JMenu mnSalir = new JMenu("Salir");
		menuBar.add(mnSalir);
		
		JMenuItem mntmSalirDelPrograma = new JMenuItem("Salir del Programa");
		mntmSalirDelPrograma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Accion para salir del programa
				Salir();
			}
		});
		mntmSalirDelPrograma.setIcon(new ImageIcon(Main.class.getResource("/Imagenes/Action-exit-icon (2).png")));
		mnSalir.add(mntmSalirDelPrograma);
		
		JPanel panel_Buscar = new JPanel();
		panel_Buscar.setBounds(10, 32, 242, 98);
		Panel_Principal.add(panel_Buscar);
		panel_Buscar.setLayout(null);
		panel_Buscar.setForeground(Color.BLACK);
		panel_Buscar.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Buscar Datos", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_Buscar.setBackground(SystemColor.menu);
		
		txtBuscar = new JTextField();
		txtBuscar.setBounds(10, 21, 152, 23);
		panel_Buscar.add(txtBuscar);
		txtBuscar.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setToolTipText("Buscar un dato");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				///Accion de buscar un dato en especifico
				atxtMostrar.setText(lista.Buscar(txtBuscar.getText()));
				txtBuscar.setText("");
			}
		});
		btnBuscar.setBounds(51, 55, 82, 23);
		panel_Buscar.add(btnBuscar);
		
		JLabel lblBuscar = new JLabel("");
		//lblBuscar.setIcon(new ImageIcon(Main.class.getResource("/Imagenes/search-icon (1).png")));
		lblBuscar.setBounds(170, 11, 62, 67);
		panel_Buscar.add(lblBuscar);
		
		
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

