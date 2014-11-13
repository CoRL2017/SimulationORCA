package fr.utbm.ia54.simulationorca.sarlagent;

import fr.utbm.ia54.simulationorca.framework.Position;
import fr.utbm.ia54.simulationorca.sarlagent.Environment;
import fr.utbm.ia54.simulationorca.sarlagent.Pedestrian;
import io.sarl.core.Initialize;
import io.sarl.lang.annotation.Generated;
import io.sarl.lang.core.Address;
import io.sarl.lang.core.Agent;
import io.sarl.lang.core.AgentContext;
import io.sarl.lang.core.Event;
import io.sarl.lang.core.EventSpace;
import io.sarl.lang.core.Percept;
import io.sarl.lang.core.Scope;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;

@SuppressWarnings("all")
public class Kernel extends Agent {
  /**
   * Construct an agent.
   * @param parentID - identifier of the parent. It is the identifier of the parent agent and the enclosing contect, at the same time.
   */
  @Generated
  public Kernel(final UUID parentID) {
    super(parentID, null);
  }
  
  /**
   * Construct an agent.
   * @param parentID - identifier of the parent. It is the identifier of the parent agent and the enclosing contect, at the same time.
   * @param agentID - identifier of the agent. If <code>null</code> the agent identifier will be computed randomly.
   */
  @Generated
  public Kernel(final UUID parentID, final UUID agentID) {
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
  
  @Percept
  public void _handle_Initialize_1(final Initialize occurrence) {
    List<Position> listPositionInitPedestrian = new ArrayList<Position>();
    List<Position> listPositionFinalPedestrian = new ArrayList<Position>();
    Position _position = new Position(1, 1);
    listPositionInitPedestrian.add(_position);
    Position _position_1 = new Position(5, 5);
    listPositionFinalPedestrian.add(_position_1);
    List<Address> listPedestrianAddresses = this.spawnPedestrians(listPositionInitPedestrian, listPositionFinalPedestrian);
    this.spawn(Environment.class, new Object[] { listPedestrianAddresses, listPositionInitPedestrian });
    this.killMe();
  }
  
  public List<Address> spawnPedestrians(final List<Position> listInitialPedestrianPositions, final List<Position> listFinalPedestrianPositions) {
    List<Address> listPedestrianAddresses = new ArrayList<Address>();
    for (int i = 0; (i < listInitialPedestrianPositions.size()); i++) {
      {
        Position _get = listInitialPedestrianPositions.get(i);
        Position _get_1 = listFinalPedestrianPositions.get(i);
        List<Position> params = Collections.<Position>unmodifiableList(CollectionLiterals.<Position>newArrayList(_get, _get_1));
        UUID id = this.spawn(Pedestrian.class, params);
        EventSpace _defaultSpace = this.getDefaultSpace();
        Address _address = _defaultSpace.getAddress(id);
        listPedestrianAddresses.add(_address);
      }
    }
    return listPedestrianAddresses;
  }
}
