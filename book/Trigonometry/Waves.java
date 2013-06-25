package com.natureOfCode.book.Trigonometry;

import controlP5.ControlP5;
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
	ControlP5 ui;
	
	public void setup(){
		size(800,800);
		angle = 0.0f;
		amp = 100;
		offset_x = 65f;
		offset_y = 0.05f;
		
		ui = new ControlP5(this);
		
		ui.addSlider("amp")
		.setPosition(0, 0)
		.setColorCaptionLabel(0)
		.setRange(10, 300);
		
		ui.addSlider("angle")
		.setPosition(0,20)
		.setColorCaptionLabel(0)
		.setRange(0, 100);
		
		ui.addSlider("offset_x")
		.setPosition(0,40)
		.setColorCaptionLabel(0)
		.setRange(0, 100);
		
		ui.addSlider("offset_y")
		.setPosition(0,60)
		.setColorCaptionLabel(0)
		.setRange(0, 3);
		
	}
	
	public void draw(){
		background(255);
//		angle +=angVel;
		fill(180);
		strokeWeight(5);
		
		for (int i = 0; i < 50; i++) {
			
			y = amp * sin(angle+(offset_y*i));
			ellipse(i * offset_x, (height/2) + y, 80, 80);
		}
		
		angle+=0.01f;
//		angVel+=0.0001f;
	}
	

}
