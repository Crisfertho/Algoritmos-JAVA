package AlgoritmosBusqueda;

public class Nodo {
	Persona dato;
	int clave;
	Nodo sigiuente;
	ListaColision colision;
	public Nodo(Persona dato,int clave){
		this.dato=dato;
		this.sigiuente=null;
		this.clave=clave;
		colision = new ListaColision();
	}//fin de constructor
}//fin de la clase
