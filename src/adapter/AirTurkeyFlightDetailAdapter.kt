package adapter

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