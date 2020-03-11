# Builder Pattern

The Builder pattern is used when you are only concerned about what you need from a class and not everything that a class has.

For example, when you go to buy some laptop, then you have a list of important features that you want in your laptop like processors, ram, storage, etc. Apart from these features, all the other features like the speaker, battery, etc are some of the optional features for you. So, based on the important features, the shopkeeper will provide you with a laptop that contains all your important features.

In this example, we will be having one Laptop class with four properties i.e. processor, ram, battery, and screen size. The processor is important, so you need to pass it every time and the rest of the properties are not important. So, if you are not setting the value then the default value will be used. 

Our model class for Laptop looks like:

```kotlin
class Laptop(builder:Builder) {
    private val processor: String = builder.processor
    private val ram: String = builder.ram
    private val battery: String = builder.battery
    private val screenSize: String = builder.screenSize

    override fun toString(): String {
        return "Laptop(processor='$processor', ram='$ram', battery='$battery', screenSize='$screenSize')"
    }

    // Builder class
    class Builder(// this is necessary
            var processor: String) {

        // optional features
        var ram: String = "2GB"
        var battery: String = "5000MAH"
        var screenSize: String = "15inch"

        fun setRam(ram: String): Builder {
            this.ram = ram
            return this
        }

        fun setBattery(battery: String): Builder {
            this.battery = battery
            return this
        }

        fun setScreenSize(screenSize: String): Builder {
            this.screenSize = screenSize
            return this
        }

        fun create(): Laptop {
            return Laptop(this)
        }
    }
}
```
 
Let's check

```kotlin
fun main(){
    val laptop = Laptop.Builder("i7")          // processor is compulsory
                     .setRam("8GB")            // this is optional
                     .setBattery("6000MAH")    // this is optional
                     .create()
    println(laptop)
}
```
Result :
```text
Laptop(processor='i7', ram='8GB', battery='6000MAH', screenSize='15inch')
```

In the above code, we have to pass the processor because this is a necessary component and rest are optional. Here, we are not passing the screen size, so the default value of the screen size will be used.
