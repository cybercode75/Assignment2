// 2. Custom Setter
class Thermostat {
    var temperature: Double = 20.0
        private set
    fun setTemp(newTemp: Double) {
        temperature = newTemp
    }
}
