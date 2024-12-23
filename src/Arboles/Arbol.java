package Arboles;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Arbol {
	ArrayList<String> lista = new ArrayList<String>();
	Nodo raiz;
	int altura,cont;
	public Arbol(){
		raiz =null;
	}//fin del constructor

//**************************************METODO PARA SABER SI ARBOL BINARIO ESTA VACIO***********************************\\
	public boolean SiVacio(){
		return raiz == null;
	}//fin de si vacia

//**************************************METODO PARA AGREGAR NODOS AL ARBOL BINARIO ***********************************\\
	public void AgregarNodo(Catalogo dato){
		int d = Convertidor(dato.getCodigo());
		Nodo nuevo = new Nodo(dato,d);
		if(raiz==null){
			raiz = nuevo;
		}else{
			Nodo aux = raiz;
			Nodo padre;
			while(true){
				padre = aux;
				if(d<aux.dato){
					aux=aux.izquierda;
					if(aux==null){
						padre.izquierda=nuevo;
						return;
					}//fin del if
				}else if(d>aux.dato){
					aux=aux.derecha;
					if(aux==null){
						padre.derecha=nuevo;
						return;
					}//fin del if
				}else{
					JOptionPane.showMessageDialog(null, "Este dato ya existe: "+d);
					return;
				}
				
			}//fin del while
		}//fin del primero if/else
	}//fin de agregar

//**************************************RECORRIDO DEL ARBOL BINARIO INORDEN***********************************\\
	public void InOrden(Nodo r){	
		String salida = "";
		if(r!=null){
			InOrden(r.izquierda);
			salida=r.datos.toString();
			lista.add(salida);
			InOrden(r.derecha);	
		}//fin del if
	}//fin del InOrden

//**************************************RECORRIDO DEL ARBOL BINARIO POSTORDEN***********************************\\	
	public void PostOrden(Nodo r){
		String salida = "";
		if(r!=null){
			PostOrden(r.izquierda);
			PostOrden(r.derecha);
			salida=r.datos.toString();
			lista.add(salida);
		}//fin del if
	}//fin del PostOrden
	
//**************************************RECORRIDO DEL ARBOL BINARIO PREORDEN***********************************\\
	public void PreOrden(Nodo r){
		String salida = "";
		if(r!=null){
			salida=r.datos.toString();
			lista.add(salida);
			PreOrden(r.izquierda);
			PreOrden(r.derecha);
		}//fin del if
	}//fin del PreOrden

//**************************************MOSTRAR RECORRIDOS DEL ARBOL BINARIO***********************************\\
	public String MostrarRecorridos(){
		String salida="";
		for(int i = 0;i<lista.size();i++){
			salida+=lista.get(i);
		}//fin del for
		lista.clear();
		return salida;
	}//fin de mostrar el recorrido PreOrden
	
//**************************************METODO DE BUSCAR UN NODO EN EL ARBOL***********************************\\
	public Nodo Buscar(String dato){
		String salida = "";
		int d = Convertidor(dato);
		Nodo aux = raiz;
		while(aux.dato!=d){
			if(d<aux.dato){
				aux = aux.izquierda;
			}else{
				aux = aux.derecha;
			}//fin del if/else
			if(aux==null){
				return null;
			}//fin del if
		}//fin del while
		return aux;
		
	}//fin del metodo buscar

//**************************************METODO DE ELIMINAR UN NODO EN EL ARBOL***********************************\\	
	public boolean Eliminar(String dato){
		int d = Convertidor(dato);
		Nodo aux = raiz;
		Nodo padre = raiz;
		boolean esIzquierdo=true;
		while(aux.dato!=d){
			padre=aux;
			if(d<aux.dato){
				esIzquierdo=true;
				aux=aux.izquierda;
			}else{
				esIzquierdo=false;
				aux=aux.derecha;
			}
			if(aux==null){
				return false;
			}
		}//fin while
		int eliminar = JOptionPane.showConfirmDialog(null,
				"¿Desea Eliminar esta Información? " + aux.datos.toString());
		if(eliminar==JOptionPane.YES_OPTION){
		if(aux.izquierda==null&&aux.derecha==null){
			if(aux==raiz){
				raiz=null;
			}else if(esIzquierdo){
				padre.izquierda=null;
			}else{
				padre.derecha=null;
			}
		}else if(aux.derecha==null){
			if(aux==raiz){
				raiz=aux.izquierda;
			}else if(esIzquierdo){
				padre.izquierda=aux.izquierda;
			}else{
				padre.derecha=aux.izquierda;
			}
		}else if(aux.izquierda==null){
			if(aux==raiz){
				raiz=aux.derecha;
			}else if(esIzquierdo){
				padre.izquierda=aux.derecha;
			}else{
				padre.derecha=aux.derecha;
			}
		}else{
			Nodo reemplazo=ObtenerReemplazo(aux);
			if(aux==raiz){
				raiz=reemplazo;
			}else if(esIzquierdo){
				padre.izquierda=reemplazo;
			}else{
				padre.derecha=reemplazo;
			}
			reemplazo.izquierda=aux.izquierda;
		}
	}
		return true;
}//fin del metodo eliminar
	
	public Nodo ObtenerReemplazo(Nodo reempl){
		Nodo ReemplazaPadre=reempl;
		Nodo Reemplazo=reempl;
		Nodo actual=reempl.derecha;
		while(actual!=null){
			ReemplazaPadre=Reemplazo;
			Reemplazo=actual;
			actual=actual.izquierda;
		}
		if(Reemplazo!=reempl.derecha){
			ReemplazaPadre.izquierda=Reemplazo.derecha;
			Reemplazo.derecha=reempl.derecha;
		}
		JOptionPane.showMessageDialog(null, "El reemplado es: "+Reemplazo.datos.getCodigo());
		return Reemplazo;
}
	
	private int Convertidor(String dato){
		int salida=0;
		String entrada = dato.toLowerCase();
		for (int i=0;i<entrada.length();i++){
			salida = salida+entrada.codePointAt(i);
		}
		return salida;
	}
	
	private void retornarAltura (Nodo reco,int nivel)    {
        if (reco != null) {    
            retornarAltura (reco.izquierda,nivel+1);
            if (nivel>altura)
                altura=nivel;
            retornarAltura (reco.derecha,nivel+1);
        }
    }

    public  int retornarAltura () {
        altura=0;
        retornarAltura (raiz,0);
        return altura;
    }
	
}//fin de la clase
