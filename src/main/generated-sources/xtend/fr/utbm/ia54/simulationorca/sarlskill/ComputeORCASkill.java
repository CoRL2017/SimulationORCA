package fr.utbm.ia54.simulationorca.sarlskill;

import fr.utbm.ia54.simulationorca.sarlcapacity.ComputeNextMoveCapacity;
import io.sarl.lang.annotation.Generated;
import io.sarl.lang.core.Agent;
import io.sarl.lang.core.Skill;

@SuppressWarnings("all")
public class ComputeORCASkill extends Skill implements ComputeNextMoveCapacity {
  public void aFunction() {
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