package org.leadpony.justify.examples.yasson;

/**
 * A color with alpha component.
 */
public class Color {
    public int r;
    public int g;
    public int b;
    public int a;

    @Override
    public String toString() {
        return new StringBuilder()
                .append("{")
                .append(r).append(", ")
                .append(g).append(", ")
                .append(b).append(", ")
                .append(a)
                .append("}")
                .toString();
    }
}
