package ListaSimple;

import javax.swing.JOptionPane;

public class Main {
	
	public static void main(String[] args) {
		Lista lista = new Lista();
		int opcion=0;
		String[] opciones = {"Insertar","Mostrar","Buscar","Eliminar","Ordenar","Salir"};
		do{
			opcion=JOptionPane.showOptionDialog(null, "Escoja una opcion", "Menu", 
					JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opciones, opciones[0]);
			switch(opcion){
			case 0://insertar
				int insertar=0;
				String[] donde = {"Al inicio","Al final"};
				insertar=JOptionPane.showOptionDialog(null, "Escoja una opcion", "Insercion", 
						JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, donde, donde[0]);
				int dato = Integer.parseInt(JOptionPane.showInputDialog(null,"Ingresar dato"));
				if(insertar==0){
					lista.InsertarInicio(dato);
				}//fin del if
				if(insertar==1){
					lista.InsertarFinal(dato);
				}//fin del if
				break;
			case 1://mostrar
				String Mostrar = lista.mostrar();
				JOptionPane.showMessageDialog(null, Mostrar);
				break;
			case 2://buscar
				int DatoBuscar;
				DatoBuscar = Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese el dato a buscar"));
				if(lista.Buscar(DatoBuscar)){
					JOptionPane.showMessageDialog(null, DatoBuscar);
				}else{
					JOptionPane.showMessageDialog(null, DatoBuscar + "no esta en la lista");
				}
				
				break;
			case 3://eliminar
				int eliminar=0;
				String[] Donde = {"Al inicio","Al final","Eliminar Especifico"};
				eliminar = JOptionPane.showOptionDialog(null, "Escoja una opcion", "Insercion", 
						JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, Donde, Donde[0]);
				int DatoEliminado = 0;
				if(eliminar==0){
					DatoEliminado=lista.EliminarIncio();
					JOptionPane.showMessageDialog(null, DatoEliminado);
				}
				if(eliminar == 1){
					DatoEliminado=lista.EliminarUltimo();
					JOptionPane.showMessageDialog(null, DatoEliminado);
				}
				if(eliminar == 2){
					DatoEliminado=Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese el dato a eliminar"));
					lista.Eliminar(DatoEliminado);
					if(lista.Eliminar(DatoEliminado)==true){
						JOptionPane.showMessageDialog(null, DatoEliminado);
					}
					else{
						JOptionPane.showMessageDialog(null, "No se elimino ningun dato");
					}
				}
				break;
			case 4:
				String ordenar = lista.Burbuja();
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
