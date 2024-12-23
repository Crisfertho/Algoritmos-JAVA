package ArbolesBinarios;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Arbol {
	public Nodo raiz;
	ArrayList<String> lista = new ArrayList<String>();
	public Arbol(){
		this.raiz = null;
	}//fin del constructor
	
	public boolean SiVacio(){
		return raiz == null;
	}//fin del metodo sivacio
	
	public void Ingresar(String dato){
		long d = Convertidor(dato);
		Nodo nuevo = new Nodo(dato,d);
		if(SiVacio()){
			raiz = nuevo;
		}else{
			Nodo aux = raiz;
			Nodo padre = null;
			while(true){
				padre = aux;
				if(d<aux.d){//si el dato es menor a la raiz
					aux = aux.izquierda;
					if(aux == null){
						padre.izquierda = nuevo;
						return;
					}
				}else if(d>aux.d){//si el dato es mayor a la raiz
					aux = aux.derecha;
					if(aux == null){
						padre.derecha = nuevo;
						return;
					}
				}else{
					JOptionPane.showMessageDialog(null, "Este dato ya existe: "+d);
					return;
				}
			}//fin del while
		}
	}//fin del metodo ingresar
	
	public void InOrden(Nodo raiz){
		if(raiz != null){
			InOrden(raiz.izquierda);
			lista.add(raiz.toString());
			InOrden(raiz.derecha);
		}
	}//fin de inOrden
	
	public void PreOrden(Nodo raiz){
		if(raiz != null){
			lista.add(raiz.toString());
			PreOrden(raiz.izquierda);
			PreOrden(raiz.derecha);
		}
	}//fin de preOrden
	
	public void PostOrden(Nodo raiz){
		if(raiz != null){
			PostOrden(raiz.izquierda);
			PostOrden(raiz.derecha);
			lista.add(raiz.toString());
		}
	}//fin de postOrden
	
	public String MostrarRecorridos(){
		String salida = "";
		for(int i = 0; i < lista.size();i++){
			salida+=lista.get(i);
		}//fin del for
		lista.clear();
		return salida;
	}//fin de mostrar recorrido
	
	public Nodo Buscar(String dato){
		long d = Convertidor(dato); 
		Nodo aux = raiz;
		while(aux.d != d){
			if(d<aux.d){
				aux = aux.izquierda;
			}else{
				aux = aux.derecha;
			}
			if(aux == null){
				return null;
			}
		}//fi del while
		return aux;
	}//fin del metodo buscar
	
	public boolean Eliminar(String dato){
		long d = Convertidor(dato);
		Nodo aux = raiz;
		Nodo padre = raiz;
		boolean esIzquierdo = true;
		while(aux.d != d){
			padre = aux;
			if(d<aux.d){
				esIzquierdo = true;
				aux = aux.izquierda;
			}else{
				esIzquierdo = false;
				aux = aux.derecha;
			}//fin del if/else
			if(aux == null){
				return false;
			}//fin del if
		}//fin del while
		if(aux.izquierda == null && aux.derecha == null){
			if(aux==raiz){
				raiz = null;
			}else if(esIzquierdo){
				padre.izquierda = null;
			}else{
				padre.derecha = null;
			}
		}else if(aux.derecha == null){
			if(aux==raiz){
				raiz = aux.izquierda;
			}else if(esIzquierdo){
				padre.izquierda = aux.izquierda;
			}else{
				padre.derecha = aux.izquierda;
			}
		}else if(aux.izquierda == null){
			if(aux==raiz){
				raiz = aux.derecha;
			}else if(esIzquierdo){
				padre.izquierda = aux.derecha;
			}else{
				padre.derecha = aux.derecha;//////ojo
			}
		}else{
			Nodo reemplazo = ObtenerReemplazo(aux);
			if(aux==raiz){
				raiz = reemplazo;
			}else if(esIzquierdo){
				padre.izquierda = reemplazo;
			}else{
				padre.derecha = reemplazo;
			}
			reemplazo.izquierda = aux.izquierda;
		}
		return true;
	}//fin de eliminar

	private Nodo ObtenerReemplazo(Nodo nodoReemp) {
		Nodo reemplazarPadre = nodoReemp;
		Nodo reemplazo = nodoReemp;
		Nodo aux = nodoReemp.derecha;
		while(aux != null){
			reemplazarPadre = reemplazo;
			reemplazo = aux;
			aux = aux.izquierda;
		}
		if(reemplazo != nodoReemp.derecha){
			reemplazarPadre.izquierda=reemplazo.derecha;
			reemplazo.derecha = nodoReemp.derecha;
		}
		JOptionPane.showMessageDialog(null, "Reemplazo = "+ reemplazo.dato);
		return reemplazo;
	}
	
	private long Convertidor(String dato){
		long salida=0;
		String entrada = dato.toLowerCase();
		for (int i=0;i<entrada.length();i++){
			//s+="\n"+dato.charAt(x) + " = " + dato.codePointAt(x);
			salida = salida+entrada.codePointAt(i);
		}
		return salida;
	}
	
}//fin de la clase
