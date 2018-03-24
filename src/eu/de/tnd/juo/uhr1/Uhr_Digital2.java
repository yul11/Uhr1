package eu.de.tnd.juo.uhr1;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class Uhr_Digital2 extends JFrame {
	
	Uhr_Basis b;	
	JTextField hr     = new JTextField("Stunden");		
	JTextField min    = new JTextField("Minuten");
	JTextField sec    = new JTextField("Sekunden");
	JButton    start  = new JButton("start");
	JButton    stop   = new JButton("stop");

	GetTimeThread gth = new GetTimeThread();
	
	
	private class GetTimeThread extends Thread{
		public void run() {
			while (true) {				
				hr.setText ("Stunden:  " + new Integer(b.heute.get(Calendar.HOUR_OF_DAY)).toString());
				min.setText("Minuten:  " + new Integer(b.heute.get(Calendar.MINUTE)).toString());
				sec.setText("Sekunden: " + new Integer(b.heute.get(Calendar.SECOND)).toString());
				if (isInterrupted()) {
					break;
				}	
			}
		}		
	}
	
	
	Uhr_Digital2(Uhr_Basis ub){
		
		super();
		this.b = ub;
		
		start.addActionListener (new ActionListener () {
			public void actionPerformed(ActionEvent e) {
				System.out.println("start-Button gedrückt in Uhr_Digital() state: " + gth.getState());
				if (gth.isInterrupted())
					gth.start();	
			}
		});		
		stop.addActionListener (new ActionListener () {
			public void actionPerformed(ActionEvent e) {
				System.out.println("stop-Button gedrückt in Uhr_Digital() state: " + gth.getState());
				gth.interrupt();
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
		p.add(start);
		p.add(stop);


	    JFrame frame    = new JFrame();
		frame.setSize(600,120);
		frame.add(p);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(true);
		frame.setVisible(true);
		
		//GetTimeThread starten
		gth.start();
	}
}
