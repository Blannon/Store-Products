package com.blannon_network.storeapppcleanarchtecture.di

import com.blannon_network.storeapppcleanarchtecture.store.data.repository.ProductRepositoryImp
import com.blannon_network.storeapppcleanarchtecture.store.domain.repository.ProductRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton

    abstract  fun bindProductsRepository
                (impl: ProductRepositoryImp): ProductRepository


}