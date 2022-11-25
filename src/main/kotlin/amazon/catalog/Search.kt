package amazon.catalog

import amazon.product.Product
import amazon.product.ProductCategory

interface Search {
    fun searchByName(name: String): List<Product>
    fun searchByCategory(category: ProductCategory): List<Product>
}