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

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.imageio.*;
import java.awt.image.*;
import java.io.*;
public class StudyCard {
		public static JFrame form = new JFrame();
		private static JPanel pane = new JPanel();
		private static JList<IndexCard> listbox;
		private static DefaultListModel dlm = new DefaultListModel();
		private static JScrollPane scroller;
		private static JButton addCard, minusCard;
		private static IndexCardHolder ich;
	public static void main(String[] args) 
	{
		/*System.out.println("Hello");
		IndexCard c1 = new IndexCard("doodie", "poop");
		IndexCard c2 = new IndexCard("iwannafuck", "karen");
		System.out.println(IndexCard.getBackText(c2));
		IndexCardHolder ich = new IndexCardHolder();
		ich.addCard(c1);
		ich.addCard(c2);
		System.out.println(ich.getCardCount());
		if (ich.checkForIndexCard("ftext"))
		{
			IndexCard icx = new IndexCard();
			icx = ich.getCardByString("ftext");
			System.out.println(icx.getBackText());
		}
		else
		{
			System.out.println("Card not found");
		}
		//ich.SaveCards("icardfile.dat");
		ich.printCards();
		System.out.println("\n");
		ich.LoadCards("icardfile.dat");
		ich.printCards();*/
		InitializeFrm();
		form.show();
	}

	private static void InitializeFrm()
	{
		form.setTitle("StudyCard");
		form.setDefaultLookAndFeelDecorated(true);
    	form.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	form.setSize(600, 400);
    	form.setResizable(false);
    	listbox = new JList(dlm);
    	listbox.setPreferredSize(new Dimension(175, 300));
    	addCard = new JButton("+");
    	addCard.setBounds(new Rectangle(75, 100, 100, 200));
    	addCard.setActionCommand("addCard");
    	addCard.addActionListener(new ActionCommands());
    	/*scroller = new JScrollPane(listbox);
    	scroller.setPreferredSize(new Dimension(175, 300));
    	scroller.setBounds(100, 200, 175, 300);*/
    	pane.add(listbox);
    	pane.add(addCard);
    	form.add(pane);
    	
	}
	
	//+ should create card
	//add to holder
	//refresh listbox with all cards.fronttext in holder
	//done
	
	
}
