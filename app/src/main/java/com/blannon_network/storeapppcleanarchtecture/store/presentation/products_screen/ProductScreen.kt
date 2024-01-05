package com.blannon_network.storeapppcleanarchtecture.store.presentation.products_screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.blannon_network.storeapppcleanarchtecture.store.domain.model.Product
import com.blannon_network.storeapppcleanarchtecture.store.presentation.products_screen.components.ProductCard
import com.blannon_network.storeapppcleanarchtecture.store.presentation.util.components.LoadingDialog
import com.blannon_network.storeapppcleanarchtecture.store.presentation.util.components.Top_Bar

@Composable
internal fun ProductScreen(
    viewModel: ProductViewModel = hiltViewModel()
){
    val state by viewModel.state.collectAsStateWithLifecycle()
    ProductsContent(state = state)
}
@Composable
fun ProductsContent(
    state: ProductViewState
){
    LoadingDialog(isLoading = state.isLoading)
    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        topBar = {
            Top_Bar(title = "Products")
        }
    ) {
        LazyVerticalStaggeredGrid(
            modifier =Modifier
                .padding(top = it.calculateTopPadding()),
            columns = StaggeredGridCells.Fixed(2),
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            verticalItemSpacing = 10.dp)
        {
            items(state.products){ product ->
                ProductCard(product = product)

            }
        }
    }

}