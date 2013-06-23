package com.natureOfCode.book.Vectors;

import processing.core.PApplet;
import processing.core.PVector;

public class Ball extends PApplet {

	PVector velocity;
	PVector location;

	public void setup() {
		size(800,800, P3D);
		smooth();
		location = new PVector(100, 100,10);
		velocity = new PVector(2.5f, 5, 0);

	}

	public void draw() {
		
		background(0);
		lights();
		location.add(velocity);

		if ((location.x > width) || (location.x < 0)) {
			velocity.x = velocity.x * -1;
		}
		if ((location.y > height) || (location.y < 0)) {
			velocity.y = velocity.y * -1;
		}
		if ((location.z > height) || (location.z < 0)) {
			velocity.z = velocity.z * -1;
		
		}
		System.out.println("Location Z: " + location.z + " Velocity Z:" + velocity.z);
		
		stroke(0);
		fill(175);
//		ellipse(location.x, location.y, 16,16);
		translate(location.x, location.y, location.z);
		sphere(50);
		
	}

}
