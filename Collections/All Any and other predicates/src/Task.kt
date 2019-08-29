import java.util.function.Predicate

// Return true if all customers are from the given city
fun Shop.checkAllCustomersAreFrom(city: City): Boolean = this.customers.all { matcher(it, city) }

// Return true if there is at least one customer from the given city
fun Shop.hasCustomerFrom(city: City): Boolean = this.customers.any { matcher(it, city) }

// Return the number of customers from the given city
fun Shop.countCustomersFrom(city: City): Int = this.customers.count { matcher(it, city) }

// Return a customer who lives in the given city, or null if there is none
fun Shop.findAnyCustomerFrom(city: City): Customer? = this.customers.firstOrNull{ matcher(it, city) }

val matcher: (Customer, City) -> Boolean = {customer, city -> customer.city == city  }
