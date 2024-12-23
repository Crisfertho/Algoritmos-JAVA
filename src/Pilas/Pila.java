package Pilas;

public class Pila {
	
	private Nodo cima;
	int contador;
	public Pila(){
		cima = null;
		contador = 0;
	}//fin del constructor
	
	public boolean SiVacia(){
		return cima == null;
	}//fin de sivacia
	
	public void Push(Catalogo dato){
		Nodo nuevo = new Nodo(dato);
		nuevo.siguiente = cima;
		cima = nuevo;
		contador++;
	}//fin de Push
	
	public String Pop(){
		String salida = "";
		salida = cima.dato.toString();
		cima = cima.siguiente;
		contador++;
		return salida;
	}//fin de pop
	
	public String Cima(){
		String salida = "";
		salida = cima.dato.toString();
		return salida;
	}//cima
	
	public String LimpiarPila(){
		String salida = "";
		while(!SiVacia()){
			salida += Pop();
		} 
		return salida;
	}
}//fin de la clase
