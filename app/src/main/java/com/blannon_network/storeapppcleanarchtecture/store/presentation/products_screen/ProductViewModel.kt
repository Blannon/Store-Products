package com.blannon_network.storeapppcleanarchtecture.store.presentation.products_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.blannon_network.storeapppcleanarchtecture.store.domain.repository.ProductRepository
import com.blannon_network.storeapppcleanarchtecture.store.presentation.util.sendEvent
import com.blannon_network.storeapppcleanarchtecture.util.Event
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductViewModel @Inject constructor(
    private val productsRepository: ProductRepository
)
:ViewModel() {

    private val _state = MutableStateFlow(ProductViewState())
    val state = _state.asStateFlow()
    fun getProducts(){
        viewModelScope.launch {
            _state.update {
                it.copy(isLoading = true)
            }
            productsRepository.getProducts()
                .onRight { products ->
                    _state.update {
                        it.copy(products = products)
                    }
                }.onLeft { error ->
                    _state.update {
                        it.copy(
                            error = error.error.message
                        )
                    }
                    sendEvent(Event.Toast(error.error.message))
                }

            _state.update {
                it.copy(isLoading = false)
            }
        }
    }
}