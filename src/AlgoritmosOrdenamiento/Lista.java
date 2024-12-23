package AlgoritmosOrdenamiento;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Lista {

	public ArrayList<Persona> lista = new ArrayList<Persona>();
	int tam = 0;
	public Persona [] vector;
	public Lista(){
		
	}//fin del constructor
	
	public void Agregar(){
		String nombre = JOptionPane.showInputDialog(null,"Ingrese su nombre");
		int cedula = Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese su numero de cedula"));
		String direccion = JOptionPane.showInputDialog(null,"Ingrese el lugar donde vive:");
		Persona persona = new Persona(nombre, direccion, cedula);
		lista.add(persona);
		//Insercion(lista,lista.size());
	}//fin de agregar la lista
	
	public void AgregarVector(){
		tam = Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese la cantidad de datos del vector"));
		vector = new Persona[tam];
		for(int i=0;i<tam;i++){
			String nombre = JOptionPane.showInputDialog(null,"Ingrese su nombre");
			int cedula = Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese su numero de cedula"));
			String direccion = JOptionPane.showInputDialog(null,"Ingrese el lugar donde vive:");
			Persona persona = new Persona(nombre, direccion, cedula);
			vector[i] = persona;
		}
	}
	public String MostrarVector(){
		String salida = "";
		for(int i =0; i<vector.length;i++){
			salida+=vector[i];
		}
		return salida;
	}
	public String Mostrar(){
		String salida = "";
		for(int i=0;i<lista.size();i++){
			salida+=lista.get(i).toString();
		}
		return salida;
	}
	
public String BurbujaMejorado ( ArrayList<Persona> array ){
		Persona aux;
		boolean HayCambios = false;
		int TotaldePasadas = 0,intercambios = 0;
				while (true) {
						TotaldePasadas++;
						HayCambios = false;
						for (int i=1; i<array.size(); i++ ){
								if ( array.get(i).getCedula() < array.get(i-1).getCedula()){
									
										aux = array.get(i);
										array.set(i,array.get(i-1));
										array.set(i-1,aux);
										HayCambios = true;
										intercambios++;
								}
								
						} // fin del for
						
						if (HayCambios == false) {
							break;
						}
				
				}  // fin del while
				String salida = "";
				for(int i=0;i<array.size();i++){
					salida+=array.get(i).toString();
				}
				return "Total de intercambios: "+intercambios+
						"\nTotal de Pasadas: "+TotaldePasadas+
						"\n"+salida;
	}  // fin de BurbujaMejorado

public String QuickSort(ArrayList<Persona> arreglo,int primero,int ultimo){
	int i,j,pivote;
	Persona aux;
	int TotaldePasadas = 0,intercambios = 0;
	i=primero;
	j=ultimo;
	pivote=arreglo.get((primero+ultimo)/2).getCedula();
	do{
		while(arreglo.get(i).getCedula()<pivote){
			i++;
		}
		while(arreglo.get(j).getCedula()>pivote){
			j--;
		}
		if(i<=j){
			aux = arreglo.get(i);
			arreglo.set(i, arreglo.get(j));
			arreglo.set(j, aux);
			i++;
			j--;
			intercambios++;
		}
		TotaldePasadas++;
	}while(i<=j);
	if(primero<j){
		QuickSort(arreglo,primero,j);
	}
	if(i<ultimo){
		QuickSort(arreglo,i,ultimo);
	}
	String salida = "";
	for(int in=0;in<arreglo.size();in++){
		salida+=arreglo.get(in).toString();
	}
	return "Total de intercambios: "+intercambios+
			"\nTotal de Pasadas: "+TotaldePasadas+
			"\n"+salida;
}//fin de quicksort

@SuppressWarnings("unchecked")
public String RadixSort(ArrayList<Persona> Lista){
	int x,i,j;
	for(x=Integer.SIZE-1;x>=0;x--){
		ArrayList<Persona> aux = new ArrayList<Persona>();
		aux = (ArrayList<Persona>) Lista.clone();
		j=0;
		for(i=0;i<Lista.size();i++){
			boolean mover = Lista.get(i).getCedula()<<x>=0;
			if(x==0 ? !mover:mover){
				aux.set(j, Lista.get(i));
				j++;
			}else{
				Lista.set(i-j, Lista.get(i));
			}
		}
		for(i=j;i<aux.size();i++){
			aux.set(i, Lista.get(i-j));
		}
		Lista=aux;
	}
	String salida = "";
	for(int in = 0;in<Lista.size();in++){
	salida+=Lista.get(in).toString();	
	}
	return salida;
	
}///metodo de ordenamiento radix

public void Burbuja1(){
	Persona aux;
	JOptionPane.showMessageDialog(null, vector.length);
	for(int i = 0;i<vector.length;i++){
		for(int j = i+1;j<vector.length;j++){
			if(vector[i].getCedula()>vector[j].getCedula()){
				aux=vector[i];
				vector[i]=vector[j];
				vector[j]=aux;
			}
		}
	}
	MostrarVector();
}//fin del metodo burbuja 1

public void Buebuja2(int[] arreglo){
	int aux;
	for(int i = 1;i<arreglo.length;i++){
		for(int j = 0;j<arreglo.length-1;j++){
			if(arreglo[j]>arreglo[j+1]){
				aux=arreglo[j];
				arreglo[j]=arreglo[j+1];
				arreglo[j+1]=aux;
			}
		}
	}
}

public String RadixSortVector(int [] arreglo){
	int x,i,j;
	for(x=Integer.SIZE-1;x>=0;x--){
		int aux[]= new int[arreglo.length];
		j=0;
		for(i=0;i<arreglo.length;i++){
			boolean mover = arreglo[i]<<x>=0;
			if(x==0 ? !mover:mover){
				aux[j]=arreglo[i];
				j++;
			}else{
				arreglo[i-j]=arreglo[1];
			}
		}
		for(i=j;i<aux.length;i++){
			aux[1]=arreglo[i-j];
		}
		arreglo=aux;
	}
	return Mostrar();	
}

public String RadixVector(){
	int x,i,j;
	JOptionPane.showMessageDialog(null, vector.length);
	for(x=Integer.SIZE-1;x>=0;x--){
		Persona aux[]= new Persona[vector.length];
		j=0;
		for(i=0;i<vector.length;i++){
			boolean mover = vector[i].cedula<< x >=0;
			if(x==0 ? !mover:mover){
				aux[j]=vector[i];
				j++;
			}else{
				vector[i-j]=vector[1];
			}
		}
		for(i=j;i<aux.length;i++){
			aux[1]=vector[i-j];
		}
		vector=aux;
	}
	return MostrarVector();	
}


public void Insercion(ArrayList<Persona> arreglo,int n){
	int i,j;
	Persona aux;
	for(i=1;i<n;i++){
		aux=arreglo.get(i);
		j=i-1;
		while(j>=0&&arreglo.get(j).getCedula()>aux.getCedula()){
			arreglo.set(j+1, arreglo.get(j));
			j--;
		}
		arreglo.set(j+1, aux);
	}
	String salida="";
	for(i=0;i<arreglo.size();i++){
		salida+= arreglo.get(i).toString();
	}
	JOptionPane.showMessageDialog(null, salida);
}

public void InsercionVectores(int [] arreglo,int n){
	int i,j,aux;
	for(i=1;i<n;i++){
		aux=arreglo[i];
		j=i-1;
		while(j>=0&&arreglo[j]>aux){
			arreglo[j+1]=arreglo[j];
			j--;
		}
		arreglo[j+1]=aux;
	}
	String salida="";
	for(i=0;i<arreglo.length;i++){
		salida+= "["+arreglo[i]+"]";
	}
	JOptionPane.showMessageDialog(null, salida);
}
public void insertar(){
	int tam=0;
	tam = Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese la cantidad de datos:"));
	int[] vector = new int[tam];
	for(int i = 0;i<tam;i++){
		vector[i]=Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese el dato en la posicion "+i));
	InsercionVectores(vector, i+1);
	}
}


public String Shell(ArrayList<Persona> arreglo){
	int salto,i,j,k;
	Persona aux;
	salto=arreglo.size()/2;
	while(salto>0){
		for(i=salto;i<arreglo.size();i++){
			j=i-salto;
			while(j>=0){
				k=j+salto;
				if(arreglo.get(j).getCedula()<=arreglo.get(k).getCedula()){
					j=-1;
				}else{
					aux=arreglo.get(j);
					arreglo.set(j, arreglo.get(k));//[j]=arreglo[k];
					arreglo.set(k, aux);//[k]=aux;
					j=j-salto;//j-=salto;
				}
			}
		}
		salto=salto/2;
	}
	String salida = "";
	for(i = 0;i<arreglo.size();i++){
	salida+=arreglo.get(i).toString();	
	}
	return salida;
}//fin del metodo ordenamiento shell

public void ShellVectores(Persona[] arreglo){
	int salto,i,j,k;
		Persona aux;
		JOptionPane.showMessageDialog(null, arreglo.length);	
	salto=arreglo.length/2;
	while(salto>0){
		for(i=salto;i<arreglo.length;i++){
			j=i-salto;
			while(j>=0){
				k=j+salto;
				if(arreglo[j].getCedula()<=arreglo[k].getCedula()){
					j=-1;
				}else{
					aux=arreglo[j];
					arreglo[j]=arreglo[k];
					arreglo[k]=aux;
					j=j-salto;//j-=salto;
				}
			}
		}
		salto=salto/2;
	}
}//fin del metodo ordenamiento shell

public int[] MezclaDirecta(int[] arreglo){
	int i,j,k;
	if(arreglo.length>1){
		int nIzq=arreglo.length/2;
		int nDer=arreglo.length-nIzq;
		int[] arregloIzq = new int[nIzq];
		int[] arregloDer = new int[nDer];
		//copia de los elementos izquierdos
		for(i=0;i<nIzq;i++){
			arregloIzq[i]=arreglo[i];
		}
		//copia de los elementos izquierdos
		for(i=nIzq;i<nIzq+nDer;i++){
			arregloDer[i-nIzq]=arreglo[i];
		}
		//recursividad
		arregloIzq=MezclaDirecta(arregloIzq);
		arregloDer=MezclaDirecta(arregloDer);
		i=0;j=0;k=0;
		while(arregloIzq.length != j && arregloDer.length != k){
			if(arregloIzq[j]<arregloDer[k]){
				arreglo[i]=arregloIzq[j];
				i++;
				j++;
			}else{
				arreglo[i]=arregloDer[k];
				i++;
				k++;
			}
		}
		while(arregloIzq.length!=j){
			arreglo[i]=arregloIzq[j];
			i++;
			j++;
		}
		while(arregloDer.length!=k){
			arreglo[i]=arregloDer[k];
			i++;
			k++;
		}
	}//fin del if
	return arreglo;
	
}///fin del metodo mezcla directa 

public Persona[] MezclaDirectaVector(Persona[] arreglo){
	int i,j,k;
	if(arreglo.length>1){
		int nIzq=arreglo.length/2;
		int nDer=arreglo.length-nIzq;
		Persona[] arregloIzq = new Persona[nIzq];
		Persona[] arregloDer = new Persona[nDer];
		//copia de los elementos izquierdos
		for(i=0;i<nIzq;i++){
			arregloIzq[i]=arreglo[i];
		}
		//copia de los elementos izquierdos
		for(i=nIzq;i<nIzq+nDer;i++){
			arregloDer[i-nIzq]=arreglo[i];
		}
		//recursividad
		arregloIzq=MezclaDirectaVector(arregloIzq);
		arregloDer=MezclaDirectaVector(arregloDer);
		i=0;j=0;k=0;
		while(arregloIzq.length != j && arregloDer.length != k){
			if(arregloIzq[j].getCedula()<arregloDer[k].getCedula()){
				arreglo[i]=arregloIzq[j];
				i++;
				j++;
			}else{
				arreglo[i]=arregloDer[k];
				i++;
				k++;
			}
		}
		while(arregloIzq.length!=j){
			arreglo[i]=arregloIzq[j];
			i++;
			j++;
		}
		while(arregloDer.length!=k){
			arreglo[i]=arregloDer[k];
			i++;
			k++;
		}
	}//fin del if
	return arreglo;
	
}//fin del metodo mezcla directa con vectores

@SuppressWarnings("unchecked")
public ArrayList<Persona> MezclaDirecta(ArrayList<Persona> arreglo){
	int i,j,k;
	if(arreglo.size()>1){
		int nIzq=arreglo.size()/2;
		int nDer=arreglo.size()-nIzq;
		ArrayList<Persona> arregloIzq = new ArrayList<Persona>();
		ArrayList<Persona> arregloDer = new ArrayList<Persona>();
		
		//copia de los elementos izquierdos
		for(i=0;i<nIzq;i++){
			arregloIzq.set(i, arreglo.get(i));
		}
		//copia de los elementos izquierdos
		for(i=nIzq;i<nIzq+nDer;i++){
			arregloDer.set(i-nIzq, arreglo.get(i));
		}
		//recursividad
		arregloIzq=MezclaDirecta(arregloIzq);
		arregloDer=MezclaDirecta(arregloDer);
		i=0;j=0;k=0;
		while(arregloIzq.size() != j && arregloDer.size() != k){
			if(arregloIzq.get(j).getCedula()<arreglo.get(k).getCedula()){
				arreglo.set(i, arregloIzq.get(j));
				i++;
				j++;
			}else{
				arreglo.set(i, arregloDer.get(k));
				i++;
				k++;
			}
		}
		while(arregloIzq.size()!=j){
			//arreglo[i]=arregloIzq[j];
			arreglo.set(i, arregloIzq.get(j));
			i++;
			j++;
		}
		while(arregloDer.size()!= k){
			arreglo.set(i, arregloDer.get(k));
			i++;
			k++;
		}
	}//fin del if
	return arreglo;
	
}//fin del metodo mezcla directa con vectores


public void Intercalacion(int[] arregloA,int[] arregloB){
	int i,j,k;
	int[] arregloC = new int[arregloA.length+arregloB.length];
	for(i=j=k=0;i<arregloA.length&&j<arregloB.length;k++){
		if(arregloA[i]<arregloB[j]){
			arregloC[k]=arregloC[i];
			i++;
		}else{
			arregloC[k]=arregloB[j];
			j++;
		}
	}
	for(;i<arregloA.length;i++,k++){
		arregloC[k]=arregloA[i];
	}
	for(;j<arregloB.length;j++,k++){
		arregloC[k]=arregloB[j];
	}
	//mostrar arreglo
}

public void Quick(int[] arreglo,int primero,int ultimo){
	int i,j,pivote,aux;
	i=primero;
	j=ultimo;
	pivote=arreglo[(primero+ultimo)/2];
	do{
		while(arreglo[i]<pivote){
			i++;
		}
		while(arreglo[j]>pivote){
			j--;
		}
		if(i<=j){
			aux=arreglo[i];
			arreglo[i]=arreglo[j];
			arreglo[j]=aux;
			i++;
			j--;
		}
	}while(i<=j);
	if(primero<j){
		Quick(arreglo,primero,j);
	}
	if(i<ultimo){
		Quick(arreglo,i,ultimo);
	}
}//fin del quick

}//fin de la clase
