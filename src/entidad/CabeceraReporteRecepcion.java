package entidad;

public class CabeceraReporteRecepcion {

	private String numReporte;
	private String fechaReporte;
	private int codProveedor;
	private String dniTransportista;
	// Constructores
	public CabeceraReporteRecepcion(String numReporte, String fechaReporte, int codProveedor,String dniTransportista) {
		super();
		this.numReporte = numReporte;
		this.fechaReporte = fechaReporte;
		this.codProveedor = codProveedor;
		this.dniTransportista = dniTransportista;
	}
	public CabeceraReporteRecepcion(){}
	// Metodos get/set
	public String getNumReporte() {return numReporte;}
	public void setNumReporte(String numReporte) {this.numReporte = numReporte;}
	public String getFechaReporte() {return fechaReporte;}
	public void setFechaReporte(String fechaReporte) {this.fechaReporte = fechaReporte;}
	public int getCodProveedor() {return codProveedor;}
	public void setCodProveedor(int codProveedor) {this.codProveedor = codProveedor;}
	public String getDniTransportista() {return dniTransportista;}
	public void setDniTransportista(String dniTransportista) {this.dniTransportista = dniTransportista;}
}
