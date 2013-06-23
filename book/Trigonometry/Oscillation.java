package com.natureOfCode.book.Trigonometry;

import processing.core.PApplet;

public class Oscillation extends PApplet{

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		PApplet.main(new String[]{"--present", "main.Oscillation"});
	}
		
	int amplitude;
	float period;
	float y;
	
	public void setup(){
		size(800,800);
		amplitude = 200;
		period = 100;
		y = 0;
	}
	
	public void draw(){
		background(255);
		
		y = amplitude * sin(TWO_PI * frameCount / period);
		smooth();
		fill(180);
		strokeWeight(5);
		ellipse(width/2, (height/2) + y, 80, 80);
		
		
	}

}
