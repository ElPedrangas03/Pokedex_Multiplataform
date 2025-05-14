package com.example.pokedex.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.pokedex.api.PokemonUI

@Composable
fun PokemonCard(pokemon: PokemonUI) {
    Column(
        modifier = Modifier.padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "#${pokemon.number} ${pokemon.name}", style = MaterialTheme.typography.headlineSmall)
        AsyncImage(model = pokemon.imageUrl, contentDescription = pokemon.name)
        Row(horizontalArrangement = Arrangement.spacedBy(35.dp)){
            pokemon.types.forEach { type ->
                TypeChip(type.name, type.imageUrl)
            }
        }
        Text(text = pokemon.description, style = MaterialTheme.typography.bodyLarge)
    }
}

@Composable
fun TypeChip(typeName: String, iconUrl: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(start=4.dp, end=4.dp)
    ) {
        AsyncImage(
            model = iconUrl,
            contentDescription = typeName,
            modifier = Modifier
                .size(80.dp) // Tamaño de layout visible
                .graphicsLayer(
                    scaleX = 1.5f, // Escalado visual
                    scaleY = 1.5f
                )
        )
    }
}