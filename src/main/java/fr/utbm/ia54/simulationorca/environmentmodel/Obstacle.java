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
	
	private static float projectsPointOnLine(float px, float py, float s1x, float s1y, float s2x, float s2y) {
		float r_numerator = (px-s1x)*(s2x-s1x) + (py-s1y)*(s2y-s1y);
		float r_denomenator = (s2x-s1x)*(s2x-s1x) + (s2y-s1y)*(s2y-s1y);
		return r_numerator / r_denomenator;
	}
	
	private static float clamp(float v, float min, float max) {
		if (min<max) {
			if (v<min) return min;
			if (v>max) return max;
		}
		else {
			if (v>min) return min;
			if (v<max) return max;
		}
		return v;
	}

	public float distanceTo(Position p) {
		float ratio = projectsPointOnLine(p.getX(), p.getY(),
				getPosA().getX(), getPosA().getY(),
				getPosB().getX(), getPosB().getY());
		ratio = clamp(ratio, 0f, 1f);
		float vx = ratio * (getPosB().getX() - getPosA().getX());
		float vy = ratio * (getPosB().getY() - getPosA().getY());
		return Math.abs(getPosA().getX() + vx - p.getX())
				+ Math.abs(getPosA().getY() + vy - p.getY());
	}
	
}
