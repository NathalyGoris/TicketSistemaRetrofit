package com.ucne.edu.ticketsistemaretrofit.presentation.sistema

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddSistemaScreen(
    goToBack: () -> Unit,
    viewModel: SistemaViewModel = hiltViewModel(),
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Crear Sistemas", color = MaterialTheme.colorScheme.onPrimary) },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary
                ),
                navigationIcon = {
                    IconButton(onClick = goToBack) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Volver",
                            tint = MaterialTheme.colorScheme.onPrimary
                        )
                    }
                }
            )
        }
    ) { paddingValues ->
        AddSistemaBodyScreen(
            uiState = uiState,
            goToBack = goToBack,
            onEvent = { event -> viewModel.onEvent(event) },
            modifier = Modifier.padding(paddingValues)
        )
    }
}

@Composable
fun AddSistemaBodyScreen(
    uiState: Uistate,
    goToBack: () -> Unit,
    onEvent: (SistemaEvent) -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.primaryContainer) // Fondo azul claro
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(20.dp))

            // Campo de texto "Nombre"
            OutlinedTextField(
                label = { Text(text = "Nombre") },
                value = uiState.nombreSistema ?: "",
                onValueChange = { onEvent(SistemaEvent.onChangeNombre(it)) },
                modifier = Modifier.fillMaxWidth(),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = MaterialTheme.colorScheme.primary,
                    unfocusedBorderColor = MaterialTheme.colorScheme.onSurfaceVariant,
                    focusedLabelColor = MaterialTheme.colorScheme.primary
                )
            )
            if (uiState.errorNombre.isNotEmpty()) {
                Text(text = uiState.errorNombre, color = Color.Red)
            }

            Spacer(modifier = Modifier.height(10.dp))

            // Campo de texto "Descripción"
            OutlinedTextField(
                label = { Text(text = "Descripción Sistema") },
                value = uiState.descripcionSistema,
                onValueChange = { onEvent(SistemaEvent.onChangeDescription(it)) },
                modifier = Modifier.fillMaxWidth(),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = MaterialTheme.colorScheme.primary,
                    unfocusedBorderColor = MaterialTheme.colorScheme.onSurfaceVariant,
                    focusedLabelColor = MaterialTheme.colorScheme.primary
                )
            )
            if (uiState.errorDescription.isNotEmpty()) {
                Text(text = uiState.errorDescription, color = Color.Red)
            }

            Spacer(modifier = Modifier.height(20.dp))

            // Botón de guardar con color primario
            Button(
                onClick = { onEvent(SistemaEvent.Save) },
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary)
            ) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "Guardar", tint = Color.White)
                Spacer(modifier = Modifier.width(8.dp))
                Text(text = "Guardar", color = Color.White)
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun PreviewAddSistemaScreen() {
    AddSistemaBodyScreen(
        uiState = Uistate(), // Proporcionamos un objeto Uistate vacío
        goToBack = {}, // Acción vacía para la navegación
        onEvent = {} // Evento vacío para evitar errores
    )
}

