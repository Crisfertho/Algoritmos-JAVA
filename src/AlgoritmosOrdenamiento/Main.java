package AlgoritmosOrdenamiento;

import javax.swing.JOptionPane;

public class Main {
	public static void main(String[] args){

		Lista lista = new Lista();
		int opcion=0;
		String[] opciones = {"Insertar","Mostrar","Buscar","Eliminar","Ordenar","Salir"};
		do{
			opcion=JOptionPane.showOptionDialog(null, "Escoja una opcion", "Menu", 
					JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opciones, opciones[0]);
			switch(opcion){
			case 0://insertar
				lista.Agregar();
				break;
			case 1://mostrar
				String Mostrar = lista.Mostrar();
				JOptionPane.showMessageDialog(null, Mostrar);
				break;
			case 2://buscar
				
				break;
			case 3://eliminar
				
				break;
			case 4:
				String ordenar = "";
				ordenar = lista.QuickSort(lista.lista, 0, lista.lista.size()-1);
				//ordenar = lista.BurbujaMejorado(lista.lista);
				ordenar = lista.RadixSort(lista.lista);
				//ordenar = lista.Shell(lista.lista);
				//lista.RadixVector();
				//lista.ShellVectores(lista.vector);
				//lista.vector = lista.MezclaDirectaVector(lista.vector);
				//lista.lista = lista.MezclaDirecta(lista.lista);
				//JOptionPane.showMessageDialog(null, lista.Mostrar());
				JOptionPane.showMessageDialog(null, ordenar);
				break;
			case 5://salir
				JOptionPane.showMessageDialog(null, "Programa finalizado");
				System.exit(0);
				break;
			}
		}while(true);

	
	}
}
