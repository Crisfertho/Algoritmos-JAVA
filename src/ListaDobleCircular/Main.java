package ListaDobleCircular;

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
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Main extends JFrame {

	private static final long serialVersionUID = 1L;
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
		setTitle("Gestor de Información");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 654, 489);
		Panel_Principal = new JPanel();
		Panel_Principal.setBackground(UIManager.getColor("Button.background"));
		Panel_Principal.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(Panel_Principal);
		Panel_Principal.setLayout(null);
		
		JPanel panel_Muestra = new JPanel();
		panel_Muestra.setBackground(UIManager.getColor("Button.background"));
		panel_Muestra.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Mostrar Información", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_Muestra.setBounds(324, 39, 304, 400);
		Panel_Principal.add(panel_Muestra);
		panel_Muestra.setLayout(null);
		
		JButton btn_Limpiar = new JButton("Limpiar");
		btn_Limpiar.setIcon(new ImageIcon(Main.class.getResource("/Imagenes/Actions-edit-clear-icon.png")));
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
		panel_Gestor.setBounds(10, 40, 304, 155);
		Panel_Principal.add(panel_Gestor);
		panel_Gestor.setLayout(null);
		panel_Gestor.setForeground(Color.BLACK);
		panel_Gestor.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Buscar Información", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_Gestor.setBackground(SystemColor.menu);
		
		JLabel label = new JLabel(" ");
		label.setIcon(new ImageIcon(Main.class.getResource("/Imagenes/search-icon (2).png")));
		label.setBounds(214, 29, 71, 88);
		panel_Gestor.add(label);
		
		txtBuscar = new JTextField();
		txtBuscar.setBounds(10, 62, 194, 23);
		panel_Gestor.add(txtBuscar);
		txtBuscar.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				///accion del boton buscar
				if(!lista.SiVacia()){
					atxtMostrar.setText(lista.Buscar(txtBuscar.getText()));
					}else{
						JOptionPane.showMessageDialog(null, "No hay Datos","Lista Vacia",JOptionPane.ERROR_MESSAGE);
					}
				txtBuscar.setText("");
				
			}
		});
		btnBuscar.setBounds(72, 94, 91, 23);
		panel_Gestor.add(btnBuscar);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 638, 33);
		Panel_Principal.add(menuBar);
		
		JMenu mnAgregar = new JMenu("Agregar");
		mnAgregar.setIcon(new ImageIcon(Main.class.getResource("/Imagenes/Actions-list-add-icon (2).png")));
		menuBar.add(mnAgregar);
		
		JMenuItem mntmAgregar = new JMenuItem("Agregar Datos");
		mntmAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//accion de ingresar datos
				Catalogo c = new Catalogo();
				c.Ingresar();
				lista.Ingresar(c);
			}
		});
		mntmAgregar.setIcon(new ImageIcon(Main.class.getResource("/Imagenes/File-New-icon.png")));
		mnAgregar.add(mntmAgregar);
		
		JMenu mnMostrar = new JMenu("Mostrar");
		mnMostrar.setIcon(new ImageIcon(Main.class.getResource("/Imagenes/Apps-preferences-desktop-printer-icon.png")));
		menuBar.add(mnMostrar);
		
		JMenuItem mntmMostrar = new JMenuItem("Mostrar Datos");
		mntmMostrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//accion de mostrar
				if(!lista.SiVacia()){
					String[] opciones = {"Mostrar Inicio a Fin","Mostrar Fin a Inicio"};
					String cat = null;
					int menu = JOptionPane.showOptionDialog(null, "Seleccione una Opción:","Mostrar",
							JOptionPane.DEFAULT_OPTION,JOptionPane.QUESTION_MESSAGE,null, opciones, opciones[0]);
					if(menu == 0){
						atxtMostrar.setText(lista.MostrarInicioFin());
					}else{
						atxtMostrar.setText(lista.MostrarFinInicio());
					}
					
					}else{
						JOptionPane.showMessageDialog(null, "No hay Datos","Lista Vacia",JOptionPane.ERROR_MESSAGE);
					}
			}
		});
		mntmMostrar.setIcon(new ImageIcon(Main.class.getResource("/Imagenes/Document-icon.png")));
		mnMostrar.add(mntmMostrar);
		
		JMenu mnEliminar = new JMenu("Eliminar");
		mnEliminar.setIcon(new ImageIcon(Main.class.getResource("/Imagenes/Actions-edit-delete-icon (2).png")));
		menuBar.add(mnEliminar);
		
		JMenuItem mntmEliminar = new JMenuItem("Eliminar Datos");
		mntmEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			//accion de eliminar datos
				if(!lista.SiVacia()){
					String dato = JOptionPane.showInputDialog(null,"Ingrese el dato para eliminar","Eliminar",JOptionPane.INFORMATION_MESSAGE);
					lista.Eliminar(dato);
				}else{
					JOptionPane.showMessageDialog(null, "No hay Datos","Lista Vacia",JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		mntmEliminar.setIcon(new ImageIcon(Main.class.getResource("/Imagenes/File-Delete-icon.png")));
		mnEliminar.add(mntmEliminar);
		
		JMenu mnSalir = new JMenu("Salir");
		mnSalir.setIcon(new ImageIcon(Main.class.getResource("/Imagenes/Action-exit-icon (2).png")));
		menuBar.add(mnSalir);
		
		JMenuItem mntmSalir = new JMenuItem("Salir de la Aplicación");
		mntmSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			//salir de la aplicacion
				Salir();
			}
		});
		mntmSalir.setIcon(new ImageIcon(Main.class.getResource("/Imagenes/Logout-icon (1).png")));
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
		JOptionPane.showMessageDialog(null, "Gracias por utilizar la aplicación");
		System.exit(0);
	}
	}//fin del metodo salir
}//fin de la clase main o principal
