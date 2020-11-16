package com.epam.university.java.core.task041;

import java.util.Objects;

public class EntityImpl implements Entity {

    private int id;
    private String value;

    public EntityImpl(int id, String value) {
        this.id = id;
        this.value = value;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getValue() {
        return value;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        EntityImpl entity = (EntityImpl) o;
        return id == entity.id
                && Objects.equals(getValue(), entity.getValue());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getValue());
    }
}
