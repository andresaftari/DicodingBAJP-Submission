package com.andresaftari.submissionfinal.data.remote

import androidx.lifecycle.LiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.andresaftari.submissionfinal.data.local.LocalDataSource
import com.andresaftari.submissionfinal.data.local.NetworkBounds
import com.andresaftari.submissionfinal.data.local.entity.Movie
import com.andresaftari.submissionfinal.data.local.entity.MovieDetail
import com.andresaftari.submissionfinal.data.local.entity.Show
import com.andresaftari.submissionfinal.data.local.entity.ShowDetail
import com.andresaftari.submissionfinal.data.remote.dataSource.RemoteDataSource
import com.andresaftari.submissionfinal.data.remote.response.DataResponse
import com.andresaftari.submissionfinal.utils.loader.LoadDataSource
import com.andresaftari.submissionfinal.utils.executor.AppExecutor
import com.andresaftari.submissionfinal.vo.Resource

class DataRepository private constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val appExecutor: AppExecutor
) : LoadDataSource {

    companion object {
        @Volatile
        var instance: DataRepository? = null

        fun getInstance(
            remoteDataSource: RemoteDataSource,
            localDataSource: LocalDataSource,
            appExecutor: AppExecutor
        ): DataRepository =
            instance ?: synchronized(this) {
                instance ?: DataRepository(remoteDataSource, localDataSource, appExecutor)
            }
    }

    // Movie
    override fun getAllMovies(): LiveData<Resource<PagedList<Movie>>> =
        object : NetworkBounds<PagedList<Movie>, List<DataResponse>>(appExecutor) {
            override fun loadFromDB(): LiveData<PagedList<Movie>> {
                val config = PagedList.Config.Builder()
                    .setEnablePlaceholders(false)
                    .setInitialLoadSizeHint(5)
                    .setPageSize(5)
                    .build()

                return LivePagedListBuilder(localDataSource.getAllMovies(), config).build()
            }

            override fun shouldFetch(data: PagedList<Movie>?): Boolean =
                data == null || data.isEmpty()

            override fun createCall(): LiveData<ApiResponse<List<DataResponse>>> =
                remoteDataSource.getAllMovies()

            override fun saveCallResult(data: List<DataResponse>) {
                val list = ArrayList<Movie>()

                for (response in data) {
                    val movie = Movie(
                        response.id,
                        response.title,
                        response.genre,
                        response.description,
                        response.imagePath,
                        false
                    )
                    list.add(movie)
                }
                localDataSource.insertMovie(list)
            }
        }.asLiveData()

    override fun getFavoritedMovie(): LiveData<PagedList<Movie>> {
        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setInitialLoadSizeHint(5)
            .setPageSize(5)
            .build()

        return LivePagedListBuilder(localDataSource.getFavoritedMovies(), config).build()
    }

    override fun getDetailMovies(movieId: String): LiveData<Resource<MovieDetail>> =
        object : NetworkBounds<MovieDetail, List<DataResponse>>(appExecutor) {
            override fun loadFromDB(): LiveData<MovieDetail> =
                localDataSource.getMovieDetail(movieId)

            override fun shouldFetch(data: MovieDetail?): Boolean =
                data?.details == null || data.details.description.isEmpty()

            override fun createCall(): LiveData<ApiResponse<List<DataResponse>>> =
                remoteDataSource.getAllMovies()

            override fun saveCallResult(data: List<DataResponse>) {
                val list = ArrayList<Movie>()

                for (response in data) {
                    val movie = Movie(
                        response.id,
                        response.title,
                        response.genre,
                        response.description,
                        response.imagePath,
                        false
                    )
                    list.add(movie)
                }
                localDataSource.insertMovie(list)
            }
        }.asLiveData()

    override fun setMovieFavorited(movie: Movie, state: Boolean) =
        appExecutor.diskIO().execute { localDataSource.setFavoritedMovie(movie, state) }

    // Show
    override fun getAllShows(): LiveData<Resource<PagedList<Show>>> =
        object : NetworkBounds<PagedList<Show>, List<DataResponse>>(appExecutor) {
            override fun loadFromDB(): LiveData<PagedList<Show>> {
                val config = PagedList.Config.Builder()
                    .setEnablePlaceholders(false)
                    .setInitialLoadSizeHint(5)
                    .setPageSize(5)
                    .build()

                return LivePagedListBuilder(localDataSource.getAllShows(), config).build()
            }

            override fun shouldFetch(data: PagedList<Show>?): Boolean =
                data == null || data.isEmpty()

            override fun createCall(): LiveData<ApiResponse<List<DataResponse>>> =
                remoteDataSource.getAllShows()

            override fun saveCallResult(data: List<DataResponse>) {
                val list = ArrayList<Show>()

                for (response in data) {
                    val show = Show(
                        response.id,
                        response.title,
                        response.genre,
                        response.description,
                        response.imagePath,
                        false
                    )
                    list.add(show)
                }
                localDataSource.insertShow(list)
            }
        }.asLiveData()

    override fun getFavoritedShow(): LiveData<PagedList<Show>> {
        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setInitialLoadSizeHint(5)
            .setPageSize(5)
            .build()

        return LivePagedListBuilder(localDataSource.getFavoritedShows(), config).build()
    }

    override fun getDetailShows(showId: String): LiveData<Resource<ShowDetail>> =
        object : NetworkBounds<ShowDetail, List<DataResponse>>(appExecutor) {
            override fun loadFromDB(): LiveData<ShowDetail> =
                localDataSource.getShowDetail(showId)

            override fun shouldFetch(data: ShowDetail?): Boolean =
                data?.details == null || data.details.description.isEmpty()

            override fun createCall(): LiveData<ApiResponse<List<DataResponse>>> =
                remoteDataSource.getAllShows()

            override fun saveCallResult(data: List<DataResponse>) {
                val list = ArrayList<Show>()

                for (response in data) {
                    val show = Show(
                        response.id,
                        response.title,
                        response.genre,
                        response.description,
                        response.imagePath,
                        false
                    )
                    list.add(show)
                }
                localDataSource.insertShow(list)
            }
        }.asLiveData()

    override fun setShowFavorited(show: Show, state: Boolean) =
        appExecutor.diskIO().execute { localDataSource.setFavoritedShow(show, state) }
}