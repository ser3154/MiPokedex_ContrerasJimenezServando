package servando.contreras.composepokedex_servandocontrerasjimenez.navigations

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import servando.contreras.composepokedex_servandocontrerasjimenez.dummys.getPokemon
import servando.contreras.composepokedex_servandocontrerasjimenez.dummys.returnOnePokemon
import servando.contreras.composepokedex_servandocontrerasjimenez.dummys.showAllPokemons
import servando.contreras.composepokedex_servandocontrerasjimenez.screens.PokedexMenuScreen
import servando.contreras.composepokedex_servandocontrerasjimenez.screens.PokemonDetailScreen

@Composable
fun MyApp(){
    val navController = rememberNavController()
    NavHost(navController, startDestination = PokemonList){
        composable<PokemonList>{
            PokedexMenuScreen(showAllPokemons(), {id -> navController.navigate(route = PokemonDetail(id = id))})
        }
        composable < PokemonDetail>{ backStackEntry ->
            val pokemon: PokemonDetail = backStackEntry.toRoute()
            PokemonDetailScreen(getPokemon(pokemon.id))
        }
    }
}