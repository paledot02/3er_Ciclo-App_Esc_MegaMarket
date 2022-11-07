package interfaces;

import java.util.ArrayList;

import entidad.Producto;
import entidad.Proveedor;

public interface ProductoInterfaceDAO {
	
	public int registrar(Producto p);
	public int actualizar(Producto p);
	public int eliminar(int codigo);
	public ArrayList<Producto>listar();
	public ArrayList<Proveedor> listarTipoEmpresa();

}
