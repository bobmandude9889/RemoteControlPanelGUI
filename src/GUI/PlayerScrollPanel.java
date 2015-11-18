package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import player.Player;

public class PlayerScrollPanel extends JPanel {

	private List<Player> players;

	private static int sectionHeight = 63;
	private Frame frame;

	public PlayerScrollPanel(Frame frame) {
		this.frame = frame;
		setPreferredSize(new Dimension(180, 5));
		setLayout(null);
		players = new ArrayList<Player>();
	}

	public void updatePlayerList() {
		removeAll();
		int height = 5 + sectionHeight * players.size();
		height = height < 235 ? 235 : height;
		setPreferredSize(new Dimension(180, height));
		for (Player p : players) {
			Color back = Color.WHITE;
			if(players.indexOf(p) % 2 == 1){
				back = Color.LIGHT_GRAY;
			}
			
			JButton kickBtn = new JButton("Kick");
			kickBtn.setBackground(back);
			kickBtn.setBounds(60, 15 + sectionHeight * players.indexOf(p), 57, 23);

			JButton banBtn = new JButton("Ban");
			banBtn.setBackground(back);
			banBtn.setBounds(120, 15 + sectionHeight * players.indexOf(p), 57, 23);
			
			JButton messageBtn = new JButton("Msg");
			messageBtn.setBackground(back);
			messageBtn.setBounds(60, 37 + sectionHeight * players.indexOf(p), 57, 23);

			JButton moreBtn = new JButton("More");
			moreBtn.setBackground(back);
			moreBtn.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					new PlayerWindow(p);
				}
				
			});
			moreBtn.setBounds(120, 37 + sectionHeight * players.indexOf(p), 57, 23);
			
			add(kickBtn);
			add(banBtn);
			add(messageBtn);
			add(moreBtn);
		}
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				repaint();
				revalidate();
			}
		});
	}

	public void add(Player player) {
		if (!players.contains(player)) {
			players.add(player);
			updatePlayerList();
		}
	}

	public void remove(Player player) {
		players.remove(player);
		updatePlayerList();
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		for (int i = 0; i < getHeight() / 37; i++) {
			g.setColor(i % 2 == 0 ? Color.WHITE : Color.LIGHT_GRAY);
			g.fillRect(0, i * sectionHeight, 200, sectionHeight);
		}

		for (Player p : players) {
			BufferedImage head = p.getHead();
			g.drawImage(p.getHead(), 5, 5 + sectionHeight * players.indexOf(p), 50, 50, null);
			g.setColor(Color.BLACK);
			g.drawString(p.getName(), 65, 12 + sectionHeight * players.indexOf(p));
		}
	}

}
