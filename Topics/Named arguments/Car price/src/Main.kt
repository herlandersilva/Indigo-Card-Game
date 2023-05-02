// complete this function, add default values
const val DEFAULT_CAR_AGE = 5
const val DEFAULT_KILOMETRES = 100000
const val DEFAULT_MAX_SPEED = 120
const val DEFAULT_AUTOMATIC = false
const val DEFAULT_PRICE = 20000

const val DECREASE_VALUE_PER_YEAR = 2000
const val DECREASE_VALUE_PER_MAX_SPEED = 100
const val DECREASE_VALUE_PER_KILOMETER = 200
const val VALUE_IF_HAVE_AUTOMATIC = 1500
const val VALUE_IF_NOT_HAVE_AUTOMATIC = 0

const val KILOMETRES_DECREASE_VALUE = 10000
fun carPrice(
    old: Int = DEFAULT_CAR_AGE,
    kilometers: Int = DEFAULT_KILOMETRES,
    maximumSpeed: Int = DEFAULT_MAX_SPEED,
    automatic: Boolean = DEFAULT_AUTOMATIC
) = DEFAULT_PRICE
    .minus(valueForAgeCar(old))
    .plus(valueForMaxSpeed(maximumSpeed))
    .minus(valueForKilometer(kilometers))
    .plus(valueForAutomatic(automatic))
    .let(::println)

fun valueForAgeCar(old: Int): Int = old * DECREASE_VALUE_PER_YEAR

fun valueForMaxSpeed(maximumSpeed: Int): Int = (maximumSpeed - DEFAULT_MAX_SPEED) * DECREASE_VALUE_PER_MAX_SPEED

fun valueForKilometer(kilometers: Int): Int = kilometers / KILOMETRES_DECREASE_VALUE * DECREASE_VALUE_PER_KILOMETER

fun valueForAutomatic(automatic: Boolean): Int = if (automatic) VALUE_IF_HAVE_AUTOMATIC else VALUE_IF_NOT_HAVE_AUTOMATIC
