/*
 *  StudyCard - Index cards and studying made easy!
 *  Copyright (C) 2013  Michael Rosenberg (Miker525 & Obscure Software)
 *	http://github.com/Miker525 - http://MikeRosenberger.com
 *	
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 * 
 */

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.Window.Type;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class QuizForm extends JFrame {
	public static JTextField textField;
	private static JLabel label_1;
	private static int curcount = 00;
	public static int correct = 0;
	private static List<IndexCard> randlist = new ArrayList<IndexCard>();
	private static JLabel lblFcard;
	public static IndexCard icard;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QuizForm frame = new QuizForm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public QuizForm() {
		setType(Type.UTILITY);
		setResizable(false);
		setTitle("Quiz Mode Beta - Obscure Software");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setDefaultLookAndFeelDecorated(true);
		setBounds(100, 100, 330, 293);
		getContentPane().setLayout(null);
		addWindowListener(new WindowAdapter() {
			public void windowOpened(WindowEvent e) 
			{
				System.out.println("Window Open");
				for (int i=0;i<form.dlm.getSize();i++)
				{
					IndexCard poop;
					poop = (IndexCard)form.ich.getCardAt(i);
					randlist.add(poop);
					System.out.println(randlist.get(i).getFrontText());
				}
				
				nextCard();
			}
			
			public void windowClosing(WindowEvent e) 
			{
                //System.out.println("Window Closing Event");
                form.isQuizzing = false;
            }
		});
		textField = new JTextField();
		textField.setBounds(10, 231, 220, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnCheckIt = new JButton("Check");
		btnCheckIt.setBounds(238, 230, 77, 23);
		btnCheckIt.setActionCommand("check");
		btnCheckIt.addActionListener(new ActionCommands());
		getContentPane().add(btnCheckIt);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.WHITE);
		panel.setBounds(10, 11, 305, 198);
		getContentPane().add(panel);
		
		lblFcard = new JLabel("fcard");
		lblFcard.setHorizontalAlignment(SwingConstants.CENTER);
		lblFcard.setBounds(0, 92, 305, 14);
		panel.add(lblFcard);
		
		JLabel lblFrontOfCard = new JLabel("^ Front Of Card ^");
		lblFrontOfCard.setBounds(10, 212, 126, 14);
		getContentPane().add(lblFrontOfCard);
		
		label_1 = new JLabel("00/00");
		label_1.setBounds(269, 212, 46, 14);
		getContentPane().add(label_1);
		label_1.setText(curcount+"/"+form.dlm.getSize());
	}
	
	public static void nextCard()
	{
		if (curcount < form.dlm.getSize())
		{
			IndexCard ic = new IndexCard();
			int index = new Random().nextInt(randlist.size());
			ic = randlist.get(index);
			randlist.remove(index);
			lblFcard.setText(ic.getFrontText());
			icard = ic;
			curcount++;
			label_1.setText(curcount + "/" + form.dlm.getSize());
			textField.setText("");
		}
		else
		{
			label_1.setText(correct+" Correct out of " +form.dlm.getSize());
		}
	}

}
