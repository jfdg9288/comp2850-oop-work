// Task 5.2.1: geometric properties of circles
import kotlin.math.PI

fun circleArea(radius: Double) = PI * radius * radius

fun circlePerimeter(radius: Double) = 2 * PI * radius

fun readDouble(str: String): Double {
    print(str)
    return readln().toDouble()
}

fun main() {
    print("Enter circle radius: ")
    val circRad = readln().toDouble()
    val circArea = circleArea(circRad)
    val circPer = circlePerimeter(circRad)
    println("Area: ${String.format("%.4f", circArea)}")
    println("Perimeter: ${String.format("%.4f", circPer)}")
}