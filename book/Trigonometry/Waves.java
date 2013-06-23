package com.natureOfCode.book.Trigonometry;

import processing.core.PApplet;
import processing.core.PVector;

public class Waves extends PApplet {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		PApplet.main(new String[]{"--present", "main.Polar"});
	}
	
	float angle,angVel,amp,y;
	float offset_x, offset_y;
	public void setup(){
		size(800,800);
		angle = 0.0f;
		amp = 300;
		offset_x = 20;
		offset_y = 0.05f;
	}
	
	public void draw(){
		background(255);
		angle +=angVel;
		fill(180);
		strokeWeight(5);
		
		for (int i = 0; i < 100; i++) {
			
			y = amp * sin(angle + i);
			ellipse(i * offset_x, (height/2) + y, 80, 80);
			angVel+=0.001f;
		}
		
	}
	

}
