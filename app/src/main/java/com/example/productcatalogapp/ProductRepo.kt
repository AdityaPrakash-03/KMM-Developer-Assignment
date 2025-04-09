package com.example.productcatalogapp

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

class ProductRepo(private val client: HttpClient) {
    suspend fun getProducts(): List<Product> {
        return try {
            println("Attempting to fetch products...")
            val response = client.get("https://dummyjson.com/products") {
                url { parameters.append("limit", "100") }
            }.body<ProductsResponse>()
            println("Successfully fetched ${response.products.size} products")
            response.products
        } catch (e: Exception) {
            println("Error fetching products: ${e.message}")
            e.printStackTrace()
            emptyList()
        }
    }

    suspend fun getProduct(id: Int): Product? {
        return try {
            client.get("https://dummyjson.com/products/$id").body<Product>()
        } catch (e: Exception) {
            null
        }
    }
}

data class ProductsResponse(
    val products: List<Product>,
    val total: Int,
    val skip: Int,
    val limit: Int
)