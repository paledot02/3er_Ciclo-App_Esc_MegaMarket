package vista;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import controlador.GestionRecepcionProductoDAO;
import entidad.CabeceraReporteRecepcion;
import entidad.DetalleReporteRecepcion;

import javax.swing.JTextField;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.lang.reflect.GenericArrayType;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class Transaccion extends JPanel implements ActionListener {
	private JPanel panel;
	private JLabel lblReporteDeRecepcion;
	private JPanel panel_1;
	private JPanel panel_2;
	private JLabel lblNumeroReporte;
	private JTextField txtNumeroReporte;
	private JLabel lblFecha;
	private JTextField txtFechaActual;
	private JLabel lblEmpresa;
	private JLabel lblRuc;
	public static JTextField txtProEmpresa;
	public static JTextField txtProRuc;
	private JPanel panel_3;
	private JLabel lblNombre;
	private JLabel lblDni;
	public static JTextField txtTraNombre;
	public static JTextField txtTraDni;
	private JPanel panel_4;
	private JLabel label_1;
	private JLabel lblCantidad;
	public static JTextField txtProNombre;
	public static JTextField txtProCodigo;
	private JLabel lblMarca;
	public static JTextField txtProStock;
	private JLabel lblCantidadRecibida;
	private JTextField txtProRecibido;
	private JButton button;
	private JButton button_1;
	private JButton button_2;
	public static JPanel panelBuscarTransaccion; //  <----
	private JButton btnAgregar;
	private JTable tblLista;
	private JButton btnNewButton;
	private JButton btnFinalizarRecepcion;
	
	// Instanciar Objeto
	GestionRecepcionProductoDAO gRec = new GestionRecepcionProductoDAO();
	DefaultTableModel modelo = new DefaultTableModel();
	ArrayList<DetalleReporteRecepcion> detReporte = new ArrayList<DetalleReporteRecepcion>();
	private JScrollPane scrollPane;
	public static JTextField txtIdProveedor;
	
	
	
	/**
	 * Create the panel.
	 */
	public Transaccion() {
		setLayout(null);
		
		panel = new JPanel();
		panel.setBounds(0, 0, 996, 660);
		add(panel);
		panel.setLayout(null);
		
		lblReporteDeRecepcion = new JLabel("Reporte de Recepcion");
		lblReporteDeRecepcion.setHorizontalAlignment(SwingConstants.CENTER);
		lblReporteDeRecepcion.setFont(new Font("Segoe UI", Font.BOLD, 24));
		lblReporteDeRecepcion.setBounds(10, 11, 976, 34);
		panel.add(lblReporteDeRecepcion);
		
		panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Proveedor", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(10, 123, 506, 63);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		lblEmpresa = new JLabel("Empresa : ");
		lblEmpresa.setBounds(10, 31, 70, 14);
		panel_1.add(lblEmpresa);
		
		lblRuc = new JLabel("RUC : ");
		lblRuc.setBounds(203, 31, 70, 14);
		panel_1.add(lblRuc);
		
		txtProEmpresa = new JTextField();
		txtProEmpresa.setEditable(false);
		txtProEmpresa.setBounds(74, 28, 119, 20);
		panel_1.add(txtProEmpresa);
		txtProEmpresa.setColumns(10);
		
		txtProRuc = new JTextField();
		txtProRuc.setEditable(false);
		txtProRuc.setBounds(238, 28, 119, 20);
		panel_1.add(txtProRuc);
		txtProRuc.setColumns(10);
		
		button = new JButton("");
		button.addActionListener(this);
		button.setIcon(new ImageIcon(Transaccion.class.getResource("/img/buscar 32.png")));
		button.setBackground(SystemColor.inactiveCaption);
		button.setBounds(401, 13, 32, 32);
		panel_1.add(button);
		
		txtIdProveedor = new JTextField();
		txtIdProveedor.setEditable(false);
		txtIdProveedor.setVisible(false);
		txtIdProveedor.setBounds(367, 28, 17, 20);
		panel_1.add(txtIdProveedor);
		txtIdProveedor.setColumns(10);
		
		panel_2 = new JPanel();
		//panel_2.setBackground(SystemColor.inactiveCaption);
		panel_2.setBorder(new TitledBorder(null, "Datos", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(10, 56, 506, 56);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		lblNumeroReporte = new JLabel("Numero Reporte :");
		lblNumeroReporte.setBounds(10, 23, 100, 14);
		panel_2.add(lblNumeroReporte);
		
		txtNumeroReporte = new JTextField();
		txtNumeroReporte.setHorizontalAlignment(SwingConstants.CENTER);
		//textField.setBackground(SystemColor.inactiveCaption);
		txtNumeroReporte.setEditable(false);
		txtNumeroReporte.setBounds(120, 20, 105, 20);
		panel_2.add(txtNumeroReporte);
		txtNumeroReporte.setColumns(10);
		
		lblFecha = new JLabel("Fecha : ");
		lblFecha.setBounds(248, 23, 46, 14);
		panel_2.add(lblFecha);
		
		txtFechaActual = new JTextField();
		txtFechaActual.setHorizontalAlignment(SwingConstants.CENTER);
		//textField_1.setBackground(SystemColor.inactiveCaption);
		txtFechaActual.setEditable(false);
		txtFechaActual.setBounds(304, 20, 105, 20);
		panel_2.add(txtFechaActual);
		txtFechaActual.setColumns(10);
		
		panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Transportista", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_3.setBounds(10, 197, 506, 63);
		panel.add(panel_3);
		
		lblNombre = new JLabel("Nombre : ");
		lblNombre.setBounds(10, 31, 70, 14);
		panel_3.add(lblNombre);
		
		lblDni = new JLabel("Dni : ");
		lblDni.setBounds(203, 31, 70, 14);
		panel_3.add(lblDni);
		
		txtTraNombre = new JTextField();
		txtTraNombre.setEditable(false);
		txtTraNombre.setColumns(10);
		txtTraNombre.setBounds(74, 28, 119, 20);
		panel_3.add(txtTraNombre);
		
		txtTraDni = new JTextField();
		txtTraDni.setEditable(false);
		txtTraDni.setColumns(10);
		txtTraDni.setBounds(235, 28, 119, 20);
		panel_3.add(txtTraDni);
		
		button_1 = new JButton("");
		button_1.addActionListener(this);
		button_1.setIcon(new ImageIcon(Transaccion.class.getResource("/img/buscar 32.png")));
		button_1.setBackground(SystemColor.inactiveCaption);
		button_1.setBounds(401, 13, 32, 32);
		panel_3.add(button_1);
		
		panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Producto", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_4.setBounds(10, 271, 506, 95);
		panel.add(panel_4);
		
		label_1 = new JLabel("Nombre : ");
		label_1.setBounds(10, 31, 70, 14);
		panel_4.add(label_1);
		
		lblCantidad = new JLabel("Codigo : ");
		lblCantidad.setBounds(203, 31, 70, 14);
		panel_4.add(lblCantidad);
		
		txtProNombre = new JTextField();
		txtProNombre.setEditable(false);
		txtProNombre.setColumns(10);
		txtProNombre.setBounds(74, 28, 119, 20);
		panel_4.add(txtProNombre);
		
		txtProCodigo = new JTextField();
		txtProCodigo.setEditable(false);
		txtProCodigo.setColumns(10);
		txtProCodigo.setBounds(248, 28, 119, 20);
		panel_4.add(txtProCodigo);
		
		lblMarca = new JLabel("Stock : ");
		lblMarca.setBounds(10, 62, 70, 14);
		panel_4.add(lblMarca);
		
		txtProStock = new JTextField();
		txtProStock.setEditable(false);
		txtProStock.setColumns(10);
		txtProStock.setBounds(74, 59, 54, 20);
		panel_4.add(txtProStock);
		
		lblCantidadRecibida = new JLabel("Cantidad Recibida: ");
		lblCantidadRecibida.setBounds(150, 62, 120, 14);
		panel_4.add(lblCantidadRecibida);
		
		txtProRecibido = new JTextField();
		txtProRecibido.setColumns(10);
		txtProRecibido.setBounds(268, 59, 54, 20);
		panel_4.add(txtProRecibido);
		
		button_2 = new JButton("");
		button_2.addActionListener(this);
		button_2.setIcon(new ImageIcon(Transaccion.class.getResource("/img/buscar 32.png")));
		button_2.setBackground(SystemColor.inactiveCaption);
		button_2.setBounds(401, 13, 32, 32);
		panel_4.add(button_2);
		
		btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(this);
		btnAgregar.setBounds(401, 58, 89, 23);
		panel_4.add(btnAgregar);
		
		panelBuscarTransaccion = new JPanel();
		panelBuscarTransaccion.setBackground(SystemColor.text);
		panelBuscarTransaccion.setBounds(526, 56, 450, 583);
		panel.add(panelBuscarTransaccion);
		panelBuscarTransaccion.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 377, 506, 228);
		panel.add(scrollPane);
		
		tblLista = new JTable();
		tblLista.setFillsViewportHeight(true);
		scrollPane.setViewportView(tblLista);
		
		btnNewButton = new JButton("Nueva Recepcion");
		btnNewButton.addActionListener(this);
		btnNewButton.setBounds(10, 616, 145, 23);
		panel.add(btnNewButton);
		
		btnFinalizarRecepcion = new JButton("Finalizar Recepcion");
		btnFinalizarRecepcion.addActionListener(this);
		btnFinalizarRecepcion.setBounds(371, 616, 145, 23);
		panel.add(btnFinalizarRecepcion);
		
		// Modificar el numero de reporte en el Label
		txtNumeroReporte.setText(gRec.generarNumeroReporteRecepcion());
		// Colocar la fecha
		Date fecha = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		txtFechaActual.setText(sdf.format(fecha));
		// --------------------------------------------------------
		// tabla
		modelo.addColumn("CodProducto");
		modelo.addColumn("Producto");
		modelo.addColumn("Cantidad Recibida");
		tblLista.setModel(modelo);
		
	}
	
	static void MostrarPanelBusquedaTransaccion(JPanel p) {
		
		p.setSize(panelBuscarTransaccion.getWidth(),panelBuscarTransaccion.getHeight());
		p.setLocation(0,0);
		panelBuscarTransaccion.removeAll();
		panelBuscarTransaccion.add(p);
		panelBuscarTransaccion.revalidate();
		panelBuscarTransaccion.repaint();
	}
	
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnNewButton) {
			actionPerformedBtnNewButton(arg0);
		}
		if (arg0.getSource() == btnFinalizarRecepcion) {
			actionPerformedBtnFinalizarRecepcion(arg0);
		}
		if (arg0.getSource() == btnAgregar) {
			actionPerformedBtnAgregar(arg0);
		}
		if (arg0.getSource() == button_2) {
			actionPerformedButton_2(arg0);
		}
		if (arg0.getSource() == button_1) {
			actionPerformedButton_1(arg0);
		}
		if (arg0.getSource() == button) {
			actionPerformedButton(arg0);
		}
	}
	protected void actionPerformedButton(ActionEvent arg0) {
		MostrarPanelBusquedaTransaccion(new TranBuscarProveedor());
	}
	protected void actionPerformedButton_1(ActionEvent arg0) {
		MostrarPanelBusquedaTransaccion(new TranBuscarTransportista());
	}
	protected void actionPerformedButton_2(ActionEvent arg0) {
		MostrarPanelBusquedaTransaccion(new TranBuscarProducto());
	}
	// Agregar Producto
	protected void actionPerformedBtnAgregar(ActionEvent arg0) {
		agregarProductos();
	}
	private void agregarProductos() {
		int cantidadRec;
		String nomProducto, codProd;
		// Obtener los datos
		codProd = leerCodProd();
		cantidadRec = leerCantidad();
		nomProducto = leerNombreProducto();
		
		// Mostrar en la tabla
		Object fila[] = {codProd, nomProducto, cantidadRec};
		
		modelo.addRow(fila);
		// Agregar datos a la clase Detalle Boleta
		DetalleReporteRecepcion d = new DetalleReporteRecepcion(null, codProd, cantidadRec);
		detReporte.add(d);
		
	}
	private String leerNombreProducto() {
		return txtProNombre.getText();}
	private int leerCantidad() {
		return Integer.parseInt(txtProRecibido.getText());}
	private String leerCodProd() {
		return txtProCodigo.getText();}
	
	// Finalizar Reporte de Transaccion
	protected void actionPerformedBtnFinalizarRecepcion(ActionEvent arg0) {
		finalizarRecepcion();
	}
	private void finalizarRecepcion() {
		String numReporte = obtenerNumReporte();
		String fecha = obtenerFecha();
		int codCliete = leerCodProveedor();
		String codVendedor = obtenerDniTransportista();
		
		CabeceraReporteRecepcion cabReporte = new CabeceraReporteRecepcion(numReporte, fecha, codCliete, codVendedor);
		
		// Obtener el resultado del método transaccional
		int ok = gRec.realizarRecepcionProducto(cabReporte, detReporte);
		// validar el resultado de la transacción
		if(ok == 0){
			mensaje("Error en la transaccion");
			detReporte.clear();
		}else{
			mensaje("Transaccion Exitosa : " + "\n" + "Datos Insertados en Cabecera Reporte" + "\n" + "Datos Insertados en Detalles Reporte" + "\n" + "Cantidad de Productos Actualizados");
		}
	}
	private String obtenerDniTransportista() {
		return txtTraDni.getText();
	}
	private int leerCodProveedor() {
		return Integer.parseInt(txtIdProveedor.getText());
	}
	private String obtenerFecha() {
		return txtFechaActual.getText();
	}
	private String obtenerNumReporte() {
		return txtNumeroReporte.getText();
	}
	private void mensaje(String mensj) {
		JOptionPane.showMessageDialog(this, mensj, "Sistema", 1);
	}
	protected void actionPerformedBtnNewButton(ActionEvent arg0) {
		nuevoReporteRecepcion();
	}
	private void nuevoReporteRecepcion() {
		txtNumeroReporte.setText(gRec.generarNumeroReporteRecepcion());
		txtProEmpresa.setText("");
		txtProRuc.setText("");
		txtIdProveedor.setText("");
		txtTraNombre.setText("");
		txtTraDni.setText("");
		txtProNombre.setText("");
		txtProCodigo.setText("");
		txtProStock.setText("");
		txtProRecibido.setText("");
		modelo.setRowCount(0);
		detReporte.clear();
	}
	
}







































