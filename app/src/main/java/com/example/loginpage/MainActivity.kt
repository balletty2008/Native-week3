package com.example.loginpage

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.loginpage.ui.theme.LoginPageTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LoginPage(applicationContext)

        }
    }
}

@Composable
fun LoginPage(context: Context) {
    var email by remember{ mutableStateOf("")}
    var password by remember{ mutableStateOf("")}

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Login",
            fontFamily = FontFamily.Monospace,
            textAlign = TextAlign.Left,
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            color = Color(138,43,226),
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 20.dp)
        )
        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Username") },
            trailingIcon = {
                Icon(Icons.Default.Email, contentDescription = "email")
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 10.dp, top = 10.dp)
        )

        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Password") },
            trailingIcon = {                          //leadingIcon:start, trailingIcon:end
                Icon(Icons.Default.Lock, contentDescription = "password")
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 10.dp, top = 10.dp),
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
        )

        OutlinedButton(
            onClick = { logged(email, password, context) },
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color(138,43,226),
                //backgroundColor = Color(9400D3),
                contentColor = Color.White
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 10.dp, top = 10.dp),

        ) {
            Text(
                text = "Submit",
                fontSize = 20.sp,
                textAlign = TextAlign.Center
            )
        }
    }
}

fun logged(email: String, password: String, context: Context) {
    if (email == "k8chhu00@students.oamk.fi" && password == "123456") {
        Toast.makeText(context, "Logged In Successfully", Toast.LENGTH_SHORT).show()

    } else {
        Toast.makeText(context, "Logged In Failed", Toast.LENGTH_SHORT).show()
    }
}
