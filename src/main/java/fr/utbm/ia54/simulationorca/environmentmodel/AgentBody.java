package fr.utbm.ia54.simulationorca.environmentmodel;

import io.sarl.lang.core.Address;
import fr.utbm.ia54.simulationorca.framework.Vector;

public class AgentBody {

	private Vector position;
	private Vector velocity;
	private Address pedestrianAddress;
	private Vector finalPosition;

	public AgentBody(Address address) {
		this.pedestrianAddress = address;
		this.velocity = new Vector(0, 0);
		this.position = null;
	}

	public AgentBody(Address address, Vector position) {
		this.pedestrianAddress = address;
		this.velocity = new Vector(0, 0);
		this.position = position;
	}

	public AgentBody(Address address, Vector position, Vector finalPos) {
		this.pedestrianAddress = address;
		this.velocity = new Vector(0, 0);
		this.position = position;
		this.finalPosition = finalPos;
	}

	public Address getPedestrianAddress() {
		return pedestrianAddress;
	}

	public Vector getPosition() {
		return position;
	}

	public void setPosition(Vector position) {
		this.position = position;
	}

	public Vector getVelocity() {
		return velocity;
	}

	public void setVelocity(Vector velocity) {
		this.velocity = velocity;
	}

	public Vector getFinalPosition() {
		return finalPosition;
	}

	public void setFinalPosition(Vector finalPosition) {
		this.finalPosition = finalPosition;
	}
}
