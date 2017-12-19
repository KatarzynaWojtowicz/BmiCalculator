package pl.katarzynawojtowicz.bmicalculator.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
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
		setSize(350, 300);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
	
		
		height = new JTextField(5);
		height.setBounds(50, 50, 100, 25);
		panel.add(height);
		
		weight = new JTextField(5);
		weight.setBounds(200, 50, 100, 25);
		panel.add(weight);
		
		button = new JButton("Calculate");
		button.setBounds(125, 100, 100, 25);
		button.addActionListener(this);
		panel.add(button);
		
		result = new JTextField(5);
		result.setBounds(125, 150, 100, 25);
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
	
