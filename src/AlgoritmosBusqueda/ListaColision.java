package AlgoritmosBusqueda;

public class ListaColision {
	NodoColision primero,ultimo;
	public ListaColision(){
		primero=null;
		ultimo=null;
	}
	
	public boolean SiVacia(){
		return primero==null;
	}
	
	public void Ingresar(Persona dato,int clave){
		NodoColision nuevo = new NodoColision(dato,clave);
		if(SiVacia()){
			primero=nuevo;
			ultimo=nuevo;
		}else{
			ultimo.sigiuente = nuevo;
			ultimo = ultimo.sigiuente;
		}
	}//fin del metodo agregar colision
	
	public String mostrar(){//metodo para mostrar lista
		NodoColision actual = primero;
		String Mostrar = "";
		while(actual != null){
			Mostrar+=actual.clave+" "+actual.dato.toString();
			actual = actual.sigiuente;
		}//fin del while
		return Mostrar;
	}//fin del metodo mostrar
	
	public NodoColision Busqueda(int dato){
		NodoColision actual = primero;
		while(actual!=null&&dato!=actual.dato.getCedula()){
			actual = actual.sigiuente;
		}
		return actual;
	}//fin del la busqueda
}//fin del la clase
