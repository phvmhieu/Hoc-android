import kotlin.math.sqrt
import kotlin.Unit

open class DaGiac (private val soCanh: Int, protected val dsCanh: IntArray){
    open fun TinhChuVi(): Int{
        return dsCanh.sum()
    }
    fun IndsCanh(){
        println("Cac canh cua da giac: ")
        for(i in dsCanh.indices){
            println("Canh ${i + 1}: ${dsCanh[i]}")
        }
    }
}

class TamGiac(dsCanh: IntArray) : DaGiac(3, dsCanh){
    override fun TinhChuVi(): Int {
        return super.TinhChuVi()
    }

    fun DienTichTamGiac(): Double{
        val p = TinhChuVi() / 2
        val a = dsCanh[0].toDouble()
        val b = dsCanh[1].toDouble()
        val c = dsCanh[2].toDouble()
        val DienTich: Double = sqrt(p * (p - a) * (p - b) * (p - c))

        return DienTich
    }

}

fun ThemTamGiac(TamGiacList: ArrayList<TamGiac>, a: Int, b: Int, c: Int){

    var dsCanh = intArrayOf(a, b, c)
    var tamGiac: TamGiac = TamGiac(dsCanh)
    TamGiacList.add(tamGiac)
}



fun main(args: Array<String>) {
    var TamGiacList = ArrayList<TamGiac>()
    var flag: Boolean = true
    while (flag == true){
        println("====================MENU=====================")
        println("1. Them Tam Giac vao danh sach")
        println("2. In ra danh sach Tam Giac")
        println("3. In ra Tam Giac co dien tich lon nhat")
        println("4. Tim kiem Tam Giac theo vi tri")
        println("5. Xoa Tam Giac tai 1 vi tri")
        println("6. Sap xep danh sach tang dan theo dien tich")
        println("7. Thoat chuong trinh")
        println("=============================================")

        var choice: String? = readLine()
        when(choice){
            "1" -> {
                println("Nhap so luong Tam Giac")
                var size: Int? = readLine()?.toInt()
                if(size != null) {
                    for (i in 0 until size) {
                        println("Nhap canh 1: ")
                        var a: Int? = readLine()?.toInt()
                        println("Nhap canh 2: ")
                        var b: Int? = readLine()?.toInt()
                        println("Nhap canh 3: ")
                        var c: Int? = readLine()?.toInt()
                        if(a != null && b != null && c != null){
                            ThemTamGiac(TamGiacList, a, b, c)
                        }

                    }

                }
            }
            "2" -> {
                if(TamGiacList.isEmpty()) {
                    println("Danh sach rong")
                }else{
                    for(i in TamGiacList.indices){
                        println("Tam giac ${i + 1}: ")
                        println(TamGiacList[i].IndsCanh())
                    }

                }
            }

            "3" -> {
                if (TamGiacList.isEmpty()) {
                    println("Danh sach Tam Giac rong.")
                } else {
                    var tmp: TamGiac = TamGiacList[0]
                    for(i in TamGiacList){
                        var temp = 0.0
                        if(temp < i.DienTichTamGiac()){
                            temp = i.DienTichTamGiac()
                            tmp = i
                        }
                    }
                    println("Tam giac co dien tich to nhat la: ")
                    tmp.IndsCanh()

                }
            }
            "4" -> {
                if (TamGiacList.isEmpty()) {
                    println("Danh sach Tam Giac rong.")
                } else {
                    println("Nhap vi tri:")
                    val position = readLine()?.toInt()

                    if (position != null && position >= 0 && position < TamGiacList.size) {
                        val tamGiac = TamGiacList[position]
                        println("Tam Giac tai vi tri $position: ")
                        tamGiac.IndsCanh()
                    } else {
                        println("Vi tri khong hop le.")
                    }
                }
            }
            "5" -> {
                if (TamGiacList.isEmpty()) {
                    println("Danh sach Tam Giac rong.")
                } else {
                    println("Nhap vi tri:")
                    val position = readLine()?.toInt()

                    if (position != null && position >= 0 && position < TamGiacList.size) {
                        TamGiacList.removeAt(position)
                        println("Tam Giac tai vi tri $position da duoc xoa.")
                    } else {
                        println("Vi tri khong hop le.")
                    }
                }
            }
            "6" -> {
                if (TamGiacList.isEmpty()) {
                    println("Danh sach Tam Giac rong.")
                } else {
                    TamGiacList.sortBy { it.DienTichTamGiac() }
                    println("Danh sach Tam Giac da duoc sap xep theo dien tich tang dan.")
                }
            }
            "7" -> {
                flag = false
            }
        }

    }

}
