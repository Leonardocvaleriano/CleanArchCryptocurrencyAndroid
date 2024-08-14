package com.codeplace.cleanarchitecturecryptocurrencyandroidapp.di

import com.codeplace.cleanarchitecturecryptocurrencyandroidapp.data.remote.CoinPaprikaApi
import com.codeplace.cleanarchitecturecryptocurrencyandroidapp.data.remote.utils.HttpRoutes
import com.codeplace.cleanarchitecturecryptocurrencyandroidapp.data.repository.CoinRepositoryImpl
import com.codeplace.cleanarchitecturecryptocurrencyandroidapp.domain.repository.CoinRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideCoinPaprikaApi(): CoinPaprikaApi{
        return Retrofit.Builder()
            .baseUrl(HttpRoutes.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CoinPaprikaApi::class.java)
    }

    @Provides
    @Singleton
    fun provideCoinRepository(api: CoinPaprikaApi): CoinRepository {
        return CoinRepositoryImpl(api)
    }

}