package com.ucne.edu.ticketsistemaretrofit.DI;

import com.squareup.moshi.Moshi;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;

@ScopeMetadata("javax.inject.Singleton")
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
public final class AppModule_ProvidesMoshiFactory implements Factory<Moshi> {
  @Override
  public Moshi get() {
    return providesMoshi();
  }

  public static AppModule_ProvidesMoshiFactory create() {
    return InstanceHolder.INSTANCE;
  }

  public static Moshi providesMoshi() {
    return Preconditions.checkNotNullFromProvides(AppModule.INSTANCE.providesMoshi());
  }

  private static final class InstanceHolder {
    private static final AppModule_ProvidesMoshiFactory INSTANCE = new AppModule_ProvidesMoshiFactory();
  }
}
