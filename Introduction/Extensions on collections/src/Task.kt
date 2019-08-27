import java.util.*

fun getList(): List<Int> {
    return arrayListOf(1, 5, 2).sortedDescending()
}

fun List<Int>.sortedDescending(): List<Int> {
    Collections.sort(this, {x,y -> y.compareTo(x)})
    return this
}