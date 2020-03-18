# Facade Pattern

Facade pattern hides the complexities of the system and provides an interface to the client using which the client can access the system. This type of design pattern comes under structural pattern as this pattern adds an interface to existing system to hide its complexities.

This pattern involves a single class which provides simplified methods required by client and delegates calls to methods of existing system classes.

Let's implement this pattern with this example below

We are going to create a ```Car``` interface

```kotlin
interface Car {
    fun build()
}
```
Then create concrete classes implementing this interface

```kotlin
class Mercedes:Car {
    override fun build() {
        println("Mercedes: build")
    }
}

class Bmw:Car{
    override fun build() {
        println("Bmw: build")
    }
}

class Audi:Car {
    override fun build() {
        println("Audi: build")
    }
}
```
Finally, create a ``CarBuilderFacade`` class in order to use these concrete classes do delegate user calls  

```kotlin
class CarBuilderFacade {
    private val mercedes = Mercedes()
    private val bmw = Bmw()
    private val audi = Audi()

    fun buildMercedes() = mercedes.build()

    fun buildBmw() = bmw.build()
    
    fun buildAudi() = audi.build()

}
```

Let's check

```kotlin
fun main(){
    val carBuilderFacade = CarBuilderFacade()

    carBuilderFacade.buildMercedes()
    carBuilderFacade.buildBmw()
    carBuilderFacade.buildAudi()
}
```

Result :
```text
Mercedes: build
Bmw: build
Audi: build
```
