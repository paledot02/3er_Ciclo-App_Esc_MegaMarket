package vista;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import controlador.GestionProductoDAO;
import controlador.GestionProveedorDAO;
import entidad.Producto;
import entidad.Proveedor;

import java.awt.Font;
import java.util.ArrayList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TranBuscarProducto extends JPanel implements ActionListener {
	private JPanel panel;
	private JTable tblProductos;
	private JButton btnCancelar;
	private JButton btnOk;
	private JScrollPane scrollPane;
	private JLabel lblListaDeProductos;

	// clase para modelarla tabla
	DefaultTableModel modelo = new DefaultTableModel();
	GestionProductoDAO gProd = new GestionProductoDAO();
	
	
	
	/**
	 * Create the panel.
	 */
	public TranBuscarProducto() {
		setLayout(null);
		
		panel = new JPanel();
		panel.setBounds(0, 0, 450, 583);
		add(panel);
		panel.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 42, 430, 496);
		panel.add(scrollPane);
		
		tblProductos = new JTable();
		tblProductos.setFillsViewportHeight(true);
		scrollPane.setViewportView(tblProductos);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(351, 549, 89, 23);
		panel.add(btnCancelar);
		
		btnOk = new JButton("Ok");
		btnOk.addActionListener(this);
		btnOk.setBounds(252, 549, 89, 23);
		panel.add(btnOk);
		
		lblListaDeProductos = new JLabel("Lista de Productos");
		lblListaDeProductos.setFont(new Font("Courier New", Font.BOLD, 12));
		lblListaDeProductos.setHorizontalAlignment(SwingConstants.CENTER);
		lblListaDeProductos.setBounds(125, 11, 200, 20);
		panel.add(lblListaDeProductos);

		// tabla -------------------------
		modelo.addColumn("Id");
		modelo.addColumn("Nombre");
		modelo.addColumn("fecha");
		modelo.addColumn("Stock");
		tblProductos.setModel(modelo);
		// --------------------------------
		listado();
		
	}
	private void listado() {
		
		ArrayList<Producto> listar = gProd.listar();
		modelo.setRowCount(0);
		for (Producto p : listar) {
			Object fila[] = {p.getIdProducto(),
							 p.getNombre(),
							 p.getFecha(),
							 p.getStock()};
			modelo.addRow(fila);
		}
	}
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnOk) {
			actionPerformedBtnOk(arg0);
		}
	}
	protected void actionPerformedBtnOk(ActionEvent arg0) {
		enviarDatos();
	}
	private void enviarDatos() {
		int fila;
		String id, nombre, fecha, stock;
		
		fila = tblProductos.getSelectedRow();
		// Obtener los datos de la fila
		id = tblProductos.getValueAt(fila, 0).toString();
		nombre = tblProductos.getValueAt(fila, 1).toString();
		fecha = tblProductos.getValueAt(fila, 2).toString();
		stock = tblProductos.getValueAt(fila, 3).toString();
		// Enviar los datos formulario Boleta
		Transaccion.txtProNombre.setText(nombre);
		Transaccion.txtProCodigo.setText(id);
		Transaccion.txtProStock.setText(stock);
		// Cerrar ventana actual
	}
	
}





















