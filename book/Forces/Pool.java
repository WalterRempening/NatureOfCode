package com.natureOfCode.book.Forces;

import com.natureOfCode.book.Mover;
import processing.core.PApplet;
import processing.core.PVector;

public class Pool extends PApplet {

	Liquid water;
	Mover ball;
	PVector gravity;
	
	float waterCo = 1.2f;

	public static void main(String[] args) {
		PApplet.main(new String[] { "--present", "main.Pool" });
	}

	public void setup() {
		size(400, 700);
		
		gravity = new PVector(0,0.1f);
		water = new Liquid(Pool.this, 0, height/2, width, height* 0.75f, waterCo);
		ball = new Mover(Pool.this, width/2, 0, 5);
	}

	public void draw() {
		background(255);
		ball.applyForce(gravity);
		
		
		if(water.isInside(ball.location)){
			PVector dragForce = water.drag(ball.velocity, ball.area);
			ball.applyForce(dragForce);
		}
		
		water.display();
		ball.update();
		ball.display();
		ball.checkEdges();
		
		fill(0,0,150,100);
		rect(water.x, water.y, water.w, water.h);
		
	}

}
