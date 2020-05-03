import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

fun main() = runBlocking {
    /* println("\n\n God Knows All, Trust in God")
     processing()
     println("Processing Done")

     val thread = Thread(Runnable {
         println("Trust me")
     })
     thread.start()

     Thread {
         println("Sure gonna trust you...")
     }.start()*/

    /*thread(start = true) {
        println("Testing thread")
    }*/


    /*runBlocking {
        launch {
            println("God Knows All, Trust in god")
            delay(2000)
            println("Done")
        }
    }*/

    /* println("Hello world")
     val jobs=GlobalScope.launch {
         processMe()
     }
     println("Welcome")
     jobs.join()*/
    /*GlobalScope.launch {
        processMe()
    }
    println("Thanks for coming to coroutine world")*/
    /*while (true) {
    }*/
    //delay(1000)
    // println("Waiting done")

    //--- Job cancellation after a wait for 1000 ms
    /*println("Hello universe")
    val jobs = GlobalScope.launch {
        processMe()
    }
    println("Waiting...")
    delay(1000)
    jobs.cancel()*/

    /* GlobalScope.launch {
         if (isActive) {
             println("Test 1")
             println("Test 12")
         }
     }
     println("Testing")*/
    //delay(1000)

    //-- Job Cancellation
    /*Job Cancellation (Operations will get cancelled while using isActive check
     else Job status will be cancelled but operations will be running).*/

    /*println("Hello friends")
    val jobs=GlobalScope.launch {
        var nextPrintTms = System.currentTimeMillis()
        var indexValue = 1
        while (isActive) {   //  while (true) {
            if (System.currentTimeMillis() >= nextPrintTms) {
                println("Take ${indexValue++}")
                nextPrintTms += 300L
            }
        }
    }
    println("Attention....")
    delay(1200)
    jobs.cancel()
    println("Job Cancelled")
    delay(1500)
    println("Closed")*/

    //val jobs = Job()
    /* val coroutineDispatcher = Dispatchers.Default

     val jobs = launch() {
         println("inside J")
         delay(TimeUnit.SECONDS.toMillis(2))
         println("Done J")
     }
     println("Cancellation")
     delay(1000)
     jobs.join()*/
    //job.cancel()

    /*launch(Dispatchers.IO) {
        println("Tester - ${Thread.currentThread().name}")
    }
    launch(Dispatchers.IO) {
        println("Tester - ${Thread.currentThread().name}")
    }
    println("Testing Thread")*/


    //- with timeout
    /*  val timeout: Long = 3000
      try {
          withTimeout(timeout) {
              processMe()
          }
      } catch (e: Exception) {
          println("Time exceeds $timeout ms")
          println("Timeout")
      }
      println("Main Done")*/

    //-- Without Async -- Sequential
    /*val timeSpent = measureTimeMillis {
        val aVal = aValue()
        val bVal = bValue()
        println("Output : ${aVal + bVal}")
    }
    println("Time Spent : $timeSpent")*/

    //-- With Async  -- Concurrent
    val timeSpent = measureTimeMillis {
        val aVal = async(Dispatchers.IO) { aValue() }
        val bVal = async { bValue() }
        println("Output : ${aVal.await() + bVal.await()}")
    }
    println("Time Spent : $timeSpent")


    //-- With Async with lazy  -- Concurrent
    /*val timeSpent = measureTimeMillis {
        val aVal = async(start = CoroutineStart.LAZY) { aValue() }
        val bVal = async(start = CoroutineStart.LAZY) { bValue() }
        println("Output : ${aVal.await() + bVal.await()}")
    }
    println("Time Spent : $timeSpent")*/
}

suspend fun aValue(): Int {
    delay(1000)
    return 20
}

suspend fun bValue(): Int {
    delay(1300)
    return 30
}

suspend fun processing() {
    Thread.sleep(5000)
    println("Processed")
}

suspend fun processMe() {
    println("Processing....")
    delay(2000)
    println("Process Done")
}

suspend fun calculateMyAmt(amt: Int): Int {
    delay(1000)
    return amt * 5
}

fun checkMyCalc() = runBlocking {
    /*val timeSpent = measureTimeMillis {
        val store1 = async { calculateMyAmt(100) }
        val store2 = async { calculateMyAmt(200) }
        val store3 = async { calculateMyAmt(300) }
        val totalAmt = store1.await() + store2.await() + store3.await()
        println("Total Store Amt: $totalAmt")
    }
    println("Time Spent: $timeSpent")*/

    val timeSpent = measureTimeMillis {
        val store1 = withContext(Dispatchers.Default) { calculateMyAmt(100) }
        val store2 = withContext(Dispatchers.Default) { calculateMyAmt(200) }
        val store3 = withContext(Dispatchers.Default) { calculateMyAmt(300) }
        val totalAmt = store1 + store2 + store3
        println("Total Store Amt: $totalAmt")
    }
    println("Time Spent: $timeSpent")
}
