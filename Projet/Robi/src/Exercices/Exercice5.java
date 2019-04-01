package Exercices;

import java.awt.Dimension;
import java.util.ArrayList;

import Tools.Tools;
import graphicLayer.Morph;
import graphicLayer.World;
import commands.*;

public class Exercice5{
	ArrayList<Command> Commandes = new ArrayList<>();
	
	public void initCommandes() {
		Commandes.add(new droite(robi, "r"));
		Commandes.add(new gauche(robi, "l"));
		Commandes.add(new haut(robi, "u"));
		Commandes.add(new bas(robi, "d"));
		Commandes.add(new couleur(robi, "c"));

	}

		
		World w = new World("Robi world", new Dimension(200,200));
		Morph robi = new Morph();
		
		public Command getCommandFromKeyCode(String[] e) {
			
			for(Command c : Commandes) {
				if(e[0].equals(c.name)) {
					//robi.setColor(new Color ((int) (Math.random() * 0x1000000)));
					return c;
				}
			}
			return null;
		}

	
		void run() {
			w.addMorph(robi);
			w.open();
			String values[];
			String entree = "start" ;
			while((entree.equals("stop") == false)) {
				entree = Tools.readKeyboard();
				values = entree.split(" ");
				Command command = getCommandFromKeyCode(values);

				if(command != null) {
					command.run(values);				
				}
			}
			System.exit(0);
		}
	
		public static void main(String[] args) {
			Exercice5 exo = new Exercice5();
			exo.initCommandes();
			exo.run();
		}	
}