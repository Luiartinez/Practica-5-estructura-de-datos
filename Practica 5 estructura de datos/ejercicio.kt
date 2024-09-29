class Node<T>(val value: T, var next: Node<T>? = null)

class Queue<T> {
    private var front: Node<T>? = null
    private var rear: Node<T>? = null
    private var size = 0

    fun enqueue(value: T) {
        val newNode = Node(value)
        if (rear != null) {
            rear?.next = newNode
        }
        rear = newNode
        if (front == null) {
            front = rear
        }
        size++
    }
        
    fun dequeue(): T? {
        if (isEmpty()) {
            println("Queue is empty.")
            return null
        }
        val dequeuedValue = front?.value
        front = front?.next
        if (front == null) {
            rear = null
        }
        size--
        return dequeuedValue
    }

    fun peek(): T? {
        return front?.value
    }

    fun isEmpty(): Boolean {
        return front == null
    }
    
    fun size(): Int {
        return size
    }
    
    override fun toString(): String {
        if (isEmpty()) return "[]"
        val result = StringBuilder("[")
        var current = front
        while (current != null) {
            result.append(current.value)
            if (current.next != null) {
                result.append(", ")
            }
            current = current.next
        }
        result.append("]")
        return result.toString()
    }
}

fun main() {
    val bancoQueue = Queue<Int>()

    for (i in 1..10) {  // Cambié '...' por '..' para el rango correcto
        bancoQueue.enqueue(i)
    }

    println("Turnos de clientes: $bancoQueue")

    for (i in 1..8) {  // Cambié '...' por '..' para el rango correcto
        println("Atendiendo al cliente: ${bancoQueue.dequeue()}")
    }

    println("Clientes restantes: ${bancoQueue.size()}")

    println("\n:: Ejercicio2 ")
    val tareaQueue = Queue<String>()

    tareaQueue.enqueue("limpiar")
    tareaQueue.enqueue("cocinar")
    tareaQueue.enqueue("estudiar")
    tareaQueue.enqueue("jugar")
    tareaQueue.enqueue("leer")

    println("Tareas pendientes: $tareaQueue")

    while (!tareaQueue.isEmpty()) {  // Cambié la condición para que sea correcta
        println("Se está realizando la tarea de: ${tareaQueue.dequeue()}")
    }
}
