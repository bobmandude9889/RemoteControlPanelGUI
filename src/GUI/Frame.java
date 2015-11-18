package GUI;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;

import com.jgoodies.forms.factories.DefaultComponentFactory;

import player.PlayerManager;

public class Frame extends JFrame {

	private JPanel mainPage;
	private JPanel playerPage;
	private static PlayerScrollPanel playerPanel;
	public JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					try {
						UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
							| UnsupportedLookAndFeelException e) {
						e.printStackTrace();
					}
					new InfoInputWindow();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Frame() {
		setResizable(false);
		setTitle("Server Control Panel");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 295);
		mainPage = new JPanel();
		mainPage.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(mainPage);
		mainPage.setLayout(null);

		playerPanel = new PlayerScrollPanel(this);

		scrollPane = new JScrollPane(playerPanel);
		scrollPane.setBounds(10, 25, 200, 235);
		mainPage.add(scrollPane);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 794, 21);
		mainPage.add(menuBar);
		
		JLabel lblPlayersOnline = DefaultComponentFactory.getInstance().createLabel("Players Online: 7");
		lblPlayersOnline.setForeground(Color.RED);
		lblPlayersOnline.setBounds(220, 59, 92, 14);
		mainPage.add(lblPlayersOnline);
		
		JButton btnStop = new JButton("Stop");
		btnStop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				playerPanel.add(PlayerManager.getPlayer(JOptionPane.showInputDialog("Enter a player:")));
			}
		});
		btnStop.setBounds(220, 25, 75, 23);
		mainPage.add(btnStop);
		
		JButton btnRestart = new JButton("Restart");
		btnRestart.setBounds(309, 25, 75, 23);
		mainPage.add(btnRestart);
	}
}
