package TicTacToe;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TicTacToe implements ActionListener{

	// randomly whose turn it is first
	Random random = new Random();
	JFrame frame = new JFrame();
	JPanel title_panel = new JPanel();
	JPanel button_panel = new JPanel();
	JLabel textField = new JLabel();
	JButton[] buttons = new JButton[9]; // 3x3
	boolean player1_turn; // if this false, player 2's turn
	
	// constructor
	public TicTacToe() {
		// frame settings
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800,800);
		frame.getContentPane().setBackground(new Color(50,50,50));
		frame.setLayout(new BorderLayout());
		frame.setVisible(true);
		
		textField.setBackground(new Color(25,25,25));
		textField.setForeground(new Color(25,255,0));
		textField.setFont(new Font("Tahoma",Font.BOLD,75));
		textField.setHorizontalAlignment(JLabel.CENTER);
		textField.setText("Tic-Tac-Toe");
		textField.setOpaque(true);
		
		title_panel.setLayout(new BorderLayout());
		title_panel.setBounds(0,0,800,100);
		
		button_panel.setLayout(new GridLayout(3,3));
		button_panel.setBackground(new Color(150,150,150));
		
		// buttons add
		for(int i = 0; i < 9; i++) {
			buttons[i] = new JButton();
			button_panel.add(buttons[i]);
			buttons[i].setFont(new Font("MV Boli",Font.BOLD,120));
			buttons[i].setFocusable(false);
			buttons[i].addActionListener(this);
		}

		// add
		title_panel.add(textField);
		frame.add(title_panel, BorderLayout.NORTH);
		frame.add(button_panel);
		
		firstTurn();
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		for(int i = 0; i < 9; i++) { // check 9 buttons
			if(e.getSource() == buttons[i]) {
				if(player1_turn) {
					if(buttons[i].getText() == "") {
						buttons[i].setForeground(new Color(255,0,0)); // color for O
						buttons[i].setText("X"); // player 1 played.
						player1_turn = false;
						textField.setText("O turn");
						check();
					}
				} else {
					if(buttons[i].getText() == "") {
						buttons[i].setForeground(new Color(0,0,255)); // color for O
						buttons[i].setText("O"); // player 2 played.
						player1_turn = true;
						textField.setText("X turn");
						check();
					}
				}
			}
		}
	}
	
	// whose turn it first method. randomly
	public void firstTurn() {
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 0-> player 1 turn, 1-> player 2 turn
		if(random.nextInt(2) == 0) { // player1 is O
			player1_turn = true;
			textField.setText("X turn");
		}
		else {
			player1_turn = false;
			textField.setText("O turn");
		}
	}
	
	// check winnig conditions
	public void check() {
		// check X wins conditions
		if(
			(buttons[0].getText() == "X") && 
			(buttons[1].getText() == "X") && 
			(buttons[2].getText() == "X")) 
		{
			xWins(0,1,2);
		}
		if(
				(buttons[3].getText() == "X") && 
				(buttons[4].getText() == "X") && 
				(buttons[5].getText() == "X")) 
			{
				xWins(3,4,5);
			}
		if(
				(buttons[6].getText() == "X") && 
				(buttons[7].getText() == "X") && 
				(buttons[8].getText() == "X")) 
			{
				xWins(6,7,8);
			}
		if(
				(buttons[0].getText() == "X") && 
				(buttons[3].getText() == "X") && 
				(buttons[6].getText() == "X")) 
			{
				xWins(0,3,6);
			}
		if(
				(buttons[1].getText() == "X") && 
				(buttons[4].getText() == "X") && 
				(buttons[7].getText() == "X")) 
			{
				xWins(1,4,7);
			}
		if(
				(buttons[2].getText() == "X") && 
				(buttons[5].getText() == "X") && 
				(buttons[8].getText() == "X")) 
			{
				xWins(2,5,8);
			}
		if(
				(buttons[0].getText() == "X") && 
				(buttons[4].getText() == "X") && 
				(buttons[8].getText() == "X")) 
			{
				xWins(0,4,8);
			}
		if(
				(buttons[2].getText() == "X") && 
				(buttons[4].getText() == "X") && 
				(buttons[6].getText() == "X")) 
			{
				xWins(2,4,6);
			}
		
		
		// check O wins conditions
		if(
				(buttons[0].getText() == "O") && 
				(buttons[1].getText() == "O") && 
				(buttons[2].getText() == "O")) 
			{
				oWins(0,1,2);
			}
			if(
					(buttons[3].getText() == "O") && 
					(buttons[4].getText() == "O") && 
					(buttons[5].getText() == "O")) 
				{
					oWins(3,4,5);
				}
			if(
					(buttons[6].getText() == "O") && 
					(buttons[7].getText() == "O") && 
					(buttons[8].getText() == "O")) 
				{
					oWins(6,7,8);
				}
			if(
					(buttons[0].getText() == "O") && 
					(buttons[3].getText() == "O") && 
					(buttons[6].getText() == "O")) 
				{
					oWins(0,3,6);
				}
			if(
					(buttons[1].getText() == "O") && 
					(buttons[4].getText() == "O") && 
					(buttons[7].getText() == "O")) 
				{
					oWins(1,4,7);
				}
			if(
					(buttons[2].getText() == "O") && 
					(buttons[5].getText() == "O") && 
					(buttons[8].getText() == "O")) 
				{
					oWins(2,5,8);
				}
			if(
					(buttons[0].getText() == "O") && 
					(buttons[4].getText() == "O") && 
					(buttons[8].getText() == "O")) 
				{
					oWins(0,4,8);
				}
			if(
					(buttons[2].getText() == "O") && 
					(buttons[4].getText() == "O") && 
					(buttons[6].getText() == "O")) 
				{
					oWins(2,4,6);
				}
	}
	
	// winnig combinitions for X
	public void xWins(int a, int b, int c) { // a, b, c is button locations
		buttons[a].setBackground(Color.GREEN);
		buttons[b].setBackground(Color.GREEN);
		buttons[c].setBackground(Color.GREEN);
		for(int i = 0; i < 9; i++) {
			buttons[i].setEnabled(false);
		}
		textField.setText("X Wins!");
	}
	
	// winnig combinitions for O
		public void oWins(int a, int b, int c) {
			buttons[a].setBackground(Color.GREEN);
			buttons[b].setBackground(Color.GREEN);
			buttons[c].setBackground(Color.GREEN);
			for(int i = 0; i < 9; i++) {
				buttons[i].setEnabled(false);
			}
			textField.setText("O Wins!");
	}
}
