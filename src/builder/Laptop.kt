package builder

class Laptop(builder:Builder) {
    private val processor: String = builder.processor
    private val ram: String = builder.ram
    private val battery: String = builder.battery
    private val screenSize: String = builder.screenSize

    override fun toString(): String {
        return "Laptop(processor='$processor', ram='$ram', battery='$battery', screenSize='$screenSize')"
    }

    // Builder class
    class Builder(// this is necessary
            var processor: String) {

        // optional features
        var ram: String = "2GB"
        var battery: String = "5000MAH"
        var screenSize: String = "15inch"

        fun setRam(ram: String): Builder {
            this.ram = ram
            return this
        }

        fun setBattery(battery: String): Builder {
            this.battery = battery
            return this
        }

        fun setScreenSize(screenSize: String): Builder {
            this.screenSize = screenSize
            return this
        }

        fun create(): Laptop {
            return Laptop(this)
        }
    }
}