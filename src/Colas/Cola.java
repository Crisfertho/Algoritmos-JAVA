package Colas;

import javax.swing.JOptionPane;

public class Cola {
Nodo Primero,Ultimo;
int contador;
public Cola(){
	this.Primero = null;
	this.Ultimo = null;
	this.contador = 0;
}//fin del constructor

public boolean SiVacia(){
	return Primero == null;
}//fin del metodo si esta vacia la cola

public void Insertar(Catalogo dato){
	Nodo Nuevo = new Nodo(dato);
	if(SiVacia()){
		Primero = Nuevo;
	}else{
		Ultimo.Siguiente = Nuevo;
	}
	Ultimo = Nuevo;
	contador++;
}//fin del metodo insertar

public String Quitar(){
	String Salida = "";
	if(!SiVacia()){
	Salida = Primero.dato.toString();
	Primero = Primero.Siguiente;
	contador--;
	}else{
		JOptionPane.showMessageDialog(null, "No hay datos!!!");
	}
	return Salida;
}//quita los nodos de la cola

public String Primero(){
	String Salida = "";
	if(!SiVacia()){
	Salida = Primero.dato.toString();
	}else{
		JOptionPane.showMessageDialog(null, "No hay datos!!!");
	}
	return Salida;
}//muestra el primero nodo de la lista
public String Ultimo(){
	String Salida = "";
	if(!SiVacia()){
	Salida = Ultimo.dato.toString();
	}else{
		JOptionPane.showMessageDialog(null, "No hay datos!!!");
	}
	return Salida;
}
public String MandarUltimo(){
	String Salida = "";
	Nodo Aux = Primero;
	if(!SiVacia()){
	Salida = Primero.dato.toString();
	Primero = Primero.Siguiente;
	contador--;
	InsertarPrimero(Aux);
	}else{
		JOptionPane.showMessageDialog(null, "No hay datos!!!");
	}
	return Salida;
}///metodo que manda el primero nodo de ultimo

public void InsertarPrimero(Nodo primero){
	Nodo Nuevo = primero;
	Ultimo.Siguiente = Nuevo;
	Ultimo = Nuevo;
	contador++;
}//fin del metodo que inserta el primero nodo que se quito
}//fin de la clase
