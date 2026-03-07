package servando.contreras.composepokedex_servandocontrerasjimenez

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import servando.contreras.composepokedex_servandocontrerasjimenez.screens.PokemonDetailScreen
import servando.contreras.composepokedex_servandocontrerasjimenez.compose.Ability
import servando.contreras.composepokedex_servandocontrerasjimenez.compose.Chip
import servando.contreras.composepokedex_servandocontrerasjimenez.compose.PokemonNavButton
import servando.contreras.composepokedex_servandocontrerasjimenez.domain.Pokemon
import servando.contreras.composepokedex_servandocontrerasjimenez.navigations.MyApp
import servando.contreras.composepokedex_servandocontrerasjimenez.ui.theme.ComposePokedex_ServandoContrerasJimenezTheme
import servando.contreras.composepokedex_servandocontrerasjimenez.ui.theme.ElectricYellow
import servando.contreras.composepokedex_servandocontrerasjimenez.ui.theme.White

val pokemon = Pokemon(
    name = "Pikachu",
    number = 25,
    type = "Electrico",
    description = "SDASDASDASD.",
    height = 0.4f,
    weight = 6.0f,
    fav = true,
    ability = "Estatica",
    image = R.drawable.pikachu
)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposePokedex_ServandoContrerasJimenezTheme {
                MyApp()
                }
            }
        }
    }



