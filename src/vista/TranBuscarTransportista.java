package vista;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import controlador.GestionProveedorDAO;
import controlador.GestionTransportistaDAO;
import entidad.Proveedor;
import entidad.Transportista;

import java.awt.Font;
import java.util.ArrayList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TranBuscarTransportista extends JPanel implements ActionListener {
	private JPanel panel;
	private JTable tblTransportistas;
	private JButton btnCancelar;
	private JButton btnOk;
	private JScrollPane scrollPane;
	private JLabel lblListaDeTransportistas;
	
	// clase para modelarla tabla
		DefaultTableModel modelo = new DefaultTableModel();
		GestionTransportistaDAO gTr = new GestionTransportistaDAO();
			
			
	/**
	 * Create the panel.
	 */
	public TranBuscarTransportista() {
		setLayout(null);
		
		panel = new JPanel();
		panel.setBounds(0, 0, 450, 583);
		add(panel);
		panel.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 42, 430, 496);
		panel.add(scrollPane);
		
		tblTransportistas = new JTable();
		tblTransportistas.setFillsViewportHeight(true);
		scrollPane.setViewportView(tblTransportistas);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(351, 549, 89, 23);
		panel.add(btnCancelar);
		
		btnOk = new JButton("Ok");
		btnOk.addActionListener(this);
		btnOk.setBounds(252, 549, 89, 23);
		panel.add(btnOk);
		
		lblListaDeTransportistas = new JLabel("Lista de Transportistas");
		lblListaDeTransportistas.setFont(new Font("Courier New", Font.BOLD, 12));
		lblListaDeTransportistas.setHorizontalAlignment(SwingConstants.CENTER);
		lblListaDeTransportistas.setBounds(125, 11, 200, 20);
		panel.add(lblListaDeTransportistas);
		
		// tabla -------------------------
		modelo.addColumn("Id");
		modelo.addColumn("Nombre");
		modelo.addColumn("Dni");
		tblTransportistas.setModel(modelo);
		// --------------------------------
		listado();

	}

	private void listado() {
		ArrayList<Transportista> listar = gTr.listar();
		modelo.setRowCount(0);
		for (Transportista p : listar) {
			Object fila[] = {p.getIdTransportista(),
							 p.getNombre()+" "+p.getApellidos(),
							 p.getDni()};
			modelo.addRow(fila);
		}
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnOk) {
			actionPerformedBtnOk(e);
		}
	}
	protected void actionPerformedBtnOk(ActionEvent e) {
		enviarDatos();
	}

	private void enviarDatos() {
		int fila;
		String nombre, dni;
		
		fila = tblTransportistas.getSelectedRow();
		// Obtener los datos de la fila
		nombre = tblTransportistas.getValueAt(fila, 1).toString();
		dni = tblTransportistas.getValueAt(fila, 2).toString();
		// Enviar los datos formulario Boleta
		Transaccion.txtTraNombre.setText(nombre);
		Transaccion.txtTraDni.setText(dni);
	}
}

























