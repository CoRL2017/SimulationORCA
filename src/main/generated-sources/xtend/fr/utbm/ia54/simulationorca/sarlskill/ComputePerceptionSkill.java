package fr.utbm.ia54.simulationorca.sarlskill;

import fr.utbm.ia54.simulationorca.environmentmodel.AgentBody;
import fr.utbm.ia54.simulationorca.framework.Position;
import fr.utbm.ia54.simulationorca.sarlcapacity.ComputePerceptionCapacity;
import io.sarl.lang.annotation.Generated;
import io.sarl.lang.core.Agent;
import io.sarl.lang.core.Skill;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("all")
public class ComputePerceptionSkill extends Skill implements ComputePerceptionCapacity {
  public List<Position> computePerception(final Position bodyPos, final List<AgentBody> listAgentBodies) {
    List<Position> listNeighbours = new ArrayList<Position>();
    return listNeighbours;
  }
  
  /**
   * Construct a skill.
   * @param owner - agent that is owning this skill.
   */
  @Generated
  public ComputePerceptionSkill(final Agent owner) {
    super(owner);
  }
  
  /**
   * Construct a skill. The owning agent is unknown.
   */
  @Generated
  public ComputePerceptionSkill() {
    super();
  }
}
