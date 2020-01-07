interface CityContract {

    interface View {
        fun showCities(cities: List<City>) // 1
        fun showLoader() // 2
        fun hideLoader() // 3
    }

    interface Presenter {
        fun attach(view: View) // 4
        fun loadCities() // 5
    }
}