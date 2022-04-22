package chetu.second.batch.mvvmCleanArchitecture.data.model


import com.google.gson.annotations.SerializedName

data class MovieList(
    @SerializedName("results")
    val movie : List<Movie>
)