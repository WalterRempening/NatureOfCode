package com.natureOfCode.book.Trigonometry;

import processing.core.PApplet;
import processing.core.PVector;

public class Pendularium extends PApplet {

	Pendulum pen;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		PApplet.main(new String[] { "--present,", "main.Pendularium" });
	}

	public void setup() {
		size(700, 400);

		pen = new Pendulum(this, 125f, new PVector((width / 2), 125));

	}

	public void draw() {
		background(255);
		pen.go();
	}

	public void mousePressed() {
		pen.clicked(mouseX, mouseY);
	}

	public void mouseReleased() {
		pen.stopDragging();
	}

}
