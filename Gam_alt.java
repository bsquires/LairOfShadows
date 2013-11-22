//We might have to find an alternate way of making loops as it freezes the game.
//we are going to have to loop through the use of the action listeners
//and creating or modifying panels as the game goes on.
//Help me out by filling blanks and changing variables/names where necessary

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

import javax.swing.*;
import javax.swing.event.*;
import java.util.*;
import java.io.*;

import javax.imageio.*;

public class Gam_alt extends JFrame  {
	boolean desert=true;
	boolean forest=true;
	boolean lake=true;
	char playerType;
	boolean playerAlive=true;
	char location;
	boolean subzone1=true;
	boolean subzone2=true;
	Image gImage=null;
	//Player player=null;
	JPanel InitScreen = new JPanel();
	JPanel ClassChoiceScreen= new JPanel();
	JPanel gamePlay=new JPanel();
	JPanel westBlock=new JPanel();
	JPanel iPanel=new JPanel();
	JLabel iL=new JLabel();
	JPanel statPanel=new JPanel();
	JPanel dirButtonPanel=null;
	JTextArea hText=null;
	JTextArea afText=null;
	JTextArea dText=null;
	JTextArea gText=new JTextArea();
	JScrollPane gWall=null;
	FileReader fileReader;
	
	public Gam_alt(){
		this.setTitle("Lair Of Shadows");
		this.setSize(new Dimension(700, 500));
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
		
		public void launchGame(char pT) throws IOException{
			this.getContentPane().removeAll();
			gamePlay.setLayout(new BorderLayout(4, 4));
			gamePlay.setForeground(Color.green);
			gamePlay.setBackground(Color.black);
			
			//Insert main game gui here
			//Text Wall
			//reading in a file
			File fOpen=null;
			
			switch(pT){
			case 'w':
				fOpen=new File("Lair+of+Shadows+Story+Warrior.txt");
				break;
			case 'm':
				fOpen=new File("Lair+of+Shadows+Story+Mage.txt");
				break;
			case 'r':
				fOpen=new File("Lair+of+Shadows+Story+Rogue.txt");
				break;
			default:
				System.out.println("CATOSTROPHIC!");
			};
			fileReader=new FileReader(fOpen);
			gText.read(fileReader, fOpen.toString());
			gText.setFont(new Font("Helevetica", Font.BOLD, 16));
			gText.setForeground(Color.green);
			gText.setBackground(Color.black);
			gWall=new JScrollPane(gText);
			gWall.setPreferredSize(new Dimension(490, 500));
			gamePlay.add(gWall, BorderLayout.EAST);
			
			//WEST SIDE!
			westBlock.setLayout(new BorderLayout(4, 4));
			westBlock.setForeground(Color.green);
			westBlock.setBackground(Color.black);
			iPanel.setBackground(Color.BLACK);
			iPanel.setPreferredSize(new Dimension(200, 300));
			try {
				gImage = ImageIO.read(new File("sauron.jpg"));
			} catch (IOException e) {
				System.out.println("Check the Image SHIT!");
			}
			gImage=gImage.getScaledInstance(200, 300, 5);
			iL.setIcon(new ImageIcon(gImage));
			iL.setPreferredSize(new Dimension(200, 300));
			iL.setBackground(Color.BLACK);
			iPanel.add(iL);
			westBlock.add(iPanel, BorderLayout.NORTH);
			
			//stat panel
			statPanel.setForeground(Color.green);
			statPanel.setBackground(Color.black);
			statPanel.setLayout(new GridLayout(3, 1, 4, 4));
			
			hText=new healthText();	
			afText=new attackText();
			dText=new defenseText();
			
			statPanel.add(hText);
			statPanel.add(afText);
			statPanel.add(dText);
			statPanel.setPreferredSize(new Dimension(200, 100));
			westBlock.add(statPanel, BorderLayout.CENTER);
			
			
			//Button stuff
			dirButtonPanel= new directionPanel(desert, forest, lake);
			
			westBlock.add(dirButtonPanel, BorderLayout.SOUTH);
			gamePlay.add(westBlock, BorderLayout.WEST);
			gamePlay.setPreferredSize(new Dimension(200, 500));
			
			this.setContentPane(gamePlay);
			this.revalidate();
			this.repaint();
			
			
		}
		
		public void launchEvent(){
			//The way this is setup it can be specialized or generalized
			int x=0;
			if (x==0/*fight*/){
				
			}
			else{
				//deal with other conditions
			}
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
		            	playerType='w';
		            	try {
							launchGame(playerType);
						} catch (IOException e) {
							System.out.println("FAILURE!");
						}
		            }
		            else if(cChoice.equals("Mage")){
		            	//player=new Mage();
		            	playerType='m';
		            	try {
							launchGame(playerType);
						} catch (IOException e) {
							System.out.println("FAILURE!");
						}
		            }
		            else if(cChoice.equals("Rogue")){
		            	//player=new Rogue();
		            	playerType='r';
		            	try {
							launchGame(playerType);
						} catch (IOException e) {
							System.out.println("FAILURE!");
						}
		            }
		        }
		 }
		 
		 class dirListener implements ActionListener{
			 public void actionPerformed(ActionEvent event) {
		            String cChoice = event.getActionCommand(); 
		            if (cChoice.equals("Desert")) {
		            	File fOpen=new File("Lair+of+Shadows+Story+Desert.txt");
		    			try {
							fileReader=new FileReader(fOpen);
						} catch (FileNotFoundException e1) {
							System.out.println("DIR! ERROR! FILE");
						}
		    			try {
							gText.read(fileReader, fOpen.toString());
						} catch (IOException e) {
							System.out.println("DIR! ERROR! IO!");
						}
		    			location='d';
		    			westBlock.remove(dirButtonPanel);
		    			dirButtonPanel=new subDirection(location, subzone1, subzone2);
		    			westBlock.add(dirButtonPanel, BorderLayout.SOUTH);
		    			revalidate();
		    			repaint();
		            }
		            else if(cChoice.equals("Forest")){
		            	File fOpen=new File("Lair+of+Shadows+Story+Forest.txt");
		    			try {
							fileReader=new FileReader(fOpen);
						} catch (FileNotFoundException e1) {
							System.out.println("DIR! ERROR! FILE");
						}
		    			try {
							gText.read(fileReader, fOpen.toString());
						} catch (IOException e) {
							System.out.println("DIR! ERROR! IO!");
						}
		    			location='f';
		    			westBlock.remove(dirButtonPanel);
		    			dirButtonPanel=new subDirection(location, subzone1, subzone2);
		    			westBlock.add(dirButtonPanel, BorderLayout.SOUTH);
		    			revalidate();
		    			repaint();
		            }
		            else if(cChoice.equals("Lake")){
		            	File fOpen=new File("Lair+of+Shadows+Story+Swamp.txt");
		    			try {
							fileReader=new FileReader(fOpen);
						} catch (FileNotFoundException e1) {
							System.out.println("DIR! ERROR! FILE");
						}
		    			try {
							gText.read(fileReader, fOpen.toString());
						} catch (IOException e) {
							System.out.println("DIR! ERROR! IO!");
						}
		    			location='l';
		    			westBlock.remove(dirButtonPanel);
		    			dirButtonPanel=new subDirection(location, subzone1, subzone2);
		    			westBlock.add(dirButtonPanel, BorderLayout.SOUTH);
		    			revalidate();
		    			repaint();
		            }
		        }
		 }

		 class subListener implements ActionListener{
			 public void actionPerformed(ActionEvent event) {
		            String cChoice = event.getActionCommand(); 
		            if (cChoice.equals(" ")) {
		            	launchEvent();
		            }
		            else if(cChoice.equals(" ")){
		            	launchEvent();
		            }
		            else if(cChoice.equals(" ")){
		            	launchEvent();
		            }
		            else if(cChoice.equals(" ")){
		            	launchEvent();
		            }
		            else if(cChoice.equals(" ")){
		            	launchEvent();
		            }
		            else if(cChoice.equals(" ")){
		            	launchEvent();
		            }
		        }
		 }
		 class directionPanel extends JPanel{
			 public directionPanel(boolean d, boolean f, boolean l){
				 ActionListener dirListener = new dirListener();
				 this.setLayout(new GridLayout(3, 1, 4, 4));
				 this.setForeground(Color.green);
				 this.setBackground(Color.black);
				 
				 if(d&f&l){
					 JButton dButton = new JButton("Desert");
					 dButton.setFont(new Font("Helevetica", Font.BOLD, 12));
					 dButton.setForeground(Color.green);
					 dButton.setBackground(Color.black);
					 dButton.setHorizontalAlignment(SwingConstants.CENTER);
					 dButton.addActionListener(dirListener);
					 
					 JButton fButton = new JButton("Forest");
					 fButton.setFont(new Font("Helevetica", Font.BOLD, 12));
					 fButton.setForeground(Color.green);
					 fButton.setBackground(Color.black);
					 fButton.setHorizontalAlignment(SwingConstants.CENTER);
					 fButton.addActionListener(dirListener);
					 
					 JButton lButton = new JButton("Lake");
					 lButton.setFont(new Font("Helevetica", Font.BOLD, 12));
					 lButton.setForeground(Color.green);
					 lButton.setBackground(Color.black);
					 lButton.setHorizontalAlignment(SwingConstants.CENTER);
					 lButton.addActionListener(dirListener);
					 
					 this.add(dButton);
					 this.add(fButton);
					 this.add(lButton);
					 this.setPreferredSize(new Dimension(200, 100));
				 }
				 else if(d&f){
					 JButton dButton = new JButton("Desert");
					 dButton.setFont(new Font("Helevetica", Font.BOLD, 12));
					 dButton.setForeground(Color.green);
					 dButton.setBackground(Color.black);
					 dButton.setHorizontalAlignment(SwingConstants.CENTER);
					 dButton.addActionListener(dirListener);
					 
					 JButton fButton = new JButton("Forest");
					 fButton.setFont(new Font("Helevetica", Font.BOLD, 12));
					 fButton.setForeground(Color.green);
					 fButton.setBackground(Color.black);
					 fButton.setHorizontalAlignment(SwingConstants.CENTER);
					 fButton.addActionListener(dirListener);
					 
					 this.add(dButton);
					 this.add(fButton);
					 this.setPreferredSize(new Dimension(200, 100));
				 }
				 else if(d&l){
					 JButton dButton = new JButton("Desert");
					 dButton.setFont(new Font("Helevetica", Font.BOLD, 12));
					 dButton.setForeground(Color.green);
					 dButton.setBackground(Color.black);
					 dButton.setHorizontalAlignment(SwingConstants.CENTER);
					 dButton.addActionListener(dirListener);
					 
					 JButton lButton = new JButton("Lake");
					 lButton.setFont(new Font("Helevetica", Font.BOLD, 12));
					 lButton.setForeground(Color.green);
					 lButton.setBackground(Color.black);
					 lButton.setHorizontalAlignment(SwingConstants.CENTER);
					 lButton.addActionListener(dirListener);
					 
					 this.add(dButton);
					 this.add(lButton);
					 this.setPreferredSize(new Dimension(200, 100));
				 }
				 else if(f&l){					 
					 JButton fButton = new JButton("Forest");
					 fButton.setFont(new Font("Helevetica", Font.BOLD, 12));
					 fButton.setForeground(Color.green);
					 fButton.setBackground(Color.black);
					 fButton.setHorizontalAlignment(SwingConstants.CENTER);
					 fButton.addActionListener(dirListener);
					 
					 JButton lButton = new JButton("Lake");
					 lButton.setFont(new Font("Helevetica", Font.BOLD, 12));
					 lButton.setForeground(Color.green);
					 lButton.setBackground(Color.black);
					 lButton.setHorizontalAlignment(SwingConstants.CENTER);
					 lButton.addActionListener(dirListener);
					 
					 this.add(fButton);
					 this.add(lButton);
					 this.setPreferredSize(new Dimension(200, 100));
				 }
				 else if(d){
					 JButton dButton = new JButton("Desert");
					 dButton.setFont(new Font("Helevetica", Font.BOLD, 12));
					 dButton.setForeground(Color.green);
					 dButton.setBackground(Color.black);
					 dButton.setHorizontalAlignment(SwingConstants.CENTER);
					 dButton.addActionListener(dirListener);
					 this.add(dButton);
					 this.setPreferredSize(new Dimension(200, 100));
				 }
				 else if(f){
					 JButton fButton = new JButton("Forest");
					 fButton.setFont(new Font("Helevetica", Font.BOLD, 12));
					 fButton.setForeground(Color.green);
					 fButton.setBackground(Color.black);
					 fButton.setHorizontalAlignment(SwingConstants.CENTER);
					 fButton.addActionListener(dirListener);
					 
					 this.add(fButton);
					 this.setPreferredSize(new Dimension(200, 100));
				 }
				 else if(l){
					 JButton lButton = new JButton("Lake");
					 lButton.setFont(new Font("Helevetica", Font.BOLD, 12));
					 lButton.setForeground(Color.green);
					 lButton.setBackground(Color.black);
					 lButton.setHorizontalAlignment(SwingConstants.CENTER);
					 lButton.addActionListener(dirListener);
					 
					 this.add(lButton);
					 this.setPreferredSize(new Dimension(200, 100));
				 }
			 }
		 }
		 
		 class subDirection extends JPanel{
			 public subDirection(char zone, boolean sub1, boolean sub2){
				 ActionListener subListener = new dirListener();
				 this.setForeground(Color.green);
				 this.setBackground(Color.black);
				 switch(zone){
				 case 'd':
					 if(sub1&&sub2){
						 this.setLayout(new GridLayout(2, 1, 4, 4));
						 JButton s1Button = new JButton("Dune");
						 s1Button.setFont(new Font("Helevetica", Font.BOLD, 12));
						 s1Button.setForeground(Color.green);
						 s1Button.setBackground(Color.black);
						 s1Button.setHorizontalAlignment(SwingConstants.CENTER);
						 s1Button.addActionListener(subListener);
						 
						 JButton s2Button = new JButton("Valley");
						 s2Button.setFont(new Font("Helevetica", Font.BOLD, 12));
						 s2Button.setForeground(Color.green);
						 s2Button.setBackground(Color.black);
						 s2Button.setHorizontalAlignment(SwingConstants.CENTER);
						 s2Button.addActionListener(subListener);
						 
						 this.add(s1Button);
						 this.add(s2Button);
						 this.setPreferredSize(new Dimension(200, 100));
					 }
					 else if(sub1){
						 this.setLayout(new GridLayout(1, 1, 4, 4));
						 JButton s1Button = new JButton("");
						 s1Button.setFont(new Font("Helevetica", Font.BOLD, 12));
						 s1Button.setForeground(Color.green);
						 s1Button.setBackground(Color.black);
						 s1Button.setHorizontalAlignment(SwingConstants.CENTER);
						 s1Button.addActionListener(subListener);
						 
						 this.add(s1Button);
						 this.setPreferredSize(new Dimension(200, 100));
					 }
					 else if(sub2){
						 this.setLayout(new GridLayout(1, 1, 4, 4));
						 JButton s2Button = new JButton("");
						 s2Button.setFont(new Font("Helevetica", Font.BOLD, 12));
						 s2Button.setForeground(Color.green);
						 s2Button.setBackground(Color.black);
						 s2Button.setHorizontalAlignment(SwingConstants.CENTER);
						 s2Button.addActionListener(subListener);
						 
						 this.add(s2Button);
						 this.setPreferredSize(new Dimension(200, 100));
					 }
					 break;	
				 case 'f':
					 if(sub1&&sub2){
						 this.setLayout(new GridLayout(2, 1, 4, 4));
						 JButton s1Button = new JButton("");
						 s1Button.setFont(new Font("Helevetica", Font.BOLD, 12));
						 s1Button.setForeground(Color.green);
						 s1Button.setBackground(Color.black);
						 s1Button.setHorizontalAlignment(SwingConstants.CENTER);
						 s1Button.addActionListener(subListener);
						 
						 JButton s2Button = new JButton("");
						 s2Button.setFont(new Font("Helevetica", Font.BOLD, 12));
						 s2Button.setForeground(Color.green);
						 s2Button.setBackground(Color.black);
						 s2Button.setHorizontalAlignment(SwingConstants.CENTER);
						 s2Button.addActionListener(subListener);
						 
						 this.add(s1Button);
						 this.add(s2Button);
						 this.setPreferredSize(new Dimension(200, 100));
					 }
					 else if(sub1){
						 this.setLayout(new GridLayout(1, 1, 4, 4));
						 JButton s1Button = new JButton("");
						 s1Button.setFont(new Font("Helevetica", Font.BOLD, 12));
						 s1Button.setForeground(Color.green);
						 s1Button.setBackground(Color.black);
						 s1Button.setHorizontalAlignment(SwingConstants.CENTER);
						 s1Button.addActionListener(subListener);
						 
						 this.add(s1Button);
						 this.setPreferredSize(new Dimension(200, 100));
					 }
					 else if(sub2){
						 this.setLayout(new GridLayout(1, 1, 4, 4));
						 JButton s2Button = new JButton("");
						 s2Button.setFont(new Font("Helevetica", Font.BOLD, 12));
						 s2Button.setForeground(Color.green);
						 s2Button.setBackground(Color.black);
						 s2Button.setHorizontalAlignment(SwingConstants.CENTER);
						 s2Button.addActionListener(subListener);
						 
						 this.add(s2Button);
						 this.setPreferredSize(new Dimension(200, 100));
					 }
					 break;
				 case 'l':
					 if(sub1&&sub2){
						 this.setLayout(new GridLayout(2, 1, 4, 4));
						 JButton s1Button = new JButton("");
						 s1Button.setFont(new Font("Helevetica", Font.BOLD, 12));
						 s1Button.setForeground(Color.green);
						 s1Button.setBackground(Color.black);
						 s1Button.setHorizontalAlignment(SwingConstants.CENTER);
						 s1Button.addActionListener(subListener);
						 
						 JButton s2Button = new JButton("");
						 s2Button.setFont(new Font("Helevetica", Font.BOLD, 12));
						 s2Button.setForeground(Color.green);
						 s2Button.setBackground(Color.black);
						 s2Button.setHorizontalAlignment(SwingConstants.CENTER);
						 s2Button.addActionListener(subListener);
						 
						 this.add(s1Button);
						 this.add(s2Button);
						 this.setPreferredSize(new Dimension(200, 100));
					 }
					 else if(sub1){
						 this.setLayout(new GridLayout(1, 1, 4, 4));
						 JButton s1Button = new JButton("");
						 s1Button.setFont(new Font("Helevetica", Font.BOLD, 12));
						 s1Button.setForeground(Color.green);
						 s1Button.setBackground(Color.black);
						 s1Button.setHorizontalAlignment(SwingConstants.CENTER);
						 s1Button.addActionListener(subListener);
						 
						 this.add(s1Button);
						 this.setPreferredSize(new Dimension(200, 100));
					 }
					 else if(sub2){
						 this.setLayout(new GridLayout(1, 1, 4, 4));
						 JButton s2Button = new JButton("");
						 s2Button.setFont(new Font("Helevetica", Font.BOLD, 12));
						 s2Button.setForeground(Color.green);
						 s2Button.setBackground(Color.black);
						 s2Button.setHorizontalAlignment(SwingConstants.CENTER);
						 s2Button.addActionListener(subListener);
						 
						 this.add(s2Button);
						 this.setPreferredSize(new Dimension(200, 100));
					 }
					 break;
				 default:
					 System.out.println("CATOSTROPHIC!");
			 }
		 }
		 }
		 
		 class healthText extends JTextArea{
			 public healthText(){
				 this.setText("Health: ");
				 this.setFont(new Font("Helevetica", Font.BOLD, 12));
				 this.setForeground(Color.green);
				 this.setBackground(Color.black);
			 }
			 public void updateText(){
				 this.setText("Health: ");
			 }
			 public void resetText(){
				 this.setText("Health: ");
			 }
		 }

		 class attackText extends JTextArea{
			 public attackText(){
				 this.setText("Attack Force: ");
				 this.setFont(new Font("Helevetica", Font.BOLD, 12));
				 this.setForeground(Color.green);
				 this.setBackground(Color.black);
			 }
			 public void updateText(){
				 this.setText("Attack Force: ");
			 }
			 public void resetText(){
				 this.setText("Attack Force: ");
			 }
		 }

		 class defenseText extends JTextArea{
			 public defenseText(){
				 this.setText("Defense: ");
				 this.setFont(new Font("Helevetica", Font.BOLD, 12));
				 this.setForeground(Color.green);
				 this.setBackground(Color.black);
			 }
			 public void updateText(){
				 this.setText("Defense: ");
			 }
			 public void resetText(){
				 this.setText("Defense: ");
			 }
		 }
}
