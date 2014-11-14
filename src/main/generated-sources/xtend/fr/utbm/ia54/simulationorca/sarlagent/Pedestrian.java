package fr.utbm.ia54.simulationorca.sarlagent;

import fr.utbm.ia54.simulationorca.framework.Position;
import fr.utbm.ia54.simulationorca.sarlevent.InfuenceReceivedEvent;
import fr.utbm.ia54.simulationorca.sarlevent.PerceptionReceivedEvent;
import io.sarl.core.Initialize;
import io.sarl.lang.annotation.Generated;
import io.sarl.lang.core.Address;
import io.sarl.lang.core.Agent;
import io.sarl.lang.core.AgentContext;
import io.sarl.lang.core.Event;
import io.sarl.lang.core.EventSpace;
import io.sarl.lang.core.Percept;
import io.sarl.lang.core.Scope;
import io.sarl.util.Scopes;
import java.util.Collection;
import java.util.UUID;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.InputOutput;

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
  
  @Generated
  protected void emit(final Event e) {
    getSkill(io.sarl.core.DefaultContextInteractions.class).emit(e);
  }
  
  @Generated
  protected void emit(final Event e, final Scope<Address> scope) {
    getSkill(io.sarl.core.DefaultContextInteractions.class).emit(e, scope);
  }
  
  @Generated
  protected Address getDefaultAddress() {
    return getSkill(io.sarl.core.DefaultContextInteractions.class).getDefaultAddress();
  }
  
  @Generated
  protected AgentContext getDefaultContext() {
    return getSkill(io.sarl.core.DefaultContextInteractions.class).getDefaultContext();
  }
  
  @Generated
  protected EventSpace getDefaultSpace() {
    return getSkill(io.sarl.core.DefaultContextInteractions.class).getDefaultSpace();
  }
  
  @Generated
  protected void receive(final UUID receiver, final Event e) {
    getSkill(io.sarl.core.DefaultContextInteractions.class).receive(receiver, e);
  }
  
  @Generated
  protected UUID spawn(final Class<? extends Agent> aAgent, final Object... params) {
    return getSkill(io.sarl.core.DefaultContextInteractions.class).spawn(aAgent, params);
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
  
  @Percept
  public void _handle_PerceptionReceivedEvent_2(final PerceptionReceivedEvent occurrence) {
    InputOutput.<String>println("in PerceptionReceivedEvent");
    Position newPos = new Position(3, 3);
    InfuenceReceivedEvent _infuenceReceivedEvent = new InfuenceReceivedEvent(newPos);
    Address _source = occurrence.getSource();
    Scope<Address> _addresses = Scopes.addresses(_source);
    this.emit(_infuenceReceivedEvent, _addresses);
  }
}
