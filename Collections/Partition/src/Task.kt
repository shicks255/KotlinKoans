// Return customers who have more undelivered orders than delivered
fun Shop.getCustomersWithMoreUndeliveredOrdersThanDelivered(): Set<Customer>
        = this.customers.partition { it.orders.count { it.isDelivered } < it.orders.count { !it.isDelivered }}
        .first
        .toSet()