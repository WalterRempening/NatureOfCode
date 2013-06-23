package com.natureOfCode.book.Forces;

import processing.core.PApplet;
import processing.core.PVector;

public class Friction{
	
	/**
	 * Friction force simulation object
	 * 
	 * Fr = -1 * u * N * v(unit)
	 * 
	 * u = miu, friction coefficient
	 * N = normal force opossing the gravitational force
	 * v = direction of the velocity
	 * 
	 *  @author wrd
	 */
	
	float miu, frictionMagnitude;
	float x, y, w, h;
	PVector normal;
	
	
	public Friction(float u){
		miu = u;
	}
	
	public Friction(float u, float x_, float w_, float y_, float h_){
		miu = u;
		x = x_;
		w = w_;
		y = y_;
		h = h_;
	}
	
	public PVector drag(PVector vel){
		PVector friction = vel.get();
		frictionMagnitude = miu * -1;
		friction.normalize();
		friction.mult(frictionMagnitude);
		return friction;
	}
	
	public boolean inContact(PVector loc){
		if (loc.x > x && loc.x < x + w && loc.y > y
				&& loc.y < y + h) {
			return true;
		} else {
			return false;
		}
		
		
	}

}
