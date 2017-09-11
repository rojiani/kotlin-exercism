import Node.*

/**
 * Sealed class representing either a Node with a value and pointers, or a sentinel node with no value.
 */
sealed class Node<T> {

    var prev: Node<T>? = null
    var next: Node<T>? = null

    class ValueNode<T>(var value: T) : Node<T>() {
        override fun toString(): String = "($value)"
    }

    class Sentinel<T> : Node<T>() {
        override fun toString(): String = if (prev == null && next != null) "[H]" else "[T]"
    }
}

/**
 * Deque
 *
 * http://exercism.io/exercises/kotlin/linked-list/readme
 * http://exercism.io/tracks/kotlin/exercises/linked-list
 * http://exercism.io/submissions/d1cf707e7dae4bdda3470ffbcf15103b
 *
 * @author nrojiani
 * @date 9/10/17
 */
class Deque<T> {
    /** Sentinel at front of list */
    private var headSentinel: Node<T> = Sentinel()
    /** Sentinel at back of list */
    private var tailSentinel: Node<T> = Sentinel()

    init {
         clear()
    }

    /** Insert an element at the back of the list */
    fun push(value: T) {
        val oldLast = tailSentinel.prev!!
        when (oldLast) {
            is Sentinel -> unshift(value)
            is ValueNode -> {
                val newLast = ValueNode(value)
                oldLast.next = newLast
                newLast.prev = oldLast
                newLast.next = tailSentinel
                tailSentinel.prev = newLast
            }
        }
    }

    /** Remove an element from the back of the list */
    fun pop(): T? {
        val last = tailSentinel.prev!!
        return when (last) {
            is Sentinel -> null
            is ValueNode -> {
                val penultimate = last.prev!!
                penultimate.next = tailSentinel
                tailSentinel.prev = penultimate

                last.value
            }
        }
    }

    /** Remove the value at the front of the list */
    fun shift(): T? {
        val front: Node<T> = headSentinel.next!!

        return when (front) {
            is Sentinel -> null
            is ValueNode -> {
                val second = front.next
                headSentinel.next = second
                second?.prev = headSentinel

                front.value
            }
        }
    }

    /** Insert an element at the front of the list */
    fun unshift(value: T) {
        val newNode = ValueNode(value)
        val afterHead = headSentinel.next
        headSentinel.next = newNode
        afterHead?.prev = newNode
        newNode.prev = headSentinel
        newNode.next = afterHead
    }

    /** The number of values in the list */
    fun count(): Int {
        var size = 0
        var currentNode = headSentinel.next
        while (currentNode is ValueNode) {
            size++
            currentNode = currentNode.next
        }
        return size
    }

    /** Returns a list of the values in the deque */
    private fun elements(): List<T> {
        val values = mutableListOf<T>()
        var currentNode = headSentinel.next
        while (currentNode is ValueNode) {
            values.add(currentNode.value)
            currentNode = currentNode.next
        }
        return values.toList()
    }

    /** Reset the deque to an empty state */
    fun clear() {
        headSentinel.next = tailSentinel
        tailSentinel.prev = headSentinel
    }

    fun isEmpty(): Boolean = count() == 0

    override fun toString(): String {
        return elements().toString()
    }

}
