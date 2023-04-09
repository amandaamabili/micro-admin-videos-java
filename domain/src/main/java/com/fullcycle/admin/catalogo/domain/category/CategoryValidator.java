package com.fullcycle.admin.catalogo.domain.category;

import com.fullcycle.admin.catalogo.domain.validation.ValidationHandler;
import com.fullcycle.admin.catalogo.domain.validation.Validator;

public class CategoryValidator extends Validator {

    private final Category category;

    public CategoryValidator(final Category aCategory, final ValidationHandler aHandler) {
        //todo o que é isso? super
        super(aHandler);
        this.category = aCategory;
    }

    @Override
    public void validate() {

        if (this.category.getName() == " ") {
            this.validationHandler().append(new Error("'name'should nobe null"));
        }
    }
}
