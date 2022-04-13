package chetu.second.batch.kotlinconcepts

fun main() {
    var demo = Demo()
    print(demo)
    var conDemo = ConsDemo("AAA", listOf("A"))
}


open class Demo : Demonterface{
    private var  i = 100
    internal var j = 200
    protected  var k = 300
    public  var  l = 400
    override fun m1() {
        TODO("Not yet implemented")
    }

    companion object {
        var name = "Companion"
    }
}


