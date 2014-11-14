package fr.utbm.ia54.simulationorca.sarlagent;

import fr.utbm.ia54.simulationorca.environmentmodel.AgentBody;
import fr.utbm.ia54.simulationorca.environmentmodel.Obstacle;
import fr.utbm.ia54.simulationorca.framework.Position;
import fr.utbm.ia54.simulationorca.sarlevent.EndOfStepEvent;
import fr.utbm.ia54.simulationorca.sarlevent.InfuenceReceivedEvent;
import fr.utbm.ia54.simulationorca.sarlevent.PerceptionReceivedEvent;
import fr.utbm.ia54.simulationorca.sarlevent.SimulationStepEvent;
import io.sarl.core.Initialize;
import io.sarl.lang.annotation.Generated;
import io.sarl.lang.core.Address;
import io.sarl.lang.core.Agent;
import io.sarl.lang.core.AgentContext;
import io.sarl.lang.core.Behavior;
import io.sarl.lang.core.Event;
import io.sarl.lang.core.EventListener;
import io.sarl.lang.core.EventSpace;
import io.sarl.lang.core.Percept;
import io.sarl.lang.core.Scope;
import io.sarl.util.Scopes;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.eclipse.xtext.xbase.lib.InputOutput;

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
  protected EventListener asEventListener() {
    return getSkill(io.sarl.core.Behaviors.class).asEventListener();
  }
  
  @Generated
  protected Behavior registerBehavior(final Behavior attitude) {
    return getSkill(io.sarl.core.Behaviors.class).registerBehavior(attitude);
  }
  
  @Generated
  protected Behavior unregisterBehavior(final Behavior attitude) {
    return getSkill(io.sarl.core.Behaviors.class).unregisterBehavior(attitude);
  }
  
  @Generated
  protected void wake(final Event evt) {
    getSkill(io.sarl.core.Behaviors.class).wake(evt);
  }
  
  protected List<AgentBody> listAgentBodies = new ArrayList<AgentBody>();
  
  protected List<Obstacle> listObstacles = new ArrayList<Obstacle>();
  
  @Percept
  public void _handle_Initialize_1(final Initialize occurrence) {
    Object _get = occurrence.parameters[0];
    Object _get_1 = occurrence.parameters[1];
    this.spawnPedestrianBodies(((List<Address>) _get), ((List<Position>) _get_1));
    SimulationStepEvent _simulationStepEvent = new SimulationStepEvent();
    this.wake(_simulationStepEvent);
  }
  
  @Percept
  public void _handle_SimulationStepEvent_2(final SimulationStepEvent occurrence) {
    InputOutput.<String>println("in SimulationStepEvent");
    for (final AgentBody body : this.listAgentBodies) {
      {
        List<Position> listNeighbours = new ArrayList<Position>();
        Position _position = body.getPosition();
        PerceptionReceivedEvent _perceptionReceivedEvent = new PerceptionReceivedEvent(this.listObstacles, _position, listNeighbours);
        Address _pedestrianAddress = body.getPedestrianAddress();
        Scope<Address> _addresses = Scopes.addresses(_pedestrianAddress);
        this.emit(_perceptionReceivedEvent, _addresses);
      }
    }
  }
  
  @Percept
  public void _handle_EndOfStepEvent_3(final EndOfStepEvent occurrence) {
    InputOutput.<String>println("in EndOfStepEvent");
  }
  
  @Percept
  public void _handle_InfuenceReceivedEvent_4(final InfuenceReceivedEvent occurrence) {
    InputOutput.<String>println("in InfuenceReceivedEvent");
  }
  
  public void spawnPedestrianBodies(final List<Address> listPedestrianAdresses, final List<Position> listInitialPositions) {
    for (int i = 0; (i < listPedestrianAdresses.size()); i++) {
      Address _get = listPedestrianAdresses.get(i);
      Position _get_1 = listInitialPositions.get(i);
      AgentBody _agentBody = new AgentBody(_get, _get_1);
      this.listAgentBodies.add(_agentBody);
    }
  }
}
