package vista;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Component;
import java.awt.Rectangle;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RegistroMantenimientos extends JPanel implements ActionListener {
	private JButton btnNewButton;
	private JButton btnProveedores;
	private JButton btnProductos;
	public static JPanel PanelMantenimientos;
	private JPanel panel;
	
	
	public RegistroMantenimientos() {
		setBackground(Color.WHITE);
		setLayout(null);
		
		panel = new JPanel();
		panel.setBounds(0, 0, 996, 660);
		add(panel);
		panel.setLayout(null);
		
		btnProveedores = new JButton("Proveedores");
		btnProveedores.setBounds(0, 0, 332, 51);
		panel.add(btnProveedores);
		btnProveedores.addActionListener(this);
		btnProveedores.setFont(new Font("Segoe UI", Font.BOLD, 18));
		
		btnNewButton = new JButton("Transportista");
		btnNewButton.setBounds(332, 0, 332, 51);
		panel.add(btnNewButton);
		btnNewButton.addActionListener(this);
		btnNewButton.setFont(new Font("Segoe UI", Font.BOLD, 18));
		
		btnProductos = new JButton("Productos");
		btnProductos.setBounds(664, 0, 332, 51);
		panel.add(btnProductos);
		btnProductos.addActionListener(this);
		btnProductos.setFont(new Font("Segoe UI", Font.BOLD, 18));
		
		PanelMantenimientos = new JPanel();
		PanelMantenimientos.setBounds(0, 51, 996, 609);
		panel.add(PanelMantenimientos);
		PanelMantenimientos.setLayout(null);
		
	}
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnProductos) {
			actionPerformedBtnProductos(arg0);
		}
		if (arg0.getSource() == btnProveedores) {
			actionPerformedBtnProveedores(arg0);
		}
		if (arg0.getSource() == btnNewButton) {
			actionPerformedBtnNewButton(arg0);
		}
		
	}
	static void MostrarPanelPrincipal(JPanel p) {
		
		p.setSize(PanelMantenimientos.getWidth(),PanelMantenimientos.getHeight());
		p.setLocation(0,0);
		PanelMantenimientos.removeAll();
		PanelMantenimientos.add(p);
		PanelMantenimientos.revalidate();
		PanelMantenimientos.repaint();
	}
	protected void actionPerformedBtnNewButton(ActionEvent arg0) {
		//MostrarPanelPrincipal( new MantenimientoTransportista());
		MostrarPanelPrincipal(new AdminTransportistas());
	}
	protected void actionPerformedBtnProveedores(ActionEvent arg0) {
		//MostrarPanelPrincipal(new MantenimientoProveedores());
		MostrarPanelPrincipal(new AdminProveedores());
	}
	protected void actionPerformedBtnProductos(ActionEvent arg0) {
		//MostrarPanelPrincipal(new MantenimientoProductos());
		MostrarPanelPrincipal(new AdminProductos());
		
		
	}
}
