package fr.utbm.ia54.simulationorca.sarlcapacity;

import io.sarl.lang.core.Capacity;

@SuppressWarnings("all")
public interface ResolveConflictCapacity extends Capacity {
  public abstract void resolveConflict();
}
