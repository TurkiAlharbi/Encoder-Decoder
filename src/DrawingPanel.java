
import javax.swing.*;
import java.awt.*;

public class DrawingPanel extends JPanel
{

	public String info;
	public String stream="00" ;
	public String name="unkown";


	public double sizingFactor=1.750;

	public int pulsLength = (int)(10*sizingFactor);
	public int levelLength= (int)(13*sizingFactor);
	
	public int orgRef_x =0;
	public int orgRef_y =32;
	public int ref_x =orgRef_x;
	public int ref_y =orgRef_y;
	
	

	
	public DrawingPanel ()
	{
		setVisible(true);
        this.setBackground(Color.WHITE);
		
	}
	public DrawingPanel (String name,String info , String stream)
	{
		this();
		this.name=name;
		this.info=info;
		this.stream=stream;
	}


	

	

	

	
	public void paintStream (Graphics g2)
	{
		Graphics2D g = (Graphics2D)g2;
		g.setFont(new Font("Joy",Font.BOLD,15));
		g.drawString(name,ref_x,ref_y);
		
		ref_x+=110;
		int oldx= ref_x,oldy = ref_y;	
		int x= stream.length();
		if(stream.charAt(0)=='a')
			x--;
		g.setColor(Color.YELLOW);
		g.drawLine(ref_x,ref_y,ref_x+x*pulsLength,ref_y);
		g.drawLine(ref_x,ref_y-levelLength,ref_x+x*pulsLength,ref_y-levelLength);
		g.drawLine(ref_x,ref_y+levelLength,ref_x+x*pulsLength,ref_y+levelLength);
		g.setColor(Color.BLACK);
		g.drawString("0",ref_x-10,ref_y);
		g.drawString("+",ref_x-10,ref_y-levelLength);
		g.drawString("-",ref_x-10,ref_y+levelLength);
		
	
		for(int i = 0 ; i<x;i+=2)
		{
			g.setColor(Color.GREEN);
			g.drawLine(oldx,oldy+levelLength,oldx,oldy-levelLength);
			oldx+=pulsLength*1;
			g.setColor(Color.RED);
			g.drawLine(oldx,oldy+levelLength,oldx,oldy-levelLength);
			oldx+=pulsLength*1;
		}
		g.setStroke(new BasicStroke(3));
		g.setColor(Color.BLACK);
	
		int j=0;	
		for(int i=0; i < stream.length() ; i++)
		{
			char puls = stream.charAt(i);
			char nextPuls='s';
			
			if((i+1) != stream.length())
				nextPuls=stream.charAt(i+1);
			if(i != stream.length()-1)
			{
				int mod=0;
				if(stream.charAt(0)=='a')
					mod=i+1;
				else
					mod=i;
				 if(info!=null && mod%2==0 && j != info.length())
					g.drawString(info.charAt(j++)+"",ref_x+pulsLength,ref_y+2*levelLength);
				
			}
				
		
			if(puls == '+')
				drawPositive(g);
			else if (puls == '-')
				drawNegtive(g);
			else if (puls == '0')
				drawGround(g);
			else if(puls=='a')
			{
				drawHlfLevDown(g);
				drawHlfLevUp(g);
			}
			else if(puls=='u')
				drawHlfLevUp(g);
			else if(puls=='d')
				drawHlfLevDown(g); 
				
			if(puls != nextPuls)
			{
				if(nextPuls!='s')
				{
					if(puls == '0' || nextPuls == '0')
					{
						if(puls == '0')// nextPuls != '0'
						{
							if(nextPuls == '+')
								drawHlfLevUp(g);
							else
								drawHlfLevDown(g);
						}
						else//nextPuls == '0'
						{
							if(puls == '+')
								drawHlfLevUp(g);
							else
								drawHlfLevDown(g);
						}
					}
					else // puls == '+' || '-' && nextPuls == '-' || '+'
					{
						drawHlfLevDown(g);
						drawHlfLevUp(g);
					}
					
				}
			}
				
			
		}

	}
	public void paintComponent (Graphics g)
	{
		super.paintComponent(g);
		ref_x=orgRef_x;
		ref_y=orgRef_y;
		paintStream(g);
	}
	
	private void drawPositive(Graphics g)
	{
		int newRef = ref_x + pulsLength;
		int y = ref_y-levelLength;
		g.drawLine(ref_x,y,newRef,y);
		ref_x=newRef;
	}
	
	private void drawNegtive(Graphics g)
	{
		int newRef = ref_x + pulsLength;
		int y = ref_y+levelLength;
		g.drawLine(ref_x,y,newRef,y);
		ref_x=newRef;
	}
	
	private void drawGround(Graphics g)
	{
		int newRef = ref_x + pulsLength;
		int y = ref_y;
		g.drawLine(ref_x,y,newRef,y);
		ref_x=newRef;
	}
	
	private void drawHlfLevUp(Graphics g)
	{
		int y=ref_y-levelLength;
		g.drawLine(ref_x,ref_y,ref_x,y);
	}
	
	private void drawHlfLevDown(Graphics g)
	{
		int y=ref_y+levelLength;
		g.drawLine(ref_x,ref_y,ref_x,y);
	}
	

}