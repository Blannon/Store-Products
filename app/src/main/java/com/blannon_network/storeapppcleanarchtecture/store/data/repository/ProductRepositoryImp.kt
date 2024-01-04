package com.blannon_network.storeapppcleanarchtecture.store.data.repository

import arrow.core.Either
import com.blannon_network.storeapppcleanarchtecture.store.data.mapper.toNetworkError
import com.blannon_network.storeapppcleanarchtecture.store.data.remote.ProductApi
import com.blannon_network.storeapppcleanarchtecture.store.domain.model.NetworkError
import com.blannon_network.storeapppcleanarchtecture.store.domain.model.Product
import com.blannon_network.storeapppcleanarchtecture.store.domain.repository.ProductRepository

class ProductRepositoryImp constructor(
    private val productApi: ProductApi
):ProductRepository {

    override suspend fun getProducts(): Either<NetworkError, List<Product>> {
        return Either.catch {
            productApi.getProducts()
        }.mapLeft {it.toNetworkError()  }
    }
}