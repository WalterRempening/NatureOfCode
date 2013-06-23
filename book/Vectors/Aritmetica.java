package com.natureOfCode.book.Vectors;

import processing.core.PApplet;
import processing.core.PVector;

public class Aritmetica extends PApplet{

	PVector location, mouseV, dir;
	float magnitude;
	
	public static void main(String[] args) {
		PApplet.main(new String[] { "--present", "main.Aritmetica" });
	}
	
	public void setup(){
		size(920, 720);
		location = new PVector(width/2, height/2);
	}
	
	public void draw(){
		background(255);
		mouseV = new PVector(mouseX, mouseY);
		mouseV.sub(location);
		magnitude = mouseV.mag();
		mouseV.normalize();
		mouseV.mult(140);
		
		smooth();
		fill(0);
		rect(0, 0, magnitude, 20);
		
		strokeWeight(5);
		stroke(0);
		translate(width/2, height/2);
		line(0,0, mouseV.x, mouseV.y);

	}
	
}
