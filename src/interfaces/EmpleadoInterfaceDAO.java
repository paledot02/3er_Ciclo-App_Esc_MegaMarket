package interfaces;

import java.util.ArrayList;

import entidad.Empleado;
import entidad.TipoEmpleado;

public interface EmpleadoInterfaceDAO {
	// Validar acceso al sistema
	public int registrar(Empleado e);
	public Empleado validarAcceso(String user, String pass);
	public ArrayList<TipoEmpleado> listarTipoEmpleado(); // para llenar el ComboBox de Tipo empleado
	
}
