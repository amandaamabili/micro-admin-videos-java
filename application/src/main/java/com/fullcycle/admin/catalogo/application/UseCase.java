package com.fullcycle.admin.catalogo.application;


import com.fullcycle.admin.catalogo.domain.category.Category;

import static com.fullcycle.admin.catalogo.domain.category.Category.newCategory;

public class UseCase {
    public Category execute() {

        return newCategory();
    }

    private Category newCategory() {
     return null;
    }
}