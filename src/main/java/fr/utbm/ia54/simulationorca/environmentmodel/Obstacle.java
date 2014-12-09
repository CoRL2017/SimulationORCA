package fr.utbm.ia54.simulationorca.environmentmodel;

import java.util.ArrayList;
import java.util.List;

import fr.utbm.ia54.simulationorca.framework.Segment;
import fr.utbm.ia54.simulationorca.framework.Vector;

public final class Obstacle {

	private List<Segment> segments;

	public Obstacle(List<Segment> l) {
		this.segments = l;
	}

	public Obstacle() {
		segments = new ArrayList<Segment>();
	}

	public void addSegment(Segment v) {
		segments.add(v);
	}

	public void removeSegment(Segment v) {
		segments.remove(v);
	}

	public Segment next(Segment v) {
		int index = segments.indexOf(v);

		if (index + 1 < segments.size()) {
			return segments.get(index + 1);
		} else {
			return segments.get(0);
		}
	}

	public Segment previous(Segment v) {
		int index = segments.indexOf(v);

		if (index - 1 > 0) {
			return segments.get(index - 1);
		} else {
			return segments.get(segments.size() - 1);
		}
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
						.get(i).getPoint().getX(), segments.get(i).getPoint()
						.getY(), segments.get(i + 1).getPoint().getX(),
						segments.get(i + 1).getPoint().getY());
				ratio = clamp(ratio, 0f, 1f);
				float vx = ratio
						* (segments.get(i + 1).getPoint().getX() - segments
								.get(i).getPoint().getX());
				float vy = ratio
						* (segments.get(i + 1).getPoint().getY() - segments
								.get(i).getPoint().getY());
				distTemp = Math.abs(segments.get(i).getPoint().getX() + vx
						- p.getX())
						+ Math.abs(segments.get(i).getPoint().getY() + vy
								- p.getY());
			} else {
				float ratio = projectsPointOnLine(p.getX(), p.getY(), segments
						.get(i).getPoint().getX(), segments.get(i).getPoint()
						.getY(), segments.get(0).getPoint().getX(), segments
						.get(0).getPoint().getY());
				ratio = clamp(ratio, 0f, 1f);
				float vx = ratio
						* (segments.get(0).getPoint().getX() - segments.get(i)
								.getPoint().getX());
				float vy = ratio
						* (segments.get(0).getPoint().getY() - segments.get(i)
								.getPoint().getY());
				distTemp = Math.abs(segments.get(i).getPoint().getX() + vx
						- p.getX())
						+ Math.abs(segments.get(i).getPoint().getY() + vy
								- p.getY());
			}

			if (distTemp < dist) {
				dist = distTemp;
			}
		}
		return dist;
	}

	public List<Segment> getSegments() {
		return segments;
	}

	public void setSegments(List<Segment> segments) {
		this.segments = segments;
	}

}
