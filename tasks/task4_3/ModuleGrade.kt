import kotlin.system.exitProcess

fun main(args: Array<String>) {
    if (args.size != 3) {
        println("Error: 3 arguments have to be entered")
        exitProcess(1)
    }

    val a = args[0].toDouble()
    val b = args[1].toDouble()
    val c = args[2].toDouble()
    val avg = (a + b + c)/ 3.0

    val grade = when (avg) {
        in 0.0..39.0   -> "Fail"
        in 40.0..69.0  -> "Pass"
        in 70.0..100.0 -> "Distinction"
        else -> "?"
}

    println("$avg, $grade")

}