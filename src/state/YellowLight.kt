package state

object YellowLight:TrafficLampState {
    override fun changeState(trafficLamp: TrafficLamp) {
        trafficLamp.state = GreenLight
        println("New State is GreenLight")
    }
}