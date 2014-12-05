package fr.utbm.ia54.simulationorca.environmentmodel;

import fr.utbm.ia54.simulationorca.framework.Constants;

public final class TimeManager {

	public static float time;
	public static final float timeStep = Constants.TIME_STEP;

	public TimeManager() {
		time = 0;
	}

	public static void incrementTime() {
		time = time + timeStep;
	}
}
