package com.natureOfCode.book.Trigonometry;

import processing.core.PApplet;
import processing.core.PVector;

public class Pendulum {
	public float armLength, angle, aVelocity, aAcceleration, gravity,
			ballRadius;
	PApplet p;
	PVector origin, location;
	float damping = 0.99f;
	private boolean dragging;

	Pendulum(PApplet parent, float _armLength, PVector _origin) {
		p = parent;
		origin = _origin;
		armLength = _armLength;
		location = new PVector();
		ballRadius = 48.0f;
	}

	public void go() {
		update();
		draw();
		drag();
	}

	public void update() {
		if (!dragging) {
			gravity = 0.4f;
			aAcceleration = (-1 * gravity * p.sin(angle)) / armLength;
			aVelocity += aAcceleration;
			aVelocity *= damping;
			angle += aVelocity;
		}
	}

	public void draw() {

		location.set(armLength * p.sin(angle), armLength * p.cos(angle), 0);
		location.add(origin);

		p.stroke(0);
		p.strokeWeight(2);
		p.fill(175);
		p.line(origin.x, origin.y, location.x, location.y);
		p.ellipseMode(p.CENTER);
		if (dragging)
			p.fill(0);
		p.ellipse(location.x, location.y, ballRadius, ballRadius);

	}

	public void drag() {
		if (dragging) {
			PVector diff = PVector.sub(origin, new PVector(p.mouseX, p.mouseY)); // Difference between 2 points
			angle = p.atan2(-1 * diff.y, diff.x) - p.radians(90); // Angle relative to vertical axis
		}
	}

	public void clicked(int _mouseX, int _mouseY) {
		float d = p.dist(_mouseX, _mouseY, location.x, location.y);
		if (d < ballRadius) {
			dragging = true;
		}
	}

	public void stopDragging() {
		aVelocity = 0; // No velocity once you let go
		dragging = false;
	}

}
