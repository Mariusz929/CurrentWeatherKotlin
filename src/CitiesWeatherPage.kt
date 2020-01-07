import org.w3c.dom.HTMLDivElement
import kotlin.browser.document

class CitiesWeatherPage(private val presenter: CityContract.Presenter) : CityContract.View {

    private val loader = document.getElementById("loader") as HTMLDivElement
    private val content = document.getElementById("content") as HTMLDivElement
    private val cardBuilder = CardBuilder()

    override fun showCities(cities: List<City>) {
        cities.forEach { city ->
            val card = cardBuilder.build(city)
            content.appendChild(card)
        }
    }

    override fun showLoader() {
        loader.style.visibility = "visible"
    }

    override fun hideLoader() {
        loader.style.visibility = "hidden"
    }

    fun show() {
        presenter.attach(this)
        presenter.loadCities()
    }
}
