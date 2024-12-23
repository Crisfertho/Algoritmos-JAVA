package ListaDoble;

import javax.swing.JOptionPane;

public class ListaDoble {
	private NodoDoble Primero,Ultimo;
	public int contador;
	public ListaDoble() {
		Primero = null;
		Ultimo = null;
		contador = 0;
		
	}//fin del constructor
	
	public boolean SiVacia(){
		return Primero==null;
	}//fin del metodo si vacia
	
	public void InsertarFinal(Catalogo dato){
		NodoDoble Nuevo;
		if(!SiVacia()){
			Nuevo = new NodoDoble(dato,null,Ultimo);
			Ultimo = Nuevo;
			Ultimo.anterior.siguiente = Ultimo;
		}else{
			Nuevo = new NodoDoble(dato);
			Primero = Nuevo;
			Ultimo = Nuevo;
		}//fin del if/else
	}//fin del metodo agregar al final
	
	public void InsertarInicio(Catalogo dato){
		NodoDoble Nuevo;
		if(!SiVacia()){
			Nuevo = new NodoDoble(dato,Primero,null);
			Primero = Nuevo;
			Primero.siguiente.anterior = Primero;
		}else{
			Nuevo = new NodoDoble(dato);
			Primero = Nuevo;
			Ultimo = Nuevo;
		}//fin del if/else
	}//fin del metodo agregar al inicio
	
	public void InsertarMedio(Catalogo dato){
		NodoDoble Nuevo,actual;
		actual=Primero;
		if(!SiVacia()){
			
		String dat = JOptionPane.showInputDialog(null,"Ingrese el codigo del producto,\n"
				+"donde desea ingresar el nuevo producto");
			while(actual!=null){
			if(actual.dato.getCodigo().equals(dat)){
				if(actual!=Ultimo){
				Nuevo = new NodoDoble(dato);
				Nuevo.siguiente=actual.siguiente;
				actual.siguiente=Nuevo;
				Nuevo.anterior=actual;
				Nuevo.siguiente.anterior=Nuevo;
				}else{
					Nuevo = new NodoDoble(dato,null,Ultimo);
					Ultimo = Nuevo;
					Ultimo.anterior.siguiente = Ultimo;
					JOptionPane.showMessageDialog(null, "Dato ingresado al final!!");
					
				}
				break;
			}
			actual = actual.siguiente;
			}//fin del while
			
		}else{
			Nuevo = new NodoDoble(dato);
			Primero = Nuevo;
			Ultimo = Nuevo;
		}
	}//fin del metodo 
	public String MostrarInicioFin(){
		String salida = "";
		NodoDoble actual = Primero;
		if(!SiVacia()){
			while(actual != null){
				salida += actual.dato.toString();
				actual = actual.siguiente;
			}//fin del while
		}//fin del if
		else{
			JOptionPane.showMessageDialog(null, "No hay dato!!");
		}
		return salida;
	}//fin del metodo mostrar de inicio a fin
	
	public String MostrarFinInicio(){
		String salida = "";
		NodoDoble actual = Ultimo;
		if(!SiVacia()){
			while(actual != null){
				salida += actual.dato.toString();
				actual = actual.anterior;
			}//fin del while
		}//fin del if
		else{
			JOptionPane.showMessageDialog(null, "No hay dato!!");
		}
		return salida;
	}//fin del metodo mostrar de fin a inicio
	
	public void Eliminar1(String dato){
		NodoDoble actual = Primero;
		NodoDoble ant = null;
		while(actual != null){
			if(actual.dato.getCodigo().equals(dato)){
				if(ant == null){
					int eliminar = JOptionPane.showConfirmDialog(null, "¿Esta seguro que desea eliminar este Producto?"
							+ "\n"+actual.dato.toString());
				    if(eliminar == JOptionPane.YES_OPTION){
					Primero = Primero.siguiente;
					actual.siguiente = null;
					actual = Primero;
					JOptionPane.showMessageDialog(null, "Dato Eliminado");
				    }
					return;
				}else{
					int eliminar = JOptionPane.showConfirmDialog(null, "¿Esta seguro que desea eliminar este Producto?"
							+ "\n"+actual.dato.toString());
				    if(eliminar == JOptionPane.YES_OPTION){
					ant.siguiente = actual.siguiente;
					actual.siguiente = null;
					actual = ant.siguiente;
					JOptionPane.showMessageDialog(null, "Dato Eliminado");
				    }
					return;
				}//fin del if/else interno
			}else{
				ant = actual;
				actual = actual.siguiente;
			}//fin del if/else externo
		}//fin del while
	}//fin del metodo eliminar

	public void Eliminar(String codigo){
		//metodo para eliminar
				NodoDoble actual=Primero;
				NodoDoble ultimo;
				if(SiVacia()){
					JOptionPane.showMessageDialog(null,"¡No hay productos!");
				}//fin del if
				else{
				while(actual != null){
				if(actual.dato.getCodigo().equals(codigo)){
				int eliminar = JOptionPane.showConfirmDialog(null, "¿Esta seguro que desea eliminar este Producto?"
						+actual.dato.toString());
			    if(eliminar == JOptionPane.YES_OPTION){
				Primero = Primero.siguiente;
				JOptionPane.showMessageDialog(null, "Producto eliminado");
				this.contador--;
				return;
			}else{break;}	
				}else
					if(actual.siguiente.dato.getCodigo().equals(codigo)){
						int eliminar = JOptionPane.showConfirmDialog(null, "¿Esta seguro que desea eliminar este Producto?"
								+actual.siguiente.dato.toString());
					    if(eliminar == JOptionPane.YES_OPTION){
					    	actual.siguiente = actual.siguiente.siguiente;
						JOptionPane.showMessageDialog(null, "Producto eliminado");
						this.contador--;
						return;
					}else{break;}
						}
						else{
							actual=actual.siguiente;
						}
				ultimo=Primero;
				while(ultimo!=null){
						ultimo=ultimo.siguiente; 
				}	
			}
				}
			
	}//fin de eliminar
 public boolean delete(String num)
    {
        NodoDoble anterior=null;
        NodoDoble actual=Primero;
        while(actual!=Ultimo)
        {
            if(actual.dato.getCodigo().equals(num))
            {
                if(anterior==null)
                {
                    Primero=actual.siguiente;
                    Primero.anterior=null;
                }
                else{
                    anterior.siguiente=actual.siguiente;
                    NodoDoble temporal;
                    temporal=actual.siguiente;
                    temporal.anterior=anterior;
                }//fin del if/else interno
                return true;
            }//fin del if/else externo
            anterior=actual;
            actual=actual.siguiente;
        }//fin del while
        if(Ultimo.dato.getCodigo().equals(num))
        {
            Ultimo=actual.anterior;
            return true;
        }
        return false;
    }//fin del metodo
 
 public String Buscar(String dato){
	 String salida="";
	 NodoDoble actual = Primero;
	 if(!SiVacia()){
	 while(actual != null){
		 if(actual.dato.getCodigo().equals(dato)){
			 salida = actual.dato.toString();
			 break;
		 }
		 actual = actual.siguiente;
	 }//fin del while
	 }else{
		 JOptionPane.showMessageDialog(null, "No hay dato!!");
	 }//fin del if/else exerno
	 return salida;
 }//fin del metodo buscar
 
 public void EliminarNodo(String dato){//metodo para eliminar nodos
	 NodoDoble actual = Primero;
	 NodoDoble atras = null;
	 while(actual!=null){
		 if(actual.dato.getCodigo().equals(dato)){
			 if(actual==Ultimo){
				 int eliminar = JOptionPane.showConfirmDialog(null, "¿Esta seguro que desea eliminar este Producto?"
							+actual.dato.toString());
				    if(eliminar == JOptionPane.YES_OPTION){
				 Ultimo = Ultimo.anterior;
				 Ultimo.siguiente = null;
				 JOptionPane.showMessageDialog(null, "Producto eliminado");
				    }
				 contador--;
				    return;
			 }
			 if(actual == Primero){
				 int eliminar = JOptionPane.showConfirmDialog(null, "¿Esta seguro que desea eliminar este Producto?"
							+actual.dato.toString());
				    if(eliminar == JOptionPane.YES_OPTION){
				 Primero = Primero.siguiente;
				 Primero.anterior = null;
				 JOptionPane.showMessageDialog(null, "Producto eliminado");
				    }
				    contador--;
				    return;
			 }else{
				 int eliminar = JOptionPane.showConfirmDialog(null, "¿Esta seguro que desea eliminar este Producto?"
							+actual.dato.toString());
				    if(eliminar == JOptionPane.YES_OPTION){
				 atras.siguiente = actual.siguiente;
				 actual.siguiente.anterior = actual.anterior;
				 JOptionPane.showMessageDialog(null, "Producto eliminado");
				    }
				    contador--;
				    return;
			 }//fin del if/else
		 }//if
		 atras = actual;
		 actual = actual.siguiente;
	 }//fin del while
 }//fin del metodo eliminar
}//fin de la clase
