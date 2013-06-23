package com.natureOfCode.book.Intro;

import processing.core.PApplet;
import toxi.geom.Spline3D;

public class Perlin3D extends PApplet{
	
	Spline s;
	float perlin;
	
	public void setup(){
		size(920,720,P3D);
		background(255);
//		perlin = map(0())
		s = new Spline(Perlin3D.this, width/2, height, 0, 0);
	}
	
	public void draw(){
		s.display();
		
		
//		fill(50);
//		beginShape();
//		vertex(100, 150, 0 + 0);
//		vertex(100, 150 + 60, 0 + 0);
//		vertex(100 + 30, 150 + 60, 0 + 0);
//		vertex(100 + 30, 150, 0 + 0);
//		endShape();
	}
	
}
