package entidad;

public class Empleado {
	private int codigo;
	private String nombre;
	private String apellido;
	private String dni;
	private String usuario;
	private String contrasena;
	private String fechaNacimiento;
	private int tipoEmpleado;
	
	public Empleado(){}

	public int getCodigo() {return codigo;}
	public void setCodigo(int codigo) {this.codigo = codigo;}
	public String getNombre() {return nombre;}
	public void setNombre(String nombre) {this.nombre = nombre;}
	public String getApellido() {return apellido;}
	public void setApellido(String apellido) {this.apellido = apellido;}
	public String getDni() {return dni;}
	public void setDni(String dni) {this.dni = dni;}
	public String getUsuario() {return usuario;}
	public void setUsuario(String usuario) {this.usuario = usuario;}
	public String getContrasena() {return contrasena;}
	public void setContrasena(String contrasena) {this.contrasena = contrasena;}
	public String getFechaNacimiento() {return fechaNacimiento;}
	public void setFechaNacimiento(String fechaNacimiento) {this.fechaNacimiento = fechaNacimiento;}
	public int getTipoEmpleado() {return tipoEmpleado;}
	public void setTipoEmpleado(int tipoEmpleado) {this.tipoEmpleado = tipoEmpleado;}

	
}
