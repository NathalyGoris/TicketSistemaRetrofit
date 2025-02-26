package com.ucne.edu.ticketsistemaretrofit.presentation.ticket

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.DatePicker
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Popup
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.ucne.edu.ticketsistemaretrofit.data.converter.Converter
import com.ucne.edu.ticketsistemaretrofit.presentation.components.InputSelect
import com.ucne.edu.ticketsistemaretrofit.presentation.sistema.AddSistemaScreen
import com.ucne.edu.ticketsistemaretrofit.presentation.sistema.ListSistemaBodyScreen
import kotlinx.coroutines.delay

@Composable
fun AddTicketScreen(
    goToBack: () -> Unit,
    viewModel: TicketViewModel = hiltViewModel(),
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    AddTicketBodyScreen(uiState, goToBack, { event -> viewModel.onEvent(event) })
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddTicketBodyScreen(
    uiState: Uistate,
    goToBack: () -> Unit,
    onEvent: (TicketEvent) -> Unit
) {
    var showDatePicker by remember { mutableStateOf(false) }
    val datePickerState = rememberDatePickerState()
    val convert = Converter()

    LaunchedEffect(datePickerState.selectedDateMillis) {
        datePickerState.selectedDateMillis?.let { selectedDateMillis ->
            val selectedDate = convert.convertToDate(selectedDateMillis)
            onEvent(TicketEvent.OnChangeDate(selectedDate))
            delay(300)
            showDatePicker = false
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.primaryContainer) // Fondo claro
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            Text(
                text = "Agregar Ticket",
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.onPrimaryContainer,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )

            Spacer(modifier = Modifier.height(20.dp))

            // **Encabezado de la tabla**
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(MaterialTheme.colorScheme.secondaryContainer)
                    .padding(8.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text("Asunto", style = MaterialTheme.typography.bodyLarge, modifier = Modifier.weight(1f))
                Text("Descripción", style = MaterialTheme.typography.bodyLarge, modifier = Modifier.weight(1f))
                Text("Fecha", style = MaterialTheme.typography.bodyLarge, modifier = Modifier.weight(1f))
                Text("Prioridad", style = MaterialTheme.typography.bodyLarge, modifier = Modifier.weight(1f))
                Text("Solicitado Por", style = MaterialTheme.typography.bodyLarge, modifier = Modifier.weight(1f))
            }

            Divider(color = Color.Gray, thickness = 1.dp)

            // **Campos de entrada**
            OutlinedTextField(
                label = { Text(text = "Asunto") },
                value = uiState.asunto,
                onValueChange = { onEvent(TicketEvent.OnChangeAsunto(it)) },
                modifier = Modifier.fillMaxWidth()
            )
            uiState.errorAsunto?.let { error ->
                Text(text = error, color = Color.Red)
            }

            OutlinedTextField(
                label = { Text(text = "Descripción") },
                value = uiState.descripcion,
                onValueChange = { onEvent(TicketEvent.OnChangeDescripcion(it)) },
                modifier = Modifier.fillMaxWidth()
            )
            uiState.errorDescripcion?.let { error ->
                Text(text = error, color = Color.Red)
            }

            OutlinedTextField(
                value = uiState.fecha,
                onValueChange = {},
                label = { Text("Fecha") },
                trailingIcon = {
                    IconButton(onClick = { showDatePicker = !showDatePicker }) {
                        Icon(
                            imageVector = Icons.Default.DateRange,
                            contentDescription = "Select date"
                        )
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(64.dp)
            )
            uiState.errorFecha?.let { error ->
                Text(text = error, color = Color.Red)
            }

            if (showDatePicker) {
                Popup(
                    onDismissRequest = { showDatePicker = false },
                    alignment = Alignment.TopStart
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .offset(y = 80.dp)
                            .shadow(elevation = 4.dp)
                            .background(MaterialTheme.colorScheme.surface)
                            .padding(16.dp)
                    ) {
                        DatePicker(
                            state = datePickerState,
                            showModeToggle = false
                        )
                    }
                }
            }

            // InputSelect for Prioridad
            InputSelect(
                label = "Selecciona una Prioridad",
                onOptionSelected = { onEvent(TicketEvent.OnChangeSistemaId(it)) }
            )
            uiState.errorSistemaId?.let { error ->
                Text(text = error, color = Color.Red)
            }

            OutlinedTextField(
                label = { Text(text = "Solicitado Por") },
                value = uiState.solicitadoPor,
                onValueChange = { onEvent(TicketEvent.OnChangeSolicitadoPor(it)) },
                modifier = Modifier.fillMaxWidth()
            )
            uiState.errorSolicitadoPor?.let { error ->
                Text(text = error, color = Color.Red)
            }

            Spacer(modifier = Modifier.height(10.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                OutlinedButton(onClick = { onEvent(TicketEvent.Save) }) {
                    Icon(imageVector = Icons.Default.Add, contentDescription = "Guardar")
                    Text(text = "Guardar")
                }
            }

        }

        FloatingActionButton(
            onClick = goToBack, modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(top = 10.dp, end = 20.dp, bottom = 35.dp)
        ) {
            Icon(
                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                contentDescription = "Volver"
            )
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun PreviewAddTicketBodyScreen() {
    AddTicketBodyScreen(
        uiState = Uistate(), // Proporcionamos un objeto Uistate vacío
        goToBack = {}, // Acción vacía para la navegación
        onEvent = {} // Evento vacío para evitar errores
    )
}
