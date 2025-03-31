package tadepalli.currencyconverterexercise.ui.screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider


class LandingScreenViewModelFactory constructor(
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return LandingScreenViewModel() as T
    }
}