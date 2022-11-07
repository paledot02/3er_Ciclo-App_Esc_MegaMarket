package vista;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.border.SoftBevelBorder;

import controlador.GestionEmpleadoDAO;
import entidad.Empleado;

import javax.swing.border.BevelBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;

public class Login extends JPanel implements ActionListener {
	private JPanel panelLogin;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JSeparator separator;
	private JPasswordField txtClave;
	private JTextField txtUsuario;
	private JLabel lblNewLabel_2;
	private JSeparator separator_1;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JButton btnEntrar;
	/////////////////////////////////
	GestionEmpleadoDAO gE = new GestionEmpleadoDAO();
	public static Empleado e = new Empleado();
	private JButton btnRegistrarse;
	
	
	/**
	 * Create the panel.
	 */
	public Login() {
		setLayout(null);
		
		panelLogin = new JPanel();
		panelLogin.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, new Color(160, 160, 160), new Color(160, 160, 160)));
		panelLogin.setLayout(null);
		panelLogin.setBackground(Color.WHITE);
		panelLogin.setBounds(0, 0, 334, 835);
		add(panelLogin);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Login.class.getResource("/img/usuario.png")));
		lblNewLabel.setBounds(114, 51, 106, 112);
		panelLogin.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Usuario");
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(39, 226, 84, 22);
		panelLogin.add(lblNewLabel_1);
		
		separator = new JSeparator();
		separator.setForeground(Color.BLACK);
		separator.setBounds(39, 295, 256, 40);
		panelLogin.add(separator);
		
		txtClave = new JPasswordField();
		txtClave.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtClave.setBorder(null);
		txtClave.setBounds(73, 387, 162, 30);
		panelLogin.add(txtClave);
		
		txtUsuario = new JTextField();
		txtUsuario.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtUsuario.setToolTipText("");
		txtUsuario.setName("");
		txtUsuario.setColumns(10);
		txtUsuario.setBorder(null);
		txtUsuario.setBounds(73, 265, 162, 30);
		panelLogin.add(txtUsuario);
		
		lblNewLabel_2 = new JLabel("Contrase\u00F1a");
		lblNewLabel_2.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(39, 351, 84, 22);
		panelLogin.add(lblNewLabel_2);
		
		separator_1 = new JSeparator();
		separator_1.setForeground(Color.BLACK);
		separator_1.setBounds(39, 418, 256, 40);
		panelLogin.add(separator_1);
		
		lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setBounds(43, 263, 32, 32);
		panelLogin.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setBounds(43, 411, 32, 32);
		panelLogin.add(lblNewLabel_4);
		
		btnEntrar = new JButton("Entrar");
		btnEntrar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnEntrar.addActionListener(this);
		btnEntrar.setBounds(31, 480, 120, 50);
		panelLogin.add(btnEntrar);
		
		btnRegistrarse = new JButton("Registrarse");
		btnRegistrarse.addActionListener(this);
		btnRegistrarse.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnRegistrarse.setBounds(182, 480, 120, 50);
		panelLogin.add(btnRegistrarse);

	}
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnRegistrarse) {
			actionPerformedBtnRegistrarse(arg0);
		}
		if (arg0.getSource() == btnEntrar) {
			actionPerformedBtnEntrar(arg0);
		}
	}
	
	protected void actionPerformedBtnEntrar(ActionEvent arg0) {
		validarAcceso();
	}
	private void validarAcceso() {
		String user, clave;
		user = getUsuario();
		clave = getClave();
		// Validar si existe el usuario en la BD
		e = gE.validarAcceso(user, clave);
		if(e == null){
			mensaje("Usuario y/o password incorrecto");
		}else{ // Existe el usuario en la BD
			//FrmPreLoader pre = new FrmPreLoader();
			FrmMenuPrincipal.MostrarPanel(new Opciones());
			FrmMenuPrincipal.MostrarPanelPrincipal(new Principal());
			FrmMenuPrincipal.btnop.setVisible(true);
		}
	}
	private void mensaje(String mensaje) {
		JOptionPane.showMessageDialog(this, mensaje, "Error", 1);
	}
	private String getClave() {
		String clave = null;
		clave = String.valueOf(txtClave.getText());
		return clave;
	}
	private String getUsuario() {
		String user = null;
		user = txtUsuario.getText();
		return user;
	}
	protected void actionPerformedBtnRegistrarse(ActionEvent arg0) {
		FrmMenuPrincipal.MostrarPanel(new RegisTrabajador());
	}
}
