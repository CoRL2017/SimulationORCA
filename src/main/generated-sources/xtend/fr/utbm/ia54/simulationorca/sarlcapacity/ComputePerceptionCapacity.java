package fr.utbm.ia54.simulationorca.sarlcapacity;

import fr.utbm.ia54.simulationorca.environmentmodel.AgentBody;
import fr.utbm.ia54.simulationorca.framework.Position;
import io.sarl.lang.core.Capacity;
import java.util.List;

@SuppressWarnings("all")
public interface ComputePerceptionCapacity extends Capacity {
  public abstract List<Position> computePerception(final Position bodyPos, final List<AgentBody> listAgentBodies);
}
