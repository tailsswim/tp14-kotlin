import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    val nombreFlow = (1..10).asFlow()

    nombreFlow
        .filter { it % 2 == 0 }
        .map { it * 10 }
        .take(3)
        .collect { valeur ->
            println(valeur)
        }
}
