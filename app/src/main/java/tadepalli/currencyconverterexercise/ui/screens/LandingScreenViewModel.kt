package tadepalli.currencyconverterexercise.ui.screens

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class LandingScreenViewModel(
) : ViewModel() {

    private var _landingScreenState: MutableStateFlow<LandingScreenState> =
        MutableStateFlow(LandingScreenState())

    val landingScreenState: StateFlow<LandingScreenState>
        get() = _landingScreenState.asStateFlow()

    fun onFlipClicked() {
        _landingScreenState.value = _landingScreenState.value.copy(
            currency1 = _landingScreenState.value.currency2,
            currency2 = _landingScreenState.value.currency1,
            currency1Value = _landingScreenState.value.currency2Value,
            currency2Value = _landingScreenState.value.currency1Value
        )
        _landingScreenState.value = _landingScreenState.value.copy(
            inputCurrency = _landingScreenState.value.currency1
        )
    }

    fun onCurrency1ValueChanged(currency1Value: String) {
        if(currency1Value.isEmpty()) {
            _landingScreenState.value = _landingScreenState.value.copy(
                currency1Value = "",
                currency2Value = ""
            )
        } else {
            _landingScreenState.value = _landingScreenState.value.copy(
                currency1Value = currency1Value,
                currency2Value = (currency1Value.toDouble() * getConversionFactor()).toString()
            )
        }
    }

    private fun getConversionFactor(): Double {
        val conversionFactor = 80.0
        return if(_landingScreenState.value.inputCurrency == CurrencyEnum.USD) {
            conversionFactor
        } else {
            (1/conversionFactor)
        }
    }

}