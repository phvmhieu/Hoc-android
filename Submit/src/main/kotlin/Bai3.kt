import kotlin.math.*

fun tongChuSo(n: Int):Int {
    var sum :Int = 0
    var number = n
    while(number > 0){
        sum += number % 10
        number /= 10
    }
    return sum
}

fun phanTichThuaSoNT(n :Int){
    var number = n
    for (i in 2..number step 1) {
        while(number % i == 0){
            print("$i")
            number /= i
            if(number > i){
                print(" * ");
            }
        }
    }
}

fun lietKeUocSo(n :Int){
    var number = n
    for(i in 1..number step 1){
        if(number % i == 0){
            print("$i ")
        }
    }
    println()
    for (i in 2..number step 1) {
        if(number % i == 0){
            print("$i ")
            while(number % i == 0){
                number /= i
            }
        }

    }
}

fun main() {
    println("Nhap vao 1 so nguyen duong n: ")
    var n: String? = readLine()
    var m: Int? = n?.toInt()
    if (m != null) {
        var tmp = tongChuSo(m)
        println("Tổng các chữ số của $n là: $tmp")
        phanTichThuaSoNT(m)
        println()
        lietKeUocSo(m)

    } else {
        println("Đầu vào không hợp lệ.")
    }

}

