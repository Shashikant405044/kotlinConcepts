package chetu.second.batch.mvvmCleanArchitecture.domain.useCases

import chetu.second.batch.mvvmCleanArchitecture.data.model.Movie
import chetu.second.batch.mvvmCleanArchitecture.domain.MovieRepository

class GetMovieUseCase(private val movieRepository: MovieRepository) {
    suspend fun getMovie() : List<Movie>{
        return movieRepository.getMovies()
    }
}