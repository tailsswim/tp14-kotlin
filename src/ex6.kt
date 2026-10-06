import kotlinx.coroutines.*

fun main() = runBlocking {
    val monJob = Job()
    val monScope = CoroutineScope(Dispatchers.Default + monJob)

    val coroutine1 = monScope.launch {
        try {
            repeat(5) { i ->
                println(i)
                delay(200)
            }
        } catch (e: CancellationException) {
            println(e)
        }
    }

    val coroutine2 = monScope.launch {
        try {
            repeat(5) { i ->
                println(i)
                delay(300)
            }
        } catch (e: CancellationException) {
            println(e)
        }
    }

    delay(500)
    monScope.cancel()
    joinAll(coroutine1, coroutine2)
}
