package fr.utbm.ia54.simulationorca.framework;

public class Position {

	private int xPos;
	private int yPos;
	
	public Position(int xPos, int yPos){
		this.xPos = xPos;
		this.yPos = yPos;
	}
	
	public Position(){
	}
	
	public int getXPos() {
		return xPos;
	}
	public void setXPos(int xPos) {
		this.xPos = xPos;
	}
	public int getYPos() {
		return yPos;
	}
	public void setYPos(int yPos) {
		this.yPos = yPos;
	}
	
}
