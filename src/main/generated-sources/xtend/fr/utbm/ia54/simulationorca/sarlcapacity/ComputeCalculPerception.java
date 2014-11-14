package fr.utbm.ia54.simulationorca.sarlcapacity;

import fr.utbm.ia54.simulationorca.framework.Position;
import io.sarl.lang.core.Capacity;
import java.util.List;

@SuppressWarnings("all")
public interface ComputeCalculPerception extends Capacity {
  public abstract List<Position> computePerception();
}
