package com.natureOfCode.book.Forces;

import com.natureOfCode.book.Mover;

import processing.core.PApplet;
import processing.core.PVector;


public class Attractor {
	
	public PVector loc;
	public PApplet p;
	public float mass;
	public float G;
	
	public Attractor(PApplet parent, float x, float y, float m){
		p = parent;
		loc = new PVector(x,y);
		mass = m;
		G = 0.4f;
		
	}
	
	public void display(){
		p.stroke(0);
	    p.fill(175,200,0);
	    p.ellipse(loc.x,loc.y,mass*2,mass*2);
	}
	
	public PVector attract(Mover m){
		PVector force = PVector.sub(loc, m.location);
		float distance = force.mag();
		distance = p.constrain(distance, 5.0f, 25.0f);
		force.normalize();
		float strength = (G * mass * m.mass) / (distance * distance);
		force.mult(strength);
		return force;
	}
	
}
