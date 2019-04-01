package Exercices;

import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;

import Tools.Tools;
import graphicLayer.Morph;
import graphicLayer.World;
import commands.*;

public class Exercice4{
	
	ArrayList<Command> Commandes = new ArrayList<>();
	
	public void initCommandes() {
		Commandes.add(new droite(robi, "droite"));
		Commandes.add(new gauche(robi, "gauche"));
		Commandes.add(new haut(robi, "haut"));
		Commandes.add(new bas(robi, "bas"));
	}

		
		World w = new World("Robi world", new Dimension(200,200));
		Morph robi = new Morph();
		
		public Command getCommandFromKeyCode(String e) {
			

			for(Command c : Commandes) {
				if(e.equals(c.name)) {
					robi.setColor(new Color ((int) (Math.random() * 0x1000000)));
					return c;
				}
			}
			return null;
		}

	
		void run() {
			w.addMorph(robi);
			w.open();
			String entree = "start" ;
			while((entree.equals("stop") == false)) {
				entree = Tools.readKeyboard();
				Command command = getCommandFromKeyCode(entree);

				if(command != null) {
					command.run();				
				}
			}
			System.exit(0);
		}
	
		public static void main(String[] args) {
			Exercice4 exo = new Exercice4();
			exo.initCommandes();
			exo.run();
		}	
}