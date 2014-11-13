package fr.utbm.ia54.simulationorca.environmentmodel;

import fr.utbm.ia54.simulationorca.framework.Position;

public final class Obstacle extends EnvironmentObject{

	private Position posA;
	private Position posB;

	public Obstacle(Position posA, Position posB){
		this.posA = posA;
		this.posB = posB;
	}

	public Position getPosA() {
		return posA;
	}

	public Position getPosB() {
		return posB;
	}
	
}
