
fun findTwoMax(A: Array<Int>, n: Int){
    var firstMax: Int? = null
    var secondMax: Int? = null

    var tmp = 0
    for(i in 0..<n){
        if(firstMax == null || A[i] > firstMax){
            secondMax = firstMax
            firstMax = A[i]
            tmp = i - 1
        }else if(secondMax == null || (A[i] > secondMax && A[i] < firstMax)){
            secondMax = A[i]
            tmp = i
        }
    }
    println("First max: $firstMax - index: ${A.indexOf(firstMax)}")
    println("Second max: $secondMax - index: $tmp")
}

fun selectionSort(array: Array<Int>, n: Int){
    var min_idx: Int = 0
    for(i in 0..<n-1){
        min_idx = i + 1
        for(j in min_idx until  n){
            if(array[j] < array[min_idx]){
                min_idx = j
            }
        }
        if(array[min_idx] < array[i]){
            var temp = array[min_idx]
            array[min_idx] = array[i]
            array[i] = temp
        }
    }
}

fun insertElement(array: Array<Int>, element: Int): Array<Int> {
    val newArray = array.toMutableList()
    var index = 0
    while (index < array.size && element > array[index]){
        index++
    }
    newArray.add(index, element)
    return newArray.toTypedArray()
}

fun main(args: Array<String>) {
    print("Nhap so ")
    var m:String? = readLine()
    var n = m?.toInt()
    //val input:String? = readLine()
    //val array = input?.split(" ")?.map { it.toInt() }?.toTypedArray()
    var array:Array<Int> = Array(n!!){0}
    if(n != null) {
        for (i in 0 until n) {
            var tmp1: String? = readLine()
            var tmp2 = tmp1!!.toInt()
            array[i] = tmp2
        }
    }
    findTwoMax(array, n!!)
    selectionSort(array, n!!)
    for(element in array){
        print("$element ")
    }
    var newArray: Array<Int> = insertElement(array, 6)
    for(element in newArray){
        print("$element ")
    }
}
