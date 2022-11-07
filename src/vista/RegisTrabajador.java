package vista;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import com.toedter.calendar.JDateChooser;

import controlador.GestionEmpleadoDAO;
import entidad.Empleado;
import entidad.TipoEmpleado;
import utils.Validaciones;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.border.BevelBorder;
import java.awt.SystemColor;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class RegisTrabajador extends JPanel implements ActionListener {
	private JLabel lblRegistrarse;
	private JLabel lblNombre;
	private JLabel lblApellido;
	private JLabel lblDni;
	private JLabel lblUsuario;
	private JLabel lblContrasea;
	private JLabel lblFechaNacimiento;
	private JLabel lblTipoEmpleado;
	private JDateChooser dcFechaNacimiento;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtDni;
	private JTextField txtUsuario;
	private JPasswordField txtClave;
	private JComboBox cboTipoEmpleado;
	private JButton btnRegistrar;
	private JLabel lblMensaje;
	private JButton button;
	// Crar el Objeto de la clase GestionEmpleadoDAO ---
	GestionEmpleadoDAO gEd = new GestionEmpleadoDAO();
	//--------------------------------------------------
	
	
	/**
	 * Create the panel.
	 */
	public RegisTrabajador() {
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, new Color(192, 192, 192), new Color(192, 192, 192)));
		panel.setBackground(SystemColor.control);
		panel.setBounds(0, 0, 334, 835);
		add(panel);
		panel.setLayout(null);
		
		lblRegistrarse = new JLabel("Registro");
		lblRegistrarse.setOpaque(true);
		lblRegistrarse.setBackground(SystemColor.activeCaptionBorder);
		lblRegistrarse.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblRegistrarse.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegistrarse.setBounds(10, 22, 314, 27);
		panel.add(lblRegistrarse);
		
		lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNombre.setBounds(35, 100, 110, 20);
		panel.add(lblNombre);
		
		lblApellido = new JLabel("Apellido");
		lblApellido.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblApellido.setBounds(35, 160, 110, 20);
		panel.add(lblApellido);
		
		lblDni = new JLabel("Dni");
		lblDni.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblDni.setBounds(35, 220, 110, 20);
		panel.add(lblDni);
		
		lblUsuario = new JLabel("Usuario");
		lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblUsuario.setBounds(35, 280, 110, 20);
		panel.add(lblUsuario);
		
		lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblContrasea.setBounds(35, 340, 110, 20);
		panel.add(lblContrasea);
		
		lblFechaNacimiento = new JLabel("Fecha Nacimiento");
		lblFechaNacimiento.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblFechaNacimiento.setBounds(35, 400, 110, 20);
		panel.add(lblFechaNacimiento);
		
		lblTipoEmpleado = new JLabel("Tipo Empleado");
		lblTipoEmpleado.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTipoEmpleado.setBounds(35, 460, 110, 20);
		panel.add(lblTipoEmpleado);
		
		dcFechaNacimiento = new JDateChooser();
		dcFechaNacimiento.setBounds(67, 425, 200, 25);
		panel.add(dcFechaNacimiento);
		
		txtNombre = new JTextField();
		txtNombre.setHorizontalAlignment(SwingConstants.CENTER);
		txtNombre.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtNombre.setBounds(67, 125, 200, 25);
		panel.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtApellido = new JTextField();
		txtApellido.setHorizontalAlignment(SwingConstants.CENTER);
		txtApellido.setBounds(67, 185, 200, 25);
		panel.add(txtApellido);
		txtApellido.setColumns(10);
		
		txtDni = new JTextField();
		txtDni.setHorizontalAlignment(SwingConstants.CENTER);
		txtDni.setBounds(67, 245, 200, 25);
		panel.add(txtDni);
		txtDni.setColumns(10);
		
		txtUsuario = new JTextField();
		txtUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		txtUsuario.setBounds(67, 305, 200, 25);
		panel.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		txtClave = new JPasswordField();
		txtClave.setHorizontalAlignment(SwingConstants.CENTER);
		txtClave.setBounds(67, 365, 200, 25);
		panel.add(txtClave);
		
		cboTipoEmpleado = new JComboBox();
		cboTipoEmpleado.setBounds(67, 485, 200, 25);
		panel.add(cboTipoEmpleado);
		
		btnRegistrar = new JButton("Registrar");
		btnRegistrar.addActionListener(this);
		btnRegistrar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnRegistrar.setBounds(107, 550, 120, 30);
		panel.add(btnRegistrar);
		
		lblMensaje = new JLabel("Registro Exitoso");
		lblMensaje.setVisible(false);
		lblMensaje.setHorizontalAlignment(SwingConstants.CENTER);
		lblMensaje.setForeground(new Color(34, 139, 34));
		lblMensaje.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblMensaje.setBounds(67, 646, 200, 25);
		panel.add(lblMensaje);
		
		button = new JButton("<-- Atras");
		button.addActionListener(this);
		button.setFont(new Font("Tahoma", Font.PLAIN, 15));
		button.setBounds(204, 774, 100, 30);
		panel.add(button);
		// Cargar Datos del ComboBox Tipo de Empleado
		cargarDataTipoEmpleadoComboBox();
	}
	/** ComboBox **/
	void cargarDataTipoEmpleadoComboBox(){
		// paso 1: Obtener el resultado del metodo de consulta
		ArrayList<TipoEmpleado> listaTipoEmpleado = gEd.listarTipoEmpleado();
		cboTipoEmpleado.addItem("- Seleccione Tipo -");
		// paso 2: Enviar la informacion al Combobox "cboTipo"
		for (TipoEmpleado t : listaTipoEmpleado) {
			cboTipoEmpleado.addItem(t.getIdTipo() + " - " + t.getDescripcion());
		}
	}/** --------------------------------------------------------------- **/
	
	public void actionPerformed(ActionEvent arg0) {
	if (arg0.getSource() == btnRegistrar) {
		actionPerformedBtnRegistrar(arg0);
	}
		if (arg0.getSource() == button) {
			actionPerformedButton(arg0);
		}
	}
	protected void actionPerformedButton(ActionEvent arg0) {
		FrmMenuPrincipal.MostrarPanel(new Login());
	}
	protected void actionPerformedBtnRegistrar(ActionEvent arg0) {
		registrarDatos();
	}
	/** -----------------  Registrar Empleado ------------------------**/ 
	private void registrarDatos() {
		
		String nomb, apellido, dni, usuario, clave, fecha; 
		int tipoEmpl;
		
		nomb = getNombre();
		apellido = getApellido();
		dni = getDni();
		usuario = getUsuario();
		clave = getClave();
		fecha = getFechaNacimiento();
		tipoEmpl = getTipoEmpleado();
		
		if(nomb == null || apellido == null || dni == null || usuario == null || clave == null || fecha == null || tipoEmpl == 0){
			mensaje("Error en el Ingreso de datos");
		
		}else{
			// paso 4: Crear un objeto "u" de la clase "Usuario"
			Empleado empl = new Empleado();
			// paso 5: Setear (asignar valores a los atributos privados) usando las variables
			empl.setNombre(nomb);
			empl.setApellido(apellido);
			empl.setDni(dni);
			empl.setUsuario(usuario);
			empl.setContrasena(clave);
			empl.setFechaNacimiento(fecha);
			empl.setTipoEmpleado(tipoEmpl);
			
			int ok = gEd.registrar(empl);
			if( ok == 0 ){
				mensaje("Error en el registro");
			}else{
				lblMensaje.setVisible(true);
				//mensaje1("Registro exitoso");
				//cargarData();
			}
		}
	}
	private void mensaje(String mensaje) {
		JOptionPane.showMessageDialog(this, mensaje, "Sistema ", 1);
	}
	private int getTipoEmpleado() {
		int tipo;
		tipo = cboTipoEmpleado.getSelectedIndex();
		if( tipo == 0 )
			mensaje("Seleccionar el Tipo de Empleado");
		return tipo;
	}
	private String getFechaNacimiento() {
		String fecha = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		fecha= sdf.format(dcFechaNacimiento.getDate());
		return fecha;
	}
	private String getClave() {
		String clave = null;
		clave = String.valueOf(txtClave.getPassword());
		return clave;
	}
	private String getUsuario() {
		String user = null;
		if(txtUsuario.getText().trim().length() == 0)
			mensaje("Ingresar usuario");
		else if(txtUsuario.getText().trim().matches(Validaciones.USER) == false)
			mensaje("Formato incorrecto del Usuario, Ejemplo: U001");
		else
			user = txtUsuario.getText();
		return user;
	}
	private String getDni() {
		String dni = null;
		if(txtDni.getText().trim().length() == 0)
			mensaje("Ingresar Dni");
		else if(txtDni.getText().trim().matches(Validaciones.DNI) == false)
			mensaje("Formato incorrecto del Dni: Ingresar de 3 a 15 letras");
		else
			dni = txtDni.getText();
		return dni;
	}
	private String getApellido() {
		String apell = null;
		if(txtApellido.getText().trim().length() == 0)
			mensaje("Ingresar apellido");
		else if(txtApellido.getText().trim().matches(Validaciones.APELLIDO) == false)
			mensaje("Formato incorrecto del Apellido: Ingresar 8 digitos");
		else
			apell = txtApellido.getText();
		return apell;
	}
	private String getNombre() {
		String nomb = null;
		if(txtNombre.getText().trim().length() == 0)
			mensaje("Ingresar nombre");
		else if(txtNombre.getText().trim().matches(Validaciones.NOMBRE) == false)
			mensaje("Formato incorrecto del nombre: Ingresar de 3 a 15 letras");
		else
			nomb = txtNombre.getText();
		return nomb;
	}
	/** ------------------------------------------------------------------ **/
}
