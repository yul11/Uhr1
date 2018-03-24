package eu.de.tnd.juo.uhr1;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Uhr_Menue_Listener extends Uhr_Menue implements ChangeListener,ActionListener{

	ArrayList<Color>       li_farben   = new ArrayList<Color>();
	ArrayList<BasicStroke> li_staerken = new ArrayList<BasicStroke>();
	Uhr_Basis b;
	private int pressCt;
	
	public Uhr_Menue_Listener(Uhr_Basis b){
				
		li_farben.add(Color.RED);
		li_farben.add(Color.BLUE);
		li_farben.add(Color.GREEN);
		li_farben.add(Color.YELLOW);
		li_farben.add(Color.CYAN);
		li_farben.add(Color.GRAY);
		li_farben.add(Color.PINK);
		li_farben.add(Color.ORANGE);
		li_staerken.add(new BasicStroke(5));		
		li_staerken.add(new BasicStroke(6));		
		li_staerken.add(new BasicStroke(7));		
		li_staerken.add(new BasicStroke(8));		
		li_staerken.add(new BasicStroke(9));		
		li_staerken.add(new BasicStroke(10));		
		li_staerken.add(new BasicStroke(11));
		
		colSlider.addChangeListener(this);
		lengthSliderSecond.addChangeListener(this);
		thickSliderSecond.addChangeListener(this);	
		startStopButton.addActionListener(this);
		this.b = b;
		pressCt = 0;
	}
	
	
	public void stateChanged(ChangeEvent ce) {
        if(ce.getSource() == colSlider){
            int val = ((JSlider) ce.getSource()).getValue();
            System.out.println("val colorSlider: " +val);
            b.changeColorSecond(li_farben.get(val));
        }
        
        if(ce.getSource() == lengthSliderSecond){
            int len = ((JSlider) ce.getSource()).getValue();
            System.out.println("val lengthSliderSecond: " +len);
            b.set_lenSecHand(len*10);
        }    
        
        if(ce.getSource() == thickSliderSecond){
            int thick = ((JSlider) ce.getSource()).getValue();
            System.out.println("val thickSliderSecond: " +thick);
            b.setThickness(li_staerken.get(thick));
        }    
	}


	public void actionPerformed(ActionEvent e) {					
		if ((pressCt % 2) ==0){			
			b.set_stateUhrBasis(0);
			startStopButton.setText("start");	
			startStopButton.setBackground(Color.GREEN);			
		}
		if ((pressCt % 2) ==1){			
			b.set_stateUhrBasis(1);	
			startStopButton.setText("stop");	
			startStopButton.setBackground(Color.RED);			
			}			
		pressCt++;
		if (pressCt==10){
			pressCt=0;			
		}
	}
}
