package com.example.productcatalogapp

import android.app.Application
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.productcatalogapp.ui.screens.ProductDetailScreen
import com.example.productcatalogapp.ui.screens.ProductListScreen
import com.example.productcatalogapp.ui.theme.ProductCatalogAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ProductCatalogAppTheme {
                AppNavigation()
            }
        }
    }
}

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    val context = LocalContext.current
    val viewModel: ProductViewModel = viewModel(
        factory = ViewModelFactory(context.applicationContext as Application)
    )

    NavHost(navController, startDestination = "products") {
        composable("products") {
            ProductListScreen(viewModel) { productId ->
                viewModel.setSelectedProductId(productId)
                navController.navigate("product/$productId")
            }
        }
        composable("product/{productId}") {
            ProductDetailScreen(viewModel)
        }
    }
}