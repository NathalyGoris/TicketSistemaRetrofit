package com.ucne.edu.ticketsistemaretrofit.presentation.ticket

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
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
import com.ucne.edu.ticketsistemaretrofit.data.remote.dto.TicketDto
import com.ucne.edu.ticketsistemaretrofit.presentation.sistema.SistemaViewModel

@Composable
fun ListTicketScreen(
    goToAdd: () -> Unit,
    onSelect: (Int) -> Unit,
    viewModel: TicketViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    ListTicketBodyScreen(uiState, goToAdd, onSelect)
}

@Composable
fun ListTicketBodyScreen(
    uiState: Uistate,
    goToAdd: () -> Unit,
    onSelect: (Int) -> Unit,
    viewModel: SistemaViewModel = hiltViewModel()
) {
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = goToAdd,
                containerColor = MaterialTheme.colorScheme.primary
            ) {
                Icon(imageVector = Icons.Filled.Add, contentDescription = "Agregar Ticket")
            }
        }
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.primaryContainer) // Fondo azul claro
                .padding(paddingValues)
                .padding(16.dp)
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Lista de Tickets",
                    style = MaterialTheme.typography.titleLarge,
                    color = MaterialTheme.colorScheme.onPrimaryContainer
                )

                Spacer(modifier = Modifier.height(16.dp))

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
                    Text("Sistema", style = MaterialTheme.typography.bodyLarge, modifier = Modifier.weight(1f))
                    Text("Solicitado Por", style = MaterialTheme.typography.bodyLarge, modifier = Modifier.weight(1f))
                }

                Divider(color = Color.Gray, thickness = 1.dp)

                // **Lista de datos**
                LazyColumn(modifier = Modifier.fillMaxSize()) {
                    items(uiState.tickets) { ticket ->
                        TicketRow(ticket, onSelect, viewModel)
                    }
                }
            }
        }
    }
}

@Composable
fun TicketRow(ticket: TicketDto, onSelect: (Int) -> Unit, viewModel: SistemaViewModel) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
            .clickable { onSelect(ticket.ticketId ?: 0) }
            .border(1.dp, Color.Gray, RoundedCornerShape(8.dp)),
        shape = RoundedCornerShape(8.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(ticket.asunto ?: "", style = MaterialTheme.typography.bodyMedium, modifier = Modifier.weight(1f))
            Text(ticket.descripcion ?: "", style = MaterialTheme.typography.bodyMedium, modifier = Modifier.weight(1f))
            Text(ticket.fecha ?: "", style = MaterialTheme.typography.bodyMedium, modifier = Modifier.weight(1f))
            Text(viewModel.getDescripcionById(ticket.sistemaId ?: 0), style = MaterialTheme.typography.bodyMedium, modifier = Modifier.weight(1f))
            Text(ticket.solicitadoPor ?: "", style = MaterialTheme.typography.bodyMedium, modifier = Modifier.weight(1f))
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun PreviewListTicketBodyScreen() {
    ListTicketBodyScreen(Uistate(), goToAdd = {}, onSelect = {})
}
