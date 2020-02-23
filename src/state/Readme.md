# State Design Pattern

The State design pattern is used when an Object changes its behavior based on its internal state.

State pattern is used to provide a systematic and lose-coupled way to achieve this through Context and State implementations.

Let's take an example scenario using a traffic lamp. Traffic lamps can be in different states. For example, Red, Yellow and Green light. According to a certain duration of per state, the behavior of the traffic lamps is a suitable scenario for state design patterns.

First, we have to create base state in order to create sub-states from that

```kotlin
interface TrafficLampState {
    fun changeState(trafficLamp: TrafficLamp)
}
```
 
Then let's create all states of the traffic lamp

```kotlin
object RedLight:TrafficLampState {
    override fun changeState(trafficLamp: TrafficLamp) {
        trafficLamp.state = YellowLight
        println("New State is YellowLight")
    }
}
```

```kotlin
object YellowLight:TrafficLampState {
    override fun changeState(trafficLamp: TrafficLamp) {
        trafficLamp.state = GreenLight
        println("New State is GreenLight")
    }
}
```

```kotlin
object GreenLight : TrafficLampState {
    override fun changeState(trafficLamp: TrafficLamp) {
        trafficLamp.state = RedLight
        println("New State is RedLight")
    }
}
```
__Note__: Pay attention to creating all states as a Singleton because of reuse

In order to implement this pattern, we should have the context of Traffic lamp. That's why we have to create a traffic lamp object and keep the state of it

```kotlin
class TrafficLamp {
    // set RedLight as default
    var state: TrafficLampState = RedLight
    
    fun changeState(){
        state.changeState(this)
    }
}
```

Let's check

```kotlin
fun main() {
    val trafficLamb = TrafficLamp() // default state is Red
    trafficLamb.changeState() // the state must become Yellow
    trafficLamb.changeState() // the state must become Green
    trafficLamb.changeState() // the state must become Red again
}
```

```text
New State is YellowLight
New State is GreenLight
New State is RedLight
```
