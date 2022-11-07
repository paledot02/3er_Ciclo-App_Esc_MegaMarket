package vista;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JTextField;

import controlador.GestionProveedorDAO;
import controlador.GestionTransportistaDAO;
import entidad.Proveedor;
import entidad.TipoEmpresa;
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
import java.sql.Date;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class MantenimientoTransportista extends JPanel implements ActionListener {
	private JLabel lblNewLabel;
	private JLabel lblEmpresa;
	private JLabel lblNombres;
	private JLabel lblApellidos;
	private JLabel lblDni;
	private JLabel lblRegistroDeTransportistas;
	private JTextField txtID;
	private JComboBox cboEmpresa;
	private JButton btnRegistrar;
	private JLabel lblCorreo;
	private JTextField txtNombres;
	private JSeparator separator;
	private JSeparator separator_1;
	private JTextField txtApellidos;
	private JSeparator separator_2;
	private JTextField txtDni;
	private JSeparator separator_3;
	private JTextField txtCorreo;
	private TextPrompt ph;
	 
	GestionTransportistaDAO gt = new GestionTransportistaDAO();
	
	public MantenimientoTransportista() {
		setBackground(Color.WHITE);
		setLayout(null);
		
		lblNewLabel = new JLabel("ID Trasnportista");
		lblNewLabel.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lblNewLabel.setBounds(59, 82, 125, 22);
		add(lblNewLabel);
		
		lblEmpresa = new JLabel("Empresa:");
		lblEmpresa.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lblEmpresa.setBounds(589, 165, 71, 33);
		add(lblEmpresa);
		
		lblNombres = new JLabel("Nombres:");
		lblNombres.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lblNombres.setBounds(59, 170, 71, 22);
		add(lblNombres);
		
		lblApellidos = new JLabel("Apellidos:");
		lblApellidos.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lblApellidos.setBounds(59, 259, 71, 22);
		add(lblApellidos);
		
		lblDni = new JLabel("DNI:");
		lblDni.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lblDni.setBounds(59, 359, 71, 22);
		add(lblDni);
		
		lblRegistroDeTransportistas = new JLabel("Registro de Transportistas");
		lblRegistroDeTransportistas.setFont(new Font("Segoe UI", Font.BOLD, 24));
		lblRegistroDeTransportistas.setBounds(10, 11, 316, 32);
		add(lblRegistroDeTransportistas);
		
		txtID = new JTextField();
		txtID.setBounds(59, 116, 61, 20);
		add(txtID);
		txtID.setColumns(10);
		
		cboEmpresa = new JComboBox();
		cboEmpresa.setBounds(589, 214, 212, 22);
		add(cboEmpresa);
		
		lblCorreo = new JLabel("Correo:");
		lblCorreo.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lblCorreo.setBounds(589, 259, 71, 22);
		add(lblCorreo);
		
		btnRegistrar = new JButton("Registrar");
		btnRegistrar.addActionListener(this);
		btnRegistrar.setBounds(589, 390, 281, 60);
		add(btnRegistrar);
		
		txtNombres = new JTextField();
		txtNombres.setToolTipText("");
		txtNombres.setName("");
		txtNombres.setColumns(10);
		txtNombres.setBorder(null);
		txtNombres.setBounds(61, 206, 162, 20);
		ph=new TextPrompt("Ingrese su nombre",txtNombres);
		add(txtNombres);
		
		separator = new JSeparator();
		separator.setForeground(Color.BLACK);
		separator.setBounds(59, 229, 267, 40);
		add(separator);
		
		txtApellidos = new JTextField();
		txtApellidos.setToolTipText("");
		txtApellidos.setName("");
		txtApellidos.setColumns(10);
		txtApellidos.setBorder(null);
		txtApellidos.setBounds(61, 304, 162, 20);
		ph=new TextPrompt("Ingrese sus apellidos",txtApellidos);
		add(txtApellidos);
		
		separator_1 = new JSeparator();
		separator_1.setForeground(Color.BLACK);
		separator_1.setBounds(59, 327, 267, 40);
		add(separator_1);
		
		txtDni = new JTextField();
		txtDni.setToolTipText("");
		txtDni.setName("");
		txtDni.setColumns(10);
		txtDni.setBorder(null);
		txtDni.setBounds(61, 392, 162, 20);
		ph=new TextPrompt("Ingrese su dni",txtDni);
		add(txtDni);
		
		separator_2 = new JSeparator();
		separator_2.setForeground(Color.BLACK);
		separator_2.setBounds(59, 415, 267, 40);
		add(separator_2);
		
		txtCorreo = new JTextField();
		txtCorreo.setToolTipText("");
		txtCorreo.setName("");
		txtCorreo.setColumns(10);
		txtCorreo.setBorder(null);
		txtCorreo.setBounds(592, 304, 162, 20);
		ph=new TextPrompt("Ingrese su correo",txtCorreo);
		add(txtCorreo);
		
		separator_3 = new JSeparator();
		separator_3.setForeground(Color.BLACK);
		separator_3.setBounds(590, 327, 267, 40);
		add(separator_3);
		cargarCboEmpresa();
		

		
	}
	
	void cargarCboEmpresa() {
		ArrayList<Proveedor> dataEmpresa= gt.listarTipoEmpresa();
		for (Proveedor t : dataEmpresa) {
		
			cboEmpresa.addItem(t.getIdProveedor()+ " - " +t.getRazonSocial());
			
		}
	
	}
	
	
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnRegistrar) {
			actionPerformedBtnRegistrar(arg0);
		}
	}
	protected void actionPerformedBtnRegistrar(ActionEvent arg0) {
		
		String nombre,apellido,dni,correo;
		int empresa;
		
		nombre= getNombre();
		apellido= getApellido();
		dni= getDni();
		correo= getCorreo();
		empresa=getEmpresa();
		if(nombre==null||apellido==null||dni==null||correo==null||empresa==0) {
		
		}else {
		Transportista t=new Transportista();
		t.setNombre(nombre);
		t.setApellidos(apellido);
		t.setDni(dni);
		t.setEmpresa(empresa);
		t.setCorreo(correo);
		
		int ok= gt.registar(t);
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

	private String getCorreo() {
		String correo= null;
		if(txtCorreo.getText().trim().length()==0)
			mensaje("Ingresar correo");
		else if(txtCorreo.getText().trim().matches(Validaciones.CORREO)==false)
				mensaje("Formato de correo incorrecto");
		else correo=txtCorreo.getText();
		return correo;
	}
	private String getDni() {
		String dni=null;
		if(txtDni.getText().trim().length()==0)
			mensaje("Ingresar dni");
		else if(txtDni.getText().trim().matches(Validaciones.DNI)==false)
			mensaje("Formato de dni incorrecto");
		else
			dni=txtDni.getText();
		return dni;
	}
	private String getApellido() {
		String apellido=null;
		if(txtApellidos.getText().trim().length()==0)
			mensaje("Ingresar Apellido");
		else if(txtApellidos.getText().trim().matches(Validaciones.APELLIDO)==false)
			mensaje("Formato incorrecto del Apellido ingresar de 3 a 25 letras");
		else
			apellido= txtApellidos.getText();
		return apellido;

	}
	private String getNombre() {
		String nombre=null;
		if(txtNombres.getText().trim().length()==0)
			mensaje("Ingresar nombres");
		else if(txtNombres.getText().trim().matches(Validaciones.NOMBRE)==false)
			mensaje("Formato incorrecto del nombre ingresar de 3 a 15 letras");
		else
			nombre= txtNombres.getText();
		return nombre;
		
	}
	private void mensaje(String msj) {
		JOptionPane.showMessageDialog(this, msj,"Error",0);
	}
	private void mensaje1(String msj) {
		JOptionPane.showMessageDialog(this,msj,"Sistema",1);
	}
}
