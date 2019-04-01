package Exercices;

import java.awt.Color;
import java.awt.Dimension;

import Tools.Tools;
import graphicLayer.Morph;
import graphicLayer.World;

public class Exercice1 {
	World w = new World("Robi world", new Dimension(200,200));
	
	void run() {
		Morph robi = new Morph();
		w.addMorph(robi);
		w.open();
		int robiWidth = robi.getWidth();

		while (true) {
			int worldWidth = (int) w.getWidth();
			int worldHeight = (int) w.getHeight();
		
			
			for(int i = 0; i < worldWidth-robiWidth; i ++) {
				robi.moveRight(1);
				Tools.sleep(5);
				if((i%10) == 0) {
					robi.setColor(new Color ((int) (Math.random() * 0x1000000)));
				}
			}

			for(int i = 0; i < worldHeight-robiWidth; i ++) {
				robi.moveDown(1);
				Tools.sleep(5);
				if((i%10) == 0) {
					robi.setColor(new Color ((int) (Math.random() * 0x1000000)));
				}
			}
			
			for(int i = 0; i < worldWidth-robiWidth; i ++) {
				robi.moveLeft(1);
				Tools.sleep(5);
				if((i%10) == 0) {
					robi.setColor(new Color ((int) (Math.random() * 0x1000000)));
				}
			}
			for(int i = 0; i < worldHeight-robiWidth; i ++) {
				robi.moveUp(1);
				Tools.sleep(5);
				if((i%10) == 0) {
					robi.setColor(new Color ((int) (Math.random() * 0x1000000)));
				}
			}
			
			
			
		}
	}
	
	public static void main(String args[]) {
		Exercice1 exo = new Exercice1();
		exo.run();
	}

}
