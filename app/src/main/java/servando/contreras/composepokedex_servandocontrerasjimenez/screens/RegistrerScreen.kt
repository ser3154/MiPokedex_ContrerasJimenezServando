package servando.contreras.composepokedex_servandocontrerasjimenez.screens

import android.view.RoundedCorner
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import servando.contreras.composepokedex_servandocontrerasjimenez.R
import servando.contreras.composepokedex_servandocontrerasjimenez.ui.theme.ComposePokedex_ServandoContrerasJimenezTheme
import servando.contreras.composepokedex_servandocontrerasjimenez.ui.theme.ElectricYellow
import servando.contreras.composepokedex_servandocontrerasjimenez.ui.theme.Red
import servando.contreras.composepokedex_servandocontrerasjimenez.ui.theme.White

@Composable
fun RegistrerScreen(onRegisterSuccess: () -> Unit, onGoToLogin: () -> Unit){
    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var password2 by remember { mutableStateOf("") }
    var error by remember { mutableStateOf("") }

    Column(modifier = Modifier.fillMaxSize().background(ElectricYellow, RectangleShape).padding(24.dp), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
        Image(painter = painterResource(R.drawable.pokeball), contentDescription = "logo", modifier = Modifier.size(100.dp), contentScale = ContentScale.Fit)
        Spacer(Modifier.height(12.dp))

        OutlinedTextField(value = name, onValueChange = {name; error = ""}, label = {Text("Nombre")},  singleLine = true, modifier = Modifier.fillMaxWidth(), shape = RoundedCornerShape(12.dp), colors = OutlinedTextFieldDefaults.colors(focusedContainerColor = White, unfocusedContainerColor = White))
        Spacer(Modifier.height(10.dp))

        OutlinedTextField(value = email, onValueChange = {email; error = ""},label = {Text("Correo")}, singleLine = true, modifier = Modifier.fillMaxWidth(), shape = RoundedCornerShape(12.dp), colors = OutlinedTextFieldDefaults.colors(focusedContainerColor = White, unfocusedContainerColor = White))
        Spacer(Modifier.height(10.dp))

        OutlinedTextField(value = password, onValueChange = {password; error = ""}, label = {Text("Contraseña")}, singleLine = true, modifier = Modifier.fillMaxWidth(), shape = RoundedCornerShape(12.dp), colors = OutlinedTextFieldDefaults.colors(focusedContainerColor = White, unfocusedContainerColor = White))
        Spacer(Modifier.height(10.dp))

        OutlinedTextField(value = password2, onValueChange = {password2; error = ""}, label = {Text("Confirmar contraseña")},singleLine = true, modifier = Modifier.fillMaxWidth(), shape = RoundedCornerShape(12.dp), colors = OutlinedTextFieldDefaults.colors(focusedContainerColor = White, unfocusedContainerColor = White))
        Spacer(Modifier.height(10.dp))

        if (error.isNotEmpty()){
            Spacer(Modifier.height(8.dp))
            Text(error, color = Red, fontSize = 13.sp)
        }
        Spacer(Modifier.height(24.dp))

        Button(onClick = {
            when{
                name.isBlank()   -> error = "Ingresa tu nombre"
                email.isBlank()  -> error = "Ingresa tu contraseña"
                password.isBlank() -> error = "Ingresa una contraseña"
                password != password2 -> error = "Las contraseñas no cinciden"
                else              -> onRegisterSuccess()
            }
        }, modifier = Modifier.fillMaxWidth().height(50.dp), shape = RoundedCornerShape(12.dp), colors = ButtonDefaults.buttonColors(contentColor = Red)) {
            Text("Registrarse", color = White, fontWeight = FontWeight.Bold)
        }
    }
    Spacer(Modifier.height(16.dp))

    TextButton(onClick = onGoToLogin) {
        Text("¿Ya tienes cuenta? Inicia sesion", color = Red)
    }
}

@Preview
@Composable
fun RegisterScreenPreview(){
    ComposePokedex_ServandoContrerasJimenezTheme {
        RegistrerScreen(onRegisterSuccess = {}, onGoToLogin = {})
    }
}