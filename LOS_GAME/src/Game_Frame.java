import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.swing.JTextPane;

import java.awt.Color;

public class Game_Frame extends JFrame {
	public Game_Frame() throws IOException {
		
		JPanel buttonPanel = new JPanel();
		getContentPane().add(buttonPanel , BorderLayout.SOUTH);
		buttonPanel .setLayout(new GridLayout(0, 4, 0, 0));
		
		JButton btnA = new JButton("a");
		buttonPanel .add(btnA);
		
		JButton btnB = new JButton("b");
		buttonPanel .add(btnB);
		
		JButton btnX = new JButton("x");
		buttonPanel .add(btnX);
		
		JButton btnY = new JButton("y");
		buttonPanel .add(btnY);
		
		//Label at the top of the Window
		JLabel lblLairOfShadows = new JLabel("Lair Of Shadows");
		lblLairOfShadows.setForeground(new Color(255, 215, 0));
		lblLairOfShadows.setBackground(new Color(0, 0, 0));
		lblLairOfShadows.setFont(new Font("Gulim", Font.BOLD, 24));
		lblLairOfShadows.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblLairOfShadows, BorderLayout.NORTH);
		
		//This should output the current situation in the game
		JTextPane gamePlayTextPane = new JTextPane();
		gamePlayTextPane.setText("This is updated with current text of the game");
		getContentPane().add(gamePlayTextPane, BorderLayout.CENTER);
		
		
		//This Pane should output the Player Stats Text
		JTextPane playerStatsPane = new JTextPane();
		playerStatsPane.setFont(new Font("Tahoma", Font.BOLD, 11));
		playerStatsPane.setForeground(Color.BLUE);
		playerStatsPane.setBackground(Color.WHITE);
		getContentPane().add(playerStatsPane, BorderLayout.WEST);
		playerStatsPane.setText("Player Stats:");
		
		//Add an image to the 
		ImageIcon image = new ImageIcon("image/pic1.jpg");
		JLabel imageLabel = new JLabel("", image, JLabel.CENTER);
		JPanel imagePane = new JPanel(new BorderLayout());
		imagePane.add( imageLabel, BorderLayout.CENTER );
		getContentPane().add(imagePane, BorderLayout.EAST);

		
		String gamePlay = "This is the gameplay";
	
	}
		
		
		
		
	
	
}
