
package vista;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import controlador.GestionProveedorDAO;
import entidad.Proveedor;
import entidad.Transportista;
import utils.Validaciones;

import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.Color;
import java.awt.Rectangle;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MantenimientoProveedores extends JPanel implements ActionListener {
	private JLabel lblNewLabel;
	private JLabel lblNombres;
	private JLabel lblApellidos;
	private JLabel lblDni;
	private JLabel lblRegistroDeTransportistas;
	private JTextField txtIDProveedor;
	private JTextField txtRazonSocial;
	private JTextField txtTelefonoProveedor;
	private JTextField txtRuc;
	private JButton btnRegistrar;
	private JLabel lblCorreo;
	private JTextField txtCorreoProveedor;
	private TextPrompt ph;
	private JSeparator separator;
	private JSeparator separator_1;
	private JSeparator separator_2;
	private JSeparator separator_3;
	
	GestionProveedorDAO gp = new GestionProveedorDAO();

	
	public MantenimientoProveedores() {
		
		setBackground(Color.WHITE);
		setLayout(null);
		
		lblNewLabel = new JLabel("ID Proveedor");
		lblNewLabel.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lblNewLabel.setBounds(59, 82, 125, 22);
		add(lblNewLabel);
		
		lblNombres = new JLabel("Razon Social:");
		lblNombres.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lblNombres.setBounds(59, 170, 125, 22);
		add(lblNombres);
		
		lblApellidos = new JLabel("Telefono:");
		lblApellidos.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lblApellidos.setBounds(59, 259, 81, 22);
		add(lblApellidos);
		
		lblDni = new JLabel("RUC:");
		lblDni.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lblDni.setBounds(59, 359, 71, 22);
		add(lblDni);
		
		lblRegistroDeTransportistas = new JLabel("Registro de Proveedores");
		lblRegistroDeTransportistas.setFont(new Font("Segoe UI", Font.BOLD, 24));
		lblRegistroDeTransportistas.setBounds(10, 11, 316, 32);
		add(lblRegistroDeTransportistas);
		
		txtIDProveedor = new JTextField();
		txtIDProveedor.setBounds(59, 116, 61, 20);
		txtIDProveedor.setColumns(10);
		add(txtIDProveedor);
		
		
		txtRazonSocial = new JTextField();
		txtRazonSocial.setBorder(null);
		txtRazonSocial.setColumns(10);
		txtRazonSocial.setBounds(59, 215, 212, 21);
		add(txtRazonSocial);
		ph=new TextPrompt("Ingrese Razon Social",txtRazonSocial);
		
		txtTelefonoProveedor = new JTextField();
		txtTelefonoProveedor.setBorder(null);
		txtTelefonoProveedor.setColumns(10);
		txtTelefonoProveedor.setBounds(59, 303, 212, 20);
		add(txtTelefonoProveedor);
		ph=new TextPrompt("Ingrese telefono de empresa",txtTelefonoProveedor);
		
		txtRuc = new JTextField();
		txtRuc.setBorder(null);
		txtRuc.setColumns(10);
		txtRuc.setBounds(59, 399, 212, 22);
		ph=new TextPrompt("Ingrese Ruc de empresa",txtRuc);
		add(txtRuc);
		
		lblCorreo = new JLabel("Correo:");
		lblCorreo.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lblCorreo.setBounds(589, 259, 71, 22);
		add(lblCorreo);
		
		txtCorreoProveedor = new JTextField();
		txtCorreoProveedor.setBorder(null);
		txtCorreoProveedor.setColumns(10);
		txtCorreoProveedor.setBounds(589, 303, 281, 20);
		ph=new TextPrompt("Ingrese correo corporativo",txtCorreoProveedor);
		add(txtCorreoProveedor);
		
		btnRegistrar = new JButton("Registrar");
		btnRegistrar.addActionListener(this);
		btnRegistrar.setBounds(589, 390, 281, 60);
		add(btnRegistrar);
		
		separator = new JSeparator();
		separator.setForeground(Color.BLACK);
		separator.setBounds(59, 236, 277, 22);
		add(separator);
		
		separator_1 = new JSeparator();
		separator_1.setForeground(Color.BLACK);
		separator_1.setBounds(59, 326, 267, 22);
		add(separator_1);
		
		separator_2 = new JSeparator();
		separator_2.setForeground(Color.BLACK);
		separator_2.setBounds(60, 422, 267, 33);
		add(separator_2);
		
		separator_3 = new JSeparator();
		separator_3.setForeground(Color.BLACK);
		separator_3.setBounds(589, 326, 267, 22);
		add(separator_3);
		

	}
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnRegistrar) {
			actionPerformedBtnRegistrar(arg0);
		}
	}
	protected void actionPerformedBtnRegistrar(ActionEvent arg0) {
		
		String razonSocial,telefono,ruc,correo;
		
		
		razonSocial= getRazonSocial();
		telefono= getTelefono();
		ruc= getRuc();
		correo= getCorreo();
		if(razonSocial==null||telefono==null||ruc==null||correo==null) {
		
		}else {
		Proveedor p = new Proveedor();
		p.setRazonSocial(razonSocial);
		p.setTelefono(telefono);
		p.setRuc(ruc);
		p.setCorreo(correo);
		
		int ok= gp.resgistrar(p);
		if(ok==0) {
			mensaje ("Error en el registro");
		}else {
			mensaje1("Registro exitoso");
			
			}
		}	
		
	}

	private String getCorreo() {
		String correo= null;
		if(txtCorreoProveedor.getText().trim().length()==0)
			mensaje("Ingresar correo");
		else if(txtCorreoProveedor.getText().trim().matches(Validaciones.CORREO)==false)
				mensaje("Formato de correo incorrecto");
		else correo=txtCorreoProveedor.getText();
		return correo;
	}
	private String getRuc() {
		String dni=null;
		if(txtRuc.getText().trim().length()==0)
			mensaje("Ingresar dni");
		else if(txtRuc.getText().trim().matches(Validaciones.RUC)==false)
			mensaje("Formato de Ruc incorrecto");
		else
			dni=txtRuc.getText();
		return dni;
	}
	private String getTelefono() {
		String apellido=null;
		if(txtTelefonoProveedor.getText().trim().length()==0)
			mensaje("Ingresar Apellido");
		else if(txtTelefonoProveedor.getText().trim().matches(Validaciones.CELULAR)==false)
			mensaje("Formato incorrecto del Apellido ingresar de 3 a 25 letras");
		else
			apellido= txtTelefonoProveedor.getText();
		return apellido;

	}
	private String getRazonSocial() {
		String nombre=null;
		if(txtRazonSocial.getText().trim().length()==0)
			mensaje("Ingresar nombres");
		else if(txtRazonSocial.getText().trim().matches(Validaciones.NOMBRE)==false)
			mensaje("Formato incorrecto del nombre ingresar de 3 a 15 letras");
		else
			nombre= txtRazonSocial.getText();
		return nombre;
		
	}
	private void mensaje(String msj) {
		JOptionPane.showMessageDialog(this, msj,"Error",0);
	}
	private void mensaje1(String msj) {
		JOptionPane.showMessageDialog(this,msj,"Sistema",1);
	}

}
