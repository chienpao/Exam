package exam.lalamove.chienpao.com.lalamoveexam.api

import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class ApiModule {

    companion object {
        const val BASE_URL = "https://mock-api-mobile.dev.lalamove.com"
    }

    @Provides
    @Singleton
    internal fun getLalamoveApiService(okHttpClient: OkHttpClient): ApiService {
        return Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .client(okHttpClient)
                .build()
                .create<ApiService>(ApiService::class.java)
    }
}