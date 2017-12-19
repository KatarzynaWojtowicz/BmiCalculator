package pl.katarzynawojtowicz.bmicalculator.controller;

public class BmiCalculator {
	public double calculateBmi(double w, double h) {
		double bmi = w / (h * h);
		return bmi;
	}
}