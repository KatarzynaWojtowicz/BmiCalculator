package pl.katarzynawojtowicz.bmicalculator.view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import pl.katarzynawojtowicz.bmicalculator.controller.BmiCalculator;

public class MyWindow extends JFrame implements ActionListener  {
	private JTextField height;
	private JTextField weight;
	private JTextField result;
	private JButton button;
	
	private BmiCalculator controller = new BmiCalculator(); 
	
	public MyWindow() {
		super("BMI Calculator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(1200, 500);
		setSize(200, 250);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(200, 200, 200));
	
		
		JLabel heightLabel = new JLabel("Height:");
		heightLabel.setBounds(20, 20, 100, 25);
		panel.add(heightLabel);
		
		height = new JTextField(5);
		height.setBounds(70, 20, 100, 25);
		panel.add(height);
		
		JLabel weightLabel = new JLabel("Weight:");
		weightLabel.setBounds(20, 60, 100, 25);
		panel.add(weightLabel);
		
		weight = new JTextField(5);
		weight.setBounds(70, 60, 100, 25);
		panel.add(weight);
		
		button = new JButton("Calculate");
		button.setBounds(70, 100, 100, 25);
		button.addActionListener(this);
		panel.add(button);
		
		JLabel resultLabel = new JLabel("BMI:");
		resultLabel.setBounds(20, 140, 100, 25);
		panel.add(resultLabel);
		
		result = new JTextField(5);
		result.setBounds(70, 140, 100, 25);
		panel.add(result);
		result.setEditable(false);
		result.setEnabled(true);
		
		add(panel);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == button) {
			double heightValue = Double.parseDouble(height.getText());
			double weightValue = Double.parseDouble(weight.getText());
			double resultValue = controller.calculateBmi(weightValue, heightValue);
			String resultText = String.format("%.2f", resultValue);
			result.setText(resultText);
		}
		
	}
	
}
	
