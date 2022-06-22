import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking

/*suspend fun sample(): List<Int> {
    delay(1000)
    return listOf(1, 2, 3, 4, 5)
}

fun main() = runBlocking<Unit> {
    sample().forEach { value -> println(value) }
}*/

fun main() = runBlocking<Unit> {
    var ct = 1
    val fl = flow {
        while (ct<10) {
            delay(800)
            emit("$ct")
            ct++
        }
    }

   /* fl.collectLatest {
        println(it)
    }*/

    println(flowOf("tes","test31","2testing").fold("") { a, b -> "${a} + ${b}" })
    flowOf("tes","tes","2testing").filter {
        it == "tes"
    }.collectLatest {
        println(it)
    }
}


/*
fun main() {
    runBlocking {
        val table1 = Orders("NutsTbl")
        val table2 = Orders("FruitsTbl")
*/
/*
        launch {
            table2.deliverOrders(Flavours.NUTS_CREAM)
            table1.deliverOrders(Flavours.COOKIES_CREAM)
        }*//*


       */
/* val request = launch {
            // it spawns two other jobs
            launch(Job()) {
                println("job1: I run in my own Job and execute independently!")
                delay(1000)
                println("job1: I am not affected by cancellation of the request")
            }
            // and the other inherits the parent context
            launch() {
                delay(100)
                println("job2: I am a child of the request coroutine")
                delay(1000)
                 println("job2: I will not execute this line if my parent request is cancelled")
            }
        }
        delay(500)
        request.cancel() // cancel processing of the request
        println("main: Who has survived request cancellation?")
        delay(1000)*//*

    }
}

class Orders(val tableName: String) {

    suspend fun deliverOrders(flavorType: Flavours) {
        val item = PrepareIceCream().prepareNProvide(flavorType)
        println("$tableName is delivered with ${item.flavorType}")
    }
}

data class IceCream(val flavorType: Flavours)
class PrepareIceCream {
    suspend fun prepareNProvide(flavorType: Flavours): IceCream {
        println("Preparation Started... ")
        delay(flavorType.readyDelay)
        return IceCream(flavorType)
    }
}


enum class Flavours(val readyDelay: Long) {
    VANILLA(3000L),
    CHOCOLATE(5000L),
    COOKIES_CREAM(1000L),
    NUTS_CREAM(7000L);
}*/
