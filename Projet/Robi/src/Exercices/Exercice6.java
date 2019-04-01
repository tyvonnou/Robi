package Exercices;

import java.awt.Dimension;
import java.util.ArrayList;

import Tools.Tools;
import graphicLayer.Morph;
import graphicLayer.World;
import commands.*;

public class Exercice6 {
	// Liste de commande 
	ArrayList<Command> Commandes = new ArrayList<>();
	// Liste de commande valide
		ArrayList<Command> CommandesV = new ArrayList<>();
	// Liste de macros 
	ArrayList<macro> Macros = new ArrayList<>();
	
	// Initialisation des commandes 
	public void initCommandes() {
		Commandes.add(new droite(robi, "d"));
		Commandes.add(new gauche(robi, "q"));
		Commandes.add(new haut(robi, "z"));
		Commandes.add(new bas(robi, "s"));
		Commandes.add(new couleur(robi, "c"));

	}public Exercice6() {
		// TODO Auto-generated constructor stub
	}
	
	// Création de la fenêtre et du cube
	World w = new World("Robi world", new Dimension(200,200));
	Morph robi = new Morph();
		
	public Command getCommandFromKeyCode(String[] e) {	
		int i;
		for(Command c : Commandes) {
			for(i =0; i< e.length; i += 2) {
				if(e[i].equals(c.name)) {
					//robi.setColor(new Color ((int) (Math.random() * 0x1000000)));
				CommandesV.add(c);
				if(e[i].equals(null)) {
					return null;
				}

				}
			}
		}
		return null;
	}

	
	
		@SuppressWarnings({ "null", "unused", "static-access" })
		void run() {
			w.addMorph(robi);
			w.open();
			String nomMacro;
			String entree = "start" ;
			Command command;
			int i = 0;
			//TODO: Initialisation
			String[] values;
			for(i =0; i<30;i++) {
				values[i] = "init";
			}
			
			// Tant que l'utilisateur ne rentre pas stop
			while((entree.equals("stop") == false)) {
				// Je récupère l'entrée 
				entree = Tools.readKeyboard();
				// Si nouveau macro
				if(entree.equals("(")) {
					
					i = 0;
					// Je récupère le nom de mon macro
					nomMacro = Tools.readKeyboard();
					// Tant que ce n'est pas la fin 
					while(entree.equals(")") == false) {
						// je lis chaque commande
						entree = Tools.readKeyboard();
						if(entree.equals(")") == false) {
							String values2[] = null;
						// Je les réunis 
							values2 = entree.split(" ");
							System.out.println(values2[0]);
							System.out.println(values2[1]);
							// TODO: COPIE 
							values[i] = new String(values2[0]);
							values[i+1] = new String(values2[1]);
							i+=2;
						}
						
						

					}
					
					Macros.add(new macro(nomMacro, values));

				}
				
				for(macro m : Macros) {
					if(entree.equals(m.name)) {
//						System.out.println(m.values2]);
						command = getCommandFromKeyCode(m.values);
						for(Command c : CommandesV) {
							if(c != null) {
								c.run(m.values);
							}
						}

					}
				}
				CommandesV.clear();

				// Je l'execute 
				
			}
			System.exit(0);
		}
	
		public static void main(String[] args) {
			Exercice6 exo = new Exercice6();
			exo.initCommandes();
			exo.run();
		}	
}