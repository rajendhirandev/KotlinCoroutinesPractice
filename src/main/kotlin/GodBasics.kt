import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() {
    println("God Knows All, Trust in god")
    runBlocking {
        launch {
            println("God Coroutine")
            delay(2000)
            println("Done")
        }
    }
}