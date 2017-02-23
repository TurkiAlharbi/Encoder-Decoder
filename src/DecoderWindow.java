
import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;

public class DecoderWindow extends JFrame 
{
	String code="";
	public DecoderWindow (String code)
	{
			this.code = code;
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			setSize(400,500);
			setTitle("Decoder Window For Input: "+code);
			setLayout(new GridLayout(9,1) );
			
			JPanel p = new JPanel ();
				p.setLayout(new FlowLayout ());
				JLabel label = new JLabel ("Input: ");
				JTextField text = new JTextField (code);
				p.add(label);
				p.add(text);
			
			JPanel pa = new JPanel ();
				pa.setLayout(new FlowLayout ());
				JLabel labela = new JLabel ("NRZ_L decoder: ");
				JTextField texta = new JTextField (CodeHandler.decoderNRZ_L(code));
				pa.add(labela);
				pa.add(texta);
				
			JPanel pb = new JPanel ();
				pb.setLayout(new FlowLayout ());
				JLabel labelb = new JLabel ("NRZI decoder: ");
				JTextField textb = new JTextField (CodeHandler.decoderNRZI(code));
				pb.add(labelb);
				pb.add(textb);
				
			JPanel pc = new JPanel ();
				pc.setLayout(new FlowLayout ());
				JLabel labelc = new JLabel ("Bipolar decoder: ");
				JTextField textc = new JTextField (CodeHandler.decoderBipolar(code));
				pc.add(labelc);
				pc.add(textc);
				
			JPanel pd = new JPanel ();
				pd.setLayout(new FlowLayout ());
				JLabel labeld = new JLabel ("Psedoternary decoder: ");
				JTextField textd = new JTextField (CodeHandler.decoderPsedoternary(code));
				pd.add(labeld);
				pd.add(textd);

			JPanel pe = new JPanel ();
				pe.setLayout(new FlowLayout ());
				JLabel labele = new JLabel ("Manchester decoder: ");
				JTextField texte = new JTextField (CodeHandler.decoderManchester(code));
				pe.add(labele);
				pe.add(texte);

			JPanel pf = new JPanel ();
				pf.setLayout(new FlowLayout ());
				JLabel labelf = new JLabel ("Manch. Diff. decoder: ");
				JTextField textf = new JTextField (CodeHandler.decoderDiffrential(code));
				pf.add(labelf);
				pf.add(textf);
				
			JPanel pg = new JPanel ();
				pg.setLayout(new FlowLayout ());
				JLabel labelg = new JLabel ("B8ZS decoder: ");
				JTextField textg = new JTextField (CodeHandler.decoderB8ZS(code));
				pg.add(labelg);
				pg.add(textg);
							
			JPanel ph = new JPanel ();
				ph.setLayout(new FlowLayout ());
				JLabel labelh = new JLabel ("HDB3 decoder: ");
				JTextField texth = new JTextField (CodeHandler.decoderHDB3(code));
				ph.add(labelh);
				ph.add(texth);
			
			add(p);	
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
		new DecoderWindow("+00-000+-+-+-0+0-0+00-+-000");
	}
}