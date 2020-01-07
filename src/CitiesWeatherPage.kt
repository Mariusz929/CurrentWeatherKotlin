import org.w3c.dom.HTMLDivElement
import kotlin.browser.document

class CitiesWeatherPage(private val presenter: CityContract.Presenter) : CityContract.View {

    private val loader = document.getElementById("loader") as HTMLDivElement
    private val content = document.getElementById("content") as HTMLDivElement

    override fun showCities(cities: List<City>) {
    }

    override fun showLoader() {
        loader.style.visibility = "visible"
    }

    override fun hideLoader() {
        loader.style.visibility = "hidden"
    }
}
