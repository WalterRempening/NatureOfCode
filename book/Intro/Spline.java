package com.natureOfCode.book.Intro;

import processing.core.PApplet;

public class Spline {
	
	PApplet p;
	int mX = 0;
	int mY = 0;
	int mZ = 0;
	float noise = 0;
	
	/**
	 * Creates a spline in 3D space
	 * @param pa
	 * @param x starting point
	 * @param y width
	 * @param z height
	 */
	public Spline(PApplet pa, int x, int y, int z, float pn){
		p = pa;
		mX = x;
		mY = y;
		mZ = z;
	}
	
	public void display(){
		p.fill(50);
		
		p.beginShape();
		p.vertex(mX, mY, mZ + noise);
		p.vertex(mX, mY + 60, mZ + noise);
		p.vertex(mX + 30, mY, mZ + noise);
		p.vertex(mX + 30, mY + 60, mZ + noise);
		p.endShape();
		
	}
	
}
