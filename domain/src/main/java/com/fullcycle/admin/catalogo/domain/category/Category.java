package com.fullcycle.admin.catalogo.domain.category;

import com.fullcycle.admin.catalogo.domain.AgregateRoot;
import com.fullcycle.admin.catalogo.domain.validation.ValidationHandler;

import java.time.Instant;
import java.util.UUID;

//TODO Convertido Categoria em uma classe agregada usando o DDD

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

    @Override
    public void validate(final ValidationHandler handler) {

        //todo a validação da categoria, a categoria sabe se validar chamando o validador,
        // o validador sabe se validar chamando o handler e o handler sabe se validar chamando o validador

        new CategoryValidator(this, handler).validate();
    }
}
