import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import player.Player;

public class Test extends JFrame {

	public static void main(String[] args) {
		String name = JOptionPane.showInputDialog("Enter a name:");
		Player player = new Player(name);
		new Test(player);
	}

	public Test(Player player) {
		setSize(235, 460);
		setTitle("Skin");
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		JPanel panel = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				g.drawImage(player.getSkin(), 16, 0, 200, 400, null);
				g.setColor(Color.BLACK);
				g.drawString(player.getName() + ":", 5, 415);
				g.drawString(player.getUUID(), 5, 430);
			}
		};
		add(panel);
		setVisible(true);
	}

}
