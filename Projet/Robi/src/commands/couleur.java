package commands;


import Tools.Tools;
import graphicLayer.Morph;

public class couleur extends Command{

	public couleur(Morph target, String id) {
		super(target, id);
		// TODO Auto-generated constructor stub
	}


	@Override
	public void run(String[] args) {
		if (Tools.getColorByName(args[1]) == null) {
			target.setColor(Tools.getColorByName("black"));
		} else {
			target.setColor(Tools.getColorByName(args[1]));
		}

	}


	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

}
