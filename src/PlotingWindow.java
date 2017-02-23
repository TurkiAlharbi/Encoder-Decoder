
import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;

public class PlotingWindow extends JFrame
{
		public  String stream="";
		
		public PlotingWindow (String stream)
		{
			this.stream = stream;
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			setSize(1200,700);
			setTitle("Ploting Window For Input: "+stream);
			setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);
			setLayout(new GridLayout(8,1) );
			
			DrawingPanel pa = new DrawingPanel ("NRZ_L",stream,CodeHandler.encoderNRZ_L(stream));
			DrawingPanel pb = new DrawingPanel ("NRZI",stream,CodeHandler.encoderNRZI(stream));
			DrawingPanel pc = new DrawingPanel ("Bipolar",stream,CodeHandler.encoderBipolar(stream));
			DrawingPanel pd = new DrawingPanel ("Psedoternary",stream,CodeHandler.encoderPsedoternary(stream));
			DrawingPanel pe = new DrawingPanel ("Manchester",stream,CodeHandler.encoderManchester(stream));
			DrawingPanel pf = new DrawingPanel ("Manch. Diff.",stream,CodeHandler.encoderDiffrential(stream));
			DrawingPanel pg = new DrawingPanel ("B8ZS",stream,CodeHandler.encoderB8ZS(stream));
			DrawingPanel ph = new DrawingPanel ("HDB3",stream,CodeHandler.encoderHDB3(stream));
			
			add(pa);
			add(pb);
			add(pc);
			add(pd);
			add(pe);
			add(pf);
			add(pg);
			add(ph);
			
			setVisible(true);
			
		}
		
		public static void main (String [] args)
		{
			new PlotingWindow ("100110000000000011111000000101010101");
		}
		
		
}