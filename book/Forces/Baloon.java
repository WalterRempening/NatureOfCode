package com.natureOfCode.book.Forces;

import processing.core.PApplet;
import processing.core.PVector;

public class Baloon extends PApplet{

	PVector loc, vel, acc, wind;
	float noise;
	
	public static void main(String[] args) {
		PApplet.main(new String[] {"Present--", "Baloon"});
	}
	
	
	public void setup() {

		size(400,300);
		
		noise = noise(-1,10);
		
		loc = new PVector(width/2, height);
		vel = new PVector(0,0);
		acc = new PVector(0,0);
		wind = new PVector(noise, 0);
		
	}
	
	public void draw() {
		background(255);
		acc.y = -0.01f;
		vel.add(acc);
		loc.add(vel);
		
		
		smooth();
		fill(190,0,0);
		stroke(0);
		strokeWeight(4);
		ellipse(loc.x, loc.y, 40, 40);
		
		acc.mult(0);
		
		if(loc.x > width) loc.x = 0;
		if(loc.y < 0) loc.y = height;
		
	}
	
	@Override
	public void keyPressed() {
		super.keyPressed();
		if(keyCode == keyEvent.VK_SPACE){
			acc.add(wind);
		}
	}
	
}
