import kotlinx.coroutines.*

fun main() = runBlocking {
    val globalJob = launch {
        delay(2000)
    }

    }

    val customScope = CoroutineScope(Dispatchers.Default + Job())

    val jobTraitement = customScope.launch {
        try {
            delay(1500)
        } catch (e: CancellationException) {
            println("Annulé")
        }
    }

    delay(500)
    customScope.cancel()
    globalJob.join()
}
