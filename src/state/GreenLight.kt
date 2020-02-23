package state

object GreenLight : TrafficLampState {
    override fun changeState(trafficLamp: TrafficLamp) {
        trafficLamp.state = RedLight
        println("New State is RedLight")
    }
}