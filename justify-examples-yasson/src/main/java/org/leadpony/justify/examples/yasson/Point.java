package org.leadpony.justify.examples.yasson;

import java.util.ArrayList;
import java.util.List;

/**
 * Point class which will be unmarshalled from JSON.
 */
public class Point {

    private Color color = new Color();
    private List<Integer> point = new ArrayList<>();

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public List<Integer> getPoint() {
        return point;
    }

    public void setPoint(List<Integer> point) {
        this.point = point;
    }

    @Override
    public String toString() {
        StringBuilder b = new StringBuilder();
        b.append("color = ").append(color.toString()).append('\n');
        b.append("point = ").append(point).append('\n');
        return b.toString();
    }
}
