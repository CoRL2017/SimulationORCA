package fr.utbm.ia54.simulationorca.sarlagent;

import io.sarl.core.Initialize;
import io.sarl.lang.annotation.Generated;
import io.sarl.lang.core.Agent;
import io.sarl.lang.core.Percept;
import java.util.UUID;

@SuppressWarnings("all")
public class Environment extends Agent {
  /**
   * Construct an agent.
   * @param parentID - identifier of the parent. It is the identifier of the parent agent and the enclosing contect, at the same time.
   */
  @Generated
  public Environment(final UUID parentID) {
    super(parentID, null);
  }
  
  /**
   * Construct an agent.
   * @param parentID - identifier of the parent. It is the identifier of the parent agent and the enclosing contect, at the same time.
   * @param agentID - identifier of the agent. If <code>null</code> the agent identifier will be computed randomly.
   */
  @Generated
  public Environment(final UUID parentID, final UUID agentID) {
    super(parentID, agentID);
  }
  
  @Percept
  public void _handle_Initialize_1(final Initialize occurrence) {
  }
}
