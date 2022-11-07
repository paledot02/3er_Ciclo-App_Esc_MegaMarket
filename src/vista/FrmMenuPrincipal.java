package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.border.SoftBevelBorder;

import Animacion.Animacion;

import javax.swing.border.BevelBorder;
import java.awt.Color;
import javax.swing.border.EtchedBorder;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import javax.swing.JSeparator;
import java.awt.SystemColor;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class FrmMenuPrincipal extends JFrame implements ActionListener {

	private JPanel contentPane;
	public static JPanel panelLogin;
	public static JButton btnop;
	public static JPanel panelPrincipal;
	private JPanel panelHora;
	private JLabel lblHora;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmMenuPrincipal frame = new FrmMenuPrincipal();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrmMenuPrincipal() {
		setResizable(false);
		setLocationByPlatform(true);
		setBackground(new Color(255, 102, 102));
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1336, 864);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EtchedBorder(EtchedBorder.RAISED, Color.GRAY, Color.GRAY));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnop = new JButton("");
		btnop.setVisible(false);
		btnop.setBounds(280, 0, 54, 51);
		getContentPane().add(btnop);
		btnop.addActionListener(this);
		btnop.setIcon(new ImageIcon(FrmMenuPrincipal.class.getResource("/img/icons8_Menu_32px.png")));
		
		panelLogin = new JPanel();
		panelLogin.setBackground(SystemColor.window);
		panelLogin.setBounds(0, 0, 334, 835);
		contentPane.add(panelLogin);
		panelLogin.setLayout(null);
		
		Login lp = new Login();
		MostrarPanel(lp);
		
		
		
		panelPrincipal = new JPanel();
		panelPrincipal.setBackground(new Color(240,240,240));
		panelPrincipal.setBounds(334, 175, 996, 660);
		contentPane.add(panelPrincipal);
		panelPrincipal.setLayout(null);
		
		panelHora = new JPanel();
		panelHora.setBackground(new Color(24, 118, 208));
		panelHora.setBounds(334, 0, 996, 175);
		contentPane.add(panelHora);
		panelHora.setLayout(null);
		
		lblHora = new JLabel("");
		lblHora.setForeground(Color.WHITE);
		lblHora.setFont(new Font("Segoe UI", Font.PLAIN, 23));
		lblHora.setBounds(552, 106, 434, 58);
		panelHora.add(lblHora);
		Hora();
	}
	
	
	
	public void actionPerformed(ActionEvent arg0) {
		
		if (arg0.getSource() == btnop) {
			actionPerformedBtnop(arg0);
		}
	}
	
	
	protected void actionPerformedBtnop(ActionEvent arg0) {
		int pos= btnop.getX();
		if(pos>0) {
			Animacion.mover_izquierda(336, 0, 2, 2, btnop);
			Animacion.mover_izquierda(0,-280, 2, 2, panelLogin);

			panelHora.setLocation(54,0);
			panelHora.setSize(1276,175);
			panelPrincipal.setLocation(54,175);
			panelPrincipal.setSize(1276,660);
			lblHora.setLocation(832, 106);
			
			
			Opciones.mostrarIconos(true);
			
		}else {
			Animacion.mover_derecha(0, 280, 2, 2, btnop);
			Animacion.mover_derecha(-334, 0, 2, 2, panelLogin);	
			panelHora.setLocation(334,0);
			panelHora.setSize(996,175);
			panelPrincipal.setLocation(334,175);
			panelPrincipal.setSize(996,660);
			lblHora.setLocation(552, 106);
			
			Opciones.mostrarIconos(false);
		}
	}
	
	static void MostrarPanel(JPanel p) {
		
		p.setSize(334,835);
		p.setLocation(0,0);
		panelLogin.removeAll();
		panelLogin.add(p);
		panelLogin.revalidate();
		panelLogin.repaint();
	}
	static void MostrarPanelPrincipal(JPanel p) {
		int sizePanelH = panelPrincipal.getHeight();
		int sizePanelW = panelPrincipal.getWidth();
		p.setSize(sizePanelW,sizePanelH);
		p.setLocation(0,0);
		panelPrincipal.removeAll();
		panelPrincipal.add(p);
		panelPrincipal.revalidate();
		panelPrincipal.repaint();
		
	}
	public void Hora() {
		Date fecha=new Date();
		
		DateFormat df6 =  DateFormat.getDateInstance(DateFormat.FULL);
		lblHora.setText("Hoy es "+df6.format(fecha));
	}
}
