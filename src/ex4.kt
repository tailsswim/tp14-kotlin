import kotlinx.coroutines.*

fun main() = runBlocking {
    val job1 = launch {
        delay(2000)
    }

    val job2 = launch {
        delay(1000)
    }

    println(job1.isActive)

    job2.cancel()
    println(job2.isCancelled)

    job1.join()
    println(job1.isCompleted)
}
