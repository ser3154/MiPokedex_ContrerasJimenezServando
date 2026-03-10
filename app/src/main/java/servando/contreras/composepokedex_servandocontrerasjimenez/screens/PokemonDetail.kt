package servando.contreras.composepokedex_servandocontrerasjimenez.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import servando.contreras.composepokedex_servandocontrerasjimenez.compose.PokemonHeader
import servando.contreras.composepokedex_servandocontrerasjimenez.R
import servando.contreras.composepokedex_servandocontrerasjimenez.compose.Ability
import servando.contreras.composepokedex_servandocontrerasjimenez.compose.Chip
import servando.contreras.composepokedex_servandocontrerasjimenez.compose.PokemonNavButton
import servando.contreras.composepokedex_servandocontrerasjimenez.domain.Pokemon
import servando.contreras.composepokedex_servandocontrerasjimenez.dummys.getPokemon
import servando.contreras.composepokedex_servandocontrerasjimenez.navigations.PokemonDetail
import servando.contreras.composepokedex_servandocontrerasjimenez.pokemon
import servando.contreras.composepokedex_servandocontrerasjimenez.ui.theme.ComposePokedex_ServandoContrerasJimenezTheme
import servando.contreras.composepokedex_servandocontrerasjimenez.ui.theme.ElectricYellow
import servando.contreras.composepokedex_servandocontrerasjimenez.ui.theme.Red
import servando.contreras.composepokedex_servandocontrerasjimenez.ui.theme.White


@Composable
fun PokemonCard(pokemon: Pokemon, prevPokemon: Pokemon?, nextPokemon: Pokemon?, onNavigate: (id: Int) -> Unit){
    Box(contentAlignment = Alignment.TopCenter){
        Image(painter = painterResource(pokemon.image), contentDescription = pokemon.name, modifier = Modifier.offset(0.dp, -80.dp).zIndex(2f).size(130.dp), contentScale = ContentScale.Fit)
        Card(modifier = Modifier.fillMaxWidth().fillMaxHeight(), elevation = CardDefaults.cardElevation(defaultElevation = 6.dp), colors = CardDefaults.cardColors(contentColor = White)) {
            LazyColumn(modifier = Modifier.fillMaxWidth().background(color = White), contentPadding = PaddingValues(bottom = 16.dp)) {
                item { Chip(pokemon.type, ElectricYellow, Modifier.padding(top = 70.dp).align(Alignment.CenterHorizontally)) }
                item {
                    Row (modifier = Modifier.fillMaxWidth(0.8f).padding(top = 15.dp).align ( Alignment.CenterHorizontally ), horizontalArrangement = Arrangement.SpaceEvenly){
                        Column {
                            Ability("row", label = "Altura", value = "${pokemon.height} m")
                            Ability("row", label = "Peso", value = "${pokemon.weight} kg")
                        }
                        Ability("column", label = "Habilidad", value = pokemon.ability)
                    }
                }
                item {
                    Row (Modifier.fillMaxWidth(0.8f).padding(25.dp)){
                        Text(pokemon.description, textAlign = TextAlign.Center)
                    }
                }
                if (pokemon.evolutions.isNotEmpty()){
                    item {
                        Text(text = "Evoluciones", fontWeight = FontWeight.Bold, fontSize = 16.sp, color = Red, modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp, vertical = 8.dp))
                    }
                    items(pokemon.evolutions) { evo ->
                        EvolutionItem(evo, onNavigate)
                    }
                }
                item {
                    Spacer(Modifier.height(16.dp))
                    Row (modifier = Modifier.fillMaxWidth().padding(horizontal = 8.dp), horizontalArrangement = Arrangement.SpaceBetween){
                        if (prevPokemon!= null){
                            Box(modifier = Modifier.clickable{onNavigate(prevPokemon.number)}){
                                PokemonNavButton(position = "left", image = prevPokemon.image, name = prevPokemon.name, number = prevPokemon.number)
                            }
                        }else {
                            Spacer(Modifier.width(1.dp))
                        }
                        if (nextPokemon != null){
                            Box(modifier = Modifier.clickable{onNavigate(nextPokemon.number)}){
                                PokemonNavButton(position = "right", image = nextPokemon.image, name = nextPokemon.name, number = nextPokemon.number)
                            }
                        }else{
                            Spacer(Modifier.width(1.dp))
                        }
                    }
                }
            }
        }
    }
}


@Composable
fun EvolutionItem(evo: Pokemon, onNavigate: (Int) -> Unit){
    Row (modifier = Modifier.fillMaxWidth().clickable{onNavigate(evo.number)}.padding(horizontal = 16.dp, vertical = 4.dp), verticalAlignment = Alignment.CenterVertically){
        Image(painter = painterResource(evo.image), contentDescription = evo.name, modifier = Modifier.size(56.dp), contentScale = ContentScale.Fit)
        Spacer(Modifier.width(12.dp))
        Text(text = evo.name, fontSize = 14.sp, fontWeight = FontWeight.Medium)
        Spacer(Modifier.weight(1f))
        Text(text = "#${evo.number.toString().padStart(4, '0')}", fontSize = 12.sp, color = Red)
    }
}

@Composable
fun PokemonDetailScreen(pokemon: Pokemon, prevPokemon: Pokemon? = null, nextPokemon: Pokemon? = null, onNavigate: (Int) -> Unit, modifier: Modifier = Modifier){
    Column(Modifier.background(ElectricYellow, RectangleShape)) {
        PokemonHeader(pokemon.name, pokemon.number, pokemon.fav)
        PokemonCard(pokemon = pokemon, prevPokemon = prevPokemon, nextPokemon = nextPokemon, onNavigate = onNavigate)
    }
}

@Preview
@Composable
fun PokemonDetailScreenPreview(){
    ComposePokedex_ServandoContrerasJimenezTheme {
        val bulbasaur = getPokemon(1) ?: return@ComposePokedex_ServandoContrerasJimenezTheme
        PokemonDetailScreen(
            pokemon     = bulbasaur,
            prevPokemon = null,
            nextPokemon = getPokemon(4),
            onNavigate  = {})
    }
}
