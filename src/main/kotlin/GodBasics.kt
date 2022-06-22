import kotlin.random.Random

fun main() {
    /* println("God Knows All, Trust in god")
     runBlocking {
         launch {
             println("God Coroutine")
             delay(2000)
             println("Done")
         }
     }
     println("Source Done")*/
    /* val seq = sequence {
         println("Test One")
         yield(1)
         println("Test Two")
         yield(2)
         println("Test Three")
         yield(3)
         println("I'm Done")
         println("See you bye")
     }

     seq.forEach {
         println("The Str: $it")
     }*/
    /*println(getIpDetails("https://api64.ipify.org/"))*/
    //generateSequence(0) { it + 2 }.take(100).forEach { println(it) }

    /* val users = listOf(
         User("Ragavan", null, "V.S."),
         User("Rajeev", "Anbu", "Devan"),
         User("Ravinder", null, null),
         User("", "", ""),
         User(null, null, null)
     )
     println(users.map {
         listOfNotNull(it.fName, it.mName, it.lName)
             .joinToString(" ").trim().takeIf { it.isNotEmpty() } ?: "NA"
     }.toString())*/

    //forEach(::println)


    //println(fullName)
    //insertAll(users)
    /* val fullNameApproach1: List<String> = users.map {
         "${it.fName ?: ""} ${it.mName ?: ""} ${it.lName ?: ""}".trim()
             .takeIf { name -> name.isNotEmpty() } ?: "NA"
     }

     val plus = { name: String? -> name ?: "" }
     val fullNameApproach2 = users.map {
         "${plus(it.fName)} ${plus(it.mName)} ${plus(it.lName)}".trim()
             .takeIf { name -> name.isNotEmpty() } ?: "NA"
     }

     val fullNameApproach3 = users.map {
         listOfNotNull(it.fName, it.mName, it.lName)
             .joinToString(" ").trim().takeIf { it.isNotEmpty() } ?: "NA"
     }

     println(fullNameApproach1)
     println(fullNameApproach2)
     println(fullNameApproach3)*/


    /* println("Approach 1 -- Usual Way")
     users.forEach {
         println("${it.fName ?: ""} ${it.mName ?: ""} ${it.lName ?: ""}".trim()
             .takeIf { it.isNotEmpty() } ?: "NA")
     }

     println("Approach 2 -- Usual Approach with Lambda expression")
     //val plus = { name: String? -> name ?: "" }
     users.forEach {
         println("${plus(it.fName)} ${plus(it.mName)} ${plus(it.lName)}".trim()
             .takeIf { it.isNotEmpty() } ?: "NA")
     }

     println("Type 3/1 -- Using map with listOfNotNull method")
     users.map {
         println("User: ${
             listOfNotNull(it.fName, it.mName, it.lName)
                 .joinToString(" ").trim().takeIf { it.isNotEmpty() } ?: "NA"
         }")
     }

     println("Type 3/2 -- Using forEach with listOfNotNull method")
     users.forEach {
         println("User: ${
             listOfNotNull(it.fName, it.mName, it.lName)
                 .joinToString(" ").trim().takeIf { it.isNotEmpty() } ?: "NA"
         }")
     }*/

    println("Tester Ragavan".randomDisplayCase())

    performTextTransformation {
        randomDisplayCase()
    }

    performTextTransformation("Rajeevan") {
        randomDisplayCase()
    }
}

fun performTextTransformation(myText: String = "", trans: String.() -> String) {
    val sharedTxt = myText.takeIf { it.isNotEmpty() } ?: "Welcome Boys"
    println(sharedTxt.trans())
}

fun String.randomDisplayCase(): String =
    asIterable().joinToString("") { if (Random.nextBoolean()) it.uppercase() else it.lowercase() }

data class User(val fName: String?, val mName: String?, val lName: String?)

fun insertAll(uses: Iterable<User>) {
    uses.forEach { insert(it) }
    println("")
    uses.forEach(::insert)
}

fun insert(userObj: User, k: String = "") {
    println("${userObj.fName}")
}

fun getIpDetails(url: String) = java.net.URL(url).readText()