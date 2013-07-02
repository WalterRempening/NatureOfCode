package com.natureOfCode.book.Trigonometry;

import processing.core.PApplet;
import processing.core.PVector;

public class TestField3 extends PApplet{
	
	// Mover object
	public Mover bob;
	// Spring object
	public Spring spring;
	
	public static void main(String[] args) {
		PApplet.main(new String[]{"--present", "main.TestField3"});
	}
	
	public void setup() {
	  size(640,360);
	  // Create objects at starting location
	  // Note third argument in Spring constructor is "rest length"
	  spring = new Spring(this,width/2,10,100); 
	  bob = new Mover(this, width/2,100); 

	}

	public void draw()  {
	  background(255); 
	  // Apply a gravity force to the bob
	  PVector gravity = new PVector(0,2);
	  bob.applyForce(gravity);
	  
	  // Connect the bob to the spring (this calculates the force)
	  spring.connect(bob);
	  // Constrain spring distance between min and max
	  spring.constrainLength(bob,30,200);
	  
	  // Update bob
	  bob.update();
	  // If it's being dragged
	  bob.drag(mouseX,mouseY);
	  
	  // Draw everything
	  spring.displayLine(bob); // Draw a line between spring and bob
	  bob.display(); 
	  spring.display(); 
	  
	  fill(0);
	  text("click on bob to drag",10,height-5);
	}


	// For mouse interaction with bob
	public void mousePressed()  {
	  bob.clicked(mouseX,mouseY);
	}

	public void mouseReleased()  {
	  bob.stopDragging(); 
	}


	
}
