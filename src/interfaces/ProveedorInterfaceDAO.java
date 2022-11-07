package interfaces;

import java.util.ArrayList;

import entidad.Proveedor;

public interface ProveedorInterfaceDAO {
	
	public int resgistrar(Proveedor p);
	public int actualizar(Proveedor p);
	public int eliminar(int codigo);
	public ArrayList<Proveedor>listar();

}
