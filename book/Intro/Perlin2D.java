package com.natureOfCode.book.Intro;

import processing.core.PApplet;

public class Perlin2D extends PApplet{
	
	public void setup(){
		size(640,320);
		
	}
	
	public void draw(){
		loadPixels();
		for(int i = 0; i < width; i++){
			for(int j = 0; j < height; j++){
				float bright = map(noise(i,j),0,1,0,255);
				 pixels[i+j*width] = color(bright);
				
			}
		}
		updatePixels();
	}	
}
