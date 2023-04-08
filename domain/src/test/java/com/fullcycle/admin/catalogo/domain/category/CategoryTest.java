package com.fullcycle.admin.catalogo.domain.category;

import com.fullcycle.admin.catalogo.domain.category.Category;
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
}
