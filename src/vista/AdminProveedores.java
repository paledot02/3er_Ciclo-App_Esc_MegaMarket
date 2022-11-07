package vista;

import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import controlador.GestionProveedorDAO;
import entidad.Proveedor;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class AdminProveedores extends JPanel implements ActionListener {
	
	DefaultTableModel model=new DefaultTableModel();
	GestionProveedorDAO gp= new GestionProveedorDAO();
	
	private static JPanel panelReporteProve;
	private JLabel lblReporteT;
	private JButton btnEliminar;
	private JButton btnAgregar;
	private JTable tblProveedor;
	private JScrollPane scrollPane;
	private JTextField txtBuscar;
	TextPrompt ph ;
	
	public AdminProveedores() {
		setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 73, 930, 466);
		add(scrollPane);
		
		tblProveedor = new JTable();
		tblProveedor.setFillsViewportHeight(true);
		scrollPane.setViewportView(tblProveedor);
		
		panelReporteProve = new JPanel();
		panelReporteProve.setBounds(0, 0, 950, 550);
		panelReporteProve.setLayout(null);
		add(panelReporteProve);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(this);
		btnEliminar.setBounds(720, 26, 89, 23);
		panelReporteProve.add(btnEliminar);
		
		btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(this);
		btnAgregar.setBounds(829, 26, 89, 23);
		panelReporteProve.add(btnAgregar);
		
		txtBuscar = new JTextField();
		txtBuscar.setBounds(327, 19, 306, 36);
		txtBuscar.setColumns(10);
		panelReporteProve.add(txtBuscar);
		ph = new TextPrompt("Eliminar por codigo",txtBuscar);
		
		lblReporteT = new JLabel(" Lista Proveedores");
		lblReporteT.setFont(new Font("Segoe UI", Font.BOLD, 24));
		lblReporteT.setBounds(0, 0, 950, 62);
		panelReporteProve.add(lblReporteT);
		
		
		
		model.addColumn("Codigo");
		model.addColumn("Razon Social");
		model.addColumn("Telefono");
		model.addColumn("Ruc");
		model.addColumn("Correo");
	
		tblProveedor.setModel(model);
		
		
		
		cargarData();

	}
	
	void cargarData() {
		model.setRowCount(0);
		ArrayList<Proveedor>data= gp.listar();
		for (Proveedor p : data) {
			Object fila[]= {p.getIdProveedor(),
							p.getRazonSocial(),
							p.getTelefono(),
							p.getRuc(),
							p.getCorreo()
							};
			model.addRow(fila);
			
		}
	}
	

	
	
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnEliminar) {
			actionPerformedBtnEliminar(arg0);
		}
		if (arg0.getSource() == btnAgregar) {
			actionPerformedBtnAgregar(arg0);
		}
	}
	static void MostrarPanelPrincipal(JPanel p) {
		
		p.setSize(RegistroMantenimientos.PanelMantenimientos.getWidth(),RegistroMantenimientos.PanelMantenimientos.getHeight());
		p.setLocation(0,0);
		RegistroMantenimientos.PanelMantenimientos.removeAll();
		RegistroMantenimientos.PanelMantenimientos.add(p);
		RegistroMantenimientos.PanelMantenimientos.revalidate();
		RegistroMantenimientos.PanelMantenimientos.repaint();
	}
	
	protected void actionPerformedBtnAgregar(ActionEvent arg0) {
		
		MostrarPanelPrincipal( new MantenimientoProveedores());
		
	}
	protected void actionPerformedBtnEliminar(ActionEvent arg0) {
		eliminarProveedores();
	}
	
	private void eliminarProveedores() {
		if(txtBuscar.getText().isEmpty()) {
			mensaje("Debe seleccionar un codigo");
			return;
		}
		int codigo, boton;
		codigo = Integer.parseInt(txtBuscar.getText());
		
		boton = JOptionPane.showConfirmDialog(this, "Seguro de eliminar? ", "Sistema", JOptionPane.YES_NO_OPTION);
			if (boton == 0) {
				int res = gp.eliminar(codigo);
				if (res == 0){
					mensaje("Error al eliminar");
				} else {
					mensaje1("Exito al eliminar");
					cargarData();

				}
			}
		}
		
	
	private void mensaje(String msj) {
		JOptionPane.showMessageDialog(this, msj, "Error", 0);
	}

	private void mensaje1(String msj) {
		JOptionPane.showMessageDialog(this, msj, "Sistema", 1);
	}
}
