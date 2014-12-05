package fr.utbm.ia54.simulationorca.framework;

public final class Constants  {
	
	// Constants relative to the world structure
	public static final int WORLD_HEIGHT = 768;
	public static final int WORLD_WIDTH = 1024;
	public static final String XML_STRUCTURE_FILEPATH = "./environment_structure.xml";
	
	// Constants relative to the Simulation Frame
	public static final int FRAME_HEIGHT = 600;
	public static final int FRAME_WIDTH = 900;
	public static final String FRAME_TITLE = "IA54 Project - Simulation of pedestrians movements according to ORCA algorithm";
	public static final int PEDSTRIAN_CIRCLE_DIAMETER = 10;
	
	// Constants relative to the cycle of simulation
	public static final int TIMEOUT = 1000;
	public static final float VELOCITY = (float) 0.8;
	public static final int PRECEPTION_DISTANCE = 100;
	

}