package com.natureOfCode.book.Forces;

import processing.core.PApplet;
import processing.core.PVector;

/**
 * Fluid force simulation object
 * 
 * Fd = -1/2 * p * v^2 * A * Cd * v(unit) p = density of liquid, not used Cd =
 * coefficient for friction v = velocity magnitude v(unit) = velocity
 * direction(velocity normalized) A = area of the surface
 * 
 * @author wrd
 * 
 */

public class Liquid {

	public PApplet p;
	public float x, y, w, h;
	public float c; // coefficient

	public Liquid(PApplet parent, float x_, float y_, float w_, float h_, float c_) {
		p = parent;
		x = x_;
		y = y_;
		w = w_;
		h = h_;
		c = c_;

	}

	public void display() {
		p.noStroke();
		p.fill(0,0,170);
		p.rect(x, y, w, h);
	}

	public PVector drag(PVector vel, float area_) {
		
		float speed = vel.mag(); // The forceÕs magnitude: Cd * v~2~
		float dragMagnitude = area_ * c * speed * speed;

		PVector drag = vel.get();
		drag.mult(-1); // The force's direction: -1 * velocity
		drag.normalize();
		drag.mult(dragMagnitude); // Finalize the force: magnitude and direction
									// together.

		return drag;
	}

	boolean isInside(PVector loc) {
		// This conditional statement determines if the PVector location is
		// inside the rectangle defined by the Liquid class.
		if (loc.x > x && loc.x < x + w && loc.y > y
				&& loc.y < y + h) {
			return true;
		} else {
			return false;
		}
	}
}
