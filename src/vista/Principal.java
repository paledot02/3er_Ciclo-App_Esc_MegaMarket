package vista;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.SystemColor;

public class Principal extends JPanel implements ActionListener  {
	private JButton btnAtras;
	private JButton BtnAdelante;
	public static JLabel lblImagen;
	int contador =1;
	int maximo=3;
	ImageIcon Imagen[]=new ImageIcon[3];
	private JLabel lblNewLabel;
	private JPanel panel;
	private JPanel panel_1;
	
	
	public Principal() {
		setBackground(Color.LIGHT_GRAY);
		setLayout(null);
		
		panel = new JPanel();
		panel.setBackground(new Color(240,240,240));
		panel.setBounds(0, 0, 1276, 660);
		add(panel);
		panel.setLayout(null);
		
		panel_1 = new JPanel();
		panel_1.setBounds(86, 91, 824, 284);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(89, 18, 646, 247);
		panel_1.add(lblNewLabel);
		lblNewLabel.setIcon(new ImageIcon(Principal.class.getResource("/img/1.PNG")));
		
		BtnAdelante = new JButton(">");
		BtnAdelante.setBounds(760, 130, 54, 23);
		panel_1.add(BtnAdelante);
		BtnAdelante.setBackground(SystemColor.inactiveCaption);
		
		btnAtras = new JButton("<");
		btnAtras.setBounds(10, 130, 54, 23);
		panel_1.add(btnAtras);
		btnAtras.setBackground(SystemColor.inactiveCaption);
		btnAtras.addActionListener(this);
		BtnAdelante.addActionListener(this);
		
		
	}
	
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnAtras) {
			actionPerformedBtnAtras(arg0);
		}
		if (arg0.getSource() == BtnAdelante) {
			actionPerformedBtnAdelante(arg0);
		}
	}
	protected void actionPerformedBtnAdelante(ActionEvent arg0) {
		if(contador==maximo) {
			contador=0;
		}
		contador++;
		lblNewLabel.setIcon(new ImageIcon(Principal.class.getResource("/img/"+contador+".PNG")));
		
	}
	
	protected void actionPerformedBtnAtras(ActionEvent arg0) {
		if(contador==1) {
			contador=maximo+1;
		}
		contador--;
		lblNewLabel.setIcon(new ImageIcon(Principal.class.getResource("/img/"+contador+".PNG")));
	}
}
