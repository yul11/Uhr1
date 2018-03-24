package eu.de.tnd.juo.uhr1;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class Uhr_Digital3 extends JFrame {
	
	private static final long serialVersionUID = 1L;
	Uhr_Basis b;	
	JTextField hr     = new JTextField("Stunden    ");		
	JTextField min    = new JTextField("Minuten    ");
	JTextField sec    = new JTextField("Sekunden   ");
	JButton    start  = new JButton("start");
	JButton    stop   = new JButton("stop");
	static int state  = 1;

	GetTimeThread t = new GetTimeThread();
	
	
	private class GetTimeThread extends Thread{
		public void run() {
			while (true) {
				if (state==1){					
					System.out.println("Uhr_Digital()-> state1");
					hr.setText ("Stunden:"  + (b.heute.get(Calendar.HOUR_OF_DAY)));
					min.setText("Minuten:"  + (b.heute.get(Calendar.MINUTE)));
					sec.setText("Sekunden:" + (b.heute.get(Calendar.SECOND)));
					start.setEnabled(false);
					stop.setEnabled(true);
				}
				if (state==0){
					System.out.println("Uhr_Digital()-> state0");
					start.setEnabled(true);
					stop.setEnabled(false);					
				}	
			}
		}		
	}
	
	
	Uhr_Digital3(Uhr_Basis ub){
		
		super();
		this.b = ub;
		
		start.addActionListener (new ActionListener () {
			public void actionPerformed(ActionEvent e) {
				System.out.println("start-Button gedrückt in Uhr_Digital() state: " + t.getState());
				state = 1;
			}
		});		
		stop.addActionListener (new ActionListener () {
			public void actionPerformed(ActionEvent e) {
				System.out.println("stop-Button gedrückt in Uhr_Digital() state: " + t.getState());
				state = 0;
			}
		});
		
		
		JPanel p = new JPanel();			
		p.setLayout(new FlowLayout());
		
		hr.setEditable(false);
		min.setEditable(false);
		sec.setEditable(false);
				
	    Font f = new Font("Courier", Font.BOLD,24);
	    hr.setFont(f);	    
	    min.setFont(f);	    
	    sec.setFont(f);	    

		p.add(hr ,FlowLayout.LEFT);
		p.add(min,FlowLayout.CENTER);
		p.add(sec,FlowLayout.RIGHT);
				
		JPanel stst = new JPanel();	
		stst.add(start);
		stst.add(stop);
		p.add(stst);

		setSize(620,120);		
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
	    int x = (d.width  - this.getSize().width) / 2;
	    int y = (d.height - this.getSize().height) / 2;
	    //setLocation(x-550, y-215); 
	    setLocation(x-565, y-25); 
	    
	    add(p);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setResizable(true);
	    setVisible(true);
		
		t.start();
	}
}
