package Exercices;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import graphicLayer.Morph;
import graphicLayer.World;
import commands.*;

public class Exercice3 implements KeyListener{
		// Liste de commandes 
		ArrayList<Command> Commandes = new ArrayList<>();
	
		World w = new World("Robi world", new Dimension(200,200));
		Morph robi = new Morph();
		
		public Command getCommandFromKeyCode(int e) {
			Commandes.add(new droite(robi, 39));
			Commandes.add(new gauche(robi, 37));
			Commandes.add(new haut(robi, 38));
			Commandes.add(new bas(robi, 40));

			for(Command c : Commandes) {
				if(e == c.id) {
					robi.setColor(new Color ((int) (Math.random() * 0x1000000)));
					
					return c;
				
				}
			}
			
			return null;
		}
		
			
		public void keyPressed(KeyEvent e) {
			Command command = getCommandFromKeyCode(e.getKeyCode());
			
			if(command != null) {
				command.run();				
			}
		}

		public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
		}
	
		public void keyTyped(KeyEvent e) {
		}
	
		void run() {
			w.addMorph(robi);
			w.open();
			w.addKeyListener(this);
		}
	
		public static void main(String[] args) {
			Exercice3 exo = new Exercice3();
			exo.run();
		}	
}