package commands;

import graphicLayer.Morph;

public abstract class Command {
	Morph target;
	public String name;
	public int id;
	public Command (Morph target, int id) {
		this.target = target;
		this.id = id;
	}
	public Command (Morph target, String name) {
		this.target = target;
		this.name = name;
	}
	
	
	Morph getTarget() { return target; }
	abstract public void run();
	abstract public void run(String [] args);
}
