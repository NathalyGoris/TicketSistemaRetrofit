package com.ucne.edu.ticketsistemaretrofit.DI;

import com.ucne.edu.ticketsistemaretrofit.data.remote.SistemaAPI;
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
public final class AppModule_ProvideSistemaApiFactory implements Factory<SistemaAPI> {
  @Override
  public SistemaAPI get() {
    return provideSistemaApi();
  }

  public static AppModule_ProvideSistemaApiFactory create() {
    return InstanceHolder.INSTANCE;
  }

  public static SistemaAPI provideSistemaApi() {
    return Preconditions.checkNotNullFromProvides(AppModule.INSTANCE.provideSistemaApi());
  }

  private static final class InstanceHolder {
    private static final AppModule_ProvideSistemaApiFactory INSTANCE = new AppModule_ProvideSistemaApiFactory();
  }
}
