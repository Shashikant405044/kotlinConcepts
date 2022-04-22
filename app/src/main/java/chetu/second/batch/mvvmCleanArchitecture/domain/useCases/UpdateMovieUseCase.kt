package chetu.second.batch.mvvmCleanArchitecture.domain.useCases

import chetu.second.batch.mvvmCleanArchitecture.data.model.Movie
import chetu.second.batch.mvvmCleanArchitecture.domain.MovieRepository

class UpdateMovieUseCase(private val movieRepository: MovieRepository) {
    suspend fun execute() : List<Movie>{
        return movieRepository.updateMovie()
    }
}