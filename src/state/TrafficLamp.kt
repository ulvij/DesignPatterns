package state

class TrafficLamp {
    // set RedLight as default
    var state: TrafficLampState = RedLight

    fun changeState(){
        state.changeState(this)
    }
}