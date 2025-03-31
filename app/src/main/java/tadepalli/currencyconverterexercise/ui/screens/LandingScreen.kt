package tadepalli.currencyconverterexercise.ui.screens

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp

@Composable
fun LandingScreen(
    modifier: Modifier = Modifier,
    landingScreenViewModel: LandingScreenViewModel
) {
    val landingScreenState = landingScreenViewModel.landingScreenState.collectAsState()
    LandingScreenContent(
        modifier = modifier,
        currency1Name = landingScreenState.value.currency1.toString(),
        currency2Name = landingScreenState.value.currency2.toString(),
        currency1Value = landingScreenState.value.currency1Value,
        currency2Value = landingScreenState.value.currency2Value,
        onCurrency1ValueChanged = {
            landingScreenViewModel.onCurrency1ValueChanged(it)
        },
        onFlipClicked = {
            landingScreenViewModel.onFlipClicked()
        }
    )
}

@Composable
fun LandingScreenContent(
    modifier: Modifier = Modifier,
    currency1Name: String = "",
    currency2Name: String = "",
    currency1Value: String = "",
    currency2Value: String = "",
    onCurrency1ValueChanged: (String) -> Unit = {},
    onFlipClicked: () -> Unit
) {
    Column(
        modifier = modifier.padding(start = 16.dp, end = 16.dp, top = 16.dp, bottom = 16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        CurrencyNameAndTextField(
            currencyName = currency1Name,
            currencyValue = currency1Value,
            inputEnabled = true,
            onValueChange = {
                Log.d("CurrencyConverter", "$currency1Name value changed $it")
                onCurrency1ValueChanged(it)
            }
        )
        CurrencyNameAndTextField(
            currencyName = currency2Name,
            inputEnabled = false,
            currencyValue = currency2Value,
            onValueChange = {
            }
        )
        FlipAction(
            modifier = Modifier.fillMaxWidth(),
            onFlipClicked = {
                onFlipClicked()
            }
        )
    }
}


@Composable
fun CurrencyNameAndTextField(
    modifier: Modifier = Modifier,
    currencyName: String,
    currencyValue: String = "",
    inputEnabled: Boolean,
    onValueChange: (String) -> Unit,
) {
    //var textInput by remember { mutableStateOf(currencyValue) }
    Row(
        modifier = modifier,
    ) {
        Text(
            text = currencyName,
            modifier = Modifier.padding(top = 16.dp, end = 8.dp),
        )
        TextField(
            value = currencyValue,
            onValueChange = {
                //textInput = it
                onValueChange(it)
            },
            enabled = inputEnabled,
            singleLine = true,
            modifier = Modifier.padding(top = 16.dp, end = 8.dp, start = 8.dp, bottom = 8.dp),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
    }
}

@Composable
fun FlipAction(
    modifier: Modifier = Modifier,
    onFlipClicked: () -> Unit = {}
) {
    Row(
        modifier = modifier,
    ) {
        Button(
            modifier = Modifier.weight(1f).padding(all = 8.dp),
            onClick = {
                onFlipClicked()
            },
        ) {
            Text(text = "Flip Currency")
        }
    }
}