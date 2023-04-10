package com.fullcycle.admin.catalogo.domain;

import com.fullcycle.admin.catalogo.domain.validation.ValidationHandler;

import javax.xml.validation.ValidatorHandler;
import java.util.Objects;

public class Entity<ID extends Identifier> {
    protected final ID id;

    public Entity(final ID id) {
        Objects.requireNonNull(id, "id cannot be null");
        this.id = id;
    }

    public ID getId() {
        return id;
    }

    //generate via wizard

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Entity<?> entity = (Entity<?>) o;
        return getId().equals(entity.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    public  void validate(ValidationHandler handler) {
        //todo DDD As entidades sabem se validar
    }
}
