package fr.utbm.ia54.simulationorca.framework;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import fr.utbm.ia54.simulationorca.environmentmodel.Obstacle;

public class XMLParser {

	private final String filepath;
	
	private List<Position> listInitialPositionPedestrians = new ArrayList<Position>();
	private List<Position> listFinalPositionPedestrians = new ArrayList<Position>();
	private List<Obstacle> listObstacles = new ArrayList<Obstacle>();
	
	public XMLParser(String filepath){	
		this.filepath = filepath;
		loadXMLDocument();		
	}

	public void loadXMLDocument(){
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(filepath));
			String line = null;
			while ((line = reader.readLine()) != null) {
				line = cleanLine(line);
				switch(line) {
					case "<obstacles>" : readObstaclesInfos(reader);
						break;
					case "<pedestrians>" : readPedestriansInfos(reader) ;
						break;
					default : //ligne suivante;
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void readPedestriansInfos(BufferedReader reader) {
		String line = null;
		try {
			while (!(line = reader.readLine()).contains("</pedestrians>")) {
				line = cleanLine(line);
				if(line.startsWith("<pedestrian>")){
					line = line.replace("<pedestrian>", "");
					line = line.replace("</pedestrian>", "");
					String[] positionValues = line.split(",");
					listInitialPositionPedestrians.add(new Position(Integer.parseInt(positionValues[0]), Integer.parseInt(positionValues[1])));
					listFinalPositionPedestrians.add(new Position(Integer.parseInt(positionValues[2]), Integer.parseInt(positionValues[3])));
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}	
		
	}

	
	private void readObstaclesInfos(BufferedReader reader) {
		String line = null;
		try {
			while (!(line = reader.readLine()).contains("</obstacles>")) {
				line = cleanLine(line);
				if(line.startsWith("<obstacle>")){
					line = line.replace("<obstacle>", "");
					line = line.replace("</obstacle>", "");
					String[] positionValues = line.split(",");
					listObstacles.add(new Obstacle(new Position(Integer.parseInt(positionValues[0]), Integer.parseInt(positionValues[1])), new Position(Integer.parseInt(positionValues[2]), Integer.parseInt(positionValues[3]))));
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
	
	private String cleanLine(String line){
		line = line.replaceAll("\\t", "");
		line = line.replaceAll("\\n", "");
		return line.trim();
	}
	
	public List<Position> getListInitialPositionPedestrians() {
		return listInitialPositionPedestrians;
	}
	
	public List<Position> getListFinalPositionPedestrians() {
		return listFinalPositionPedestrians;
	}
	
	public List<Obstacle> getListObstacles() {
		return listObstacles;
	}
}