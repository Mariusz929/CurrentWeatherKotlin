val API_URL = js("getApiUrl()") as String

fun main(args: Array<String>) {
    val cityWeatherPresenter = CityWeatherPresenter()
    val citiesWeatherPage = CitiesWeatherPage(cityWeatherPresenter)
    citiesWeatherPage.show()
}