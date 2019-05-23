package misc.sumzero

/**
 * Generic implementation of a pair
 */

class Pair<T>(first: T, second: T) {
    private val firstValue = first
    private val secondValue = second

    override fun toString(): String {
        return "Pair of $firstValue and $secondValue"
    }
}