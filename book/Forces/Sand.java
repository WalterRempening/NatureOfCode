package com.natureOfCode.book.Forces;

import com.natureOfCode.book.Mover;
import processing.core.PApplet;
import processing.core.PVector;

public class Sand extends PApplet {

	PVector wind;
	Friction sand1, sand2;
	Mover ball;

//	public static void main(String[] args) {
//		PApplet.main(new String[] { "--present", "main.Sand" });
//	}

	public void setup() {
		size(800, 500);
		wind = new PVector(0.09f, 0);
		sand1 = new Friction(0.08f, 200, 80, (height / 2) - 60, 120);
		sand2 = new Friction(-0.09f, 500, 80, (height / 2) - 60, 120);

		ball = new Mover(Sand.this, 0, height/2, 5);
	}

	public void draw() {
		background(255);

		fill(100,0,0);
		rect(sand1.x, sand1.y, sand1.w, sand1.h);
		rect(sand2.x, sand2.y, sand2.w, sand2.h);
		
		if(sand1.inContact(ball.location)){
			ball.applyForce(sand1.drag(ball.velocity));
		}else if(sand2.inContact(ball.location)){
			ball.applyForce(sand2.drag(ball.velocity));
		}

		ball.applyForce(wind);
		
		ball.update();
		ball.display();
		ball.checkEdges();
		
	}
}
