package chetu.second.batch.mvvmCleanArchitecture.presentation.di

import android.content.Context
import androidx.room.Room
import chetu.second.batch.mvvmCleanArchitecture.data.db.MovieDao
import chetu.second.batch.mvvmCleanArchitecture.data.db.MovieDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataBaseModule {
    @Singleton
    @Provides
    fun provideMovieDatabase(context : Context) : MovieDatabase{
        return Room.databaseBuilder(context, MovieDatabase::class.java, "tmdb_client").build()
    }

    @Singleton
    @Provides
    fun provideMovieDao(movieDatabase : MovieDatabase) : MovieDao{
        return movieDatabase.dao
    }

}