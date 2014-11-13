package fr.utbm.ia54.simulationorca.sarlagent;

import fr.utbm.ia54.simulationorca.framework.Position;
import io.sarl.core.Initialize;
import io.sarl.lang.annotation.Generated;
import io.sarl.lang.core.Agent;
import io.sarl.lang.core.AgentContext;
import io.sarl.lang.core.Percept;
import java.util.Collection;
import java.util.UUID;
import org.eclipse.xtext.xbase.lib.Conversions;

@SuppressWarnings("all")
public class Pedestrian extends Agent {
  /**
   * Construct an agent.
   * @param parentID - identifier of the parent. It is the identifier of the parent agent and the enclosing contect, at the same time.
   */
  @Generated
  public Pedestrian(final UUID parentID) {
    super(parentID, null);
  }
  
  /**
   * Construct an agent.
   * @param parentID - identifier of the parent. It is the identifier of the parent agent and the enclosing contect, at the same time.
   * @param agentID - identifier of the agent. If <code>null</code> the agent identifier will be computed randomly.
   */
  @Generated
  public Pedestrian(final UUID parentID, final UUID agentID) {
    super(parentID, agentID);
  }
  
  @Generated
  protected void killMe() {
    getSkill(io.sarl.core.Lifecycle.class).killMe();
  }
  
  @Generated
  protected UUID spawnInContext(final Class<? extends Agent> agentClass, final AgentContext context, final Object... params) {
    return getSkill(io.sarl.core.Lifecycle.class).spawnInContext(agentClass, context, params);
  }
  
  @Generated
  protected UUID spawnInContextWithID(final Class<? extends Agent> agentClass, final UUID agentID, final AgentContext context, final Object... params) {
    return getSkill(io.sarl.core.Lifecycle.class).spawnInContextWithID(agentClass, agentID, context, params);
  }
  
  protected Position initialPosition;
  
  protected Position finalPostition;
  
  @Percept
  public void _handle_Initialize_1(final Initialize occurrence) {
    Object _get = occurrence.parameters[0];
    Object _get_1 = ((Object[])Conversions.unwrapArray(((Collection<Object>) _get), Object.class))[0];
    this.initialPosition = ((Position) _get_1);
    Object _get_2 = occurrence.parameters[0];
    Object _get_3 = ((Object[])Conversions.unwrapArray(((Collection<Object>) _get_2), Object.class))[0];
    this.finalPostition = ((Position) _get_3);
  }
}
