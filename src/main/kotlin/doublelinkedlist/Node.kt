package doublelinkedlist

data class Node<T>(var precursor: Node<T>?, var follower: Node<T>?, var value: T) {
    override fun toString(): String {
        return "I´m node $value, my precursor is ${precursor?.value} and my follower is ${follower?.value}"
    }
}