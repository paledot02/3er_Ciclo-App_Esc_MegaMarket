package interfaces;

import java.util.ArrayList;

import entidad.CabeceraReporteRecepcion;
import entidad.DetalleReporteRecepcion;

public interface RecepcionProductoDAO {
	
	public String generarNumeroReporteRecepcion();
	// Transaccion
	public int realizarRecepcionProducto(CabeceraReporteRecepcion cabReporte, ArrayList<DetalleReporteRecepcion> detReporte);
}
