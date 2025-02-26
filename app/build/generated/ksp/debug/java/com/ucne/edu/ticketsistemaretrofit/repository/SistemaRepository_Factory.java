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
public final class SistemaRepository_Factory implements Factory<SistemaRepository> {
  private final Provider<SistemaAPI> sistemaAPIProvider;

  public SistemaRepository_Factory(Provider<SistemaAPI> sistemaAPIProvider) {
    this.sistemaAPIProvider = sistemaAPIProvider;
  }

  @Override
  public SistemaRepository get() {
    return newInstance(sistemaAPIProvider.get());
  }

  public static SistemaRepository_Factory create(Provider<SistemaAPI> sistemaAPIProvider) {
    return new SistemaRepository_Factory(sistemaAPIProvider);
  }

  public static SistemaRepository newInstance(SistemaAPI sistemaAPI) {
    return new SistemaRepository(sistemaAPI);
  }
}
