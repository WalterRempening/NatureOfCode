package com.natureOfCode.book.Vectors;

import processing.core.PApplet;
import processing.core.PVector;

public class Car extends PApplet{
	
	PVector location, velocity, acceleration;
	int carWidth, carHeight, limit;
	
	public static void main(String[] args) {
		PApplet.main(new String[] {"--Present","main.Car"});
	}
	
	public void setup(){
		size(800,300);
		
		location = new PVector(20,150);
		velocity = new PVector(0,0);
		acceleration = new PVector(0,0);
		
		carHeight = 20;
		carWidth = 50;
		
		limit = 2;
		acceleration.limit(limit);
	}
	
	public void draw(){
		background(255);
		
		velocity.add(acceleration);
		location.add(velocity);
		
		smooth();
		fill(0,0,180);
		rect(location.x, location.y, carWidth, carHeight);
		if(location.x > width){
			location.x = 0;
		}
		
		if(velocity.x <= 0){
			acceleration.x = 0;
			velocity.x = 0;
		}
		
		System.out.println("acceleration: " + acceleration.x);
		System.out.println("velocity	: " + velocity.x);
	}
	
	@Override
	public void keyPressed() {
		if(keyCode == keyEvent.VK_RIGHT){
			acceleration.x += 0.05f;
		}
		
		if(keyCode == keyEvent.VK_LEFT){
			acceleration.x -= 0.5f;
		}
		super.keyPressed();
	}
	
}
