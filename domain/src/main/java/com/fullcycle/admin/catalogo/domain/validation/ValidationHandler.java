package com.fullcycle.admin.catalogo.domain.validation;

import java.util.List;

public interface ValidationHandler {

    ValidationHandler append(Error anError);
    ValidationHandler append(ValidationHandler anHandler);
    <T> T validate(Validation<T> aValidation);
    default boolean hasErrors(){
        return getErrors() != null && getErrors().size() == 0;
    }

    List<Error> getErrors();
     interface Validation<T> {
        T validate();
    }
}
