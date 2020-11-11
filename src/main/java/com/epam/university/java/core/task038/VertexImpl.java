package com.epam.university.java.core.task038;

import java.util.Objects;

public class VertexImpl implements Vertex {

    private int id;
    private int x;
    private int y;

    /**
     * Constructor for Vertex instance.
     *
     * @param id - id of the Vertex
     * @param x  - coordinate on x axis
     * @param y  - coordinate on y axis
     */
    public VertexImpl(int id, int x, int y) {
        this.id = id;
        this.x = x;
        this.y = y;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        VertexImpl vertex = (VertexImpl) o;
        return id == vertex.getId()
                && x == vertex.getX()
                && y == vertex.getY();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getX(), getY());
    }
}
