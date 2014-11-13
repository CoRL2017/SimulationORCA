package fr.utbm.ia54.simulationorca.framework;

public class Position {

	private int x;
	private int y;
	
	public Position(int xPos, int yPos){
		this.x = xPos;
		this.y = yPos;
	}
	
	public Position(){
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
