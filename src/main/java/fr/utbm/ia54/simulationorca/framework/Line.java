package fr.utbm.ia54.simulationorca.framework;

public class Line {

	Vector point;
	Vector direction;
	
	public Line(){
		
	}
	
	public Line(Vector point, Vector direction){
		this.point = point;
		this.direction = direction;
	}

	public Vector getPoint() {
		return point;
	}

	public void setPoint(Vector point) {
		this.point = point;
	}

	public Vector getDirection() {
		return direction;
	}

	public void setDirection(Vector direction) {
		this.direction = direction;
	}
}
