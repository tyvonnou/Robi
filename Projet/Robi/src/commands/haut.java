package commands;

import Tools.Tools;
import graphicLayer.Morph;

public class haut extends Command{

	public haut(Morph target, int id) {
		super(target, id);
		// TODO Auto-generated constructor stub
	}
	public haut(Morph target, String id) {
		super(target, id);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void run() {
		this.target.moveUp(1);		
	}

	@Override
	public void run(String[] args) {
		int nbGap = Integer.parseInt(args[1]);
		while(nbGap > 0) {
			this.target.moveUp(1);
			Tools.sleep(5);
			nbGap --;
		}
	}

}
