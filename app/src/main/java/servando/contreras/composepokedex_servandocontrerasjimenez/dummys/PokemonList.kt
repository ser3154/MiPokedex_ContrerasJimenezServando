package servando.contreras.composepokedex_servandocontrerasjimenez.dummys

import servando.contreras.composepokedex_servandocontrerasjimenez.R
import servando.contreras.composepokedex_servandocontrerasjimenez.domain.Pokemon


val pokemonList = listOf(

    Pokemon(
        name = "Bulbasaur",
        number = 1,
        type = "grass/poison",
        description = "Un Pokémon que lleva una semilla en el lomo desde que nace.",
        height = 0.7f,
        weight = 6.9f,
        fav = true,
        ability = "Espesura",
        image = R.drawable.bulbasaur
    ),

    Pokemon(
        name = "Charmander",
        number = 4,
        type = "fire",
        description = "La llama de su cola indica su estado emocional.",
        height = 0.6f,
        weight = 8.5f,
        fav = false,
        ability = "Mar Llamas",
        image = R.drawable.charmander
    ),

    Pokemon(
        name = "Squirtle",
        number = 7,
        type = "water",
        description = "Se protege dentro de su caparazón y ataca con agua.",
        height = 0.5f,
        weight = 9.0f,
        fav = false,
        ability = "Torrente",
        image = R.drawable.squirtle
    ),

    Pokemon(
        name = "Gengar",
        number = 94,
        type = "ghost/poison",
        description = "Se oculta en las sombras y absorbe el calor de sus víctimas.",
        height = 1.5f,
        weight = 40.5f,
        fav = true,
        ability = "Levitación",
        image = R.drawable.gengar
    ),

    Pokemon(
        name = "Jigglypuff",
        number = 39,
        type = "normal/fairy",
        description = "Canta para dormir a sus oponentes.",
        height = 0.5f,
        weight = 5.5f,
        fav = false,
        ability = "Gran Encanto",
        image = R.drawable.jigglypuff
    ),

    Pokemon(
        name = "Meowth",
        number = 52,
        type = "normal",
        description = "Ama los objetos brillantes y las monedas.",
        height = 0.4f,
        weight = 4.2f,
        fav = false,
        ability = "Recogida",
        image = R.drawable.meowth
    ),

    Pokemon(
        name = "Psyduck",
        number = 54,
        type = "water",
        description = "Sufre constantes dolores de cabeza que liberan poderes psíquicos.",
        height = 0.8f,
        weight = 19.6f,
        fav = false,
        ability = "Humedad",
        image = R.drawable.psyduck
    ),

    Pokemon(
        name = "Machop",
        number = 66,
        type = "fight",
        description = "Entrena constantemente para fortalecer su cuerpo.",
        height = 0.8f,
        weight = 19.5f,
        fav = false,
        ability = "Agallas",
        image = R.drawable.machop
    ),

    Pokemon(
        name = "Geodude",
        number = 74,
        type = "rock/ground",
        description = "Se encuentra comúnmente en montañas y caminos.",
        height = 0.4f,
        weight = 20.0f,
        fav = false,
        ability = "Cabeza Roca",
        image = R.drawable.geodude
    ),

    Pokemon(
        name = "Eevee",
        number = 133,
        type = "normal",
        description = "Tiene un ADN inestable que le permite evolucionar de muchas formas.",
        height = 0.3f,
        weight = 6.5f,
        fav = true,
        ability = "Fuga",
        image = R.drawable.eevee
    )
)

fun showAllPokemons(): List<Pokemon>{
    return pokemonList
}

fun returnOnePokemon(): Pokemon{
    return pokemonList.get((0..9).random())
}

fun getPokemon(id:Int): Pokemon{
    return pokemonList.filter { pokemon -> pokemon.number == id }.get(0)
}