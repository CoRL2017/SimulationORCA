package fr.utbm.ia54.simulationorca.framework;

public class Segment {

	Vector point;
	Vector unitDir;

	public Segment(Vector point, Vector unitDir) {
		this.point = point;
		this.unitDir = unitDir;
	}

	public Segment(Vector point) {
		this.point = point;
		this.unitDir = new Vector(1, 1);
	}

	public boolean isConvex() {
		return true;
	}

	public Vector getPoint() {
		return point;
	}

	public void setPoint(Vector point) {
		this.point = point;
	}

	public Vector getUnitDir() {
		return unitDir;
	}

	public void setUnitDir(Vector unitDir) {
		this.unitDir = unitDir;
	}
}
