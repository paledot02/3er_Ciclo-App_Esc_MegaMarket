package vista;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.JTextComponent;
import javax.swing.JSeparator;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Reportes extends JPanel {
	private JSeparator separator;
	private JTextField txtReporteProd;
	private JButton btnBuscar;
	private JLabel lblReportesDeProductos;
	private TextPrompt ph;
	private JTable table;
	private JScrollPane scrollPane;
	/**
	 * Create the panel.
	 */
	public Reportes() {
		setBackground(Color.WHITE);
		setLayout(null);
		
		separator = new JSeparator();
		separator.setForeground(Color.BLACK);
		separator.setBounds(87, 108, 452, 22);
		add(separator);
		
		txtReporteProd = new JTextField();
		txtReporteProd.setBorder(null);
		txtReporteProd.setBounds(87, 85, 209, 20);
		txtReporteProd.setColumns(10);
		new TextPrompt("Ingrese el ID del producto a buscar",txtReporteProd);
		add(txtReporteProd);
		
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(729, 78, 125, 35);
		add(btnBuscar);
		
		lblReportesDeProductos = new JLabel("Reporte de Productos");
		lblReportesDeProductos.setFont(new Font("Segoe UI", Font.BOLD, 24));
		lblReportesDeProductos.setBounds(25, 11, 316, 32);
		add(lblReportesDeProductos);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(25, 159, 708, 341);
		add(scrollPane);
		
		table = new JTable();
		table.setFillsViewportHeight(true);
		scrollPane.setViewportView(table);

	}
}
