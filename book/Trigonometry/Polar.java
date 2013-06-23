package com.natureOfCode.book.Trigonometry;

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
	float r, theta;
	
	public void setup(){
		size(800,800);
		background(255);
		location = new PVector(0, 0);
		r = 0;
		theta = 0;
	}
	
	public void draw(){
		smooth();
		
		location.x = r * cos(theta);
		location.y = r * sin(theta);
		translate(width/2, height/2);
//		strokeWeight(5);
//		stroke(theta+r,0, r);
//		line(0,0,location.x, location.y);
		noStroke();
		fill(theta,0,theta+r);
		ellipse(location.x, location.y, 10, 10);
		
		theta +=0.01;
		r += 0.1f;
		
	}
	
}
