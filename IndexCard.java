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

import java.awt.Color;
import java.awt.Rectangle;
import java.io.Serializable;

import javax.swing.JPanel;
public class IndexCard extends java.lang.Object implements Serializable
{
	private String frontText, backText;
	private boolean isFront;
	//private boolean linesOn = false; No where near implemented yet
	
	public IndexCard() //If created without parameters
	{
		this.frontText = "";
		this.backText = "";
	}
	
	public IndexCard(String front) //If Created with one parameter
	{
		this.frontText = front;
		this.backText = "";
	}
	
	public IndexCard(String front, String back) //If Created with both parameters
	{
		this.frontText = front;
		this.backText = back;
	}
	
	public void setFront(String front) //set Text on the front card..Generally word or phrase to study
	{
		this.frontText = front;
	}
	
	public void setBack(String back) //Set Text on the back of the card...generally the definition or meaning
	{
		this.backText = back;
	}
	
	public String getBackText() // Returns the Back Text (Definitions) As a string
	{
		return this.backText;
	}
	
	public String getFrontText() // Returns the Front Text (Word/phrase) As a string
	{
		return this.frontText;
	}
	
	public static String getBackText(IndexCard ic) //IndexCard class function to get back text of a specific Card
	{
		String s = ic.backText;
		return s;
	}
	
	public static String getFrontText(IndexCard ic) //IndexCard class function to get front text of a specific Card
	{
		String s = ic.frontText;
		return s;
	}
	
	public boolean isFrontOfCard()
	{
		if (isFront)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}
