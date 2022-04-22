package chetu.second.batch.mvvmCleanArchitecture.presentation.di

import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(modules = [
    AppModule::class,
    NetModule::class,
    RemoteDataModule::class,
    LocalDataModule::class,
    CacheDataModule::class,
    DataBaseModule::class,
    UseCaseModule::class,
    RepositoryModule::class ])
interface AppComponent {
    fun movieSubComponent() : MovieSubComponent.Factory
}