package commands;

import Tools.Tools;
import graphicLayer.Morph;

public class gauche extends Command{

	public gauche(Morph target, int id) {
		super(target, id);
		// TODO Auto-generated constructor stub
	}
	
	public gauche(Morph target, String id) {
		super(target, id);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void run() {
		this.target.moveLeft(1);
	}

	@Override
	public void run(String[] args) {
		int nbGap = Integer.parseInt(args[1]);
		while(nbGap > 0) {
			this.target.moveLeft(1);
			Tools.sleep(5);
			nbGap --;
		}
	}
}
