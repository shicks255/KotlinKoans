class LazyProperty(val initializer: () -> Int) {
    val lazyValue: Int by lazy {
        val i = initializer()
        i
    }
}

