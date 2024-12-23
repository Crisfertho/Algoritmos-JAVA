package Arboles;

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

	private static final long serialVersionUID = 1L;
	private JPanel Panel_Principal;
	private JTextField txtbuscar;
	Arbol arbol = new Arbol();
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
		setTitle("Arboles Binarios");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 654, 489);
		Panel_Principal = new JPanel();
		Panel_Principal.setBackground(UIManager.getColor("Button.background"));
		Panel_Principal.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(Panel_Principal);
		Panel_Principal.setLayout(null);
		
		JPanel panel_Muestra = new JPanel();
		panel_Muestra.setBackground(UIManager.getColor("Button.background"));
		panel_Muestra.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Mostrar Informaci\u00F3n", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
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
		panel_Gestor.setBounds(0, 39, 314, 152);
		Panel_Principal.add(panel_Gestor);
		panel_Gestor.setLayout(null);
		panel_Gestor.setForeground(Color.BLACK);
		panel_Gestor.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Ingreso de Libros", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_Gestor.setBackground(SystemColor.menu);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//accion de buscar
				if(!arbol.SiVacio()){
					atxtMostrar.setText(arbol.Buscar(txtbuscar.getText()).datos.toString());
					}else{
						JOptionPane.showMessageDialog(null, "No hay datos");
					}
				
			}
		});
		btnBuscar.setBounds(49, 105, 103, 23);
		panel_Gestor.add(btnBuscar);
		
		txtbuscar = new JTextField();
		txtbuscar.setBounds(10, 54, 186, 30);
		panel_Gestor.add(txtbuscar);
		txtbuscar.setColumns(10);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Main.class.getResource("/Imagenes/search-icon (2).png")));
		label.setBounds(206, 11, 74, 95);
		panel_Gestor.add(label);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 638, 33);
		Panel_Principal.add(menuBar);
		
		JMenu mnAgregar = new JMenu("Agregar");
		mnAgregar.setIcon(new ImageIcon(Main.class.getResource("/Imagenes/Actions-list-add-icon (2).png")));
		menuBar.add(mnAgregar);
		
		JMenuItem mntmIngresar = new JMenuItem("Ingresar");
		mntmIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//accion de agregar
				Catalogo c = new Catalogo();
				c.Ingresar();
				arbol.AgregarNodo(c);
			}
		});
		mntmIngresar.setIcon(new ImageIcon(Main.class.getResource("/Imagenes/File-New-icon.png")));
		mnAgregar.add(mntmIngresar);
		
		JMenu mnEliminar = new JMenu("Eliminar");
		mnEliminar.setIcon(new ImageIcon(Main.class.getResource("/Imagenes/Actions-list-remove-icon.png")));
		menuBar.add(mnEliminar);
		
		JMenuItem mntmEliminar = new JMenuItem("Eliminar");
		mntmEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//accion para eliminar
				if(!arbol.SiVacio()){
					String datoEliminar = JOptionPane.showInputDialog(null,"Ingrese el dato a eliminar");
						arbol.Eliminar(datoEliminar);
					}else{
						JOptionPane.showMessageDialog(null, "No hay datos");
					}
			}
		});
		mntmEliminar.setIcon(new ImageIcon(Main.class.getResource("/Imagenes/File-Delete-icon.png")));
		mnEliminar.add(mntmEliminar);
		
		JMenu mnMostrar = new JMenu("Mostrar");
		mnMostrar.setIcon(new ImageIcon(Main.class.getResource("/Imagenes/Apps-preferences-desktop-printer-icon.png")));
		menuBar.add(mnMostrar);
		
		JMenuItem mntmInOrden = new JMenuItem("InOrden");
		mntmInOrden.setIcon(new ImageIcon(Main.class.getResource("/Imagenes/InOrden.png")));
		mntmInOrden.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//accion de mostrar recorrido InOrden
				if(!arbol.SiVacio()){
					arbol.InOrden(arbol.raiz);
					atxtMostrar.setText( "La altura es: "+arbol.retornarAltura()+ arbol.MostrarRecorridos());
				}else{
					JOptionPane.showMessageDialog(null, "No hay datos");
				}
			}
		});
		mnMostrar.add(mntmInOrden);
		
		JMenuItem mntmPreorden = new JMenuItem("PreOrden");
		mntmPreorden.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//accion de mostrar recorrido PreOrden
				if(!arbol.SiVacio()){
					arbol.PreOrden(arbol.raiz);
					atxtMostrar.setText( "La altura es: "+arbol.retornarAltura()+ arbol.MostrarRecorridos());
				}else{
					JOptionPane.showMessageDialog(null, "No hay datos");
				}
			}
		});
		mntmPreorden.setIcon(new ImageIcon(Main.class.getResource("/Imagenes/PreOrden.png")));
		mnMostrar.add(mntmPreorden);
		
		JMenuItem mntmPostorden = new JMenuItem("PostOrden");
		mntmPostorden.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//accion de mostrar recorrido PostOrden
				if(!arbol.SiVacio()){
					arbol.PostOrden(arbol.raiz);
					atxtMostrar.setText( "La altura es: "+arbol.retornarAltura()+ arbol.MostrarRecorridos());
				}else{
					JOptionPane.showMessageDialog(null, "No hay datos");
				}
			}
		});
		mntmPostorden.setIcon(new ImageIcon(Main.class.getResource("/Imagenes/PostOrden.png")));
		mnMostrar.add(mntmPostorden);
		
		JMenu mnSalir = new JMenu("Salir");
		mnSalir.setIcon(new ImageIcon(Main.class.getResource("/Imagenes/Action-exit-icon (2).png")));
		menuBar.add(mnSalir);
		
		JMenuItem mntmSalir = new JMenuItem("Salir de la Aplicacion");
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
		JOptionPane.showMessageDialog(null, "Gracias por utilizar la aplicacion");
		System.exit(0);
	}
	}//fin del metodo salir
}//fin de la clase main o principal
/*
public class Main2 {

public static void main(String[] args) {
	Arbol arbol = new Arbol();
	int opcion=0;
	String[] opciones = {"Insertar","Mostrar","Buscar","Eliminar","Salir"};
	do{
		opcion=JOptionPane.showOptionDialog(null, "Escoja una opcion", "Menu", 
				JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opciones, opciones[0]);
		switch(opcion){
		case 0://insertar
			String dato = JOptionPane.showInputDialog(null,"Ingrese el nombre de la persona");
			arbol.AgregarNodo(dato);
			break;
		case 1://mostrar
			int escoje=0;
			String[] donde = {"InOrden","PreOrden","PostOrden"};
			escoje=JOptionPane.showOptionDialog(null, "Escoja una opcion", "Mostrar", 
					JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, donde, donde[0]);
			if(escoje==0){
				if(!arbol.SiVacio()){
						arbol.InOrden(arbol.raiz);
						JOptionPane.showMessageDialog(null, arbol.MostrarRecorridos());
						JOptionPane.showMessageDialog(null, "La altura es: "+arbol.retornarAltura());
					}else{
						JOptionPane.showMessageDialog(null, "No hay datos");
					}
			}
			if(escoje==1){
				if(!arbol.SiVacio()){
					arbol.PreOrden(arbol.raiz);
					JOptionPane.showMessageDialog(null, arbol.MostrarRecorridos());
				}else{
					JOptionPane.showMessageDialog(null, "No hay datos");
				}
			}
			if(escoje==2){
				if(!arbol.SiVacio()){
					arbol.PostOrden(arbol.raiz);
					JOptionPane.showMessageDialog(null, arbol.MostrarRecorridos());
					
				}else{
					JOptionPane.showMessageDialog(null, "No hay datos");
				}
			}
			//JOptionPane.showMessageDialog(null, mostrar);
			break;
		case 2://buscar
			if(!arbol.SiVacio()){
				String datobuscar = JOptionPane.showInputDialog(null,"Ingrese el dato a buscar");
				JOptionPane.showMessageDialog(null,arbol.Buscar(datobuscar).toString());
				}else{
					JOptionPane.showMessageDialog(null, "No hay datos");
				}
			break;
		case 3://eliminar
			if(!arbol.SiVacio()){
				String datoEliminar = JOptionPane.showInputDialog(null,"Ingrese el dato a eliminar");
					arbol.Eliminar(datoEliminar);
				}else{
					JOptionPane.showMessageDialog(null, "No hay datos");
				}
			break;
		case 4://salir
			JOptionPane.showMessageDialog(null, "Programa finalizado");
			System.exit(0);
			break;
		}
	}while(true);

}
	private void pruebas(){
		String cadena = "yama";
		String cadena2=cadena.toUpperCase();
		int c = 0,d=0;
		String s = "",ss="";
		//int c = cadena.codePointCount(0, cadena.length());
		for (int x=0;x<cadena2.length();x++){
			s+=cadena2.charAt(x) + " = " + cadena2.codePointAt(x)+", ";
			c = c+cadena2.codePointAt(x);
			
		}
		for (int x=0;x<cadena.length();x++){
			ss+=cadena.charAt(x) + " = " + cadena.codePointAt(x)+", ";
			d = d+cadena.codePointAt(x);
			
		}
		JOptionPane.showMessageDialog(null, ss+"\n"+cadena+": "+d+"\n"+s+"\n"+cadena2+": "+c);	
	}
	}
*/


