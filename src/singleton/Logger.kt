package singleton

// this is singleton class which is not receive any argument
object Logger {

    fun d(message:String){
        println("Logger D : $message")
    }

    fun i(message:String){
        println("Logger I : $message")
    }

    fun e(message:String){
        println("Logger E : $message")
    }

    fun w(message:String){
        println("Logger W : $message")
    }

    fun getInstance():Logger{
        return this
    }
}