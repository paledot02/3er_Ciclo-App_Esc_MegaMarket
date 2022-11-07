package controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.mysql.cj.protocol.Resultset;

import entidad.Proveedor;
import entidad.TipoEmpresa;
import entidad.Transportista;
import interfaces.TransportistaInterfaceDAO;
import utils.MySQLConexion8_PF;

public class GestionTransportistaDAO implements TransportistaInterfaceDAO {

	@Override
	public int registar(Transportista t) {
		int estado=0;
		Connection con=null;
		PreparedStatement pstm=null;
		try {
			
			con = MySQLConexion8_PF.getConnection();
			//insert into megamarket.tb_transportistas values(null,'Leonardo','Palacios',47992688,'Kala','leopoldox3.lpa@gmail.com',default,default);
			String sql ="insert into tb_transportistas values(null,?,?,?,?,?,default,default)";
			pstm= con.prepareStatement(sql);
			pstm.setString(1, t.getNombre());
			pstm.setString(2, t.getApellidos());
			pstm.setString(3, t.getDni());
			pstm.setInt(4, t.getEmpresa());
			pstm.setString(5, t.getCorreo());
			
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
	public int actualizar(Transportista t) {
		
		int estado= 0;
		Connection con = null;
		PreparedStatement pstm = null;
		try {
			
			con=MySQLConexion8_PF.getConnection();
			
			 String sql = "update tb_Transportistas set nombre= ?, apellidos = ?, dni = ?,empresa = ? where id_transportista = ?";			 
			 pstm= con.prepareStatement(sql);
			
			pstm.setString(1, t.getNombre());
			pstm.setString(2, t.getApellidos());
			pstm.setString(3, t.getDni());
			pstm.setInt(4, t.getEmpresa());
			pstm.setString(5, t.getCorreo());
		
			estado= pstm.executeUpdate();		 	 
					 
		} catch (Exception e) {
			System.out.println("Error<<<< en la instruccion de actualizar "+e.getMessage());
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
	public int eliminar(int codigo) {
		int estado=0;
		Connection con = null;
		PreparedStatement pstm= null;
		try {
			con= MySQLConexion8_PF.getConnection();
			String sql= "delete from tb_transportistas where id_transportista= ?";
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
	public ArrayList<Transportista> listar() {
		ArrayList<Transportista> lista = new ArrayList<Transportista>();
		Connection con = null;
		PreparedStatement pstm= null;
		ResultSet res=null;
		try {
			con=MySQLConexion8_PF.getConnection();
			String sql = "select * from tb_transportistas";
			pstm=con.prepareStatement(sql);
			res= pstm.executeQuery();
			Transportista t;
			while(res.next()) {
				t = new Transportista();
				t.setIdTransportista(res.getInt(1));
				t.setNombre(res.getString(2));
				t.setApellidos(res.getString(3));
				t.setDni(res.getString(4));
				t.setEmpresa(res.getInt(5));
				t.setCorreo(res.getString(6));
				lista.add(t);
				
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

	@Override
	public ArrayList<Proveedor> listarTipoEmpresa() {
		
		ArrayList<Proveedor>lista = new ArrayList<Proveedor>();
		Connection con = null;
		PreparedStatement pstm= null;
		ResultSet res = null;
		try {
			con=MySQLConexion8_PF.getConnection();
			String sql= "select*from tb_proveedores";
			pstm = con.prepareStatement(sql);
			res=pstm.executeQuery();
			Proveedor tipoE;
		while (res.next()) {
			tipoE=new Proveedor();
			tipoE.setIdProveedor(res.getInt(1));
			tipoE.setRazonSocial(res.getString(2));
			lista.add(tipoE);	
			}
			
			
		} catch (Exception e) {
			System.out.println("Error en la sentencia listar usuario "+e.getMessage());
		}finally {
			try {
				if(res!=null) res.close();
				if(pstm!=null)pstm.close();
				if(con != null)con.close();
			
			} catch (Exception e2) {
				System.out.println("Error al cerrar la base de datos "+e2.getMessage());
			}
		}
		
		return lista;
			
		
	}

	@Override
	public Transportista consultaXTranportista(int idTransportista) {
		
		Transportista transpo = new Transportista();
		Connection con = null;
		PreparedStatement pstm=null;
		ResultSet res = null;
		
		try {
			
			con= MySQLConexion8_PF.getConnection();
			
				
			String sql ="call usp_ConsultaXTransportista(?)";
			
			pstm = con.prepareStatement(sql);
			
			pstm.setInt(1, idTransportista);
			
			res= pstm.executeQuery();
			
			Transportista repUs;
			
			if(res.next()){
				//PASO 8: CREAR OBJETO USUARIO
				repUs = new Transportista();
				//PASO 9: SETEAR LOS OBJ DE LA CLASE USUARIO;
				repUs.setIdTransportista(res.getInt(1));
				repUs.setNombre(res.getString(2));
				repUs.setApellidos(res.getString(3));
				repUs.setDni(res.getString(4));
				repUs.setEmpresa(res.getInt(5));
				
				transpo = repUs;
			}
			
		} catch (Exception e) {
			System.out.println("Error en la sentencia listar usuario "+e.getMessage());
		}finally {
			try {
				if(res!=null) res.close();
				if(pstm!=null)pstm.close();
				if(con != null)con.close();
				
			} catch (SQLException e2) {
				System.out.println("Error al cerrar la base de datos "+e2.getMessage());
			}
		}
		
		return transpo;
	}
}
