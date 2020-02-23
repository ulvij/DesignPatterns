package state

object RedLight:TrafficLampState {

    override fun changeState(trafficLamp: TrafficLamp) {
        trafficLamp.state = YellowLight
        println("New State is YellowLight")
    }
}