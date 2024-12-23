package ListaCircular;

import javax.swing.JOptionPane;

public class Lista {
private Nodo ultimo,primero;

public Lista(){
	ultimo = null;
	primero = null;
}//fin del constructor

public boolean SiVacia(){
	return ultimo == null;
}//fin de si la lista esta vacia

public Lista Insertar(Catalogo dato){
	Nodo Nuevo = new Nodo(dato);
	if(!SiVacia()){
		Nuevo.siguiente = ultimo.siguiente;
		ultimo.siguiente = Nuevo;
	}
	ultimo = Nuevo;
	return this;
}//fin de ingresar

public String Mostrar(){
	String Salida = "";
	Nodo auxiliar = ultimo.siguiente;
	do{
		Salida+=auxiliar.dato.toString();
		auxiliar = auxiliar.siguiente;
	}while(auxiliar!=ultimo.siguiente);
	return Salida;
}//fin de mostrar

public void Eliminar(String dato){//Metodo de eliminar
	Nodo actual;
	boolean encontrado = false;
	actual = ultimo;
	while(actual.siguiente!=ultimo&&!encontrado){
		encontrado = (actual.siguiente.dato.getCodigo().equals(dato));
		if(!encontrado){
			actual=actual.siguiente;
		}
	}//fin del while
	encontrado = (actual.siguiente.dato.getCodigo().equals(dato));
	if(encontrado){//primero if
		Nodo aux = actual.siguiente;
		int eliminar = JOptionPane.showConfirmDialog(null,
				"¿Desea Eliminar esta Información? " + aux.dato.toString());
		if(eliminar==JOptionPane.YES_OPTION){//segundo if
		if(ultimo==ultimo.siguiente){//tercer if
			ultimo=null;
		}else{
			if(aux==ultimo){
				ultimo = actual;
			}//fin del if
			actual.siguiente = aux.siguiente;
			
		}//fin del tercer if/else 
		aux = null;
		JOptionPane.showMessageDialog(null, "Datos Eliminados!!!");
	}//fin del if segundo
	}//fin del if primero
	else{
		JOptionPane.showMessageDialog(null, "No se encontraron los datos,\ncon el codigo: "+dato);
	}
	return;
}//fin de eliminar
public String Buscar2(String dato){//Metodo de buscar
	String salida = "";
	Nodo actual = ultimo.siguiente;
	do{
		if(actual.dato.getCodigo().equals(dato)){
			salida=actual.dato.toString();
		}
		actual=actual.siguiente;
	}while(actual!=ultimo.siguiente);
	return salida;
}//fin de buscar

public String Buscar(String dato){
	String salida = "";
	Nodo actual;
	boolean encontrado = false;
	actual = ultimo;
	while(actual.siguiente!=ultimo&&!encontrado){
		encontrado = (actual.siguiente.dato.getCodigo().equals(dato));
		if(!encontrado){
			actual=actual.siguiente;
		}
	}//fin del while
	encontrado = (actual.siguiente.dato.getCodigo().equals(dato));
	if(encontrado){//primero if
		Nodo aux = actual.siguiente;
		salida = aux.dato.toString();
	}//fin del if primero
	else{
		JOptionPane.showMessageDialog(null, "No se encontraron los datos,\ncon el codigo: "+dato);
	}
	return salida;
}


}//fin de la clase
