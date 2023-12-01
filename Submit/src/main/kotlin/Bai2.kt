import kotlin.math.sqrt


fun CheckPrime(n: Int): Int {
    var tmp = sqrt(n.toDouble()).toInt()
    for(i in 2..tmp){
        if(n % i == 0){
            return 0
        }
    }
    if(n > 2) return 1
    else return 0
}

fun Fibo(N: Int){
    var f1 = 0
    var f2 = 1
    var fn = 0
    while (fn < N){
        fn = f1 + f2
        f1 = f2
        f2 = fn
        if(CheckPrime(fn) == 1){
            print("$fn ")
        }
    }
}

fun main(args: Array<String>) {
    var N:Int? = readLine()?.toInt()
    if (N != null) {
        Fibo(N)
    }
}