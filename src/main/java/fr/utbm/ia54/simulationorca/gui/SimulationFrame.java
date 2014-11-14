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

public class SimulationFrame extends JFrame implements EnvironmentListener {

	private static final long serialVersionUID = -3163338454480158226L;
	private static int HEIGHT = 500;
	private static int WIDTH = 500;
	private static int CIRCLE_DIAMETER = 50;
	
	@SuppressWarnings("unused")
	private final Set<Obstacle> obstacles;
	private Set<AgentBody> pedestrianBodies = new HashSet<AgentBody>();
	private JPanel mainPanel;
	
	public SimulationFrame(final Set<Obstacle> obstacles){
		this.obstacles = obstacles;
		
		// Paramètres de définition de la fenêtre
		this.setSize(new Dimension(WIDTH, HEIGHT));
		this.setTitle("SUPER BLAAA");
		
		// Création du Jpanel responsable de l'affichage
		mainPanel = new JPanel(){
			private static final long serialVersionUID = 1590001807804743054L;

			@Override
			public void paint(Graphics graphics) {
				super.paint(graphics);
				// Dessin des obstacles
				for(Obstacle obs : obstacles){
					graphics.setColor(Color.white);
					graphics.drawLine(obs.getPosA().getX(), obs.getPosA().getY(), obs.getPosB().getX(), obs.getPosB().getY());
				} 
				
				// Dessin des piétons
				for(AgentBody body : pedestrianBodies){
					graphics.setColor(Color.cyan);
					graphics.drawOval(body.getPosition().getX(), body.getPosition().getY(), CIRCLE_DIAMETER, CIRCLE_DIAMETER);
				}
			}
		};
		mainPanel.setBackground(Color.black);
		
		this.setContentPane(mainPanel);
		this.setVisible(true);
	}
	
	@Override
	public void updateGraphics(Set<AgentBody> pedestrianBodies) {
		this.pedestrianBodies = pedestrianBodies;
		mainPanel.repaint();
	}
	
// TEST DE LA FRAME
	@SuppressWarnings("unused")
	public static void main(String[] args){
		SimulationFrame frame = new SimulationFrame(null);	
	}
	
}
