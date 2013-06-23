package com.natureOfCode.book.Trigonometry;

import processing.core.PApplet;

public class TestField2 extends PApplet {

	public static void main(String[] args) {
		PApplet.main(new String[] { "--present", "main.TestField2" });
	}
	
	Oscillator[] oscis = new Oscillator[30];
	
	public void setup() {
		size(800, 800);
		
		for(int i = 0; i < oscis.length; i++){
			oscis[i] = new Oscillator(this);
		}
	}

	public void draw() {
		background(255);
		for(int i = 0; i < oscis.length; i++){
			oscis[i].oscillate();
			oscis[i].display();
		}
		
	}
}
