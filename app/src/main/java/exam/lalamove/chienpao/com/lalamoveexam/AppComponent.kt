package exam.lalamove.chienpao.com.lalamoveexam

import android.content.Context
import dagger.Component
import exam.lalamove.chienpao.com.lalamoveexam.api.ApiModule
import exam.lalamove.chienpao.com.lalamoveexam.api.ApiService
import exam.lalamove.chienpao.com.lalamoveexam.okhttp.OkHttpModule
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, OkHttpModule::class, ApiModule::class])
interface AppComponent {
    fun inject(application: MainApplication)
    fun getContext(): Context
    fun getApiService(): ApiService
}