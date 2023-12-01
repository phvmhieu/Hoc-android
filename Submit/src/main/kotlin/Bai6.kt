
open class CanBo(val Name: String, val Age: Int, val Gender: String, val Address: String)

class CongNhan(Name: String, Age: Int, Gender: String, Address: String, val Rank: Int) :
    CanBo(Name, Age, Gender, Address){


}

class KySu(Name: String, Age: Int, Gender: String, Address: String, val NganhDaoTao: String):
        CanBo(Name, Age, Gender, Address){


}

class NhanVien(Name: String, Age: Int, Gender: String, Address: String, val Congviec: String):
        CanBo(Name, Age, Gender, Address){

}

class QLCB(val dsCanBo: ArrayList<CanBo>) {
    fun ThemMoiCanBo(canBo: CanBo){
        dsCanBo.add(canBo)
    }

    fun TimKienTheoHoTen(Name: String){
        for(canbo in dsCanBo){
            var compare = Name.compareTo(canbo.Name, ignoreCase = true)
            if(compare == 0){
                InCanBo(canbo)
            }
        }
    }

    fun InCanBo(canBo: CanBo){
        println("Ten: ${canBo.Name}, Tuoi: ${canBo.Age}, Gioi tinh: ${canBo.Gender}, Dia chi: ${canBo.Address}")
    }

    fun InDanhSach(){
        println("Danh sach can bo")
        for(canBo in dsCanBo){
            InCanBo(canBo)
        }
    }

    fun Thoat(): Boolean{
        return false
    }
}

fun main(args: Array<String>) {
    var dsCanBo = ArrayList<CanBo>()
    var qlcb: QLCB = QLCB(dsCanBo)
    var flag = true
    while (flag == true){
        println("=====================MENU====================")
        println("============== 1.Them moi can bo ============")
        println("========== 2.Tim kiem theo ho ten ===========")
        println("= 3.Hien thi thong tin danh sach cac can bo =")
        println("========= 4.Thoat khoi chuong trinh =========")
        println("=============================================")

        var choice: String? = readLine()
        when(choice){
            "1" -> {
                println("Nhap vao ten cua Can Bo")
                var Name: String? = readLine()
                println("Nhap vao tuoi cua Can Bo")
                var Age: Int? = readLine()?.toInt()
                println("Nhap vao gioi tinh cua Can Bo")
                var Gender: String? = readLine()
                println("Nhap vao dia chi cua Can Bo")
                var Address: String? = readLine()
                if(Name != null && Age != null && Gender != null && Address != null) {
                    var canBo: CanBo = CanBo(Name, Age, Gender, Address)
                    qlcb.ThemMoiCanBo(canBo)
                }
            }
            "2" -> {
                if (dsCanBo.isEmpty()){
                    println("Danh sach rong")
                }else {
                    println("Nhap vao ho ten Can Bo de tim kiem")
                    var Name: String? = readLine()
                    if (Name != null) {
                        qlcb.TimKienTheoHoTen(Name)
                    }
                }
            }
            "3" -> {
                if(dsCanBo.isEmpty()){
                    println("Danh sach rong !")
                }else{
                    qlcb.InDanhSach()
                }
            }
            "4" -> {
                flag = qlcb.Thoat()
            }
        }
    }
}