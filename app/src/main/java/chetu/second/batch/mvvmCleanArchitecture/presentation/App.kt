package chetu.second.batch.mvvmCleanArchitecture.presentation

import android.app.Application
import chetu.second.batch.kotlinconcepts.BuildConfig
import chetu.second.batch.mvvmCleanArchitecture.presentation.di.*

class App : Application(), Injector {
    private lateinit var appComponent : AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(applicationContext))
            .netModule(NetModule(BuildConfig.BASE_URL))
            .remoteDataModule(RemoteDataModule(BuildConfig.api_key))
            .build()

    }

    override fun createMovieSubComponent(): MovieSubComponent {
        return appComponent.movieSubComponent().create()
    }
}