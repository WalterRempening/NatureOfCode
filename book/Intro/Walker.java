package com.natureOfCode.book.Intro;

import java.util.Random;

import processing.core.PApplet;

public class Walker{
	
	PApplet p;
	int x;
	int y;
	float stepSize;
	Random generator;
	
	Walker(PApplet pa, int _x, int _y){
		p = pa;
		x = _x;
		y = _y;
		generator = new Random();
	}
	
	public void display(){
		p.stroke(0);
		p.point(x, y);
	}
	
	public void step(){
		
		float num = (float) generator.nextGaussian();
		float sd = 50;
		float mean = 100;
		
		stepSize = sd * num + mean;
		
		// 50% chance to move towards the mouse
		float r = p.random(1);
		
		if (r < 0.5) {
		      
			if(p.mouseX > (p.width/2)){
		    	  x++;
		      } else if(p.mouseX < (p.width/2)){
		    	  x--;
		      } else if(p.mouseY > (p.height/2)){
		    	  y++;
		      } else if(p.mouseY < (p.height/2)){
		    	  y--;
		      }
		      
		    } else if (r < 0.625) {
		      x++;
		    } else if (r < 0.750) {
		      x--;
		    } else if (r < 0.875) {
		      y++;
		    } else {
		      y--;
		    }
		
		// 9 Choices 
//		float stepx = p.random(-1, 1);
//		 float stepy = p.random(-1, 1);
//		 x += stepx;
//		 y += stepy;
		 
		 
//		    4 choices
//	    int choice = (int)(p.random(4));
//
//	    switch (choice) {
//		case 0:
//			x+=stepSize;
//			break;
//		case 1:
//			x-=stepSize;
//			break;
//		case 2:
//			y+=stepSize;
//			break;
//		case 3:
//			y-=stepSize;
//			break;
//		}
	}
}
