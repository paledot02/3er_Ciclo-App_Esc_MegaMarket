package vista;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import controlador.GestionProveedorDAO;
import entidad.Proveedor;

import java.awt.Font;
import java.util.ArrayList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TranBuscarProveedor extends JPanel implements ActionListener {
	private JPanel panel;
	private JTable tblProveedores;
	private JButton btnOk;
	private JButton btnCancelar;
	private JScrollPane scrollPane;
	private JLabel lblNewLabel;
	
	// clase para modelarla tabla
		DefaultTableModel modelo = new DefaultTableModel();
		GestionProveedorDAO gPr = new GestionProveedorDAO();
		
		
	/**
	 * Create the panel.
	 */
	public TranBuscarProveedor() {
		setLayout(null);
		
		panel = new JPanel();
		panel.setBounds(0, 0, 450, 583);
		add(panel);
		panel.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 42, 430, 496);
		panel.add(scrollPane);
		
		tblProveedores = new JTable();
		tblProveedores.setFillsViewportHeight(true);
		scrollPane.setViewportView(tblProveedores);
		
		btnOk = new JButton("Ok");
		btnOk.addActionListener(this);
		btnOk.setBounds(252, 549, 89, 23);
		panel.add(btnOk);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(351, 549, 89, 23);
		panel.add(btnCancelar);
		
		lblNewLabel = new JLabel("Lista Proveedores");
		lblNewLabel.setFont(new Font("Courier New", Font.BOLD, 12));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(125, 11, 200, 20);
		panel.add(lblNewLabel);
		// tabla -------------------------
		modelo.addColumn("Id");
		modelo.addColumn("Razon Social");
		modelo.addColumn("Ruc");
		tblProveedores.setModel(modelo);
		// --------------------------------
		listado();
	}

	void listado(){
		ArrayList<Proveedor> listar = gPr.listar();
		modelo.setRowCount(0);
		for (Proveedor p : listar) {
			Object fila[] = {p.getIdProveedor(),
							 p.getRazonSocial(),
							 p.getRuc()};
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
		String id,empresa, ruc;
		
		fila = tblProveedores.getSelectedRow();
		// Obtener los datos de la fila
		id = tblProveedores.getValueAt(fila, 0).toString();
		empresa = tblProveedores.getValueAt(fila, 1).toString();
		ruc = tblProveedores.getValueAt(fila, 2).toString();
		// Enviar los datos formulario Boleta
		Transaccion.txtIdProveedor.setText(id);
		Transaccion.txtProEmpresa.setText(empresa);
		Transaccion.txtProRuc.setText(ruc);
	}
}

























































