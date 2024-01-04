package com.blannon_network.storeapppcleanarchtecture.store.data.remote

import com.blannon_network.storeapppcleanarchtecture.store.domain.model.Product
import retrofit2.http.GET

interface ProductApi {

    @GET("products")

    suspend fun getProducts():List<Product>
}