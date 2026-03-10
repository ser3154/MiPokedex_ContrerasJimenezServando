package servando.contreras.composepokedex_servandocontrerasjimenez.navigations

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import servando.contreras.composepokedex_servandocontrerasjimenez.dummys.getNeighbors
import servando.contreras.composepokedex_servandocontrerasjimenez.dummys.getPokemon
import servando.contreras.composepokedex_servandocontrerasjimenez.dummys.returnOnePokemon
import servando.contreras.composepokedex_servandocontrerasjimenez.dummys.showAllPokemons
import servando.contreras.composepokedex_servandocontrerasjimenez.screens.LoginScreen
import servando.contreras.composepokedex_servandocontrerasjimenez.screens.PokedexMenuScreen
import servando.contreras.composepokedex_servandocontrerasjimenez.screens.PokemonDetailScreen
import servando.contreras.composepokedex_servandocontrerasjimenez.screens.RegistrerScreen

@Composable
fun MyApp(){
    val navController = rememberNavController()
    NavHost(navController, startDestination = Login){

        composable<Login>{
            LoginScreen(onLoginSuccess = { navController.navigate(PokemonList){
                popUpTo(Login){inclusive = true}
            }
            },
                onGoToRegister = {navController.navigate(Register)}
            )
        }
        composable <Register>{
            RegistrerScreen(onRegisterSuccess = {navController.navigate(PokemonList){
                popUpTo(Login){inclusive = true}
            }
            },
                onGoToLogin = {navController.popBackStack()}
            )
        }
        composable<PokemonList>{
            PokedexMenuScreen(showAllPokemons(), {id -> navController.navigate(route = PokemonDetail(id = id))})
        }
        composable < PokemonDetail>{ backStackEntry ->
            val route: PokemonDetail = backStackEntry.toRoute()
            val pokemon = getPokemon(route.id)
            if (pokemon == null){
                navController.popBackStack()
                return@composable
            }
            val (prev, next) = getNeighbors(route.id)

            PokemonDetailScreen(
                pokemon = pokemon,
                prevPokemon = prev,
                nextPokemon = next,
                onNavigate = {id ->
                    navController.navigate(PokemonDetail(id = id)){
                        popUpTo<PokemonDetail> { inclusive = true}
                    }
                }
            )
        }
    }
}