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
import java.util.ArrayList;
import java.util.List;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
public class IndexCardHolder 
{
	private List<IndexCard> l;  //Private list of cards
	private int count; //Count of all cards held
	
	public IndexCardHolder()
	{
		l = new ArrayList<IndexCard>(); //Initializing the new list
		count = 0; //Initializing the count
	}
	
	public void addCard(IndexCard ic)
	{
		l.add(ic);
		count++; //Adding user defined card and adding to the count
	}
	
	public void removeCard(IndexCard ic)
	{
		l.remove(ic);
		count--; //Removing user defined card and subtracting to the count
	}
	
	public List<IndexCard> viewList()
	{
		return l; //Returns list of cards
	}
	
	public boolean isEmpty()
	{
		if (l.isEmpty())
		{
			return true;
		}
		else 
		{
			return false;
		}
	} //True/False of weather there are cards in the ICH
	
	public boolean checkForIndexCard(String s)
	{
		boolean x = false;
		for (IndexCard ic: l)
		{
			if (ic.getFrontText() == s)
			{
				x= true;
			}
			else
			{
				x= false;
			}
		}
		return x;
	} //Checks to see if a specific card is in the holder by string. T if yes F if no
	
	public IndexCard getCardByString(String name)
	{
		IndexCard gotCard = new IndexCard();
		for (IndexCard ic: l)
		{
			if (ic.getFrontText() == name)
			{
				gotCard = ic;
			}
		}
		
		return gotCard;
	} //Gets the requested card by string and returns that Card
	
	public void printCards()
	{
		for (IndexCard i: l)
		{
			System.out.println(i.getFrontText() + " - " + i.getBackText());
		}
	} //Prints to Console all Cards in the holder
	
	public int getCardCount()
	{
		return l.size();
	} //Returns the amount of cards in the holder
	
	public void SaveCards(String filename)
	{
		try {
			FileOutputStream out;
			if (filename.endsWith(".scard"))
			{
				 out = new FileOutputStream(filename);
			}
			else
			{
				 out = new FileOutputStream(filename + ".scard");
			}
		      ObjectOutputStream oos = new ObjectOutputStream(out);
		      try 
		      {
		    	  oos.writeInt(l.size());
		    	  for(IndexCard ixx: l)
		    	  {
		    		  oos.writeObject(ixx);
		    		  oos.flush();
		    	  }
		      }
		      catch (Exception e){System.out.println("Problem saving: " + e);}
		      out.close();
		    }
		catch (Exception e) {System.out.println("Problem serializing: " + e);}
	} //Saves all Index Cards in the list to the specified file
	
	public void LoadCards(String filename)
	{
		try {
			FileInputStream in = new FileInputStream(filename);
			ObjectInputStream ois = new ObjectInputStream(in);
			int cardamt = ois.readInt();
			this.l.clear();
			for (int i=0;i<cardamt;i++)
			{
				try{
					this.addCard((IndexCard)ois.readObject());
				}
				catch (Exception e) {System.out.println(e);}
			}
			
		}
		catch (Exception e) {
		      System.out.println("Problem serializing: " + e);
		    }
	} //Loads the Index Cards from the specified file into the holder
	
}
