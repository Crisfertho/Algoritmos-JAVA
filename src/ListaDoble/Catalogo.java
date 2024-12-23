package ListaDoble;

import javax.swing.JOptionPane;

public class Catalogo {
private static final String String = null;
public String producto;
public String codigo;
public long precio;
public int cantidad;
public String categoria;
public long TotalProductos;
public Catalogo(String producto, String codigo, long precio, int cantidad, String categoria,long total) {
	this.producto = producto;
	this.codigo = codigo;
	this.precio = precio;
	this.cantidad = cantidad;
	this.categoria = categoria;
	this.TotalProductos = 0;
}
public Catalogo(){
	
}
public String getProducto() {
	return producto;
}
public void setProducto(String producto) {
	this.producto = producto;
}
public String getCodigo() {
	return codigo;
}
public void setCodigo(String codigo) {
	this.codigo = codigo;
}
public long getPrecio() {
	return precio;
}
public void setPrecio(long precio) {
	this.precio = precio;
}
public int getCantidad() {
	return cantidad;
}
public void setCantidad(int cantidad) {
	this.cantidad = cantidad;
}
public String getCategoria() {
	return categoria;
}
public void setCategoria(String categoria) {
	this.categoria = categoria;
}
public void Ingresar(){//ingresar
	String[] opciones = {"P","C","F"};
	String cat = null;
	int menu = JOptionPane.showOptionDialog(null, "seleccione la categoria deseada:"
			+ "\n(P)Pintura.\n(C)Material para construccion. \n(F)Fontaneria","Elegir Categoria",
			JOptionPane.DEFAULT_OPTION,JOptionPane.QUESTION_MESSAGE,null, opciones, opciones[0]);
	switch(menu){
	case 0:
		setCategoria("Pintura");
		cat = "PLA";
		break;
	case 1:
		setCategoria("Construccion");
		cat = "CLA";
		break;
	case 2:
		setCategoria("Fontaneria");
		cat = "FLA";
		break;
	}
	producto = JOptionPane.showInputDialog(null,"Ingrese el nombre del producto");
	try{
		int cod = 0;
		do{
	cod = Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese numero del codigo del producto"));
	if(cod > 99){
		JOptionPane.showMessageDialog(null, "No se puede ingresar mas de dos numeros");
	}
		}while(cod > 99);
	String c = String.valueOf(cod);
	codigo = cat+c;
	precio = Long.parseLong(JOptionPane.showInputDialog(null,"Ingrese el precio individual del producto"));
	cantidad = Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese la cantidad del producto"));
	}catch( Exception e){
		JOptionPane.showMessageDialog(null, "No se puede ingresar letras, solo numeros.");
	}
}//fin de metodo ingresar

@Override
public String toString() {
	return "\n\n********************************************"+
		   "\nNombre del Producto: " + getProducto() + 
		   "\nCodigo: " + getCodigo() + 
		   "\nPrecio:" + getPrecio() + 
		   "\nCantidad:" + getCantidad() + 
		   "\nCategoria: " + getCategoria() +
		   "\nMonto Total de Productos:" + getTotalProductos();
	
}
public long getTotalProductos() {
	
	return TotalProductos = getCantidad()*getPrecio();
}
public void setTotalProductos(long totalProductos) {
	TotalProductos = totalProductos;
}

}
