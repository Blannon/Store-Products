package com.blannon_network.storeapppcleanarchtecture.store.domain.repository

import arrow.core.Either
import com.blannon_network.storeapppcleanarchtecture.store.domain.model.NetworkError
import com.blannon_network.storeapppcleanarchtecture.store.domain.model.Product

interface ProductRepository {

    suspend fun getProducts(): Either<NetworkError,List<Product>>
}