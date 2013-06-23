package com.natureOfCode.book.Intro;

import processing.core.PApplet;

public class Sketch extends PApplet{

	public Walker w;

	
	public static void main(String args[]) {
		PApplet.main(new String[] { "--present", "main.Sketch" });
	}
	
	public void setup(){
		size(640, 320);
		background(255);
		w = new Walker(Sketch.this, width/2, height/2);
	}
	
	public void draw(){
		w.step();
		w.display();
	}
	
	
}
