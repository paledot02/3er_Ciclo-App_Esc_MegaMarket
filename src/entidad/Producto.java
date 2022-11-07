package entidad;

public class Producto {

	private String  nombre, fecha;
	private int stock,idProducto,empresa;
	
	
	
	public Producto() {
		
		
	}



	public int getIdProducto() {
		return idProducto;
	}



	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}



	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public int getEmpresa() {
		return empresa;
	}



	public void setEmpresa(int empresa) {
		this.empresa = empresa;
	}



	public String getFecha() {
		return fecha;
	}



	public void setFecha(String fecha) {
		this.fecha = fecha;
	}



	public int getStock() {
		return stock;
	}



	public void setStock(int stock) {
		this.stock = stock;
	}
	
	
}
