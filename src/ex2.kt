import kotlinx.coroutines.*

fun main() = runBlocking {

    val jobCalcul = launch(Dispatchers.Default) {
        delay(1000)

        var total = 0
        for (i in 1..100000) {
            total += i
        }

        println("Calcul terminé : $total")
    }

    val jobIO = launch(Dispatchers.IO) {
        delay(1200)
        println("IO terminé")
    }

    val jobMain = launch(Dispatchers.Default) {
        delay(100)
        println("Main non disponible")
    }

    jobCalcul.join()
    jobIO.join()
    jobMain.join()

    println("Tous les jobs sont terminés")
}
