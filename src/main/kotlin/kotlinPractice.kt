/**
 * A simple implementation of an integer stack
 */
class IntQueue {

    private var intQueue = mutableListOf<Int>()

    fun add(element: Int) {
        intQueue.add(intQueue.size, element)
    }

    fun remove() = when {
        !isEmpty() -> {
            intQueue.removeAt(0)
        }
        else -> null
    }

    fun peek() = when {
        !isEmpty() -> {
            intQueue[0]
        }
        else -> null
    }

    private fun isEmpty() = intQueue.size == 0
}

class Queue<E> {

    var genericQueue = mutableListOf<E>()

    fun add(element: E) {
        genericQueue.add(genericQueue.size, element)
    }

    private fun remove() = if (isEmpty()) null else genericQueue.removeAt(0)

    private fun peek() = genericQueue.firstOrNull()

    private fun isEmpty() = genericQueue.size == 0

    /**
     * This function weaves two queues together into one single queue
     */

    fun weave(q1: Queue<out E>, q2: Queue<out E>, q3: Queue<Any?>) { //fun weave( q1:Queue<*>, q2:Queue<*>, q3:Queue<*>) -> star-notation since we know nothing about the type; similar to <out E>
        while (true) {
            q1.remove()?.let { q3.add(it) }
            q2.remove()?.let { q3.add(it) }

            if (q1.peek() == null && q2.peek() == null) {
                break
            }
        }
    }
}

/**
 * A simple generic stack implementation
 */

class Stack<E> {
    private val stack = mutableListOf<E>()
    fun push(element: E) {
        stack.add(stack.size, element)
    }

    fun pop() = if (isEmpty()) null else stack.removeAt(stack.size - 1)

    fun peek() = if (isEmpty()) null else stack[stack.size - 1] //stack.lastOrNull()

    fun isEmpty() = stack.size == 0
}

/**
 * This class implements a queue using two stacks instead of a list
 */
class TwoStackQueue<E> {

    private val stack1 = Stack<E>()
    private val stack2 = Stack<E>()

    fun add(element: E) {
        stack2.push(element)
    }

    fun pop(): E? {
        return if (!stack1.isEmpty()) {
            stack1.pop()
        } else {
            while (!stack2.isEmpty()) {
                stack2.pop()?.let { stack1.push(it) }
            }
            stack1.pop()
        }
    }
}


fun main() {
    //some test code here
}



