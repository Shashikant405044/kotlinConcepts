package chetu.second.batch.kotlinconcepts

fun main() {
//    print(describe(1000.1))
    var name : String? = "Android"
    name = ""
    print(name)
}

fun describe(obj: Any): String =
    when (obj) {
        1          -> "One"
        "Hello"    -> "Greeting"
        is Long    -> "Long"
        !is String -> "Not a string"
        else       -> "Unknown"
    }

