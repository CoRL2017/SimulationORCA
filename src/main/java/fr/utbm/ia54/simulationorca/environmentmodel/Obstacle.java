package fr.utbm.ia54.simulationorca.environmentmodel;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import fr.utbm.ia54.simulationorca.framework.Vector;

public final class Obstacle {

	private List<Vector> segments;

	public Obstacle(List<Vector> l) {
		this.segments = l;
	}

	public Obstacle() {
		segments = new ArrayList<Vector>();
	}

	public void addSegment(Vector v) {
		segments.add(v);
	}

	public void removeSegment(Vector v) {
		segments.remove(v);
	}

	public Vector next(Vector v) {
		ListIterator<Vector> it = segments.listIterator();

		while (!it.equals(v)) {
			it.next();
		}

		if (it.nextIndex() < segments.size()) {
			return it.next();
		} else {
			return segments.get(0);
		}
	}

	public Vector previous(Vector v) {
		ListIterator<Vector> it = segments.listIterator();

		while (!it.equals(v)) {
			it.next();
		}

		if (it.previousIndex() > -1) {
			return it.previous();
		} else {
			return segments.get(segments.size() - 1);
		}
	}

	public boolean isConvex(int i) {
		// TODO is convex
		return true;
	}

	public boolean isConvex(Vector seg) {
		// TODO is convex
		return true;
	}

	private static float projectsPointOnLine(float px, float py, float s1x,
			float s1y, float s2x, float s2y) {
		float r_numerator = (px - s1x) * (s2x - s1x) + (py - s1y) * (s2y - s1y);
		float r_denomenator = (s2x - s1x) * (s2x - s1x) + (s2y - s1y)
				* (s2y - s1y);
		return r_numerator / r_denomenator;
	}

	private static float clamp(float v, float min, float max) {
		if (min < max) {
			if (v < min)
				return min;
			if (v > max)
				return max;
		} else {
			if (v > min)
				return min;
			if (v < max)
				return max;
		}
		return v;
	}

	public float distanceTo(Vector p) {
		float dist = 1000;
		float distTemp = 0;
		for (int i = 0; i < segments.size(); i++) {
			if (i < segments.size() - 1) {
				float ratio = projectsPointOnLine(p.getX(), p.getY(), segments
						.get(i).getX(), segments.get(i).getY(),
						segments.get(i + 1).getX(), segments.get(i + 1).getY());
				ratio = clamp(ratio, 0f, 1f);
				float vx = ratio
						* (segments.get(i + 1).getX() - segments.get(i).getX());
				float vy = ratio
						* (segments.get(i + 1).getY() - segments.get(i).getY());
				distTemp = Math.abs(segments.get(i).getX() + vx - p.getX())
						+ Math.abs(segments.get(i).getY() + vy - p.getY());
			} else {
				float ratio = projectsPointOnLine(p.getX(), p.getY(), segments
						.get(i).getX(), segments.get(i).getY(), segments.get(0)
						.getX(), segments.get(0).getY());
				ratio = clamp(ratio, 0f, 1f);
				float vx = ratio
						* (segments.get(0).getX() - segments.get(i).getX());
				float vy = ratio
						* (segments.get(0).getY() - segments.get(i).getY());
				distTemp = Math.abs(segments.get(i).getX() + vx - p.getX())
						+ Math.abs(segments.get(i).getY() + vy - p.getY());
			}

			if (distTemp < dist) {
				dist = distTemp;
			}
		}
		return dist;
	}

	public List<Vector> getSegments() {
		return segments;
	}

	public void setSegments(List<Vector> segments) {
		this.segments = segments;
	}

}
