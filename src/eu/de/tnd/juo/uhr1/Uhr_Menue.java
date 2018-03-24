package eu.de.tnd.juo.uhr1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.JButton;


public class Uhr_Menue  extends JFrame {
		
	private static final long serialVersionUID = 1L;
	protected JSlider colSlider;
	protected JSlider lengthSliderSecond;
	protected JSlider thickSliderSecond;	
	protected JButton startStopButton;
	
		
	Uhr_Menue(){	
		
		super();		
		colSlider            = new JSlider();
		lengthSliderSecond   = new JSlider();
		thickSliderSecond    = new JSlider();	
		startStopButton      = new JButton("stop");

		colSlider.setMinimum(0);
		colSlider.setMaximum(7);
		colSlider.setMajorTickSpacing(5);
		colSlider.setMinorTickSpacing(1);
		colSlider.createStandardLabels(1);
		colSlider.setPaintTicks(true);
		colSlider.setPaintLabels(true);
		colSlider.setValue(9);
		
		lengthSliderSecond.setMinimum(0);
		lengthSliderSecond.setMaximum(40);
		lengthSliderSecond.setMajorTickSpacing(5);
		lengthSliderSecond.setMinorTickSpacing(1);
		lengthSliderSecond.createStandardLabels(1);
		lengthSliderSecond.setPaintTicks(true);
		lengthSliderSecond.setPaintLabels(true);
		lengthSliderSecond.setValue(200);	
		
		thickSliderSecond.setMinimum(0);
		thickSliderSecond.setMaximum(7);
		thickSliderSecond.setMajorTickSpacing(5);
		thickSliderSecond.setMinorTickSpacing(1);
		thickSliderSecond.createStandardLabels(1);
		thickSliderSecond.setPaintTicks(true);
		thickSliderSecond.setPaintLabels(true);
		thickSliderSecond.setValue(5);
		
		startStopButton.setBackground(Color.RED);

		
		JPanel mainPanel = new JPanel();			
		mainPanel.setLayout(new BorderLayout());

		
		JTextField p_sliderH = new JTextField("Sekundenzeiger");	
		JPanel p_slider = new JPanel(new BorderLayout());
		p_slider.setLayout(new BorderLayout());
		p_slider.add("North",colSlider);
		p_slider.add("Center",lengthSliderSecond);
		p_slider.add("South",thickSliderSecond);		
		
		
		JPanel p_sliderAll = new JPanel(new BorderLayout());
		p_sliderAll.add("North" ,p_sliderH);
		p_sliderAll.add("Center",p_slider);
				
		
		JPanel westPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		westPanel.setLayout(new BorderLayout());
		westPanel.setPreferredSize(new Dimension(200,30));
		JTextField WestName = new JTextField("WestName");
		westPanel.add(WestName);
		mainPanel.add(westPanel, BorderLayout.WEST);

		
		JPanel eastPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		eastPanel.setLayout(new BorderLayout());
		eastPanel.setPreferredSize(new Dimension(2000,30));
		
		
		//JTextField EastName = new JTextField("Hier kommt button her");			
		//eastPanel.add(EastName);
		mainPanel.add(startStopButton, BorderLayout.EAST);
		
		add(mainPanel,BorderLayout.WEST);
		add(p_sliderAll,BorderLayout.EAST);
		
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
	    int x = (d.width  - this.getSize().width) / 2;
	    int y = (d.height - this.getSize().height) / 2;
	    setLocation(x-875, y-275);    
						
		pack();
		setVisible(true);
	}
}
