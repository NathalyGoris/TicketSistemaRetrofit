package com.ucne.edu.ticketsistemaretrofit.repository;

import com.ucne.edu.ticketsistemaretrofit.data.remote.SistemaAPI;
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
public final class TicketRepository_Factory implements Factory<TicketRepository> {
  private final Provider<SistemaAPI> sistemaAPIProvider;

  public TicketRepository_Factory(Provider<SistemaAPI> sistemaAPIProvider) {
    this.sistemaAPIProvider = sistemaAPIProvider;
  }

  @Override
  public TicketRepository get() {
    return newInstance(sistemaAPIProvider.get());
  }

  public static TicketRepository_Factory create(Provider<SistemaAPI> sistemaAPIProvider) {
    return new TicketRepository_Factory(sistemaAPIProvider);
  }

  public static TicketRepository newInstance(SistemaAPI sistemaAPI) {
    return new TicketRepository(sistemaAPI);
  }
}
