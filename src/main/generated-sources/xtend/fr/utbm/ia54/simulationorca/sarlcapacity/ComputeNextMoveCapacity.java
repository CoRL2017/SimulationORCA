package fr.utbm.ia54.simulationorca.sarlcapacity;

import fr.utbm.ia54.simulationorca.environmentmodel.Obstacle;
import fr.utbm.ia54.simulationorca.framework.Position;
import io.sarl.lang.core.Capacity;
import java.util.List;

@SuppressWarnings("all")
public interface ComputeNextMoveCapacity extends Capacity {
  public abstract Position nextMove(final List<Obstacle> listObstacles, final Position bodyPos, final List<Position> listNeighbours);
}
