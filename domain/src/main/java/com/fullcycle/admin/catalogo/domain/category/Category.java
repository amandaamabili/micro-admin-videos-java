package com.fullcycle.admin.catalogo.domain.category;

import com.fullcycle.admin.catalogo.domain.AgregateRoot;

import java.time.Instant;
import java.util.UUID;

public class Category extends AgregateRoot<CategoryID> {

    private String name;
    private String description;



    private boolean isActive;

    //Instant is a class that represents a moment in time, voce cria um marco no tempo, sempre UTC
    private Instant createdAt;

    private Instant updatedAt;
    private Instant deletedAt;

    private Category(
            final CategoryID anId,
            final String aName,
            final String aDescription,
            final boolean aIsActive,
            final Instant aCreationDate,
            final Instant aUpdateDate,
            final Instant aDeletedDate) {
        super(anId);
        this.name = aName;
        this.description = aDescription;
        this.isActive = aIsActive;
        this.createdAt = aCreationDate;
        this.updatedAt = aUpdateDate;
        this.deletedAt = aDeletedDate;
    }

    public CategoryID getId() {
        return id;
    }
    public boolean isActive() {
        return isActive;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }

    public Instant getDeletedAt() {
        return deletedAt;
    }

    public static Category newCategory(
            final String aName,
            final String aDescription,
            final boolean aIsActive)
    {
        final var id = CategoryID.unique();
        final var now = Instant.now();
        return new Category(
                id,
                aName,
                aDescription,
                aIsActive,
                now,
                now,
                null);
    }
}
