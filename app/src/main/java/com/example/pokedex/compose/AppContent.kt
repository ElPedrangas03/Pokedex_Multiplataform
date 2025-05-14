package com.example.pokedex.compose

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.*
import androidx.compose.runtime.*
import com.example.pokedex.api.fetchPokemon
import com.example.pokedex.api.PokemonUI
import kotlinx.coroutines.launch
import androidx.compose.foundation.layout.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun AppContent() {
    val scope = rememberCoroutineScope()
    var pokemon by remember { mutableStateOf<PokemonUI?>(null) }

    LaunchedEffect(Unit) {
        pokemon = fetchPokemon((1..1000).random())
    }

    MaterialTheme {
        val scope = rememberCoroutineScope()

        Scaffold { innerPadding ->
            Column(
                modifier = Modifier
                    .padding(innerPadding)
                    .fillMaxSize()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                pokemon?.let {
                    PokemonCard(pokemon = it)
                    Spacer(modifier = Modifier.height(24.dp)) // espacio entre tarjeta y botón

                    Button(onClick = {
                        scope.launch {
                            pokemon = fetchPokemon((1..1000).random())
                        }
                    }) {
                        Text("Consultar nuevo Pokémon")
                    }
                }
            }
        }
    }
}