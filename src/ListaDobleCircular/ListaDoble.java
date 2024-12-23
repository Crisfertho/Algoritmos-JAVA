package ListaDobleCircular;

import javax.swing.JOptionPane;

public class ListaDoble {

	Nodo primero,ultimo;
	public ListaDoble(){
		primero = null;
		ultimo = null;
	}//fin del contructor
	
	public boolean SiVacia(){
		return primero == null;
	}//fin del si esta vacia la lista
	
	public void Ingresar(Catalogo dato){
		Nodo nuevo = new Nodo(dato);
		if(SiVacia()){
			primero = nuevo;
			primero.siguiente = primero;
			nuevo.anterior = ultimo;
			ultimo = nuevo;
		}else{
			ultimo.siguiente = nuevo;
			nuevo.siguiente = primero;
			nuevo.anterior = ultimo;
			ultimo = nuevo;
			primero.anterior = ultimo;
		}
	}//fin de ingresar
	
	public String MostrarInicioFin(){
		String salida = "";
		Nodo actual = primero;
		do{
			salida += actual.dato.toString();
			actual = actual.siguiente;
		}while(actual != primero);
		return salida;
	}//muestra la lista de inicio a fin
	
	public String MostrarFinInicio(){
		String salida = "";
		Nodo actual = ultimo;
		do{
			salida += actual.dato.toString();
			actual = actual.anterior;
		}while(actual != ultimo);
		return salida;
	}//muestra la lista de fin a inicio
	
	public String Buscar(String dato){
		String salida = "";
		boolean encontrado = false;
		Nodo actual = primero;
		do{
			if(actual.dato.getCodigo().equals(dato)){
				salida = actual.dato.toString();
				encontrado = true;
			}
			actual = actual.siguiente;
		}while(actual != primero&&!encontrado);
		if(encontrado==false){
			JOptionPane.showMessageDialog(null, "No se encontraron los datos,\ncon el codigo: "+dato,"",JOptionPane.ERROR_MESSAGE);
		}
		return salida;
	}//fin del metodo buscar
	
	public void Eliminar(String dato){
		Nodo actual = primero;
		Nodo anterior = ultimo;
		boolean encontrado=false;
		do{
			if(actual.dato.getCodigo().equals(dato)){
				int eliminar = JOptionPane.showConfirmDialog(null,
						"¿Desea Eliminar esta Información? " + actual.dato.toString());
				if(eliminar==JOptionPane.YES_OPTION){
				if(actual==primero&&actual==ultimo){
					primero = null;
					return;
				}else 
				if(actual == primero){
					primero = primero.siguiente;
					ultimo.siguiente = primero;
					primero.anterior = ultimo;
				}else if(actual == ultimo){
					ultimo = anterior;
					primero.anterior = ultimo;
					ultimo.siguiente = primero;
				}else{
					anterior.siguiente = actual.siguiente;
					actual.siguiente.anterior = anterior;
				}
			}
			encontrado = true;	
			}//fin del if que compara
			anterior = actual;
			actual = actual.siguiente;
		}while(actual != primero&&!encontrado);
		if(encontrado==false){
			JOptionPane.showMessageDialog(null, "No se encontraron los datos,\ncon el codigo: "+dato,"",JOptionPane.ERROR_MESSAGE);
		}
	}//fin del metodo eliminar
}//fin de la clase
