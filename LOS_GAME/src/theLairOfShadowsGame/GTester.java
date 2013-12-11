package theLairOfShadowsGame;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.io.*;
import javax.imageio.*;

public class GTester {
	public static void main(String[] args)throws IOException{
        JFrame frame = new Game_alt();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
	}
}