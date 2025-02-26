package com.ucne.edu.ticketsistemaretrofit.presentation.ticket;

import com.ucne.edu.ticketsistemaretrofit.repository.TicketRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata
@QualifierMetadata
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava",
    "cast"
})
public final class TicketViewModel_Factory implements Factory<TicketViewModel> {
  private final Provider<TicketRepository> ticketRepositoryProvider;

  public TicketViewModel_Factory(Provider<TicketRepository> ticketRepositoryProvider) {
    this.ticketRepositoryProvider = ticketRepositoryProvider;
  }

  @Override
  public TicketViewModel get() {
    return newInstance(ticketRepositoryProvider.get());
  }

  public static TicketViewModel_Factory create(
      Provider<TicketRepository> ticketRepositoryProvider) {
    return new TicketViewModel_Factory(ticketRepositoryProvider);
  }

  public static TicketViewModel newInstance(TicketRepository ticketRepository) {
    return new TicketViewModel(ticketRepository);
  }
}
