package servando.contreras.composepokedex_servandocontrerasjimenez.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import servando.contreras.composepokedex_servandocontrerasjimenez.ui.theme.ElectricYellow
import servando.contreras.composepokedex_servandocontrerasjimenez.R
import servando.contreras.composepokedex_servandocontrerasjimenez.ui.theme.ComposePokedex_ServandoContrerasJimenezTheme
import servando.contreras.composepokedex_servandocontrerasjimenez.ui.theme.Red
import servando.contreras.composepokedex_servandocontrerasjimenez.ui.theme.White

@Composable
fun LoginScreen(onLoginSuccess: () -> Unit, onGoToRegister: () -> Unit){
    var email    by remember { mutableStateOf("") }
    var password by remember {mutableStateOf("")  }
    var error by remember { mutableStateOf("") }

    Column (modifier = Modifier.fillMaxSize().background(ElectricYellow, RectangleShape).padding(24.dp), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center){
        Image(painter = painterResource(R.drawable.pokeball), contentDescription = "Logo", modifier = Modifier.size(120.dp), contentScale = ContentScale.Fit)
        Spacer(Modifier.height(16.dp))
        Text(text = "Pokedex", fontSize = 32.sp, fontWeight = FontWeight.Bold, color = Red)
        Spacer(Modifier.height(32.dp))

        OutlinedTextField(value = email, onValueChange = {email = it; error = ""}, label = {Text("Correo electronico")}, singleLine = true, modifier = Modifier.fillMaxWidth(), shape = RoundedCornerShape(12.dp), colors = OutlinedTextFieldDefaults.colors(focusedContainerColor = White, unfocusedContainerColor = White))
        Spacer(Modifier.height(12.dp))

        OutlinedTextField(value = password, onValueChange = {password = it; error = ""}, label = {Text("Contraseña")}, singleLine = true, modifier = Modifier.fillMaxWidth(), shape = RoundedCornerShape(12.dp), colors = OutlinedTextFieldDefaults.colors(focusedContainerColor = White, unfocusedContainerColor = White))
        if (error.isNotEmpty()){
            Spacer(Modifier.height(8.dp))
            Text(error, color = Red, fontSize = 13.sp)
        }

        Spacer(Modifier.height(24.dp))

        Button(
            onClick = {
                when{
                    email.isBlank() -> error = "Ingrese tu correo"
                    password.isBlank() -> error= "Ingrese su contraseña"
                    else -> onLoginSuccess()
                }
            },
            modifier = Modifier.fillMaxWidth().height(50.dp), shape = RoundedCornerShape(12.dp), colors = ButtonDefaults.buttonColors(contentColor = Red)) {
            Text("Ingresar", color = White, fontWeight = FontWeight.Bold)
        }
        Spacer(Modifier.height(16.dp))

        TextButton(onClick = onGoToRegister) {
            Text("¿No tienes cuenta? Registrate", color = Red)
        }
    }
}


@Preview
@Composable
fun LoginScreenPreview(){
    ComposePokedex_ServandoContrerasJimenezTheme {
        LoginScreen(onLoginSuccess = {}, onGoToRegister = {})
    }
}