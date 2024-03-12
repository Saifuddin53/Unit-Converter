package com.myprojects.currencyconverter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.myprojects.currencyconverter.ui.theme.CurrencyConverterTheme
import kotlin.math.roundToInt

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CurrencyConverterTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    UnitConverter()
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun UnitConverter() {

    LocalContext.current

    var inputExpandedState by remember {
        mutableStateOf(false)
    }

    var outputExpandedState by remember {
        mutableStateOf(false)
    }

    var inputValue by remember {
        mutableStateOf("")
    }

    var outputValue by remember {
        mutableStateOf("")
    }
    
    var inputUnit by remember {
        mutableStateOf("Meters")
    }

    var outputUnit by remember {
        mutableStateOf("Meters")
    }

    val conversionFactor = remember {
        mutableStateOf(1.00)
    }

    val oConversionFactor = remember {
        mutableStateOf(1.00)
    }

    fun convertUnits() {
        val inputDoubleValue = inputValue.toDoubleOrNull() ?: 0.0

        val result = (inputDoubleValue * conversionFactor.value * 100 / oConversionFactor.value).roundToInt() / 100.00

        outputValue = result.toString()
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(36.dp, 20.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Unit Converter",
            fontSize = 24.sp)

        Spacer(modifier = Modifier.height(36.dp))

        OutlinedTextField(value = inputValue,
            onValueChange = {
                inputValue = it
                convertUnits()
            },
            label = {
                Text(text = "Enter value")
            })

        Spacer(modifier = Modifier.height(24.dp))

        Row {
            Box(modifier = Modifier) {
                Button(onClick = {
                    inputExpandedState = true
                }) {
                    Text(text = inputUnit)
                    Icon(
                        imageVector = Icons.Filled.ArrowDropDown,
                        contentDescription = ""
                    )
                }
                DropdownMenu(expanded = inputExpandedState, onDismissRequest = { inputExpandedState = false }) {
                    DropdownMenuItem(
                        text = {
                        Text(text = "Centimeters") },
                        onClick = {
                            inputUnit = "Centimeters"
                            inputExpandedState = false
                            conversionFactor.value = 0.01
                            convertUnits()
                        }
                    )
                    DropdownMenuItem(
                        text = {
                        Text(text = "Meters") },
                        onClick = {
                            inputUnit = "Meters"
                            inputExpandedState = false
                            conversionFactor.value = 1.0
                            convertUnits()
                        }
                    )
                    DropdownMenuItem(
                        text = {
                        Text(text = "Feet") },
                        onClick = {
                            inputUnit = "Feet"
                            inputExpandedState = false
                            conversionFactor.value = 0.3048
                            convertUnits()
                        }
                    )
                    DropdownMenuItem(
                        text = {
                        Text(text = "Millimeters") },
                        onClick = {
                            inputUnit = "Millimeters"
                            inputExpandedState = false
                            conversionFactor.value = 0.001
                            convertUnits()
                        }
                    )
                }
            }

            Spacer(modifier = Modifier.width(8.dp))

            Box(modifier = Modifier) {
                Button(onClick = { outputExpandedState = true }) {
                    Text(text = outputUnit)
                    Icon(imageVector = Icons.Filled.ArrowDropDown,
                        contentDescription = "")
                }
                DropdownMenu(expanded = outputExpandedState, onDismissRequest = { outputExpandedState = false }) {
                    DropdownMenuItem(
                        text = { Text(text = "Centimeters") },
                        onClick = {
                            outputUnit = "Centimeters"
                            outputExpandedState = false
                            oConversionFactor.value = 0.01
                            convertUnits()
                        }
                    )
                    DropdownMenuItem(
                        text = { Text(text = "Meters") },
                        onClick = {
                            outputUnit = "Meters"
                            outputExpandedState = false
                            oConversionFactor.value = 1.00
                            convertUnits()
                        }
                    )
                    DropdownMenuItem(
                        text = { Text(text = "Feet") },
                        onClick = {
                            outputUnit = "Feet"
                            outputExpandedState = false
                            oConversionFactor.value = 0.3048
                            convertUnits()
                        }
                    )
                    DropdownMenuItem(
                        text = { Text(text = "Millimeters") },
                        onClick = {
                            outputUnit = "Millimeters"
                            outputExpandedState = false
                            oConversionFactor.value = 0.001
                            convertUnits()
                        }
                    )
                }
            }
        }

        Text(text = "Result: $outputValue $outputUnit")
    }
}