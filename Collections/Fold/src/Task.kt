// Return the set of products that were ordered by every customer
fun Shop.getSetOfProductsOrderedByEveryCustomer(): Set<Product> {
    val products = this.customers.flatMap { it.orders }.flatMap { it.products }

    val map = this.customers.associate {it to it.orders.flatMap { it.products } }

    return products.filter { map.all { (k,v) -> v.contains(it) } }.toSet()
}
