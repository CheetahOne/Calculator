package com.anma.calculator.data

import android.content.Context
import com.anma.calculator.R
import com.anma.calculator.Utils.Constants
import com.anma.calculator.Utils.UiState
import javax.inject.Inject

data class UnitInfo(
    val name: String,
    val symbol: String,
    val factor: Double
)

open class AppResources @Inject constructor() {

    val navigationOptions =
        listOf(UiState.UNITS, UiState.CALCULATOR, UiState.MATHS, UiState.FINANCE)


    val unitOptions = listOf(
        Constants.AREA,
        Constants.LENGTH,
        Constants.TEMPERATURE,
        Constants.TIME,
        Constants.VOLUME,
        Constants.WEIGHT,
        Constants.SPEED,
        Constants.ENERGY,
        Constants.PRESSURE,
        Constants.FUEL,
        Constants.STORAGE,
        Constants.CURRENT,
        Constants.FORCE,
        Constants.SOUND,
        Constants.FREQUENCY,
        Constants.RADIATION,
        Constants.POWER,
        Constants.DENSITY,
        Constants.RESOLUTION,
        Constants.LAND_AREA,
        Constants.ANGLE,
        Constants.TORQUE,
        Constants.DATA_SPEED,
        Constants.ILLUMINATION,
    )

    private val mappedResourceForUnits = mapOf(
        Constants.AREA to R.drawable.area,
        Constants.LENGTH to R.drawable.length,
        Constants.TEMPERATURE to R.drawable.temperature,
        Constants.TIME to R.drawable.time,
        Constants.VOLUME to R.drawable.volume,
        Constants.WEIGHT to R.drawable.weight,
        Constants.SPEED to R.drawable.speed,
        Constants.ENERGY to R.drawable.energy,
        Constants.BINARY to R.drawable.binary,
        Constants.PRESSURE to R.drawable.pressure,
        Constants.CURRENCY to R.drawable.currency,
        Constants.FUEL to R.drawable.fule,
        Constants.STORAGE to R.drawable.storage,
        Constants.CURRENT to R.drawable.current,
        Constants.FORCE to R.drawable.force,
        Constants.SOUND to R.drawable.sound,
        Constants.FREQUENCY to R.drawable.frequency,
        Constants.RADIATION to R.drawable.radiation,
        Constants.POWER to R.drawable.power,
        Constants.FLOW to R.drawable.flow,
        Constants.DENSITY to R.drawable.density,
        Constants.SURFACE_TENSION to R.drawable.surface,
        Constants.RESOLUTION to R.drawable.resolution,
        Constants.LAND_AREA to R.drawable.land,
        Constants.ANGLE to R.drawable.angle,
        Constants.TORQUE to R.drawable.torque,
        Constants.DATA_SPEED to R.drawable.data_transfer,
        Constants.ILLUMINATION to R.drawable.illumination,
    )

    private val navigationBarRes = mapOf(
        UiState.UNITS to R.drawable.tab_unit,
        UiState.CALCULATOR to R.drawable.tab_cal,
        UiState.MATHS to R.drawable.tab_maths,
        UiState.FINANCE to R.drawable.tab_finance
    )

    val unitMap = mapOf(
        Constants.LENGTH to listOf(
            UnitInfo("meter", "m", 1.0),
            UnitInfo("kilometer", "km", 1000.0),
            UnitInfo("centimeter", "cm", 0.01),
            UnitInfo("millimeter", "mm", 0.001),
            UnitInfo("micrometer", "μm", 1e-6),
            UnitInfo("nanometer", "nm", 1e-9),
            UnitInfo("mile", "mi", 1609.34),
            UnitInfo("yard", "yd", 0.9144),
            UnitInfo("foot", "ft", 0.3048),
            UnitInfo("inch", "in", 0.0254),
            UnitInfo("nautical mile", "nmi", 1852.0)
        ),
        Constants.AREA to listOf(
            UnitInfo("square meter", "m²", 1.0),
            UnitInfo("square kilometer", "km²", 1_000_000.0),
            UnitInfo("square centimeter", "cm²", 0.0001),
            UnitInfo("square millimeter", "mm²", 0.000001),
            UnitInfo("square mile", "mi²", 2589988.11),
            UnitInfo("square yard", "yd²", 0.836127),
            UnitInfo("square foot", "ft²", 0.092903),
            UnitInfo("square inch", "in²", 0.00064516),
            UnitInfo("hectare", "ha", 10000.0),
            UnitInfo("acre", "ac", 4046.86)
        ),
        Constants.TEMPERATURE to listOf(
            UnitInfo("Celsius", "°C", 1.0),
            UnitInfo("Fahrenheit", "°F", 1.0),
            UnitInfo("Kelvin", "K", 1.0)
        ),
        Constants.TIME to listOf(
            UnitInfo("second", "s", 1.0),
            UnitInfo("millisecond", "ms", 0.001),
            UnitInfo("microsecond", "μs", 0.000001),
            UnitInfo("nanosecond", "ns", 1e-9),
            UnitInfo("minute", "min", 60.0),
            UnitInfo("hour", "h", 3600.0),
            UnitInfo("day", "d", 86400.0),
            UnitInfo("week", "wk", 604800.0),
            UnitInfo("year", "yr", 31536000.0)
        ),
        Constants.VOLUME to listOf(
            UnitInfo("cubic meter", "m³", 1000.0),
            UnitInfo("liter", "L", 1.0),
            UnitInfo("milliliter", "mL", 0.001),
            UnitInfo("cubic foot", "ft³", 28.3168),
            UnitInfo("cubic inch", "in³", 0.016387),
            UnitInfo("gallon", "gal", 3.78541),
            UnitInfo("quart", "qt", 0.946353),
            UnitInfo("pint", "pt", 0.473176),
            UnitInfo("cup", "cup", 0.24),
            UnitInfo("fluid ounce", "fl oz", 0.0295735)
        ),
        Constants.WEIGHT to listOf(
            UnitInfo("kilogram", "kg", 1.0),
            UnitInfo("gram", "g", 0.001),
            UnitInfo("milligram", "mg", 0.000001),
            UnitInfo("metric ton", "t", 1000.0),
            UnitInfo("pound", "lb", 0.453592),
            UnitInfo("ounce", "oz", 0.0283495),
            UnitInfo("stone", "st", 6.35029)
        ),
        Constants.SPEED to listOf(
            UnitInfo("meters per second", "m/s", 1.0),
            UnitInfo("kilometers per hour", "km/h", 0.277778),
            UnitInfo("miles per hour", "mph", 0.44704),
            UnitInfo("knot", "kn", 0.514444),
            UnitInfo("mach", "Ma", 340.3)
        ),
        Constants.ENERGY to listOf(
            UnitInfo("joule", "J", 1.0),
            UnitInfo("kilojoule", "kJ", 1000.0),
            UnitInfo("calorie", "cal", 4.184),
            UnitInfo("kilocalorie", "kcal", 4184.0),
            UnitInfo("watt hour", "Wh", 3600.0),
            UnitInfo("kilowatt hour", "kWh", 3600000.0),
            UnitInfo("british thermal unit", "BTU", 1055.06)
        ),
        Constants.STORAGE to listOf(
            UnitInfo("bit", "b", 0.125),
            UnitInfo("byte", "B", 1.0),
            UnitInfo("kilobyte", "KB", 1024.0),
            UnitInfo("megabyte", "MB", 1048576.0),
            UnitInfo("gigabyte", "GB", 1073741824.0),
            UnitInfo("terabyte", "TB", 1099511627776.0)
        ),
        Constants.PRESSURE to listOf(
            UnitInfo("pascal", "Pa", 1.0),
            UnitInfo("kilopascal", "kPa", 1000.0),
            UnitInfo("bar", "bar", 100000.0),
            UnitInfo("psi", "psi", 6894.76),
            UnitInfo("atmosphere", "atm", 101325.0),
            UnitInfo("torr", "Torr", 133.322)
        ),
        Constants.FORCE to listOf(
            UnitInfo("newton", "N", 1.0),
            UnitInfo("kilonewton", "kN", 1000.0),
            UnitInfo("pound-force", "lbf", 4.44822)
        ),
        Constants.FREQUENCY to listOf(
            UnitInfo("hertz", "Hz", 1.0),
            UnitInfo("kilohertz", "kHz", 1000.0),
            UnitInfo("megahertz", "MHz", 1_000_000.0),
            UnitInfo("gigahertz", "GHz", 1_000_000_000.0)
        ),
        Constants.POWER to listOf(
            UnitInfo("watt", "W", 1.0),
            UnitInfo("kilowatt", "kW", 1000.0),
            UnitInfo("megawatt", "MW", 1_000_000.0),
            UnitInfo("horsepower", "hp", 745.7)
        ),
        Constants.DENSITY to listOf(
            UnitInfo("kg/m³", "kg/m³", 1.0),
            UnitInfo("g/cm³", "g/cm³", 1000.0)
        ),
        Constants.CURRENT to listOf(
            UnitInfo("ampere", "A", 1.0),
            UnitInfo("milliampere", "mA", 0.001),
            UnitInfo("microampere", "μA", 0.000001)
        ),
        Constants.RESOLUTION to listOf(
            UnitInfo("Pixels per inch", "PPI", 1.0),
            UnitInfo("Pixels per centimeter", "PPCM", 0.3937),
            UnitInfo("Dots per inch", "DPI", 1.0)
        ),
        Constants.LAND_AREA to listOf(
            UnitInfo("Square Meter", "m²", 1.0),
            UnitInfo("Square Yard (Gaj)", "yd²", 0.8361),
            UnitInfo("Square Foot", "ft²", 0.0929),
            UnitInfo("Acre", "ac", 4046.86),
            UnitInfo("Hectare", "ha", 10000.0),
            UnitInfo("Bigha", "bigha", 2529.29),
            UnitInfo("Kanal", "kanal", 505.857),
            UnitInfo("Marla", "marla", 25.2929),
            UnitInfo("Biswa", "biswa", 126.46),
            UnitInfo("Guntha", "guntha", 101.17)
        ),
        Constants.RADIATION to listOf(
            UnitInfo("Sievert", "Sv", 1.0),
            UnitInfo("Millisievert", "mSv", 0.001),
            UnitInfo("Microsievert", "μSv", 0.000001),
            UnitInfo("Gray", "Gy", 1.0),
            UnitInfo("Milligray", "mGy", 0.001),
            UnitInfo("Rad", "rad", 0.01),
            UnitInfo("Millirad", "mrad", 0.00001),
            UnitInfo("Roentgen", "R", 0.00877),
            UnitInfo("Milliroentgen", "mR", 0.00000877),
            UnitInfo(
                "Becquerel",
                "Bq",
                1.0
            ),
            UnitInfo("Curie", "Ci", 3.7e10)
        ),
        Constants.SOUND to listOf(
            UnitInfo("Decibel", "dB", 1.0),
            UnitInfo("Bel", "B", 10.0),
            UnitInfo("Neper", "Np", 8.6858),
            UnitInfo("Pascal", "Pa", 1.0),
            UnitInfo("Millipascal", "mPa", 0.001)
        ),
        Constants.FUEL to listOf(
            UnitInfo("Kilometers per liter", "km/L", 1.0),
            UnitInfo("Liters per 100km", "L/100km", 1.0),
            UnitInfo("Miles per gallon (US)", "mpg US", 0.4251),
            UnitInfo("Miles per gallon (UK)", "mpg UK", 0.3540),
            UnitInfo("Miles per liter", "mi/L", 0.6213)
        ),
        Constants.ANGLE to listOf(
            UnitInfo("Degree", "°", 1.0),
            UnitInfo("Radian", "rad", 57.2958),
            UnitInfo("Gradian", "grad", 0.9),
            UnitInfo("Minute of arc", "′", 0.0166667)
        ),
        Constants.DATA_SPEED to listOf(
            UnitInfo("Bits per second", "bps", 1.0),
            UnitInfo("Kilobits per second", "kbps", 1000.0),
            UnitInfo("Megabits per second", "Mbps", 1_000_000.0),
            UnitInfo("Gigabits per second", "Gbps", 1_000_000_000.0),
            UnitInfo("Megabytes per second", "MB/s", 8_000_000.0) // 1 byte = 8 bits
        ),
        Constants.TORQUE to listOf(
            UnitInfo("Newton-meter", "N·m", 1.0),
            UnitInfo("Pound-foot", "lb·ft", 1.3558),
            UnitInfo("Kilogram-force meter", "kgf·m", 9.8066)
        ),
        Constants.ILLUMINATION to listOf(
            UnitInfo("Lux", "lx", 1.0),
            UnitInfo("Foot-candle", "ft-cd", 10.7639),
            UnitInfo("Phot", "ph", 10000.0)
        )
    )

    fun getTabIcon(name: UiState): Int {
        return navigationBarRes[name] ?: 0
    }

    fun getUnitName(context: Context, name: String): String {
        return when (name) {
            Constants.AREA -> context.getString(R.string.TAB_Area)
            Constants.LENGTH -> context.getString(R.string.TAB_Length)
            Constants.TEMPERATURE -> context.getString(R.string.TAB_Temperature)
            Constants.TIME -> context.getString(R.string.TAB_Time)
            Constants.VOLUME -> context.getString(R.string.TAB_Volume)
            Constants.WEIGHT -> context.getString(R.string.TAB_Weight)
            Constants.SPEED -> context.getString(R.string.TAB_Speed)
            Constants.ENERGY -> context.getString(R.string.TAB_Energy)
            Constants.BINARY -> context.getString(R.string.TAB_Binary)
            Constants.PRESSURE -> context.getString(R.string.TAB_Pressure)
            Constants.CURRENCY -> context.getString(R.string.TAB_Currency)
            Constants.FUEL -> context.getString(R.string.TAB_Fuel)
            Constants.STORAGE -> context.getString(R.string.TAB_Storage)
            Constants.CURRENT -> context.getString(R.string.TAB_Current)
            Constants.FORCE -> context.getString(R.string.TAB_Force)
            Constants.SOUND -> context.getString(R.string.TAB_Sound)
            Constants.FREQUENCY -> context.getString(R.string.TAB_Frequency)
            Constants.RADIATION -> context.getString(R.string.TAB_Radiation)
            Constants.POWER -> context.getString(R.string.TAB_Power)
            Constants.FLOW -> context.getString(R.string.TAB_Flow)
            Constants.DENSITY -> context.getString(R.string.TAB_Density)
            Constants.SURFACE_TENSION -> context.getString(R.string.TAB_SurfaceTension)
            Constants.RESOLUTION -> context.getString(R.string.TAB_Resolution)
            Constants.LAND_AREA -> context.getString(R.string.TAB_LandArea)
            Constants.ANGLE -> context.getString(R.string.TAB_Angle)
            Constants.TORQUE -> context.getString(R.string.TAB_Torque)
            Constants.DATA_SPEED -> context.getString(R.string.TAB_DataSpeed)
            Constants.ILLUMINATION -> context.getString(R.string.TAB_Illumination)
            else -> ""
        }
    }

    fun getTabName(context: Context, name: UiState): String {
        return when (name) {
            UiState.CALCULATOR -> context.getString(R.string.TAB_Calculator)
            UiState.UNITS -> context.getString(R.string.TAB_UNITS)
            UiState.FINANCE -> context.getString(R.string.TAB_Finance)
            UiState.MATHS -> context.getString(R.string.TAB_Maths)
        }
    }

    fun getResourcesForUnit(name: String): Int {
        return mappedResourceForUnits[name] ?: 0
    }

    fun getUnitsData(unit: String): List<UnitInfo>? {
        return unitMap[unit]
    }

    fun getFactor(unitName: String): Double {
        return unitMap.values.flatten().find { it.name == unitName }?.factor ?: 1.0
    }

    fun getSelectedCategoryIndex(name: String): Int{
        return unitOptions.indexOfFirst { it == name }
    }
}