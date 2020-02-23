package state

fun main() {
    val trafficLamb = TrafficLamp() // default state is Red
    trafficLamb.changeState() // the state must become Yellow
    trafficLamb.changeState() // the state must become Green
    trafficLamb.changeState() // the state must become Red again
}