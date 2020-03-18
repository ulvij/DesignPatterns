package facade

class CarBuilderFacade {
    private val mercedes = Mercedes()
    private val bmw = Bmw()
    private val audi = Audi()

    fun buildMercedes() = mercedes.build()

    fun buildBmw() = bmw.build()

    fun buildAudi() = audi.build()

}