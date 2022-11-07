package interfaces;

import java.util.ArrayList;

import entidad.Proveedor;
import entidad.TipoEmpresa;
import entidad.Transportista;

public interface TransportistaInterfaceDAO {
	
	public int registar(Transportista t);
	public int actualizar(Transportista t);
	public int eliminar(int codigo);
	public ArrayList<Transportista> listar();
	public ArrayList<Proveedor> listarTipoEmpresa();
	public Transportista consultaXTranportista(int idTransportista);
}
