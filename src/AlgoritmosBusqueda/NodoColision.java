package AlgoritmosBusqueda;

public class NodoColision {
	int clave;
	Persona dato;
	NodoColision sigiuente;
	public NodoColision(Persona dato,int clave){
		this.clave=clave;
		this.dato=dato;
		this.sigiuente=null;
	}//fin de constructor

}
