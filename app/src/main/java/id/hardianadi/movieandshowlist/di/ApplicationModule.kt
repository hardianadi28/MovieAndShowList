package id.hardianadi.movieandshowlist.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import id.hardianadi.movieandshowlist.BuildConfig
import id.hardianadi.movieandshowlist.data.source.MovieShowRepository
import id.hardianadi.movieandshowlist.data.source.remote.RemoteDataSource
import id.hardianadi.movieandshowlist.network.NetworkService
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Qualifier
import javax.inject.Singleton

/**
 * @author hardiansyah (hardiansyah.adi@gmail.com)
 * @date 17/09/2020
 */
@Module
@InstallIn(ApplicationComponent::class)
class ApplicationModule {

    @BaseUrl
    @Provides
    fun provideBaseUrl() = "https://api.themoviedb.org/3/"

    @ApiKey
    @Provides
    fun provideApiKey() = BuildConfig.ApiKey

    @Provides
    @Singleton
    fun provideOkHttpClient(@ApiKey apiKey: String) = OkHttpClient.Builder()
        .addInterceptor(Interceptor { chain ->
            val ongoing = chain.request().newBuilder()
            ongoing.addHeader("Authorization", "Bearer $apiKey")
            chain.proceed(ongoing.build())
        })
        .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
        .connectTimeout(30, TimeUnit.SECONDS)
        .readTimeout(30, TimeUnit.SECONDS)
        .build()

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient, @BaseUrl BASE_URL: String): Retrofit =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()

    @Provides
    @Singleton
    fun provideNetworkService(retrofit: Retrofit): NetworkService =
        retrofit.create(NetworkService::class.java)

    @Provides
    @Singleton
    fun provideRemoteDataSource(networkService: NetworkService): RemoteDataSource =
        RemoteDataSource(networkService)

    @Provides
    @Singleton
    fun provideRepository(remoteDataSource: RemoteDataSource): MovieShowRepository =
        MovieShowRepository(remoteDataSource)
}

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class BaseUrl

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class ApiKey