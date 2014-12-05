package fr.utbm.ia54.simulationorca.framework;

public class Vector {

	private float x;
	private float y;
	
	public Vector(float xPos, float yPos){
		this.x = xPos;
		this.y = yPos;
	}
	
	public double distanceTo(Vector pos){
		double distance = Math.sqrt(Math.pow(this.x - pos.x, 2) + Math.pow(this.y - pos.y, 2));
		return distance;
	}
	
	public float abs(){
		return (float) Math.sqrt(x*x + y*y);
	}
	public Vector minus(Vector b){
		return new Vector(x-b.x, y-b.y);
	}
	
	public Vector plus(Vector b){
		return new Vector(x+b.x, y+b.y);
	}
	
	public Vector plus(float f){
		return new Vector(x+f, y+f);
	}
	
	/*public Vector prod(Vector b){
		return new Vector(x*b.x, y*b.y);
	}*/
	
	public float absSq(){
		return x*x+y*y;
	}
	
	public Vector prod(float f){
		return new Vector(x*f,y*f);
	}
	
	public float prod(Vector b){
		return x*b.x+y*b.y;
	}
	
	public Vector divide(float f){
		return new Vector(x/f,y/f);
	}
	
	public float det(Vector b){
		return x*b.y -y*b.x;
	}
	
	public Vector normalize(){
		return divide(abs());
	}
	
	
	public float getX() {
		return x;
	}
	public void setX(float xPos) {
		this.x = xPos;
	}
	public float getY() {
		return y;
	}
	public void setY(float yPos) {
		this.y = yPos;
	}
	
}
