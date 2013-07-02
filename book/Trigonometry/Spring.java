package com.natureOfCode.book.Trigonometry;

import processing.core.PApplet;
import processing.core.PVector;

public class Spring {

	// Location
	PVector anchor;
	PApplet p;
	// Rest length and spring constant
	float len;
	float k = 0.2f;

	// Constructor
	Spring(PApplet parent, float x, float y, int l) {
		p = parent;
		anchor = new PVector(x, y);
		len = l;
	}

	// Calculate spring force
	public void connect(Mover b) {
		// Vector pointing from anchor to bob location
		PVector force = PVector.sub(b.location, anchor);
		// What is distance
		float d = force.mag();
		// Stretch is difference between current distance and rest length
		float stretch = d - len;

		// Calculate force according to Hooke's Law
		// F = k * stretch
		force.normalize();
		force.mult(-1 * k * stretch);
		b.applyForce(force);
	}

	// Constrain the distance between bob and anchor between min and max
	public void constrainLength(Mover b, float minlen, float maxlen) {
		PVector dir = PVector.sub(b.location, anchor);
		float d = dir.mag();
		// Is it too short?
		if (d < minlen) {
			dir.normalize();
			dir.mult(minlen);
			// Reset location and stop from moving (not realistic physics)
			b.location = PVector.add(anchor, dir);
			b.velocity.mult(0);
			// Is it too long?
		} else if (d > maxlen) {
			dir.normalize();
			dir.mult(maxlen);
			// Reset location and stop from moving (not realistic physics)
			b.location = PVector.add(anchor, dir);
			b.velocity.mult(0);
		}
	}

	public void display() {
		p.stroke(0);
		p.fill(175);
		p.strokeWeight(2);
		p.rectMode(p.CENTER);
		p.rect(anchor.x, anchor.y, 10, 10);
	}

	void displayLine(Mover b) {
		if(b == null) System.out.println("Nuller dude");
		p.strokeWeight(2);
		p.stroke(0);
		p.line(b.location.x, b.location.y, anchor.x, anchor.y);
	}

}
