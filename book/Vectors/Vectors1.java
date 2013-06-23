package com.natureOfCode.book.Vectors;

import com.natureOfCode.book.Mover;

import processing.core.PApplet;

public class Vectors1 extends PApplet{
	
	public static void main(String args[]) {
		PApplet.main(new String[] { "--present", "main.Vectors1" });
	}
	
	public Mover mover;
	public PerlinMover pmover;
	public void setup(){
		
		size(800,500);
		mover = new Mover(Vectors1.this, width/2, height/2, 30);
		pmover = new PerlinMover(this);
	}
	
	public void draw(){
		background(255);
		smooth();
		mover.update();
		pmover.update();
		
		mover.display();
		pmover.display();
		pmover.checkEdges();
		
	}
	
}
