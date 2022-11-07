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
import controlador.GestionTransportistaDAO;
import entidad.Transportista;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class AdminTransportistas extends JPanel implements ActionListener {
	
	DefaultTableModel model=new DefaultTableModel();
	GestionTransportistaDAO gt=new GestionTransportistaDAO();
	private JTable tblTransportistas;
	private JScrollPane scrollPane;
	private static JPanel panelReporteTranspo;
	private JLabel lblReporteT;
	private JButton btnEliminar;
	private JButton btnAgregar;
	private JTextField txtBuscar;
	TextPrompt ph ;
	
	public AdminTransportistas() {
		setLayout(null);
		
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 72, 930, 467);
		add(scrollPane);
		
		tblTransportistas = new JTable();
		tblTransportistas.setFillsViewportHeight(true);
		scrollPane.setViewportView(tblTransportistas);
		
		panelReporteTranspo = new JPanel();
		panelReporteTranspo.setBounds(0, 0, 950, 550);
		panelReporteTranspo.setLayout(null);
		add(panelReporteTranspo);
		
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(this);
		btnEliminar.setBounds(693, 26, 89, 23);
		panelReporteTranspo.add(btnEliminar);
		
		btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(this);
		btnAgregar.setBounds(808, 26, 89, 23);
		panelReporteTranspo.add(btnAgregar);

		txtBuscar = new JTextField();
		txtBuscar.setBounds(351, 19, 306, 36);
		txtBuscar.setColumns(10);
		ph= new TextPrompt("Eliminar por codigo",txtBuscar);
		panelReporteTranspo.add(txtBuscar);
		
		
		lblReporteT = new JLabel(" Lista Transportistas");
		lblReporteT.setFont(new Font("Segoe UI", Font.BOLD, 24));
		lblReporteT.setBounds(0, 0, 950, 62);
		panelReporteTranspo.add(lblReporteT);
		
		

		model.addColumn("Codigo");
		model.addColumn("Nombre");
		model.addColumn("Apellido");
		model.addColumn("Dni");
		model.addColumn("Empresa");
		model.addColumn("Correo");
		tblTransportistas.setModel(model);
		
		
		
		
		cargarData();

	}
	
	void cargarData() {
		model.setRowCount(0);
		ArrayList<Transportista>data= gt.listar();
		for (Transportista t : data) {
			Object fila[]= {t.getIdTransportista(),
							t.getNombre(),
							t.getApellidos(),
							t.getDni(),
							t.getEmpresa(),
							t.getCorreo()
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
		
		MostrarPanelPrincipal( new MantenimientoTransportista());
		
	}
	protected void actionPerformedBtnEliminar(ActionEvent arg0) {
		eliminarTransportista();
		
	}
	private void eliminarTransportista() {
		int codigo, boton;
		//FrmJugador j = new FrmJugador(0);
		codigo = Integer.parseInt(txtBuscar.getText());//j.getCodigo();
		boton = JOptionPane.showConfirmDialog(this, "Seguro de eliminar? ", "Sistema", JOptionPane.YES_NO_OPTION);

		if (boton == 0) {
			int res = gt.eliminar(codigo);
			if (res == 0) {
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
