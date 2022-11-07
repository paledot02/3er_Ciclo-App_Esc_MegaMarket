package controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entidad.Producto;
import entidad.Proveedor;
import entidad.Transportista;
import interfaces.ProductoInterfaceDAO;
import utils.MySQLConexion8_PF;

public class GestionProductoDAO implements ProductoInterfaceDAO {

	@Override
	public int registrar(Producto p) {
		int estado=0;
		Connection con=null;
		PreparedStatement pstm=null;
		try {
			
			con = MySQLConexion8_PF.getConnection();
			//insert into megamarket.tb_transportistas values(null,'Leonardo','Palacios',47992688,'Kala','leopoldox3.lpa@gmail.com',default,default);
			String sql ="insert into tb_productos values(?,?,?,?,?,?,default,default)";
			pstm= con.prepareStatement(sql);
			pstm.setString(1,p.getNombre());
			pstm.setString(2, p.getFecha());
			pstm.setInt(3, p.getStock());
			pstm.setInt(4, p.getEmpresa());
			
			
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
	public int actualizar(Producto p) {
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
			String sql= "delete from tb_productos where id_producto= ?";
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
	public ArrayList<Producto> listar() {
		ArrayList<Producto> lista = new ArrayList<Producto>();
		Connection con = null;
		PreparedStatement pstm= null;
		ResultSet res=null;
		try {
			con=MySQLConexion8_PF.getConnection();
			String sql = "select * from tb_productos";
			pstm=con.prepareStatement(sql);
			res= pstm.executeQuery();
			Producto p;
			while(res.next()) {
				p = new Producto();
				p.setIdProducto(res.getInt(1));
				p.setNombre(res.getString(2));
				p.setFecha(res.getString(3));
				p.setStock(res.getInt(4));
				p.setEmpresa(res.getInt(5));
				lista.add(p);
				
			}
		} catch (Exception e) {
			System.out.println("Error en la sentencia listar Productos "+e.getMessage());
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

}
