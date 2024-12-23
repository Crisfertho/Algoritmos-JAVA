package ListaSimple;

import javax.swing.JOptionPane;

public class Lista {
protected Nodo Primero, Ultimo;
public Lista(){
	Primero = null;
	Ultimo = null;
}//fin del constructor

public void InsertarInicio(int dato){//metodo de insertar al inicio de la lista
	Primero = new Nodo(dato, Primero);
	if(Ultimo == null){
		Ultimo = Primero;
	}//fin del if
}//fin del metodo insertar al inicio de la lista

public boolean SiVacio(){//metodo si esta vacia lista
	if( Primero==null){
		return true;
	}else{
	return false;
	}
}//fin del metodo si vacio

public void InsertarFinal(int dato){//metodo para insertar al final
	Nodo Nuevo = new Nodo(dato);//Crear nuevo nodo
	if(SiVacio()){
		Primero = Nuevo;
		Ultimo = Nuevo;	
	}else{
		Ultimo.Siguiente = Nuevo;
		Ultimo = Ultimo.Siguiente;	
		}
}//fin del metodo para insertar al final

public String mostrar(){//metodo para mostrar lista
	Nodo Actual = Primero;
	String Mostrar = "";
	while(Actual != null){
		Mostrar+=Actual.dato+"  ";
		Actual = Actual.Siguiente;
	}//fin del while
	return Mostrar;
}//fin del metodo mostrar

public int EliminarIncio(){//metodo para eliminar el inicio de la lista
	int dato = Primero.dato;
	if(Primero==Ultimo){
		Primero = null;
		Ultimo = null;
	}else{
		Primero = Primero.Siguiente;
	}//fin del if/else
	return dato;
}//fin del metodo para eliminar el inicio

public int EliminarUltimo(){//metodo para eliminar al final de la lista
	int dato = Ultimo.dato;
	if(Primero==Ultimo){
		Primero = null;
		Ultimo = null;
	}else{
		Nodo Auxiliar = Primero;
		while(Auxiliar.Siguiente != Ultimo){
			Auxiliar = Auxiliar.Siguiente;
		}//fin del while
		Ultimo = Auxiliar;
		Ultimo.Siguiente = null;
	}
	return dato;
}//fin del metodo elimanar al final de la lista

public boolean Eliminar(int dato){//metodo para eliminar un nodo en especifico
	if(!SiVacio()){
		if(Primero==Ultimo && dato==Primero.dato){
			Primero = null;
			Ultimo = null;
		}else if(dato==Primero.dato){
			Primero = Primero.Siguiente;
		}else{
			Nodo Anterior, Auxiliar;
			Anterior = Primero;
			Auxiliar = Primero.Siguiente;
			while(Auxiliar != null && Auxiliar.dato != dato){
				Anterior = Anterior.Siguiente;
				Auxiliar = Auxiliar.Siguiente;
			}//fin while
			if(Auxiliar != null){
				Anterior.Siguiente = Auxiliar.Siguiente;
				if(Auxiliar==Ultimo){
					Ultimo = Anterior;
				}
			}
		}
		return true;
	}else{
		return false;
	}
}//fin del metodo eliminar en especifico

public boolean Buscar(int dato){//metodo para buscar un dato
	Nodo Actual = Primero;
	while(Actual!=null&&Actual.dato!=dato){
		Actual = Actual.Siguiente;
	}
	return Actual!=null;
	
}//fin del metodo buscar

public String Burbuja(){//metodo de ordenamiento de burbuja
	 Nodo actual,siguiente;
	 int auxiliar;
	 int totalComparaciones=0;
	 int totalIntercambios=0;
	 int totalPasadas=0;
	 actual = Primero;
	 while(actual.Siguiente!=null){
		 siguiente = actual.Siguiente;
		 totalPasadas++;
		 while(siguiente!=null){
			 totalComparaciones++;
			 if(actual.dato>siguiente.dato){
				 auxiliar = siguiente.dato;
				 siguiente.dato= actual.dato;
				 actual.dato = auxiliar;
				 totalIntercambios++;
			 }//fin del if
			 siguiente=siguiente.Siguiente;
		 }//fin el while interno
		 actual = actual.Siguiente;
		 siguiente = actual.Siguiente;
	 }//fin del while externo
	 JOptionPane.showMessageDialog(null, "Lista Ordenada");
	 return  "*******************************************"+
			 "\n**Total Pasadas = " + totalPasadas +  
			 "\n**Total Comparaciones = " + totalComparaciones+
			 "\n**Total Intercambios = " + totalIntercambios+
			 "\n*******************************************\n" + mostrar();
}//fin del metodo burbuja

}//fin de la clase
