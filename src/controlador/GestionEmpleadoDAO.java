package controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entidad.Empleado;
import entidad.TipoEmpleado;
import interfaces.EmpleadoInterfaceDAO;
import utils.MySQLConexion8_PF;

public class GestionEmpleadoDAO implements EmpleadoInterfaceDAO{

	@Override
	public Empleado validarAcceso(String user, String pass) {
		Empleado empleado = null;
		
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet res = null;
		try {
			con = MySQLConexion8_PF.getConnection();
			String sql = "CALL usp_validarEmpleado (?, ?);";
			pstm = con.prepareStatement(sql);

			pstm.setString(1, user);
			pstm.setString(2, pass);
			// paso 5: ejecutar la instruccion
			res = pstm.executeQuery();
			
			// paso 6: Crear un bucle para recorrer la tabla mientras tenga registros es verdadero
			if(res.next()){
				// paso 7: crear el objeto usuario
				empleado = new Empleado();
				// paso 9: setear los objetos de la clase usuario --> asignar los registros obtenidos a los atributos
				empleado.setCodigo(res.getInt(1));
				empleado.setNombre(res.getString(2));
				empleado.setApellido(res.getString(3));
				empleado.setDni(res.getString(4));
				empleado.setUsuario(res.getString(5));
				empleado.setContrasena(res.getString(6));
				empleado.setFechaNacimiento(res.getString(7));
				empleado.setTipoEmpleado(res.getInt(8));
				
			}
		} catch (Exception e) {
			System.out.println("Error en la sentencia validar acceso" + e.getMessage());
		}finally {
			try {
				if( res != null ) res.close();
				if( pstm != null ) pstm.close();
				if( con != null ) con.close();
			} catch (SQLException e2) {
				System.out.println("Error al cerrar la base de datos" + e2.getMessage());
			}
		}
		
		return empleado;
	}

	@Override
	public ArrayList<TipoEmpleado> listarTipoEmpleado() {
		ArrayList<TipoEmpleado> lista = new ArrayList<TipoEmpleado>();
		
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet res = null;
		try {
			con = MySQLConexion8_PF.getConnection();
			String sql = "SELECT * FROM megamarket.tb_tipoempleado";
			pstm = con.prepareStatement(sql);
			res = pstm.executeQuery();
			
			TipoEmpleado tipoE; // Declara un objeto de tipo "TipoEmpleado"
			
			while(res.next()){
				
				tipoE = new TipoEmpleado();
				tipoE.setIdTipo(res.getInt(1));
				tipoE.setDescripcion(res.getString(2));
				lista.add(tipoE);
			}
		} catch (Exception e) {
			System.out.println("Error en la sentencia listar usuario" + e.getMessage());
		}finally {
			try {
				if( res != null ) res.close();
				if( pstm != null ) pstm.close();
				if( con != null ) con.close();
			} catch (SQLException e2) {
				System.out.println("Error al cerrar la base de datos" + e2.getMessage());
			}
		}
		return lista;
	}

	@Override
	public int registrar(Empleado empl) {
		int estado = 0;  // 0 es error
		Connection conexion = null;
		PreparedStatement pstm = null;
		try {
			conexion = MySQLConexion8_PF.getConnection();
			String sql = "insert into tb_Empleado values(null,?,?,?,?,?,?,?)";
			pstm = conexion.prepareStatement(sql);
			// paso 4: parametros
			// codigo esta null porque esta como auto incremento --> 0
			pstm.setString(1, empl.getNombre());
			pstm.setString(2, empl.getApellido());
			pstm.setString(3, empl.getDni());
			pstm.setString(4, empl.getUsuario());
			pstm.setString(5, empl.getContrasena());
			pstm.setString(6, empl.getFechaNacimiento());
			pstm.setInt(7, empl.getTipoEmpleado());
			
			// paso 5 : ejecutar instruccion
			estado = pstm.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("Error <<< en la instruccion de registrar " + e.getMessage());
		}finally {
			try {
				if(pstm != null)
					pstm.close();
				if(conexion != null)
					conexion.close();
			} catch (SQLException e2) {
				System.out.println("Error al cerrar base de datos " + e2.getMessage() );
			}
		}
		return estado;
	}
}
