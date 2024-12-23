package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class Mensaje extends JDialog {

	private final JPanel contentPanel = new JPanel();
	public static void main(String[] args) {
		try {
			Mensaje dialog = new Mensaje();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public Mensaje() {
		setBounds(100, 100, 450, 250);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblAlertaHaOcurrido = new JLabel("ALERTA HA OCURRIDO UNA COLISION!!!!");
			lblAlertaHaOcurrido.setForeground(Color.RED);
			lblAlertaHaOcurrido.setHorizontalAlignment(SwingConstants.CENTER);
			lblAlertaHaOcurrido.setBounds(10, 11, 414, 29);
			lblAlertaHaOcurrido.setFont(new Font("Arial", Font.BOLD, 20));
			contentPanel.add(lblAlertaHaOcurrido);
		}
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Mensaje.class.getResource("/Imagenes2/warning-icon.png")));
		lblNewLabel.setBounds(151, 51, 128, 120);
		contentPanel.add(lblNewLabel);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBounds(0, 172, 434, 39);
			contentPanel.add(buttonPane);
			{
				JButton okButton = new JButton("OK");
				okButton.setBounds(192, 11, 47, 23);
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						setVisible(false);
					}
				});
				buttonPane.setLayout(null);
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
	}
}
