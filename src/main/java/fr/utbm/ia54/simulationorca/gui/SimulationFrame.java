package fr.utbm.ia54.simulationorca.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.swing.JFrame;
import javax.swing.JPanel;

import fr.utbm.ia54.simulationorca.environmentmodel.AgentBody;
import fr.utbm.ia54.simulationorca.environmentmodel.Obstacle;
import fr.utbm.ia54.simulationorca.framework.Constants;
import fr.utbm.ia54.simulationorca.framework.Vector;

public class SimulationFrame extends JFrame implements EnvironmentListener {

	private static final long serialVersionUID = -3163338454480158226L;

	@SuppressWarnings("unused")
	private final Set<Obstacle> obstacles;
	private final Set<Vector> pedestrianObjectives;
	private Set<AgentBody> pedestrianBodies = new HashSet<AgentBody>();

	private JPanel mainPanel;

	public SimulationFrame(final Set<Obstacle> obstacles,
			final Set<Vector> pedestrianObjectives) {
		this.obstacles = obstacles;
		this.pedestrianObjectives = pedestrianObjectives;

		// Définition des aramètres de la fenêtre
		this.setSize(new Dimension(Constants.FRAME_WIDTH,
				Constants.FRAME_HEIGHT));
		this.setTitle(Constants.FRAME_TITLE);
		this.setLocationRelativeTo(null);

		// Création du Panel responsable de l'affichage
		mainPanel = new JPanel() {
			private static final long serialVersionUID = 1590001807804743054L;

			@Override
			public void paint(Graphics graphics) {

				super.paint(graphics);

				// Dessin des obstacles
				if (obstacles != null) {
					for (Obstacle obs : obstacles) {
						graphics.setColor(Color.white);
						List<Vector> segments = obs.getSegments();
						for (int i = 0; i < segments.size(); i++) {
							if (i < segments.size() - 1) {
								graphics.drawLine((int) segments.get(i).getX(),
										(int) segments.get(i).getY(),
										(int) segments.get(i + 1).getX(),
										(int) segments.get(i + 1).getY());
							} else {
								graphics.drawLine((int) segments.get(i).getX(),
										(int) segments.get(i).getY(),
										(int) segments.get(0).getX(),
										(int) segments.get(0).getY());
							}

						}

					}
				} else {
					System.out
							.println("SimulationFrame - No obstacle to be drawn");
				}

				// Dessin des piétons
				if (pedestrianBodies != null) {
					for (AgentBody body : pedestrianBodies) {
						graphics.setColor(Color.cyan);
						graphics.drawOval((int) body.getPosition().getX(),
								(int) body.getPosition().getY(),
								(int) Constants.PEDSTRIAN_CIRCLE_DIAMETER,
								(int) Constants.PEDSTRIAN_CIRCLE_DIAMETER);
					}
				} else {
					System.out
							.println("SimulationFrame - No pedestrian to be drawn");
				}

				if (pedestrianObjectives != null) {
					for (Vector position : pedestrianObjectives) {
						graphics.setColor(Color.orange);
						graphics.drawOval((int) position.getX(),
								(int) position.getY(),
								(int) Constants.PEDSTRIAN_CIRCLE_DIAMETER,
								(int) Constants.PEDSTRIAN_CIRCLE_DIAMETER);
					}
				} else {
					System.out
							.println("SimulationFrame - No final position to be drawn");
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
	// @SuppressWarnings("unused")
	// public static void main(String[] args){
	// XMLParser test = new XMLParser(Constants.XML_STRUCTURE_FILEPATH);
	// test.loadXMLDocument();
	//
	// SimulationFrame frame = new SimulationFrame(test.getListObstacles());
	// }

}
