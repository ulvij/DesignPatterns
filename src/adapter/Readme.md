# Adapter Pattern

An Adapter is something like a connector that is used to connect two or more incompatible interface. This pattern lets the classes work together. 

Let's look at one example:

Firstly, let's create an interface Adapter named __"FlightDetailAdapter"__. This interface is having two methods that will return the time according to AZ and the price will be in AZ currency. The basic idea is we will implement this interface in various Airlines to get the details according to Azerbaijan standards.

```kotlin
interface FlightDetailAdapter {
    // get price in indian rupees
    fun getPriceInINR()
    
    // get time in Indian Standard Time
    fun getTimeInIST()
}
```
 
Secondly, we have to create two class for Airlines that implement same interface - __FlightDetailAdapter__ 
 
```kotlin
// Custom adapter for Azerbaijan Airlines
class AirAzerbaijanFlightDetailAdapter:FLightDetailAdapter {

    override fun getPriceInAZ(): Int {
        return 100
    }

    override fun getTimeInAZ(): String {
        return "TIME_IN_AZ"
    }
}

// Custom adapter for Turkey Airlines
class AirTurkeyFlightDetailAdapter : FLightDetailAdapter {

    override fun getPriceInAZ(): Int {
        return convertTRPriceToAZ(200)
    }

    override fun getTimeInAZ(): String {
        return convertTRTimeToAZ("TIME_IN_TR")
    }

    fun convertTRPriceToAZ(price: Int): Int {
        // make some logic here
        return price
    }

    fun convertTRTimeToAZ(time: String): String {
        // make some logic here
        return time.replace("TR","AZ")
    }
}
```

Then, we have to create some view class that will show the time and price of the flights on the appliation

```kotlin
class FlightView {

    fun showFlightData(adapter: FLightDetailAdapter){
        println("PRICE-->"+adapter.getPriceInAZ())
        println("TIME-->"+adapter.getTimeInAZ())
    }

}
``` 

Finally we can call our view and for the desired flight details : 

```kotlin
fun main(){
    val flightView: FlightView = FlightView()

    // for showing AirAzerbaijan flight details
    flightView.showFlightData(AirAzerbaijanFlightDetailAdapter())

    // for showing AirTurkey flight details
    flightView.showFlightData(AirTurkeyFlightDetailAdapter())
}
```

Result :
```text
PRICE-->100
TIME-->TIME_IN_AZ
PRICE-->200
TIME-->TIME_IN_AZ
```
