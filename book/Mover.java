package com.natureOfCode.book;

import com.natureOfCode.book.Forces.Liquid;
import processing.core.PApplet;
import processing.core.PVector;

public class Mover {
	PApplet p;
	public PVector location, velocity, acceleration;

	public float mass;
	public float area;

	public Mover(PApplet parent, float x, float y, float m) {
		p = parent;
		mass = m;
		area = mass / 10;
		location = new PVector(x, y);
		velocity = new PVector(0, 0);
		acceleration = new PVector(0, 0);
	}

	public void update() {
		velocity.add(acceleration);
		location.add(velocity);

		acceleration.mult(0);
	}

	public void display() {
		p.fill(175);
		p.stroke(10);
		p.ellipse(location.x, location.y, mass * 16, mass * 16);
	}

	public void applyForce(PVector f) {
		PVector force = PVector.div(f, mass);
		acceleration.add(force);
	}


	public void checkEdges() {
		if (location.x > p.width) {
			location.x = p.width;
			velocity.x *= -1;
		} else if (location.x < 0) {
			velocity.x *= -1;
			location.x = 0;
		}

		if (location.y > p.height) {
			velocity.y *= -1;
			location.y = p.height;
		}
	}

}
