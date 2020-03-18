package facade

fun main(){
    val carBuilderFacade = CarBuilderFacade()

    carBuilderFacade.buildMercedes()
    carBuilderFacade.buildBmw()
    carBuilderFacade.buildAudi()
}