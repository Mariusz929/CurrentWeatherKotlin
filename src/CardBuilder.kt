import org.w3c.dom.Element
import org.w3c.dom.HTMLDivElement
import org.w3c.dom.HTMLElement
import org.w3c.dom.HTMLImageElement
import kotlin.browser.document
import kotlin.dom.addClass
import kotlin.math.round
import kotlin.math.roundToInt

class CardBuilder {

    private fun bind(city: City,
                     nameElement: HTMLDivElement,
                     tempElement: HTMLDivElement,
                     feelsElement: HTMLDivElement,
                     humidityElement: HTMLDivElement,
                     pressureElement: HTMLDivElement) {

        nameElement.innerHTML = city.name
        tempElement.innerHTML = "temperatura: " + city.main.temp.toFloat().roundToInt() + "\u00B0" + "C"
        feelsElement.innerHTML = "odczuwalna: " + city.main.feels_like.toFloat().roundToInt() + "\u00B0" + "C"
        humidityElement.innerHTML = "wilgotność: " + city.main.humidity + "%"
        pressureElement.innerHTML = "ciśnienie: " + city.main.pressure + " hPa"
    }

    private fun applyStyle(containerElement: HTMLDivElement,
                           nameElement: HTMLDivElement,
                           tempElement: HTMLDivElement,
                           feelsElement: HTMLDivElement,
                           humidityElement: HTMLDivElement,
                           pressureElement: HTMLDivElement) {
        containerElement.addClass("card", "card-shadow")
        nameElement.addClass("text-name")
        tempElement.addClass("text-temp", "float-left")
        feelsElement.addClass("text-feels", "float-left")
        humidityElement.addClass("text-humidity", "float-left")
        pressureElement.addClass("text-pressure", "float-left")
    }

    fun build(city: City): HTMLElement {
        val containerElement = document.createElement("div") as HTMLDivElement
        val nameElement = document.createElement("div") as HTMLDivElement
        val tempElement = document.createElement("div") as HTMLDivElement
        val feelsElement = document.createElement("div") as HTMLDivElement
        val humidityElement = document.createElement("div") as HTMLDivElement
        val pressureElement = document.createElement("div") as HTMLDivElement

        bind(city = city,
                nameElement = nameElement,
                tempElement = tempElement,
                feelsElement = feelsElement,
                humidityElement = humidityElement,
                pressureElement = pressureElement)

        applyStyle(containerElement,
                nameElement = nameElement,
                tempElement = tempElement,
                feelsElement = feelsElement,
                humidityElement = humidityElement,
                pressureElement = pressureElement)

        containerElement
                .appendChild(
                        nameElement,
                        tempElement,
                        feelsElement,
                        humidityElement,
                        pressureElement
                )
        return containerElement
    }

    private fun Element.appendChild(vararg elements: Element) {
        elements.forEach {
            this.appendChild(it)
        }
    }
}
