package com.natureOfCode.book.Forces;

import com.natureOfCode.book.Mover;

import processing.core.PApplet;
import processing.core.PVector;

public class Gravitation extends PApplet{

	Mover m;
	Attractor a;
	PVector gravitationForce;
	
	public static void main(String[] args) {
		PApplet.main(new String[]{"--present", "main.Gravitation"});
	}
	
	public void setup(){
		size(500,300);
		m = new Mover(this, 100, 100, 1);
		a = new Attractor(this, width/2, height/2, 30);
	}
	
	public void draw(){
		background(255);
		
		gravitationForce = a.attract(m);
		m.applyForce(gravitationForce);
		m.update();

		a.display();
		m.display();
		
		
	}
	
}
