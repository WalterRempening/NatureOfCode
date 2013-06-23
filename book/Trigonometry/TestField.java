package com.natureOfCode.book.Trigonometry;

import processing.core.PApplet;
import processing.core.PVector;

public class TestField extends PApplet{

	public MoverTrig mover;
	public PVector attractor;
	public PVector mouse;
	public PVector wind;
	
	public static void main(String[] args) {
		PApplet.main(new String[]{"--present", "main.TestField"});
	}
	
	public void setup(){
		size(600,300);
		wind = new PVector(0.05f, 0.001f);
		mouse = new PVector(mouseX, mouseY);
		mover = new MoverTrig(this, 10);
	}

	public void draw(){
		background(255);
		mouse.sub(mover.location);
		mouse.normalize();
		mouse.mult(5);
//		mover.applyForce(wind);
		mover.applyForce(mouse);
		mover.checkEdges();
		mover.update();
		mover.display();
	}
}
