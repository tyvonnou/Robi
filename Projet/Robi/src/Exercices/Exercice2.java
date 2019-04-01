package Exercices;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener; 

import graphicLayer.Morph;
import graphicLayer.World;

public class Exercice2 implements KeyListener {
	
	World w = new World("Robi world", new Dimension(200,200));
	Morph robi = new Morph();
	
		
	@Override
	public void keyPressed(KeyEvent e) {
		int code = e.getKeyCode();
		if(code == 37) {
			robi.moveLeft(1);				
		}
		
		if(code == 38) {
			robi.moveUp(1);
		}
		
		if(code == 39) {
			robi.moveRight(1);			
		} 
		
		if(code == 40) {
			robi.moveDown(1);
		}
		robi.setColor(new Color ((int) (Math.random() * 0x1000000)));
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	 @Override
	 public void keyTyped(KeyEvent e) {
	 }
	
	void run() {
		w.addMorph(robi);
		w.open();
		w.addKeyListener(this);
	}
	

	public static void main(String[] args) {
		Exercice2 exo = new Exercice2();
		exo.run();

	}
}
