package entidad;

public class Transportista {
	
	private String nombre,apellidos,dni,correo;
	private int empresa,idTransportista;
	
	public Transportista() {}

	public int getIdTransportista() {return idTransportista;}
	public void setIdTransportista(int idTransportista) {this.idTransportista = idTransportista;}
	public String getNombre() {return nombre;}
	public void setNombre(String nombre) {this.nombre = nombre;}
	public String getApellidos() {return apellidos;}
	public void setApellidos(String apellidos) {this.apellidos = apellidos;}
	public String getDni() {return dni;}
	public void setDni(String dni) {this.dni = dni;}
	public int getEmpresa() {return empresa;}
	public void setEmpresa(int empresa) {this.empresa = empresa;}
	public String getCorreo() {return correo;}
	public void setCorreo(String correo) {this.correo = correo;}
	
	
}

