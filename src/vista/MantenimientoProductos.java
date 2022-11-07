package vista;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.Color;
import java.awt.Rectangle;
import java.util.ArrayList;

import com.toedter.calendar.JDateChooser;

import controlador.GestionProductoDAO;
import entidad.Producto;
import entidad.Proveedor;
import entidad.Transportista;
import utils.Validaciones;

import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;

public class MantenimientoProductos extends JPanel implements ActionListener {
	private JLabel lblNewLabel;
	private JLabel lblEmpresa;
	private JLabel lblNombres;
	private JLabel lblApellidos;
	private JLabel lblDni;
	private JLabel lblRegistroDeTransportistas;
	private JTextField txtIdProducto;
	private JComboBox cboEmpresa;
	private JButton btnRegistrar;
	private JComboBox cboCategoria;
	private JLabel lblEmpresa_1;
	private JTextField txtProductos;
	private JSeparator separator;
	private JTextField txtStock;
	private JSeparator separator_2;
	private TextPrompt ph;
	private JDateChooser dcFecha;
	
	GestionProductoDAO gp = new GestionProductoDAO();
	
	public MantenimientoProductos () {
		setBackground(Color.WHITE);
		setLayout(null);
		
		lblNewLabel = new JLabel("ID Productos");
		lblNewLabel.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lblNewLabel.setBounds(59, 82, 125, 22);
		add(lblNewLabel);
		
		lblEmpresa = new JLabel("Empresa:");
		lblEmpresa.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lblEmpresa.setBounds(589, 165, 87, 33);
		add(lblEmpresa);
		
		lblNombres = new JLabel("Nombre del Producto:");
		lblNombres.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lblNombres.setBounds(59, 170, 161, 22);
		add(lblNombres);
		
		lblApellidos = new JLabel("Fecha:");
		lblApellidos.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lblApellidos.setBounds(59, 259, 71, 22);
		add(lblApellidos);
		
		lblDni = new JLabel("Stock:");
		lblDni.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lblDni.setBounds(59, 359, 71, 22);
		add(lblDni);
		
		lblRegistroDeTransportistas = new JLabel("Registro de Productos");
		lblRegistroDeTransportistas.setFont(new Font("Segoe UI", Font.BOLD, 24));
		lblRegistroDeTransportistas.setBounds(10, 11, 316, 32);
		add(lblRegistroDeTransportistas);
		
		txtIdProducto = new JTextField();
		txtIdProducto.setBounds(59, 116, 61, 20);
		add(txtIdProducto);
		txtIdProducto.setColumns(10);
		
		cboEmpresa = new JComboBox();
		cboEmpresa.setBounds(589, 214, 212, 22);
		add(cboEmpresa);
		
		btnRegistrar = new JButton("Registrar");
		btnRegistrar.addActionListener(this);
		btnRegistrar.setBounds(589, 390, 281, 60);
		add(btnRegistrar);
		
		cboCategoria = new JComboBox();
		cboCategoria.setBounds(589, 302, 212, 22);
		add(cboCategoria);
		
		lblEmpresa_1 = new JLabel("Categoria:");
		lblEmpresa_1.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lblEmpresa_1.setBounds(589, 247, 87, 33);
		
		add(lblEmpresa_1);
		
		txtProductos = new JTextField();
		txtProductos.setColumns(10);
		txtProductos.setBorder(null);
		txtProductos.setBounds(59, 203, 212, 21);
		ph=new TextPrompt("Ingrese nombre del producto",txtProductos);
		add(txtProductos);
		
		separator = new JSeparator();
		separator.setForeground(Color.BLACK);
		separator.setBounds(59, 224, 277, 22);
		add(separator);
		
		txtStock = new JTextField();
		txtStock.setColumns(10);
		txtStock.setBorder(null);
		txtStock.setBounds(59, 392, 212, 21);
		ph=new TextPrompt("Ingrese el numero de productos",txtStock);
		add(txtStock);
		
		separator_2 = new JSeparator();
		separator_2.setForeground(Color.BLACK);
		separator_2.setBounds(59, 413, 277, 22);
		add(separator_2);
		
		dcFecha = new JDateChooser();
		dcFecha.setBounds(59, 292, 147, 20);
		dcFecha.setBorder(null);
		
		add(dcFecha);
		
		cargarCboEmpresa();
		

	}
	
	void cargarCboEmpresa() {
		ArrayList<Proveedor> dataEmpresa= gp.listarTipoEmpresa();
		for (Proveedor p : dataEmpresa) {
			
		
			cboEmpresa.addItem(p.getIdProveedor()+ " - " +p.getRazonSocial());
			
		}
	
	}
	
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnRegistrar) {
			actionPerformedBtnRegistrar(arg0);
		}
	}
	protected void actionPerformedBtnRegistrar(ActionEvent arg0) {
		
		String nombreProd,fecha;
		int empresa,stock;
		
		nombreProd= getNombreProd();
		fecha = getFecha();
		stock= getStock();
		empresa=getEmpresa();
		
		if(nombreProd==null||fecha==null||stock==0||empresa==0) {
		
		}else {
		Producto p=new Producto();
		p.setNombre(nombreProd);
		p.setFecha(fecha);
		p.setStock(stock);
		p.setEmpresa(empresa);
		
		
		int ok= gp.registrar(p);
		if(ok==0) {
			mensaje ("Error en el registro");
		}else {
			mensaje1("Registro exitoso");
			
			}
		}	
		
		
	}
	private int getEmpresa() {
		int tipo;
		tipo = cboEmpresa.getSelectedIndex();
		if(tipo == 0)
			mensaje("Seleccionar el tipo de producto");
		
		return tipo;
	}

	private int getStock() {
		int stock = 0;
		if(txtStock.getText().trim().length()==0)
			mensaje("Ingresar stock");
		else if(txtStock.getText().trim().matches(Validaciones.CELULAR)==false)
			mensaje("Formato de dni incorrecto");
		else
			stock=Integer.parseInt(txtStock.getText());
		return stock;
	}

	private String getFecha() {
		//fecha --> año/mes/dia
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				String fecha=null;
				fecha=sdf.format(dcFecha.getDate());
				return fecha;
			
	}

	private String getNombreProd() {
		// TODO Auto-generated method stub
		return null;
	}

	private void mensaje(String msj) {
		JOptionPane.showMessageDialog(this, msj,"Error",0);
	}
	private void mensaje1(String msj) {
		JOptionPane.showMessageDialog(this,msj,"Sistema",1);
	}
}