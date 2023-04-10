package com.fullcycle.admin.catalogo.domain;

//Todo study this class and its usage
public class AgregateRoot< ID extends Identifier> extends Entity< ID> {

    protected AgregateRoot(final ID id) {
        super(id);
    }
}

