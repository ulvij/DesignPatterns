package adapter

fun main(){
    val flightView: FlightView = FlightView()

    // for showing AirAzerbaijan flight details
    flightView.showFlightData(AirAzerbaijanFlightDetailAdapter())

    // for showing AirTurkey flight details
    flightView.showFlightData(AirTurkeyFlightDetailAdapter())
}