package com.myprojects.currencyconverter

import android.graphics.drawable.Icon
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.border
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
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.myprojects.currencyconverter.ui.theme.CurrencyConverterTheme

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

    val context = LocalContext.current

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
        mutableStateOf("Centimeters")
    }

    var outputUnit by remember {
        mutableStateOf("Meters")
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(36.dp, 20.dp)
            .border(1.dp, Color.Gray),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Unit Converter",
            fontSize = 24.sp)

        Spacer(modifier = Modifier.height(36.dp))

        OutlinedTextField(value = "Enter value",
            onValueChange = {
                inputValue = it
            })

        Spacer(modifier = Modifier.height(24.dp))

        Row {
            Box(modifier = Modifier) {
                Button(onClick = {
                    expandedState = !(expandedState);
                }) {
                    Text(text = "Centimeters")
                    Icon(
                        imageVector = Icons.Filled.ArrowDropDown,
                        contentDescription = ""
                    )
                }
                DropdownMenu(expanded = expandedState, onDismissRequest = { /*TODO*/ }) {
                    DropdownMenuItem(text = { Text(text = "Centimeters") }, onClick = { /*TODO*/ })
                    DropdownMenuItem(text = { Text(text = "Meters") }, onClick = { /*TODO*/ })
                    DropdownMenuItem(text = { Text(text = "Feet") }, onClick = { /*TODO*/ })
                    DropdownMenuItem(text = { Text(text = "Millimeters") }, onClick = { /*TODO*/ })
                }
            }

            Spacer(modifier = Modifier.width(8.dp))

            Box(modifier = Modifier) {
                Button(onClick = { /*TODO*/ }) {
                    Text(text = "Meters")
                    Icon(imageVector = Icons.Filled.ArrowDropDown,
                        contentDescription = "")
                }
                DropdownMenu(expanded = false, onDismissRequest = { /*TODO*/ }) {
                    DropdownMenuItem(text = { Text(text = "Centimeters") }, onClick = { /*TODO*/ })
                    DropdownMenuItem(text = { Text(text = "Meters") }, onClick = { /*TODO*/ })
                    DropdownMenuItem(text = { Text(text = "Feet") }, onClick = { /*TODO*/ })
                    DropdownMenuItem(text = { Text(text = "Millimeters") }, onClick = { /*TODO*/ })
                }
            }
        }

        Text(text = "Result: Meters")
    }
}