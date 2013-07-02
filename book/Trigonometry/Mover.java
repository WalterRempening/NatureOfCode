package com.natureOfCode.book.Trigonometry;

import processing.core.PApplet;
import processing.core.PVector;

public class Mover {

	PApplet p;
	PVector location;
	PVector velocity;
	PVector acceleration;
	float mass = 24;

	// Arbitrary damping to simulate friction / drag
	float damping = 0.98f;

	// For mouse interaction
	PVector dragOffset;
	boolean dragging = false;

	// Constructor
	Mover(PApplet parent, float x, float y) {
		p = parent;
		location = new PVector(x, y);
		velocity = new PVector();
		acceleration = new PVector();
		dragOffset = new PVector();
	}

	// Standard Euler integration
	public void update() {
		velocity.add(acceleration);
		velocity.mult(damping);
		location.add(velocity);
		acceleration.mult(0);
	}

	// Newton's law: F = M * A
	public void applyForce(PVector force) {
		PVector f = force.get();
		f.div(mass);
		acceleration.add(f);
	}

	// Draw the bob
	public void display() {
		p.stroke(0);
		p.strokeWeight(2);
		p.fill(175);
		if (dragging) {
			p.fill(50);
		}
		p.ellipse(location.x, location.y, mass * 2, mass * 2);
	}

	// The methods below are for mouse interaction

	// This checks to see if we clicked on the mover
	public void clicked(int mx, int my) {
		float d = p.dist(mx, my, location.x, location.y);
		if (d < mass) {
			dragging = true;
			dragOffset.x = location.x - mx;
			dragOffset.y = location.y - my;
		}
	}

	public void stopDragging() {
		dragging = false;
	}

	public void drag(int mx, int my) {
		if (dragging) {
			location.x = mx + dragOffset.x;
			location.y = my + dragOffset.y;
		}
	}
}
