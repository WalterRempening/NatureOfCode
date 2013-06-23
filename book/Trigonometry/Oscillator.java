package com.natureOfCode.book.Trigonometry;

import processing.core.PApplet;
import processing.core.PVector;

public class Oscillator {

	// Using a PVector to track two angles!
	PVector angle;
	PVector velocity;
	PVector amplitude;
	PApplet p;

	public Oscillator(PApplet parent) {
		p = parent;
		angle = new PVector();
		velocity = new PVector(p.random(-0.05f, 0.05f), p.random(-0.05f, 0.05f));
		// [offset-down] Random velocities and amplitudes
		amplitude = new PVector(p.random(p.width / 2), p.random(p.height / 2));
	}

	void oscillate() {
		angle.add(velocity);
	}

	void display() {
		// Oscillating on the x-axis
		float x = p.sin(angle.x) * amplitude.x;
		// Oscillating on the y-axis
		float y = p.sin(angle.y) * amplitude.y;

		p.pushMatrix();
		p.translate(p.width / 2, p.height / 2);
		p.stroke(0);
		p.fill(175);
		// Drawing the Oscillator as a line connecting a circle
		p.line(0, 0, x, y);
		p.ellipse(x, y, 16, 16);
		p.popMatrix();
	}
}
