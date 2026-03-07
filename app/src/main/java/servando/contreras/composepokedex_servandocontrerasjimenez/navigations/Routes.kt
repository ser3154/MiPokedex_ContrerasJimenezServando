package servando.contreras.composepokedex_servandocontrerasjimenez.navigations

import kotlinx.serialization.Serializable


@Serializable
object PokemonList;

@Serializable
data class PokemonDetail(val id: Int)