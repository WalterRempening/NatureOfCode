package com.natureOfCode.book.Intro;

import processing.core.PApplet;

public class Perlin extends PApplet{

	private float t = 5;
	private float n = 0;

	public void setup(){
		size(640,320);
	}
	
	public void draw(){
		background(255);
		n = noise(t);
		noStroke();
		fill(0);
		float x = map(n,0,1,0,width/2);
		ellipse(width/2, height/2, 50 + x,50+ x);
		
		t+=0.01;
		System.out.println("noise:"  + n);
	}
}
