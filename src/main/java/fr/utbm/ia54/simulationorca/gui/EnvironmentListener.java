package fr.utbm.ia54.simulationorca.gui;

import java.util.EventListener;
import java.util.Set;

import fr.utbm.ia54.simulationorca.environmentmodel.AgentBody;

public interface EnvironmentListener extends EventListener {

	void updateGraphics(Set<AgentBody> pedestrianBodies);
	
}
