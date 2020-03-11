package builder

fun main(){
    val laptop = Laptop.Builder("i7")          // processor is compulsory
            .setRam("8GB")            // this is optional
            .setBattery("6000MAH")    // this is optional
            .create()
    println(laptop)
}