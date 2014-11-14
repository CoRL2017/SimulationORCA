package fr.utbm.ia54.simulationorca.sarlevent;

import fr.utbm.ia54.simulationorca.framework.Position;
import io.sarl.lang.annotation.Generated;
import io.sarl.lang.core.Event;

@SuppressWarnings("all")
public class InfuenceReceivedEvent extends Event {
  public Position bodyPos;
  
  public InfuenceReceivedEvent(final Position bodyPos) {
    this.bodyPos = bodyPos;
  }
  
  @Override
  @Generated
  public boolean equals(final Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    if (!super.equals(obj))
      return false;
    InfuenceReceivedEvent other = (InfuenceReceivedEvent) obj;
    if (this.bodyPos == null) {
      if (other.bodyPos != null)
        return false;
    } else if (!this.bodyPos.equals(other.bodyPos))
      return false;
    return true;
  }
  
  @Override
  @Generated
  public int hashCode() {
    final int prime = 31;
    int result = super.hashCode();
    result = prime * result + ((this.bodyPos== null) ? 0 : this.bodyPos.hashCode());
    return result;
  }
  
  /**
   * Returns a String representation of the InfuenceReceivedEvent event's attributes only.
   */
  @Generated
  protected String attributesToString() {
    StringBuilder result = new StringBuilder(super.attributesToString());
    result.append("bodyPos  = ").append(this.bodyPos);
    return result.toString();
  }
  
  @Generated
  private final static long serialVersionUID = 370729528L;
}
