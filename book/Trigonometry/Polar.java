package com.natureOfCode.book.Trigonometry;

import controlP5.ControlP5;
import processing.core.PApplet;
import processing.core.PVector;

public class Polar extends PApplet{

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		PApplet.main(new String[]{"--present", "main.Polar"});
	}
	
	
	PVector location;
	float radius, theta;
	float hue,sat,bal;
	ControlP5 ui;
	
	public void setup(){
		size(800,800);
		background(255);
		location = new PVector(0, 0);
		radius = 0;
		theta = 0;
		hue = 0;
		sat =70;
		bal = 70;
		
		ui = new ControlP5(this);
		
		ui.addSlider("radius")
		.setPosition(20, 20)
		.setColorCaptionLabel(0)
		.setRange(0, 200);
		
		ui.addSlider("theta")
		.setPosition(20, 30)
		.setColorCaptionLabel(0)
		.setRange(0, 200);
		
		ui.addSlider("hue")
		.setPosition(20, 40)
		.setColorCaptionLabel(0)
		.setRange(0, 360);
		
		ui.addSlider("sat")
		.setPosition(20, 50)
		.setColorCaptionLabel(0)
		.setRange(0, 100);
		
		ui.addSlider("bal")
		.setPosition(20, 60)
		.setColorCaptionLabel(0)
		.setRange(0, 100);
	}
	
	public void draw(){
		smooth();
		
		location.x = radius * cos(theta);
		location.y = radius * sin(theta);
		pushMatrix();
		translate(width/2, height/2);
		colorMode(HSB,360,100,100);
		strokeWeight(5);
		stroke(radius,sat,bal);
		line(0,0,location.x, location.y);
		
		noStroke();
		fill(radius+10,sat,bal);
		ellipse(location.x, location.y, 10, 10);
		popMatrix();
		theta +=0.01;
		radius += 0.1f;
	}
	
}
