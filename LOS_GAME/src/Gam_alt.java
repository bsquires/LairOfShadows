import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

import javax.swing.*;
import javax.swing.event.*;
import java.util.*;
import java.io.*;

import javax.imageio.*;

public class Gam_alt extends JFrame {
	// variables that will be reused across the game
	int currentHealth;
	int currentAttackForce;
	int currentDefense;
	int currentSpecialStat;
	int currentLevel;
	int fightRound=0;
	boolean subFight=false;
	boolean desert = true;
	boolean forest = true;
	boolean swamp = true;
	boolean BossFight=false;
	char playerType;
	boolean playerAlive = true;
	char location;
	boolean subzone1 = true;
	boolean subzone2 = true;
	boolean subBoss=true;
	char enemyType;
	String attackType;
	Randomizer Bob_the_AI=new Randomizer();
	Player player = null;
	Player Enemy=null;
	Image gImage = null;
	JPanel InitScreen = new JPanel();
	JPanel ClassChoiceScreen = new JPanel();
	JPanel gamePlay = new JPanel();
	JPanel westBlock = new JPanel();
	JPanel iPanel = new JPanel();
	JLabel iL = new JLabel();
	JPanel statPanel = new JPanel();
	JPanel dirButtonPanel = null;
	JTextArea hText = null;
	JTextArea afText = null;
	JTextArea dText = null;
	JTextArea gText = new JTextArea();
	JScrollPane gWall = null;
	FileReader fileReader;

	// The basic JFrame setup
	public Gam_alt() {
		this.setTitle("Lair Of Shadows");
		this.setSize(new Dimension(700, 500));
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		this.getContentPane().setBackground(Color.black);
		this.setResizable(false);
		makeInitScreen();
	}

	// The start screen for the game
	public void makeInitScreen() {
		// creates a border layout for the JPanel InitScreen
		// containing the attributes wanted
		InitScreen.setLayout(new BorderLayout(4, 4));
		InitScreen.setForeground(Color.green);
		InitScreen.setBackground(Color.black);

		// The Text on the start screen
		JPanel initText = new JPanel();
		initText.setLayout(new GridLayout(3, 1, 1, 1));
		initText.setForeground(Color.green);
		initText.setBackground(Color.black);

		JLabel cName = new JLabel("Shadow Tech Enterprises");
		cName.setFont(new Font("Helevetica", Font.BOLD, 48));
		cName.setForeground(Color.green);
		cName.setBackground(Color.black);
		cName.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel pName = new JLabel("Presents:");
		pName.setFont(new Font("Helevetica", Font.BOLD, 24));
		pName.setForeground(Color.green);
		pName.setBackground(Color.black);
		pName.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel gName = new JLabel("Lair Of Shadows");
		gName.setFont(new Font("Helevetica", Font.BOLD, 48));
		gName.setForeground(Color.green);
		gName.setBackground(Color.black);
		gName.setHorizontalAlignment(SwingConstants.CENTER);

		initText.add(cName);
		initText.add(pName);
		initText.add(gName);

		// Initial Options
		ActionListener initListener = new initListener();
		JPanel initButtonPanel = new JPanel();
		initButtonPanel.setLayout(new GridLayout(2, 1, 4, 4));
		initButtonPanel.setForeground(Color.green);
		initButtonPanel.setBackground(Color.black);

		// Button for player choosing to start a game
		JButton startButton = new JButton("Start Game");
		startButton.setFont(new Font("Helevetica", Font.BOLD, 24));
		startButton.setForeground(Color.green);
		startButton.setBackground(Color.black);
		startButton.setHorizontalAlignment(SwingConstants.CENTER);
		startButton.addActionListener(initListener);

		// Button for players who don't want to play the game
		// Pressing the button leads to the game closing
		JButton quitButton = new JButton("Quit Game");
		quitButton.setFont(new Font("Helevetica", Font.BOLD, 24));
		quitButton.setForeground(Color.green);
		quitButton.setBackground(Color.black);
		quitButton.setHorizontalAlignment(SwingConstants.CENTER);
		quitButton.addActionListener(initListener);

		// buttons being added to the button panel
		initButtonPanel.add(startButton);
		initButtonPanel.add(quitButton);

		// Adding the text and button onto the JPanel
		InitScreen.add(initText, BorderLayout.NORTH);
		InitScreen.add(initButtonPanel, BorderLayout.CENTER);

		// Setting the JPanel onto the JFrame
		this.setContentPane(InitScreen);
	}
	
	/*The screen on which the player is
	 *  given the basic story/background
	 *  and chooses their character class 
	*/
	public void makeClassChoiceScreen() throws IOException {
		//Removes the Initial Screen
		this.remove(InitScreen);
		
		//Sets up the Class Choice Screen
		ClassChoiceScreen.setLayout(new BorderLayout(4, 4));
		ClassChoiceScreen.setForeground(Color.green);
		ClassChoiceScreen.setBackground(Color.black);

		//JTextArea on which the story will appear
		JTextArea classText = new JTextArea();
		//A file containing the story is 
		//read in and displayed on screen
		File fOpen = new File("Lair of Shadows Intro Story.txt");
		fileReader = new FileReader(fOpen);
		classText.read(fileReader, fOpen.toString());
		classText.append("\n"+"\n"+ "Choose your character class:\n");
		classText.append("Will you be a Warrior, a Mage, or a Rogue?\n");
		classText.append("Choose Wisely.\n");

		classText.setFont(new Font("Helevetica", Font.BOLD, 16));
		classText.setForeground(Color.green);
		classText.setBackground(Color.black);
		JScrollPane cWall = new JScrollPane(classText);
		cWall.setPreferredSize(new Dimension(490, 500));
		ClassChoiceScreen.add(cWall, BorderLayout.EAST);

		//Buttons that let the player choose
		//thier character class
		ActionListener classListener = new classListener();
		JPanel classButtonPanel = new JPanel();
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

	//The main game screen from which players will
	//choose the zone they want to travel to
	//add Fianl Boss Stuff
	public void launchGame(char pT) throws IOException {
		this.getContentPane().removeAll();
		gamePlay.setLayout(new BorderLayout(4, 4));
		gamePlay.setForeground(Color.green);
		gamePlay.setBackground(Color.black);

		/*Depending on the player's class choice
		 * a specific file will open, informing the 
		 * player on the class's attributes and
		 * some basic information/back story
		*/
		File fOpen = null;

		switch (pT) {
		case 'w':
			fOpen = new File("Lair of Shadows Story Warrior.txt");
			break;
		case 'm':
			fOpen = new File("Lair of Shadows Story Mage.txt");
			break;
		case 'r':
			fOpen = new File("Lair of Shadows Story Rogue.txt");
			break;
		default:
			System.out.println("CATOSTROPHIC!");
		}
		;
		fileReader = new FileReader(fOpen);
		gText.read(fileReader, fOpen.toString());
		gText.setFont(new Font("Helevetica", Font.BOLD, 16));
		gText.setForeground(Color.green);
		gText.setBackground(Color.black);
		gWall = new JScrollPane(gText);
		gWall.setPreferredSize(new Dimension(490, 500));
		gamePlay.add(gWall, BorderLayout.EAST);

		//The information that will be displayed on
		//the Western area of the JFrame's Border Layout
		westBlock.setLayout(new BorderLayout(4, 4));
		westBlock.setForeground(Color.green);
		westBlock.setBackground(Color.black);
		
		//Initial image
		//This could be an image of the class character or possibly a game symbol
		//for now testing images are used
		iPanel.setBackground(Color.BLACK);
		iPanel.setPreferredSize(new Dimension(200, 300));
		try {
			gImage = ImageIO.read(new File("lair_of_shadows.jpg"));
		} catch (IOException e) {
			System.out.println("Check the Image SHIT!");
		}
		gImage = gImage.getScaledInstance(200, 300, 5);
		iL.setIcon(new ImageIcon(gImage));
		iL.setPreferredSize(new Dimension(200, 300));
		iL.setBackground(Color.BLACK);
		iPanel.add(iL);
		westBlock.add(iPanel, BorderLayout.NORTH);

		//The panel shows the player's stats
		statPanel.setForeground(Color.green);
		statPanel.setBackground(Color.black);
		statPanel.setLayout(new GridLayout(3, 1, 4, 4));
		
		currentHealth=player.getHealth();
		currentAttackForce=player.getAttackForce();
		currentDefense=player.getDefense();
		currentSpecialStat=player.getSpecialStat();
		currentLevel=player.getLevel();
		
		hText = new healthText(currentHealth);
		afText = new attackText(currentAttackForce);
		dText = new defenseText(currentDefense);

		statPanel.add(hText);
		statPanel.add(afText);
		statPanel.add(dText);
		statPanel.setPreferredSize(new Dimension(200, 100));
		westBlock.add(statPanel, BorderLayout.CENTER);
		
		if(desert || forest || swamp){
		//Creates a panel with the current zone choices available
		dirButtonPanel = new directionPanel(desert, forest, swamp);
		westBlock.add(dirButtonPanel, BorderLayout.SOUTH);
		gamePlay.add(westBlock, BorderLayout.WEST);
		gamePlay.setPreferredSize(new Dimension(200, 500));

		this.setContentPane(gamePlay);
		this.revalidate();
		this.repaint();
		}
		else{
			dirButtonPanel=new JPanel();
			westBlock.add(dirButtonPanel, BorderLayout.SOUTH);
			gamePlay.add(westBlock, BorderLayout.WEST);
			gamePlay.setPreferredSize(new Dimension(200, 500));

			this.setContentPane(gamePlay);
			this.revalidate();
			this.repaint();
			
			File finalOpen = new File("Lair of Shadows Story Lair of Shadows.txt");
			fileReader = new FileReader(finalOpen);
			gText.read(fileReader, finalOpen.toString());
			gText.append("\n"+"\n");
			String str = "";
			Scanner reader = new Scanner(new File("Lair of Shadows Enemy Mastermind.txt"));
			while (reader.hasNext()){
				str = reader.nextLine();	
				gText.append(str);
				gText.append("\n");
			}
			createFinalBoss();
		}
	}
	
	//Main play area for the Desert zone
	//add SubBoss Stuff
	public void desertZone() throws IOException{
		if (subzone1){
			//Dunes Image
			westBlock.remove(iPanel);
			iPanel.removeAll();
			iL.setIcon(null);
			try {
				gImage = ImageIO.read(new File("dunes.jpg"));
			} catch (IOException e) {
				System.out.println("Check the Image SHIT!");
			}
			gImage = gImage.getScaledInstance(200, 300, 5);
			iL.setIcon(new ImageIcon(gImage));
			iPanel.add(iL);
			westBlock.add(iPanel, BorderLayout.NORTH);
			revalidate();
			repaint();
			
			gText.append("\n"+"\n");
			String str = "";
			Scanner reader = new Scanner(new File("Lair of Shadows DesertSubZone Dunes.txt"));
			while (reader.hasNext()){
				str = reader.nextLine();	
				gText.append(str);
				gText.append("\n");
			}
			launchEvent();
		}
		else if(subzone2){
			//Canyon Image
			westBlock.remove(iPanel);
			iPanel.removeAll();
			iL.setIcon(null);
			try {
				gImage = ImageIO.read(new File("canyon.jpg"));
			} catch (IOException e) {
				System.out.println("Check the Image SHIT!");
			}
			gImage = gImage.getScaledInstance(200, 300, 5);
			iL.setIcon(new ImageIcon(gImage));
			iPanel.add(iL);
			westBlock.add(iPanel, BorderLayout.NORTH);
			revalidate();
			repaint();
			
			gText.setText("");
			String str = "";
			Scanner reader = new Scanner(new File("Lair of Shadows DesertSubZone Canyon.txt"));
			while (reader.hasNext()){
				str = reader.nextLine();	
				gText.append(str);
				gText.append("\n");
			}
			launchEvent();
		}
		else if(subBoss){
			//Mountains Image
			westBlock.remove(iPanel);
			iPanel.removeAll();
			iL.setIcon(null);
			try {
				gImage = ImageIO.read(new File("mountains.jpg"));
			} catch (IOException e) {
				System.out.println("Check the Image SHIT!");
			}
			gImage = gImage.getScaledInstance(200, 300, 5);
			iL.setIcon(new ImageIcon(gImage));
			iPanel.add(iL);
			westBlock.add(iPanel, BorderLayout.NORTH);
			revalidate();
			repaint();
			
			gText.setText("");
			String str = "";
			Scanner reader = new Scanner(new File("Lair of Shadows DesertBossZone Mountains.txt"));
			while (reader.hasNext()){
				str = reader.nextLine();	
				gText.append(str);
				gText.append("\n");
			}
			gText.append("\n");
			reader=new Scanner(new File("Lair of Shadows Story Enemy Warrior Cerberus.txt"));
			while (reader.hasNext()){
				str = reader.nextLine();	
				gText.append(str);
				gText.append("\n");
			}
			createDesertSubBoss();
		}
		else{
			desert=false;
			gText.append("\n"+"You have cleared the Desert Zone!\n");
			subzone1=true;
			subzone2=true;
			subBoss=true;
			subFight=false;
			
			//Clearing out the western block
			westBlock.removeAll();
			dirButtonPanel.removeAll();
			statPanel.removeAll();
			iPanel.removeAll();
			revalidate();
			repaint();
			
			launchGame(playerType);	
		}
	}
	
	//Main play area for the Forest zone
	public void forestZone() throws IOException{
		if (subzone1){
			//Clearing Image
			westBlock.remove(iPanel);
			iPanel.removeAll();
			iL.setIcon(null);
			try {
				gImage = ImageIO.read(new File("forest_clearing.jpg"));
			} catch (IOException e) {
				System.out.println("Check the Image SHIT!");
			}
			gImage = gImage.getScaledInstance(200, 300, 5);
			iL.setIcon(new ImageIcon(gImage));
			iPanel.add(iL);
			westBlock.add(iPanel, BorderLayout.NORTH);
			revalidate();
			repaint();
			
			gText.append("\n"+"\n");
			String str = "";
			Scanner reader = new Scanner(new File("Lair of Shadows ForestSubZone Open Clearing.txt"));
			while (reader.hasNext()){
				str = reader.nextLine();	
				gText.append(str);
				gText.append("\n");
			}
			launchEvent();
		}
		else if(subzone2){
			//Cliff Image
			westBlock.remove(iPanel);
			iPanel.removeAll();
			iL.setIcon(null);
			try {
				gImage = ImageIO.read(new File("forest_cliff.jpg"));
			} catch (IOException e) {
				System.out.println("Check the Image SHIT!");
			}
			gImage = gImage.getScaledInstance(200, 300, 5);
			iL.setIcon(new ImageIcon(gImage));
			iPanel.add(iL);
			westBlock.add(iPanel, BorderLayout.NORTH);
			revalidate();
			repaint();
			
			gText.setText("");
			gText.append("\n"+"\n");
			String str = "";
			Scanner reader = new Scanner(new File("Lair of Shadows ForestSubZone Cliff.txt"));
			while (reader.hasNext()){
				str = reader.nextLine();	
				gText.append(str);
				gText.append("\n");
			}
			launchEvent();
		}
		else if(subBoss){
			//Hollow Tree Image
			westBlock.remove(iPanel);
			iPanel.removeAll();
			iL.setIcon(null);
			try {
				gImage = ImageIO.read(new File("hollow_tree.jpg"));
			} catch (IOException e) {
				System.out.println("Check the Image SHIT!");
			}
			gImage = gImage.getScaledInstance(200, 300, 5);
			iL.setIcon(new ImageIcon(gImage));
			iPanel.add(iL);
			westBlock.add(iPanel, BorderLayout.NORTH);
			revalidate();
			repaint();
			
			gText.setText("");
			String str = "";
			Scanner reader = new Scanner(new File("Lair of Shadows ForestBossZone Hollow Tree.txt"));
			while (reader.hasNext()){
				str = reader.nextLine();	
				gText.append(str);
				gText.append("\n");
			}
			gText.append("\n");
			reader=new Scanner(new File("Lair of Shadows Story Enemy Rogue Hermes.txt"));
			while (reader.hasNext()){
				str = reader.nextLine();	
				gText.append(str);
				gText.append("\n");
			}
			createForestSubBoss();
		}
		else{
			forest=false;
			gText.append("\n"+"You have cleared the Forest Zone!\n");
			subzone1=true;
			subzone2=true;
			subBoss=true;
			subFight=false;
			
			//Clearing out the western block
			westBlock.removeAll();
			dirButtonPanel.removeAll();
			statPanel.removeAll();
			iPanel.removeAll();
			revalidate();
			repaint();
			
			launchGame(playerType);
		}
	}
	
	//Main play area for the Swamp zone
	public void swampZone() throws IOException{
		//Lake Image
		westBlock.remove(iPanel);
		iPanel.removeAll();
		iL.setIcon(null);
		try {
			gImage = ImageIO.read(new File("swamp_lake.jpg"));
		} catch (IOException e) {
			System.out.println("Check the Image SHIT!");
		}
		gImage = gImage.getScaledInstance(200, 300, 5);
		iL.setIcon(new ImageIcon(gImage));
		iPanel.add(iL);
		westBlock.add(iPanel, BorderLayout.NORTH);
		revalidate();
		repaint();
		
		if (subzone1){
			gText.append("\n"+"\n");
			String str = "";
			Scanner reader = new Scanner(new File("Lair of Shadows SwampSubZone Lake.txt"));
			while (reader.hasNext()){
				str = reader.nextLine();	
				gText.append(str);
				gText.append("\n");
			}
			launchEvent();
		}
		else if(subzone2){
			//Dry patch Image
			westBlock.remove(iPanel);
			iPanel.removeAll();
			iL.setIcon(null);
			try {
				gImage = ImageIO.read(new File("swamp_dry_patch.jpg"));
			} catch (IOException e) {
				System.out.println("Check the Image SHIT!");
			}
			gImage = gImage.getScaledInstance(200, 300, 5);
			iL.setIcon(new ImageIcon(gImage));
			iPanel.add(iL);
			westBlock.add(iPanel, BorderLayout.NORTH);
			revalidate();
			repaint();
			
			gText.setText("");
			String str = "";
			Scanner reader = new Scanner(new File("Lair of Shadows SwampSubZone Dry Patch.txt"));
			while (reader.hasNext()){
				str = reader.nextLine();	
				gText.append(str);
				gText.append("\n");
			}
			launchEvent();
		}
		else if(subBoss){
			//Vine Covered Mass Image
			westBlock.remove(iPanel);
			iPanel.removeAll();
			iL.setIcon(null);
			try {
				gImage = ImageIO.read(new File("swamp_vine_mass.jpg"));
			} catch (IOException e) {
				System.out.println("Check the Image SHIT!");
			}
			gImage = gImage.getScaledInstance(200, 300, 5);
			iL.setIcon(new ImageIcon(gImage));
			iPanel.add(iL);
			westBlock.add(iPanel, BorderLayout.NORTH);
			revalidate();
			repaint();
			
			gText.setText("");
			String str = "";
			Scanner reader = new Scanner(new File("Lair of Shadows SwampBossZone Vine Covered Mass.txt"));
			while (reader.hasNext()){
				str = reader.nextLine();	
				gText.append(str);
				gText.append("\n");
			}
			gText.append("\n");
			reader=new Scanner(new File("Lair of Shadows Story Enemy Mage Medusa.txt"));
			while (reader.hasNext()){
				str = reader.nextLine();	
				gText.append(str);
				gText.append("\n");
			}
			createSwampSubBoss();
		}
		else{
			swamp=false;
			gText.append("\n"+"You have cleared the Swamp Zone!\n");
			subzone1=true;
			subzone2=true;
			subBoss=true;
			subFight=false;
			
			//Clearing out the western block
			westBlock.removeAll();
			dirButtonPanel.removeAll();
			statPanel.removeAll();
			iPanel.removeAll();
			revalidate();
			repaint();
			
			launchGame(playerType);	
		}
	}
	
	//Determines the event to occur.
	//Player may end up with a random event or 
	//fighting against an enemy
	public void launchEvent() {
		int event=Bob_the_AI.randomize(0, 3);
		switch(event){
		case 0:
			gText.append("\n"+"Enemy Encounter!"+"\n");
			createEnemy();
			launchCombat();
			break;
		case 1:
			gText.append("\n"+"Enemy Encounter!"+"\n");
			createEnemy();
			launchCombat();
			break;
		case 2:
			gText.append("\n"+"Enemy Encounter!"+"\n");
			createEnemy();
			launchCombat();
			break;
		case 3:
			//Random Encounter
			randomEcounter();
			break;
		default:
			System.out.println("\n"+"Catostraphic Disaster!!!!!!!"+"\n");
			break;
		}
	}
	
	public void randomEcounter(){
		int rdm=Bob_the_AI.randomize(0, 7);
		gText.append("\n");
		switch(rdm)
		{
		case 0:
			gText.append("You met a farmer who would like you to stay for Dinner.");
			gText.append("\n");
			player.adjHealth( (int) (player.getHealth()*.05));
			currentHealth=player.getHealth();
			currentAttackForce=player.getAttackForce();
			currentDefense=player.getDefense();
			currentSpecialStat=player.getSpecialStat();
			currentLevel=player.getLevel();
			
			hText = new healthText(currentHealth);
			afText = new attackText(currentAttackForce);
			dText = new defenseText(currentDefense);
			
			westBlock.remove(statPanel);
			statPanel.removeAll();
			statPanel.add(hText);
			statPanel.add(afText);
			statPanel.add(dText);
			statPanel.setPreferredSize(new Dimension(200, 100));
			westBlock.add(statPanel, BorderLayout.CENTER);
			revalidate();
			repaint();
			launchEvent();
			break;
		case 1:
			gText.append("A troll snuck into your camp over night"+"\n"
					+"and blunted your weapon!");
			gText.append("\n");
			player.adjAttackForce((int) (player.getAttackForce()*.05)*-1);
			currentHealth=player.getHealth();
			currentAttackForce=player.getAttackForce();
			currentDefense=player.getDefense();
			currentSpecialStat=player.getSpecialStat();
			currentLevel=player.getLevel();
			
			hText = new healthText(currentHealth);
			afText = new attackText(currentAttackForce);
			dText = new defenseText(currentDefense);
			
			westBlock.remove(statPanel);
			statPanel.removeAll();
			statPanel.add(hText);
			statPanel.add(afText);
			statPanel.add(dText);
			statPanel.setPreferredSize(new Dimension(200, 100));
			westBlock.add(statPanel, BorderLayout.CENTER);
			revalidate();
			repaint();
			launchEvent();
			break;
		case 2:
			gText.append("You found a health potion hidden behind a rock");
			gText.append("\n");
			player.adjHealth( (int) (player.getHealth()*.10));
			currentHealth=player.getHealth();
			currentAttackForce=player.getAttackForce();
			currentDefense=player.getDefense();
			currentSpecialStat=player.getSpecialStat();
			currentLevel=player.getLevel();
			
			hText = new healthText(currentHealth);
			afText = new attackText(currentAttackForce);
			dText = new defenseText(currentDefense);
			
			westBlock.remove(statPanel);
			statPanel.removeAll();
			statPanel.add(hText);
			statPanel.add(afText);
			statPanel.add(dText);
			statPanel.setPreferredSize(new Dimension(200, 100));
			westBlock.add(statPanel, BorderLayout.CENTER);
			revalidate();
			repaint();
			launchEvent();
			break;
		case 3:
			gText.append("A local armorer has heard tales of your struggle"+"\n"+"and wants to help."
					+ "\n" + "He fine tunes your weapon!");
			gText.append("\n");
			player.adjAttackForce((int) (player.getAttackForce()*.03));
			currentHealth=player.getHealth();
			currentAttackForce=player.getAttackForce();
			currentDefense=player.getDefense();
			currentSpecialStat=player.getSpecialStat();
			currentLevel=player.getLevel();
			
			hText = new healthText(currentHealth);
			afText = new attackText(currentAttackForce);
			dText = new defenseText(currentDefense);
			
			westBlock.remove(statPanel);
			statPanel.removeAll();
			statPanel.add(hText);
			statPanel.add(afText);
			statPanel.add(dText);
			statPanel.setPreferredSize(new Dimension(200, 100));
			westBlock.add(statPanel, BorderLayout.CENTER);
			revalidate();
			repaint();
			launchEvent();
			break;
		case 4:
			gText.append("You find and eat some bad mushrooms. " +
					"\n"+"You fall and ill and your Defense falls as a result");
			gText.append("\n");
			player.adjDefense((int) (player.getDefense()*.05)*-1);
			currentHealth=player.getHealth();
			currentAttackForce=player.getAttackForce();
			currentDefense=player.getDefense();
			currentSpecialStat=player.getSpecialStat();
			currentLevel=player.getLevel();
			
			hText = new healthText(currentHealth);
			afText = new attackText(currentAttackForce);
			dText = new defenseText(currentDefense);
			
			westBlock.remove(statPanel);
			statPanel.removeAll();
			statPanel.add(hText);
			statPanel.add(afText);
			statPanel.add(dText);
			statPanel.setPreferredSize(new Dimension(200, 100));
			westBlock.add(statPanel, BorderLayout.CENTER);
			revalidate();
			repaint();
			launchEvent();
			break;
		case 5:
			gText.append("Ralph the shield maker upgrades your " +
					"\n"+"defensive equipment in exchange for pint of local ale!");
			gText.append("\n");
			player.adjDefense((int) (player.getDefense()*.05));
			currentHealth=player.getHealth();
			currentAttackForce=player.getAttackForce();
			currentDefense=player.getDefense();
			currentSpecialStat=player.getSpecialStat();
			currentLevel=player.getLevel();
			
			hText = new healthText(currentHealth);
			afText = new attackText(currentAttackForce);
			dText = new defenseText(currentDefense);
			
			westBlock.remove(statPanel);
			statPanel.removeAll();
			statPanel.add(hText);
			statPanel.add(afText);
			statPanel.add(dText);
			statPanel.setPreferredSize(new Dimension(200, 100));
			westBlock.add(statPanel, BorderLayout.CENTER);
			revalidate();
			repaint();
			launchEvent();
			break;
		case 6:
			gText.append("A fairy appears out of nowhere and heals your wounds!");
			gText.append("\n");
			player.adjHealth( (int) (player.getHealth()*.025));
			currentHealth=player.getHealth();
			currentAttackForce=player.getAttackForce();
			currentDefense=player.getDefense();
			currentSpecialStat=player.getSpecialStat();
			currentLevel=player.getLevel();
			
			hText = new healthText(currentHealth);
			afText = new attackText(currentAttackForce);
			dText = new defenseText(currentDefense);
			
			westBlock.remove(statPanel);
			statPanel.removeAll();
			statPanel.add(hText);
			statPanel.add(afText);
			statPanel.add(dText);
			statPanel.setPreferredSize(new Dimension(200, 100));
			westBlock.add(statPanel, BorderLayout.CENTER);
			revalidate();
			repaint();
			launchEvent();
			break;
		case 7: 
			gText.append("A satyr at play throws a rock at your head while you sleep!"+"\n"+"Ouch!");
			gText.append("\n");
			player.adjHealth( (int) (player.getHealth()*.05)*-1);
			currentHealth=player.getHealth();
			currentAttackForce=player.getAttackForce();
			currentDefense=player.getDefense();
			currentSpecialStat=player.getSpecialStat();
			currentLevel=player.getLevel();
			
			hText = new healthText(currentHealth);
			afText = new attackText(currentAttackForce);
			dText = new defenseText(currentDefense);
			
			westBlock.remove(statPanel);
			statPanel.removeAll();
			statPanel.add(hText);
			statPanel.add(afText);
			statPanel.add(dText);
			statPanel.setPreferredSize(new Dimension(200, 100));
			westBlock.add(statPanel, BorderLayout.CENTER);
			revalidate();
			repaint();
			launchEvent();
			break;
		default:
			System.out.println("Your Random Event encounter code is broken");
			break;	
		}
	}
	
	public void createEnemy(){
		int e = Randomizer.randomize(0, 2);
		//Generate a Randomizer.random multiple between 25% and 100%
		double botStatsMultiplier =(double) Randomizer.randomize(25, 75)/100;
		
		//The bot stats will be used as the initial stats for our bots
		//created by the following switch statement.
		int botHealth =(int) (botStatsMultiplier*player.getHealth());
		int botDefense = (int)(botStatsMultiplier*player.getDefense());
		int botAttackForce =(int) (botStatsMultiplier*player.getAttackForce());
		
		switch(e){
		case 0:
			//create a warrior enemy
			//Special Attribute Focus will be a product 1/2 the bots health
			Warrior warBot = new Warrior(botHealth, botAttackForce, botDefense, (int) (botHealth*.5));
			Enemy=new Warrior(warBot);
			enemyType='w';
			break;
		case 1:
			//create a rogue enemy
			//Special Attribute Agility will be a product 1/2 the bots health
			Rogue rogueBot = new Rogue(botHealth, botAttackForce, botDefense, (int) (botHealth*.5));
			Enemy=new Rogue(rogueBot);
			enemyType='r';
			break;
		case 2:
			//create a mage enemy
			//Special Attribute Mana will be a product 1/2 the bots health
			Mage mageBot = new Mage(botHealth, botAttackForce, botDefense, (int) (botHealth*.5));
			Enemy=new Mage(mageBot);
			enemyType='m';
			break;
		default:
			System.out.println("You should not reach this code in create an enemy");
		}
	}
	
	//Combat panel
	public void launchCombat(){
		westBlock.remove(dirButtonPanel);
		dirButtonPanel.removeAll();
		switch(playerType){
		case 'w':
			dirButtonPanel=new warriorPanel(currentSpecialStat);
			westBlock.add(dirButtonPanel, BorderLayout.SOUTH);
			dirButtonPanel.revalidate();
			dirButtonPanel.repaint();
			revalidate();
			repaint();
			break;
		case 'm':
			dirButtonPanel=new magePanel(currentSpecialStat);
			westBlock.add(dirButtonPanel, BorderLayout.SOUTH);
			dirButtonPanel.revalidate();
			dirButtonPanel.repaint();
			revalidate();
			repaint();
			break;
		case 'r':
			dirButtonPanel=new roguePanel(currentSpecialStat);
			westBlock.add(dirButtonPanel, BorderLayout.SOUTH);
			dirButtonPanel.revalidate();
			dirButtonPanel.repaint();
			revalidate();
			repaint();
			break;
		default:
			System.out.println("Combat Error!");
		}
	}
	
	public void theCombat() throws IOException{
		int pDamage=0;
		int eDamage=0;
		switch(playerType){
		case 'w':
			if (attackType.equals("Basic Attack")){
				pDamage =(int)((((double)player.getAttackForce())*((double) Randomizer.randomize(80, 150)/100))
						-(((double)Enemy.getDefense())*((double) Randomizer.randomize(20, 50)/100)));
			}
			else if(attackType.equals("Power Strike")){
				pDamage = (int)((((double)player.getAttackForce())*((double) Randomizer.randomize(125, 200)/100))
						-(((double)Enemy.getDefense())*((double) Randomizer.randomize(20, 50)/100)));
				currentSpecialStat-= 10;
			}
			else if(attackType.equals("Block")){
				currentDefense+=(int)(((double)player.getDefense())*((double) Randomizer.randomize(25, 50)/100));
				Enemy.setDefense((int)(Enemy.getDefense() * (((double)(Randomizer.randomize(5, 20)))/100)));
				currentSpecialStat-= 10;
			}
			break;
		case 'r':
			if (attackType.equals("Basic Attack")){
				pDamage =(int)((((double)player.getAttackForce())*((double) Randomizer.randomize(80, 150)/100))
						-(((double)Enemy.getDefense())*((double) Randomizer.randomize(20, 50)/100)));
			}
			else if(attackType.equals("Critical Strike")){
				pDamage = (int)((((double)player.getAttackForce())*((double) Randomizer.randomize(125, 200)/100))
						-(((double)Enemy.getDefense())*((double) Randomizer.randomize(20, 50)/100)));
				currentSpecialStat-= 10;
			}
			else if(attackType.equals("Disarm")){
				Enemy.setAttackForce((int)(((double)Enemy.getAttackForce())*((double) Randomizer.randomize(20, 50)/100)));
				currentSpecialStat-= 10;
			}
			break;
		case 'm':
			if (attackType.equals("Basic Attack")){
				pDamage = (int)((((double)player.getAttackForce())*((double) Randomizer.randomize(80, 150)/100))
						-(((double)Enemy.getDefense())*((double) Randomizer.randomize(20, 50)/100)));
			}
			else if(attackType.equals("Cast")){
				pDamage = (int)((((double)player.getAttackForce())*((double) Randomizer.randomize(125, 200)/100))
						-(((double)Enemy.getDefense())*((double) Randomizer.randomize(20, 50)/100)));
				currentSpecialStat-= 10;
			}
			else if(attackType.equals("Heal")){
				currentHealth+=((int)(((double)player.getHealth())+((double) Randomizer.randomize(25, 75)/100)));
				currentSpecialStat-= 10;
			}
			break;
		default:
			System.out.println("Combat Error!");
		}
		gText.append("\n");
		//Enemy attack
		int eAtx;
		if(fightRound>=5){
			eAtx=0;
		}
		else{
			eAtx=Randomizer.randomize(0, 1);
		}
		switch(enemyType){
		case 'w':
			if (eAtx==0){
				gText.append("Enemy launches his basic attack!\n");
				eDamage=(int)((((double)Enemy.getAttackForce())*((double) Randomizer.randomize(80, 150)/100))
						-(((double)player.getDefense())*((double) Randomizer.randomize(20, 50)/100)));
			}
			else if(eAtx==1){
				gText.append("Enemy launches Power Strike!\n");
				eDamage=(int)((((double)Enemy.getAttackForce())*((double) Randomizer.randomize(125, 200)/100))
						-(((double)player.getDefense())*((double) Randomizer.randomize(20, 50)/100)));
			}
			break;
		case 'r':
			if (eAtx==0){
				gText.append("Enemy launches his basic attack!\n");
				eDamage=(int)((((double)Enemy.getAttackForce())*((double) Randomizer.randomize(80, 150)/100))
						-(((double)player.getDefense())*((double) Randomizer.randomize(20, 50)/100)));
			}
			else if(eAtx==1){
				gText.append("Enemy launches Critical Strike!\n");
				eDamage=(int)((((double)Enemy.getAttackForce())*((double) Randomizer.randomize(125, 200)/100))
						-(((double)player.getDefense())*((double) Randomizer.randomize(20, 50)/100)));
			}
			break;
		case 'm':
			if (eAtx==0){
				gText.append("Enemy launches his basic attack!\n");
				eDamage=(int)((((double)Enemy.getAttackForce())*((double) Randomizer.randomize(80, 150)/100))
						-(((double)player.getDefense())*((double) Randomizer.randomize(20, 50)/100)));
			}
			else if(eAtx==1){
				gText.append("Enemy casts a spell!\n");
				eDamage=(int)((((double)Enemy.getAttackForce())*((double) Randomizer.randomize(125, 200)/100))
						-(((double)player.getDefense())*((double) Randomizer.randomize(20, 50)/100)));
			}
			break;
		default:
			System.out.println("Combat Error!");
		}
		
		if(pDamage<0){
			Enemy.adjHealth(pDamage);
		}
		else{
			Enemy.adjHealth((-1*pDamage));
		}
		
		if(eDamage<0){
			currentHealth+=eDamage;
		}
		else{
			currentHealth-=eDamage;
		}
		
		gText.append("Your Health: "+currentHealth+" Enemy Health: "+Enemy.getHealth()+"\n");
		
		if(Enemy.getHealth()<=0){
			fightRound=0;
			gText.setText("");
			gText.append("Enemy Terminated!\n");
			if(BossFight){
				Victory();
			}
			else if (subFight){
				player.incXP(10);
				subBoss=false;
				switch(location){
				case 'd':
					desertZone();
					break;
				case 'f':
					forestZone();
					break;
				case 's':
					swampZone();
					break;
				default:
					System.out.println("Checkout The Combat!");
				}
			}
			else{
				player.incXP(5);
				levelCheck();
			}
		}
		else if(currentHealth<=0){
			GameOver();
		}
		else{
			fightRound++;
			launchCombat();
		}
	}
	
	public void createDesertSubBoss(){
		//Desert Sub Boss Image
		westBlock.remove(iPanel);
		iPanel.removeAll();
		iL.setIcon(null);
		try {
			gImage = ImageIO.read(new File("cerberus.jpg"));
		} catch (IOException e) {
			System.out.println("Check the Image SHIT!");
		}
		gImage = gImage.getScaledInstance(200, 300, 5);
		iL.setIcon(new ImageIcon(gImage));
		iPanel.add(iL);
		westBlock.add(iPanel, BorderLayout.NORTH);
		revalidate();
		repaint();
		
		subFight=true;
		int botHealth = ((player.getHealth()*90)/100);
		int botDefense = ((player.getDefense()*90)/100);
		int botAttackForce = ((player.getAttackForce()*90)/100);
		Enemy=new Warrior(botHealth, botAttackForce, botDefense, botHealth);
		launchCombat();
	}

	public void createForestSubBoss(){
		//Forest Sub Boss Image
		westBlock.remove(iPanel);
		iPanel.removeAll();
		iL.setIcon(null);
		try {
			gImage = ImageIO.read(new File("hermes.jpg"));
		} catch (IOException e) {
			System.out.println("Check the Image SHIT!");
		}
		gImage = gImage.getScaledInstance(200, 300, 5);
		iL.setIcon(new ImageIcon(gImage));
		iPanel.add(iL);
		westBlock.add(iPanel, BorderLayout.NORTH);
		revalidate();
		repaint();
		
		subFight=true;
		int botHealth = ((player.getHealth()*90)/100);
		int botDefense = ((player.getDefense()*90)/100);
		int botAttackForce = ((player.getAttackForce()*90)/100);
		Enemy=new Rogue(botHealth, botAttackForce, botDefense, botHealth);
		launchCombat();
	}
	
	public void createSwampSubBoss(){
		//Swamp Sub Boss Image
		westBlock.remove(iPanel);
		iPanel.removeAll();
		iL.setIcon(null);
		try {
			gImage = ImageIO.read(new File("medusa.jpg"));
		} catch (IOException e) {
			System.out.println("Check the Image SHIT!");
		}
		gImage = gImage.getScaledInstance(200, 300, 5);
		iL.setIcon(new ImageIcon(gImage));
		iPanel.add(iL);
		westBlock.add(iPanel, BorderLayout.NORTH);
		revalidate();
		repaint();
		
		subFight=true;
		int botHealth = ((player.getHealth()*90)/100);
		int botDefense = ((player.getDefense()*90)/100);
		int botAttackForce = ((player.getAttackForce()*90)/100);
		Enemy=new Mage(botHealth, botAttackForce, botDefense, botHealth);
		launchCombat();
	}
	
	public void createFinalBoss(){
		//Final Boss Image
		westBlock.remove(iPanel);
		iPanel.removeAll();
		iL.setIcon(null);
		try {
			gImage = ImageIO.read(new File("mastermind.jpg"));
		} catch (IOException e) {
			System.out.println("Check the Image SHIT!");
		}
		gImage = gImage.getScaledInstance(200, 300, 5);
		iL.setIcon(new ImageIcon(gImage));
		iPanel.add(iL);
		westBlock.add(iPanel, BorderLayout.NORTH);
		revalidate();
		repaint();
		
		//Dialogue
		gText.append("\n");
		gText.append("The Boss:"+"\n");
		gText.append("There is no way you can save the world!"+"\n");
		gText.append("For you must kill me first!"+"\n");
		gText.append("\n");
		gText.append("Player: Challenge Accepted."+"\n");
		gText.append("\n");
		gText.append("The Boss: Don't you understand you FOOL! " +"\n"+
				"YOU WILL DIE!"+"\n");
		gText.append("\n");
		gText.append("Player: Life is cheap. Especially mine."+"\n");
		
		//Create a boss bot that is a mirror of the player		
		int botHealth = player.getHealth();		
		int botDefense =player.getDefense();
		int botAttackForce = player.getAttackForce();
		Enemy = new Warrior(botHealth, botAttackForce, botDefense, botHealth);
		//The boss and the player fight until one are dead
		enemyType='w';
		BossFight=true;
		launchCombat();
	}
	
	public void GameOver(){
		this.getContentPane().removeAll();
		
		JPanel failureText = new JPanel();
		failureText.setLayout(new GridLayout(2, 1, 1, 1));
		failureText.setForeground(Color.green);
		failureText.setBackground(Color.black);

		JLabel cName = new JLabel("CATASTROPHIC!");
		cName.setFont(new Font("Helevetica", Font.BOLD, 60));
		cName.setForeground(Color.green);
		cName.setBackground(Color.black);
		cName.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel pName = new JLabel("FAILURE!");
		pName.setFont(new Font("Helevetica", Font.BOLD, 60));
		pName.setForeground(Color.green);
		pName.setBackground(Color.black);
		pName.setHorizontalAlignment(SwingConstants.CENTER);
		
		failureText.add(cName);
		failureText.add(pName);
		failureText.setPreferredSize(new Dimension(700, 500));
		
		this.setContentPane(failureText);
		this.revalidate();
		this.repaint();
	}
	
	public void Victory(){
		this.getContentPane().removeAll();
		
		JTextArea victoryText = new JTextArea();
		victoryText.setForeground(Color.green);
		victoryText.setBackground(Color.black);
		victoryText.setFont(new Font("Helevetica", Font.BOLD, 60));
		victoryText.append("VICTORY!\n");
		victoryText.append("YOU HAVE SAVED\n");
		victoryText.append("THE WORLD!\n");
		victoryText.setPreferredSize(new Dimension(700, 500));
		
		this.setContentPane(victoryText);
		this.revalidate();
		this.repaint();
	}
	
	public void levelCheck() throws IOException{
		player.calculateLevel();
		
		if(currentLevel!=player.getLevel()){
			player.levelUp();
			currentHealth=player.getHealth();
			currentAttackForce=player.getAttackForce();
			currentDefense=player.getDefense();
			currentSpecialStat=player.getSpecialStat();
			currentLevel=player.getLevel();
			
			hText = new healthText(currentHealth);
			afText = new attackText(currentAttackForce);
			dText = new defenseText(currentDefense);
			
			westBlock.remove(statPanel);
			statPanel.removeAll();
			statPanel.add(hText);
			statPanel.add(afText);
			statPanel.add(dText);
			statPanel.setPreferredSize(new Dimension(200, 100));
			westBlock.add(statPanel, BorderLayout.CENTER);
			revalidate();
			repaint();
			
			
			if(subzone1){
				subzone1=false;
				switch(location){
				case 'd':
					desertZone();
					break;
				case 'f':
					forestZone();
					break;
				case 's':
					swampZone();
					break;
				default:
					System.out.println("Checkout Level Check!");
				}
			}
			else if(subzone2){
				subzone2=false;
				switch(location){
				case 'd':
					desertZone();
					break;
				case 'f':
					forestZone();
					break;
				case 's':
					swampZone();
					break;
				default:
					System.out.println("Checkout Level Check!");
				}
			}
		}
		else{
			currentHealth=player.getHealth();
			currentAttackForce=player.getAttackForce();
			currentDefense=player.getDefense();
			currentSpecialStat=player.getSpecialStat();
			currentLevel=player.getLevel();
			
			hText = new healthText(currentHealth);
			afText = new attackText(currentAttackForce);
			dText = new defenseText(currentDefense);
			
			westBlock.remove(statPanel);
			statPanel.removeAll();
			statPanel.add(hText);
			statPanel.add(afText);
			statPanel.add(dText);
			statPanel.setPreferredSize(new Dimension(200, 100));
			westBlock.add(statPanel, BorderLayout.CENTER);
			revalidate();
			repaint();
			launchEvent();
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
			} else if (initChoice.equals("Quit Game")) {
				setVisible(false);
				dispose();

			}
		}
	}

	class classListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			String cChoice = event.getActionCommand();
			if (cChoice.equals("Warrior")) {
				player = new Warrior();
				playerType = 'w';
				try {
					launchGame(playerType);
				} catch (IOException e) {
					System.out.println("FAILURE!");
				}
			} else if (cChoice.equals("Mage")) {
				player = new Mage();
				playerType = 'm';
				try {
					launchGame(playerType);
				} catch (IOException e) {
					System.out.println("FAILURE!");
				}
			} else if (cChoice.equals("Rogue")) {
				player = new Rogue();
				playerType = 'r';
				try {
					launchGame(playerType);
				} catch (IOException e) {
					System.out.println("FAILURE!");
				}
			}
		}
	}

	class dirListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			String cChoice = event.getActionCommand();
			if (cChoice.equals("Desert")) {
				File fOpen = new File("Lair of Shadows Story Desert.txt");
				try {
					fileReader = new FileReader(fOpen);
				} catch (FileNotFoundException e1) {
					System.out.println("DIR! ERROR! FILE");
				}
				try {
					gText.read(fileReader, fOpen.toString());
				} catch (IOException e) {
					System.out.println("DIR! ERROR! IO!");
				}
				location = 'd';
				westBlock.remove(dirButtonPanel);
				revalidate();
				repaint();
				try {
					desertZone();
				} catch (IOException e) {
					System.out.println("Check Desert Zone Stuff!");
				}
			} else if (cChoice.equals("Forest")) {
				File fOpen = new File("Lair of Shadows Story Forest.txt");
				try {
					fileReader = new FileReader(fOpen);
				} catch (FileNotFoundException e1) {
					System.out.println("DIR! ERROR! FILE");
				}
				try {
					gText.read(fileReader, fOpen.toString());
				} catch (IOException e) {
					System.out.println("DIR! ERROR! IO!");
				}
				location = 'f';
				westBlock.remove(dirButtonPanel);
				revalidate();
				repaint();
				try {
					forestZone();
				} catch (IOException e) {
					System.out.println("Check Forest Zone Stuff!");
				}
			} else if (cChoice.equals("Swamp")) {
				File fOpen = new File("Lair of Shadows Story Swamp.txt");
				try {
					fileReader = new FileReader(fOpen);
				} catch (FileNotFoundException e1) {
					System.out.println("DIR! ERROR! FILE");
				}
				try {
					gText.read(fileReader, fOpen.toString());
				} catch (IOException e) {
					System.out.println("DIR! ERROR! IO!");
				}
				location = 's';
				westBlock.remove(dirButtonPanel);
				revalidate();
				repaint();
				try {
					swampZone();
				} catch (IOException e) {
					System.out.println("Check Swamp Zone Stuff!");
				}
			}
		}
	}

	class directionPanel extends JPanel {
		public directionPanel(boolean d, boolean f, boolean s) {
			ActionListener dirListener = new dirListener();
			this.setLayout(new GridLayout(3, 1, 4, 4));
			this.setForeground(Color.green);
			this.setBackground(Color.black);

			if (d & f & s) {
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

				JButton lButton = new JButton("Swamp");
				lButton.setFont(new Font("Helevetica", Font.BOLD, 12));
				lButton.setForeground(Color.green);
				lButton.setBackground(Color.black);
				lButton.setHorizontalAlignment(SwingConstants.CENTER);
				lButton.addActionListener(dirListener);

				this.add(dButton);
				this.add(fButton);
				this.add(lButton);
				this.setPreferredSize(new Dimension(200, 100));
			} else if (d & f) {
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
			} else if (d & s) {
				JButton dButton = new JButton("Desert");
				dButton.setFont(new Font("Helevetica", Font.BOLD, 12));
				dButton.setForeground(Color.green);
				dButton.setBackground(Color.black);
				dButton.setHorizontalAlignment(SwingConstants.CENTER);
				dButton.addActionListener(dirListener);

				JButton lButton = new JButton("Swamp");
				lButton.setFont(new Font("Helevetica", Font.BOLD, 12));
				lButton.setForeground(Color.green);
				lButton.setBackground(Color.black);
				lButton.setHorizontalAlignment(SwingConstants.CENTER);
				lButton.addActionListener(dirListener);

				this.add(dButton);
				this.add(lButton);
				this.setPreferredSize(new Dimension(200, 100));
			} else if (f & s) {
				JButton fButton = new JButton("Forest");
				fButton.setFont(new Font("Helevetica", Font.BOLD, 12));
				fButton.setForeground(Color.green);
				fButton.setBackground(Color.black);
				fButton.setHorizontalAlignment(SwingConstants.CENTER);
				fButton.addActionListener(dirListener);

				JButton lButton = new JButton("Swamp");
				lButton.setFont(new Font("Helevetica", Font.BOLD, 12));
				lButton.setForeground(Color.green);
				lButton.setBackground(Color.black);
				lButton.setHorizontalAlignment(SwingConstants.CENTER);
				lButton.addActionListener(dirListener);

				this.add(fButton);
				this.add(lButton);
				this.setPreferredSize(new Dimension(200, 100));
			} else if (d) {
				JButton dButton = new JButton("Desert");
				dButton.setFont(new Font("Helevetica", Font.BOLD, 12));
				dButton.setForeground(Color.green);
				dButton.setBackground(Color.black);
				dButton.setHorizontalAlignment(SwingConstants.CENTER);
				dButton.addActionListener(dirListener);
				this.add(dButton);
				this.setPreferredSize(new Dimension(200, 100));
			} else if (f) {
				JButton fButton = new JButton("Forest");
				fButton.setFont(new Font("Helevetica", Font.BOLD, 12));
				fButton.setForeground(Color.green);
				fButton.setBackground(Color.black);
				fButton.setHorizontalAlignment(SwingConstants.CENTER);
				fButton.addActionListener(dirListener);

				this.add(fButton);
				this.setPreferredSize(new Dimension(200, 100));
			} else if (s) {
				JButton lButton = new JButton("Swamp");
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


	class healthText extends JTextArea {
		public healthText() {
			this.setText("Health: ");
			this.setFont(new Font("Helevetica", Font.BOLD, 12));
			this.setForeground(Color.green);
			this.setBackground(Color.black);
		}
		
		public healthText(int h){
			this.setText("Health: "+h);
			this.setFont(new Font("Helevetica", Font.BOLD, 12));
			this.setForeground(Color.green);
			this.setBackground(Color.black);
		}
		
		public void updateText(int h) {
			this.setText("Health: "+h);
		}
	}

	class attackText extends JTextArea {
		public attackText() {
			this.setText("Attack Force: ");
			this.setFont(new Font("Helevetica", Font.BOLD, 12));
			this.setForeground(Color.green);
			this.setBackground(Color.black);
		}
		public attackText(int a){
			this.setText("Attack Force: "+a);
			this.setFont(new Font("Helevetica", Font.BOLD, 12));
			this.setForeground(Color.green);
			this.setBackground(Color.black);
		}

		public void updateText(int a) {
			this.setText("Attack Force: "+a);
		}
	}

	class defenseText extends JTextArea {
		public defenseText() {
			this.setText("Defense: ");
			this.setFont(new Font("Helevetica", Font.BOLD, 12));
			this.setForeground(Color.green);
			this.setBackground(Color.black);
		}
		public defenseText(int d){
			this.setText("Defense: "+d);
			this.setFont(new Font("Helevetica", Font.BOLD, 12));
			this.setForeground(Color.green);
			this.setBackground(Color.black);
		}

		public void updateText(int d) {
			this.setText("Defense: "+d);
		}
	}

	class combatListener implements ActionListener{
		public void actionPerformed(ActionEvent event) {
			String cChoice = event.getActionCommand();
			if (cChoice.equals("Basic Attack")) {
				attackType=cChoice;
				try {
					theCombat();
				} catch (IOException e) {
					System.out.println("Check combat listener!");
				}
			} 
			else if (cChoice.equals("Power Strike")) {
				attackType=cChoice;
				try {
					theCombat();
				} catch (IOException e) {
					System.out.println("Check combat listener!");
				}
			} 
			else if (cChoice.equals("Block")) {
				attackType=cChoice;
				try {
					theCombat();
				} catch (IOException e) {
					System.out.println("Check combat listener!");
				}
			}
			else if(cChoice.equals("Critical Strike")){
				attackType=cChoice;
				try {
					theCombat();
				} catch (IOException e) {
					System.out.println("Check combat listener!");
				}
			}
			else if(cChoice.equals("Disarm")){
				attackType=cChoice;
				try {
					theCombat();
				} catch (IOException e) {
					System.out.println("Check combat listener!");
				}
			}
			else if(cChoice.equals("Cast")){
				attackType=cChoice;
				try {
					theCombat();
				} catch (IOException e) {
					System.out.println("Check combat listener!");
				}
			}
			else if(cChoice.equals("Heal")){
				attackType=cChoice;
				try {
					theCombat();
				} catch (IOException e) {
					System.out.println("Check combat listener!");
				}
			}
			else if(cChoice.equals("Run Away")){
				gText.append("\n"+"You Ran Away!"+"\n"+"You Coward!"
						+"\n"+"WHO do you think you are THE DOCTOR?"+"\n");
				launchEvent();
			}
		}
	}
	
	class warriorPanel extends JPanel{
		public warriorPanel(int s){
			ActionListener combatListener = new combatListener();
			this.setForeground(Color.green);
			this.setBackground(Color.black);
			
			if (s>=10){
				this.setLayout(new GridLayout(4, 1, 4, 4));
				
				JButton baButton = new JButton("Basic Attack");
				baButton.setFont(new Font("Helevetica", Font.BOLD, 12));
				baButton.setForeground(Color.green);
				baButton.setBackground(Color.black);
				baButton.setHorizontalAlignment(SwingConstants.CENTER);
				baButton.addActionListener(combatListener);
				
				JButton pButton = new JButton("Power Strike");
				pButton.setFont(new Font("Helevetica", Font.BOLD, 12));
				pButton.setForeground(Color.green);
				pButton.setBackground(Color.black);
				pButton.setHorizontalAlignment(SwingConstants.CENTER);
				pButton.addActionListener(combatListener);
				
				JButton blButton = new JButton("Block");
				blButton.setFont(new Font("Helevetica", Font.BOLD, 12));
				blButton.setForeground(Color.green);
				blButton.setBackground(Color.black);
				blButton.setHorizontalAlignment(SwingConstants.CENTER);
				blButton.addActionListener(combatListener);
				
				JButton rButton = new JButton("Run Away");
				rButton.setFont(new Font("Helevetica", Font.BOLD, 12));
				rButton.setForeground(Color.green);
				rButton.setBackground(Color.black);
				rButton.setHorizontalAlignment(SwingConstants.CENTER);
				rButton.addActionListener(combatListener);
				
				this.add(baButton);
				this.add(pButton);
				this.add(blButton);
				this.add(rButton);
				this.setPreferredSize(new Dimension(200, 100));
			}
			else{
				this.setLayout(new GridLayout(2, 1, 4, 4));
				
				JButton baButton = new JButton("Basic Attack");
				baButton.setFont(new Font("Helevetica", Font.BOLD, 12));
				baButton.setForeground(Color.green);
				baButton.setBackground(Color.black);
				baButton.setHorizontalAlignment(SwingConstants.CENTER);
				baButton.addActionListener(combatListener);
				
				JButton rButton = new JButton("Run Away");
				rButton.setFont(new Font("Helevetica", Font.BOLD, 12));
				rButton.setForeground(Color.green);
				rButton.setBackground(Color.black);
				rButton.setHorizontalAlignment(SwingConstants.CENTER);
				rButton.addActionListener(combatListener);
				
				this.add(baButton);
				this.add(rButton);
				this.setPreferredSize(new Dimension(200, 100));
			}
		}
	}
	
	class magePanel extends JPanel{
		public magePanel(int s){
			ActionListener combatListener = new combatListener();
			this.setForeground(Color.green);
			this.setBackground(Color.black);
			
			if(s>=10){
				this.setLayout(new GridLayout(4, 1, 4, 4));
				JButton baButton = new JButton("Basic Attack");
				baButton.setFont(new Font("Helevetica", Font.BOLD, 12));
				baButton.setForeground(Color.green);
				baButton.setBackground(Color.black);
				baButton.setHorizontalAlignment(SwingConstants.CENTER);
				baButton.addActionListener(combatListener);
				
				JButton pButton = new JButton("Cast");
				pButton.setFont(new Font("Helevetica", Font.BOLD, 12));
				pButton.setForeground(Color.green);
				pButton.setBackground(Color.black);
				pButton.setHorizontalAlignment(SwingConstants.CENTER);
				pButton.addActionListener(combatListener);
				
				JButton blButton = new JButton("Heal");
				blButton.setFont(new Font("Helevetica", Font.BOLD, 12));
				blButton.setForeground(Color.green);
				blButton.setBackground(Color.black);
				blButton.setHorizontalAlignment(SwingConstants.CENTER);
				blButton.addActionListener(combatListener);
				
				JButton rButton = new JButton("Run Away");
				rButton.setFont(new Font("Helevetica", Font.BOLD, 12));
				rButton.setForeground(Color.green);
				rButton.setBackground(Color.black);
				rButton.setHorizontalAlignment(SwingConstants.CENTER);
				rButton.addActionListener(combatListener);
				
				this.add(baButton);
				this.add(pButton);
				this.add(blButton);
				this.add(rButton);
				this.setPreferredSize(new Dimension(200, 100));
			}
			else{
				this.setLayout(new GridLayout(2, 1, 4, 4));
				JButton baButton = new JButton("Basic Attack");
				baButton.setFont(new Font("Helevetica", Font.BOLD, 12));
				baButton.setForeground(Color.green);
				baButton.setBackground(Color.black);
				baButton.setHorizontalAlignment(SwingConstants.CENTER);
				baButton.addActionListener(combatListener);
				
				JButton rButton = new JButton("Run Away");
				rButton.setFont(new Font("Helevetica", Font.BOLD, 12));
				rButton.setForeground(Color.green);
				rButton.setBackground(Color.black);
				rButton.setHorizontalAlignment(SwingConstants.CENTER);
				rButton.addActionListener(combatListener);
				
				this.add(baButton);
				this.add(rButton);
				this.setPreferredSize(new Dimension(200, 100));
			}
		}
	}
	
	class roguePanel extends JPanel{
		public roguePanel(int s){
			ActionListener combatListener = new combatListener();
			this.setForeground(Color.green);
			this.setBackground(Color.black);
			
			if(s>=10){
				this.setLayout(new GridLayout(4, 1, 4, 4));
				JButton baButton = new JButton("Basic Attack");
				baButton.setFont(new Font("Helevetica", Font.BOLD, 12));
				baButton.setForeground(Color.green);
				baButton.setBackground(Color.black);
				baButton.setHorizontalAlignment(SwingConstants.CENTER);
				baButton.addActionListener(combatListener);
				
				JButton pButton = new JButton("Crtical Strike");
				pButton.setFont(new Font("Helevetica", Font.BOLD, 12));
				pButton.setForeground(Color.green);
				pButton.setBackground(Color.black);
				pButton.setHorizontalAlignment(SwingConstants.CENTER);
				pButton.addActionListener(combatListener);
				
				JButton blButton = new JButton("Disarm");
				blButton.setFont(new Font("Helevetica", Font.BOLD, 12));
				blButton.setForeground(Color.green);
				blButton.setBackground(Color.black);
				blButton.setHorizontalAlignment(SwingConstants.CENTER);
				blButton.addActionListener(combatListener);
				
				JButton rButton = new JButton("Run Away");
				rButton.setFont(new Font("Helevetica", Font.BOLD, 12));
				rButton.setForeground(Color.green);
				rButton.setBackground(Color.black);
				rButton.setHorizontalAlignment(SwingConstants.CENTER);
				rButton.addActionListener(combatListener);
				
				this.add(baButton);
				this.add(pButton);
				this.add(blButton);
				this.add(rButton);
				this.setPreferredSize(new Dimension(200, 100));
			}
			else{
				this.setLayout(new GridLayout(2, 1, 4, 4));
				JButton baButton = new JButton("Basic Attack");
				baButton.setFont(new Font("Helevetica", Font.BOLD, 12));
				baButton.setForeground(Color.green);
				baButton.setBackground(Color.black);
				baButton.setHorizontalAlignment(SwingConstants.CENTER);
				baButton.addActionListener(combatListener);
				
				JButton rButton = new JButton("Run Away");
				rButton.setFont(new Font("Helevetica", Font.BOLD, 12));
				rButton.setForeground(Color.green);
				rButton.setBackground(Color.black);
				rButton.setHorizontalAlignment(SwingConstants.CENTER);
				rButton.addActionListener(combatListener);
				
				this.add(baButton);
				this.add(rButton);
				this.setPreferredSize(new Dimension(200, 100));
			}
		}
	}
}
