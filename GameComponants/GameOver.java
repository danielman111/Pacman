package GameComponants;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/*Name: GameOver
propose: This class is the window that pops up when you lose
author: Gal Luvton and Daniel Sinaniev
Date Created: 27/6/2013
Last modification: 08/7/2013
*/

public class GameOver extends JFrame implements ActionListener{

	/*Fields*/
	//the 'ok' button in this form
	private JButton ok;
	//the 'ok' button's picture
	private final ImageIcon okPic= new ImageIcon(GameOver.class.getResource("/Resources/play again.jpg"));
	//the game over picture
	private final ImageIcon background= new ImageIcon(GameOver.class.getResource("/Resources/game over.jpg"));
	
	
	/*Behavior*/
	/*Constructors*/
	//creates a new ScoreLabel
	public GameOver(){
		super("Gamer over!");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JLabel pic= new JLabel();
		pic.setIcon(this.background);
		add(pic, BorderLayout.CENTER);
		this.ok= new JButton("");
		this.ok.setIcon(this.okPic);
		this.ok.setBorderPainted(false);
		this.ok.setOpaque(true);
		this.ok.setRolloverEnabled(false);
		this.ok.setContentAreaFilled(false);
		this.ok.setFocusPainted(false);
		this.ok.addActionListener(this);
		add(this.ok, BorderLayout.SOUTH);
		Dimension size = getToolkit().getScreenSize();	//sets the size of the menu and sets it to open mid-screen
		setLocation(size.width/2-getWidth()/2 - 350, size.height/2 - getHeight()/2 - 400);
		setSize(background.getIconWidth(), 705);
		getContentPane().setBackground(Color.BLACK);
		getContentPane().setForeground(Color.BLACK);
		setResizable(false);
		setVisible(true);
	}


	//starts a new game when the button is pressed
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.ok){
			GameFrame play= new GameFrame();
			dispose();
		}
	}
	
}//GameOver
