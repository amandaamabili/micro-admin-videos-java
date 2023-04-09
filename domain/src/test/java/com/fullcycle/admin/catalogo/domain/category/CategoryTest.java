package com.fullcycle.admin.catalogo.domain.category;

import com.fullcycle.admin.catalogo.domain.category.Category;
import com.fullcycle.admin.catalogo.domain.exceptions.DomainException;
import com.fullcycle.admin.catalogo.domain.validation.handler.ThrowsValidationHandler;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CategoryTest {
    @Test
    public void givenAValidParams_whenCallNewCategory_thenInstantiateCategory() {

        final var expectedName = "Category name";
        final var expectedDescription = "Category description";
        final boolean expectedIsActive = true;

        final  var actualcategory = Category.newCategory(expectedName, expectedDescription, expectedIsActive);
        Assertions.assertNotNull(actualcategory);
        Assertions.assertNotNull(actualcategory.getId());
        Assertions.assertEquals(expectedName, actualcategory.getName());
        Assertions.assertEquals(expectedDescription, actualcategory.getDescription());
        Assertions.assertEquals(expectedIsActive, actualcategory.isActive());

        Assertions.assertNotNull(actualcategory.getCreatedAt());
        Assertions.assertNotNull(actualcategory.getUpdatedAt());
        Assertions.assertNull(actualcategory.getDeletedAt());




    }
    @Test
    public void givenInvalidParams_whenCallNewCategoryAndValidate_thenShouldReceiveError() {

        final var expectedName = " ";
        final var expectedDescription = "Category description";
        final boolean expectedIsActive = true;
        final var expectedErrorMessage = "'name'should nobe null";
        final var expectedErrorCount = 1;

        final  var actualcategory =
                Category.newCategory(expectedName, expectedDescription, expectedIsActive);

        final var actualException =
                Assertions.assertThrows(DomainException.class, () ->  actualcategory.validate(new ThrowsValidationHandler()));
            //todo DDD As entidades sabem se validar


        Assertions.assertEquals(expectedErrorCount, actualException.getErrors().size());
        Assertions.assertEquals(expectedErrorMessage, actualException.getErrors().get(0).getMessage());


    }
}
