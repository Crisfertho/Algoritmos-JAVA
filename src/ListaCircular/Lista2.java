package ListaCircular;

import javax.swing.JOptionPane;

public class Lista2 {

	Nodo primero,ultimo;

	public Lista2() {
		primero = null;
		ultimo = null;
	}//fin del constructor
	
	public boolean SiVacia(){
		return primero == null;
	}//fin del metodo si la lista esta vacia
	
	public void Insertar(Catalogo dato){//metodo para agregar a la lista
		Nodo nuevo = new Nodo();
		nuevo.dato = dato;
		if(primero == null){
			primero = nuevo;
			ultimo = primero;
			primero.siguiente = ultimo;
		}else{
			ultimo.siguiente = nuevo;
			nuevo.siguiente = primero;
			ultimo = nuevo;
		}//fin del if/else
	}//fin del metodo agregar


	public String Mostrar(){//metodo para mostrar la lista
		String salida="";
		Nodo actual = primero;
		do{
			salida+=actual.dato.toString();
			actual = actual.siguiente;
		}while(actual!=primero);
		return salida;
}//fin de visualizar

	public String Buscar(String dato){
		String salida="";
		Nodo actual = primero;
		do{
			if(actual.dato.getCodigo().equals(dato)){
				salida = actual.dato.toString();
			}
			actual = actual.siguiente;
		}while(actual!=primero);
		return salida;
		
	}//fin de buscar

	public void Eliminar(String dato){//metodo eliminar
		Nodo actual = primero;
		Nodo anterior = ultimo;
		do{
			if(actual.dato.getCodigo().equals(dato)){
				int eliminar = JOptionPane.showConfirmDialog(null,
						"¿Desea Eliminar esta Información? " + actual.dato.toString());
				if(eliminar==JOptionPane.YES_OPTION){//segundo if
				if(actual==primero&&actual==ultimo){
					primero = null;
					return;
				}else
				if(actual == primero){
					primero = primero.siguiente;
					ultimo.siguiente = primero;
				}else if(actual == ultimo){
					anterior.siguiente = ultimo.siguiente;
					ultimo = anterior;
				}else{
					anterior.siguiente = actual.siguiente;
				}
			}
			}//fin del primero if
			anterior = actual;
			
		actual = actual.siguiente;
		}while(actual != primero);
	}//fin del metodo eliminar

}//fin de la clase