package fr.utbm.ia54.simulationorca.gui;

import java.util.Set;

import fr.utbm.ia54.simulationorca.environmentmodel.EnvironmentObject;

public interface EnvironmentListener {
	void updateGraphics(Set<EnvironmentObject> environmentObjects);
}
