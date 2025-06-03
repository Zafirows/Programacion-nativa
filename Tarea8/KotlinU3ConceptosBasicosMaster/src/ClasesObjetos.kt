import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

// Clase base para cualquier dispositivo inteligente.
open class SmartDevice(val name: String, val category: String) {

    // Estado del dispositivo (por defecto "online")
    var deviceStatus = "online"
        protected set // Solo puede modificarse dentro de la clase o subclases

    open val deviceType = "unknown" // Tipo del dispositivo, se sobreescribe en las subclases

    // Función para encender el dispositivo (se puede sobreescribir)
    open fun turnOn() {
        deviceStatus = "on"
    }

    // Función para apagar el dispositivo (se puede sobreescribir)
    open fun turnOff() {
        deviceStatus = "off"
    }
}

// Clase que representa un Smart TV, hereda de SmartDevice
class SmartTvDevice(deviceName: String, deviceCategory: String) :
    SmartDevice(name = deviceName, category = deviceCategory) {

    override val deviceType = "Smart TV"

    // Volumen del altavoz controlado por un delegado con límites
    private var speakerVolume by RangeRegulator(initialValue = 2, minValue = 0, maxValue = 100)

    // Número de canal también con regulación de rango
    private var channelNumber by RangeRegulator(initialValue = 1, minValue = 0, maxValue = 200)

    // Función para subir volumen del altavoz
    fun increaseSpeakerVolume() {
        speakerVolume++
        println("Speaker volume increased to $speakerVolume.")
    }

    // Función para cambiar al siguiente canal
    fun nextChannel() {
        channelNumber++
        println("Channel number increased to $channelNumber.")
    }

    // Se sobreescribe el método turnOn para personalizar el encendido
    override fun turnOn() {
        super.turnOn()
        println(
            "$name is turned on. Speaker volume is set to $speakerVolume and channel number is " +
                    "set to $channelNumber."
        )
    }

    // Se sobreescribe el método turnOff
    override fun turnOff() {
        super.turnOff()
        println("$name turned off")
    }
}

// Clase que representa una luz inteligente, también hereda de SmartDevice
class SmartLightDevice(deviceName: String, deviceCategory: String) :
    SmartDevice(name = deviceName, category = deviceCategory) {

    override val deviceType = "Smart Light"

    // Nivel de brillo regulado entre 0 y 100
    private var brightnessLevel by RangeRegulator(initialValue = 0, minValue = 0, maxValue = 100)

    // Aumenta el brillo en uno (si no se excede del límite)
    fun increaseBrightness() {
        brightnessLevel++
        println("Brightness increased to $brightnessLevel.")
    }

    // Se sobreescribe turnOn para configurar brillo y mostrar mensaje
    override fun turnOn() {
        super.turnOn()
        brightnessLevel = 2
        println("$name turned on. The brightness level is $brightnessLevel.")
    }

    // Se sobreescribe turnOff para apagar luz y resetear brillo
    override fun turnOff() {
        super.turnOff()
        brightnessLevel = 0
        println("Smart Light turned off")
    }
}

// Clase que representa un hogar inteligente con TV y Luz
class SmartHome(
    val smartTvDevice: SmartTvDevice,
    val smartLightDevice: SmartLightDevice
) {

    // Contador de cuántos dispositivos están encendidos
    var deviceTurnOnCount = 0
        private set

    // Encender TV
    fun turnOnTv() {
        deviceTurnOnCount++
        smartTvDevice.turnOn()
    }

    // Apagar TV
    fun turnOffTv() {
        deviceTurnOnCount--
        smartTvDevice.turnOff()
    }

    // Subir volumen de TV
    fun increaseTvVolume() {
        smartTvDevice.increaseSpeakerVolume()
    }

    // Cambiar al siguiente canal
    fun changeTvChannelToNext() {
        smartTvDevice.nextChannel()
    }

    // Encender la luz
    fun turnOnLight() {
        deviceTurnOnCount++
        smartLightDevice.turnOn()
    }

    // Apagar la luz
    fun turnOffLight() {
        deviceTurnOnCount--
        smartLightDevice.turnOff()
    }

    // Aumentar el brillo de la luz
    fun increaseLightBrightness() {
        smartLightDevice.increaseBrightness()
    }

    // Apagar todos los dispositivos del hogar
    fun turnOffAllDevices() {
        turnOffTv()
        turnOffLight()
    }
}

// Clase delegada que restringe un valor numérico dentro de un rango (para volumen, brillo, etc.)
class RangeRegulator(
    initialValue: Int,
    private val minValue: Int,
    private val maxValue: Int
) : ReadWriteProperty<Any?, Int> {

    var fieldData = initialValue

    // Devuelve el valor actual
    override fun getValue(thisRef: Any?, property: KProperty<*>): Int {
        return fieldData
    }

    // Asigna un valor solo si está dentro del rango permitido
    override fun setValue(thisRef: Any?, property: KProperty<*>, value: Int) {
        if (value in minValue..maxValue) {
            fieldData = value
        }
    }
}

// Función principal que prueba el funcionamiento de los dispositivos
fun main() {
    // Se crea un SmartTvDevice como SmartDevice (polimorfismo)
    var smartDevice: SmartDevice = SmartTvDevice("Android TV", "Entertainment")
    smartDevice.turnOn() // Llama a SmartTvDevice.turnOn()

    // Ahora se reasigna a un SmartLightDevice
    smartDevice = SmartLightDevice("Google Light", "Utility")
    smartDevice.turnOn() // Llama a SmartLightDevice.turnOn()
}
