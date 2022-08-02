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

    /*println("Tester Ragavan".randomDisplayCase())

    performTextTransformation {
        randomDisplayCase()
    }

    performTextTransformation("Rajeevan") {
        randomDisplayCase()
    }*/

    /* val universityDefCenters = listOf("Delhi", "Mumbai","Puducherry","Chennai")
     val universitySouthCenters = listOf("Karnataka", "Puducherry","Chennai", "Kerala")

     val allCenters= universityDefCenters union universitySouthCenters
     val commonCenters = universityDefCenters intersect universitySouthCenters
     val nonSouthCenters = universityDefCenters subtract universitySouthCenters

     println("All Centers (Union): $allCenters")
     println("Common Centers (Intersection): $commonCenters")
     println("Non-South Centers (Subtract): $nonSouthCenters")*/
    test()
}

fun test() {
    /*runBlocking {
       *//* flow {
            (1..10).forEach {
                delay(300)
                emit(it)
            }
        }.collect {
            println(it)
        }*//*

        *//*val x = flowOf("A", "B", "C").onEach {
            delay(1000)
        }

        x.collectLatest {
            println(it)
        }*//*

        *//*val items = listOf("Test","Testing","Tester")
        val f= items.asFlow().onEach {
            delay(1000)
        }
        f.collectLatest {
            println(it)
        }*//*

        *//*val items = listOf("AAA","BBB","CCC")
        val chn = channelFlow {
            items.forEach{
                delay(1000)
                send(it)
            }
        }

        chn.buffer().collectLatest {
            println(it)
        }*//*
    }*/


    val studentList = listOf(
        StudentMarks("Ragavan", PRIMARY_SCHOOL, 92.79),
        StudentMarks("Rajeevan", PRIMARY_SCHOOL, 65.15),
        StudentMarks("Rajeevan", PRIMARY_SCHOOL, 52.23),
        StudentMarks("Arun", HIGH_SCHOOL, 83.21),
        StudentMarks("Harish", HIGH_SCHOOL, 63.56)
    )

    println("Name || Grade")
    studentList.forEach {
        println(
            "${it.sName} ||  ${
                it.getStudentGrade(gradeSel(it.classLevel))
            }"
        )
    }
}

val gradeSel by lazy { { classLevel: Int -> if (classLevel == PRIMARY_SCHOOL) primarySchoolGrade else highSchoolGrade } }

val primarySchoolGrade = GradePredicate {
    when {
        it > 90 -> "A+"
        it > 80 -> "A"
        it > 65 -> "B"
        it > 45 -> "C"
        it > 34 -> "D"
        else -> "F"
    }
}

val highSchoolGrade = GradePredicate {
    when {
        it > 80 -> "Very Good"
        it > 60 -> "Good"
        it > 34 -> "Fair"
        else -> "Fail"
    }
}

const val PRIMARY_SCHOOL = 1
const val HIGH_SCHOOL = 2

data class StudentMarks(val sName: String, val classLevel: Int, val sAvg: Double) {
    fun getStudentGrade(predicate: GradePredicate) = predicate.getGrade((sAvg))

}

fun interface GradePredicate {
    fun getGrade(avg: Double): String
}

fun interface dataPractice {
    fun getMy(d: Int, x: Int)
}

val x = dataPractice { x: Int, y: Int ->

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