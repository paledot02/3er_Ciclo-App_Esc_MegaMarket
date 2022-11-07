package vista;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class Opciones extends JPanel implements ActionListener, MouseListener {
	private JButton btnPrincipal;
	private JButton btnMantenimiento;
	private JButton btnReportes;
	private JButton btnTransacciones;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private static JLabel lblNewLabel_4;
	private static JLabel lblNewLabel_5;
	private static JLabel lblNewLabel_6;
	private static JLabel lblNewLabel_7;
	private JButton btnSalir;
	private JLabel lblUser;
	private JLabel lblNewLabel_8;
	private JLabel lblNewLabel_9;
	private JPanel panel;
	private JPanel panel_1;
	private JLabel lblNewLabel_10;
	

	
	public Opciones() {
		setBackground(new Color(13, 71, 161));
		setLayout(null);
		setBackground(new Color(19, 91, 172));
		
		panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(0, 0, 334, 835);
		add(panel);
		panel.setLayout(null);
		
		btnSalir = new JButton("Salir");
		btnSalir.setBounds(123, 572, 87, 45);
		panel.add(btnSalir);
		btnSalir.addMouseListener(this);
		btnSalir.addActionListener(this);
		btnSalir.setForeground(Color.WHITE);
		btnSalir.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		btnSalir.setFocusPainted(false);
		btnSalir.setBorderPainted(false);
		btnSalir.setBorder(null);
		btnSalir.setBackground(new Color(19, 91, 172));
		
		lblUser = new JLabel("");
		lblUser.setBounds(10, 35, 80, 80);
		panel.add(lblUser);
		lblUser.setIcon(new ImageIcon(Opciones.class.getResource("/img/user 80.png")));
		
		lblNewLabel_8 = new JLabel(tipoEmpleado());
		lblNewLabel_8.setBounds(104, 55, 200, 20);
		panel.add(lblNewLabel_8);
		lblNewLabel_8.setFont(new Font("Monospaced", Font.BOLD, 16));
		lblNewLabel_8.setForeground(Color.WHITE);
		
		lblNewLabel_9 = new JLabel(Login.e.getNombre() + " " + Login.e.getApellido());
		lblNewLabel_9.setBounds(104, 83, 248, 20);
		panel.add(lblNewLabel_9);
		lblNewLabel_9.setFont(new Font("Monospaced", Font.BOLD, 16));
		lblNewLabel_9.setForeground(Color.WHITE);
		
		panel_1 = new JPanel();
		panel_1.setBackground(Color.DARK_GRAY);
		panel_1.setBounds(0, 188, 334, 340);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		btnPrincipal = new JButton("Principal");
		btnPrincipal.setBounds(55, 27, 224, 51);
		panel_1.add(btnPrincipal);
		btnPrincipal.addActionListener(this);
		btnPrincipal.setFocusPainted(false);
		btnPrincipal.addMouseListener(this);
		btnPrincipal.setForeground(Color.WHITE);
		btnPrincipal.setBorder(null);
		btnPrincipal.setBackground(new Color(18, 90, 173));
		btnPrincipal.setFont(new Font("Segoe UI", Font.BOLD, 17));
		////////////////
		lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setBounds(293, 44, 24, 24);
		panel_1.add(lblNewLabel_4);
		lblNewLabel_4.setVisible(false);
		lblNewLabel_4.setIcon(new ImageIcon(Opciones.class.getResource("/img/home-outline.png")));
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(17, 44, 24, 24);
		panel_1.add(lblNewLabel);
		lblNewLabel.setIcon(new ImageIcon(Opciones.class.getResource("/img/home-outline.png")));
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(17, 122, 24, 24);
		panel_1.add(lblNewLabel_1);
		lblNewLabel_1.setIcon(new ImageIcon(Opciones.class.getResource("/img/book-open-page-variant.png")));
		
		btnMantenimiento = new JButton("Mantenimiento");
		btnMantenimiento.setBounds(55, 105, 224, 51);
		panel_1.add(btnMantenimiento);
		btnMantenimiento.addMouseListener(this);
		btnMantenimiento.setFocusPainted(false);
		btnMantenimiento.setBorderPainted(false);
		btnMantenimiento.setBorder(null);
		btnMantenimiento.setForeground(Color.WHITE);
		btnMantenimiento.addActionListener(this);
		btnMantenimiento.setBackground(new Color(18, 90, 173));
		btnMantenimiento.setFont(new Font("Segoe UI", Font.BOLD, 17));
		
		lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setBounds(293, 122, 24, 24);
		panel_1.add(lblNewLabel_5);
		lblNewLabel_5.setVisible(false);
		lblNewLabel_5.setIcon(new ImageIcon(Opciones.class.getResource("/img/book-open-page-variant.png")));
		
		lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setBounds(293, 200, 24, 24);
		panel_1.add(lblNewLabel_6);
		lblNewLabel_6.setVisible(false);
		lblNewLabel_6.setIcon(new ImageIcon(Opciones.class.getResource("/img/file-chart.png")));
		
		btnReportes = new JButton("Reportes");
		btnReportes.setBounds(55, 183, 224, 51);
		panel_1.add(btnReportes);
		btnReportes.addMouseListener(this);
		btnReportes.setFocusPainted(false);
		btnReportes.setForeground(Color.WHITE);
		btnReportes.setBorderPainted(false);
		btnReportes.setBorder(null);
		btnReportes.setBackground(new Color(19, 91, 172));
		btnReportes.addActionListener(this);
		btnReportes.setFont(new Font("Segoe UI", Font.BOLD, 17));
		
		lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(17, 200, 24, 24);
		panel_1.add(lblNewLabel_2);
		lblNewLabel_2.setIcon(new ImageIcon(Opciones.class.getResource("/img/file-chart.png")));
		
		lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setBounds(17, 278, 24, 24);
		panel_1.add(lblNewLabel_3);
		lblNewLabel_3.setIcon(new ImageIcon(Opciones.class.getResource("/img/calendar-multiple-check.png")));
		
		btnTransacciones = new JButton("Transacciones");
		btnTransacciones.addActionListener(this);
		btnTransacciones.setBounds(55, 261, 224, 51);
		panel_1.add(btnTransacciones);
		btnTransacciones.addMouseListener(this);
		btnTransacciones.setFocusPainted(false);
		btnTransacciones.setForeground(Color.WHITE);
		btnTransacciones.setBorderPainted(false);
		btnTransacciones.setBorder(null);
		btnTransacciones.setBackground(new Color(19, 91, 172));
		btnTransacciones.setFont(new Font("Segoe UI", Font.BOLD, 17));
		
		lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setBounds(293, 278, 24, 24);
		panel_1.add(lblNewLabel_7);
		lblNewLabel_7.setVisible(false);
		lblNewLabel_7.setIcon(new ImageIcon(Opciones.class.getResource("/img/calendar-multiple-check.png")));
		
		lblNewLabel_10 = new JLabel("");
		lblNewLabel_10.setIcon(new ImageIcon(Opciones.class.getResource("/img/megamarket 100.png")));
		lblNewLabel_10.setBounds(21, 724, 100, 100);
		panel.add(lblNewLabel_10);

	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnTransacciones) {
			actionPerformedBtnTransacciones(e);
		}
		if (e.getSource() == btnSalir) {
			actionPerformedBtnSalir(e);
		}
		if (e.getSource() == btnPrincipal) {
			actionPerformedBtnPrincipal(e);
		}
		if (e.getSource() == btnReportes) {
			actionPerformedBtnReportes(e);
		}
		if (e.getSource() == btnMantenimiento) {
			actionPerformedBtnMantenimiento(e);
		}
	}
	protected void actionPerformedBtnMantenimiento(ActionEvent e) {
		
		FrmMenuPrincipal.MostrarPanelPrincipal(new RegistroMantenimientos());
		
	}
	protected void actionPerformedBtnReportes(ActionEvent e) {
		FrmMenuPrincipal.MostrarPanelPrincipal(new Reportes());
	}
	public void mouseClicked(MouseEvent arg0) {
	}
	public void mouseEntered(MouseEvent arg0) {
		if (arg0.getSource() == btnSalir) {
			mouseEnteredBtnSalir(arg0);
		}
		if (arg0.getSource() == btnTransacciones) {
			mouseEnteredBtnTransacciones(arg0);
		}
		if (arg0.getSource() == btnReportes) {
			mouseEnteredBtnReportes(arg0);
		}
		if (arg0.getSource() == btnMantenimiento) {
			mouseEnteredBtnMantenimiento(arg0);
		}
		if (arg0.getSource() == btnPrincipal) {
			mouseEnteredBtnPrincipal(arg0);
		}
	}
	public void mouseExited(MouseEvent arg0) {
		btnPrincipal.setBackground(new Color(18, 90, 173));
		btnMantenimiento.setBackground(new Color(18, 90, 173));
		btnReportes.setBackground(new Color(18, 90, 173));
		btnTransacciones.setBackground(new Color(18, 90, 173));
		btnSalir.setBackground(new Color(18, 90, 173));
		
	}
	public void mousePressed(MouseEvent arg0) {
	}
	public void mouseReleased(MouseEvent arg0) {
	}
	protected void mouseEnteredBtnPrincipal(MouseEvent arg0) {
		btnPrincipal.setBackground(new Color(1, 65, 102));
	}
	protected void mouseEnteredBtnMantenimiento(MouseEvent arg0) {
		btnMantenimiento.setBackground(new Color(1, 65, 102));
	}
	protected void mouseEnteredBtnReportes(MouseEvent arg0) {
		btnReportes.setBackground(new Color(1, 65, 102));
	}
	protected void mouseEnteredBtnTransacciones(MouseEvent arg0) {
		btnTransacciones.setBackground(new Color(1, 65, 102));
	}
	
	public static void mostrarIconos(boolean estado) {
		
		lblNewLabel_4.setVisible(estado);
		lblNewLabel_5.setVisible(estado);
		lblNewLabel_6.setVisible(estado);
		lblNewLabel_7.setVisible(estado);
		
		
	}
	protected void actionPerformedBtnPrincipal(ActionEvent e) {
		FrmMenuPrincipal.MostrarPanelPrincipal(new Principal());
	}
	protected void actionPerformedBtnSalir(ActionEvent e) {
		FrmMenuPrincipal.MostrarPanelPrincipal(new Principal());
		FrmMenuPrincipal.MostrarPanel(new Login());
		FrmMenuPrincipal.btnop.setVisible(false);
	}
	protected void mouseEnteredBtnSalir(MouseEvent arg0) {
		btnSalir.setBackground(new Color(1,65,102));
	}
	public String tipoEmpleado(){
		String tipo = null;
		switch (Login.e.getTipoEmpleado()) {
		case 1: tipo = "Trabajador";
			break;
		default: tipo = "Administrador";
			break;
		}
		return tipo;
	}
	protected void actionPerformedBtnTransacciones(ActionEvent e) {
		FrmMenuPrincipal.MostrarPanelPrincipal(new Transaccion());
	}
}
