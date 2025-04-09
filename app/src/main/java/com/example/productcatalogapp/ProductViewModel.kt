package com.example.productcatalogapp

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ProductViewModel(
    private val repo: ProductRepo,
    application: Application
) : AndroidViewModel(application) {
    private val _products = MutableStateFlow<List<Product>>(emptyList())
    val products = _products.asStateFlow()

    private val _selectedProduct = MutableStateFlow<Product?>(null)
    val selectedProduct = _selectedProduct.asStateFlow()

    private val _isLoading = MutableStateFlow(false)
    val isLoading = _isLoading.asStateFlow()

    private val _error = MutableStateFlow<String?>(null)
    val error = _error.asStateFlow()

    init {
        loadProducts()
    }

    fun loadProducts() {
        viewModelScope.launch {
            _isLoading.value = true
            try {
                _products.value = repo.getProducts()
            } catch (e: Exception) {
                _error.value = "Failed to load products: ${e.message}"
            } finally {
                _isLoading.value = false
            }
        }
    }

    fun setSelectedProductId(id: Int) {
        viewModelScope.launch {
            _isLoading.value = true
            try {
                _selectedProduct.value = repo.getProduct(id)
            } catch (e: Exception) {
                _error.value = "Failed to load product: ${e.message}"
            } finally {
                _isLoading.value = false
            }
        }
    }
}