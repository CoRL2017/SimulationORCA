package fr.utbm.ia54.simulationorca.environmentmodel;

import fr.utbm.ia54.simulationorca.framework.Vector;
import io.sarl.lang.core.Address;

public class AgentBody extends EnvironmentObject{

	private Vector position;
	private Address pedestrianAddress;
	
	public AgentBody(Address address, Vector position){
		this.pedestrianAddress = address;
		this.position = position;
	}

	public Address getPedestrianAddress() {
		return pedestrianAddress;
	}

	public void setPedestrianAddress(Address pedestrianAddress) {
		this.pedestrianAddress = pedestrianAddress;
	}

	public Vector getPosition() {
		return position;
	}

	public void setPosition(Vector position) {
		this.position = position;
	}
}
