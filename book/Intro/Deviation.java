package com.natureOfCode.book.Intro;

import java.util.Random;

import processing.core.PApplet;

public class Deviation extends PApplet{
	Random generator;
	
	public void setup(){
		size(640,320);
		background(255);
		generator = new Random();
	}
	
	public void draw(){
		float num = (float)generator.nextGaussian(); // returns un promedio de 0 y un sd de 1.0
		
		float sd = 60; //standard deviation, que tan picuda o plana es la campana
		float meanX = 320; // promedio, o el area del promedio
		
		float sdC = 100;
		float meanC = 150;
		
		float x = sd * num + meanX;
		float paleta = sdC * num + meanC;  
		
		noStroke();
		fill(paleta +50,paleta, 0);
		for (int i = 0; i < 20; i++) {
			ellipse(x+i, 20 + (i*10), 16, 16);
		}
	}
	
}
