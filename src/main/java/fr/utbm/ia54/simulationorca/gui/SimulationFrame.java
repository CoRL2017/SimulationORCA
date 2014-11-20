package fr.utbm.ia54.simulationorca.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.HashSet;
import java.util.Set;

import javax.swing.JFrame;
import javax.swing.JPanel;

import fr.utbm.ia54.simulationorca.environmentmodel.AgentBody;
import fr.utbm.ia54.simulationorca.environmentmodel.Obstacle;
import fr.utbm.ia54.simulationorca.framework.Constants;

public class SimulationFrame extends JFrame implements EnvironmentListener {

	private static final long serialVersionUID = -3163338454480158226L;
	
	@SuppressWarnings("unused")
	private final Set<Obstacle> obstacles;
	private Set<AgentBody> pedestrianBodies = new HashSet<AgentBody>();
	private JPanel mainPanel;
	
	public SimulationFrame(final Set<Obstacle> obstacles){
		this.obstacles = obstacles;
		
		// Définition des aramètres de la fenêtre
		this.setSize(new Dimension(Constants.FRAME_WIDTH, Constants.FRAME_HEIGHT));
		this.setTitle(Constants.FRAME_TITLE);
		this.setLocationRelativeTo(null);
		
		// Création du Panel responsable de l'affichage
		mainPanel = new JPanel(){
			private static final long serialVersionUID = 1590001807804743054L;

			@Override
			public void paint(Graphics graphics) {

				super.paint(graphics);
				
				// Dessin des obstacles
				if( obstacles != null){
					for(Obstacle obs : obstacles){
						graphics.setColor(Color.white);
						graphics.drawLine(obs.getPosA().getX(), obs.getPosA().getY(), obs.getPosB().getX(), obs.getPosB().getY());
					} 					
				} else {
					System.out.println("SimulationFrame - No obstacle to be drawn");
				}
				
				// Dessin des piétons
				if( pedestrianBodies != null){
					for(AgentBody body : pedestrianBodies){
						graphics.setColor(Color.cyan);
						graphics.drawOval(body.getPosition().getX(), body.getPosition().getY(), Constants.PEDSTRIAN_CIRCLE_DIAMETER, Constants.PEDSTRIAN_CIRCLE_DIAMETER);
					}					
				} else {
					System.out.println("SimulationFrame - No pedestrian to be drawn");
				}
			}
		};
		mainPanel.setBackground(Color.black);
		
		this.setVisible(true);
		this.setContentPane(mainPanel);
	}
	
	@Override
	public void updateGraphics(Set<AgentBody> pedestrianBodies) {
		this.pedestrianBodies = pedestrianBodies;
		repaint();
	}
	
// TEST DE LA FRAME
//	@SuppressWarnings("unused")
//	public static void main(String[] args){
//		XMLParser test = new XMLParser(Constants.XML_STRUCTURE_FILEPATH);
//		test.loadXMLDocument();
//		
//		SimulationFrame frame = new SimulationFrame(test.getListObstacles());	
//	}
	
}
