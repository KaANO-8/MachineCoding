package amazon.catalog

import amazon.product.Product
import amazon.product.ProductCategory

class Catalog: Search {

    private val productNames  = mapOf<String, List<Product>>()
    private val productCategories  = mapOf<String, List<Product>>()

    override fun searchByName(name: String): List<Product> {
        return productNames.getOrDefault(name, listOf())
    }

    override fun searchByCategory(category: ProductCategory): List<Product> {
        return productCategories.getOrDefault(category.name, listOf())
    }
}