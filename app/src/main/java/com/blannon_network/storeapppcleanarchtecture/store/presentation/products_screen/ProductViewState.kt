package com.blannon_network.storeapppcleanarchtecture.store.presentation.products_screen

import com.blannon_network.storeapppcleanarchtecture.store.domain.model.Product

data class ProductViewState (
    val isLoading: Boolean = false,
    val  products: List<Product> = emptyList(),
    val error: String? = null
)