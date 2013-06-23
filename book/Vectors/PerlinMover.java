package com.natureOfCode.book.Vectors;

import processing.core.PApplet;
import processing.core.PVector;

public class PerlinMover {
	
	PApplet p;
	PVector location;
	PVector velocity;
	PVector acceleration;
	float noise;
	float topSpeed = 10f;
	PerlinMover(PApplet parent) {
		p = parent;

		location = new PVector(p.width/2, p.height/2);
		velocity = new PVector(0,0);
		acceleration = new PVector(0,0);
		noise = p.map(p.noise(0.005f), -10,10,0,0.01f);
	}

	public void update() {
		acceleration.set(noise, noise, 0);
		
		velocity.add(acceleration);
		velocity.limit(topSpeed);
		location.add(velocity);
	  }

	public void display() {
		p.stroke(1);
		p.fill(175);
		p.ellipse(location.x, location.y, 30, 30);
	}

	
	public void checkEdges() {
		if (location.x > p.width) {
			location.x = 0;
		} else if (location.x < 0) {
			location.x = p.width;
		}

		if (location.y > p.height) {
			location.y = 0;
		} else if (location.y < 0) {
			location.y = p.height;
		}
	}

}
