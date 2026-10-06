import kotlinx.coroutines.*

fun main() = runBlocking {
    val deferredCalcul = async {
        delay(1000)
        42
    }

    val deferredReseau = async {
        delay(1500)
        100
    }

    val resultatCalcul = deferredCalcul.await()
    val resultatReseau = deferredReseau.await()

    val total = resultatCalcul + resultatReseau
    println(total)
}
