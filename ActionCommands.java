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
import java.util.*;
public class ActionCommands implements ActionListener
{
	public ActionCommands() {}

	public void actionPerformed(java.awt.event.ActionEvent ae) 
	{
		if(ae.getActionCommand().equals("addCard"))
   	 	{
				IndexCard ic = new IndexCard();
				ic.setFront(JOptionPane.showInputDialog("Enter The Front Text"));
				form.ich.addCard(ic);
				form.dlm.addElement(ic.getFrontText());
				
   	 	}
		if(ae.getActionCommand().equals("minusCard"))
   	 	{
			int sel = form.list.getSelectedIndex();
			IndexCard ic = new IndexCard();
			ic = form.ich.getCardByString(form.list.getSelectedValue());
			form.ich.removeCard(ic);
			form.dlm.removeElementAt(sel);
   	 	}
		if (ae.getActionCommand().equals("save"))
		{
			JFileChooser jfc = new JFileChooser();
			int res = jfc.showSaveDialog(form.list);
			if (res == JFileChooser.APPROVE_OPTION) 
			{
				form.ich.SaveCards(jfc.getSelectedFile().getPath());
			}
		}
		if (ae.getActionCommand().equals("load"))
		{
			form.dlm.clear();
			JFileChooser jfc = new JFileChooser();
			int res = jfc.showOpenDialog(form.list);
			if (res == JFileChooser.APPROVE_OPTION) 
			{
				form.ich.LoadCards(jfc.getSelectedFile().getPath());
			}
			for (IndexCard i: form.ich.viewList())
			{
				form.dlm.addElement(i.getFrontText());
			}
		}
		
	}
}