package fr.utbm.ia54.simulationorca.framework;

public final class Constants {

	// Constants relative to the world structure
	public static final int WORLD_HEIGHT = 768;
	public static final int WORLD_WIDTH = 1024;
	public static final String XML_STRUCTURE_FILEPATH = "./obstacles_environment_structure.xml";

	// Constants relative to the Simulation Frame
	public static final int FRAME_HEIGHT = 600;
	public static final int FRAME_WIDTH = 900;
	public static final String FRAME_TITLE = "IA54 Project - Simulation of pedestrians movements according to ORCA algorithm";
	public static final float PEDSTRIAN_CIRCLE_DIAMETER = 10;

	// Constants relative to the cycle of simulation
	public static final int TIMEOUT = 5000;
	public static final float TIME_HORIZON = 5; 
	public static final float TIME_HORIZON_OBST = 5; 
	public static final float TIME_STEP = (float) 0.25; 
														
	public static final float MAX_SPEED = (float) 2; 
	public static final float PRECEPTION_DISTANCE = 100;
	public static final float EPSILON = (float) 0.00001;
	public static final float ERROR = (float) 2;
	public static final float RADIUS = 10;
}