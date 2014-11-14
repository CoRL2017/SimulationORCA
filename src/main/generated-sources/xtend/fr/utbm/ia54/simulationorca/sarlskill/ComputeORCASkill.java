package fr.utbm.ia54.simulationorca.sarlskill;

import fr.utbm.ia54.simulationorca.environmentmodel.Obstacle;
import fr.utbm.ia54.simulationorca.framework.Position;
import fr.utbm.ia54.simulationorca.sarlcapacity.ComputeNextMoveCapacity;
import io.sarl.lang.annotation.Generated;
import io.sarl.lang.core.Agent;
import io.sarl.lang.core.Skill;
import java.util.List;

@SuppressWarnings("all")
public class ComputeORCASkill extends Skill implements ComputeNextMoveCapacity {
  public Position nextMove(final List<Obstacle> listObstacles, final Position bodyPos, final List<Position> listNeighbours) {
    Position newPos = new Position(3, 3);
    return newPos;
  }
  
  /**
   * Construct a skill.
   * @param owner - agent that is owning this skill.
   */
  @Generated
  public ComputeORCASkill(final Agent owner) {
    super(owner);
  }
  
  /**
   * Construct a skill. The owning agent is unknown.
   */
  @Generated
  public ComputeORCASkill() {
    super();
  }
}
