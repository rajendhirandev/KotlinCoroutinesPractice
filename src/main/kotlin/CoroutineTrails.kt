import kotlinx.coroutines.*
import java.util.concurrent.TimeUnit

fun main() {
    println("God Knows All, Trust in God")

    runBlocking {
        /*CoroutineScope(Dispatchers.Main).launch {

        }*/
        launch {
            println("First One")
            delay(TimeUnit.SECONDS.toMillis(3))
            println("First Done")
        }

        GlobalScope.launch {
            println("Second One")
            delay(TimeUnit.SECONDS.toMillis(2))
            println("Second Done")
        }

        val x=withTimeoutOrNull(2) {
            println("With started")
            delay(3000)
            println("Err")
        }
        println("X Value: $x")
    }


}
