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

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JScrollPane;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;


public class form extends JFrame {

	private JPanel contentPane;
	static DefaultListModel<String> dlm = new DefaultListModel<String>();
	static JList<String> list;
	private JScrollPane jsp;
	static IndexCard icard;
	static IndexCardHolder ich = new IndexCardHolder();
	static JLabel cfrontlbl;
	public static boolean isQuizzing;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					form frame = new form();
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
	public form() {
		setResizable(false);
		setTitle("StudyCard beta- Obscure Software");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setDefaultLookAndFeelDecorated(true);
		setBounds(100, 100, 450, 291);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	
		//Index Card Creation
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(129, 11, 305, 198);
		contentPane.add(panel);
		panel.setLayout(null);
				
		/*final JLabel */cfrontlbl = new JLabel("CardFront");
		cfrontlbl.setHorizontalAlignment(SwingConstants.CENTER);
		cfrontlbl.setBounds(0, 92, 305, 14);
		panel.add(cfrontlbl);
		//End Card Creation
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 119, 226);
		contentPane.add(scrollPane);
		
		list = new JList<String>(dlm);
		scrollPane.setViewportView(list);
		list.addMouseListener(new java.awt.event.MouseAdapter()
		{
            public void mouseClicked(java.awt.event.MouseEvent mouseEvent)
            {
            	IndexCard xc = new IndexCard();
            	xc = ich.getCardByString(list.getSelectedValue());
            	icard = xc;
            	cfrontlbl.setText(xc.getFrontText());
            }
         });
		
		JButton btnSave = new JButton("Save");
		btnSave.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnSave.setBounds(129, 237, 62, 23);
		btnSave.setActionCommand("save");
		btnSave.addActionListener(new ActionCommands());
		contentPane.add(btnSave);
		
		JButton btnLoad = new JButton("Load");
		btnLoad.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnLoad.setBounds(196, 237, 62, 23);
		btnLoad.setActionCommand("load");
		btnLoad.addActionListener(new ActionCommands());
		contentPane.add(btnLoad);
		
		JButton button = new JButton("+");
		button.setBounds(0, 237, 57, 23);
		button.setActionCommand("addCard");
		button.addActionListener(new ActionCommands());
		contentPane.add(button);
		
		
		JButton button_1 = new JButton("-");
		button_1.setBounds(62, 237, 57, 23);
		button_1.setActionCommand("minusCard");
		button_1.addActionListener(new ActionCommands());
		contentPane.add(button_1);
		
		JButton btnFlipIndexCard = new JButton("Flip");
		btnFlipIndexCard.setBounds(372, 213, 62, 23);
		btnFlipIndexCard.setActionCommand("flip");
		btnFlipIndexCard.addActionListener(new ActionCommands());
		contentPane.add(btnFlipIndexCard);
		
		JButton btnEdit = new JButton("Edit");
		btnEdit.setBounds(305, 213, 62, 23);
		btnEdit.setActionCommand("edit");
		btnEdit.addActionListener(new ActionCommands());
		contentPane.add(btnEdit);
		
		JButton btnQuiz = new JButton("Quiz!");
		btnQuiz.setBounds(239, 213, 62, 23);
		btnQuiz.setActionCommand("quiz");
		btnQuiz.addActionListener(new ActionCommands());
		contentPane.add(btnQuiz);
		isQuizzing = false;
	}
	
	public static void setIndexCardText(String text)
	{
		cfrontlbl.setText(text);
	}
}
