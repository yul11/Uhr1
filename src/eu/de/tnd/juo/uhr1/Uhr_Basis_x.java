package eu.de.tnd.juo.uhr1;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Calendar;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Uhr_Basis_x extends Uhr_Basis{
	
	private static final long serialVersionUID = 1L;
	protected JTextField txt_sec;
    private int    i_sec;
	
	Uhr_Basis_x(){
		
	    txt_sec = new JTextField("",3);
	    //txt_sec.setBorder (BorderFactory.createLineBorder ((Color.BLUE), 1));
	    txt_sec.setBorder(javax.swing.BorderFactory.createEmptyBorder()); //Border ausblenden
	    txt_sec.setEditable(false);
	    Font f = new Font("Courier", Font.BOLD,36);
	    txt_sec.setFont(f);	
	    
	    
		JPanel p = new JPanel();			
		//p.setLayout(new FlowLayout());	
		p.setLayout(new BorderLayout());	
		p.add(txt_sec);	    
	    //add(p,FlowLayout.LEFT);
	    add(p,BorderLayout.EAST);
	}
		
	//zeichnet zusätzliche grafische Elemente in Uhr_Basis()
    public void paintComponent(Graphics g) {	    
	    super.paintComponent(g);
	    	    	    
	    Dimension d = getSize();
		int w = d.width;
		int h = d.height;		
		
		//zeichnet Torten-Ziffernblatt
	    g2d = (Graphics2D) g;	
	    g2d.setColor(Color.RED);
	    g2d.setStroke(new BasicStroke(10));	    
	    g2d.drawArc(0, 0, w, h, 90, (360-angleSec));	//counter-clock-wise	    
	    
	    
	    //zeichnet Sekunden-Textfeld
        i_sec = heute.get(Calendar.SECOND);
	    angleSec = (360 / 60) * i_sec;       
	    Integer int_sec = new Integer(i_sec);
	    str_sec = int_sec.toString();
	    txt_sec.setText(str_sec);
    }
}
