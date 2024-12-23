package AlgoritmosBusqueda;

import javax.swing.JOptionPane;


public class Lista {

protected Nodo Primero, Ultimo;
protected int numeroPrimo = 101;
protected int cantidad = 100;
public int contador = 0;
public Lista(){
	Primero = null;
	Ultimo = null;
}//fin del constructor

public boolean SiVacio(){//metodo si esta vacia lista
	return Primero==null;
}//fin del metodo si vacio

public void Insertar(Persona dato){//metodo para insertar al final
	int clave = MitadCuadrado(dato.getCedula());
	Nodo Nuevo = new Nodo(dato,clave);//Crear nuevo nodo
	if(SiVacio()){
		Primero = Nuevo;
		Ultimo = Nuevo;	
	}else{
		if(DireccEncandenamiento(dato, clave)==true){
			JOptionPane.showMessageDialog(null, "Colision!!!");
			
		}else{
			Ultimo.sigiuente = Nuevo;
			Ultimo = Ultimo.sigiuente;	
		}
	}
	contador++;
}//fin del metodo para insertar

public void Insertar2(Persona dato){//metodo para insertar al final
	int clave = FuncionModular(dato.getCedula());
	Nodo nuevo = new Nodo(dato,clave);//Crear nuevo nodo
	if(SiVacio()){
		Primero = nuevo;
		Ultimo = nuevo;	
	}else{
		while(DireccAbierto(nuevo.clave)==true&&nuevo.clave<cantidad){
			JOptionPane.showMessageDialog(null, "Colision!!!");
		nuevo.clave++;	
		}
			Ultimo.sigiuente = nuevo;
			Ultimo = Ultimo.sigiuente;
	}
	contador++;
}//fin del metodo para insertar

private boolean DireccEncandenamiento(Persona dato,int clave){
	Nodo actual = Primero;
	while(actual!=null){
		if(actual.clave==clave){
			actual.colision.Ingresar(dato, clave);
		return true;
		}
		actual=actual.sigiuente;
	}
	return false;
}//

private boolean DireccAbierto(int clave){
	Nodo actual = Primero;
	while(actual!=null){
		if(actual.clave==clave){
		return true;
		}
		actual=actual.sigiuente;
	}
	return false;
}//

public String mostrar(){//metodo para mostrar lista
	Nodo actual = Primero;
	String Mostrar = "";
	while(actual != null){
		Mostrar+=actual.clave+" "+actual.dato.toString()+"\n"+actual.colision.mostrar()+"\n";
		actual = actual.sigiuente;
	}//fin del while
	return Mostrar;
}//fin del metodo mostrar

public boolean Eliminar(int dato){//metodo para eliminar un nodo en especifico
	if(!SiVacio()){
		if(Primero==Ultimo && dato==Primero.dato.getCedula()){
			Primero = null;
			Ultimo = null;
		}else if(dato==Primero.dato.getCedula()){
			Primero = Primero.sigiuente;
		}else{
			Nodo Anterior, Auxiliar;
			Anterior = Primero;
			Auxiliar = Primero.sigiuente;
			while(Auxiliar != null && Auxiliar.dato.getCedula() != dato){
				Anterior = Anterior.sigiuente;
				Auxiliar = Auxiliar.sigiuente;
			}//fin while
			if(Auxiliar != null){
				Anterior.sigiuente = Auxiliar.sigiuente;
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

public Nodo BusquedaSecuencial(int dato){//metodo para buscar un dato
	Nodo actual = Primero;
	while(actual!=null&&actual.dato.getCedula()!=dato){
		actual = actual.sigiuente;
	}
	if(actual==null){
		return null;
	}
	return actual;
	
}//fin del metodo buscar

public Nodo BusquedaHashing(int dato){
	int clave = MitadCuadrado(dato);
	Nodo actual = Primero;
	while(actual!=null&&clave!=actual.clave&&dato!=actual.dato.getCedula()){
		actual = actual.sigiuente;
	}
	return actual;
}

public String Burbuja(){//metodo de ordenamiento de burbuja
	 Nodo actual,siguiente;
	 Persona auxiliar;
	 int totalComparaciones=0;
	 int totalIntercambios=0;
	 int totalPasadas=0;
	 actual = Primero;
	 while(actual.sigiuente!=null){
		 siguiente = actual.sigiuente;
		 totalPasadas++;
		 while(siguiente!=null){
			 totalComparaciones++;
			 if(actual.dato.getCedula()>siguiente.dato.getCedula()){
				 auxiliar = siguiente.dato;
				 siguiente.dato= actual.dato;
				 actual.dato = auxiliar;
				 totalIntercambios++;
			 }//fin del if
			 siguiente=siguiente.sigiuente;
		 }//fin el while interno
		 actual = actual.sigiuente;
		 siguiente = actual.sigiuente;
	 }//fin del while externo
	 JOptionPane.showMessageDialog(null, "Lista Ordenada");
	 return  "*******************************************"+
			 "\n**Total Pasadas = " + totalPasadas +  
			 "\n**Total Comparaciones = " + totalComparaciones+
			 "\n**Total Intercambios = " + totalIntercambios+
			 "\n*******************************************\n" + mostrar();
}//fin del metodo burbuja

private int FuncionModular(int cedula){
	int clave=0;
	clave=(cedula%numeroPrimo);
	return clave;
}//fincion Modular

private int RestaSucesiva(int cedula){
	int clave = 0;
	
	return clave;
}

private int MitadCuadrado(int cedula){
	int clave = 0;
	long resultado = (long) Math.pow(cedula,2);
	String longitudNumero = String.valueOf(resultado);
	int primero = 0, ultimo=longitudNumero.length()-1;
	int mitad = (primero+ultimo)/2;
	int sigueMitad = mitad+2;
	String subNumero = longitudNumero.substring(mitad, sigueMitad);
	clave = Integer.parseInt(subNumero);

	return clave;
}
}
