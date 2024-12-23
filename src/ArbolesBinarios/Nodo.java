package ArbolesBinarios;

public class Nodo {
	String dato;
	long d;
	Nodo izquierda,derecha;
	public Nodo(String dato,long d){
		this.dato = dato;
		this.d=d;
		this.izquierda = null;
		this.derecha = null;
	}//fin del constructor
	
	public String toString(){
		return dato+" = "+d;
	}
}
