package exam.lalamove.chienpao.com.lalamoveexam

import android.content.Context
import dagger.Component
import exam.lalamove.chienpao.com.lalamoveexam.api.LalamoveApiModule
import exam.lalamove.chienpao.com.lalamoveexam.okhttp.OkHttpModule
import javax.inject.Singleton

@Singleton
@Component(modules = [MainModule::class, OkHttpModule::class, LalamoveApiModule::class])
interface AppComponent {
    fun inject(application: MainApplication)
    fun getContext(): Context
}