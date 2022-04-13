package chetu.second.batch.kotlinconcepts

import java.lang.ArithmeticException
import kotlin.IndexOutOfBoundsException

fun main() {
    var items = listOf<String>("A", "B", "C" )
    try{
//        println(items[3])
        println(10/0)
    }catch(e : Exception){
        println(e.message)
//        throw Exception(e.message)
        throw MyException("This is catch block")
    }catch (ae : IndexOutOfBoundsException){
        throw MyException(ae.message.toString())
    }finally {
        println("This is finally block")
    }
    println(items[0])
}


class MyException(msg : String) : Exception(msg)