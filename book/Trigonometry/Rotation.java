package com.natureOfCode.book.Trigonometry;

import processing.core.PApplet;

public class Rotation extends PApplet{

	public static void main(String[] args) {
		PApplet.main(new String[]{"--present", "main.Rotation"});

	}

	
	float angle, aVelocity, aAcceleration = 0;
	
	public void setup(){
		size(620, 480);
		aAcceleration = 0.001f;
	}
	
	public void draw(){
		background(0);
		rectMode(CENTER);
		translate(width/2, height/2);
		rotate(angle);
		rect(0, 0, 200, 100);
		
		aVelocity += aAcceleration;
		angle += aVelocity;
	}
}
