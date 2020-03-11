package adapter

class FlightView {

    fun showFlightData(adapter: FLightDetailAdapter){
        println("PRICE-->"+adapter.getPriceInAZ())
        println("TIME-->"+adapter.getTimeInAZ())
    }
}