data class City(val name: String,
                val main: MainParams)

data class CityJSON(val name: String,
                    val main: String,
                    val wind: String,
                    val rain: String)