package adapter

class AirAzerbaijanFlightDetailAdapter:FLightDetailAdapter {

    override fun getPriceInAZ(): Int {
        return 100
    }

    override fun getTimeInAZ(): String {
        return "TIME_IN_AZ"
    }
}