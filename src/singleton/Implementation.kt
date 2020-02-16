package singleton

fun main() {
    println("Implementation without sending params")
    println("First call ->${SingletonWithoutParam.hashCode()}")
    println("Second call ->${SingletonWithoutParam.hashCode()}")
    println("Implementation with sending params")
    println("First call ->${SingletonWithParam.getInstance("First Call").hashCode()}")
    println("Second call ->${SingletonWithParam.getInstance("Second Call").hashCode()}")
}
