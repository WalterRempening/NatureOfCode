package com.natureOfCode.book.Forces;

import com.natureOfCode.book.Mover;
import processing.core.PApplet;
import processing.core.PVector;

public class NoMassGravity extends PApplet {

	public Mover[] movers = new Mover[100];
	public PVector wind, gravity, friction;

	public static void main(String[] args) {
		PApplet.main(new String[] { "--present", "main.NoMassGravity" });
	}

	public void setup() {
		size(800, 300);

		wind = new PVector(0.01f, 0);
		for (int i = 0; i < movers.length; i++) {
			movers[i] = new Mover(this, 0, 0, random(0.1f, 5));
		}
	}

	public void draw() {
		background(255);
		smooth();

		float c = 0.01f;

		for (int i = 0; i < movers.length; i++) {
			friction = movers[i].velocity.get();
			friction.mult(-1);
			friction.normalize();
			friction.mult(c);
			
			movers[i].applyForce(friction);
			movers[i].applyForce(wind);
			float m = movers[i].mass;
			gravity = new PVector(0, 0.1f * m);
			movers[i].applyForce(gravity);

			movers[i].update();
			movers[i].display();
			movers[i].checkEdges();
		}

	}
}
