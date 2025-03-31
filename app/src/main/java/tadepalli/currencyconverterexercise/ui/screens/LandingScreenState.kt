package tadepalli.currencyconverterexercise.ui.screens

enum class CurrencyEnum {
    USD, INR
}

data class LandingScreenState(
    val currency1: CurrencyEnum = CurrencyEnum.USD,
    val currency2: CurrencyEnum = CurrencyEnum.INR,
    val inputCurrency: CurrencyEnum = currency1,
    val currency1Value: String = "",
    val currency2Value: String = ""
)
