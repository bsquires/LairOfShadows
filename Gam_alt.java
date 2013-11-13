import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.*;
import java.io.*;
import javax.imageio.*;

public class Gam_alt extends JFrame  {
	JPanel InitScreen = new JPanel();
	JPanel ClassChoiceScreen= new JPanel();
	JPanel gamePlay=new JPanel();
	FileReader fileReader;
	//Player player=null;
	
	
	public Gam_alt(){
		this.setTitle("Lair Of Shadows");
		this.setSize(700, 500);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		this.getContentPane().setBackground(Color.black);
		this.setResizable(false);
		makeInitScreen();
	}
		
		public void makeInitScreen(){
			
	        InitScreen.setLayout(new BorderLayout(4, 4));
	        InitScreen.setForeground(Color.green);
			InitScreen.setBackground(Color.black);
	        
			//The Text on the start screen
	        JPanel initText= new JPanel();
	        initText.setLayout(new GridLayout(3, 1, 1, 1));
	        initText.setForeground(Color.green);
			initText.setBackground(Color.black);
	        
	        JLabel cName=new JLabel("Shadow Tech Enterprises");
			cName.setFont(new Font("Helevetica", Font.BOLD, 48));
			cName.setForeground(Color.green);
			cName.setBackground(Color.black);
			cName.setHorizontalAlignment(SwingConstants.CENTER);
			
			JLabel pName=new JLabel("Presents:");
			pName.setFont(new Font("Helevetica", Font.BOLD, 24));
			pName.setForeground(Color.green);
			pName.setBackground(Color.black);
			pName.setHorizontalAlignment(SwingConstants.CENTER);
			
			JLabel gName=new JLabel("Lair Of Shadows");
			gName.setFont(new Font("Helevetica", Font.BOLD, 48));
			gName.setForeground(Color.green);
			gName.setBackground(Color.black);
			gName.setHorizontalAlignment(SwingConstants.CENTER);
			
			initText.add(cName);
			initText.add(pName);
			initText.add(gName);
			
			//Initial Options
			ActionListener initListener = new initListener();
			JPanel initButtonPanel= new JPanel();
			initButtonPanel.setLayout(new GridLayout(2, 1, 4, 4));
			initButtonPanel.setForeground(Color.green);
			initButtonPanel.setBackground(Color.black);
			
			JButton startButton = new JButton("Start Game");
			startButton.setFont(new Font("Helevetica", Font.BOLD, 24));
			startButton.setForeground(Color.green);
			startButton.setBackground(Color.black);
			startButton.setHorizontalAlignment(SwingConstants.CENTER);
			startButton.addActionListener(initListener);
			
			JButton quitButton = new JButton("Quit Game");
			quitButton.setFont(new Font("Helevetica", Font.BOLD, 24));
			quitButton.setForeground(Color.green);
			quitButton.setBackground(Color.black);
			quitButton.setHorizontalAlignment(SwingConstants.CENTER);
			quitButton.addActionListener(initListener);
			
			initButtonPanel.add(startButton);
			initButtonPanel.add(quitButton);
			
			//Adding Stuff
	        InitScreen.add(initText, BorderLayout.NORTH);
			InitScreen.add(initButtonPanel, BorderLayout.CENTER);
	        
	        this.setContentPane(InitScreen);
		}
		
		public void makeClassChoiceScreen() throws IOException {
			this.remove(InitScreen);
			
			ClassChoiceScreen.setLayout(new BorderLayout(4, 4));
			ClassChoiceScreen.setForeground(Color.green);
			ClassChoiceScreen.setBackground(Color.black);
						
			//Text Wall
			JTextArea classText=new JTextArea();
			//reading in a file
			File fOpen=new File("ClassInfo.txt");
			fileReader=new FileReader(fOpen);
			classText.read(fileReader, fOpen.toString());
			
			classText.setFont(new Font("Helevetica", Font.BOLD, 16));
			classText.setForeground(Color.green);
			classText.setBackground(Color.black);
			JScrollPane cWall=new JScrollPane(classText);
			cWall.setPreferredSize(new Dimension(490, 500));
			ClassChoiceScreen.add(cWall, BorderLayout.EAST);
			
			//Add Images-change using tutorial found
			//JPanel iPanel=new JPanel();
			//Initial Options
			ActionListener classListener = new classListener();
			JPanel classButtonPanel= new JPanel();
			classButtonPanel.setLayout(new GridLayout(3, 1, 4, 4));
			classButtonPanel.setForeground(Color.green);
			classButtonPanel.setBackground(Color.black);
			
			JButton warButton = new JButton("Warrior");
			warButton.setFont(new Font("Helevetica", Font.BOLD, 24));
			warButton.setForeground(Color.green);
			warButton.setBackground(Color.black);
			warButton.setHorizontalAlignment(SwingConstants.CENTER);
			warButton.addActionListener(classListener);
			
			JButton mageButton = new JButton("Mage");
			mageButton.setFont(new Font("Helevetica", Font.BOLD, 24));
			mageButton.setForeground(Color.green);
			mageButton.setBackground(Color.black);
			mageButton.setHorizontalAlignment(SwingConstants.CENTER);
			mageButton.addActionListener(classListener);
			
			JButton rogButton = new JButton("Rogue");
			rogButton.setFont(new Font("Helevetica", Font.BOLD, 24));
			rogButton.setForeground(Color.green);
			rogButton.setBackground(Color.black);
			rogButton.setHorizontalAlignment(SwingConstants.CENTER);
			rogButton.addActionListener(classListener);
			
			classButtonPanel.add(warButton);
			classButtonPanel.add(mageButton);
			classButtonPanel.add(rogButton);
			classButtonPanel.setPreferredSize(new Dimension(200, 500));
			
			ClassChoiceScreen.add(classButtonPanel, BorderLayout.WEST);
			
			this.setContentPane(ClassChoiceScreen);
			this.validate();
			this.repaint();
		}
		
		public void launchGame(){
			this.remove(ClassChoiceScreen);
			gamePlay.setLayout(new BorderLayout(4, 4));
			gamePlay.setForeground(Color.green);
			gamePlay.setBackground(Color.black);
			
			//Insert main game gui here
			
			this.setContentPane(gamePlay);
			this.validate();
			this.repaint();
			
			//insert gam code here
		}
		
		 class initListener implements ActionListener {
		        public void actionPerformed(ActionEvent event) {
		            String initChoice = event.getActionCommand(); 
		            if (initChoice.equals("Start Game")) {
		              try {
						makeClassChoiceScreen();
					} catch (FileNotFoundException e) {
						System.out.println("Catostrophic Disaster");
					} catch (IOException e) {
						System.out.println("Catostrophic Disaster");
					}
		            } 
		            else if(initChoice.equals("Quit Game")){
		             setVisible(false);
		             dispose();
		            
		            }
		        }
		 }
		 
		 class classListener implements ActionListener{
			 public void actionPerformed(ActionEvent event) {
		            String cChoice = event.getActionCommand(); 
		            if (cChoice.equals("Warrior")) {
		            	//player=new Warrior();
		            	launchGame();
		            }
		            else if(cChoice.equals("Mage")){
		            	//player=new Mage();
		            	launchGame();
		            }
		            else if(cChoice.equals("Rogue")){
		            	//player=new Rogue();
		            	launchGame();
		            }
		        }
		 }
}
