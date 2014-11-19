package fr.utbm.ia54.projet.SimulationORCA;

import fr.utbm.ia54.simulationorca.environmentmodel.Obstacle;
import fr.utbm.ia54.simulationorca.framework.XMLParser;
import junit.framework.TestCase;

public class XMLParserTest extends TestCase {
	
	public void testApp(){
		XMLParser xmlParser = new XMLParser("./environment_structure.xml");	
		xmlParser.loadXMLDocument();

		System.out.println("Taille liste pos_init : " + xmlParser.getListInitialPositionPedestrians().size());
		System.out.println("Taille liste pos_final : " + xmlParser.getListFinalPositionPedestrians().size());
		System.out.println("Taille liste obstacles : " + xmlParser.getListObstacles().size());
		
		for(Obstacle obs : xmlParser.getListObstacles()){
			System.out.println("Obstacle " + obs.getPosA().getX());
		}
		
		for(Obstacle obs : xmlParser.getListObstacles()){
			System.out.println("Obstacle " + obs.getPosA().getX());
		}
	}

}
