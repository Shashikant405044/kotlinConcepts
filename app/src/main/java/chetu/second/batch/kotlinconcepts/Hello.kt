package chetu.second.batch.kotlinconcepts


fun main(args: Array<String>) {
    var i = 10
    i = 20
    val j  = 20
    val sum = i + j

    val add = add(10, 20)
//    print(add(10, 200))
//    print("The sum of $i and $j is $sum")
    print(add(11,222))
}

fun add(i : Int, j : Int ) {
    println("The sum of $i and $j is ${i.plus(j)}")
}

