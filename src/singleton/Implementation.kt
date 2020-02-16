package singleton

fun main() {
    println("Implementation without sending params")
    println("First call ->${SingletonWithoutParam.getInstance().hashCode()}")
    println("Second call ->${SingletonWithoutParam.getInstance().hashCode()}")
    println("Implementation with sending params")
    println("First call ->${SingletonWithParam.getInstance("First Call").hashCode()}")
    println("Second call ->${SingletonWithParam.getInstance("Second Call").hashCode()}")
}
