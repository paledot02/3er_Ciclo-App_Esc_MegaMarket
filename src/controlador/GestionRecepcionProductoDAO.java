package controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;

import entidad.CabeceraReporteRecepcion;
import entidad.DetalleReporteRecepcion;
import interfaces.RecepcionProductoDAO;
import utils.MySQLConexion8_PF;

public class GestionRecepcionProductoDAO implements RecepcionProductoDAO{

	@Override
	public String generarNumeroReporteRecepcion() {
		String codigoBol = "R0001";
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet res = null;
		try{
			con = MySQLConexion8_PF.getConnection();
			String sql = "SELECT substring(max(num_reporte),2) FROM tb_cab_reporte";
			
			pstm = con.prepareStatement(sql);
			res = pstm.executeQuery();
			
			if(res.next()){
				DecimalFormat df = new DecimalFormat("0000");
				codigoBol = "R" + df.format(Integer.parseInt(res.getString(1)) + 1 ); // ejemplo 003+1 = 004	
			}
		} catch(Exception e){
			System.out.println("Error en generar Número de Reporte");
		}finally{
			try{
				if(con != null)
					con.close();
			}catch(SQLException e2){
				System.out.println(">>>> Error al cerrar <<<< " + e2.getMessage());
			}
		}
		return codigoBol;
	}

	@Override
	public int realizarRecepcionProducto(CabeceraReporteRecepcion cabReporte,ArrayList<DetalleReporteRecepcion> detReporte) {
		int estado = 0;
		Connection con = null;
		PreparedStatement pstm1 = null; // registra datos en la tb cab_Bol
		PreparedStatement pstm2 = null; // registra datos en la tb det_Bol
		PreparedStatement pstm3 = null; // actualizar la tbProductos --> stock
		
		try {
			con = MySQLConexion8_PF.getConnection();
			con.setAutoCommit(false);
			// INSTRUCCION 1 -- Registro de la tabla cabecera boleta
			String sql1 = "insert into tb_cab_reporte values (?,?,?,?)";
			// Crear el objeto pstm y enviar a dicho objeto la insruccion sql
			pstm1 = con.prepareStatement(sql1);
			
			pstm1.setString(1, cabReporte.getNumReporte());
			pstm1.setString(2, cabReporte.getFechaReporte());
			pstm1.setInt(3, cabReporte.getCodProveedor());
			pstm1.setString(4, cabReporte.getDniTransportista());
			// Ejecutar instruccion
			estado = pstm1.executeUpdate();
			
			// INSTRUCCION 2 -- Registro de la tabla cabecera boleta
			String sql2 = "insert into tb_det_reporte values (?, ?, ?);";
			
			for (DetalleReporteRecepcion d : detReporte) {
				
				pstm2 = con.prepareStatement(sql2);
				
				pstm2.setString(1, cabReporte.getNumReporte());
				pstm2.setInt(2, Integer.parseInt(d.getIdProducto()));
				pstm2.setInt(3, d.getCantidad());
				
				estado = pstm2.executeUpdate();
			}
			
			// INSTRUCCION 3 -- Actualizar los productos, disminuye cada ves que se vende los productos
			String sql3 = "update tb_productos set stock = stock + ? where id_producto = ?";
			for (DetalleReporteRecepcion d : detReporte) {    // preparar la instruccion sql3
				pstm3 = con.prepareStatement(sql3);
				
				pstm3.setInt(1, d.getCantidad());
				pstm3.setInt(2, Integer.parseInt(d.getIdProducto()));
				estado = pstm3.executeUpdate(); // ejecutar la sentencia
			}
			con.commit();     // <--------------------
			
		} catch (Exception e) {
			System.out.println("Error <<< al realizar la venta" + e.getMessage());
			estado = 0;
			try {
				con.rollback();   // <----------
			} catch (Exception e2) {
				System.out.println("Error <<< al Restaurar tablas" + e.getMessage());
			}
		}finally {
			try {
				if(con != null)
					con.close();
			} catch (SQLException e2) {
				System.out.println("Error al cerrar base de datos " + e2.getMessage() );
			}
		}
		return estado;
	}

}
