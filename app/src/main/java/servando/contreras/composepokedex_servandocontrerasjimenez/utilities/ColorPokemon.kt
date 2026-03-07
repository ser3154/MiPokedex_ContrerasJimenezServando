package servando.contreras.composepokedex_servandocontrerasjimenez.utilities

import androidx.compose.ui.graphics.Color
import servando.contreras.composepokedex_servandocontrerasjimenez.domain.Pokemon
import servando.contreras.composepokedex_servandocontrerasjimenez.ui.theme.Bug
import servando.contreras.composepokedex_servandocontrerasjimenez.ui.theme.DarkGray
import servando.contreras.composepokedex_servandocontrerasjimenez.ui.theme.Dragon
import servando.contreras.composepokedex_servandocontrerasjimenez.ui.theme.Electric
import servando.contreras.composepokedex_servandocontrerasjimenez.ui.theme.Fairy
import servando.contreras.composepokedex_servandocontrerasjimenez.ui.theme.Fight
import servando.contreras.composepokedex_servandocontrerasjimenez.ui.theme.Fire
import servando.contreras.composepokedex_servandocontrerasjimenez.ui.theme.Flying
import servando.contreras.composepokedex_servandocontrerasjimenez.ui.theme.Ghost
import servando.contreras.composepokedex_servandocontrerasjimenez.ui.theme.Grass
import servando.contreras.composepokedex_servandocontrerasjimenez.ui.theme.Ground
import servando.contreras.composepokedex_servandocontrerasjimenez.ui.theme.Normal
import servando.contreras.composepokedex_servandocontrerasjimenez.ui.theme.OffWhite
import servando.contreras.composepokedex_servandocontrerasjimenez.ui.theme.Poison
import servando.contreras.composepokedex_servandocontrerasjimenez.ui.theme.Psych
import servando.contreras.composepokedex_servandocontrerasjimenez.ui.theme.Rock
import servando.contreras.composepokedex_servandocontrerasjimenez.ui.theme.Water


fun getColorType(pokemon: Pokemon): Pair<Color, Color> {
    var color: Color = Normal
    var dark = true
    var textColor: Color
    when {
        pokemon.type.lowercase().contains("normal") -> color = Normal;
        pokemon.type.lowercase().contains("electric") -> {
            color = Electric
            dark = false
        }

        pokemon.type.lowercase().contains("water") -> color = Water;

        pokemon.type.lowercase().contains("fire") -> color = Fire;
        pokemon.type.lowercase().contains("fairy") -> {
            color = Fairy
            dark = false
        }

        pokemon.type.lowercase().contains("psychic") -> color = Psych;
        pokemon.type.lowercase().contains("fight") -> color = Fight;
        pokemon.type.lowercase().contains("grass") -> color = Grass;
        pokemon.type.lowercase().contains("ghost") -> color = Ghost;
        pokemon.type.lowercase().contains("bug") -> color = Bug;
        pokemon.type.lowercase().contains("poison") -> color = Poison;
        pokemon.type.lowercase().contains("ground") -> color = Ground;
        pokemon.type.lowercase().contains("rock") -> color = Rock;
        pokemon.type.lowercase().contains("flying") -> {
            color = Flying
            dark = false
        }
        pokemon.type.lowercase().contains("dragon") -> color = Dragon;

    }

    return Pair(color, if (dark) OffWhite else DarkGray)
}