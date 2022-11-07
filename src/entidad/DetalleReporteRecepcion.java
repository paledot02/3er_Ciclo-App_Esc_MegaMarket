package entidad;

public class DetalleReporteRecepcion {
	
	private String numReporte;
	private String idProducto;
	private int cantidad;
	// Constructores
	public DetalleReporteRecepcion(String numReporte, String idProducto, int cantidad) {
		super();
		this.numReporte = numReporte;
		this.idProducto = idProducto;
		this.cantidad = cantidad;
	}
	public DetalleReporteRecepcion(){}
	// Metodos get/set
	public String getNumReporte() {return numReporte;}
	public void setNumReporte(String numReporte) {this.numReporte = numReporte;}
	public String getIdProducto() {return idProducto;}
	public void setIdProducto(String idProducto) {this.idProducto = idProducto;}
	public int getCantidad() {return cantidad;}
	public void setCantidad(int cantidad) {this.cantidad = cantidad;}
	
	
	
	
	
}
