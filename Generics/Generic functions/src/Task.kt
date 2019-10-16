import java.util.*

fun <T, C: MutableCollection<T>> Collection<T>.partitionTo(t: C, r: C, f: (s: T) -> Boolean): Pair<Collection<T>, Collection<T>> {

    for (i in this)
        if (f(i))
            t.add(i)
        else
            r.add(i)

    return Pair(t,r)
}

fun partitionWordsAndLines() {
    val (words, lines) = listOf("a", "a b", "c", "d e").
            partitionTo(ArrayList<String>(), ArrayList<String>()) { s: String -> !s.contains(" ") }
    words == listOf("a", "c")
    lines == listOf("a b", "d e")
}

fun partitionLettersAndOtherSymbols() {
    val (letters, other) = setOf('a', '%', 'r', '}').
            partitionTo(HashSet<Char>(), HashSet<Char>()) { c -> c in 'a'..'z' || c in 'A'..'Z'}
    letters == setOf('a', 'r')
    other == setOf('%', '}')
}
