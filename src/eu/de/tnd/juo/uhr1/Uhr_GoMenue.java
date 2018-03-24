package eu.de.tnd.juo.uhr1;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Uhr_GoMenue extends Uhr_Start implements ActionListener{

	private static final long serialVersionUID = 1L;
	Uhr_Basis b;
		
	public Uhr_GoMenue(Uhr_Basis b){			
		super();	
		this.b=b;
		menueButton.addActionListener(this);
		digitalButton.addActionListener(this);
	}
		
	public void actionPerformed(ActionEvent e) {	
		if (e.getActionCommand().equals("Analog")){
			System.out.println("Analog-button gedrückt");
			new Uhr_Menue_Listener(b);
			setVisible(true);
		}		
		if (e.getActionCommand().equals("Digital")){
			System.out.println("Digital-button gedrückt");
			new Uhr_Digital(b);
			setVisible(true);
		}				
	}
}
