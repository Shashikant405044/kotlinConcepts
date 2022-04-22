package chetu.second.batch.mvvmCleanArchitecture.presentation

import chetu.second.batch.mvvmCleanArchitecture.presentation.di.MovieSubComponent


interface Injector {
    fun createMovieSubComponent() : MovieSubComponent
}