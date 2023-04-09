package com.fullcycle.admin.catalogo.domain.category;

import com.fullcycle.admin.catalogo.domain.validation.ValidationHandler;
import com.fullcycle.admin.catalogo.domain.validation.Validator;

import java.util.Objects;

public class CategoryValidator extends Validator {

    private final Category category;

    public CategoryValidator(final Category aCategory, final ValidationHandler aHandler) {
        //todo o que é isso? super
        super(aHandler);
        this.category = aCategory;
    }

    @Override
    public void validate() {

        if (Objects.equals(this.category.getName(), " ") || this.category.getName() == null ) {
            this.validationHandler().append(new Error("'name'should nobe null"));
        }
    }
}
