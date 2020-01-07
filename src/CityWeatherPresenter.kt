import org.w3c.xhr.XMLHttpRequest

class CityWeatherPresenter : CityContract.Presenter {

    private lateinit var view: CityContract.View

    override fun attach(view: CityContract.View) {
        this.view = view
    }

    override fun loadCities() {
        view.showLoader()
        getAsync(API_URL) { response ->
            val result = JSON.parse<JsonResult>(response)
            val cityJSONList = JSON.parse<Array<CityJSON>>(JSON.stringify(result.list))
            val cities = ArrayList<City>()
            cityJSONList.forEach {
                val main = JSON.parse<MainParams>(JSON.stringify(it.main))
                cities.add(City(it.name, main))
            }
            view.hideLoader()
            view.showCities(cities.toList())
        }
    }

    private fun getAsync(url: String, callback: (String) -> Unit) {
        val xmlHttp = XMLHttpRequest()
        xmlHttp.open("GET", url)
        xmlHttp.onload = {
            if (xmlHttp.readyState == 4.toShort() && xmlHttp.status == 200.toShort()) {
                callback.invoke(xmlHttp.responseText)
            }
        }
        xmlHttp.send()
    }
}