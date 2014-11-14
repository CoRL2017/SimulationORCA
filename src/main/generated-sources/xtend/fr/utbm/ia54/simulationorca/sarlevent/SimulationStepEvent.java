package fr.utbm.ia54.simulationorca.sarlevent;

import io.sarl.lang.annotation.Generated;
import io.sarl.lang.core.Address;
import io.sarl.lang.core.Event;

@SuppressWarnings("all")
public class SimulationStepEvent extends Event {
  /**
   * Construct an event. The source of the event is unknown.
   */
  @Generated
  public SimulationStepEvent() {
    super();
  }
  
  /**
   * Construct an event.
   * @param source - address of the agent that is emitting this event.
   */
  @Generated
  public SimulationStepEvent(final Address source) {
    super(source);
  }
  
  @Generated
  private final static long serialVersionUID = 588368462L;
}
