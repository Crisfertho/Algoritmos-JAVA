package ArbolesBinarios;

import javax.swing.JOptionPane;

public class Main {

public static void main(String[] args) {
	Main app = new Main();
	//app.Ejecutar();
	app.pruebas();
}
public void Ejecutar(){
	Arbol arbol = new Arbol();
	int opcion=0;
	String[] opciones = {"Insertar","Mostrar","Buscar","Eliminar","Salir"};
	do{
		opcion=JOptionPane.showOptionDialog(null, "Escoja una opcion", "Menu", 
				JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opciones, opciones[0]);
		switch(opcion){
		case 0://insertar
			String dato = JOptionPane.showInputDialog(null,"Ingrese el dato");
			arbol.Ingresar(dato);
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
		case 2://buscar//Algoritmos de Ordenamiento Algoritmos de Busqueda Estructuras de Datos
			if(!arbol.SiVacio()){
				String datobuscar = JOptionPane.showInputDialog(null,"Ingrese el dato a buscar");
				JOptionPane.showMessageDialog(null,"El dato es: "+arbol.Buscar(datobuscar).toString());
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
		int c2=cadena.compareToIgnoreCase("zinia");
		JOptionPane.showMessageDialog(null,cadena +" con zinia "+c2);
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
