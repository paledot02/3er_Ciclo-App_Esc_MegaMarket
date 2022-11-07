package vista;

import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controlador.GestionProductoDAO;
import controlador.GestionTransportistaDAO;
import entidad.Producto;
import entidad.Transportista;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;

public class AdminProductos extends JPanel implements ActionListener {
	
	DefaultTableModel model=new DefaultTableModel();
	GestionProductoDAO gp=new GestionProductoDAO();
	
	private JTable tblProductos;
	private JScrollPane scrollPane;
	private static JPanel panelReporteTranspo;
	private JLabel lblReporteT;
	private JButton btnEliminar;
	private JButton btnAgregar;
	
	public AdminProductos() {
		setLayout(null);
		
		panelReporteTranspo = new JPanel();
		panelReporteTranspo.setBounds(0, 0, 996, 609);
		panelReporteTranspo.setLayout(null);
		add(panelReporteTranspo);
		
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(720, 26, 89, 23);
		panelReporteTranspo.add(btnEliminar);
		
		btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(this);
		btnAgregar.setBounds(829, 26, 89, 23);
		panelReporteTranspo.add(btnAgregar);
		
		
		lblReporteT = new JLabel("  Lista Productos");
		lblReporteT.setBackground(SystemColor.inactiveCaption);
		lblReporteT.setFont(new Font("Segoe UI", Font.BOLD, 24));
		lblReporteT.setBounds(10, 11, 976, 51);
		panelReporteTranspo.add(lblReporteT);
		
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 73, 970, 519);
		panelReporteTranspo.add(scrollPane);
		
		tblProductos = new JTable();
		tblProductos.setFillsViewportHeight(true);
		scrollPane.setViewportView(tblProductos);
		
		tblProductos.setModel(model);
		

		model.addColumn("Codigo Producto");
		model.addColumn("Nombre Producto");
		model.addColumn("Fecha");
		model.addColumn("Stock");
		model.addColumn("Empresa");
		
		
		
		
		cargarData();

	}
	
	void cargarData() {
		model.setRowCount(0);
		ArrayList<Producto>data= gp.listar();
		for (Producto p : data) {
			Object fila[]= {p.getIdProducto(),
							p.getNombre(),
							p.getFecha(),
							p.getStock(),
							p.getEmpresa(),
							};
			model.addRow(fila);
			
		}
	}
	

	
	
	
	public void actionPerformed(ActionEvent arg0) {
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
		MostrarPanelPrincipal( new MantenimientoProductos());
		
	}
}
