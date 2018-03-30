package eu.de.tnd.juo.uhr1;

import java.awt.Button;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Uhr_Button extends Button implements ActionListener {

	private static final long serialVersionUID = 1L;
	int i;
	Uhr_Basis basis;
	Thread t;


	Uhr_Button(Uhr_Basis ub, String text) {
		setLabel(text);
		addActionListener(this);
		this.basis=ub;
	}

	public void actionPerformed(ActionEvent e) {
		i++;
		
		t=basis.getThread();
		//t.interrupt();
		
		if ((i%2)==0){
			setBackground(Color.red);
			setLabel("state is: " + t.getState().toString());
			basis.changeColorSecond(Color.RED);							
		}
		else{
			setBackground(Color.yellow);
			setLabel("state is: " + t.getState().toString());
			basis.changeColorSecond(Color.YELLOW);
		}		
	}
}
