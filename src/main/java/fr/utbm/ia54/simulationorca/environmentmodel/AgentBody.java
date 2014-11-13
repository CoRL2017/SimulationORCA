package fr.utbm.ia54.simulationorca.environmentmodel;

import fr.utbm.ia54.simulationorca.framework.Position;
import io.sarl.lang.core.Address;

public class AgentBody extends EnvironmentObject{

	private Position position;
	private Address pedestrianAddress;
	
	public AgentBody(Address address, Position position){
		this.pedestrianAddress = address;
		this.position = position;
	}

	public Address getPedestrianAddress() {
		return pedestrianAddress;
	}

	public void setPedestrianAddress(Address pedestrianAddress) {
		this.pedestrianAddress = pedestrianAddress;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}
}
