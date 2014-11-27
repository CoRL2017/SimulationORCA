package fr.utbm.ia54.simulationorca.framework;

public class Position {

	private int x;
	private int y;
	
	public Position(int xPos, int yPos){
		this.x = xPos;
		this.y = yPos;
	}
	
	public double distanceTo(Position pos){
		double distance = Math.sqrt(Math.pow(this.x - pos.x, 2) + Math.pow(this.y - pos.y, 2));
		return distance;
	}
	
	public int getX() {
		return x;
	}
	public void setX(int xPos) {
		this.x = xPos;
	}
	public int getY() {
		return y;
	}
	public void setY(int yPos) {
		this.y = yPos;
	}
	
}
