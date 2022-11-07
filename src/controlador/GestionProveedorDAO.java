package controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entidad.Proveedor;
import entidad.TipoEmpresa;
import entidad.Transportista;
import interfaces.ProveedorInterfaceDAO;

import utils.MySQLConexion8_PF;

public class GestionProveedorDAO implements ProveedorInterfaceDAO {

	@Override
	public int resgistrar(Proveedor p) {
		int estado=0;
		Connection con=null;
		PreparedStatement pstm=null;
		try {
			
			con = MySQLConexion8_PF.getConnection();
			
			String sql ="insert into tb_proveedores values(null,?,?,?,?,default,default)";
			pstm= con.prepareStatement(sql);
			pstm.setString(1, p.getRazonSocial());
			pstm.setString(2,p.getTelefono());
			pstm.setString(3, p.getRuc());
			pstm.setString(4, p.getCorreo());
			
			estado= pstm.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("Error<<<< en la instruccion de registrar "+e.getMessage());
		}finally {
			try {
				if(pstm!=null)
					pstm.close();
				if(con!=null)
					pstm.close();
				
			} catch (SQLException e2) {
				System.out.println("Error al cerrar base de dato "+e2.getMessage());
			}
		
		}
		
		return estado;
	}
	@Override
	public int actualizar(Proveedor p) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int eliminar(int codigo) {
		int estado=0;
		Connection con = null;
		PreparedStatement pstm= null;
		try {
			con= MySQLConexion8_PF.getConnection();
			String sql= "delete from tb_proveedores where id_Proveedor= ?";
			pstm= con.prepareStatement(sql);
			pstm.setInt(1, codigo);
			
			estado = pstm.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("Error en la sentencia eliminar >>>> "+ e.getMessage());
		}finally {
			try {
				if(pstm!=null)
					pstm.close();
				if(con !=null)
					con.close();
				
			} catch (Exception e2) {
				System.out.println("Error al cerrar la base de datos >>> "+e2.getMessage());
			}
		}
		
		return estado;
	}


	@Override
	public ArrayList<Proveedor> listar() {
		ArrayList<Proveedor> lista = new ArrayList<Proveedor>();
		Connection con = null;
		PreparedStatement pstm= null;
		ResultSet res=null;
		try {
			con=MySQLConexion8_PF.getConnection();
			String sql = "select * from tb_proveedores";
			pstm=con.prepareStatement(sql);
			res= pstm.executeQuery();
			Proveedor p;
			while(res.next()) {
				p = new Proveedor();
				p.setIdProveedor(res.getInt(1));
				p.setRazonSocial(res.getString(2));
				p.setTelefono(res.getString(3));
				p.setRuc(res.getString(4));
				p.setCorreo(res.getString(5));
				lista.add(p);
				
			}
		} catch (Exception e) {
			System.out.println("Error en la sentencia listar Transportista "+e.getMessage());
		}finally {
			try {
				if(res!=null) res.close();
				if(pstm!=null)pstm.close();
				if(con != null)con.close();
				
			} catch (SQLException e2) {
				System.out.println("Error al cerrar la base de datos "+e2.getMessage());
			}
		}
		return lista;
	}

}
