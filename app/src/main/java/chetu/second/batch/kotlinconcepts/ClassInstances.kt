package chetu.second.batch.kotlinconcepts

fun main(args: Array<String>) {
    var shapObject  = Shap(10, 20)
    println("Area of ${shapObject.length} and ${shapObject.width} is ${shapObject.area()}")


    var name = "android"
    var name2 = name
    println(name.length)
    println(name)

    val i1 = 10
    val i2 = 20

    println(i1 + i2)
    println(i1.plus(i2))


    var data = arrayOf(10, 20, "Android", 100000000, 10.7)

    for (items in data){
        println(items)
    }

}