package fr.utbm.ia54.simulationorca.sarlevent;

import fr.utbm.ia54.simulationorca.environmentmodel.Obstacle;
import fr.utbm.ia54.simulationorca.framework.Position;
import io.sarl.lang.annotation.Generated;
import io.sarl.lang.core.Event;
import java.util.List;

@SuppressWarnings("all")
public class PerceptionReceivedEvent extends Event {
  public List<Obstacle> listObstacles;
  
  public Position bodyPos;
  
  public List<Position> listNeighbours;
  
  public PerceptionReceivedEvent(final List<Obstacle> listObstacles, final Position bodyPos, final List<Position> listNeighbours) {
    this.listObstacles = listObstacles;
    this.bodyPos = bodyPos;
    this.listNeighbours = listNeighbours;
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
    PerceptionReceivedEvent other = (PerceptionReceivedEvent) obj;
    if (this.listObstacles == null) {
      if (other.listObstacles != null)
        return false;
    } else if (!this.listObstacles.equals(other.listObstacles))
      return false;
    if (this.bodyPos == null) {
      if (other.bodyPos != null)
        return false;
    } else if (!this.bodyPos.equals(other.bodyPos))
      return false;
    if (this.listNeighbours == null) {
      if (other.listNeighbours != null)
        return false;
    } else if (!this.listNeighbours.equals(other.listNeighbours))
      return false;
    return true;
  }
  
  @Override
  @Generated
  public int hashCode() {
    final int prime = 31;
    int result = super.hashCode();
    result = prime * result + ((this.listObstacles== null) ? 0 : this.listObstacles.hashCode());
    result = prime * result + ((this.bodyPos== null) ? 0 : this.bodyPos.hashCode());
    result = prime * result + ((this.listNeighbours== null) ? 0 : this.listNeighbours.hashCode());
    return result;
  }
  
  /**
   * Returns a String representation of the PerceptionReceivedEvent event's attributes only.
   */
  @Generated
  protected String attributesToString() {
    StringBuilder result = new StringBuilder(super.attributesToString());
    result.append("listObstacles  = ").append(this.listObstacles);
    result.append("bodyPos  = ").append(this.bodyPos);
    result.append("listNeighbours  = ").append(this.listNeighbours);
    return result.toString();
  }
  
  @Generated
  private final static long serialVersionUID = 1058739404L;
}
