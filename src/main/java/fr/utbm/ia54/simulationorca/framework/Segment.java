package fr.utbm.ia54.simulationorca.framework;

public class Segment {

	Vector point;
	Vector unitDir;
	boolean isConvex;

	public Segment(Vector point, Vector unitDir) {
		this.point = point;
		this.unitDir = unitDir;
	}

	public void setConvexity(boolean isConvex) {
		this.isConvex = isConvex;
	}

	public boolean isConvex() {
		return isConvex;
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

	public boolean equals(Segment seg) {
		return (this.point.equals(seg.point) && this.unitDir
				.equals(seg.unitDir));
	}
}
