package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.jgoodies.forms.factories.DefaultComponentFactory;

public class InfoInputWindow extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField txtPassword;
	private String connect = "connect";

	public InfoInputWindow() {
		setTitle("Info");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 300, 180);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblIpAddress = DefaultComponentFactory.getInstance().createLabel("IP Address:");
		lblIpAddress.setBounds(10, 11, 92, 14);
		contentPane.add(lblIpAddress);
		
		textField = new JTextField();
		textField.setBounds(10, 30, 150, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblPort = DefaultComponentFactory.getInstance().createLabel("Port:");
		lblPort.setBounds(188, 11, 92, 14);
		contentPane.add(lblPort);
		
		textField_1 = new JTextField();
		textField_1.setBounds(188, 30, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblUsername = DefaultComponentFactory.getInstance().createLabel("Username:");
		lblUsername.setBounds(10, 61, 92, 14);
		contentPane.add(lblUsername);
		
		textField_2 = new JTextField();
		textField_2.setBounds(10, 80, 125, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblPassword = DefaultComponentFactory.getInstance().createLabel("Password:");
		lblPassword.setBounds(149, 61, 92, 14);
		lblPassword.setLabelFor(txtPassword);
		contentPane.add(lblPassword);
		
		JButton btnConnect = new JButton("Connect");
		btnConnect.setBounds(10, 111, 264, 23);
		btnConnect.setActionCommand(connect);
		btnConnect.addActionListener(this);
		contentPane.add(btnConnect);
		
		txtPassword = new JPasswordField();
		txtPassword.setActionCommand(connect);
		txtPassword.setBounds(149, 80, 125, 20);
		txtPassword.addActionListener(this);
		contentPane.add(txtPassword);
		txtPassword.setColumns(10);

		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		if(cmd.equals(connect)){
			this.dispose();
			Frame frame = new Frame();
			frame.setVisible(true);
		}
	}
	
}
