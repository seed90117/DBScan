package Output;

import java.awt.Color;
import java.awt.Graphics;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import InterFace.View;
import Value.value;

public class DrawPanel {

	static Graphics g;
	
	public static void drawdatapoint()
	{
		//*****JPanel��e��*****//
		g = View.show.getGraphics();
		
		//*****�M�ŵe��*****//
		g.setColor(Color.white);
						
		//*****�M�Žd��*****//
		g.fillRect(0, 0, View.show.getWidth(), View.show.getHeight());
		
		//*****�]�w�C��*****//
		g.setColor(Color.black);
		
		//*****�e���W���I*****//
		for(int i = 0; i < value.total; i++)
		{
			int x = (int)((value.x[i]));
			int y = (int)((value.y[i]));
			g.fillRect(x, y, 3, 3);
		}
	}
	
	public static void drawoutput()
	{
		Color c;
		Set<Color> st = new HashSet<Color>();
		//*****�M�ŵe��*****//
		g.setColor(Color.white);
								
		//*****�M�Žd��*****//
		g.fillRect(0, 0, View.show.getWidth(), View.show.getHeight());
		
		//*****�H�����ͤ������C��*****//
		for(int i=0;i<value.colornum;i++)
		{
			c = makeRandomColor();
			if(st.add(c))
			{
				//*****�]�w�C��*****//
				g.setColor(c);
				
				//*****�e���W���I*****//
				for(int j = 0; j < value.total; j++)
				{
					if(value.group[j] == i)
					{
						int x = (int)((value.x[j]));
						int y = (int)((value.y[j]));
						g.fillRect(x, y, 3, 3);
					}
				}
			}
			else
			{
				i--;
			}
		}
	}
	
	public static Color makeRandomColor() {
		Random rd = new Random();
	    int red = rd.nextInt(256);
	    int green = rd.nextInt(256);
	    int blue = rd.nextInt(256);
	    return new Color(red, green, blue);
	}
}
