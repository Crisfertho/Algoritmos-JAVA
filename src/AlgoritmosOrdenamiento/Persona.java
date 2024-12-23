package AlgoritmosOrdenamiento;

public class Persona {
public String nombre,direccion;
public int cedula;
public Persona(String nombre, String direccion, int cedula) {
	this.nombre = nombre;
	this.direccion = direccion;
	this.cedula = cedula;
}//fin del constructor
public String getNombre() {
	return nombre;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
}
public String getDireccion() {
	return direccion;
}
public void setDireccion(String direccion) {
	this.direccion = direccion;
}
public int getCedula() {
	return cedula;
}
public void setCedula(int cedula) {
	this.cedula = cedula;
}
@Override
public String toString() {
	return "\n" + getNombre() + " - " + getDireccion() + " - " + getCedula();
}


}//fin de la clase

