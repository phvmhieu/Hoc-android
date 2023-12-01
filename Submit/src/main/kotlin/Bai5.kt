import kotlin.math.pow
import kotlin.math.sqrt

fun main(args: Array<String>) {
    print("a: ")
    var a: Double? = readLine()?.toDouble()
    print("b: ")
    var b: Double? = readLine()?.toDouble()
    print("c ")
    var c: Double? = readLine()?.toDouble()
    if(a != null && b != null && c != null){
        if(a == 0.0){
            if(b == 0.0){
                if(c == 0.0){
                    println("Phuong trinh co vo so nghiem")
                }else{
                    println("Phuong trinh vo nghiem")
                }
            }else{
                println("x co nghiem la: ${-c / b}")
            }
        }else{
            var delta: Double = b.pow(2) - 4 * a * c
            if(delta > 0){
                var x1: Double = (-b + sqrt(delta)) / (2 * a)
                var x2: Double = (-b - sqrt(delta)) / (2 * a)
                println("x1 co nghiem la: $x1")
                println("x2 co nghiem la: $x2")
            }else if(delta == 0.0){
                var x: Double = -b / (2 * a)
                println("Phuong trinh co nghiem duy nhat la: $x")
            }else{
                println("Phuong trinh vo nghiem")
            }
        }
    }
}