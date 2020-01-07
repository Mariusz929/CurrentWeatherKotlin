data class MainParams(
        val temp: String,
        val feels_like: String,
        val pressure: String,
        val humidity: String)

data class Weather(
        val icon: String,
        val description: String)

data class WeatherJSON(
        val icon: String)