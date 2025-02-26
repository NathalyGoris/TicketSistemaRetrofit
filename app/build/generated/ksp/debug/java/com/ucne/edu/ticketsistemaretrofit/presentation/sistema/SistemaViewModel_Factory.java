package com.ucne.edu.ticketsistemaretrofit.presentation.sistema;

import com.ucne.edu.ticketsistemaretrofit.repository.SistemaRepository;
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
public final class SistemaViewModel_Factory implements Factory<SistemaViewModel> {
  private final Provider<SistemaRepository> sistemaRepositoryProvider;

  public SistemaViewModel_Factory(Provider<SistemaRepository> sistemaRepositoryProvider) {
    this.sistemaRepositoryProvider = sistemaRepositoryProvider;
  }

  @Override
  public SistemaViewModel get() {
    return newInstance(sistemaRepositoryProvider.get());
  }

  public static SistemaViewModel_Factory create(
      Provider<SistemaRepository> sistemaRepositoryProvider) {
    return new SistemaViewModel_Factory(sistemaRepositoryProvider);
  }

  public static SistemaViewModel newInstance(SistemaRepository sistemaRepository) {
    return new SistemaViewModel(sistemaRepository);
  }
}
