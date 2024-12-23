package AlgoritmosBusqueda;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;


public class Main {
	Lista lista = new Lista();
	public Main(){
	}
	public static void main(String[] args){
		Main app = new Main();
		app.ejecutar();
	}
		public void ejecutar(){
		int opcion=0,cedula=0;
		String nombre="",direccion="";
		
		String[] opciones = {"Insertar","Mostrar","Buscar","Eliminar","Ordenar","Salir"};
		do{
			opcion=JOptionPane.showOptionDialog(null, "Escoja una opcion", "Menu", 
					JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opciones, opciones[0]);
			switch(opcion){
			case 0://insertar
				nombre = JOptionPane.showInputDialog(null,"Ingrese su nombre");
				cedula = Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese su numero de cedula"));
				direccion = JOptionPane.showInputDialog(null,"Ingrese el lugar donde vive:");
				Persona persona = new Persona(nombre, direccion, cedula);
				lista.Insertar2(persona);
				break;
			case 1://mostrar
				String Mostrar = lista.mostrar();
				JOptionPane.showMessageDialog(null, Mostrar);
				break;
			case 2://buscar
				String[] opcionesbuscar={"Secuancia","Hashing","Binaria"};
				int menu=0;
				menu=JOptionPane.showOptionDialog(null, "Opciones de busqueda", "Menu", 
				JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcionesbuscar, opcionesbuscar[0]);
				switch(menu){
				case 0:
					cedula = Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese su numero de cedula"));
					Nodo encontrado = lista.BusquedaSecuencial(cedula);
					if(encontrado==null){
						JOptionPane.showMessageDialog(null,"Numero de cedula no encontrado");
					}else{
					JOptionPane.showMessageDialog(null, encontrado.dato.toString());
					}
					break;
				case 1:
					cedula = Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese su numero de cedula"));
					Nodo encontradohash = lista.BusquedaHashing(cedula);
					if(encontradohash==null){
						JOptionPane.showMessageDialog(null,"Numero de cedula no encontrado");
					}else{
					JOptionPane.showMessageDialog(null, encontradohash.dato.toString());
					}
					break;
				case 2:
					cedula = Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese su numero de cedula"));
					
					break;
				}
				break;
			case 3://eliminar
				long r = (long) Math.pow(5267564,2);
				String l = String.valueOf(r);
				int p = 0, u=l.length()-1;
				int m = (p+u)/2;
				int sm = m+2;
				String sl = l.substring(m, sm);
				int n = Integer.parseInt(sl);
				JOptionPane.showMessageDialog(null,r + "\nLongitud: "+l.length()+ "\nPosicion: "+ m + ", "+sm+ "\nMitad: "+sl+ "\nClave: "+n);
				String nombreE = "sodio";
				long numero = 0;
				String cadena=nombreE.toLowerCase();
				char[] caracter = cadena.toCharArray();
				String c="";
				char[] letras = {'@','a','b','c','d','e','f','g','h','i','j','k','l','m','n','ñ','o','p','q','r','s','t','u','v','w','x','y','z'};
				
				for(int i=0;i<caracter.length;i++){
					for(int j=0;j<letras.length;j++){
						if(caracter[i]==letras[j]){
						c +=j;	
						}
					}	
				
				}
				numero=Long.parseLong(c);
				long clave = (numero%119);
				JOptionPane.showMessageDialog(null, nombreE+": "+c+"\nclave: "+clave);
				
				break;
			case 4:
				String ordenar = "";
				ordenar=lista.Burbuja();
				JOptionPane.showMessageDialog(null, ordenar);
				break;
			case 5://salir
				JOptionPane.showMessageDialog(null, "Programa finalizado");
				System.exit(0);
				break;
			}
		}while(true);

	
	}

	private static double Math(double d, int i) {
		// TODO Auto-generated method stub
		return 0;
	}
}
